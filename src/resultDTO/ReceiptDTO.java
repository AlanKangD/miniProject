package resultDTO;
						   // result 테이블의 DB값을 불러오는 클래스						 	
public class ReceiptDTO {  // 카드 데이터를 불러옴 // + 포장여부
	private int orderNum;  // 주문번호
	private String menu;   // 주문메뉴
	private int price;     // 총금액
	private int card;	   // 카드     1 : 매장 / 2: 포장
	private int takeAway;  // 포장여부  1 : 신용 / 2: 카카오
	
	
	public int getOrderNum() { return orderNum; }
	public void setOrderNum(int orderNum) { this.orderNum = orderNum; }
	
	public String getMenu() { return menu; }
	public void setMenu(String menu) { this.menu = menu; }
	
	public int getPrice() { return price; }
	public void setPrice(int price) { this.price = price; }
	
	public int getCard() { return card; }
	public void setCard(int card) { this.card = card; }
	
	public int getTakeAway() { return takeAway; }
	public void setTakeAway(int takeAway) { this.takeAway = takeAway; }
	
	
	
	
}
