package dto;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBCommon {
	public static Connection con;			
	
	//public static void setDBConnection()
	static{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(  
					"jdbc:oracle:thin:@localhost:1521:xe","dsjin123","1234"); 
			System.out.println("연결 되었습니다." + con);
		} catch (Exception e) {				  			
			e.printStackTrace();
		}
	}
}
