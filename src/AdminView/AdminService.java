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

	static String adminId = "ADmin123";  // 관리자 로그인 아이디 
	static String adminPw= "PASSword";  // 비밀번호 
	Parent root;  
	TextField resultId, resultPw;  // 텍스트필드에 담겨지는 값들을 화면으로 보여줌 (UI화면)
	String textId, textPw;  //  텍스트필드 값 + 키보드 값  === 데이터 비교 시 사용될 값 
	String keyId, keyPw; // 키보드 각각의 문자 값 
	int a = 1;  // 아이디(ADMIN) 텍스트필드 선택 시
	int capBtn = 0, clickNum = 0; //  클릭 시 대소문자 변경 ,  클릭 시 문자-숫자 변경 
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
				nextScene();  // 두번째 페이지로 이동  
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
		clickNum++;   // 클릭할 때마다 숫자&문자 변경 

		for (i = 1; i <= 10; i++) {
			if (clickNum == 1 || clickNum % 2 != 0) {
				Button num = (Button) root.lookup("#fxId" + i); // Button num = 키보드의 123 버튼
				if (i == 10) {
					num.setText(0 + "");
				} else {
					num.setText(i + "");
				}
			} else {  
				String [] list = {"","q","w","e","r","t","y","u","i","o","p"}; //맨 윗줄만 다시 문자로 변경 				
				Button num = (Button) root.lookup("#fxId" + i);
				num.setText(list[i]);
			}
		}
	}
	
	public void keyboard(ActionEvent event) {
		if (a == 1) {
			keyId = ((Button) event.getSource()).getText(); //클릭 시  키보드에 입력되어있는 '값' 가져오기 
			resultId = ((TextField) root.lookup("#resultId"));  // 텍스트필드에 담겨지는 값들 화면에 보여주기 
			textId = resultId.getText() + keyId; // 텍스트필드에 담겨있는 값  + 키보드 누르면 추가되는 값 
			resultId.setText(textId); // 텍스트필드에 (바로)위 데이터를 가져와 보여준다 . 
		} else {
			keyPw = ((Button) event.getSource()).getText();
			resultPw = ((TextField) root.lookup("#resultPw"));
			textPw = resultPw.getText() + keyPw;
			resultPw.setText(textPw);
		}   
	}
	
	public void keyboardCap() {  
		capBtn++;  // 클릭할 때마다 대소문자로 변경 
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
			if(d <=0) {  // 입력된 값이 없을 때 
				alert("ADMIN을 입력하세요");
				} else {
					resultId.deleteText((d - 1), d); // d-1 이상 d 미만 텍스트를 제거해준다 
					textId = resultId.getText();
			}	
		} else {
			int d = resultPw.getLength();
			System.out.println(resultPw.getLength());
			if(d<= 0) {
				alert("PASSWORD를 입력하세요");
				}else {
					resultPw.deleteText((d- 1), d);
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
