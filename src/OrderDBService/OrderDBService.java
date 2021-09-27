package OrderDBService;

import Orderdto.BeverageOrderDTO;
import Orderdto.BurgerOrderDTO;
import Orderdto.SideOrderDTO;
import dto.ReceiptDTO;
import javafx.scene.Parent;

public interface OrderDBService {
	public void setRoot(Parent root);
	public int saveDTO(ReceiptDTO dto);
	public int saveBurgerDTO(BurgerOrderDTO burgerDTO);
	public int saveSideDTO(SideOrderDTO sideDTO);
	public int saveBeverageDTO(BeverageOrderDTO beverageDTO);
	public BurgerOrderDTO readDTO();
	public void readMenu();
}
