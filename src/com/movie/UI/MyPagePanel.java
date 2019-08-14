package com.movie.UI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
/**코드가 길어진 이유**/
/* 기본정보 페이지와 기본정보 수정 페이지를 각각 메서드로 나누어 뒀기 때문
 * - 패널의 리셋 혹은 내용 변화 실험을 위해 나눴음
 * - 패널의 새로고침 기능을 이해하고 나면 다시 재 수정 예정
 * - 생성자 내에서 따로 mainP를 add하지 않고, 메서드 호출만으로 클래스 패널에 추가됨
 */
public class MyPagePanel extends JPanel implements ActionListener{
	private JLabel menuL = new JLabel("기본정보",SwingConstants.CENTER);	//메뉴 라벨(기본정보)			//각항목의 제목용 라벨(title label)
	private JLabel idTL = new JLabel("아이디");		//아이디 타이틀 라벨
	private JLabel passTL = new JLabel("비밀번호");	//비밀번호 타이틀 라벨
	private JLabel nameTL = new JLabel("이름");		//이름 타이틀 라벨
	private JLabel sexTL = new JLabel("성별");		//성별 타이틀 라벨
	private JLabel birthTL = new JLabel("생년월일");	//생년월일 타이틀 라벨
	private JLabel emailTL = new JLabel("이메일");	//이메일 타이틀 라벨

	protected JLabel idCL = new JLabel();		//아이디 출력 라벨		//각항목의 내용 출력용 라벨(content label)
	protected JLabel passCL = new JLabel();		/**(나중에 지울것)비밀번호 출력용 라벨**/
	protected JLabel nameCL = new JLabel();		//이름 출력 라벨
	protected JLabel sexCL = new JLabel();		//성별 출력 라벨
	protected JLabel birthCL = new JLabel();	//생년월일 출력 라벨
	protected JLabel emailCL = new JLabel();	//이메일 출력 라벨

	private JLabel birth_mentCL = new JLabel("설정하신 생일 기준으로 15일전 생일쿠폰을 보내드립니다.");//생일 안내정보 라벨             //항목 안내정보 입력용 라벨(announcement content label)
	private JLabel email_mentCL = new JLabel("아이디 및 비밀번호 찾기시 메세가 전송되며, 쿠폰 & 이벤트 정보 등을 제공 받으실 수 있습니다.");//이메일 안내정보 라벨

	private JPanel menuP = new JPanel();		 //메뉴 라벨(기본정보) 패널
	private JPanel buttonP = new JPanel();		 //수정,탈퇴 버튼 패널
	private JPanel titleP = new JPanel();		 //타이틀 라벨 패널
	private JPanel contentP = new JPanel();		 //출력 라벨 패널
	private JPanel titleContentP = new JPanel(); //타이틀 라벨 패널과 출력 라벨 패널 두개를 올릴 패널

	private JPanel idTP = new JPanel();		  	 //아이디 타이틀 라벨 패널	//각항목의 제목용 패널(title panel)
	private JPanel passTP = new JPanel();		 //비밀번호 타이틀 라벨 패널
	private JPanel nameTP = new JPanel();		 //이름 타이틀 라벨 패널
	private JPanel sexTP = new JPanel();	 	 //성별 타이틀 라벨 패널
	private JPanel birthTP = new JPanel(); 	 	 //생년월일 타이틀 라벨 패널
	private JPanel emailTP = new JPanel();		 //이메일 타이틀 라벨 패널
	private JPanel idCP = new JPanel();			 //아이디 출력 라벨 패널       //각항목의 내용 출력라벨용 패널(content panel)
	private JPanel passCP = new JPanel();		 //비밀번호 출력 라벨(동시에 비밀번호 입력 패널을 올릴) 패널
	private JPanel passF_UpdateTP = new JPanel();			 //비밀번호 입력 제목용 라벨 올라갈 패널(password number_update title panel)
	private JPanel passS_UpdateTP = new JPanel();
	private JPanel passF_UpdateCP = new JPanel();           //비밀번호 입력용 패스워드 필드 올라갈 패널(password number_update content panel)
	private JPanel passS_UpdateCP = new JPanel();
	private JPanel nameCP = new JPanel();		 //이름 출력 라벨 패널
	private JPanel sexCP = new JPanel(); 		 //성별 출력 라벨 패널
	private JPanel birthCP = new JPanel();		 //생년월일 출력 라벨 패널
	private JPanel emailCP = new JPanel();	     //이메일 출력 라벨 패널	    

	private JPanel birth_mentCP = new JPanel(); //생년월일 안내 정보 라벨 패널 //항목 정보 입력용 라벨(announcement content panel)
	private JPanel email_mentCP = new JPanel();               

	protected JButton updateB = new JButton("수정하기");     //기본정보 수정 버튼
	protected JButton deleteB = new JButton("탈퇴하기");	   //회원탈퇴 버튼

	/**기본정보 수정 페이지에 추가적으로 필요한 변수**/
	private JLabel passF_UpdateL = new JLabel("비밀번호 입력");		 //비밀번호 입력 제목용 라벨 (password number_update label)					 
	private JLabel passS_UpdateL = new JLabel("비밀번호 재입력");
	private JLabel year_UpdateL = new JLabel(" 년 ");				 //년,월,일 라벨(텍스트필드 사이에 들어갈 것)
	private JLabel month_UpdateL = new JLabel(" 월 ");
	private JLabel date_UpdateL = new JLabel(" 일 ");
	private JLabel email_AtL = new JLabel("@");					 //이메일 주소 @(At) 라벨

	protected JLabel error_passL = new JLabel();	 	//비밀번호 입력 오류 라벨
	protected JLabel error_birthL = new JLabel();	 	//생년월일 입력 오류 라벨
	protected JLabel error_emailL = new JLabel();		//이메일 입력 오류 라벨

	private JPanel update_ConfirmP = new JPanel();		//수정 완료 버튼 올라갈 패널

	protected JPasswordField passF_UpdatePF = new JPasswordField(); //비밀번호 입력용 패스워드필드(password number_update password field)
	protected JPasswordField passS_UpdatePF = new JPasswordField();
	protected JTextField year_UpdateTF = new JTextField();      	//생년월일 년,월,일 입력용 텍스트필드(update_text field)
	protected JTextField month_UpdateTF = new JTextField();
	protected JTextField date_UpdateTF = new JTextField();
	protected JTextField email_UpdateTF = new JTextField();	 		//이메일 입력용 텍스트필드(email_update text field)
	protected JTextField email_UpdateDoTF = new JTextField();		//이메일 도메인용 텍스트 필드

	String[] emaillist= {"선택","naver.com","hanmail.net","gmail.com","nate.com","직접입력"};//성별 콤보박스 내용물
	String[] sex = {"남자","여자"};                          			
	protected JComboBox<String> sex_UpdateCB;				 		//성별 입력용 콤보박스(update_combo box)
	protected JComboBox<String> emailC = new JComboBox<>(emaillist);
	protected JButton update_ConfirmB = new JButton("수정"); 		 	//수정하기 버튼
	
	

	protected JOptionPane dialog = new JOptionPane();

	/**기본정보 삭제 페이지에 추가적으로 필요한 컴포넌트**/
	protected JPasswordField delete_passPF = new JPasswordField();   //탈퇴시 입력할 비밀번호란
	protected JButton delete_ConfirmB = new JButton("탈퇴");			 //탈퇴하기 버튼

	/**회원탈퇴 Dialog 출력 필요 컴포넌트**/
	private JLabel delete_ment1L = new JLabel();					 //회원탈퇴 안내메세지
	private JLabel delete_ment2L = new JLabel();

	private JPanel delete_mentP = new JPanel();						 //회원탈퇴 안내 라벨 올라갈 패널 

	/*폰트 만들기*/
	Font menuF = new Font("맑은 고딕",Font.BOLD,30);
	Font titleTF = new Font("맑은 고딕",Font.BOLD,20);
	Font contentTF = new Font("맑은 고딕",Font.PLAIN,18);
	Font content_mentTF = new Font("맑은 고딕",Font.PLAIN,13);
	Font comboF = new Font("맑은 고딕",Font.BOLD,15);
	Font confirmBF = new Font("맑은 고딕",Font.BOLD,20);
	Font warnF = new Font("맑은 고딕",Font.BOLD,9);

	public MyPagePanel() {
		setPreferredSize(new Dimension(1400,800));
		setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
		setOpaque(false);
		setBorder(BorderFactory.createEmptyBorder(20,100,90,370));
		setViewUI();
		setUpdateUI();
	}//기본생성자

	/**기본정보 확인 페이지 컴포넌트**/
	public void setViewUI() {
		/*제목,내용들 올라갈 패널들 설정*/
		menuP.setPreferredSize(new Dimension(920,60));            //사이즈설정
		buttonP.setPreferredSize(new Dimension(160,60));
		titleP.setPreferredSize(new Dimension(240,640));
		contentP.setPreferredSize(new Dimension(680,640));
		titleContentP.setPreferredSize(new Dimension(920,640));
		update_ConfirmP.setPreferredSize(new Dimension(920,70));

		menuP.setBackground(Color.DARK_GRAY);                     //임시 색상 설정
		titleP.setBackground(Color.LIGHT_GRAY);
		contentP.setBackground(Color.WHITE);
		update_ConfirmP.setBackground(Color.DARK_GRAY);

		menuP.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.BLACK));
		//패널 테두리 설정 (상,좌,하,우,색상)
		update_ConfirmP.setBorder(BorderFactory.createEmptyBorder(10,0,10,0));  //패딩


		menuP.setLayout(new BorderLayout(0,0));     //배치관리자 설정
		buttonP.setLayout(new GridLayout(1,2));
		titleP.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));    //Flow 좌측정렬, 상하좌우여백 0
		contentP.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
		titleContentP.setLayout(new BorderLayout());              //titleContentP만 보더레이아웃
		update_ConfirmP.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));

		add(menuP); add(titleContentP);                           //뼈대가될 패널들을 올림
		titleContentP.add(titleP,BorderLayout.WEST);
		titleContentP.add(contentP,BorderLayout.CENTER);
		add(update_ConfirmP);

		/*각항목의 제목용 & 내용용 패널 생성*/

		idTP.setPreferredSize(new Dimension(240,70));             //크기지정
		passTP.setPreferredSize(new Dimension(240,160));
		passF_UpdateTP.setPreferredSize(new Dimension(240,80));
		passS_UpdateTP.setPreferredSize(new Dimension(240,80));
		nameTP.setPreferredSize(new Dimension(240,70));
		sexTP.setPreferredSize(new Dimension(240,100));
		birthTP.setPreferredSize(new Dimension(240,120));
		emailTP.setPreferredSize(new Dimension(240,120));

		idCP.setPreferredSize(new Dimension(680,70));
		passCP.setPreferredSize(new Dimension(680,160));
		passF_UpdateCP.setPreferredSize(new Dimension(680,80));
		passS_UpdateCP.setPreferredSize(new Dimension(680,80));
		nameCP.setPreferredSize(new Dimension(680,70));
		sexCP.setPreferredSize(new Dimension(680,100));
		birthCP.setPreferredSize(new Dimension(680,120));
		emailCP.setPreferredSize(new Dimension(680,120));
		birth_mentCP.setPreferredSize(new Dimension(650,25));//birth,email 패널 내에 들어갈 것
		email_mentCP.setPreferredSize(new Dimension(650,25));//크기가 패딩된것보다 작아야한다.(좌측패딩 30)


		idTP.setBackground(new Color(240,240,240));                  //배경색 지정
		passF_UpdateTP.setBackground(new Color(240,240,240));
		passS_UpdateTP.setBackground(new Color(240,240,240));
		nameTP.setBackground(new Color(240,240,240));
		sexTP.setBackground(new Color(240,240,240));
		birthTP.setBackground(new Color(240,240,240));
		emailTP.setBackground(new Color(240,240,240));

		idCP.setBackground(Color.WHITE);
		passF_UpdateCP.setBackground(Color.WHITE);
		passS_UpdateCP.setBackground(Color.WHITE);
		nameCP.setBackground(Color.WHITE);
		sexCP.setBackground(Color.WHITE);
		birthCP.setBackground(Color.WHITE);
		emailCP.setBackground(Color.WHITE);
		birth_mentCP.setBackground(Color.WHITE);
		email_mentCP.setBackground(Color.WHITE);


		idTP.setLayout(new FlowLayout(FlowLayout.LEFT));                //패널 내부 레이아웃 지정
		passTP.setLayout(new GridLayout(2,1));
		passF_UpdateTP.setLayout(new FlowLayout(FlowLayout.LEFT));
		passS_UpdateTP.setLayout(new FlowLayout(FlowLayout.LEFT));
		nameTP.setLayout(new FlowLayout(FlowLayout.LEFT));
		sexTP.setLayout(new FlowLayout(FlowLayout.LEFT));
		birthTP.setLayout(new FlowLayout(FlowLayout.LEFT));
		emailTP.setLayout(new FlowLayout(FlowLayout.LEFT));

		idCP.setLayout(new FlowLayout(FlowLayout.LEFT));
		passCP.setLayout(new GridLayout(2,1));
		passF_UpdateCP.setLayout(new FlowLayout(FlowLayout.LEFT));
		passS_UpdateCP.setLayout(new FlowLayout(FlowLayout.LEFT));
		nameCP.setLayout(new FlowLayout(FlowLayout.LEFT));
		sexCP.setLayout(new FlowLayout(FlowLayout.LEFT));
		birthCP.setLayout(new FlowLayout(FlowLayout.LEFT));
		emailCP.setLayout(new FlowLayout(FlowLayout.LEFT));
		birth_mentCP.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
		email_mentCP.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));


		idTP.setBorder(new CompoundBorder(                 //패널 테두리 설정 및 패널 내부 패딩설정(내부공백)
				BorderFactory.createMatteBorder(0,0,1,0,Color.LIGHT_GRAY),
				BorderFactory.createEmptyBorder(20,30,0,0)));     
		passF_UpdateTP.setBorder(new CompoundBorder(
				BorderFactory.createMatteBorder(0,0,1,0,Color.LIGHT_GRAY),
				BorderFactory.createEmptyBorder(15,30,0,0)));
		passS_UpdateTP.setBorder(new CompoundBorder(
				BorderFactory.createMatteBorder(0,0,1,0,Color.LIGHT_GRAY),
				BorderFactory.createEmptyBorder(15,30,0,0)));
		nameTP.setBorder(new CompoundBorder(
				BorderFactory.createMatteBorder(0,0,1,0,Color.LIGHT_GRAY),
				BorderFactory.createEmptyBorder(20,30,0,0)));
		sexTP.setBorder(new CompoundBorder(
				BorderFactory.createMatteBorder(0,0,1,0,Color.LIGHT_GRAY),
				BorderFactory.createEmptyBorder(20,30,0,0)));
		birthTP.setBorder(new CompoundBorder(
				BorderFactory.createMatteBorder(0,0,1,0,Color.LIGHT_GRAY),
				BorderFactory.createEmptyBorder(20,30,0,0)));
		emailTP.setBorder(new CompoundBorder(
				BorderFactory.createMatteBorder(0,0,1,0,Color.LIGHT_GRAY),
				BorderFactory.createEmptyBorder(20,30,0,0)));

		idCP.setBorder(new CompoundBorder(
				BorderFactory.createMatteBorder(0,0,1,0,Color.LIGHT_GRAY),
				BorderFactory.createEmptyBorder(20,30,0,0)));
		passF_UpdateCP.setBorder(new CompoundBorder(
				BorderFactory.createMatteBorder(0,0,1,0,Color.LIGHT_GRAY),
				BorderFactory.createEmptyBorder(15,30,0,0)));
		passS_UpdateCP.setBorder(new CompoundBorder(
				BorderFactory.createMatteBorder(0,0,1,0,Color.LIGHT_GRAY),
				BorderFactory.createEmptyBorder(15,30,0,0)));
		nameCP.setBorder(new CompoundBorder(
				BorderFactory.createMatteBorder(0,0,1,0,Color.LIGHT_GRAY),
				BorderFactory.createEmptyBorder(20,30,0,0)));
		sexCP.setBorder(new CompoundBorder(
				BorderFactory.createMatteBorder(0,0,1,0,Color.LIGHT_GRAY),
				BorderFactory.createEmptyBorder(20,30,0,0)));
		birthCP.setBorder(new CompoundBorder(
				BorderFactory.createMatteBorder(0,0,1,0,Color.LIGHT_GRAY),
				BorderFactory.createEmptyBorder(20,30,0,0)));
		emailCP.setBorder(new CompoundBorder(
				BorderFactory.createMatteBorder(0,0,1,0,Color.LIGHT_GRAY),
				BorderFactory.createEmptyBorder(20,30,0,0)));


		titleP.add(idTP);    titleP.add(passTP);                //뼈대 패널에 내용 패널 추가
		passTP.add(passF_UpdateTP);
		passTP.add(passS_UpdateTP);
		titleP.add(nameTP);  titleP.add(sexTP);
		titleP.add(birthTP); titleP.add(emailTP);

		contentP.add(idCP); contentP.add(passCP);
		passCP.add(passF_UpdateCP);
		passCP.add(passS_UpdateCP);
		contentP.add(nameCP); contentP.add(sexCP);
		contentP.add(birthCP); contentP.add(emailCP);

		/*로고 라벨 생성*/
		menuL.setPreferredSize(new Dimension(140,60)); 
		menuL.setForeground(Color.WHITE);
		menuL.setFont(menuF);
		menuP.add(menuL,BorderLayout.WEST);

		/*제목 라벨 생성 : 각항목의 제목용 라벨(title label)*/
		idTL.setFont(titleTF);    passTL.setFont(titleTF);             //제목 라벨 폰트 지정
		nameTL.setFont(titleTF);  sexTL.setFont(titleTF);
		birthTL.setFont(titleTF); emailTL.setFont(titleTF);

		idTP.add(idTL);       passF_UpdateTP.add(passTL);                      //제목 라벨을 패널에 추가
		nameTP.add(nameTL);   sexTP.add(sexTL);
		birthTP.add(birthTL); emailTP.add(emailTL);

		/*내용 라벨 생성 : 각항목의 내용 출력용 라벨(content label)*/
		idCL.setText("아이디 출력VO");     passCL.setText("비밀번호 공백!!");   //출력 라벨 객체 생성
		nameCL.setText("이름 출력VO");     sexCL.setText("성별 출력VO");
		birthCL.setText("생년월일 출력VO"); emailCL.setText("이메일 출력VO");


		idCL.setFont(contentTF);    passCL.setFont(contentTF);           //출력 라벨 폰트 지정
		nameCL.setFont(contentTF);  sexCL.setFont(contentTF);
		birthCL.setFont(contentTF); emailCL.setFont(contentTF);
		birth_mentCL.setFont(content_mentTF);
		email_mentCL.setFont(content_mentTF);

		birth_mentCL.setForeground(Color.LIGHT_GRAY);                   //안내문 글자색 지정
		email_mentCL.setForeground(Color.LIGHT_GRAY);                   	

		idCP.add(idCL);       passF_UpdateCP.add(passCL);                       //출력 라벨 패널에 추가
		nameCP.add(nameCL);   sexCP.add(sexCL);
		birthCP.add(birthCL); emailCP.add(emailCL);
		birth_mentCP.add(birth_mentCL);
		email_mentCP.add(email_mentCL);

		/*수정 버튼 생성*/         
		updateB.setBackground(Color.BLACK);
		updateB.setForeground(Color.WHITE);
		updateB.setFocusPainted(false);
		updateB.setBorderPainted(false);
		updateB.setMargin(new Insets(1,1,1,1));

		/*삭제 버튼 생성*/
		deleteB.setBackground(Color.RED);
		deleteB.setForeground(Color.WHITE);
		deleteB.setFocusPainted(false);
		deleteB.setBorderPainted(false);
		deleteB.setMargin(new Insets(1,1,1,1));

		buttonP.add(updateB);
		buttonP.add(deleteB);
		menuP.add(buttonP,BorderLayout.EAST);

		updateB.addActionListener(this);            //버튼 이벤트 추가
		deleteB.addActionListener(this);
	}//setViewUI()

	/**기본정보 수정페이지,탈퇴페이지에 필요한 컴포넌트 추가**/
	public void setUpdateUI() {

		/*제목 라벨 생성 : 각항목의 제목용 라벨(title label)*/
		passF_UpdateL.setFont(titleTF);    //제목 라벨 폰트 지정      
		passS_UpdateL.setFont(titleTF);             

		passF_UpdateTP.add(passF_UpdateL); //제목 라벨을 패널에 추가
		passS_UpdateTP.add(passS_UpdateL);

		/*비밀번호 패스워드 필드*/
		passF_UpdatePF.setPreferredSize(new Dimension(200,30));    //패스워드 필드 크기 지정
		passS_UpdatePF.setPreferredSize(new Dimension(200,30));
		delete_passPF.setPreferredSize(new Dimension(200,30));

		passF_UpdatePF.setBorder(new LineBorder(Color.LIGHT_GRAY));//패널 테두리 색 지정
		passS_UpdatePF.setBorder(new LineBorder(Color.LIGHT_GRAY));
		delete_passPF.setBorder(new LineBorder(Color.LIGHT_GRAY));

		passF_UpdateCP.add(passF_UpdatePF); 					   //각 패널에 패스워드 필드 추가
		passS_UpdateCP.add(passS_UpdatePF);
		passF_UpdateCP.add(delete_passPF);

		/*콤포 박스*/
		sex_UpdateCB = new JComboBox<>(sex);                       //콤보박스 객체생성(내용물 등록)
		sex_UpdateCB.setPreferredSize(new Dimension(100,30));	   //사이즈 지정
		sex_UpdateCB.setFont(comboF);							   //글씨체 지정
		sex_UpdateCB.setBorder(new LineBorder(Color.lightGray));   //테두리색 지정
		sex_UpdateCB.setBackground(Color.WHITE);				   //콤보박스 배색 지정

		sexCP.add(sex_UpdateCB);								   //성별 패널에 콤보박스 추가

		/*년,월,일 보여줄 라벨*/
		year_UpdateL.setFont(comboF);							  //폰트 지정
		month_UpdateL.setFont(comboF);
		date_UpdateL.setFont(comboF);

		/*이메일 @ 표현 라벨*/
		email_AtL.setFont(comboF);								  //폰트지정
		email_AtL.setHorizontalAlignment(JLabel.CENTER);		  //라벨 중앙정렬
		
		/*텍스트 필드*/		
		year_UpdateTF.setPreferredSize(new Dimension(80,30));     //사이즈 지정
		month_UpdateTF.setPreferredSize(new Dimension(80,30));
		date_UpdateTF.setPreferredSize(new Dimension(80,30));
		email_UpdateTF.setPreferredSize(new Dimension(105,30));
		email_UpdateDoTF.setPreferredSize(new Dimension(105,30));

		year_UpdateTF.setBorder(new LineBorder(Color.LIGHT_GRAY)); //테두리색 지정
		month_UpdateTF.setBorder(new LineBorder(Color.LIGHT_GRAY));
		date_UpdateTF.setBorder(new LineBorder(Color.LIGHT_GRAY));
		email_UpdateTF.setBorder(new LineBorder(Color.LIGHT_GRAY));		
		email_UpdateDoTF.setBorder(new LineBorder(Color.LIGHT_GRAY));
		
		/*콤보박스*/
		emailC.setFont(comboF);
		emailC.setPreferredSize(new Dimension(110,30));
		emailC.setBorder(new LineBorder(Color.LIGHT_GRAY));
		
		emailCP.add(email_UpdateTF);                  			   //이메일 패널에 텍스트필드 추가
		emailCP.add(email_AtL);
		emailCP.add(email_UpdateDoTF);
		emailCP.add(emailC);

		/*생년월일 패널에 컴포넌트 추가*/
		birthCP.add(year_UpdateTF);
		birthCP.add(year_UpdateL);
		birthCP.add(month_UpdateTF);
		birthCP.add(month_UpdateL);
		birthCP.add(date_UpdateTF);
		birthCP.add(date_UpdateL);

		birthCP.add(birth_mentCP);                               //안내문패널을 지정된 패널에 추가
		emailCP.add(email_mentCP);

		/*경고문 라벨*/
		error_passL.setFont(warnF);							     //폰트 지정
		error_birthL.setFont(warnF);
		error_emailL.setFont(warnF);

		error_passL.setForeground(Color.RED);					 //글자색 지정
		error_birthL.setForeground(Color.RED);
		error_emailL.setForeground(Color.RED);

		error_passL.setPreferredSize(new Dimension(670,10));
		error_birthL.setPreferredSize(new Dimension(670,10));
		error_emailL.setPreferredSize(new Dimension(670,10));

		passS_UpdateCP.add(error_passL);						//각패널에 경고문 추가
		birthCP.add(error_birthL);
		emailCP.add(error_emailL);

		/*수정 완료 버튼*/ 
		update_ConfirmB.setPreferredSize(new Dimension(150,50));
		update_ConfirmB.setFont(confirmBF);
		update_ConfirmB.setBackground(Color.BLACK);
		update_ConfirmB.setForeground(Color.WHITE);
		update_ConfirmB.setFocusPainted(false);
		update_ConfirmB.setBorderPainted(false);
		update_ConfirmP.add(update_ConfirmB);

		/*삭제하기 버튼*/
		delete_ConfirmB.setPreferredSize(new Dimension(150,50));
		delete_ConfirmB.setFont(confirmBF);
		delete_ConfirmB.setBackground(Color.BLACK);
		delete_ConfirmB.setForeground(Color.WHITE);
		delete_ConfirmB.setFocusPainted(false);
		delete_ConfirmB.setBorderPainted(false);
		update_ConfirmP.add(delete_ConfirmB);

		/*수정전에 수정하기 컴포턴트들 숨겨두기*/
		passF_UpdateL.setVisible(false);
		passS_UpdateL.setVisible(false);
		passF_UpdatePF.setVisible(false);
		passS_UpdatePF.setVisible(false);
		delete_passPF.setVisible(false);
		year_UpdateTF.setVisible(false);
		year_UpdateL.setVisible(false);
		month_UpdateTF.setVisible(false);
		month_UpdateL.setVisible(false);
		date_UpdateTF.setVisible(false);
		date_UpdateL.setVisible(false);
		email_UpdateTF.setVisible(false);
		email_UpdateDoTF.setVisible(false);
		email_AtL.setVisible(false);
		emailC.setVisible(false);
		sex_UpdateCB.setVisible(false);
		update_ConfirmB.setVisible(false);
		delete_ConfirmB.setVisible(false);
		error_passL.setVisible(false);
		error_birthL.setVisible(false);
		error_emailL.setVisible(false);

		update_ConfirmB.addActionListener(this);       //버튼 이벤트 추가
		delete_ConfirmB.addActionListener(this);
	}//setUpdateUI()

	public Component setDialog() {
		delete_mentP.setLayout(new BorderLayout());
		
		delete_ment1L.setText("탈퇴하시겠습니까?");
		delete_ment2L.setText("탈퇴 시 모든 회원정보는 삭제되며, 복원할 수 없습니다.");

		delete_ment1L.setFont(comboF);//폰트설정
		delete_ment2L.setFont(comboF);
		
		delete_ment2L.setForeground(Color.RED);

		delete_mentP.add(delete_ment1L,BorderLayout.NORTH);//라벨 패널에 올림
		delete_mentP.add(delete_ment2L,BorderLayout.CENTER);

		return delete_mentP;
	}

	public void changeVisible(int c) {
		if(c==0) {
			/*정보보기 컴포넌트 보이기*/
			passTL.setVisible(true);
			passCL.setVisible(true);
			sexCL.setVisible(true);
			birthCL.setVisible(true);
			emailCL.setVisible(true);
			buttonP.setVisible(true);
			/*수정하기 컴포넌트 숨기기*/
			passF_UpdateL.setVisible(false);
			passS_UpdateL.setVisible(false);
			passF_UpdatePF.setVisible(false);
			passS_UpdatePF.setVisible(false);
			delete_passPF.setVisible(false);
			year_UpdateTF.setVisible(false);
			year_UpdateL.setVisible(false);
			month_UpdateTF.setVisible(false);
			month_UpdateL.setVisible(false);
			date_UpdateTF.setVisible(false);
			date_UpdateL.setVisible(false);
			email_UpdateTF.setVisible(false);
			email_UpdateDoTF.setVisible(false);
			email_AtL.setVisible(false);
			emailC.setVisible(false);
			sex_UpdateCB.setVisible(false);
			update_ConfirmB.setVisible(false);
			error_passL.setVisible(false);
			error_birthL.setVisible(false);
			error_emailL.setVisible(false);
			/*삭제하기 컴포넌트 숨기기*/
			delete_ConfirmB.setVisible(false);
			/*텍스트필드 비우기*/
			passF_UpdatePF.setText("");
			passS_UpdatePF.setText("");
			year_UpdateTF.setText("");
			month_UpdateTF.setText("");
			date_UpdateTF.setText("");
			email_UpdateTF.setText("");
			sex_UpdateCB.setSelectedIndex(0);

		}else if(c==1) {
			/*정보보기 컴포넌트 숨기기*/
			passTL.setVisible(false);
			passCL.setVisible(false);
			sexCL.setVisible(false);
			birthCL.setVisible(false);
			emailCL.setVisible(false);
			buttonP.setVisible(false);
			/*수정하기 컴포넌트 보이기*/
			passF_UpdateL.setVisible(true);
			passS_UpdateL.setVisible(true);
			passF_UpdatePF.setVisible(true);
			passS_UpdatePF.setVisible(true);
			year_UpdateTF.setVisible(true);
			year_UpdateL.setVisible(true);
			month_UpdateTF.setVisible(true);
			month_UpdateL.setVisible(true);
			date_UpdateTF.setVisible(true);
			date_UpdateL.setVisible(true);
			email_UpdateTF.setVisible(true);
			email_UpdateDoTF.setVisible(true);
			email_AtL.setVisible(true);
			emailC.setVisible(true);
			sex_UpdateCB.setVisible(true);
			update_ConfirmB.setVisible(true);
			error_passL.setVisible(true);
			error_birthL.setVisible(true);
			error_emailL.setVisible(true);
			/*삭제하기 컴포넌트 숨기기*/
			delete_passPF.setVisible(false);
			delete_ConfirmB.setVisible(false);
		}else if(c==2) {
			/*정보보기 컴포넌트 보이고 숨기기*/
			passTL.setVisible(true);
			passCL.setVisible(false);
			sexCL.setVisible(true);
			birthCL.setVisible(true);
			emailCL.setVisible(true);
			buttonP.setVisible(false);
			/*수정하기 컴포넌트 숨기기*/
			passF_UpdateL.setVisible(false);
			passS_UpdateL.setVisible(false);
			passF_UpdatePF.setVisible(false);
			passS_UpdatePF.setVisible(false);
			year_UpdateTF.setVisible(false);
			year_UpdateL.setVisible(false);
			month_UpdateTF.setVisible(false);
			month_UpdateL.setVisible(false);
			date_UpdateTF.setVisible(false);
			date_UpdateL.setVisible(false);
			email_UpdateTF.setVisible(false);
			email_UpdateDoTF.setVisible(false);
			email_AtL.setVisible(false);
			emailC.setVisible(false);
			sex_UpdateCB.setVisible(false);
			update_ConfirmB.setVisible(false);
			error_passL.setVisible(false);
			error_birthL.setVisible(false);
			error_emailL.setVisible(false);
			/*삭제하기 컴포넌트 보이기*/
			delete_passPF.setVisible(true);
			delete_ConfirmB.setVisible(true);
		}
	}//changeVisible()

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==updateB) {
			changeVisible(1); //정보입력용 컴포넌트 보여줌, 출력용 라벨 숨김 
		}//수정하기 버튼 클릭 시

		if(e.getSource()==deleteB) {
			changeVisible(2);
		}//탈퇴하기 버튼 클릭 시 

		if(e.getSource()==update_ConfirmB) {
			error_passL.setText("");	//경고문들 초기화(비움)
			error_birthL.setText("");
			error_emailL.setText("");
			
			if(passF_UpdatePF.getText().length()<6 || passF_UpdatePF.getText().length()>16 || 
					!(Pattern.matches("^[a-z0-9]*$",passF_UpdatePF.getText()))) {
				error_passL.setText("비밀번호는 6~16사이 영문소문자와 숫자로만 입력하세요!");
				return;
			}//비밀번호 입력값이 올바르지 않을 때

			if(!passF_UpdatePF.getText().equals(passS_UpdatePF.getText())) {
				error_passL.setText("비밀번호가 일치하지 않습니다!");
				return;
			}//비밀번호 입력값과 재입력값이 다른 경우

			/***앞으로 해야할 것*/
			/*
			 *  버튼에 대한 유효성 검증
			 *  1. 비밀번호 검증
			 *  2. 생년월일 검증(년 : 4자리, 월 : 1~2자리, 일: 1~2자리)
			 *  3. 이메일 검증(@가 포함이 되어있는지)
			 */


			changeVisible(0);//정보입력용 컴포넌트 숨김, 출력용 라벨 보여줌
			/**텍스트필드 비우기**/
		}//수정 버튼 클릭 시

		if(e.getSource()==delete_ConfirmB) {
			/** DB 패스워드 검증 **/
			int deleteResult = dialog.showConfirmDialog(null,setDialog(),"회원탈퇴",dialog.YES_NO_OPTION,dialog.PLAIN_MESSAGE);
			if(deleteResult==dialog.CLOSED_OPTION) {				//닫기버튼 눌렀을 때

			}else if(deleteResult==dialog.YES_OPTION) {				//예 버튼 눌렀을 때
				
				dialog.showMessageDialog(null, "이용해주셔서 감사합니다");
				changeVisible(0);
				/**로그아웃 기능 실행**/
				/**DB delete 구문 실행**/
				/**텍스트필드 비우기**/
			}else if(deleteResult==dialog.NO_OPTION) {				//아니오 버튼 눌렀을 때
				
			}
		}//탈퇴 버튼 클릭 시
	}//aP()

}//MaPagePanel class
