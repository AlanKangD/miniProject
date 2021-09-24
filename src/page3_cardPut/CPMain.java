package page3_cardPut;

import java.io.IOException;

import dto.ReceiptDTO;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CPMain {
	public void cpMain(Parent cardRoot) {
		Stage primaryStage = (Stage)cardRoot.getScene().getWindow();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("cardPut.fxml"));
		Parent cpRoot = null;
		try {
			cpRoot = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		CPController ct1 = loader.getController();
		ct1.setRoot(cpRoot);
		
		Scene scene = new Scene(cpRoot);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
