package payment4.receiptDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import resultDTO.DBCommon;
import resultDTO.ReceiptDTO;

public class RcDBServiceImpl implements RcDBService{ // 주문번호,가격,주문메뉴,포장여부,카드를
													 // 테이블에서 불러와 ReceiptDTO클래스에 값 설정후 return
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
