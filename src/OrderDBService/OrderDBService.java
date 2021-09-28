package OrderDBService;

import Orderdto.BeverageOrderDTO;
import Orderdto.BurgerOrderDTO;
import Orderdto.SideOrderDTO;
import javafx.scene.Parent;

public interface OrderDBService {
	public void setRoot(Parent root);
	public int saveBurgerDTO(BurgerOrderDTO burgerDTO);
	public int saveSideDTO(SideOrderDTO sideDTO);
	public int saveBeverageDTO(BeverageOrderDTO beverageDTO);
	public BurgerOrderDTO readBurgerDTO();
	public int TotalOrderDTO(BurgerOrderDTO burgerDTO, SideOrderDTO sideDTO, BeverageOrderDTO beverageDTO);
}
