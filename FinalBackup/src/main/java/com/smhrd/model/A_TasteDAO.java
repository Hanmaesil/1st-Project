package com.smhrd.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class A_TasteDAO {
	
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
			//초성에 맞는 단어 가져오기
			public ArrayList<String> taste(int sort, String taste) {
				connect();
				ArrayList<String> list = new ArrayList<String>();
				
				
				
				try {
					sql = "select * from taste where sort = ?";
					psmt = conn.prepareStatement(sql);
					
					
					psmt.setInt(1, sort);
					
					rs = psmt.executeQuery();
					
					while(rs.next()) {
						
						String tas = rs.getString(taste); //수정
						
						list.add(tas);
						
						
					}
					
					
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					close();
				}
				
				
				return list;
			}
	
	
	
	
}
