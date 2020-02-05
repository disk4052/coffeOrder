package javabean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DBClose;
import db.DBConnection;
import dto.OrderDTO;

public class OrderDAO {
	public void addOrder(OrderDTO dto) {
		// db에 추가
		String sql = " INSERT INTO CAFEORDER(SEQ, BEVERAGE, SYRUP, CUPSIZE, ADDSHOT, ADDCREAM, CUP, PRICE, WDATE, ID) "
				+ " VALUES(SEQ_BBS.NEXTVAL, '" + dto.getBeverage() + "', '" + dto.getSyrup() + "', '" + dto.getCupSize() + "', '"
				+ dto.getAddShot() + "', '" + dto.getAddCream() + "', " + dto.getCup() + ", " + dto.getPrice() + ", SYSDATE, '" + dto.getId() + "') ";
		
		Connection conn = DBConnection.getConnection();
		Statement stmt = null;
		
		System.out.println("sql:" + sql);
		
		try {
			stmt = conn.createStatement();
			
			stmt.executeUpdate(sql);
			
			System.out.println("성공적으로 추가되었습니다.");
			
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
	
	public int priceSearch(String beverage, String size_) {
	
		
		String sql = " SELECT " + size_
				+ " FROM PRICE"
				+ " WHERE BEVERAGE = '" + beverage + "' ";
		
		Connection conn = DBConnection.getConnection();
		PreparedStatement psmt = null;
		
		ResultSet rs = null;
		int price = 0;
		
		System.out.println("sql :" + sql);
		
		try {
			psmt = conn.prepareStatement(sql);
			
			rs = psmt.executeQuery();
			
			if(rs.next()) { // 데이터가 있는 경우
					price = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}
		
		return price;
		
	}
	
	public List<OrderDTO> getOrderList(String id){
		String sql = " SELECT SEQ, BEVERAGE, SYRUP, CUPSIZE, ADDSHOT, ADDCREAM, CUP, PRICE, TO_CHAR(WDATE, 'YYYY-MM-DD HH24:MI'), ID "
				+ " FROM CAFEORDER WHERE ID = '" + id + "' ORDER BY WDATE DESC";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		List<OrderDTO> list = new ArrayList<OrderDTO>();
		
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				OrderDTO dto = new OrderDTO(rs.getInt(1),
										rs.getString(2),
										rs.getString(3),
										rs.getString(4),
										rs.getString(5),
										rs.getString(6),
										rs.getInt(7),
										rs.getInt(8),
										rs.getString(9),
										rs.getString(10)
										);
				list.add(dto);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBClose.close(psmt, conn, rs);
		}
		return list;
	}
	
}
