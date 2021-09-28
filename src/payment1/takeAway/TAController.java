package payment1.takeAway;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import payment2.card.CardMain;

public class TAController implements Initializable{ // 포장여부 메인컨트롤러
	Parent root;
	TAService ts;
	
	public void setRoot(Parent root) {
		this.root = root;
		setImage();
		ts.setRoot(root);
	}
	
	public void setImage() { // 이미지를 세팅해주는 메소드
		ImageView store = (ImageView)root.lookup("#storeView");
		ImageView pack = (ImageView)root.lookup("#packView");
		
		store.setImage(new Image("/image/store.jfif"));
		pack.setImage(new Image("/image/packing.jpg"));
		
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ts = new TAServiceImpl();
	}
	
	public void clickTakeOut() { // 포장주문 클릭시 실행 // TAServiceImpl 로 이동
		ts.clickTakeOut();
	}
	public void clickEatStore() { // 매장식사 클릭시 실행  // TAServiceImpl 로 이동
		ts.clickEatStore();
	}
}
