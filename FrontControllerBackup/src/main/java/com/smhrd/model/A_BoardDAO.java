package com.smhrd.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class A_BoardDAO {
	
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
		//글작성
		public int Input(A_BoardDTO a_BoardDTO) {
			connect();
			
			try {
				sql = "insert into board values(board_num_seq.nextval,?,?,?,sysdate)";
				psmt = conn.prepareStatement(sql);
				
				psmt.setString(1, a_BoardDTO.getNick());
				psmt.setString(2, a_BoardDTO.getBo_title());
				psmt.setString(3, a_BoardDTO.getBo_content());
				
				cnt = psmt.executeUpdate();
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close();
			}
			
			return cnt;
		}
		
		//게시판에 글 목록 출력
		public ArrayList<A_BoardDTO> Output(){
			connect();
			
			ArrayList<A_BoardDTO> list = new ArrayList<A_BoardDTO>();
			
			
			try {
				sql = "select bo_num, nick, bo_title, bo_date from board";
				psmt = conn.prepareStatement(sql);
				
				rs = psmt.executeQuery();
				
				while(rs.next()) {
					int b_num = rs.getInt(1);
					String b_nick = rs.getString(2);
					String b_title = rs.getString(3);
					String b_date = rs.getString(4);
					
					A_BoardDTO board = new A_BoardDTO(b_num,b_nick,b_title,null,b_date);
					list.add(board);
					
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close();
			}
			
			
			return list;
			
		}
		
		
		//게시글에 content 출력!
		public ArrayList<A_BoardDTO> content(int num){
			connect();
			
			ArrayList<A_BoardDTO> contentlist = new ArrayList<A_BoardDTO>();
			
			
			
			try {
				sql = "select nick, bo_title, bo_content, bo_date from board where bo_num = ?";
				psmt = conn.prepareStatement(sql);
			
				psmt.setInt(1, num);
				
				rs = psmt.executeQuery();
				
				while(rs.next()) {
					
					String b_nick = rs.getString(1);
					String b_title = rs.getString(2);
					String b_content = rs.getString(3);
					String b_date = rs.getString(4);
					
					A_BoardDTO view = new A_BoardDTO(num, b_nick, b_title, b_content, b_date);
					contentlist.add(view);
					
				}
			
			
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close();
			}
			
			
			
			return contentlist;
			
		}
		//게시판 글 수정
		public int Update(int bo_num, String bo_title, String bo_content) {
			connect();
			
			try {
				sql = "update board set bo_title = ?, bo_content = ? where bo_num = ?";
				psmt = conn.prepareStatement(sql);
				
				psmt.setString(1, bo_title);
				psmt.setString(2, bo_content);
				psmt.setInt(3, bo_num);
				
				cnt = psmt.executeUpdate();
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close();
			}
			
			return cnt;
		}
		//글삭제
		public int Delete(int bo_num, String nick2) {
			connect();
			
			
			
			try {
				sql = "delete from reply where bo_num = ?";
				psmt = conn.prepareStatement(sql);
				
				psmt.setInt(1, bo_num);
				
				cnt = psmt.executeUpdate();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			
			
			try {
				sql = "delete from board where bo_num = ? and nick = ?";
				
				psmt = conn.prepareStatement(sql);
				
				psmt.setInt(1, bo_num);
				psmt.setString(2, nick2);
				
				cnt = psmt.executeUpdate();
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close();
			}
			
			
			
			
			return cnt;
		}
	
	
}
