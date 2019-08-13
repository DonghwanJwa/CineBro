package com.movie.UI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import com.movie.main.AppManager;

public class SignUpFrame extends JFrame{
	private JPanel mainP = new JPanel();         	//메인패널(바탕)

	private JLabel emptyL1 = new JLabel();			 //아이디 텍스트 필드와 버튼 사이 공백
	private JLabel emptyL2 = new JLabel("@");		 //이메일 텍스트 필드와 이메일 도메인 텍스트필드 사이 공백(@)
	private JLabel emptyL3 = new JLabel();			 //이메일 도메인 텍스트필드와 이메일 도메인 콤보박스 사이 공백 
	private JLabel emptyL4 = new JLabel(); 			 //이메일 텍스트필드와 가입하기 버튼사이 공백
	private JLabel logoL = new JLabel();           	 //로고 넣을 라벨
	private JLabel idL = new JLabel("아이디");		 //아이디 타이틀 라벨
	private JLabel passL = new JLabel("비밀번호");		 //비밀번호 타이틀 라벨
	private JLabel passreL = new JLabel("비밀번호 재입력");//비밀번호 재입력 타이틀 라벨
	private JLabel nameL = new JLabel("성함");		 //이름 타이틀 라벨
	private JLabel birthL = new JLabel("생년월일");     //생년월일 타이틀 라벨
	private JLabel sexL = new JLabel("성별");			 //성별 타이틀 라벨
	private JLabel emailL = new JLabel("이메일");		 //이메일 타이틀 라벨

	private JLabel yearL = new JLabel("   년");			 //년 라벨
	private JLabel monthL = new JLabel("   월");		 //월 라벨
	private JLabel dateL = new JLabel("   일");			 //일 라벨

	protected JLabel error_idL = new JLabel();		 //아이디 입력 오류 라벨
	protected JLabel error_passL = new JLabel();	 //비밀번호 입력 오류 라벨
	protected JLabel error_emailL = new JLabel();	 //이메일 입력 오류 라벨
	protected JLabel error_nameL = new JLabel();	 //이름 입력 오류 라벨
	protected JLabel error_birthL = new JLabel();	 //생년월일 입력 오류 라벨
	
	protected JTextField idTF = new JTextField();	 //아이디 입력 텍스트 필드
	protected JTextField nameTF = new JTextField();  //이름 입력 텍스트 필드
	protected JTextField yearTF = new JTextField(); //년 입력 텍스트 필드
	protected JTextField monthTF = new JTextField();//월 입력 텍스트 필드
	protected JTextField dateTF = new JTextField(); //일 입력 텍스트 필드
	protected JTextField emailTF = new JTextField(); //이메일 입력 텍스트 필드
	protected JTextField emailDoTF = new JTextField();//이메일 도메인 입력 텍스트 필드

	protected JPasswordField passPF = new JPasswordField();  //비밀번호 입력 패스워드 필드
	protected JPasswordField passrePF = new JPasswordField();//비밀번호 재입력 패스워드 필드

	protected JButton check_idB = new JButton("중복확인");		 //아이디 중복확인 버튼
	protected JButton check_emailB = new JButton("이메일 인증번호 받기");//이메일 인증번호 버튼
	protected JButton confirmB = new JButton("가입하기"); 		 //가입하기 버튼 

	protected JOptionPane dialog = new JOptionPane();         //회원가입 완료 옵션패널
	
	String[] sex = {"남자","여자"};//성별 콤보박스 내용물
	protected JComboBox<String> sexC = new JComboBox<>(sex);//성별 콤보박스
	
	String[] emaillist= {"직접입력","naver.com","hanmail.net","gmail.com","nate.com"};
	protected JComboBox<String> emailC = new JComboBox<>(emaillist);
	
	
	Font font = new Font("맑은 고딕",Font.BOLD,15);
	Font warnF = new Font("맑은 고딕",Font.BOLD,9);

	public SignUpFrame() {
		AppManager.getInstance().setSignUpFrame(this);

		setTitle("회원가입");
		setSize(new Dimension(540,792));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null); // 팝업창 뜨는 위치를 화면 중앙으로 설정
		setResizable(false);

		add(mainP());
		setVisible(true);
	}

	public Component mainP() {
		/*메인패널 설정*/
		mainP.setPreferredSize(new Dimension(544,720));
		mainP.setBorder(BorderFactory.createEmptyBorder(10,95,10,95));
		mainP.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
		mainP.setBackground(Color.DARK_GRAY);

		/* 로고 넣을 패널 및 라벨 만들기 */
		ImageIcon preImg = new ImageIcon("pic/logo.png");//포스터 넣는란
		Image originImg = preImg.getImage();//ImageIcon을 Image로 전환
		Image changeImg = originImg.getScaledInstance(390,80,java.awt.Image.SCALE_SMOOTH);
		ImageIcon image = new ImageIcon(changeImg);
		logoL.setIcon(image);                       	 

		idL.setPreferredSize(new Dimension(340,35));//타이틀라벨     //컴포넌트 사이즈 지정
		passL.setPreferredSize(new Dimension(340,35));
		passreL.setPreferredSize(new Dimension(340,35));
		nameL.setPreferredSize(new Dimension(340,35));
		birthL.setPreferredSize(new Dimension(340,35));
		sexL.setPreferredSize(new Dimension(340,35));
		emailL.setPreferredSize(new Dimension(340,35));

		emptyL1.setPreferredSize(new Dimension(10,35));//공백라벨
		emptyL2.setPreferredSize(new Dimension(20,35));
		emptyL3.setPreferredSize(new Dimension(10,35));
		emptyL4.setPreferredSize(new Dimension(340,20));

		yearL.setPreferredSize(new Dimension(30,35));//년월일라벨
		monthL.setPreferredSize(new Dimension(30,35));
		dateL.setPreferredSize(new Dimension(30,35));

		error_idL.setPreferredSize(new Dimension(340,15));//경고문라벨
		error_passL.setPreferredSize(new Dimension(340,15));
		error_emailL.setPreferredSize(new Dimension(340,15));
		error_nameL.setPreferredSize(new Dimension(340,15));
		error_birthL.setPreferredSize(new Dimension(340,15));

		idTF.setPreferredSize(new Dimension(240,35));//텍스트필드
		nameTF.setPreferredSize(new Dimension(340,35));
		yearTF.setPreferredSize(new Dimension(90,35));
		monthTF.setPreferredSize(new Dimension(80,35));
		dateTF.setPreferredSize(new Dimension(80,35));
		emailTF.setPreferredSize(new Dimension(105,35));
		emailDoTF.setPreferredSize(new Dimension(105,35));

		passPF.setPreferredSize(new Dimension(340,35));//패스워드필드
		passrePF.setPreferredSize(new Dimension(340,35));

		check_idB.setPreferredSize(new Dimension(90,35));//버튼
		check_emailB.setPreferredSize(new Dimension(340,35));
		confirmB.setPreferredSize(new Dimension(340,35));

		sexC.setPreferredSize(new Dimension(340,35));//콤보박스
		emailC.setPreferredSize(new Dimension(100,35));

		idL.setFont(font);          passL.setFont(font);      	 //글씨체 지정
		passreL.setFont(font);      nameL.setFont(font);
		birthL.setFont(font);       sexL.setFont(font);
		emailL.setFont(font);	    sexC.setFont(font);
		emptyL2.setFont(font);

		error_idL.setFont(warnF);    error_passL.setFont(warnF);
		error_emailL.setFont(warnF); error_nameL.setFont(warnF);
		error_birthL.setFont(warnF);

		emptyL2.setHorizontalAlignment(JLabel.CENTER);			 //라벨 중앙정렬
		
		idL.setForeground(Color.WHITE);							 //라벨 글씨색 지정
		passL.setForeground(Color.WHITE);
		passreL.setForeground(Color.WHITE);
		nameL.setForeground(Color.WHITE);
		birthL.setForeground(Color.WHITE);
		sexL.setForeground(Color.WHITE);
		emailL.setForeground(Color.WHITE);
		emptyL2.setForeground(Color.WHITE);

		yearL.setForeground(Color.WHITE);
		monthL.setForeground(Color.WHITE);
		dateL.setForeground(Color.WHITE);
		
		error_idL.setForeground(Color.RED);
		error_passL.setForeground(Color.RED);
		error_emailL.setForeground(Color.RED);
		error_nameL.setForeground(Color.RED);
		error_birthL.setForeground(Color.RED);

		idTF.setBorder(new LineBorder(Color.BLACK));			 //텍스트필드 테두리 색지정
		nameTF.setBorder(new LineBorder(Color.BLACK));
		yearTF.setBorder(new LineBorder(Color.BLACK));
		monthTF.setBorder(new LineBorder(Color.BLACK));
		dateTF.setBorder(new LineBorder(Color.BLACK));
		emailTF.setBorder(new LineBorder(Color.BLACK));
		emailDoTF.setBorder(new LineBorder(Color.BLACK));

		passPF.setBorder(new LineBorder(Color.BLACK));
		passrePF.setBorder(new LineBorder(Color.BLACK));

		sexC.setBorder(new LineBorder(Color.BLACK));             //콤보박스 테두리 색 지정

		check_idB.setFont(new Font("맑은 고딕",Font.BOLD,15)); 
		check_emailB.setFont(new Font("맑은 고딕",Font.BOLD,15));
		confirmB.setFont(new Font("맑은 고딕",Font.BOLD,18));

		check_idB.setForeground(Color.WHITE);                    //버튼 글씨색
		check_emailB.setForeground(Color.WHITE);
		confirmB.setForeground(Color.WHITE);

		check_idB.setBackground(Color.BLACK);					 //버튼 배경색
		check_emailB.setBackground(Color.BLACK);
		confirmB.setBackground(Color.BLACK);
		
		check_idB.setMargin(new Insets(0,0,0,0));				 //버튼 내부 공백설정(없에버림)
		check_emailB.setMargin(new Insets(0,0,0,0));

		check_idB.setFocusPainted(false);						 //버튼 클릭시 테두리 색 설정해제
		check_emailB.setFocusPainted(false);
		confirmB.setFocusPainted(false);

		check_idB.setBorderPainted(false); 						 //버튼 테두리 색 설정 해제
		check_emailB.setBorderPainted(false);
		confirmB.setBorderPainted(false);
	
		mainP.add(logoL);		mainP.add(idL); 		
		mainP.add(idTF);		mainP.add(emptyL1);
		mainP.add(check_idB);	mainP.add(error_idL);	
		mainP.add(passL);		mainP.add(passPF);
		mainP.add(passreL);		mainP.add(passrePF);
		mainP.add(error_passL);	mainP.add(nameL);
		mainP.add(nameTF);		mainP.add(error_nameL);
		mainP.add(birthL);		mainP.add(yearTF);
		mainP.add(yearL);		mainP.add(monthTF);		
		mainP.add(monthL);		mainP.add(dateTF);		
		mainP.add(dateL);		mainP.add(error_birthL);
		mainP.add(sexL);		mainP.add(sexC);
		mainP.add(emailL);		mainP.add(emailTF);
		mainP.add(emptyL2);		mainP.add(emailDoTF);
		mainP.add(emptyL3); 	mainP.add(emailC);
		mainP.add(error_emailL);mainP.add(check_emailB);
		mainP.add(emptyL4);		mainP.add(confirmB);

		return mainP;
	}//mainP()

	public void addSignupListener(ActionListener listener) {
		check_idB.addActionListener(listener);
		check_emailB.addActionListener(listener);
		confirmB.addActionListener(listener);
		emailC.addActionListener(listener);
	}

//	public static void main(String[] args) {
//		new SignUpFrame();
//	}//main() : 완성시 삭제해야됨!!!
}//SignUpFrame class
