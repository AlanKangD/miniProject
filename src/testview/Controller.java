package testview;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import page1_takeAway.*;

public class Controller implements Initializable {
	Parent root;
	
	String sAmount = null;
	String sPrice = null;
	String sTotal = null;
	int amount;
	int price;
	int total;
	
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

	public void setRoot(Parent root) {
		this.root = root;
		
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
		
		
	
		
		amount = 0;
		price = 0;
		sAmountFunc(amount);
		sPriceFunc(price, amount);
		
		setOnCancelExit();
		setOnPayExit();
		setOnWorkoutExit();
		
		vi.setDesignService(root);
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		vi = new DesignService();
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
		System.out.println("결제 버튼을 클릭했습니다.");
		TAMainClass.main(null);
		
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
	
	
	public void sAmountFunc(int amount) {
		sAmount = Integer.toString(amount);
		fxAmount1.setText(sAmount);
	}
	
	public void sPriceFunc(int price, int amount) {
		price = amount * price;
		sPrice = Integer.toString(price);
		sTotal = sPrice;
		lbMenuPrice1.setText(sPrice);
		fxTotal.setText(sTotal);
	}
	
	
	public void setOnBurger1Click() {
		
		String menu = "와퍼";
		System.out.println("와퍼를 선택했습니다.");
		lbMenuName1.setText(menu);
		lbMenuPrice1.setText("6000");
		
		amount = 1;
		price = 6000;
		sAmountFunc(amount);
		sPriceFunc(price, amount);
		
		opacityMax1();
		lbFunc1(menu);
		
	}
	
	public void setOnMinus1Click() {
		System.out.println("마이너스 버튼 클릭");
		if(amount == 1) {
			amount = 1;
		} else {
			amount--;
		}
		sAmountFunc(amount);
		sPriceFunc(price, amount);
		
	}
	
	public void setOnPlus1Click() {
		System.out.println("플러스 버튼 클릭");
		amount++;
		sAmountFunc(amount);
		sPriceFunc(price, amount);
	}
	
	public void setOnDelete1Click() {
		lbMenuName1.setText("");
		lbMenuPrice1.setText("");
		
		amount = 0;
		price = 0;
		sAmountFunc(amount);
		sPriceFunc(price, amount);
		
		opacityZero1();

		map.remove(1);
		System.out.println(map.get(1));
	}
	
	
	
	
	
	public void setOnMinus2Click() {
		System.out.println("2 마이너스 버튼 클릭");
	}
	
	public void setOnMinus3Click() {
		System.out.println("3 마이너스 버튼 클릭");
	}
	
	public void setOnPlus2Click() {
		System.out.println("2 플러스 버튼 클릭");
	}
	
	public void setOnPlus3Click() {
		System.out.println("3 플러스 버튼 클릭");
	}
	
	public void setOnDelete2Click() {
		lbMenuName2.setText("");
		opacityZero2();
		System.out.println("2 딜리트 버튼 클릭");
	}
	
	public void setOnDelete3Click() {
		lbMenuName3.setText("");
		opacityZero3();
		System.out.println("3 딜리트 버튼 클릭");
	}
	
	public void setOnSide1Click() {
		lbMenuName2.setText("프랜치프라이");
		opacityMax2();
	}
	
	public void setOnDrink1Click() {
		lbMenuName3.setText("콜라");
		opacityMax3();
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
	
	

}

