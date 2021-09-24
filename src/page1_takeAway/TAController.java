package page1_takeAway;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import page2_card.CardMain;

public class TAController implements Initializable{
	Parent root;
	TAService ps;
	
	public void setRoot(Parent root) {
		this.root = root;
		setImage();
		ps.setRoot(root);
	}
	
	public void setImage() {
		ImageView store = (ImageView)root.lookup("#storeView");
		ImageView pack = (ImageView)root.lookup("#packView");
		
		store.setImage(new Image("/image/store.jfif"));
		pack.setImage(new Image("/image/packing.jpg"));
		
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ps = new TAServiceImpl();
	}
	
	public void clickTakeOut() { // 포장주문 클릭시 실행 
		ps.clickTakeOut();
	}
	public void clickEatStore() { // 매장식사 클릭시 실행
		ps.clickEatStore();
	}
}
