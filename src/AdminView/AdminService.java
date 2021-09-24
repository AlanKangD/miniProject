package AdminView;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import testview.Controller;

public class AdminService extends ActionEvent {

<<<<<<< HEAD:src/miniProject/AdminService.java
	
=======

	static String adminId = "ADmin123";
	static String adminPw= "PASSword";
>>>>>>> 2e19405ddb4b5253d0f6805438ecbdeafce3cec2:src/AdminView/AdminService.java
	Parent root;
	TextField resultId, resultPw;
	String textId, textPw, keyId, keyPw;
	int a = 1;
	int capBtn = 0, clickNum = 0, del = 0;
	int i = 1;
	
	public void setSRoot(Parent root) {
		this.root = root;
	}
	
	public void loginAdmin() { 	
		System.out.println("입력한 관리자 아이디 : " + textId);
		System.out.println("입력한 비밀번호 : " + textPw);		
		
		if(textId == null || textId.length() <= 0) {
			alert("ADMIN을 입력하세요!");
		} else if(textPw == null || textPw.length() <= 0) {
			alert("Password를 입력하세요!");
		} else if(textId.equals(adminId)) {
			if(textPw.equals(adminPw)) {
				nextScene();  // 여기에 다음 씬 넣어주기 
			}else {
				alert("비밀번호가 일치하지 않습니다.");
			}
		} else {
			alert("아이디가 일치하지 않습니다.");
		}
	}
	
	public void keyboardId() {
		System.out.println("스크린 아이디 터치 ");
		a=1;
	}
	
	public void keyboardPw() {
		System.out.println("스크린 비밀번호 터치 ");
		a=2;
	}
		
	public void keyboardNum() {
		clickNum++;

		for (i = 1; i <= 10; i++) {
			if (clickNum == 1 || clickNum % 2 != 0) {
				Button cap = (Button) root.lookup("#fxId" + i);
				if (i == 10) {
					cap.setText(0 + "");
				} else {
					cap.setText(i + "");
				}
			} else {
				String [] list = {"","q","w","e","r","t","y","u","i","o","p"};				
				Button cap = (Button) root.lookup("#fxId" + i);
				cap.setText(list[i]);
			}
		}
	}
	
	public void keyboard(ActionEvent event) {
		if (a == 1) {
			keyId = ((Button) event.getSource()).getText();
			resultId = ((TextField) root.lookup("#resultId"));
			textId = resultId.getText() + keyId;
			resultId.setText(textId);
		} else {
			keyPw = ((Button) event.getSource()).getText();
			resultPw = ((TextField) root.lookup("#resultPw"));
			textPw = resultPw.getText() + keyPw;
			resultPw.setText(textPw);
		}   
	}
	
	public void keyboardCap() {
		capBtn++;
		if (capBtn == 1 || capBtn % 2 != 0) {
			for (i = 1; i <= 27; i++) {
				Button cap = (Button) root.lookup("#fxId" + i);
				cap.setText(cap.getText().toUpperCase());
			}
		} else {
			for (i = 1; i <= 27; i++) {
				Button cap = (Button) root.lookup("#fxId" + i);
				cap.setText(cap.getText().toLowerCase());
			}
		}
	}
	
	public void deleteLetter() {
		if (a == 1) {
			int d = resultId.getLength(); // resultId의 총 길이를 구한 뒤
			System.out.println(resultId.getLength());
			if(d <=0) {
				alert("ADMIN을 입력하세요");
				} else {
					resultId.deleteText((d - 1), d); // i-1 이상 i 미만 만큼 텍스트를 제거해준다
					textId = resultId.getText();
			}	
		} else {
			int j = resultPw.getLength();
			System.out.println(resultPw.getLength());
			if(j <= 0) {
				alert("PASSWORD를 입력하세요");
				}else {
					resultPw.deleteText((j - 1), j);
					textPw = resultPw.getText();
				}			
		}
	}	
	
	public void powerOff() {
		System.out.println("power off ");
		Stage s = (Stage)root.getScene().getWindow();
		s.close();
	}
	
	private void alert(String msg) {
		Alert alert  = new Alert(AlertType.CONFIRMATION);
		alert.setContentText(msg);
		alert.show();
	}
	
	
	public void nextScene() {
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/testview/eventTest.fxml"));
		Parent mainRoot = null;
				try {
					
					mainRoot = loader.load(); 
				} catch (Exception e) {
					e.printStackTrace();			
				}
				
				Controller ctl = loader.getController();
				ctl.setRoot(mainRoot);
				
				Scene scene = new Scene(mainRoot);
				Stage s = (Stage)root.getScene().getWindow();
				s.setScene(scene);   
				s.show();
				
		
		
	}
}
