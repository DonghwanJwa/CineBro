package com.movie.UI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;

import com.movie.frame.SignUP;
import com.movie.main.AppManager;

public class MyActionListener {
	MainUI mainUi=new MainUI();
	LoginPage loginP;
	SignUP SignUp;
	LoginActionL logL=new LoginActionL();
	MainActionL mainL=new MainActionL();
	
	public MyActionListener() {
		AppManager.getInstance().setMyListener(this);
	}//cons MyActionListener()
	
	class LoginActionL implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj=e.getSource();
			if(obj==loginP.login) {
				if(loginP.idField.getText().equals("")) {
					loginP.error.setText("아이디를 입력해주세요!");
					loginP.idField.requestFocus();
					loginP.idField.setBorder(BorderFactory.createLineBorder(Color.RED,2)); // 외곽선 설정 오류시 붉은선
					loginP.passwordField.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // 정상작동시 검은선
				}else {
					/* 비밀번호를 적지 않았을 때 */
					if(loginP.passwordField.getText().equals("")) {
						loginP.error.setText("비밀번호를 입력해주세요!");
						loginP.passwordField.requestFocus();
						loginP.passwordField.setBorder(BorderFactory.createLineBorder(Color.RED,2));
						loginP.idField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
					}else {
						/* 확인 이벤트 */
						if(loginP.idField.getText().equals("abcd") && loginP.passwordField.getText().equals("abcd")) { 
							// idField와 passwordField에 정확한 id와 password가 적혔을때
							loginP.error.setText(""); // error문구 없음
							loginP.idField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
							loginP.passwordField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
							/* 로그인 됐을때 실행할 문장 */
							
						}else { // 정확하지 않은 id가 적혔을때
							loginP.error.setText("아이디 또는 비밀번호를 잘못 입력하셨습니다!"); // error문구 출력
							loginP.idField.setBorder(BorderFactory.createLineBorder(Color.RED,2)); // idFeild 테두리색 변경
							loginP.idField.requestFocus(); // 포커스를 idField에 둠
							loginP.passwordField.setBorder(BorderFactory.createLineBorder(Color.RED,2)); // passwordField 테두리색 변경
						}// 아이디,비밀번호 오입력시 
					}// 비밀번호 미입력시
				}// 아이디 미입력시
			}// 로그인버튼 클릭시
		}//aP()
	}// LoginActionL inner class
	class MainActionL implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj=e.getSource();
			if(obj==mainUi.homeB) {
				mainUi.homeB.setBackground(Color.RED); // 버튼클릭시 클릭한 버튼 배경색 변경
				mainUi.movieB.setBackground(Color.GRAY.brighter());
				mainUi.reservB.setBackground(Color.GRAY.brighter());
				mainUi.checkB.setBackground(Color.GRAY.brighter());
				mainUi.myPageB.setBackground(Color.GRAY.brighter());
				mainUi.card.show(mainUi.mainC,"homeB"); // "homeB"키가 적용된 카드레이아웃 보여줌

			}//if
			if(obj==mainUi.movieB){
				mainUi.homeB.setBackground(Color.GRAY.brighter());
				mainUi.movieB.setBackground(Color.RED);
				mainUi.reservB.setBackground(Color.GRAY.brighter());
				mainUi.checkB.setBackground(Color.GRAY.brighter());
				mainUi.myPageB.setBackground(Color.GRAY.brighter());
				mainUi.card.show(mainUi.mainC,"movieB");
			}//if
			if(obj==mainUi.reservB) {
				mainUi.homeB.setBackground(Color.GRAY.brighter());
				mainUi.movieB.setBackground(Color.GRAY.brighter());
				mainUi.reservB.setBackground(Color.RED);
				mainUi.checkB.setBackground(Color.GRAY.brighter());
				mainUi.myPageB.setBackground(Color.GRAY.brighter());
				mainUi.card.show(mainUi.mainC,"reservB");
			}//if
			if(obj==mainUi.checkB) {
				mainUi.homeB.setBackground(Color.GRAY.brighter());
				mainUi.movieB.setBackground(Color.GRAY.brighter());
				mainUi.reservB.setBackground(Color.GRAY.brighter());
				mainUi.checkB.setBackground(Color.RED);
				mainUi.myPageB.setBackground(Color.GRAY.brighter());
				mainUi.card.show(mainUi.mainC,"checkB");
			}//if
			if(obj==mainUi.myPageB) {
				mainUi.homeB.setBackground(Color.GRAY.brighter());
				mainUi.movieB.setBackground(Color.GRAY.brighter());
				mainUi.reservB.setBackground(Color.GRAY.brighter());
				mainUi.checkB.setBackground(Color.GRAY.brighter());
				mainUi.myPageB.setBackground(Color.RED);
				mainUi.card.show(mainUi.mainC,"myPageB");
			}else if(obj==mainUi.loginB) {
				new LoginPage();
			}else if(obj==mainUi.registB) {
				new SignUP();
			}
		}		
	}
	public void loginListenerSet() {
		loginP.addLoginListener(logL);
	}
	public void mainListenerSet() {
		mainUi.addMainListener(mainL);
	}
}//MyActionListener class
