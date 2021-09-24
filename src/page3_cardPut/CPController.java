package page3_cardPut;

import java.net.URL;
import java.util.ResourceBundle;

import dto.ReceiptDTO;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import page4_receipt.ReceiptMain;

public class CPController implements Initializable  {
	Parent cPRoot;
	ReceiptMain rc;
	public void setRoot(Parent cPRoot) {
		this.cPRoot = cPRoot;
		setImage();
	}
	
	public void setImage() {
		ImageView fxCardPut = (ImageView)cPRoot.lookup("#fxCardPut");
		fxCardPut.setImage(new Image("/image/cardPut.PNG"));
	}
	
	public void clickCP() {
		rc.receiptMain(cPRoot);
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		rc = new ReceiptMain();
	}
	

}
