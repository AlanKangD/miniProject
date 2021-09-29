package takeAway;

import card.CardMain;
import javafx.scene.Parent;
import resultDTO.ReceiptDTO;

public class TAServiceImpl implements TAService{ // 포장주문, 매장식사 클릭시 실행기능 
	CardMain cm;
	Parent root;
	String store;
	String takeOut;
	ReceiptDTO RcptDTO = new ReceiptDTO();
	
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

	