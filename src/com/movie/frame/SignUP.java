package com.movie.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**회원 가입 페이지**/
/* WSignupFrame에서 Window 생성 및
 * 내부클래스로 panel 3개 나눌 예정
 * 1. ID(중복버튼) & Pass(재확인)
 * 2. 이름, 생년월일
 * 3. 성별, 본인 확인 이메일(코드전송)
 */
public class SignUP extends JFrame {
	JPanel panelLogo;
	JLabel logo;

	public SignUP() {
		/* 프레임 설정*/
		setSize(550,750);//프레임 크기 지정
		setLayout(new BorderLayout());//그리드 레이아웃 : 1열 정렬
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		/* 로고 넣을 패널 및 라벨 만들기 */
		ImageIcon preImg = new ImageIcon("logo.png");//포스터 넣는란
		Image originImg = preImg.getImage();//ImageIcon을 Image로 전환
		Image changeImg = originImg.getScaledInstance(490,100,java.awt.Image.SCALE_SMOOTH);
		//이미지 사이즈 가로150,세로214
		ImageIcon image = new ImageIcon(changeImg);
		
		logo = new JLabel();//라벨 객체 생성
		logo.setIcon(image);//라벨에 이미지 넣기
		logo.setOpaque(false);
		
		panelLogo = new JPanel() ;//panel 객체 생성
		
		panelLogo.add(logo);//panelLogo에 라벨 넣기
		panelLogo.setBackground(Color.WHITE);
		add(panelLogo,BorderLayout.NORTH);//frame에 paenlLogo 넣기

		/* 내부클래스 패널 불러오기, 프래임에 넣기 */
		Panel1 panel1 = new Panel1();//panel1번 객체 생성
		add(panel1,BorderLayout.CENTER);//프레임에 추가
		panel1.setBorder(BorderFactory.createEmptyBorder(0,100,50,100));//패널 좌우에 100씩 공간

		setResizable(false);//윈도우(프레임) 크기 조절 불가
		setVisible(true);
	}//생성자

	/* 첫번째 패널 만들기 - 내부클래스 */
	class Panel1 extends JPanel {
		JPanel panelSign;

		JButton signup;

		JLabel label_id,label_pass,label_passcheck;//아이디,비번,비번재입력 라벨
		JTextField text_id;//아이디 입력란
		JPasswordField pass_first,pass_second;//비밀번호 입력란
		JButton id_check;

		JLabel label_name, label_birthDate;//이름, 생년월일 라벨
		JTextField text_name,text_year,text_day;//이름,태어난년도,태어난일 텍스트필드
		String[] month= {"1월","2월","3월","4월","5월","6월","7월","8월","9월","10월","11월","12월"};
		//태어난 달을 지정하는 콤보박스 내용물(배열)
		JComboBox<String> combo_month;//콤보박스

		JLabel label_sex,label_email;//성별,이메일 라벨
		String[] sex = {"남자","여자"};//성별 콤보박스 내용물
		JComboBox<String> combo_sex;//성별 콤보박스
		JTextField text_email;//이메일 텍스트필드
		JButton certiNum;//인증번호


		public Panel1() {
			setBackground(Color.WHITE);
			/* 라벨 준비 */	
			label_id = new JLabel("아이디");//라벨에 글씨 입력 및 
			label_pass  = new JLabel("비밀번호");
			label_passcheck = new JLabel("비밀번호 재확인");
			label_name = new JLabel("성함");
			label_birthDate = new JLabel("생년월일");
			label_sex = new JLabel("성별");
			label_email = new JLabel("본인 확인 이메일");

			label_id.setFont(new Font("고딕",Font.BOLD,15));//글씨체 지정
			label_pass.setFont(new Font("고딕",Font.BOLD,15));
			label_passcheck.setFont(new Font("고딕",Font.BOLD,15));
			label_name.setFont(new Font("고딕",Font.BOLD,15));
			label_birthDate.setFont(new Font("고딕",Font.BOLD,15));
			label_sex.setFont(new Font("고딕",Font.BOLD,15));
			label_email.setFont(new Font("고딕",Font.BOLD,15));

			/* 텍스트필드 준비 */
			text_id = new JTextField();//텍스트필드 객체 생성
			pass_first = new JPasswordField();
			pass_second = new JPasswordField();
			text_name = new JTextField();
			text_year = new JTextField();
			text_day = new JTextField();
			text_email = new JTextField();//객체생성

			text_id.setSize(460,50);//필드 크기 지정
			pass_first.setSize(460,50);
			pass_second.setSize(460,50);
			text_name.setSize(460,50);
			text_year.setSize(150,50);
			text_day.setSize(150,50);
			text_email.setSize(420,50);//크기 지정

			text_id.setBorder(new LineBorder(Color.lightGray));//테두리 회색으로 지정
			pass_first.setBorder(new LineBorder(Color.lightGray));
			pass_second.setBorder(new LineBorder(Color.lightGray));
			text_name.setBorder(new LineBorder(Color.lightGray));
			text_year.setBorder(new LineBorder(Color.lightGray));
			text_day.setBorder(new LineBorder(Color.lightGray));
			text_email.setBorder(new LineBorder(Color.lightGray));

			/* 버튼 준비 */
			id_check = new JButton("중복확인");//중복확인 버튼생성
			id_check.setSize(60,50);//버튼 크기 지정
			id_check.setFont(new Font("고딕",Font.BOLD,15));//버튼 글씨체 지정
			id_check.setForeground(Color.white);// 버튼 글씨색 지정
			id_check.setBackground(Color.black);// 버튼 배경색 지정
			certiNum = new JButton("인증번호 받기");//버튼 객체생성
			certiNum.setSize(110,50);//버튼 크기지정
			certiNum.setBackground(Color.BLACK);//버튼색 지정
			certiNum.setForeground(Color.WHITE);//버튼 글씨색 지정
			certiNum.setBorder(new LineBorder(Color.lightGray));//테두리색 지정

			/* 콤보박스 준비 */
			combo_month = new JComboBox<String>(month);
			//콤보박스 생성자 호출시 배열을 전달인자로 넣어주면, 콤보박스에 배열 데이터가 들어감
			combo_month.setFont(new Font("고딕",Font.BOLD,15));//콤보박스 글씨체 지정
			combo_month.setSize(150,50);//콤보박스 크기 지정
			combo_month.setBorder(new LineBorder(Color.lightGray));//콤보박스 테두리 밝은회색으로 지정
			combo_month.setBackground(Color.WHITE);
			
			combo_sex = new JComboBox<>(sex);//객체생성
			combo_sex.setSize(550,50);//크기 지정
			combo_sex.setFont(new Font("고딕",Font.BOLD,15));//콤보박스 글씨체 지정
			combo_sex.setBorder(new LineBorder(Color.lightGray));//테두리색 지정
			combo_sex.setBackground(Color.WHITE);
			
			/* 아이디란의 텍스트필드 & 버튼 넣어줄 패널 생성 */
			JPanel panel_id = new JPanel();//패널생성
			panel_id.setBackground(Color.WHITE);
			panel_id.setSize(550,50);//크기지정
			panel_id.setLayout(new BorderLayout(10,0)); //보더레이아웃으로 레이아웃 지정(좌우 10 떨어짐)
			panel_id.add(text_id,BorderLayout.CENTER); //중앙에 텍스트필드 배치(자동적으로 왼쪽까지 꽉채움)
			panel_id.add(id_check,BorderLayout.EAST);  //오른쪽에 버튼 배치

			/* 이메일&인증번호 묶을 패널 준비 */
			JPanel panel_mail = new JPanel();//패널생성
			panel_mail.setBackground(Color.WHITE);
			panel_mail.setSize(550,50);//크기지정
			panel_mail.setLayout(new BorderLayout(10,0));//보더레이아웃 지정 10 좌우 공백
			panel_mail.add(text_email,BorderLayout.CENTER);//텍스트필드 중앙배치
			panel_mail.add(certiNum,BorderLayout.EAST);//버튼 왼쪽배치

			/* 생년월일 텍스트필드 및 콤보박스 들어갈 패널 생성 */
			JPanel panel_birth = new JPanel();//패널 객체 생성
			panel_birth.setBackground(Color.WHITE);
			panel_birth.setSize(550,50);
			panel_birth.setLayout(new GridLayout(1,3,20,0));//그리드 레이아웃 1행3열,가로 20 공간
			panel_birth.add(text_year); panel_birth.add(combo_month);//패널에 생년월일 컴포넌트 추가
			panel_birth.add(text_day);

			/* 가입하기 버튼 넣을 패널 및 버튼 만들기 */
			signup = new JButton("가입하기");
			signup.setSize(550,60);//크기 지정
			signup.setBackground(Color.BLACK);//배경색 지정
			signup.setForeground(Color.white);//글씨색 지정
			signup.setFont(new Font("고딕",Font.BOLD,18));
			panelSign = new JPanel();//패널객체 생성
			panelSign.setLayout(new GridLayout(1,1));
			panelSign.add(signup);//패널에 버튼 배치

			/* 패널에 컴포넌트들 넣을 준비 */
			setSize(550,300);//패널 사이즈 지정
			setLayout(new GridLayout(0,1));//레이아웃 설정

			add(label_id); add(panel_id); add(label_pass);
			add(pass_first); add(label_passcheck); add(pass_second);

			add(label_name); add(text_name); add(label_birthDate);
			add(panel_birth);

			add(label_sex); add(combo_sex); add(label_email);
			add(panel_mail);
			add(panelSign);

			/* 가입하기 버튼 넣기 */

		}//생성자
	}//Panel1 inner class
}//SignUpFrame class