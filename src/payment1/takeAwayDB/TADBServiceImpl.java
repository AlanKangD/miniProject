package payment1.takeAwayDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import resultDTO.DBCommon;

public class TADBServiceImpl implements TADBService{ // DB에 매장(1) or 포장(2)으로 값을 설정

	PreparedStatement ps;
	ResultSet rs;	
	
	@Override
	public int choiceTA(int choice) {
		System.out.println("포장여부를 선택합니다." + choice);
		String sql = "insert into burger(TakeAway) values (?)"; 
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