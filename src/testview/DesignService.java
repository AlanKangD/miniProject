package testview;

import javafx.scene.Cursor;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class DesignService {
	ImageView fxBurger1;
	ImageView fxBurger2;
	ImageView fxBurger3;
	ImageView fxBurger4;
	ImageView fxSide1;
	ImageView fxSide2;
	ImageView fxSide3;
	ImageView fxSide4;
	ImageView fxDrink1, fxDrink2, fxDrink3, fxDrink4;
	ImageView fxMenu;
	ImageView fxCartBackground;
//	Label lbBurgerName1, lbBurgerName2, lbBurgerName3, lbBurgerName4;
//	Label lbSideName1, lbSideName2, lbSideName3, lbSideName4;
//	Label lbDrinkName1, lbDrinkName2, lbDrinkName3, lbDrinkName4;
	
	public void setDesignService(Parent root) {

		setDesignControll(root);
		
		fxBurger1.setImage(new Image("/img/menu/whopper.png"));
		fxBurger2.setImage(new Image("/img/menu/whopper_cheese.png"));
		fxBurger3.setImage(new Image("/img/menu/whopper_bacon.png"));
		fxBurger4.setImage(new Image("/img/menu/whopper_monster.png"));
		
		fxSide1.setImage(new Image("/img/menu/side_fries.png"));
		fxSide2.setImage(new Image("/img/menu/side_nuggets.png"));
		fxSide3.setImage(new Image("/img/menu/side_stick.png"));
		fxSide4.setImage(new Image("/img/menu/side_corn.png"));
		
		fxDrink1.setImage(new Image("/img/menu/drink_coke.png"));
		fxDrink2.setImage(new Image("/img/menu/drink_coke_zero.png"));
		fxDrink3.setImage(new Image("/img/menu/drink_cider.png"));
		fxDrink4.setImage(new Image("/img/menu/drink_orange.png"));
		
		fxMenu.setImage(new Image("/img/bg/bg_menu.png"));
		fxCartBackground.setImage(new Image("/img/bg/bg_cart.png"));
		
//		lbBurgerName1.setText("와퍼");
//		lbBurgerName2.setText("치즈 와퍼");
//		lbBurgerName3.setText("베이컨 와퍼");
//		lbBurgerName4.setText("몬스터 와퍼");
//		
//		lbSideName1.setText("프랜치프라이");
//		lbSideName2.setText("치킨너겟");
//		lbSideName3.setText("치즈스틱");
//		lbSideName4.setText("콘샐러드");
//		
//		lbDrinkName1.setText("콜라");
//		lbDrinkName2.setText("제로콜라");
//		lbDrinkName3.setText("사이다");
//		lbDrinkName4.setText("오렌지주스");
		
	}
	
	public void setDesignControll(Parent root) {
		fxBurger1 = (ImageView)root.lookup("#fxBurger1");
		fxBurger1.setCursor(Cursor.HAND);
		fxBurger2 = (ImageView)root.lookup("#fxBurger2");
		fxBurger2.setCursor(Cursor.HAND);
		fxBurger3 = (ImageView)root.lookup("#fxBurger3");
		fxBurger3.setCursor(Cursor.HAND);
		fxBurger4 = (ImageView)root.lookup("#fxBurger4");
		fxBurger4.setCursor(Cursor.HAND);
		
		fxSide1 = (ImageView)root.lookup("#fxSide1");
		fxSide1.setCursor(Cursor.HAND);
		fxSide2 = (ImageView)root.lookup("#fxSide2");
		fxSide2.setCursor(Cursor.HAND);
		fxSide3 = (ImageView)root.lookup("#fxSide3");
		fxSide3.setCursor(Cursor.HAND);
		fxSide4 = (ImageView)root.lookup("#fxSide4");
		fxSide4.setCursor(Cursor.HAND);
		
		fxDrink1 = (ImageView)root.lookup("#fxDrink1");
		fxDrink1.setCursor(Cursor.HAND);
		fxDrink2 = (ImageView)root.lookup("#fxDrink2");
		fxDrink2.setCursor(Cursor.HAND);
		fxDrink3 = (ImageView)root.lookup("#fxDrink3");
		fxDrink3.setCursor(Cursor.HAND);
		fxDrink4 = (ImageView)root.lookup("#fxDrink4");
		fxDrink4.setCursor(Cursor.HAND);
		
		fxMenu = (ImageView)root.lookup("#fxMenu");
		fxCartBackground = (ImageView)root.lookup("#fxCartBackground");
		
//		lbBurgerName1 = (Label)root.lookup("#lbBurgerName1");
//		lbBurgerName2 = (Label)root.lookup("#lbBurgerName2");
//		lbBurgerName3 = (Label)root.lookup("#lbBurgerName3");
//		lbBurgerName4 = (Label)root.lookup("#lbBurgerName4");
//		lbSideName1 = (Label)root.lookup("#lbSideName1");
//		lbSideName2 = (Label)root.lookup("#lbSideName2");
//		lbSideName3 = (Label)root.lookup("#lbSideName3");
//		lbSideName4 = (Label)root.lookup("#lbSideName4");
//		lbDrinkName1 = (Label)root.lookup("#lbDirnkName1");
//		lbDrinkName2 = (Label)root.lookup("#lbDirnkName2");
//		lbDrinkName3 = (Label)root.lookup("#lbDirnkName3");
//		lbDrinkName4 = (Label)root.lookup("#lbDirnkName4");
		
	}
	

}
