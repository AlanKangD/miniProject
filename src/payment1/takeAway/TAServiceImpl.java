package payment1.takeAway;

import javafx.scene.Parent;
import payment2.card.CardMain;
import resultDTO.ReceiptDTO;

public class TAServiceImpl implements TAService{ // 포장주문, 매장식사 클릭시 실행기능 
	CardMain cm;
	Parent root;
	ReceiptDTO RcptDTO;
	String store;
	String takeOut;
	
	public TAServiceImpl() {
		cm = new CardMain();
	}

	@Override
	public void setRoot(Parent root) {
		this.root = root;
	}
	

	@Override
	public void clickEatStore() {
		store = "매장식사";
		RcptDTO.setTakeAway(store); // 포장여부를 DTO에 매장식사로 set
		cm.cardMain(root);
	}

	@Override
	public void clickTakeOut() {
		takeOut = "주문포장";
		RcptDTO.setTakeAway(takeOut); // 포장여부를 DTO에 주문포장로 set
		cm.cardMain(root);
		}	
	}

	