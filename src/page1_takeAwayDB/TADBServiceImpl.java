package page1_takeAwayDB;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dto.DBCommon;

public class TADBServiceImpl implements TADBService{

	PreparedStatement ps;
	ResultSet rs;	
	
	@Override
	public int choiceTA(int choice) {
		System.out.println("포장여부를 선택합니다." + choice);
		String sql = "insert into burger(TakeAway) values (?)"; // 나중에 값을 채우겠다.
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
