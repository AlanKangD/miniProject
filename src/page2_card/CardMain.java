package page2_card;

import java.io.IOException;

import dto.ReceiptDTO;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CardMain {
	public void cardMain(Parent root) {
		Stage primaryStage = (Stage)root.getScene().getWindow();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("card.fxml"));
		Parent cardRoot = null;
		try {
			cardRoot = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		CardController ct1 = loader.getController();
		ct1.setRoot(cardRoot);
		
		Scene scene = new Scene(cardRoot);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
