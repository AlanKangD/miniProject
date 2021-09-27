package payment2.card;

import javafx.scene.Parent;
import payment2.cardDB.CardDBService;
import payment2.cardDB.CardDBServiceimpl;
import payment3.cardPut.CPMain;
import resultDTO.ReceiptDTO;

public class CardServiceImpl implements CardService{ // 신용카드,카카오 클릭시 실행기능
	CPMain cm;
	Parent cardRoot;
	CardDBService db;
	
	public CardServiceImpl() {
		cm = new CPMain();
		db = new CardDBServiceimpl();
	}
	
	@Override
	public void setRoot(Parent cardRoot) {
		this.cardRoot = cardRoot;
	}
	
	@Override
	public void buyCredit() {
		
		int result = db.ChoiceCard(1); // DB에 신용카드로 세팅, 1 -> 신용카드 
		
		if(result == 1) {
			System.out.println("성공적으로 DB세팅완료");
			cm.cpMain(cardRoot); // DB에 값 세팅 후 카드넣기 클래스로 이동
		}else {
			System.out.println("DB세팅 실패");
		}		
	}
	
	@Override
	public void buyKakao() {
		
		int result = db.ChoiceCard(2); // DB에 카카오페이로 세팅, 2 -> 카카오페이 
		
		if(result == 1) {
			System.out.println("성공적으로 DB세팅완료");
			cm.cpMain(cardRoot); // DB에 값 세팅 후 카드넣기 클래스로 이동
		}else {
			System.out.println("DB세팅 실패");
		}		
	}
}
