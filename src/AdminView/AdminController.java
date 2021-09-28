package AdminView;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class AdminController implements Initializable {

	Parent root;
	AdminService as = new AdminService();

	public void setRoot(Parent root) {
		this.root = root;
		as.setSRoot(root);
	}

	public void loginAdmin() {   // 로그인 버튼 클릭 -> 관리자 아이디 비번 검증 
		as.loginAdmin();
	}

	public void keyboardId() {  // 관리자 아이디(ADMIN) 텍스트필드 선택 
		as.keyboardId();
	}

	public void keyboardPw() {  // 패스워드 텍스트필드 선택 
		as.keyboardPw();
	}
 
	public void keyboardNum() {   //  키보드 맨 윗줄 숫자로 변경 
		as.keyboardNum();
}

	public void keyboardCap() {   //  키보드 대문자로 변경 
		as.keyboardCap();
	}

	public void keyboard(ActionEvent event) {   //키보드 클릭 시 값이 텍스트필드에 입력됨 
		as.keyboard(event);
	}

	public void deleteLetter() {    // 텍스트필드 값 삭제 del 
		as.deleteLetter();		
	}

	public void setPowerOff() {    //  로고 버튼 클릭 시 프로그램 종료  
		as.powerOff();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {

	}

}
