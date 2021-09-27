package Admin;

import java.io.IOException;

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

	Parent root;
	TextField resultId;  //텍스트값 반영 데이터비교시 사용
	TextField resultPw; //텍스트값 반영  데이터비교시 사용
	String textId;  
	String textPw;  
	String keyId;
	String keyPw;
	int a;
	int capBtn = 0;     //cap값 변환
	int i = 1;
	int clickNum = 0;   //숫자값 변환
	int del = 0;
	static  String id ="ADmin123";      //id(고정값)
	 static  String pwd="PASSword";      //pwd(고정값)
	public void setSRoot(Parent root) {
		this.root = root;
	}
	
	public void loginAdmin() { 	
		System.out.println("입력한 관리자 아이디:"+textId);   
		System.out.println("입력한 비밀번호:"+textPw);       
		if(textId == null || textId.length() <= 0) { 
			alert("ADMIN을 입력하세요!");
		} else if(textPw == null || textPw.length() <= 0) {
			alert("Password를 입력하세요!");
		}else if(textId.equals(id) &&textPw.equals(pwd)){
					System.out.println("로그인 성공");   //아이디와 비번이 일치할때
					next();                            //다음 페이지 실행
		}else {
			alert("아이디나 비밀번호가 틀립니다");       //아이디나 비번이 틀렸을경우 경고창 출력
			System.out.println("아이디나 비밀번호가 틀립니다");
		}
	}
	
	public void next() {
		FXMLLoader loader=new FXMLLoader(getClass().getResource("/testview/eventTest.fxml")); //아이디하고 비번이 일치할 경우 실행됨
		Parent main=null;
		try {
			main=loader.load();
		}catch(Exception e){
			e.printStackTrace();
		}
		Controller con=loader.getController();
		con.setRoot(main);
		
		Scene scene=new Scene(main);
		Stage s=(Stage)root.getScene().getWindow();
		s.setScene(scene);
		s.show();
		
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
		clickNum++;  //키보드 클릭할 경우 반응

		for (i = 1; i <= 10; i++) {
			if (clickNum == 1 || clickNum % 2 != 0) {
				Button cap = (Button) root.lookup("#fxId" + i); //숫자값 반환
				if (i == 10) {
					cap.setText(0 + "");
				} else {
					cap.setText(i + "");
				}
			} else {
				String [] list = {"","q","w","e","r","t","y","u","i","o","p"}; //해당키보드를 문자로 다시 반환				
				Button cap = (Button) root.lookup("#fxId" + i);
				cap.setText(list[i]);
			}
		}
	}
	
	public void keyboard(ActionEvent event) {
		if (a == 1) {
			keyId = ((Button) event.getSource()).getText();  //id값 텍스트필드에 문자로 반환
			resultId = ((TextField) root.lookup("#resultId"));
			textId = resultId.getText() + keyId;
			resultId.setText(textId);
		} else {
			keyPw = ((Button) event.getSource()).getText(); //pw값 텍스드필드에 문자로 반환
			resultPw = ((TextField) root.lookup("#resultPw"));
			textPw = resultPw.getText() + keyPw;
			resultPw.setText(textPw);
		}   
	}
	
	public void keyboardCap() {
		capBtn++; 
		if (capBtn == 1 || capBtn % 2 != 0) {
			for (i = 1; i <= 27; i++) {
				Button cap = (Button) root.lookup("#fxId" + i); //클릭한경우 대문자로 변환
				cap.setText(cap.getText().toUpperCase());
			}
		} else {
			for (i = 1; i <= 27; i++) {
				Button cap = (Button) root.lookup("#fxId" + i); //소문자 반환
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
		System.out.println("power off ");  //로그인창 off
		Stage s = (Stage)root.getScene().getWindow();
		s.close();
	}
	
	private void alert(String msg) {
		Alert alert  = new Alert(AlertType.CONFIRMATION);
		alert.setContentText(msg);
		alert.show();
	}
	
}
