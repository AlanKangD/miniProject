package card;

import java.net.URL;
import java.util.ResourceBundle;

import cardPut.CPMain;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import receipt.ReceiptMain;
import resultDTO.ReceiptDTO;

public class CardController implements Initializable { // 카드선택 메인컨트롤러
	Parent cardRoot;
	CardService cs;
	public void setRoot(Parent cardRoot) {
		this.cardRoot = cardRoot;
		setImage();
		cs.setRoot(cardRoot);
	}
	
	public void setImage() { // 이미지를 세팅해주는 메소드
		ImageView credit = (ImageView)cardRoot.lookup("#creditView");
		ImageView kakao = (ImageView)cardRoot.lookup("#kakaoView");
		
		credit.setImage(new Image("/image/credit.jfif"));
		kakao.setImage(new Image("/image/kakao.jpg"));
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cs = new CardServiceImpl();
	}
	
	public void buyCredit() { // 신용카드 클릭시 // CardServiceImpl로 이동
		cs.buyCredit();
	}
	public void buyKakao() { // 카카오페이 클릭시 // CardServiceImpl로 이동
		cs.buyKakao();
	}
}
