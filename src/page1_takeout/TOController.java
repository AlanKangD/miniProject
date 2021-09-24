package page1_takeout;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import page2_card.CardMain;

public class TOController implements Initializable{
	Parent root;
	CardMain cm;
	public void setRoot(Parent root) {
		this.root = root;
		setImage();
	}
	
	public void setImage() {
		ImageView store = (ImageView)root.lookup("#storeView");
		ImageView pack = (ImageView)root.lookup("#packView");
		
		store.setImage(new Image("/image/store.jfif"));
		pack.setImage(new Image("/image/packing.jpg"));
		
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cm = new CardMain();
	}
	
	public void clickPacking() {
		cm.cardMain(root);
	}
	public void clickStore() {
		cm.cardMain(root);	
	}
}
