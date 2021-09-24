package page3_receipt;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ReceiptMain {
	public void receiptMain(Parent cardRoot) {
		Stage primaryStage = (Stage)cardRoot.getScene().getWindow();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("receipt.fxml"));
		Parent rcRoot = null;
		try {
			rcRoot = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		CardController ct1 = loader.getController();
//		ct1.setRoot(cardRoot);
		
		Scene scene = new Scene(rcRoot);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
