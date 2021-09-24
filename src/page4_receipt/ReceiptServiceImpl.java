package page4_receipt;

import dto.ReceiptDTO;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import page4_receiptDB.RcDBService;
import page4_receiptDB.RcDBServiceImpl;

public class ReceiptServiceImpl implements ReceiptService{
	Parent rcRoot;
	RcDBService db;
	Label orderNum, takeAway, card, menu, price;
	
	public ReceiptServiceImpl() {
		db = new RcDBServiceImpl();
	}
	
	@Override
	public void setRoot(Parent rcRoot) {
		this.rcRoot =  rcRoot;
		setLabel();
	}
	
	private void setLabel() {
		orderNum = (Label)rcRoot.lookup("#fxMenuNum");
		takeAway = (Label)rcRoot.lookup("#fxPacking");
		card = (Label)rcRoot.lookup("#fxCard");
		menu = (Label)rcRoot.lookup("#fxBurger");
		price = (Label)rcRoot.lookup("#fxMoney");
	}

	@Override
	public void showReceipt() { // 영수증 보여주는 메소드
		ReceiptDTO dto = db.takeResult();
		if(dto != null) {
			// 주문번호
			orderNum.setText(dto.getOrderNum()+"");
			// 포장여부
			if(dto.getTakeAway() == 1) {
				takeAway.setText("매장식사");
			}else { takeAway.setText("포장주문"); }
			// 카드
			if(dto.getCard() == 1) {
				card.setText("신용카드");
			}else { card.setText("카카오페이"); }
			// 주문메뉴
			menu.setText( dto.getMenu() );
			// 결제금액
			price.setText( dto.getPrice()+"" );
			
		}else {
			System.out.println("주문서 불러오기 실패");
		}
		
	}

}
