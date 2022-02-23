package com.smhrd.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;



public class A_MemberDAO {
	
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
		
		//회원가입
		public int memberJoin(A_MemberDTO a_MemberDTO) {
			connect(); //db연결
			
			try {
				sql = "insert into member values(?,?,?,?,?,?)";	
				psmt = conn.prepareStatement(sql);
				
				psmt.setString(1, a_MemberDTO.getId());
				psmt.setString(2, a_MemberDTO.getPw());
				psmt.setString(3, a_MemberDTO.getNick());
				psmt.setString(4, a_MemberDTO.getPhone());
				psmt.setString(5, a_MemberDTO.getBirth());
				psmt.setInt(6, a_MemberDTO.getSex());
			
				cnt = psmt.executeUpdate();
				
			}
				catch (SQLException e) { 
					e.printStackTrace();
				}
				finally { 
				close();
				}
				
				return cnt;
			}
		
		//로그인
		
		
		public String memberLogin(String id, String pw) {
			connect();
			
			
			
			try {
				sql = "select nick from member where id = ? and pw = ?";
				psmt = conn.prepareStatement(sql);
				
				psmt.setString(1, id);
				psmt.setString(2, pw);
				
				rs = psmt.executeQuery();
				
				if(rs.next()) {
					nick = rs.getString(1);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close();
			}
			
			return nick;
		}
		
		
		//회원정보 수정
		
		public int memberUdate(String re_pw, String re_nick, String re_phone, String nick) {
			connect();
			
			try {
				sql = "update member set pw = ?, phone = ? where nick = ?";
				psmt = conn.prepareStatement(sql);
				
				psmt.setString(1, re_pw);
				psmt.setString(2, re_phone);
				psmt.setString(3, nick);
				
				
				cnt = psmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close();
			}
			
			
			return cnt;
		}
		
		//회원탈퇴
		
		public int memberUnregister(String id, String pw, String nick) {
			connect();
			
			try {
				sql = "delete from board where nick = ?";	
				psmt = conn.prepareStatement(sql);
				
				psmt.setString(1, nick);
				
				cnt = psmt.executeUpdate();
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			
			try {
				sql = "delete from reply where nick = ?";	
				psmt = conn.prepareStatement(sql);
				
				psmt.setString(1, nick);
				
				cnt = psmt.executeUpdate();
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			
			
			
			
			try {
				sql = "delete from list where nick = ?";	
				psmt = conn.prepareStatement(sql);
				
				psmt.setString(1, nick);
				
				cnt = psmt.executeUpdate();
				
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			
			
			try {
				sql = "delete from member where id = ? and pw = ?";
				psmt= conn.prepareStatement(sql);
				
				psmt.setString(1, id);
				psmt.setString(2, pw);
				
				cnt = psmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close();
			}
			
			
			
			
			
			return cnt;
		}
			
		}
		

		

