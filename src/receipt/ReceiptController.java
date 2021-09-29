package receipt;

import javafx.scene.Parent;
import resultDTO.ReceiptDTO;

public class ReceiptController { 	// 영수증 메인컨트롤러
	Parent rcRoot;
	ReceiptService rs;
	public void setRoot(Parent rcRoot) {
		this.rcRoot = rcRoot;
		rs.setRoot(rcRoot);
		rs.showReceipt(); // ReceiptServiceImpl클래스에서 라벨을 설정해 주문서를 보여준다.
		}
	
	public ReceiptController() {
		rs = new ReceiptServiceImpl(); 
	}
}
