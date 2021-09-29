package payment4.receipt;

import javafx.scene.Parent;
import javafx.scene.control.Label;
import payment4.receiptDB.RcDBService;
import payment4.receiptDB.RcDBServiceImpl;
import resultDTO.ReceiptDTO;
import resultDTO.ReceiptDTO;
import testview.Controller;

public class ReceiptServiceImpl implements ReceiptService{ // 영수증을 보여주기위해 설정하는 클래스
	Parent rcRoot;
	RcDBService db;
	Label orderNum, takeAway, card, menu, price;
	ReceiptDTO RcptDTO;
	
	public ReceiptServiceImpl() {
		db = new RcDBServiceImpl();
	}
	
	@Override
	public void setRoot(Parent rcRoot) {
		this.rcRoot =  rcRoot;
		setLabel();
	}
	
	private void setLabel() { // 라벨을 세팅해준다.
		orderNum = (Label)rcRoot.lookup("#fxMenuNum");
		takeAway = (Label)rcRoot.lookup("#fxPacking");
		card = (Label)rcRoot.lookup("#fxCard");
		menu = (Label)rcRoot.lookup("#fxBurger");
		price = (Label)rcRoot.lookup("#fxMoney");
	}

	@Override
	public void showReceipt() { // 영수증 설정해서 보여주는 메소드
		ReceiptDTO dto = db.takeResult(); // RcDBServiceImpl클래스로 이동해 DB값 설정 후 값 세팅
		if(dto != null) {
			// 주문번호
			orderNum.setText(dto.getOrderNum()+"");
			
//			// 포장여부
//			if(dto.getTakeAway() == 1) {
//				takeAway.setText("매장식사");
//			}else { takeAway.setText("포장주문"); }
//			
//			// 카드
//			if(dto.getCard() == 1) {
//				card.setText("신용카드");
//			}else { card.setText("카카오페이"); }

//			// 결제금액
			price.setText( RcptDTO.getTotal()+"원" );
			
			// 주문메뉴
			
			String totalMenu = RcptDTO.getMenu_1_name() + " (" 
			+ RcptDTO.getMenu_1_count()+")개 : "+RcptDTO.getMenu_1_price()+"원\n"
			+ RcptDTO.getMenu_2_name() + " (" 
			+ RcptDTO.getMenu_2_count()+")개 : "+RcptDTO.getMenu_2_price()+"원\n"
			+ RcptDTO.getMenu_3_name() + " (" 
			+ RcptDTO.getMenu_3_count()+")개 : "+RcptDTO.getMenu_3_price()+"원";
			System.out.println(totalMenu);		
			menu.setText( totalMenu );			
	
		}else {
			System.out.println("주문서 불러오기 실패");
			
		}
		
	}

}
