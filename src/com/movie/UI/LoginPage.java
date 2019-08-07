package com.movie.UI;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.movie.main.AppManager;

public class LoginPage extends JFrame{	
	protected JLabel id=new JLabel("                              아이디"); // 아이디 라벨
	protected JLabel password=new JLabel("                            비밀번호"); // 패스워드 라벨
	protected JLabel error=new JLabel(""); // 오류 라벨
	
	/* 입력란 */
	protected JTextField idField=new JTextField(10); // 아이디 입력필드
	protected JPasswordField passwordField=new JPasswordField(10); // 비밀번호 입력필드
	
	/* 버튼 */
	protected JButton addMem=new JButton("회원가입"); // 회원가입버튼
	protected JButton find=new JButton("아이디/비밀번호 찾기"); // 아이디&비밀번호 찾기 버튼
	protected JButton login=new JButton("로그인"); // 로그인 버튼
	
	private JPanel loginViewP=new JPanel();
	private JPanel reg_findP=new JPanel();
	
	public LoginPage() {	
		AppManager.getInstance().setLogin(this);
		
		/* ---------------- 로그인 페이지 프레임 설정 ---------------- */
		setTitle("CineBRO Login"); // 타이틀명 설정
		setSize(400,550); // 프레임 사이즈 설정
		setResizable(false); // 프레임 사이즈 수정 불가
		setLayout(null); // 프레임의 레이아웃 제거
		setLocationRelativeTo(null); // 팝업창 뜨는 위치를 화면 중앙으로 설정
		getContentPane().setBackground(Color.WHITE); // 프레임 배경색 흰색으로 설정
		
		setLoginUI(); // UI셋 메서드 호출

		setDefaultCloseOperation(DISPOSE_ON_CLOSE); // 이 프레임만 자원 해제
		setVisible(true);
	}//cons LoginPage()
		
		public void setLoginUI() {
			/* 각 폰트 설정 */
			Font infoFont=new Font("고딕",Font.BOLD,15); // info 폰트 설정
			Font idPassFont=new Font("고딕",Font.PLAIN,13); // 아이디/패스워드 폰트설정
			Font buttonFont=new Font("고딕",Font.BOLD,20); // 버튼 폰트 설정
			
			/* 입력란 설정 */
			idField.setFont(idPassFont); // ID폰트 설정			
			passwordField.setFont(idPassFont); // Password폰트 설정
			
			/* 각 라벨 설정 */
			id.setFont(infoFont); // ID라벨 폰트 설정					
			password.setFont(infoFont); // Password라벨 폰트 설정				
			error.setFont(new Font("고딕",Font.PLAIN,11)); // error라벨 폰트 설정
			error.setForeground(Color.RED); // error라벨 글씨체 설정
			
			/* 로그인 버튼 설정 */
			login.setFont(buttonFont); // login버튼 폰트 설정
			login.setBackground(Color.BLACK); //버튼 배경색 설정
			login.setForeground(Color.WHITE); //버튼위 글씨색 설정
			login.setBorderPainted(false); //버튼 윤곽선 제거
			
			/* 패널에 각 컴포넌트 추가 */
			loginViewP.add(id);         loginViewP.add(idField); 
			loginViewP.add(password);	loginViewP.add(passwordField);
			loginViewP.add(error);      loginViewP.add(login);// TextPanel에 텍스트박스, 라벨, 버튼 추가
			loginViewP.setLayout(new GridLayout(6,1)); // GridLayout 배치관리자 설정으로 세로정렬
			loginViewP.setBackground(Color.WHITE); // 패널배경색 흰색으로 설정
			
			/* 버튼 배경색 설정 */
			find.setBackground(Color.WHITE);
			addMem.setBackground(Color.WHITE);			
			
			reg_findP.setLayout(new FlowLayout(FlowLayout.CENTER,37,1)); // FlowLayout 배치관리자 설정
			reg_findP.add(find); reg_findP.add(addMem); // 패널에 버튼 추가
			reg_findP.setBackground(Color.WHITE); // 패널 배경색 흰색으로 변경
			
			/* 프레임에 패널 추가&위치설정 */
			add(loginViewP);
			loginViewP.setBounds(55,60,280,250);
			add(reg_findP);
			reg_findP.setBounds(35,310,320,100);
		}//setLoginUI()
	
	public void addLoginListener(ActionListener listener) {
		login.addActionListener(listener);
		addMem.addActionListener(listener);
	}
}//LoginPage class
