package com.movie.UI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;

import com.movie.main.AppManager;

public class MyActionListener {
	MainUI mainUi=new MainUI();
	LoginPage loginP;
	SignUpFrame signUp;
	FindIDPassFrame findF;
	LoginActionL logL=new LoginActionL();
	MainActionL mainL=new MainActionL();
	SignupActionL signupL=new SignupActionL();
	FindActionL findL=new FindActionL();

	public MyActionListener() {
		AppManager.getInstance().setMyListener(this);
	}//cons MyActionListener()
	
	class SignupActionL implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==signUp.check_idB) {
				if((signUp.idTF.getText().length()<6 || signUp.idTF.getText().length()>16) || 
						!(Pattern.matches("^[a-z]+[a-z0-9]*$",signUp.idTF.getText()))) {
					signUp.error_idL.setText("아이디는 영문소문자로 시작하는 6~16자리 영문 소문자와 숫자로만 입력하세요!");
					return;
				}else {//아이디 경고문 출력
					/**DB에서 id search=>비교 if절 추가해야됨**/		
					signUp.check_idB.setEnabled(false);
					return;
				}
			}//아이디 중복체크 버튼 선택시

			if(e.getSource()==signUp.check_emailB) {
				return;
			}//이메일 인증번호 버튼 선택시

			if(e.getSource()==signUp.confirmB) {
				signUp.error_idL.setText("");   //회원가입 버튼 선택시 경고문 초기화
				signUp.error_passL.setText("");
				signUp.error_nameL.setText("");
				signUp.error_birthL.setText("");
				signUp.error_emailL.setText("");
				
				if(signUp.check_idB.isEnabled()==true) { //중복검색 안했을때(버튼 활성화되어있을때)
					signUp.error_idL.setText("아이디를 입력한 후 중복확인을 해주세요!");
					signUp.idTF.requestFocus();
					return;
				}//아이디 중복검색 버튼 안눌렀을 때
				
				if(signUp.passPF.getText().length()<6 || signUp.passPF.getText().length()>16 || 
						!(Pattern.matches("^[a-z0-9]*$",signUp.passPF.getText()))) {
					signUp.error_passL.setText("비밀번호는 6~16사이 영문소문자와 숫자로만 입력하세요!");
					signUp.passPF.setText("");
					signUp.passrePF.setText("");
					signUp.passPF.requestFocus();
					return;
				}//비밀번호 입력값이 올바르지 않을 때
				
				if(!signUp.passPF.getText().equals(signUp.passrePF.getText())) {
					signUp.error_passL.setText("두 비밀번호가 일치하지 않습니다!");
					signUp.passPF.setText(""); 
					signUp.passrePF.setText("");
					signUp.passPF.requestFocus();
					return;
				}//비밀번호 입력값과 재입력값이 다른경우
				
				if(signUp.nameTF.getText().trim().equals("")) {
					signUp.error_nameL.setText("이름을 입력하세요!");
					signUp.nameTF.requestFocus();
					return;
				}//이름란이 공백일 때
				
				if(signUp.yearTF.getText().trim().equals("") || signUp.monthTF.getText().trim().equals("") ||
						signUp.dateTF.getText().trim().equals("") ||                     //생년월일에 공백이 있을 때 
						(!(Pattern.matches("^[0-9]*$", signUp.yearTF.getText()))) ||     //연 텍스트필드에 숫자가 아닌것이 있을때
						(!(Pattern.matches("^[0-9]*$", signUp.monthTF.getText()))) ||    //월 텍스트필드에 숫자가 아닌것이 있을때
						(!(Pattern.matches("^[0-9]*$", signUp.dateTF.getText())))) {     //일 텍스트필드에 숫자가 아닌것이 있을때
					signUp.error_birthL.setText("생년월일을 정확히 입력해 주세요!");
					signUp.yearTF.requestFocus();
					return;
				}//생년월일 란에 문제가 있을 때
				
				if(signUp.emailTF.getText().trim().equals("")) {
					signUp.error_emailL.setText("이메일을 입력하세요!");
					signUp.emailTF.requestFocus();
					return;
				}//이메일 란이 공백일 때
			
				signUp.dialog.showMessageDialog(signUp, "회원가입이 되셨습니다!", "안내", signUp.dialog.CLOSED_OPTION);
				signUp.dispose();
			}//가입하기 버튼 눌렀을 때
			
		}//aP()
	}//SignupActionL inner class
	
	class FindActionL implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==findF.find_idB) {
				findF.find_idB.setBackground(Color.RED);            //상단의 버튼 색 변경
				findF.find_passB.setBackground(Color.WHITE);			
				findF.name_idTF.setText("");					     //텍스트필드 비움
				findF.email_idTF.setText("");
				findF.name_idTF.requestFocus();                    //텍스트 커서(깜빡이)를 성함입력창에 둠
				findF.cardlayout.show(findF.card_backgroundP,"find_idB"); //아이디찾기 버튼 클릭 시 아이디 찾기 패널로 전환
			}//좌측상단 아이디찾기 버튼 클릭 시
			
			if(e.getSource()==findF.find_passB) {
				findF.find_idB.setBackground(Color.WHITE);          //상단의 버튼 색 변경
				findF.find_passB.setBackground(Color.RED);
				findF.cardlayout.show(findF.card_backgroundP,"find_passB");//비밀번호 찾기 버튼 클릭 시 비밀번호 찾기 패널로 전환
			}//좌측상단 비밀번호찾기 버튼 클릭 시
			
			/*아이디 찾기 패널의 액션*/
			if(e.getSource()==findF.confirm_idB) {
				/**아이디 찾기 중 : 입력된 아이디,이메일과 DB의 아이디,이메일 같은지 비교하여, 같으면 페이지 넘어가기 활성**/
				/**            이후, DB에서 지정된 ID값을 가져와 라벨에 출력**/
				if((findF.name_idTF.getText().trim().equals("")) ||   //텍스트필드가 비어있을 때
						(findF.email_idTF.getText().trim().equals(""))) {
					findF.error_idL.setText("정보가 입력되지 않았습니다.");    //경고문 출력
				}else {
					findF.error_idL.setText("");                        //경고문 지우기
					findF.show_nameL.setText("이름 DB에서 가져온 님 의 아이디는"); //결과 창 내용 기입
					findF.show_idL.setText("\"아이디 DB에서 가저옴\" 입니다");
					findF.cardlayout.show(findF.find_idP,"confirm_idB"); //결과 패널로 전환
				}
			}//아이디 찾기 패널(정보입력란)에서 확인 버튼 클릭 시
			
			if(e.getSource()==findF.back_closeidB) {
				findF.dispose();
			}//아이디 찾기 패널(아이디확인란)에서 돌아가기 버튼 클릭 시
			
			/*비밀번호 찾기 패널의 액션*/
			if(e.getSource()==findF.confirm_passB) {
				if((findF.id_passTF.getText().trim().equals("")) ||        //텍스트 필드가 비어있을 때
						(findF.name_passTF.getText().trim().equals("")) ||
						(findF.email_passTF.getText().trim().equals(""))) {
					findF.error_passL.setText("입력된 정보가 올바르지 않습니다.");    //경고문 출력
				}else { 												  //올바르게 정보가 입력되었을 때
					findF.error_passL.setText("");                          //경고문 지우기
					findF.cardlayout.show(findF.find_passP,"confirm_passB");//비밀번호 재입력 패널로 이동
				}
			}//비밀번호 찾기 패널(정보입력란)에서 확인 버튼 클릭 시
			
			if(e.getSource()==findF.update_passB) {
				if((findF.pass_PF.getText().length()<6 || findF.passre_PF.getText().length()>16) ||
						!(Pattern.matches("^[a-z0-9]*$", findF.pass_PF.getText()))) {
					findF.wrong_passL.setText("비밀번호는 6~16사이 영문소문자와 숫자로만 입력하세요.");  //경고문 출력
					findF.pass_PF.setText("");
					findF.passre_PF.setText("");
					findF.requestFocus();
				}else if(!(findF.pass_PF.getText().equals(findF.passre_PF.getText()))) {//두개의 패스워드 필드값이 서로 다를때
					findF.wrong_passL.setText("비밀번호가 일치하지 않습니다.");   //경고문 출력
					findF.pass_PF.setText("");
					findF.passre_PF.setText("");
					findF.requestFocus();
				}else {                                                  //올바르게 정보가 입력되었을 때
					findF.wrong_passL.setText("");          			 //경고문 지우기
					findF. pass_updateD.showMessageDialog(findF, "비밀번호가 변경 되었습니다.", "안내", findF.pass_updateD.CLOSED_OPTION);
					//비밀번호가 제대로 변경되었다는 알림문 다이어로그 출력
					findF.dispose();    //닫기
				}
			}//비밀번호 재입력 패널에서 확인 버튼 클릭 시
		}//aP()
	}//FindActionL inner class
	
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
			if(obj==loginP.addMem) {
				signUp = new SignUpFrame();
				signupListenerSet();
			}// 회원가입버튼 클릭시
			if(obj==loginP.find) {
				findF = new FindIDPassFrame();
				findListenerSet();
			}
		}//aP()
	}// LoginActionL inner class
	class MainActionL implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj=e.getSource(); // obj에 컴포넌트 가져옴
			/* 각 버튼 탭 클릭이벤트 */
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
				loginP = new LoginPage();
				loginListenerSet();
			}else if(obj==mainUi.registB) {
				signUp = new SignUpFrame();
				signupListenerSet();
			}// 메인페이지 로그인버튼/회원가입 버튼 선택 이벤트
		}//ap()
	}// MainActionL class
	
	public void loginListenerSet() {
		loginP.addLoginListener(logL);
	}
	public void mainListenerSet() {
		mainUi.addMainListener(mainL);
	}
	public void signupListenerSet() {
		signUp.addSignupListener(signupL);
	}
	public void findListenerSet() {
		findF.addFindListener(findL);
	}
}//MyActionListener class
