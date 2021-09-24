package page4_receipt;

import java.io.IOException;

import dto.ReceiptDTO;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ReceiptMain {
	public void receiptMain(Parent cPRoot) {
		Stage primaryStage = (Stage)cPRoot.getScene().getWindow();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("receipt.fxml"));
		Parent rcRoot = null;
		try {
			rcRoot = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		ReceiptController ct1 = loader.getController();
		ct1.setRoot(rcRoot);
		
		Scene scene = new Scene(rcRoot);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
