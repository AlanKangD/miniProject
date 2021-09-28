package OrderDBcommon;

import java.sql.Connection;
import java.sql.DriverManager;

public class OrderDBCommon {
	public static Connection con;
	
	public static void setDBConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "java", "1234");
			System.out.println("orderDB 연결완료 : " + con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
