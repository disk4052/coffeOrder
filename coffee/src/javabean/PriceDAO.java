package javabean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DBClose;
import db.DBConnection;
import dto.PriceDTO;

public class PriceDAO {
	public List<PriceDTO> getPriceList(){
		String sql = " SELECT * "
				+ " FROM PRICE";
		
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;
		
		List<PriceDTO> list = new ArrayList<PriceDTO>();
		
		try {
			conn = DBConnection.getConnection();
			psmt = conn.prepareStatement(sql);
			
			rs = psmt.executeQuery();
			
			while(rs.next()) {
				PriceDTO dto = new PriceDTO(rs.getString(1),
										rs.getInt(2),
										rs.getInt(3),
										rs.getInt(4)
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
