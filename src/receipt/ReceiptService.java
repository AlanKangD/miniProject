package receipt;

import javafx.scene.Parent;
import resultDTO.ReceiptDTO;

public interface ReceiptService { // ReceiptServiceImpl클래스의 인터페이스

	public void setRoot(Parent cPRoot);
	public void showReceipt();
}
