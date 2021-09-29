package cardPut;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import resultDTO.ReceiptDTO;

public class CPMain {	// '카드를 넣어주세요'페이지의 메인클래스
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
