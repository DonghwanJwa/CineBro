package com.movie.UI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;

import com.movie.DAO.BookingDAO;
import com.movie.DAO.DAOManager;
import com.movie.DAO.MemberDAO;
import com.movie.DAO.MovieDAO;
import com.movie.DAO.MovieNowDAO;
import com.movie.VO.BookedseatVO;
import com.movie.VO.BookingVO;
import com.movie.VO.CinemaVO;
import com.movie.VO.DataManager;
import com.movie.VO.DayseatVO;
import com.movie.VO.MemberVO;
import com.movie.VO.MovieNowVO;
import com.movie.VO.MovieVO;
import com.movie.VO.MovietimeVO;
import com.movie.VO.SeatVO;
import com.movie.main.AppManager;

public class MyActionListener {
	/* 동환 코멘트 20190810
	 * MyActionListener를 MainClass에서 객체를 생성하고, MainUI를 호출하여 첫 화면(frame)을 보여주는데,
	 * 이 때 MainUI내에서 필요한 DB구동 객체들(DataManager,DAOManager,VO들,DAO들)을 MyActionLisitener에서 생성해야
	 * MainUI내에서 필요한 정보들을 DB로부터 가져올수 있게 된다.
	 * (DAO,VO객체를 미리 생성하지 않았기 때문에 영화정보를 불러올때마다 NullPointerException 오류가 나타난것임)
	 */
	DataManager dataManager = new DataManager();	
	DAOManager daoManager = new DAOManager();		
	MovieVO movievo = new MovieVO();				
	MovieDAO moviedao = new MovieDAO();
	MovieNowVO movienowvo= new MovieNowVO();
	MovieNowDAO movienowdao= new MovieNowDAO();
	MemberVO membervo = new MemberVO();
	MemberDAO memberdao = new MemberDAO();
	CinemaVO cinemavo = new CinemaVO();
	SeatVO seatvo = new SeatVO();
	MovietimeVO movietimevo = new MovietimeVO();
	DayseatVO dayseatvo = new DayseatVO();
	BookingVO bookingvo = new BookingVO();
	BookingDAO bookingDAO = new BookingDAO();
	BookedseatVO bookedseatvo = new BookedseatVO();
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

	class SignupActionL implements ActionListener,FocusListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == signUp.check_idB) {
				if ((signUp.idTF.getText().length() < 6 
						|| signUp.idTF.getText().length() > 16)
						|| !(Pattern.matches("^[a-z]+[a-z0-9]*$", signUp.idTF.getText()))) {
					signUp.error_idL.setText("아이디는 영문소문자로 시작하는 6~16자리 영문 소문자와 숫자로만 입력하세요!");
					return;
				} else { // 아이디 경고문 출력
					if (memberdao.selectIdcheck(signUp.idTF.getText()) == 1) {
						signUp.dialog.showMessageDialog(null, "중복된 아이디입니다", "안내", signUp.dialog.CLOSED_OPTION);
					} else if (memberdao.selectIdcheck(signUp.idTF.getText()) == 0) {
						signUp.dialog.showMessageDialog(null, "사용가능한 아이디입니다", "안내", signUp.dialog.CLOSED_OPTION);
						signUp.error_idL.setText("");		// setEnabeld true이면 기능이 동작하고 false면 기능이 동작하지 않는다
						signUp.check_idB.setEnabled(false); // 컴포넌트기능을 가능하게 하는지 여부를 결정해주는 메서드
						signUp.passPF.requestFocus();
					} // 아이디 비교함
					return;
				}
			} // 아이디 중복체크 버튼 선택시

			if (e.getSource() == signUp.check_emailB) {
				if (!(Pattern.matches("^[a-zA-Z0-9]*$", signUp.emailTF.getText()))
						||signUp.emailTF.getText().trim().equals("")) {					
					signUp.error_emailL.setText("이메일은 영문 소문자,대문자, 숫자로만 입력해주세요!");
					signUp.emailTF.setText("");			//이메일 텍스트필드 비움
					signUp.emailDoTF.setText("");		//이메일 도메인 텍스트필드 비움
					signUp.emailC.setSelectedIndex(0);	//이메일 도메인 콤보박스 초기화
					signUp.emailTF.requestFocus();
					return;
				} // 이메일 제약조건 : 영문소문자와 숫자로만 입력하게 만듬
				
				if(memberdao.selectEmailcheck(signUp.emailTF.getText()+"@"+signUp.emailDoTF.getText())==1){
					signUp.error_emailL.setText("사용중인 이메일 입니다!");
					signUp.emailTF.setText("");			//이메일 텍스트필드 비움
					signUp.emailDoTF.setText("");		//이메일 도메인 텍스트필드 비움
					signUp.emailC.setSelectedIndex(0);	//이메일 도메인 콤보박스 초기화
					signUp.emailTF.requestFocus();
					return;
				} // 이메일 제약조건 : 이메일 중복 확인 
				
				signUp.security = memberdao.randomAuthNum();
				String email = signUp.emailTF.getText()+"@"+signUp.emailDoTF.getText();
				memberdao.Auth_Email(email, signUp.security);
				signUp.dialog.showMessageDialog(null, "인증번호가 해당 이메일로 발송되었습니다.");
				signUp.error_emailL.setText("");			//오류 메세지 제거
				signUp.secu_codeTF.setEnabled(true);		//인증번호 텍스트 필드 활성화
				signUp.check_emailB.setVisible(false);		//이메일 인증번호 받기 버튼 숨기기
				signUp.confirm_emailB.setEnabled(true);		//이메일 인증번호 확인 버튼 활성화
				signUp.confirm_emailB.setVisible(true);		//이메일 인증번호 확인 버튼 보이기
				signUp.secu_codeTF.requestFocus();			//인증번호 텍스트 필드로 포커스 이동
			}//이메일 인증번호 받기 버튼 클릭시

			if(e.getSource() == signUp.confirm_emailB) {
				if(signUp.security.equals(signUp.secu_codeTF.getText())) {
					signUp.dialog.showMessageDialog(null, "인증번호가 확인되었습니다.");
					signUp.error_emailL.setText("");				//오류 메세지 제거
					signUp.security=null;							//인증번호 비우기(초기화)
					signUp.secu_count=0;							//인증 실패 카운트 초기화
					signUp.secu_codeTF.setText("");					//인증번호 텍스트 필드 초기화
					signUp.secu_codeTF.setEnabled(false);			//인증번호 텍스트 필드 비활성화
					signUp.check_emailB.setEnabled(false);			//이메일 인증번호 받기 버튼 비활성화
					signUp.check_emailB.setVisible(true);			//이메일 인증번호 받기 버튼 보이기
					signUp.confirm_emailB.setEnabled(false);		//이메일 인증번호 확인 버튼 비활성화
					signUp.confirm_emailB.setVisible(false);		//이메일 인증번호 확인 버튼 숨기기
					signUp.confirmB.requestFocus();					//가입하기 버튼으로 포커스 이동
				}else {
					signUp.error_emailL.setText("인증번호를 잘못 입력하셨습니다!!");
					signUp.secu_codeTF.setText("");
					signUp.secu_codeTF.requestFocus();
					signUp.secu_count+=1;
					if(signUp.secu_count==3) {
						signUp.dialog.showMessageDialog(null, "인증번호 입력이 3회 틀리셨습니다. 다시 인증번호를 받아주세요!");
						signUp.error_emailL.setText("");				//오류 메세지 제거
						signUp.security=null;							//인증번호 비우기(초기화)
						signUp.secu_count=0;							//인증 실패 카운트 초기화
						signUp.secu_codeTF.setEnabled(false);			//인증번호 텍스트 필드 비활성화
						signUp.check_emailB.setEnabled(true);			//이메일 인증번호 받기 버튼 활성화
						signUp.check_emailB.setVisible(true);			//이메일 인증번호 받기 버튼 보이기
						signUp.confirm_emailB.setEnabled(false);		//이메일 인증번호 확인 버튼 비활성화
						signUp.confirm_emailB.setVisible(false);		//이메일 인증번호 확인 버튼 숨기기
						signUp.check_emailB.requestFocus();				//이메일 인증번호 받기 버튼으로 포커스 이동
					}//if : 3회이상 틀릴시
				}//if
			}//이메일 인증번호 확인 버튼 클릭시

			if (e.getSource() == signUp.confirmB) {
				signUp.error_idL.setText(""); // 회원가입 버튼 선택시 경고문 초기화
				signUp.error_passL.setText("");
				signUp.error_nameL.setText("");
				signUp.error_birthL.setText("");
				signUp.error_emailL.setText("");

				if (signUp.check_idB.isEnabled() == true) { // 중복검색 안했을때(버튼 활성화되어있을때)
					signUp.error_idL.setText("중복확인을 해주세요");
					signUp.idTF.setText("");
					signUp.idTF.requestFocus();
					return;
				} // 아이디 제약조건 : 중복검색 안했을때

				if (signUp.passPF.getText().length() < 8 || signUp.passPF.getText().length() > 19
						|| !(Pattern.matches("^[a-z0-9]*$", signUp.passPF.getText()))) {
					signUp.error_passL.setText("비밀번호는 8자 이상, 영문소문자와 숫자로만 입력하세요!");
					signUp.passPF.setText("");
					signUp.passrePF.setText("");
					signUp.passPF.requestFocus();
					return;
				} // 비밀번호 제약조건 : 8자 이상이면서 19자 이하와 영문소문자와 숫자로만 입력하는 조건

				if (!signUp.passPF.getText().equals(signUp.passrePF.getText())) {
					signUp.error_passL.setText("두 비밀번호가 일치하지 않습니다!");
					signUp.passPF.setText("");
					signUp.passrePF.setText("");
					signUp.passPF.requestFocus();
					return;
				} // 비밀번호 확인 제약조건 : 첫번쨰 비밀번호와 비교해서 같은 값인지 확인하는 조건

				if (signUp.nameTF.getText().length() < 1 || signUp.nameTF.getText().length() > 6
						|| !(Pattern.matches("^[가-힣]*$", signUp.nameTF.getText()))) {
					signUp.error_nameL.setText("올바른 입력 값이 아닙니다");
					signUp.nameTF.setText("");
					signUp.nameTF.requestFocus();
					return;
				} // 이름 제약조건 : 이름은 5글자이하만 가능하고 한글만 가능한 제약 조건
				
				if (signUp.yearTF.getText().trim().length() != 4 // 생년월일 중 년이 4자리가 아닐때
						||signUp.monthTF.getText().trim().length() < 1 // 생년월일 중 월이 1자리 이하일 때
						||signUp.monthTF.getText().trim().length() > 2 // 생년월일 중 월이 2자리 초과일 때
						||signUp.dateTF.getText().trim().length() < 1 // 생년월일 중 일이 1자리 이하일 때
						||signUp.dateTF.getText().trim().length() > 2 // 생년월일 중 일이 2자리 초과일 때
						|| Integer.parseInt(signUp.yearTF.getText().trim()) > 2019 // 생년월일 중 년이 2019 이상일 때
						|| Integer.parseInt(signUp.yearTF.getText().trim()) < 1900 // 생년월일 중 년이 1900 이하일 때
						|| Integer.parseInt(signUp.monthTF.getText().trim()) > 12 // 생년월일 중 월이 12 이상일 때
						|| Integer.parseInt(signUp.monthTF.getText().trim()) < 1  // 생년월일 중 월이 1 이하일 때						
						|| Integer.parseInt(signUp.dateTF.getText().trim()) > 31  // 생년월일 중 일이 31 이상일 때						
						|| Integer.parseInt(signUp.dateTF.getText().trim()) < 1  // 생년월일 중 일이 1 이하일 때						
						|| (!(Pattern.matches("^[0-9]*$", signUp.yearTF.getText())))
						|| (!(Pattern.matches("^[0-9]*$", signUp.monthTF.getText())))
						|| (!(Pattern.matches("^[0-9]*$", signUp.dateTF.getText())))) {
					// 일 텍스트필드에 숫자가 아닌것이 있을때
					signUp.error_birthL.setText("생년월일을 정확히 입력해 주세요!");
					signUp.yearTF.setText("");
					signUp.monthTF.setText("");
					signUp.dateTF.setText("");
					signUp.yearTF.requestFocus();
					return;
				} // 생년월일 제약조건 : 매 텍스트필드마다 년은 4자리 이면서 숫자만 ,월은 2자리 숫자만, 일은 2자리 숫자만 제약을 줌
				
				if(signUp.check_emailB.isEnabled()==true) {
					signUp.error_emailL.setText("이메일 인증을 받아주세요!");
					signUp.check_emailB.requestFocus();
					return;
				} // 이메일 제약조건 : 이메일 인증을 받지 않았을 때
				
				membervo.setId(signUp.idTF.getText());
				membervo.setPwd(signUp.passPF.getText());
				membervo.setName(signUp.nameTF.getText());
				membervo.setBirth(signUp.yearTF.getText() + "-" + signUp.monthTF.getText() + "-" + signUp.dateTF.getText());
				membervo.setSex((String) signUp.sexC.getSelectedItem());
				membervo.setEmail(signUp.emailTF.getText() + "@" + signUp.emailDoTF.getText());
				
				if(memberdao.insertMember(membervo)==1) {
					signUp.dialog.showMessageDialog(null, "회원가입이 되셨습니다!", "안내", signUp.dialog.CLOSED_OPTION);
					membervo.resetMemberVO();	//회원가입 후 VO 데이터 초기화
					signUp.dispose();// 회원가입이 안되었을 때 잘못되었다는 메시지 창을 만들어줘야 한다
				}else {
					signUp.dialog.showMessageDialog(null, "오류가 발생했습니다. 다시한번 시도하시기 바랍니다.", "안내", signUp.dialog.CLOSED_OPTION);
					membervo.resetMemberVO();
				}				
			} // 가입하기 버튼 눌렀을 때

			if (e.getSource() == signUp.emailC) {
				String str = (String) signUp.emailC.getSelectedItem();
				signUp.emailDoTF.setText(str);
				signUp.emailDoTF.setEditable(false);
				if (str.equals("직접입력")) {
					signUp.emailDoTF.setText("");
					signUp.emailDoTF.setEditable(true);
					signUp.emailDoTF.requestFocus();
				}
			} // 이메일 콤보박스 선택시
		}// aP()

		@Override
		public void focusGained(FocusEvent e) {
			Object obj = e.getSource();
			if(obj==signUp.idTF) {
				signUp.check_idB.setEnabled(true);		//아이디를 수정하려고 할 때
			}
			if(obj==signUp.emailTF) {
				signUp.check_emailB.setEnabled(true);	//이메일을 수정하려고 할 때
			}
			if(obj==signUp.emailDoTF) {
				signUp.check_emailB.setEnabled(true);
			}
			if(obj==signUp.emailC) {
				signUp.check_emailB.setEnabled(true);
			}		
		}//fG() : 포커스를 얻었을 때

		@Override
		public void focusLost(FocusEvent e) {
		}//fL() : 포커스를 잃었을 떄
	}// SignupActionL inner class

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
				String id = memberdao.FindID(findF.email_idTF.getText(), findF.name_idTF.getText());
				//이메일과 아이디를 기입함 ->id값을 호출 : 정보가 일치하면 id값 가져옴, 정보가 일치하지 않으면  null;
				
				if (findF.name_idTF.getText().length() < 1 || findF.name_idTF.getText().length() > 6
						|| !(Pattern.matches("^[가-힣]*$", findF.name_idTF.getText()))) {
					findF.error_idL.setText("올바른 입력 값이 아닙니다");
					findF.name_idTF.setText("");
					findF.name_idTF.requestFocus();
					return;
				}// 아이디 제약 조건 : 입력값 오류

				if ((findF.name_idTF.getText().trim().equals("")) || // 텍스트필드가 비어있을 때
						(findF.email_idTF.getText().trim().equals(""))) {
					findF.error_idL.setText("정보가 입력되지 않았습니다.");
					findF.email_idTF.setText("");
					findF.email_idTF.requestFocus();
					return;
				}// 아이디 제약 조건 : 입력값 없음
						
				if (id != null) {// 이메일 검증 아이디가 맞고 이메일이 틀렸을때 유효성 검증해주는 기능 눌값을 대체한다
					findF.error_idL.setText(""); 				// 경고문 지우기
					findF.show_nameL.setText("고객님의 아이디는");   // 결과 창 내용 기입
					findF.show_idL.setText(id + " 입니다");
					findF.cardlayout.show(findF.find_idP, "confirm_idB"); // 결과 패널로 전환
				} else if (id == null) {
					findF.error_idL.setText("일치하는 정보가 없습니다.");
					findF.name_idTF.setText("");
					findF.email_idTF.setText("");
					findF.name_idTF.requestFocus();
				}			
			}//아이디 찾기 패널(정보입력란)에서 확인 버튼 클릭 시

			if(e.getSource()==findF.back_closeidB) {
				findF.dispose();
			}//아이디 찾기 패널(아이디확인란)에서 돌아가기 버튼 클릭 시

			/*비밀번호 찾기 패널의 액션*/
			if(e.getSource()==findF.confirm_passB) {
				int re = memberdao.FindPWNAMEEMAILcheck(findF.id_passTF.getText(), findF.name_passTF.getText(),
						findF.email_passTF.getText());

				if ((findF.id_passTF.getText().length() < 6 || findF.id_passTF.getText().length() > 16)
						|| !(Pattern.matches("^[a-z]+[a-z0-9]*$", findF.id_passTF.getText()))) {
					findF.error_passL.setText("올바른 아이디정보가 아닙니다.");
					return;
				}// 아이디 유효성 검증

				if (findF.name_passTF.getText().length() < 1 || findF.name_passTF.getText().length() > 6
						|| !(Pattern.matches("^[가-힣]*$", findF.name_passTF.getText()))) {
					findF.error_passL.setText("올바른 이름정보가 아닙니다.");
					findF.name_passTF.setText("");
					findF.name_passTF.requestFocus();
					return;
				}// 이름 유효성 검증

				if ((findF.email_passTF.getText().trim().equals(""))) { // 텍스트필드가 비어있을
					findF.error_passL.setText("이메일을 입력해 주세요.");
					findF.email_passTF.setText("");
					findF.email_passTF.requestFocus();
					return;
				}// 이메일 유효성 검증

				if (re == 1) {
					findF.error_idL.setText(""); // 경고문 지우기
					findF.cardlayout.show(findF.find_passP, "confirm_passB");// 비밀번호 재입력 패널로 이동
				} else if (re == 0) {
					findF.id_passTF.setText("");
					findF.id_passTF.requestFocus();
					findF.name_passTF.setText("");
					findF.email_passTF.setText("");
					findF.pass_updateD.showMessageDialog(null, "고객님께서 입력하신 정보와 일치하는 정보가 없습니다.", "안내", findF.pass_updateD.CLOSED_OPTION);
				}
				
				
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
				}
				
				if(memberdao.FindPW(findF.pass_PF.getText(),
						findF.id_passTF.getText(),findF.name_passTF.getText(),findF.email_passTF.getText())==1) {
						findF.pass_PF.getText();
						findF.wrong_passL.setText(""); // 경고문 지우기
						findF.pass_updateD.showMessageDialog(null, "비밀번호가 변경 되었습니다.", "안내",findF.pass_updateD.CLOSED_OPTION);
						// 비밀번호가 제대로 변경되었다는 알림문 다이어로그 출력
						findF.dispose(); // 닫기
					}else {
						findF.pass_PF.setText("");
						findF.pass_PF.requestFocus();
						findF.passre_PF.setText("");
						findF.wrong_passL.setText("실행이 되지 않았습니다");						
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
					return;
				}else {
					/* 비밀번호를 적지 않았을 때 */
					if(loginP.passwordField.getText().equals("")) {
						loginP.error.setText("비밀번호를 입력해주세요!");
						loginP.passwordField.requestFocus();
						loginP.passwordField.setBorder(BorderFactory.createLineBorder(Color.RED,2));
						loginP.idField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
					}else {
						/* 확인 이벤트 */
						membervo.setId(loginP.idField.getText());
						membervo.setPwd(loginP.passwordField.getText());
						/* 아아디 비밀번호가 제대로 입력 되었을 때 */
						if(memberdao.login()) { 
							loginP.error.setText(""); // error문구 없음
							loginP.idField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
							loginP.passwordField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
							loginP.dispose();
							/* 로그인 됐을때 실행할 문장 */
							/* 1. 메인 frame 로그인버튼,회원가입 버튼 setVisible(false),
							 *    아이디 출력되는 Label에 setText(); "어서오세요, ~회원님"
							 * 2. 예매 정보를 reservation panel에 부름(where id,order by booking_code)
							 * 3. 개인 정보를 mypage panel에 부름(where id)
							 * 4. loginFlag => true로 
							 */
							/* (1) */
							mainUi.log_regBP.setVisible(false);
							mainUi.welcomeL.setText("환영합니다, "+membervo.getName()+" 님!");
							mainUi.after_loginLP.setVisible(true);
							/* (3) */
							mainUi.myPageC.setInfoLabel(); //현재 로그인 회원 정보를 mypage에 세팅하는 메서드
							mainUi.loginFlag=true;

						}else { // 정확하지 않은 id가 적혔을때
							loginP.error.setText("아이디 또는 비밀번호를 잘못 입력하셨습니다!"); // error문구 출력
							loginP.idField.setBorder(BorderFactory.createLineBorder(Color.RED,2)); // idFeild 테두리색 변경
							loginP.idField.requestFocus(); // 포커스를 idField에 둠
							loginP.passwordField.setBorder(BorderFactory.createLineBorder(Color.RED,2)); // passwordField 테두리색 변경
						}// 아이디,비밀번호 오입력시 
					}// 비밀번호 미입력시
					return;
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
				if(mainUi.loginFlag==true) {
				mainUi.homeB.setBackground(Color.GRAY.brighter());
				mainUi.movieB.setBackground(Color.GRAY.brighter());
				mainUi.reservB.setBackground(Color.RED);
				mainUi.checkB.setBackground(Color.GRAY.brighter());
				mainUi.myPageB.setBackground(Color.GRAY.brighter());
				mainUi.card.show(mainUi.mainC,"reservB");
				}else {
					loginP = new LoginPage();
					loginListenerSet();
				}
			}//if
			if(obj==mainUi.checkB) {
				if(mainUi.loginFlag==true) {
				mainUi.homeB.setBackground(Color.GRAY.brighter());
				mainUi.movieB.setBackground(Color.GRAY.brighter());
				mainUi.reservB.setBackground(Color.GRAY.brighter());
				mainUi.checkB.setBackground(Color.RED);
				mainUi.myPageB.setBackground(Color.GRAY.brighter());
				mainUi.card.show(mainUi.mainC,"checkB");
				}else {
					loginP = new LoginPage();
					loginListenerSet();
				}
			}//if
			if(obj==mainUi.myPageB) {
				if(mainUi.loginFlag==true) {
				mainUi.homeB.setBackground(Color.GRAY.brighter());
				mainUi.movieB.setBackground(Color.GRAY.brighter());
				mainUi.reservB.setBackground(Color.GRAY.brighter());
				mainUi.checkB.setBackground(Color.GRAY.brighter());
				mainUi.myPageB.setBackground(Color.RED);
				mainUi.card.show(mainUi.mainC,"myPageB");
				mainUi.myPageC.error_passL.setText("");
				mainUi.myPageC.error_birthL.setText("");
				mainUi.myPageC.error_emailL.setText("");
				mainUi.myPageC.changeVisible(0);				//회원정보수정 초기화 및 정보조회페이지로 전환
				}else {
					loginP = new LoginPage();
					loginListenerSet();
				}
			}
			if(obj==mainUi.loginB) {
				loginP = new LoginPage();
				loginListenerSet();
			}
			if(obj==mainUi.registB) {
				signUp = new SignUpFrame();
				signupListenerSet();
			}// 메인페이지 로그인버튼/회원가입 버튼 선택 이벤트
			if(obj==mainUi.logoutB) {
				int logoutresult = mainUi.dialog.showConfirmDialog(null,"로그아웃 하시겠습니까?",
						"로그아웃",mainUi.dialog.YES_NO_OPTION,mainUi.dialog.PLAIN_MESSAGE);
				if(logoutresult == mainUi.dialog.CLOSED_OPTION) {

				}else if(logoutresult == mainUi.dialog.NO_OPTION) {

				}else if(logoutresult == mainUi.dialog.YES_OPTION) {
					mainUi.dialog.showMessageDialog(null, "감사합니다. 다음에 또 뵙겠습니다^^");
					/* 로그아웃 시
					 * 1. 로그인,회원가입 버튼 복구/웰컴라벨 텍스트 제거 및 숨기기
					 * 2. 예약정보 지우기 & reservation vo를 null로 초기화
					 * 3. 회원정보 페이지 정보 지우기 & member vo를 null로 초기화
					 * 4. mainframe의 home panel로 이동
					 * 5. MainUi의 loginflag => false;
					 */
					/* (1) */
					mainUi.after_loginLP.setVisible(false);
					mainUi.welcomeL.setText("");
					mainUi.log_regBP.setVisible(true);

					/* (3) */
					mainUi.myPageC.clearInfoLabel();	//회원정보 라벨 비움
					membervo.resetMemberVO();			//membervo 정보 비움
					/* (4) */
					mainUi.homeB.setBackground(Color.RED); // 버튼클릭시 클릭한 버튼 배경색 변경
					mainUi.movieB.setBackground(Color.GRAY.brighter());
					mainUi.reservB.setBackground(Color.GRAY.brighter());
					mainUi.checkB.setBackground(Color.GRAY.brighter());
					mainUi.myPageB.setBackground(Color.GRAY.brighter());
					mainUi.card.show(mainUi.mainC,"homeB"); // "homeB"키가 적용된 카드레이아웃 보여줌
					mainUi.loginFlag=false;
				}
			}
		}//ap()
	}// MainActionL class

	public void loginListenerSet() 	 {		  loginP.addLoginListener(logL);		 }
	public void mainListenerSet() 	 {		  mainUi.addMainListener(mainL);	 	 }
	public void signupListenerSet()  {		  signUp.addSignupListener(signupL);
											  signUp.addSignupFocusListener(signupL);}
	public void findListenerSet()	 {		  findF.addFindListener(findL); 		 }
}//MyActionListener class
