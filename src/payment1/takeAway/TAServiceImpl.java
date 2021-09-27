package payment1.takeAway;

import javafx.scene.Parent;
import payment1.takeAwayDB.TADBService;
import payment1.takeAwayDB.TADBServiceImpl;
import payment2.card.CardMain;
import resultDTO.ReceiptDTO;

public class TAServiceImpl implements TAService{ // 포장주문, 매장식사 클릭시 실행기능 
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
		
		int result = db.choiceTA(1); // DB에 매장으로 세팅, 1 -> 매장식사
		
		if(result == 1) {
			System.out.println("성공적으로 DB세팅완료");
			cm.cardMain(root); // card선택 장면으로 넘어감
		}else {
			System.out.println("DB세팅 실패");
		}		
	}

	@Override
	public void clickTakeOut() { // 포장여부를 세팅하고 객체를 넘겨줌
		
		int result =  db.choiceTA(2); // DB에 포장으로 세팅. 2 -> 포장주문
		
		if(result == 1) {
			System.out.println("성공적으로 DB세팅완료");
			cm.cardMain(root); // card선택 장면으로 넘어감
		}else {
			System.out.println("DB세팅 실패");
		}	
	}

}
	