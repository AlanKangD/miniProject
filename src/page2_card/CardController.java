package page2_card;

import java.net.URL;
import java.util.ResourceBundle;

import dto.ReceiptDTO;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import page3_cardPut.CPMain;
import page4_receipt.ReceiptMain;

public class CardController implements Initializable {
	Parent cardRoot;
	CardService cs;
	public void setRoot(Parent cardRoot) {
		this.cardRoot = cardRoot;
		setImage();
		cs.setRoot(cardRoot);
	}
	
	public void setImage() {
		ImageView credit = (ImageView)cardRoot.lookup("#creditView");
		ImageView kakao = (ImageView)cardRoot.lookup("#kakaoView");
		
		credit.setImage(new Image("/image/credit.jfif"));
		kakao.setImage(new Image("/image/kakao.jpg"));
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cs = new CardServiceImpl();
	}
	
	public void buyCredit() {
		cs.buyCredit();
	}
	public void buyKakao() {
		cs.buyKakao();
	}
}
