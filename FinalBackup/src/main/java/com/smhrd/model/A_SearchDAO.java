package com.smhrd.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class A_SearchDAO {

	private Connection conn;
	private PreparedStatement psmt;
	private ResultSet rs;
	private int cnt;
	private String sql;
	private String nick;

	// 연결을 위한 메소드
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

	// 술 출력!!!!!

	public ArrayList<A_SearchDTO> result(int sort, String[] taste, String[] flavor, String option) {
		connect();
		ArrayList<A_SearchDTO> list = new ArrayList<A_SearchDTO>();

		/*
		 * sql =
		 * "select dr_id, dr_flavor, dr_taste, dr_abv, dr_des, dr_img, num from test3 where"
		 * ; for (int i = 0; i < taste.length; i++) { sql +=
		 * "(sort = ? and dr_taste like '%"; sql += taste[i]; sql += "%')"; sql += "or";
		 * } for (int i = 0; i < flavor.length; i++) { sql +=
		 * "(sort = ? and dr_taste like '%"; sql += flavor[i]; sql += "%')"; if (i !=
		 * flavor.length) { sql += "or"; }
		 * 
		 * }
		 */
		// 값 가져오기
		
		
		if (option.equals("or")) {

			sql = "select dr_id, dr_flavor, dr_taste, dr_abv, dr_des, dr_img, num from test3 where";
			for (int i = 0; i < taste.length; i++) {
				sql += "(sort = ? and dr_taste like '%";
				sql += taste[i];
				sql += "%')";
				sql += "or";
			}
			for (int i = 0; i < flavor.length; i++) {
				sql += "(sort = ? and dr_flavor like '%";
				sql += flavor[i];
				sql += "%')";
				if (i != flavor.length-1) {
					sql += "or";
				}

			}
			System.out.println(sql);
			
			//------------------------
			try {
				psmt = conn.prepareStatement(sql);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			//------------------------
			for (int i = 0; i < taste.length; i++) {
				try {
					psmt.setInt(i + 1, sort);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			for (int i = 0; i < flavor.length; i++) {
				try {
					psmt.setInt(taste.length + (i + 1), sort);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			try {
				 rs = psmt.executeQuery();
				while (rs.next()) {

					String dr_id = rs.getString(1);
					String dr_flavor = rs.getString(2);
					String dr_taste = rs.getString(3);
					int dr_abv = rs.getInt(4);
					String dr_des = rs.getString(5);
					String dr_img = rs.getString(6);
					int num = rs.getInt(7);

					A_SearchDTO dtolist = new A_SearchDTO(sort, dr_id, dr_flavor, dr_taste, dr_abv, dr_des, dr_img,
							num);
					list.add(dtolist);

				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				close();
			}

		} else if (option.equals("and")) {

			sql = "select dr_id, dr_flavor, dr_taste, dr_abv, dr_des, dr_img, num from test3 where";
			for (int i = 0; i < taste.length; i++) {
				sql += "(sort = ? and dr_taste like '%";
				sql += taste[i];
				sql += "%')";
				sql += "and";
			}
			for (int i = 0; i < flavor.length; i++) {
				sql += "(sort = ? and dr_flavor like '%";
				sql += flavor[i];
				sql += "%')";
				if (i != flavor.length -1) {
					sql += "and";
				}

			}
			
			System.out.println(sql);
			
			//------------------------
			try {
				psmt = conn.prepareStatement(sql);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			//------------------------

			for (int i = 0; i < taste.length; i++) {
				try {
					psmt.setInt(i + 1, sort);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			for (int i = 0; i < flavor.length; i++) {
				try {
					psmt.setInt(taste.length + (i + 1), sort);
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			
			
			try {
				 rs = psmt.executeQuery();
				while (rs.next()) {

					String dr_id = rs.getString(1);
					String dr_flavor = rs.getString(2);
					String dr_taste = rs.getString(3);
					int dr_abv = rs.getInt(4);
					String dr_des = rs.getString(5);
					String dr_img = rs.getString(6);
					int num = rs.getInt(7);

					A_SearchDTO dtolist = new A_SearchDTO(sort, dr_id, dr_flavor, dr_taste, dr_abv, dr_des, dr_img,
							num);
					list.add(dtolist);

				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				close();
			}

		}

		/*
		 * // 맛 선택
		 * 
		 * String taste1 = taste[0]; String taste2 = taste[1]; String taste3 = taste[2];
		 * 
		 * 
		 * // 향 선택
		 * 
		 * String flavor1 = flavor[0]; String flavor2 = flavor[1]; String flavor3 =
		 * flavor[2];
		 * 
		 * 
		 * try { if (option.equals("or")) {
		 * 
		 * sql =
		 * "select dr_id, dr_flavor, dr_taste, dr_abv, dr_des, dr_img, num from test3 where"
		 * + " (sort = ? and dr_taste like ?) or (sort = ? and dr_flavor like ?)";
		 * 
		 * psmt = conn.prepareStatement(sql);
		 * 
		 * psmt.setInt(1, sort); psmt.setString(2, "%" + taste1 + "%"); psmt.setInt(3,
		 * sort); psmt.setString(4, "%" + flavor1 + "%");
		 * 
		 * rs = psmt.executeQuery();
		 * 
		 * while (rs.next()) {
		 * 
		 * String dr_id = rs.getString(1); String dr_flavor = rs.getString(2); String
		 * dr_taste = rs.getString(3); int dr_abv = rs.getInt(4); String dr_des =
		 * rs.getString(5); String dr_img = rs.getString(6); int num = rs.getInt(7);
		 * 
		 * A_SearchDTO dtolist = new A_SearchDTO(sort, dr_id, dr_flavor, dr_taste,
		 * dr_abv, dr_des, dr_img, num); list.add(dtolist);
		 * 
		 * }
		 * 
		 * } else if (option.equals("and")) {
		 * 
		 * sql =
		 * "select dr_id, dr_flavor, dr_taste, dr_abv, dr_des, dr_img, num from test3 where (sort = ?"
		 * + "and dr_taste like ?) and (sort =? and dr_flavor like ?)";
		 * 
		 * psmt = conn.prepareStatement(sql);
		 * 
		 * psmt.setInt(1, sort); psmt.setString(2, "%" + taste1 + "%"); psmt.setInt(3,
		 * sort); psmt.setString(4, "%" + flavor1 + "%");
		 * 
		 * rs = psmt.executeQuery();
		 * 
		 * while (rs.next()) {
		 * 
		 * String dr_id = rs.getString(1); String dr_flavor = rs.getString(2); String
		 * dr_taste = rs.getString(3); int dr_abv = rs.getInt(4); String dr_des =
		 * rs.getString(5); String dr_img = rs.getString(6); int num = rs.getInt(7);
		 * 
		 * A_SearchDTO dtolist = new A_SearchDTO(sort, dr_id, dr_flavor, dr_taste,
		 * dr_abv, dr_des, dr_img, num); list.add(dtolist);
		 * 
		 * }
		 * 
		 * }
		 * 
		 * 
		 * sql =
		 * "select dr_id, dr_flavor, dr_taste, dr_abv, dr_des, dr_img from test2 where sort = ?"
		 * + "and dr_taste like ?"; psmt = conn.prepareStatement(sql);
		 * 
		 * psmt.setInt(1, sort); psmt.setString(2, "%" + taste1 + "%"); //
		 * psmt.setString(3, taste2); // psmt.setString(4, taste3); // psmt.setString(5,
		 * taste4); // psmt.setString(6, taste5);
		 * 
		 * rs = psmt.executeQuery();
		 * 
		 * while(rs.next()) {
		 * 
		 * String dr_id = rs.getString(1); String dr_flavor = rs.getString(2); String
		 * dr_taste = rs.getString(3); int dr_abv = rs.getInt(4); String dr_des =
		 * rs.getString(5); String dr_img = rs.getString(6);
		 * 
		 * A_SearchDTO dtolist = new A_SearchDTO(sort, dr_id, dr_flavor, dr_taste,
		 * dr_abv, dr_des, dr_img); list.add(dtolist);
		 * 
		 * }
		 * 
		 * 
		 * } catch (SQLException e) { e.printStackTrace(); } finally { close(); }
		 */

		return list;
	}

}
