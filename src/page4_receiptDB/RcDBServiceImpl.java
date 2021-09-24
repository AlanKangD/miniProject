package page4_receiptDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dto.DBCommon;
import dto.ReceiptDTO;

public class RcDBServiceImpl implements RcDBService{

	PreparedStatement ps;
	ResultSet rs;	
	
	@Override
	public ReceiptDTO takeResult() {
		String sql = "select * from burgerking";
		ReceiptDTO dto = null;
//		try {
//			ps = DBCommon.con.prepareStatement(sql);
//			rs = ps.executeQuery();
//			
//			if(rs.next()) {
//				dto = new ReceiptDTO();
//				dto.setOrderNum(rs.getInt("orderNum"));
//				dto.setMenu(rs.getString("menu"));
//				dto.setPrice(rs.getInt("price"));
//				dto.setCard(rs.getInt("card"));
//				dto.setTakeAway(rs.getInt("takeAway"));
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
		return dto;
	}
	
}
