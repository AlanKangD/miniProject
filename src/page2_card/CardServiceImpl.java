package page2_card;

import dto.ReceiptDTO;
import javafx.scene.Parent;
import page2_cardDB.CardDBService;
import page2_cardDB.CardDBServiceimpl;
import page3_cardPut.CPMain;

public class CardServiceImpl implements CardService{
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
		
		int result = db.ChoiceCard(1); // DB에 1(신용카드)로 세팅 
		
		if(result == 1) {
			System.out.println("성공적으로 DB세팅완료");
			cm.cpMain(cardRoot);
		}else {
			System.out.println("DB세팅 실패");
		}		
	}
	
	@Override
	public void buyKakao() {
		
		int result = db.ChoiceCard(2); // DB에 2(카카오카드)로 세팅 
		
		if(result == 1) {
			System.out.println("성공적으로 DB세팅완료");
			cm.cpMain(cardRoot);
		}else {
			System.out.println("DB세팅 실패");
		}		
	}
}
