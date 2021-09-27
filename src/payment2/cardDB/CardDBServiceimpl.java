package payment2.cardDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import resultDTO.ReceiptDTO;

public class CardDBServiceimpl implements CardDBService{ // DB에 신용카드(1) or 카카오페이(2)로 값을  설정 

	PreparedStatement ps;
	ResultSet rs;	
	
	@Override
	public int ChoiceCard(int choice) {
		System.out.println("사용할 카드를 선택합니다." + choice);
		String sql = "insert into burger(card) values (?)";
		int result = 1 ;
//		try {
//			ps = DBCommon.con.prepareStatement(sql);
//			ps.setInt(1, choice);
//			result = ps.executeUpdate();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		return result;
	}

}
