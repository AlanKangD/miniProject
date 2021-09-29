package payment4.receiptDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import OrderDBcommon.OrderDBCommon;
import resultDTO.ReceiptDTO;

public class RcDBServiceImpl implements RcDBService{ // 주문번호,가격,주문메뉴,포장여부,카드를
													 // 테이블에서 불러와 ReceiptDTO클래스에 값 설정후 return
	PreparedStatement ps;
	ResultSet rs;	
	
	@Override
	public ReceiptDTO takeResult() {
		String sql = "select sales_code from BURGER_ORDER";
		ReceiptDTO dto = null;
		int sales_count = 0;
		try {
			ps = OrderDBCommon.con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				dto = new ReceiptDTO();
				sales_count = rs.getInt("sales_code");
				dto.setOrderNum(sales_count);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}
	
}
