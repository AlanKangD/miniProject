package payment1.takeAway;

import javafx.scene.Parent;
								      // TAServiceImpl클래스의 인터페이스
public interface TAService {
	public void setRoot(Parent root); // 루트값 넘겨주는 기능
	public void clickTakeOut();       // 포장주문 클릭시 포장주문으로 DB 세팅후 다음페이지
	public void clickEatStore();      // 포장주문 클릭시 매장식사로 DB 세팅후 다음페이지
}
