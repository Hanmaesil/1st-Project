package model;

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

		// 맛 선택

		String taste1 = taste[0];
//				String taste2 = taste[1];
//				String taste3 = taste[2];
//				String taste4 = taste[3];
//				String taste5 = taste[4];

		// 향 선택

		String flavor1 = flavor[0];
//				String flavor2 = flavor[1]; 
//				String flavor3 = flavor[2]; 
//				String flavor4 = flavor[3]; 
//				String flavor5 = flavor[4]; 

		try {
			if (option.equals("or")) {

				sql = "select dr_id, dr_flavor, dr_taste, dr_abv, dr_des, dr_img from test2 where sort = ?"
						+ "and dr_taste like ? or dr_flavor like ?";

				psmt = conn.prepareStatement(sql);

				psmt.setInt(1, sort);
				psmt.setString(2, "%" + taste1 + "%");
				psmt.setString(3, "%" + flavor1 + "%");

				rs = psmt.executeQuery();

				while (rs.next()) {

					String dr_id = rs.getString(1);
					String dr_flavor = rs.getString(2);
					String dr_taste = rs.getString(3);
					int dr_abv = rs.getInt(4);
					String dr_des = rs.getString(5);
					String dr_img = rs.getString(6);

					A_SearchDTO dtolist = new A_SearchDTO(sort, dr_id, dr_flavor, dr_taste, dr_abv, dr_des, dr_img);
					list.add(dtolist);

				}

			} else if (option.equals("and")) {

				sql = "select dr_id, dr_flavor, dr_taste, dr_abv, dr_des, dr_img from test2 where sort = ?"
						+ "and dr_taste like ? and dr_flavor like ?";

				psmt = conn.prepareStatement(sql);

				psmt.setInt(1, sort);
				psmt.setString(2, "%" + taste1 + "%");
				psmt.setString(3, "%" + flavor1 + "%");

				rs = psmt.executeQuery();

				while (rs.next()) {

					String dr_id = rs.getString(1);
					String dr_flavor = rs.getString(2);
					String dr_taste = rs.getString(3);
					int dr_abv = rs.getInt(4);
					String dr_des = rs.getString(5);
					String dr_img = rs.getString(6);

					A_SearchDTO dtolist = new A_SearchDTO(sort, dr_id, dr_flavor, dr_taste, dr_abv, dr_des, dr_img);
					list.add(dtolist);

				}

			}

			/*
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
			 */

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}

		return list;
	}

}
