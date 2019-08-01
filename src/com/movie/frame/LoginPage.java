package com.movie.frame;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPage extends JFrame{
	LoginPanel loginPanel=new LoginPanel(); //내부클래스 LoginPanel 객체생성
	MemButtonPanel mem_buttonPanel=new MemButtonPanel(); //내부클래스 MemButtonPanel 객체 생성

	public LoginPage() {		
		setTitle("Login"); // 타이틀명 설정
		setSize(400,550); // 프레임 사이즈 설정
		setResizable(false); // 프레임 사이즈 고정
		setLayout(null); // 절대배치를 위한 프레임의 기본레이아웃 제거
		setLocationRelativeTo(null); // 팝업창 뜨는 위치를 화면 중앙으로 설정
		getContentPane().setBackground(Color.WHITE); // 프레임 배경색 흰색으로 설정

		add(mem_buttonPanel);
		mem_buttonPanel.setBounds(35,310,320,100);
		add(loginPanel); // 프레임에 패널추가
		loginPanel.setBounds(55,60,280,250); // 절대위치 배정

		setVisible(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				dispose();
			}			
		});
	}//cons LoginPage()

	class LoginPanel extends JPanel implements ActionListener{
		private JPasswordField passwordField;
		private JLabel id,password,error;
		private Font infoFont,idPassFont,buttonFont;
		JTextField idField; // 각 항목 멤버변수 선언
		JButton login;

		public LoginPanel() {
			/* Font */
			infoFont=new Font("고딕",Font.BOLD,15); // info 폰트 설정
			idPassFont=new Font("고딕",Font.PLAIN,13); // 아이디/패스워드 폰트설정
			buttonFont=new Font("고딕",Font.BOLD,20); // 버튼 폰트 설정
			/* TextFeild */
			idField=new JTextField(10); // ID텍스트박스 객체 생성
			idField.setFont(idPassFont); // ID폰트 설정
			passwordField=new JPasswordField(10); // Password텍스트박스 객체 생성
			passwordField.setFont(idPassFont); // Password폰트 설정
			/* Label */
			id=new JLabel("                             아이디"); // ID라벨 객체 생성
			id.setFont(infoFont); // ID라벨 폰트 설정
			password=new JLabel("                           비밀번호"); // Password라벨 객체 생성		
			password.setFont(infoFont); // Password라벨 폰트 설정			
			error=new JLabel(""); // error라벨 객체 생성
			error.setFont(new Font("고딕",Font.PLAIN,11)); // error라벨 폰트 설정
			error.setForeground(Color.RED); // error라벨 글씨체 설정
			/* Button */
			login=new JButton("로그인"); // login버튼 객체 생성
			login.setFont(buttonFont); // login버튼 폰트 설정
			login.addActionListener(this); // login버튼 이벤트 설정
			login.setBackground(Color.BLACK); //버튼 배경색 설정
			login.setForeground(Color.WHITE); //버튼위 글씨색 설정
			login.setBorderPainted(false); //버튼 윤곽선 제거
			/* add */
			add(id); add(idField); 
			add(password);	add(passwordField);
			add(error); add(login);// TextPanel에 텍스트박스, 라벨, 버튼 추가
			setLayout(new GridLayout(6,1)); // GridLayout 배치관리자 설정으로 세로정렬
			setBackground(Color.WHITE); // 패널배경색 흰색으로 설정
		}//cons TextPanel()
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==login) { // login 버튼을 눌렀을 때	
				/* 아이디를 적지 않았을때 */
				if(idField.getText().equals("")) {
					error.setText("아이디를 입력해주세요!");
					idField.requestFocus();
					idField.setBorder(BorderFactory.createLineBorder(Color.RED,2)); // 외곽선 설정 오류시 붉은선
					passwordField.setBorder(BorderFactory.createLineBorder(Color.BLACK)); // 정상작동시 검은선
				}else {
					/* 비밀번호를 적지 않았을 때 */
					if(passwordField.getText().equals("")) {
						error.setText("비밀번호를 입력해주세요!");
						passwordField.requestFocus();
						passwordField.setBorder(BorderFactory.createLineBorder(Color.RED,2));
						idField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
					}else {
						/* 확인 이벤트 */
						if(idField.getText().equals("abcd") && passwordField.getText().equals("abcd")) { 
							// idField와 passwordField에 정확한 id와 password가 적혔을때
							error.setText(""); // error문구 없음
							idField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
							passwordField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
							/* 로그인 됐을때 실행할 문장 */
							
						}else { // 정확하지 않은 id가 적혔을때
							error.setText("아이디 또는 비밀번호를 잘못 입력하셨습니다!"); // error문구 출력
							idField.setBorder(BorderFactory.createLineBorder(Color.RED,2)); // idFeild 테두리색 변경
							idField.requestFocus(); // 포커스를 idField에 둠
							passwordField.setBorder(BorderFactory.createLineBorder(Color.RED,2)); // passwordField 테두리색 변경
						}//if else => 아이디,비밀번호 오입력
					}//if else => 비밀번호 미입력
				}//if else => 아이디 미입력
			}//if => 로그인 버튼 클릭시
		}//aP() => 버튼이벤트
	}//TextPanel inner class	
	class MemButtonPanel extends JPanel{
		private JButton addMem,find;

		public MemButtonPanel() {
			find=new JButton("아이디/비밀번호 찾기"); // find버튼 객체 생성
			addMem=new JButton("회원가입"); // addMem버튼 객체생성
			/* 버튼 배경색 설정 */
			find.setBackground(Color.WHITE);
			addMem.setBackground(Color.WHITE);
			/* 버튼 이벤트 등록 */ 
			addMem.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(e.getSource()==addMem) {
						new SignUP();
					}//if
				}//aP() => 눌렀을 때 시행		
			}); // 버튼이벤트 등록
			
			setLayout(new FlowLayout(FlowLayout.CENTER,37,1)); // FlowLayout 배치관리자 설정
			add(find); add(addMem); // 패널에 버튼 추가
			setBackground(Color.WHITE); // 패널 배경색 흰색으로 변경
		}//cons MemButtonPanel()
	}//MemButtonPanel class
}//LoginPage class
