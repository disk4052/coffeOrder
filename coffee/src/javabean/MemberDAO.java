package javabean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DBClose;
import db.DBConnection;
import dto.MemberDTO;

// DB <-> Java
public class MemberDAO {

	public Boolean pwCheck(String id, String pw) {
		
		String sql = " SELECT PWD "
				+ " FROM CAFEMEMBER"
				+ " WHERE ID = '" + id + "'";
		
		Connection conn = DBConnection.getConnection();
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		boolean check = false;
		
		System.out.println("sql :" + sql);
		
		try {
			psmt = conn.prepareStatement(sql);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) { // �����Ͱ� �ִ� ���	
					if( pw.equals(rs.getString("pwd"))) {
						check = true;
					}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}
		
		return check;
		
	}
	
	public boolean getId(String id) {
		String sql = " SELECT ID "
				+ " FROM CAFEMEMBER"
				+ " WHERE ID = ? ";
		
		Connection conn = null;			// DB Connection �ϱ� ���� �ʿ�
		PreparedStatement psmt = null;	// SQL �� �Է�
		ResultSet rs = null;			// �������� ���� ����� �������� ����
		
		boolean findid = false;
		
		System.out.println("sql: " + sql);
		
		
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, id);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				findid = true;
			}
			else {
				findid = false;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}
		
		return findid;
	}
	
	public void addMember(MemberDTO dto) {
		// db�� �߰�
		String sql = " INSERT INTO CAFEMEMBER(ID, PWD, NAME, AGE, EMAIL, AUTH) "
				+ " VALUES('" + dto.getId() + "', '" + dto.getPwd() + "', '" + dto.getName() + "', " + dto.getAge() + ", '" + dto.getEmail() + "', " + dto.getAuth() + ")";
		
		Connection conn = DBConnection.getConnection();
		Statement stmt = null;
		
		System.out.println("sql:" + sql);
		
		try {
			stmt = conn.createStatement();
			
			stmt.executeUpdate(sql);
			
			System.out.println("���������� �߰��Ǿ����ϴ�.");
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				if(stmt != null) {
					stmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
