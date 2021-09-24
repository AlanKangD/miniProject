package page1_takeAway;

import dto.ReceiptDTO;
import javafx.scene.Parent;
import page1_takeAwayDB.TADBService;
import page1_takeAwayDB.TADBServiceImpl;
import page2_card.CardMain;

public class TAServiceImpl implements TAService{
	CardMain cm;
	Parent root;
	TADBService db;
	
	public TAServiceImpl() {
		cm = new CardMain();
		db = new TADBServiceImpl();
	}

	@Override
	public void setRoot(Parent root) {
		this.root = root;
	}
	

	@Override
	public void clickEatStore() { // 포장여부를 세팅하고 객체를 넘겨줌
		
		int result = db.choiceTA(1); // DB에 1(매장)로 세팅 
		
		if(result == 1) {
			System.out.println("성공적으로 DB세팅완료");
			cm.cardMain(root);
		}else {
			System.out.println("DB세팅 실패");
		}		
	}

	@Override
	public void clickTakeOut() { // 포장여부를 세팅하고 객체를 넘겨줌
		
		int result =  db.choiceTA(2); // DB에 2(포장)로 세팅
		
		if(result == 1) {
			System.out.println("성공적으로 DB세팅완료");
			cm.cardMain(root);
		}else {
			System.out.println("DB세팅 실패");
		}	
	}

}
	