package OrderDBService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import OrderDBcommon.OrderDBCommon;
import Orderdto.BeverageOrderDTO;
import Orderdto.BurgerOrderDTO;
import Orderdto.SideOrderDTO;
import Orderdto.TotalDTO;
import javafx.scene.Parent;

public class OrderDBServiceImpl implements OrderDBService{
	Parent root;
	PreparedStatement ps;
	PreparedStatement ps2;
	ResultSet rs;
	ResultSet rs2;
	BurgerOrderDTO burgerDTO;
	SideOrderDTO sideDTO;
	BeverageOrderDTO beverageDTO;
	
	
	public void setRoot(Parent root) {
		this.root = root;
	}
	
	public int TotalOrderDTO(BurgerOrderDTO burgerDTO, SideOrderDTO sideDTO, BeverageOrderDTO beverageDTO) {
		String sql = 
				"insert into burger_order(sales_code, burger_1, burger_2, burger_3, burger_4, "
				+ "side_1, side_2, side_3, side_4, "
				+ "beverage_1, beverage_2, beverage_3, beverage_4) "
				+ "values(sales_seq.nextval, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//		String sql2 = 
//				"select sales_code from burger_order";
		
//		int sales_code_count = 0;
		int result = 0;
		
		try {
			ps = OrderDBCommon.con.prepareStatement(sql);
//			ps2 = OrderDBCommon.con.prepareStatement(sql2);
//			rs2 = ps2.executeQuery();
//			while(rs2.next()) {
//				sales_code_count = rs2.getInt("sales_code");
//			}
//			ps.setInt(1, sales_code_count + 1);
			ps.setInt(1, burgerDTO.getBurger_1());
			ps.setInt(2, burgerDTO.getBurger_2());
			ps.setInt(3, burgerDTO.getBurger_3());
			ps.setInt(4, burgerDTO.getBurger_4());
			ps.setInt(5, sideDTO.getSide_1());
			ps.setInt(6, sideDTO.getSide_2());
			ps.setInt(7, sideDTO.getSide_3());
			ps.setInt(8, sideDTO.getSide_4());
			ps.setInt(9, beverageDTO.getBeverage_1());
			ps.setInt(10, beverageDTO.getBeverage_2());
			ps.setInt(11, beverageDTO.getBeverage_3());
			ps.setInt(12, beverageDTO.getBeverage_4());
			result = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int saveBurgerDTO(BurgerOrderDTO burgerDTO) {
//		System.out.println(burgerDTO.getBurger_1());
//		System.out.println(burgerDTO.getBurger_2());
//		System.out.println(burgerDTO.getBurger_3());
//		System.out.println(burgerDTO.getBurger_4());
		String sql = "insert into burger_order(sales_code, burger_1, burger_2, burger_3, burger_4) values(sales_seq.nextval, ?, ?, ?, ?)";
		int result = 0;
		
		try {
			ps = OrderDBCommon.con.prepareStatement(sql);
			ps.setInt(1, burgerDTO.getBurger_1());
			ps.setInt(2, burgerDTO.getBurger_2());
			ps.setInt(3, burgerDTO.getBurger_3());
			ps.setInt(4, burgerDTO.getBurger_4());
			result = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public int saveSideDTO(SideOrderDTO sideDTO) {
		String sql = 
				"insert into burger_order(side_1, side_2, side_3, side_4) values(?, ?, ?, ?)";
		int result = 0;
		
		try {
			ps = OrderDBCommon.con.prepareStatement(sql);
			ps.setInt(1, sideDTO.getSide_1());
			ps.setInt(2, sideDTO.getSide_2());
			ps.setInt(3, sideDTO.getSide_3());
			ps.setInt(4, sideDTO.getSide_4());
			result = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public int saveBeverageDTO(BeverageOrderDTO beverageDTO) {
		String sql = 
				"insert into burger_order(beverage_1, beverage_2, beverage_3, beverage_4) values(?, ?, ?, ?)";
		int result = 0;
		
		try {
			ps = OrderDBCommon.con.prepareStatement(sql);
			ps.setInt(1, beverageDTO.getBeverage_1());
			ps.setInt(2, beverageDTO.getBeverage_2());
			ps.setInt(3, beverageDTO.getBeverage_3());
			ps.setInt(4, beverageDTO.getBeverage_4());
			result = ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public TotalDTO readTotalDTO() {
		String sql = "select * from burger_order";
		
		TotalDTO dto = null;
		
		int sales_count = 0;
		int burger_1_count = 0;
		int burger_2_count = 0;
		int burger_3_count = 0;
		int burger_4_count = 0;
		int side_1_count = 0;
		int side_2_count = 0;
		int side_3_count = 0;
		int side_4_count = 0;
		int beverage_1_count = 0;
		int beverage_2_count = 0;
		int beverage_3_count = 0;
		int beverage_4_count = 0;
		
		try {
			ps = OrderDBCommon.con.prepareStatement(sql);
			rs = ps.executeQuery();
				System.out.println("불러오기 시작");
							
			while(rs.next()) {
				dto = new TotalDTO();
				dto.setSales_code(sales_count = rs.getInt("sales_code"));
				dto.setBurger_1(burger_1_count += rs.getInt("burger_1"));
				dto.setBurger_2(burger_2_count += rs.getInt("burger_2"));
				dto.setBurger_3(burger_3_count += rs.getInt("burger_3"));
				dto.setBurger_4(burger_4_count += rs.getInt("burger_4"));
				dto.setSide_1(side_1_count += rs.getInt("side_1"));
				dto.setSide_2(side_2_count += rs.getInt("side_2"));
				dto.setSide_3(side_3_count += rs.getInt("side_3"));
				dto.setSide_4(side_4_count += rs.getInt("side_4"));
				dto.setBeverage_1(beverage_1_count += rs.getInt("beverage_1"));
				dto.setBeverage_2(beverage_2_count += rs.getInt("beverage_2"));
				dto.setBeverage_3(beverage_3_count += rs.getInt("beverage_3"));
				dto.setBeverage_4(beverage_4_count += rs.getInt("beverage_4"));
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return dto;
	}
	
	
//	public BurgerOrderDTO readDTO() {
//		String sql = "select * from ";
//		
//		BurgerOrderDTO dto = null;
//		try {
//			ps = DBCommon.con.prepareStatement(sql);
//			rs = ps.executeQuery();
////			System.out.println("불러오기 시작");
//			while(rs.next()) {
//				dto = new SurveyDTO();
//				dto.setOversea(rs.getInt("Oversea"));
//				dto.setDomestic(rs.getInt("Domestic"));
//				dto.setNowhere(rs.getInt("Nowhere"));
//				dto.setTeenager(rs.getInt("Teenager"));
//				dto.setTwenty(rs.getInt("Twenty"));
//				dto.setThirty(rs.getInt("Thirty"));
//				dto.setFourty(rs.getInt("Fourty"));
//				dto.setMale(rs.getInt("Male"));
//				dto.setFemale(rs.getInt("Female"));
////				System.out.println("불러오기 완료");
//			}
//			
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		return dto;
//	}
	
//	public void readMenu() {
//		String sql = "select * from menu";
//		
//	}

}
