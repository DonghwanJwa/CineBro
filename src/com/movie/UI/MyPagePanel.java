package com.movie.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
public class MyPagePanel extends JPanel{
	JLabel menuL,idTL,passTL,nameTL,sexTL,birthTL,emailTL, //각항목의 제목용 라벨(title label)
	             idCL,passCL,nameCL,sexCL,birthCL,emailCL, //각항목의 내용 출력용 라벨(content label)
	       birth_mentCL, email_mentCL;                     //항목 정보 입력용 라벨(announcement content label)
	JPanel mainP,menuP,titleP,contentP,titleContentP,      //제목들,내용들이 올라갈 패널들
	       idTP,passTP,nameTP,sexTP,birthTP,emailTP, //각항목의 제목용 패널(title panel)
	       idCP,passCP,nameCP,sexCP,birthCP,emailCP, //각항목의 내용 출력라벨용 패널(content panel)	    
	       birth_mentCP, email_mentCP;               //항목 정보 입력용 라벨(announcement content panel)
	JButton updateB;                                 //기본정보 수정 버튼
	
//	-----------------------------------------------------기본정보 수정 페이지에 추가적으로 필요한 변수
	JLabel passF_UpdateL, passS_UpdateL;			 //비밀번호 입력 제목용 라벨 (password number_update label)
	JPasswordField passF_UpdatePF,passS_UpdatePF;    //비밀번호 입력용 패스워드필드(password number_update password field)
	JPanel passF_UpdateTP, passS_UpdateTP,			 //비밀번호 입력 제목용 라벨 올라갈 패널(password number_update title panel)
	   	   passF_UpdateCP, passS_UpdateCP,           //비밀번호 입력용 패스워드 필드 올라갈 패널(password number_update content panel)
	   	   update_ConfirmP;							 //수정 완료 버튼 올라갈 패널
	JTextField year_UpdateTF,date_UpdateTF,          //생년월일 중 년,일 입력용 텍스트필드(update_text field)
			   email_UpdateTF;						 //이메일 입력용 텍스트필드(email_update text fiedl)
	JComboBox<String> sex_UpdateCB, month_UpdateCB;  //성별, 생년월일중 일 입력용 콤보박스(update_combo box)
	JButton update_ConfirmB;  						 //수정 완료버튼
	
	String[] sex = {"남자","여자"};                          //성별 콤보박스 내용물
	String[] month= {"1월","2월","3월","4월","5월","6월",     //생년월일 월 콤모박스 내용물
			          "7월","8월","9월","10월","11월","12월"};
	
	/*폰트 만들기*/
	Font menuF = new Font("맑은 고딕",Font.BOLD,30);
	Font titleTF = new Font("맑은 고딕",Font.BOLD,20);
	Font contentTF = new Font("맑은 고딕",Font.PLAIN,18);
	Font content_mentTF = new Font("맑은 고딕",Font.PLAIN,13);
	Font comboF = new Font("맑은 고딕",Font.BOLD,15);
	Font confirmBF = new Font("맑은 고딕",Font.BOLD,20);
	
	public MyPagePanel() {
		setPreferredSize(new Dimension(1400,800));
		setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
		setOpaque(false);
		setBorder(BorderFactory.createEmptyBorder(50,240,50,240));
		setViewUI();
	}//기본생성자
	
	
    /************************/
	/**기본정보를 보여주는 패널 메서드**/
	/************************/
	public void setViewUI() {
		/*메인 패널 설정*/
		mainP = new JPanel();
		mainP.setPreferredSize(new Dimension(920,700));
		mainP.setLayout(new FlowLayout(FlowLayout.LEFT,0,0)); //flowlayout 좌측정렬,컴포넌트끼리 상하좌우여백 0
		
		/*제목,내용들 올라갈 패널들 설정*/
		menuP = new JPanel();
		titleP = new JPanel();
		contentP = new JPanel();
		titleContentP = new JPanel();

		menuP.setPreferredSize(new Dimension(920,60));            //사이즈설정
		titleP.setPreferredSize(new Dimension(240,640));
		contentP.setPreferredSize(new Dimension(680,640));
		titleContentP.setPreferredSize(new Dimension(920,640));

		menuP.setBackground(Color.DARK_GRAY);                     //임시 색상 설정
		titleP.setBackground(Color.LIGHT_GRAY);
		contentP.setBackground(Color.WHITE);

		menuP.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.BLACK));
		//패널 테두리 설정 (상,좌,하,우,색상)

		menuP.setLayout(new BorderLayout());                      //배치관리자 설정
		titleP.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));    //Flow 좌측정렬, 상하좌우여백 0
		contentP.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
		titleContentP.setLayout(new BorderLayout());              //titleContentP만 보더레이아웃

		add(menuP); add(titleContentP);                           //뼈대가될 패널들을 올림
		titleContentP.add(titleP,BorderLayout.WEST);
		titleContentP.add(contentP,BorderLayout.CENTER);

		/*각항목의 제목용 & 내용용 패널 생성*/
		idTP = new JPanel();      passTP = new JPanel();
		nameTP = new JPanel();    sexTP = new JPanel(); 
		birthTP = new JPanel();   emailTP = new JPanel();

		idCP = new JPanel();      passCP = new JPanel();
		nameCP = new JPanel();    sexCP = new JPanel();
		birthCP = new JPanel();   emailCP = new JPanel();
		birth_mentCP = new JPanel();
		email_mentCP = new JPanel();


		idTP.setPreferredSize(new Dimension(240,100));             //크기지정
		passTP.setPreferredSize(new Dimension(240,140));
		nameTP.setPreferredSize(new Dimension(240,100));
		sexTP.setPreferredSize(new Dimension(240,100));
		birthTP.setPreferredSize(new Dimension(240,100));
		emailTP.setPreferredSize(new Dimension(240,100));

		idCP.setPreferredSize(new Dimension(680,100));
		passCP.setPreferredSize(new Dimension(680,140));
		nameCP.setPreferredSize(new Dimension(680,100));
		sexCP.setPreferredSize(new Dimension(680,100));
		birthCP.setPreferredSize(new Dimension(680,100));
		emailCP.setPreferredSize(new Dimension(680,100));
		birth_mentCP.setPreferredSize(new Dimension(650,25));//birth,email 패널 내에 들어갈 것
		email_mentCP.setPreferredSize(new Dimension(650,25));//크기가 패딩된것보다 작아야한다.(좌측패딩 30)

		
		idTP.setBackground(new Color(240,240,240));                  //배경색 지정
		passTP.setBackground(new Color(240,240,240));
		nameTP.setBackground(new Color(240,240,240));
		sexTP.setBackground(new Color(240,240,240));
		birthTP.setBackground(new Color(240,240,240));
		emailTP.setBackground(new Color(240,240,240));

		idCP.setBackground(Color.WHITE);
		passCP.setBackground(Color.WHITE);
		nameCP.setBackground(Color.WHITE);
		sexCP.setBackground(Color.WHITE);
		birthCP.setBackground(Color.WHITE);
		emailCP.setBackground(Color.WHITE);
		birth_mentCP.setBackground(Color.WHITE);
		email_mentCP.setBackground(Color.WHITE);
	
		
		idTP.setLayout(new FlowLayout(FlowLayout.LEFT));                //패널 내부 레이아웃 지정
		passTP.setLayout(new FlowLayout(FlowLayout.LEFT));
		nameTP.setLayout(new FlowLayout(FlowLayout.LEFT));
		sexTP.setLayout(new FlowLayout(FlowLayout.LEFT));
		birthTP.setLayout(new FlowLayout(FlowLayout.LEFT));
		emailTP.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		idCP.setLayout(new FlowLayout(FlowLayout.LEFT));
		passCP.setLayout(new FlowLayout(FlowLayout.LEFT));
		nameCP.setLayout(new FlowLayout(FlowLayout.LEFT));
		sexCP.setLayout(new FlowLayout(FlowLayout.LEFT));
		birthCP.setLayout(new FlowLayout(FlowLayout.LEFT));
		emailCP.setLayout(new FlowLayout(FlowLayout.LEFT));
		birth_mentCP.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
		email_mentCP.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));

		
		idTP.setBorder(new CompoundBorder(                 //패널 테두리 설정 및 패널 내부 패딩설정(내부공백)
				BorderFactory.createMatteBorder(0,0,1,0,Color.LIGHT_GRAY),
				BorderFactory.createEmptyBorder(20,30,0,0)));     
		passTP.setBorder(new CompoundBorder(
				BorderFactory.createMatteBorder(0,0,1,0,Color.LIGHT_GRAY),
				BorderFactory.createEmptyBorder(20,30,0,0)));
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
		passCP.setBorder(new CompoundBorder(
				BorderFactory.createMatteBorder(0,0,1,0,Color.LIGHT_GRAY),
				BorderFactory.createEmptyBorder(20,30,0,0)));
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
		titleP.add(nameTP);  titleP.add(sexTP);
		titleP.add(birthTP); titleP.add(emailTP);

		contentP.add(idCP); contentP.add(passCP);
		contentP.add(nameCP); contentP.add(sexCP);
		contentP.add(birthCP); contentP.add(emailCP);

		/*로고 라벨 생성*/
		menuL = new JLabel("기본정보",SwingConstants.CENTER);      //라벨 중앙정렬
		menuL.setPreferredSize(new Dimension(140,60)); 
		menuL.setForeground(Color.WHITE);
		menuL.setFont(menuF);
		menuP.add(menuL,BorderLayout.WEST);

		/*제목 라벨 생성 : 각항목의 제목용 라벨(title label)*/
		idTL = new JLabel("아이디");     passTL = new JLabel("비밀번호");   //제목 라벨 객체생성
		nameTL = new JLabel("이름");     sexTL = new JLabel("성별");
		birthTL = new JLabel("생년월일"); emailTL = new JLabel("이메일");

		idTL.setFont(titleTF);    passTL.setFont(titleTF);             //제목 라벨 폰트 지정
		nameTL.setFont(titleTF);  sexTL.setFont(titleTF);
		birthTL.setFont(titleTF); emailTL.setFont(titleTF);

		idTP.add(idTL);       passTP.add(passTL);                      //제목 라벨을 패널에 추가
		nameTP.add(nameTL);   sexTP.add(sexTL);
		birthTP.add(birthTL); emailTP.add(emailTL);

		/*내용 라벨 생성 : 각항목의 내용 출력용 라벨(content label)*/
		idCL = new JLabel("아이디 출력VO");     passCL = new JLabel("비밀번호 공백!!");   //출력 라벨 객체 생성
		nameCL = new JLabel("이름 출력VO");     sexCL = new JLabel("성별 출력VO");
		birthCL = new JLabel("생년월일 출력VO"); emailCL = new JLabel("이메일 출력VO");
		birth_mentCL = new JLabel("설정하신 생일 기준으로 15일전 생일쿠폰을 보내드립니다.");
		email_mentCL = new JLabel("아이디 및 비밀번호 찾기시 메세가 전송되며, 쿠폰 & 이벤트 정보 등을 제공 받으실 수 있습니다.");

		idCL.setFont(contentTF);    passCL.setFont(contentTF);           //출력 라벨 폰트 지정
		nameCL.setFont(contentTF);  sexCL.setFont(contentTF);
		birthCL.setFont(contentTF); emailCL.setFont(contentTF);
		birth_mentCL.setFont(content_mentTF);
		email_mentCL.setFont(content_mentTF);
		
		birth_mentCL.setForeground(Color.LIGHT_GRAY);                   //안내문 글자색 지정
		email_mentCL.setForeground(Color.LIGHT_GRAY);                   	

		idCP.add(idCL);       passCP.add(passCL);                       //출력 라벨 패널에 추가
		nameCP.add(nameCL);   sexCP.add(sexCL);
		birthCP.add(birthCL); emailCP.add(emailCL);
		birth_mentCP.add(birth_mentCL);
		email_mentCP.add(email_mentCL);
		
		birthCP.add(birth_mentCP);                               //안내문패널을 지정된 패널에 추가
		emailCP.add(email_mentCP);
		
		/*수정 버튼 생성*/
		updateB = new JButton("수정하기");          
		updateB.setBackground(Color.BLACK);
		updateB.setForeground(Color.WHITE);
		updateB.setFocusPainted(false);
		updateB.setBorderPainted(false);
//		updateB.addActionListener(this);            //버튼 이벤트 추가
		menuP.add(updateB,BorderLayout.EAST);
		
	}//setViewUI()
	
	
	/********************************/
	/**기본정보 수정 페이지를 보여주는 패널 메서드**/
	/********************************/
	public void setUpdateUI() {
		/*메인 패널 설정*/
		setPreferredSize(new Dimension(920,760));
		setLayout(new FlowLayout(FlowLayout.LEFT,0,0)); //flowlayout 좌측정렬,컴포넌트끼리 상하좌우여백 0
		
		/*제목,내용들 올라갈 패널들 설정*/
		menuP = new JPanel();
		titleP = new JPanel();
		contentP = new JPanel();
		titleContentP = new JPanel();
		update_ConfirmP = new JPanel();

		menuP.setPreferredSize(new Dimension(920,60));            //사이즈설정
		titleP.setPreferredSize(new Dimension(240,640));
		contentP.setPreferredSize(new Dimension(680,640));
		titleContentP.setPreferredSize(new Dimension(920,640));
		update_ConfirmP.setPreferredSize(new Dimension(920,70));

		menuP.setBackground(Color.DARK_GRAY);                     //임시 색상 설정
		titleP.setBackground(Color.LIGHT_GRAY);
		contentP.setBackground(Color.WHITE);
		update_ConfirmP.setBackground(Color.DARK_GRAY);

		menuP.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.BLACK));  //테두리
		update_ConfirmP.setBorder(BorderFactory.createEmptyBorder(10,0,10,0));  //패딩

		menuP.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));     //배치관리자 설정
		titleP.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));    //Flow 좌측정렬, 상하좌우여백 0
		contentP.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
		titleContentP.setLayout(new BorderLayout());              //titleContentP만 보더레이아웃
		update_ConfirmP.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));

		add(menuP); add(titleContentP);                           //뼈대가될 패널들을 올림
		titleContentP.add(titleP,BorderLayout.WEST);
		titleContentP.add(contentP,BorderLayout.CENTER);
		add(update_ConfirmP);

		/*각항목의 제목용 & 내용용 패널 생성*/
		idTP = new JPanel();      passTP = new JPanel();
		passF_UpdateTP = new JPanel();
		passS_UpdateTP = new JPanel();
		nameTP = new JPanel();    sexTP = new JPanel(); 
		birthTP = new JPanel();   emailTP = new JPanel();

		idCP = new JPanel();      passCP = new JPanel();
		passF_UpdateCP = new JPanel();
		passS_UpdateCP = new JPanel();
		nameCP = new JPanel();    sexCP = new JPanel();
		birthCP = new JPanel();   emailCP = new JPanel();
		birth_mentCP = new JPanel();
		email_mentCP = new JPanel();


		idTP.setPreferredSize(new Dimension(240,100));             //크기지정
		passTP.setPreferredSize(new Dimension(240,140));
		passF_UpdateTP.setPreferredSize(new Dimension(240,70));
		passS_UpdateTP.setPreferredSize(new Dimension(240,70));
		nameTP.setPreferredSize(new Dimension(240,100));
		sexTP.setPreferredSize(new Dimension(240,100));
		birthTP.setPreferredSize(new Dimension(240,100));
		emailTP.setPreferredSize(new Dimension(240,100));

		idCP.setPreferredSize(new Dimension(680,100));
		passCP.setPreferredSize(new Dimension(680,140));
		passF_UpdateCP.setPreferredSize(new Dimension(680,70));
		passS_UpdateCP.setPreferredSize(new Dimension(680,70));
		nameCP.setPreferredSize(new Dimension(680,100));
		sexCP.setPreferredSize(new Dimension(680,100));
		birthCP.setPreferredSize(new Dimension(680,100));
		emailCP.setPreferredSize(new Dimension(680,100));
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

		
		idTP.setBorder(new CompoundBorder(                                //패널 테두리 설정 및 패널 내부 패딩설정(내부공백)
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
		menuL = new JLabel("기본정보수정",SwingConstants.CENTER);      //라벨 중앙정렬
		menuL.setPreferredSize(new Dimension(140,60)); 
		menuL.setForeground(Color.WHITE);
		menuL.setFont(menuF);
		menuP.add(menuL);

		/*제목 라벨 생성 : 각항목의 제목용 라벨(title label)*/
		idTL = new JLabel("아이디");                                     //제목 라벨 객체생성
		passF_UpdateL = new JLabel("비밀번호 입력");  
		passS_UpdateL = new JLabel("비밀번호 재입력");   
		nameTL = new JLabel("이름");     sexTL = new JLabel("성별");
		birthTL = new JLabel("생년월일"); emailTL = new JLabel("이메일");

		idTL.setFont(titleTF);    									   //제목 라벨 폰트 지정
		passF_UpdateL.setFont(titleTF);             
		passS_UpdateL.setFont(titleTF);             
		nameTL.setFont(titleTF);  sexTL.setFont(titleTF);
		birthTL.setFont(titleTF); emailTL.setFont(titleTF);

		idTP.add(idTL);           					                  //제목 라벨을 패널에 추가
		passF_UpdateTP.add(passF_UpdateL);
		passS_UpdateTP.add(passS_UpdateL);
		nameTP.add(nameTL);   sexTP.add(sexTL);
		birthTP.add(birthTL); emailTP.add(emailTL);

		/*내용 객체 생성 : 각항목의 내용 입력용 객체(update)*/
		/*아이디,이름, 안내문 라벨*/
		idCL = new JLabel("아이디 출력VO");                                //아이디,이름 출력라벨 객체생성
		nameCL = new JLabel("이름 출력VO");     		
		birth_mentCL = new JLabel("설정하신 생일 기준으로 15일전 생일쿠폰을 보내드립니다.");
		email_mentCL = new JLabel("아이디 및 비밀번호 찾기시 메세가 전송되며, 쿠폰 & 이벤트 정보 등을 제공 받으실 수 있습니다.");

		idCL.setFont(contentTF);                                         //폰트 지정
		nameCL.setFont(contentTF);
		birth_mentCL.setFont(content_mentTF);
		email_mentCL.setFont(content_mentTF);
		
		birth_mentCL.setForeground(Color.LIGHT_GRAY);                   //안내문 글자색 지정
		email_mentCL.setForeground(Color.LIGHT_GRAY);
		
		idCP.add(idCL);                                                 //각각의 패널에 라벨 추가
		nameCP.add(nameCL);
		birth_mentCP.add(birth_mentCL);
		email_mentCP.add(email_mentCL);
		
		/*비밀번호 패스워드 필드*/
		passF_UpdatePF = new JPasswordField();                     //패스워드 필드 생성
		passS_UpdatePF = new JPasswordField();
		
		passF_UpdatePF.setPreferredSize(new Dimension(200,30));    //패스워드 필드 크기 지정
		passS_UpdatePF.setPreferredSize(new Dimension(200,30));
		
		passF_UpdatePF.setBorder(new LineBorder(Color.LIGHT_GRAY));//패널 테두리 색 지정ㄴ
		passS_UpdatePF.setBorder(new LineBorder(Color.LIGHT_GRAY));
		
		passF_UpdateCP.add(passF_UpdatePF); 					   //각 패널에 패스워드 필드 추가
		passS_UpdateCP.add(passS_UpdatePF);
		
		/*콤포 박스*/
		sex_UpdateCB = new JComboBox<>(sex);                       //콤보박스 객체생성(내용물 등록)
		month_UpdateCB = new JComboBox<>(month);
		    
		sex_UpdateCB.setPreferredSize(new Dimension(100,30));	   //사이즈 지정
		month_UpdateCB.setPreferredSize(new Dimension(100,30));
		
		sex_UpdateCB.setFont(comboF);							   //글씨체 지정
		month_UpdateCB.setFont(comboF);
		
		sex_UpdateCB.setBorder(new LineBorder(Color.lightGray));   //테두리색 지정
		month_UpdateCB.setBorder(new LineBorder(Color.lightGray));
		
		sex_UpdateCB.setBackground(Color.WHITE);				   //콤보박스 배색 지정
		month_UpdateCB.setBackground(Color.WHITE);
		
		sexCP.add(sex_UpdateCB);								   //성별 패널에 콤보박스 추가
		
		/*텍스트 필드*/
		year_UpdateTF = new JTextField();						   //텍스트필드 객체 생성
		date_UpdateTF = new JTextField();
		email_UpdateTF = new JTextField();
		
		year_UpdateTF.setPreferredSize(new Dimension(100,30));     //사이즈 지정
		date_UpdateTF.setPreferredSize(new Dimension(100,30));
		email_UpdateTF.setPreferredSize(new Dimension(200,30));
		
		year_UpdateTF.setBorder(new LineBorder(Color.LIGHT_GRAY)); //테두리색 지정
		date_UpdateTF.setBorder(new LineBorder(Color.LIGHT_GRAY));
		email_UpdateTF.setBorder(new LineBorder(Color.LIGHT_GRAY));		
		
		emailCP.add(email_UpdateTF);                  			   //이메일 패널에 텍스트필드 추가
		
		/*생년월일 패널에 컴포넌트 추가*/
		birthCP.add(year_UpdateTF);
		birthCP.add(month_UpdateCB);
		birthCP.add(date_UpdateTF);
		
		birthCP.add(birth_mentCP);                               //안내문패널을 지정된 패널에 추가
		emailCP.add(email_mentCP);

		/*수정 완료 버튼*/
		update_ConfirmB = new JButton("수정 완료");         
		update_ConfirmB.setPreferredSize(new Dimension(150,50));
		update_ConfirmB.setFont(confirmBF);
		update_ConfirmB.setBackground(Color.BLACK);
		update_ConfirmB.setForeground(Color.WHITE);
		update_ConfirmB.setFocusPainted(false);
		update_ConfirmB.setBorderPainted(false);
//		update_ConfirmB.addActionListener(this);       //버튼 이벤트 추가
		update_ConfirmP.add(update_ConfirmB);
		
	}//setUpdateUI()

	public static void main(String[] args) {
		JFrame f = new JFrame();
		MyPagePanel m = new MyPagePanel();
		f.setTitle("MyPage");
		f.setSize(940,740);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(m);
		f.setVisible(true);
	}//main() 나중에 지울것

}//MaPagePanel class
