package testview;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import OrderDBService.OrderDBService;
import OrderDBService.OrderDBServiceImpl;
import OrderDBcommon.OrderDBCommon;
import Orderdto.BeverageOrderDTO;
import Orderdto.BurgerOrderDTO;
import Orderdto.SideOrderDTO;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import payment1.takeAway.TAController;

public class Controller implements Initializable {
	Parent mainRoot;
	
	String menu;
	String sAmount = null;
	String sPrice = null;
	String sTotal = null;
	int amount1;
	int price1;
	int amount2;
	int price2;
	int amount3;
	int price3;
	int total = 0;
//	int price = 0;
//	int amount = 0;
	int i1 = 0;
	int i2 = 0;
	int i3 = 0;
	
	HashMap<Integer, String> map = new HashMap<Integer, String>(3);
	/*
		HashMap으로
		키 : Menu1 / 값 : 6500
		만들고 그걸 꺼내와서 쓰는 형식으로 Click 이벤트를 제작
		
		아래 카트에는
		HashMap 이터레이터 돌려서
		값 없을 때 1번 라벨에 값 넣고 버튼들 오퍼시티 100 주기
		만일 값 있으면 그 다음 라벨 비어있나 확인, 없으면 라벨에 값 넣고 버튼 오퍼시티 100주기
		사이즈 체크해서 키가 3개면은 못 넣고
	*/
	
	ImageView fxCancel;
	ImageView fxPay;
	ImageView fxWorkout;
	
	Label lbMenuName1, lbMenuName2, lbMenuName3;
	Label lbMenuPrice1, lbMenuPrice2, lbMenuPrice3;
	Label lbWon1, lbWon2, lbWon3;
	Button fxMinus1, fxMinus2, fxMinus3;
	Button fxPlus1, fxPlus2, fxPlus3;
	Label fxAmount1, fxAmount2, fxAmount3;
	Button fxDelete1, fxDelete2, fxDelete3;
	
	Label fxTotal;
	
	DesignService vi;
	
	OrderDBServiceImpl orderdb;
	
	BurgerOrderDTO burgerDTO = new BurgerOrderDTO();
	SideOrderDTO Sidedto = new SideOrderDTO();
	BeverageOrderDTO Beveragedto = new BeverageOrderDTO();
	
	public Controller() {
		orderdb = new OrderDBServiceImpl();
	}
	
	public void setRoot(Parent root) {
//		this.root = root;
		this.mainRoot = root;
		
		fxCancel = (ImageView)root.lookup("#fxCancel");
		fxPay = (ImageView)root.lookup("#fxPay");
		fxWorkout = (ImageView)root.lookup("#fxWorkout");
		
		fxTotal = (Label)root.lookup("#fxTotal");
		
		lbMenuName1 = (Label)root.lookup("#lbMenuName1");
		lbMenuPrice1 = (Label)root.lookup("#lbMenuPrice1");
		fxMinus1 = (Button)root.lookup("#fxMinus1");
		fxPlus1 = (Button)root.lookup("#fxPlus1");
		fxDelete1 = (Button)root.lookup("#fxDelete1");
		fxAmount1 = (Label)root.lookup("#fxAmount1");
		lbWon1 = (Label)root.lookup("#lbWon1");
		
		lbMenuName2 = (Label)root.lookup("#lbMenuName2");
		lbMenuPrice2 = (Label)root.lookup("#lbMenuPrice2");
		fxMinus2 = (Button)root.lookup("#fxMinus2");
		fxPlus2 = (Button)root.lookup("#fxPlus2");
		fxDelete2 = (Button)root.lookup("#fxDelete2");
		fxAmount2 = (Label)root.lookup("#fxAmount2");
		lbWon2 = (Label)root.lookup("#lbWon2");
		
		lbMenuName3 = (Label)root.lookup("#lbMenuName3");
		lbMenuPrice3 = (Label)root.lookup("#lbMenuPrice3");
		fxMinus3 = (Button)root.lookup("#fxMinus3");
		fxPlus3 = (Button)root.lookup("#fxPlus3");
		fxDelete3 = (Button)root.lookup("#fxDelete3");
		fxAmount3 = (Label)root.lookup("#fxAmount3");
		lbWon3 = (Label)root.lookup("#lbWon3");
		
		opacityZero1();
		opacityZero2();
		opacityZero3();
		
		
		amount1 = 0;//기존 amount, price 하나씩 있던것을 123으로 나누었습니다.
		price1 = 0;
		amount2 = 0;
		price2 = 0;
		amount3 = 0;
		price3 = 0;
//		sAmountFunc(amount);
//		sPriceFunc(price, amount);
		lbMenuPrice1.setUserData(0);
		lbMenuPrice2.setUserData(0);
		lbMenuPrice3.setUserData(0);
		
		setOnCancelExit();
		setOnPayExit();
		setOnWorkoutExit();
		
		vi.setDesignService(root);
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		vi = new DesignService();
		OrderDBCommon.setDBConnection();
	}
	
	public void opacityZero1() {
		fxDelete1.setOpacity(0);
		lbWon1.setOpacity(0);
		lbMenuPrice1.setOpacity(0);
		fxMinus1.setOpacity(0);
		fxPlus1.setOpacity(0);
		fxAmount1.setOpacity(0);
	}
	
	public void opacityZero2() {
		fxDelete2.setOpacity(0);
		lbWon2.setOpacity(0);
		lbMenuPrice2.setOpacity(0);
		fxMinus2.setOpacity(0);
		fxPlus2.setOpacity(0);
		fxAmount2.setOpacity(0);
	}
	
	public void opacityZero3() {
		fxDelete3.setOpacity(0);
		lbWon3.setOpacity(0);
		lbMenuPrice3.setOpacity(0);
		fxMinus3.setOpacity(0);
		fxPlus3.setOpacity(0);
		fxAmount3.setOpacity(0);
	}
	
	
	public void opacityMax1() {
		fxDelete1.setOpacity(100);
		lbWon1.setOpacity(100);
		lbMenuPrice1.setOpacity(100);
		fxMinus1.setOpacity(100);
		fxPlus1.setOpacity(100);
		fxAmount1.setOpacity(100);
	}
	
	public void opacityMax2() {
		fxDelete2.setOpacity(100);
		lbWon2.setOpacity(100);
		lbMenuPrice2.setOpacity(100);
		fxMinus2.setOpacity(100);
		fxPlus2.setOpacity(100);
		fxAmount2.setOpacity(100);
	}
	
	public void opacityMax3() {
		fxDelete3.setOpacity(100);
		lbWon3.setOpacity(100);
		lbMenuPrice3.setOpacity(100);
		fxMinus3.setOpacity(100);
		fxPlus3.setOpacity(100);
		fxAmount3.setOpacity(100);
	}
	
	
	public void setOnCancelClick() {
		System.out.println("취소 버튼을 클릭했습니다.");
	}
	public void setOnCancelTouch() {
		fxCancel.setImage(new Image("/img/btn/btn_cancel_touch.png"));
	}
	public void setOnCancelExit() {
		fxCancel.setImage(new Image("/img/btn/btn_cancel.png"));
	}
	
	
	public void setOnPayClick() {
//		orderdb.setRoot(mainRoot);
		System.out.println("결제 버튼을 클릭했습니다.");
		try {
			int result = orderdb.TotalOrderDTO(burgerDTO, Sidedto, Beveragedto);
			if(result == 1) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setContentText("제출 성공!");
				alert.show();
			}else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setContentText("제출 실패");
				alert.show();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
//		orderdb.saveBurgerDTO(Burgerdto);
//		orderdb.saveSideDTO(Sidedto);
//		orderdb.saveBeverageDTO(Beveragedto);
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/payment1/takeAway/takeAway.fxml"));
		Parent root;
		try {
			root = loader.load();
			
			TAController ct1 = loader.getController();
			ct1.setRoot(root);
			
			Scene scene = new Scene(root);
			Stage s = (Stage)mainRoot.getScene().getWindow();
			s.setScene(scene); 
			s.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void setOnPayTouch() {
		fxPay.setImage(new Image("/img/btn/btn_pay_touch.png"));
	}
	public void setOnPayExit() {
		fxPay.setImage(new Image("/img/btn/btn_pay.png"));
	}

	
	public void setOnWorkoutClick() {
		System.out.println("정산하기 버튼을 클릭했습니다.");
	}
	
	public void setOnWorkoutTouch() {
		fxWorkout.setImage(new Image("/img/btn/btn_workout_touch.png"));
	}
	public void setOnWorkoutExit() {
		fxWorkout.setImage(new Image("/img/btn/btn_workout.png"));
	}
	
	
	public void sAmountFunc1(int amount) {//기존 sAmountFunc를 3개로 늘림
		sAmount = Integer.toString(amount);
		fxAmount1.setText(sAmount);
	}
	public void sAmountFunc2(int amount) {
		sAmount = Integer.toString(amount);
		fxAmount2.setText(sAmount);
	}
	public void sAmountFunc3(int amount) {
		sAmount = Integer.toString(amount);
		fxAmount3.setText(sAmount);
	}
	
	public void sPriceFunc1(int price, int amount) {//기존 sPriceFunc를 3개로 늘림
		price = amount * price;
		lbMenuPrice1.setUserData(price);//total계산하기 위해 추가되었습니다.
		sPrice = Integer.toString(price);
		lbMenuPrice1.setText(sPrice);
	}
	public void sPriceFunc2(int price, int amount) {
		price = amount * price;
		lbMenuPrice2.setUserData(price);
		sPrice = Integer.toString(price);
		lbMenuPrice2.setText(sPrice);
	}
	public void sPriceFunc3(int price, int amount) {
		price = amount * price;
		lbMenuPrice3.setUserData(price);
		sPrice = Integer.toString(price);
		lbMenuPrice3.setText(sPrice);
	}
	public void sTotalFunc() {//기존 sPiriceFunc에 포함되어있던 sTotal 분리
		total = (int)lbMenuPrice1.getUserData() + (int)lbMenuPrice2.getUserData() + (int)lbMenuPrice3.getUserData();
		String stotal = Integer.toString(total);
		fxTotal.setText(stotal);
	}
	
	public void setOnBurger1Click() {
		
		menu = "와퍼";
		System.out.println("와퍼를 선택했습니다.");
		
		lbMenuName1.setText(menu);
		lbMenuPrice1.setText("6000");
		
		amount1 = 1;
		price1 = 6000;
		
		burgerDTO = new BurgerOrderDTO();
		burgerDTO.setBurger_1(amount1);
		
		sAmountFunc1(amount1);
		sPriceFunc1(price1, amount1);
		sTotalFunc();	
		
		opacityMax1();
		lbFunc1(menu);
	}
	public void setOnBurger2Click() {
		menu = "치즈와퍼";
		System.out.println("치즈와퍼를 선택했습니다.");
		lbMenuName1.setText(menu);
		lbMenuPrice1.setText("6500");
		
		amount1 = 1;
		price1 = 6500;
		
		burgerDTO = new BurgerOrderDTO();
		burgerDTO.setBurger_2(amount1);
		
		sAmountFunc1(amount1);
		sPriceFunc1(price1, amount1);
		sTotalFunc();
		
		opacityMax1();
		lbFunc1(menu);
	}
	public void setOnBurger3Click() {
		menu = "베이컨와퍼";
		System.out.println("베이컨와퍼를 선택했습니다.");
		lbMenuName1.setText(menu);
		lbMenuPrice1.setText("7500");
		
		amount1 = 1;
		price1 = 7500;
		
		burgerDTO = new BurgerOrderDTO();
		burgerDTO.setBurger_3(amount1);
		
		sAmountFunc1(amount1);
		sPriceFunc1(price1, amount1);
		sTotalFunc();
		
		opacityMax1();
		lbFunc1(menu);
	}
	public void setOnBurger4Click() {
		menu = "몬스터와퍼";
		System.out.println("몬스터와퍼를 선택했습니다.");
		lbMenuName1.setText(menu);
		lbMenuPrice1.setText("8500");
		
		amount1 = 1;
		price1 = 8500;
		
		burgerDTO = new BurgerOrderDTO();
		burgerDTO.setBurger_4(amount1);
		
		sAmountFunc1(amount1);
		sPriceFunc1(price1, amount1);
		sTotalFunc();
		
		opacityMax1();
		lbFunc1(menu);
	}
	
	public void setOnMinus1Click() {
		System.out.println("마이너스 버튼 클릭");
		if(amount1 == 1) {
			amount1 = 1;
		} else {
			amount1--;
		}
		
		BurgerCountChange();
		
		sAmountFunc1(amount1);
		sPriceFunc1(price1, amount1);
		sTotalFunc();
		
	}
	
	public void setOnPlus1Click() {
		System.out.println("플러스 버튼 클릭");
		amount1++;
		BurgerCountChange();
		sAmountFunc1(amount1);
		sPriceFunc1(price1, amount1);
		sTotalFunc();
	}
	
	public void setOnDelete1Click() {
		lbMenuName1.setText("");
		lbMenuPrice1.setText("");
		
		amount1 = 0;
		price1 = 0;
		BurgerCountChange();
		sAmountFunc1(amount1);
		sPriceFunc1(price1, amount1);
		sTotalFunc();
		
		opacityZero1();

		map.remove(1);
		System.out.println(map.get(1));
	}
	
	public void setOnMinus2Click() {
		System.out.println("2 마이너스 버튼 클릭");
		System.out.println("마이너스 버튼 클릭");
		if(amount2 == 1) {
			amount2 = 1;
		} else {
			amount2--;
		}
		SideCountChange();
		sAmountFunc2(amount2);
		sPriceFunc2(price2, amount2);
		sTotalFunc();
		
	}
	
	public void setOnMinus3Click() {
		System.out.println("3 마이너스 버튼 클릭");
		System.out.println("마이너스 버튼 클릭");
		if(amount3 == 1) {
			amount3 = 1;
		} else {
			amount3--;
		}
		
		BeverageCountChange();
		
		sAmountFunc3(amount3);
		sPriceFunc3(price3, amount3);
		sTotalFunc();
		
	}
	
	public void setOnPlus2Click() {
		System.out.println("2 플러스 버튼 클릭");
		System.out.println("플러스 버튼 클릭");
		amount2++;
		SideCountChange();
		sAmountFunc2(amount2);
		sPriceFunc2(price2, amount2);
		sTotalFunc();
	}
	
	public void setOnPlus3Click() {
		System.out.println("3 플러스 버튼 클릭");
		System.out.println("플러스 버튼 클릭");
		amount3++;
		
		BeverageCountChange();
		
		sAmountFunc3(amount3);
		sPriceFunc3(price3, amount3);
		sTotalFunc();
	}
	
	public void setOnDelete2Click() {
		lbMenuName2.setText("");
		lbMenuPrice2.setText("");
		
		amount2 = 0;
		price2 = 0;
		
		SideCountChange();
		
		sAmountFunc2(amount2);
		sPriceFunc2(price2, amount2);
		sTotalFunc();
		
		opacityZero2();

		map.remove(2);
		System.out.println(map.get(2));
		System.out.println("2 딜리트 버튼 클릭");
	}
	
	public void setOnDelete3Click() {
		lbMenuName3.setText("");
		lbMenuPrice3.setText("");
		
		amount3 = 0;
		price3 = 0;
		
		BeverageCountChange();
		
		sAmountFunc3(amount3);
		sPriceFunc3(price3, amount3);
		sTotalFunc();
		
		opacityZero3();
		map.remove(3);
		System.out.println(map.get(3));
		System.out.println("3 딜리트 버튼 클릭");
	}
	
	public void setOnSide1Click() {
		menu = "프랜치프라이";
		lbMenuName2.setText(menu);
		lbMenuPrice2.setText("1500");
		
		amount2 = 1;
		price2 = 1500;
		
		Sidedto = new SideOrderDTO();
		Sidedto.setSide_1(amount2);
		
		sAmountFunc2(amount2);
		sPriceFunc2(price2, amount2);
		sTotalFunc();
		
		opacityMax2();
		lbFunc2(menu);
	}
	public void setOnSide2Click() {
		menu = "치킨너겟";
		lbMenuName2.setText(menu);
		lbMenuPrice2.setText("2000");
		
		amount2 = 1;
		price2 = 2000;
		
		Sidedto = new SideOrderDTO();
		Sidedto.setSide_2(amount2);
		
		sAmountFunc2(amount2);
		sPriceFunc2(price2, amount2);
		sTotalFunc();
		
		opacityMax2();
		lbFunc2(menu);
	}
	public void setOnSide3Click() {
		menu = "치즈스틱";
		lbMenuName2.setText(menu);
		lbMenuPrice2.setText("1500");
		
		amount2 = 1;
		price2 = 1500;
		
		Sidedto = new SideOrderDTO();
		Sidedto.setSide_3(amount2);
		
		sAmountFunc2(amount2);
		sPriceFunc2(price2, amount2);
		sTotalFunc();
		
		opacityMax2();
		lbFunc2(menu);
	}
	public void setOnSide4Click() {
		menu = "콘샐러드";
		lbMenuName2.setText(menu);
		lbMenuPrice2.setText("1500");
		
		amount2 = 1;
		price2 = 1500;
		
		Sidedto = new SideOrderDTO();
		
		Sidedto.setSide_4(amount2);
		
		sAmountFunc2(amount2);
		sPriceFunc2(price2, amount2);
		sTotalFunc();
		
		opacityMax2();
		lbFunc2(menu);
	}
	
	
	public void setOnDrink1Click() {
		menu = "콜라";
		lbMenuName3.setText(menu);
		lbMenuPrice3.setText("1500");
		
		amount3 = 1;
		price3 = 1500;
		
		Beveragedto = new BeverageOrderDTO();
		Beveragedto.setBeverage_1(amount3);
		
		sAmountFunc3(amount3);
		sPriceFunc3(price3, amount3);
		sTotalFunc();
		
		opacityMax3();
		lbFunc3(menu);
	}
	public void setOnDrink2Click() {
		menu = "제로콜라";
		lbMenuName3.setText(menu);
		lbMenuPrice3.setText("1500");
		
		amount3 = 1;
		price3 = 1500;
		
		Beveragedto = new BeverageOrderDTO();
		Beveragedto.setBeverage_2(amount3);
		
		sAmountFunc3(amount3);
		sPriceFunc3(price3, amount3);
		sTotalFunc();
		
		opacityMax3();
		lbFunc3(menu);
	}
	public void setOnDrink3Click() {
		menu = "사이다";
		lbMenuName3.setText(menu);
		lbMenuPrice3.setText("1500");
		
		amount3 = 1;
		price3 = 1500;
		
		Beveragedto = new BeverageOrderDTO();
		Beveragedto.setBeverage_3(amount3);
		
		sAmountFunc3(amount3);
		sPriceFunc3(price3, amount3);
		sTotalFunc();
		
		opacityMax3();
		lbFunc3(menu);
	}
	public void setOnDrink4Click() {
		menu = "오렌지주스";
		lbMenuName3.setText(menu);
		lbMenuPrice3.setText("2000");
		
		amount3 = 1;
		price3 = 2000;
		
		Beveragedto = new BeverageOrderDTO();
		Beveragedto.setBeverage_4(amount3);
		
		sAmountFunc3(amount3);
		sPriceFunc3(price3, amount3);
		sTotalFunc();
	
		opacityMax3();
		lbFunc3(menu);
	}
	
	public void lbFunc1(String menu) {
		map.put(1, menu);
		System.out.println(map.get(1));
	}
	
	public void lbFunc2(String menu) {
		map.put(2, menu);
		System.out.println(map.get(2));
	}
	
	public void lbFunc3(String menu) {
		map.put(3, menu);
		System.out.println(map.get(3));
	}
	
	public void BurgerCountChange() {//플러스마이너스 값을 dto에 넣어서 수정할 수 있게 만들었음
		if(burgerDTO.getBurger_1() != 0) {
			burgerDTO.setBurger_1(amount1);
		}else if(burgerDTO.getBurger_2() != 0){
			burgerDTO.setBurger_2(amount1);
		}else if(burgerDTO.getBurger_3() != 0) {
			burgerDTO.setBurger_3(amount1);
		}else if(burgerDTO.getBurger_4() != 0) {
			burgerDTO.setBurger_4(amount1);
		}
	}
	public void SideCountChange() {
		if(Sidedto.getSide_1() != 0) {
			Sidedto.setSide_1(amount2);
		}else if(Sidedto.getSide_2() != 0){
			Sidedto.setSide_2(amount2);
		}else if(Sidedto.getSide_3() != 0) {
			Sidedto.setSide_3(amount2);
		}else if(Sidedto.getSide_4() != 0) {
			Sidedto.setSide_4(amount2);
		}
	}
	public void BeverageCountChange() {
		if(Beveragedto.getBeverage_1() != 0) {
			Beveragedto.setBeverage_1(amount3);
		}else if(Beveragedto.getBeverage_2() != 0){
			Beveragedto.setBeverage_2(amount3);
		}else if(Beveragedto.getBeverage_3() != 0) {
			Beveragedto.setBeverage_3(amount3);
		}else if(Beveragedto.getBeverage_4() != 0) {
			Beveragedto.setBeverage_4(amount3);
		}
	}

}

