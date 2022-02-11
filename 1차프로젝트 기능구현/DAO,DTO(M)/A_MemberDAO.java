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
	
	
	
	//������ ���� �޼ҵ�
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
	
	// DB��������
		// �������� �ݾ��ش�!
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
		
		//ȸ������
		public int memberJoin(A_MemberDTO a_MemberDTO) {
			connect(); //db����
			
			try {
				sql = "insert into member_test values(?,?,?,?,?,?)";	
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
		
		//�α���
		
		
		public String memberLogin(String id, String pw) {
			connect();
			
			
			
			try {
				sql = "select nick from member_test where id = ? and pw = ?";
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
		
		
		//ȸ������ ����
		
		public int memberUdate(String re_pw, String re_nick, String re_phone, String nick) {
			connect();
			
			try {
				sql = "update member_test set pw = ?, nick = ?, phone = ? where nick = ?";
				psmt = conn.prepareStatement(sql);
				
				psmt.setString(1, re_pw);
				psmt.setString(2, re_nick);
				psmt.setString(3, re_phone);
				psmt.setString(4, nick);
				
				
				cnt = psmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close();
			}
			
			
			return cnt;
		}
		
		//ȸ��Ż��
		
		public int memberUnregister(String id, String pw) {
			connect();
			
			try {
				sql = "delete from member_test where id = ? and pw = ?";
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
		

		
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		
//		// ȸ�����Ա��
//		public int memberJoin(MemberDTO member) {
//			connect();
//
//			sql = "insert into web_member values(?,?,?,?)";
//			try {
//				psmt = conn.prepareStatement(sql);
//				psmt.setString(1, member.getM_email());
//				psmt.setString(2, member.getM_pw());
//				psmt.setString(3, member.getM_tel());
//				psmt.setString(4, member.getM_address());
//
//			cnt = psmt.executeUpdate();
//
//			} catch (SQLException e) { // ����ó���� �߻��ؼ� catch���� �ɸ��� close���� ���� �ʱ� ������ finally�� �־ ������ ���������� �����Ѵ�.
//				//����ó�� �߻��Ǵ� ���!
//				//1. SQL������ �߸� �ۼ��Ǿ��� ���
//				//2. psmt��ü�� �߸��� �ε��� ���� �ۼ����� ���
//				//3. ���̺��� ���� ���
//				e.printStackTrace();
//			}
//			finally { //try -catch ���� ����� �� �ݵ�� �����ϱ� ���� finally
//			close();
//			}
//			
//			return cnt; //ȸ�������� �Ǹ� 0�� �ƴѰ��� ������ �ȴ�.
//		}
//		
//		//�α��� ���
//		
//		public String login(String email, String pw) {
//			connect();
//			String result = null;
//			
//			
//			try {
//				
//				sql = "select * from web_member where m_email = ? and m_pw = ?";
//				psmt = conn.prepareStatement(sql);
//				psmt.setString(1, email);
//				psmt.setString(2, pw);
//				
//				rs = psmt.executeQuery();
//				
//				if(rs.next()) {
//					
//				}else {
//					
//				}
//				
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			
//			
//			
//			return result;
//		}
//
//		
//
//		public MemberDTO memberLogin(String email, String pw) {
//			connect();
//			
//			
//			MemberDTO member = null;
//			
//			
//			try {
//				sql = "select m_tel, m_address from web_member where m_email = ? and m_pw = ?";
//				psmt = conn.prepareStatement(sql);
//				
//				psmt.setString(1, email);
//				psmt.setString(2, pw);
//				
//				rs = psmt.executeQuery();
//				
//				if(rs.next()) { //ȸ�����Ե� ������ db�� �ִ°��
//					member = new MemberDTO(email, null, rs.getString(1), rs.getString(2)); //1,2���� ���� �̸�(tel,address)
//				}
//				
//			} catch (SQLException e) {
//				e.printStackTrace();
//			} finally {
//				close();
//			}
//			
//			
//			
//			
//			return member;
//		}
//
//		public int memberUpdate(MemberDTO memberDTO) {
//			connect();
//			MemberDTO member = null;
//			
//			
//			try {
//				sql = "update web_member set m_pw = ?, m_tel= ?, m_address = ? where m_email = ?";
//				psmt = conn.prepareStatement(sql);
//				
//				psmt.setString(1, memberDTO.getM_pw());
//				psmt.setString(2, memberDTO.getM_tel());
//				psmt.setString(3, memberDTO.getM_address());
//				psmt.setString(4, memberDTO.getM_email());
//				
//				cnt = psmt.executeUpdate();
//				
//				
//				
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}finally {
//				close();
//			}
//			
//			
//			
//			
//			return cnt;
//		}
//		//�����ڸ�忡�� ȸ�� ���� ����
//		public ArrayList<MemberDTO> memberselectAll() {
//			ArrayList<MemberDTO> list = new ArrayList<MemberDTO>(); 
//			connect();
//			
//			
//			try {
//				sql = "select m_email, m_tel, m_address from web_member";
//				psmt = conn.prepareStatement(sql);
//				
//				
//				rs = psmt.executeQuery();
//				
//				while(rs.next()) {
//					//rs��ü �� ����� ȸ���������� ���� -> Member��ü ���� -> list�� ����
//					String email = rs.getString(1);
//					String tel = rs.getString(2);
//					String address = rs.getString(3);
//					
//					if(!email.equals("admin")) { //������ ������ �����ϰ� ����
//						MemberDTO member = new MemberDTO(email, null, tel, address);
//						list.add(member);
//					}
//					
////					MemberDTO member = new MemberDTO(email, null, tel, address);
////					list.add(member);
//					//�̷������ε� ����
//					//list.add(new MemberDTO(email, null, tel, address));
//				}
//				
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			finally {
//				close();
//			}
//			
//			
//			
//			
//			return list;
//		}

	
	
	
	
	
	
	
	
	
	
	
	

