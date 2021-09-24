package page2_card;

import dto.ReceiptDTO;
import javafx.scene.Parent;

public interface CardService {
	public void setRoot(Parent cardRoot);
	public void buyCredit();
	public void buyKakao();
}
