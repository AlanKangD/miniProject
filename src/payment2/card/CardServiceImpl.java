package payment2.card;

import javafx.scene.Parent;
import payment3.cardPut.CPMain;
import resultDTO.ReceiptDTO;

public class CardServiceImpl implements CardService{ // 신용카드,카카오 클릭시 실행기능
	CPMain cm;
	Parent cardRoot;
	ReceiptDTO RcptDTO;
	
	public CardServiceImpl() {
		cm = new CPMain();
	}
	
	@Override
	public void setRoot(Parent cardRoot) {
		this.cardRoot = cardRoot;
	}
	
	@Override
	public void buyCredit() {
		RcptDTO.setCard("신용카드"); // 카드를 DTO에 신용카드로 set
		cm.cpMain(cardRoot);
	}
	
	@Override
	public void buyKakao() {
		RcptDTO.setCard("카카오페이"); // 카드를 DTO에 카카오페이로 set
		cm.cpMain(cardRoot);
	}
}
