package page4_receipt;

import dto.ReceiptDTO;
import javafx.scene.Parent;

public class ReceiptController {
	Parent rcRoot;
	ReceiptService rs;
	public void setRoot(Parent rcRoot) {
		this.rcRoot = rcRoot;
		rs.setRoot(rcRoot);
		rs.showReceipt();
		}
	
	public ReceiptController() {
		rs = new ReceiptServiceImpl();
	}
}
