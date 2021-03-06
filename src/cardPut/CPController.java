package cardPut;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import receipt.ReceiptMain;
import resultDTO.ReceiptDTO;
import resultDTO.ReceiptDTO;

public class CPController implements Initializable  { // '카드를 넣어주세요'페이지의 메인컨트롤러
	Parent cPRoot;
	ReceiptMain rc;
	ReceiptDTO RcptDTO;
	
	public void setRoot(Parent cPRoot) {
		this.cPRoot = cPRoot;
		setImage();
		setTotal_price();
	}
	
	public void setImage() { // 이미지를 세팅해주는 메소드
		ImageView fxCardPut = (ImageView)cPRoot.lookup("#fxCardPut");
		fxCardPut.setImage(new Image("/image/cardPut.PNG"));
	}
	
	public void setTotal_price() { // 결제가격을 set해주는 메소드
		Label price = (Label)cPRoot.lookup("#fxMoney");
		price.setText( RcptDTO.getTotal()+"원" );
	}
	
	public void clickCP() {
		rc.receiptMain(cPRoot); // 확인 클릭시 영수증(주문서) 클래스로 이동
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		rc = new ReceiptMain();
	}
	

}
