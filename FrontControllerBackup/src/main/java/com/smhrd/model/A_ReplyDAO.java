package com.smhrd.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class A_ReplyDAO {
	
	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	private int cnt;
	private String sql;
	private String nick;
	
	
	
	
	//연결을 위한 메소드
	public void connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String user = "campus_f_4_0115";
			String password = "smhrd4";
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	// DB연결종료
		// 역순으로 닫아준다!
		public void close() {
			try {
				if (rs != null) {
					rs.close();
				}
				if (psmt != null) {
					psmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
		
		//댓글 db에 저장
		
		public int Input(A_ReplyDTO a_ReplyDTO) {
			connect();
			
			
			
			try {
				sql = "insert into reply values(reply_reorder_seq.nextval, ?,?,?, sysdate, reply_index_seq.nextval)";
				psmt = conn.prepareStatement(sql);
				
				psmt.setInt(1, a_ReplyDTO.getBo_num());
				psmt.setString(2, a_ReplyDTO.getNick());
				psmt.setString(3, a_ReplyDTO.getRe_coment());
				
				cnt = psmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close();
			}
			
			
			return cnt;
		}
		//댓글출력
		public ArrayList<A_ReplyDTO> Output(int num){
			connect();
			ArrayList<A_ReplyDTO> list = new ArrayList<A_ReplyDTO>();
			
			
			
			try {
				sql = "select nick, re_comment, regdate from reply where bo_num = ?";
				psmt = conn.prepareStatement(sql);
				
				psmt.setInt(1, num);
				
				rs = psmt.executeQuery();
				
				while(rs.next()) {
					String nick = rs.getString(1);
					String re_comment = rs.getString(2);
					String regdate = rs.getString(3);
					
					A_ReplyDTO reply = new A_ReplyDTO(0, num, nick, re_comment, regdate, 0);
					list.add(reply);
				}
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close();
			}
			
			
			return list;
			
		}
		
		
	
	
	
	
	
}
