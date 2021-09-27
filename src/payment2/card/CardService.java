package payment2.card;

import javafx.scene.Parent;
import resultDTO.ReceiptDTO;
				
public interface CardService { // CardServiceImpl 인터페이스
	public void setRoot(Parent cardRoot); // root값을 가져온다.
	public void buyCredit();			  // DB에 값을 신용카드(1)로 설정
	public void buyKakao();				  // DB에 값을 카카오페이(2)로 설정
}
