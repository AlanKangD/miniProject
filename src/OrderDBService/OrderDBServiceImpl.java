package OrderDBService;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import OrderDBcommon.OrderDBCommon;
import Orderdto.BeverageOrderDTO;
import Orderdto.BurgerOrderDTO;
import Orderdto.SideOrderDTO;
import dto.ReceiptDTO;
import javafx.scene.Parent;

public class OrderDBServiceImpl implements OrderDBService{
	Parent root;
	PreparedStatement ps;
	ResultSet rs;
	SideOrderDTO sideDTO;
	BeverageOrderDTO beverageDTO;
	
	public void setRoot(Parent root) {
		this.root = root;
	}
	public int saveBurgerDTO(BurgerOrderDTO burgerDTO) {
		String sql = 
				"insert into burger_order(burger_1, burger_2, burger_3, burger_4) values(?, ?, ?, ?)";
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
				"insert into burger_order(side_1, side_2, burger_3, burger_4) values(?, ?, ?, ?)";
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
	public BurgerOrderDTO readDTO() {
//		String sql = "select * from ";
//		
		BurgerOrderDTO dto = null;
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
		return dto;
	}
	
	public void readMenu() {
		String sql = "select * from menu";
		
	}
	@Override
	public int saveDTO(ReceiptDTO dto) {
		// TODO Auto-generated method stub
		return 0;
	}

}
