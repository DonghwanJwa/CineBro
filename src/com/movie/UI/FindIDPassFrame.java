package com.movie.UI;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

import com.movie.main.AppManager;

/**아이디/비밀번호 찾기 Frame**/
/* 아이디패널 클래스, 비밀번호 찾기 패널 클래스 따로 생성
 * 각 패널은 각각의 버튼에 따라 보여지게 된다.(CardLayout(?))
 */
public class FindIDPassFrame extends JFrame{
	private JPanel mainP = new JPanel();                 //배경이 되는 패널
	private JPanel buttonbarP = new JPanel();            //버튼이 올라갈 패널(상단)
	protected JPanel card_backgroundP = new JPanel();      //주요 패널들을 카드패널로 올릴 패널
	protected JPanel find_idP = new JPanel();               //아이디 찾기 화면 패널(카드패널)
	protected JPanel find_passP = new JPanel();             //비밀번호 찾기 화면 패널(카드패널)
	private JPanel first_idP = new JPanel();             //아이디 찾기 정보 입력 패널(입력:성함,이메일)
	private JPanel second_idP = new JPanel();            //아이디 찾기 정보 출력 패널(출력:아이디)
	private JPanel first_passP = new JPanel();           //비밀번호 찾기 정보 입력 패널(입력:아이디,성함,이메일)
	private JPanel second_passP = new JPanel();          //비밀번호 찾기 정보 수정 패널(수정:비밀번호)

	protected JButton find_idB = new JButton("아이디 찾기");    //아이디 찾기,비밀번호 찾기 패널 전환버튼
	protected JButton find_passB = new JButton("비밀번호 찾기");
	protected JButton confirm_idB = new JButton("확인");      //아이디 찾기 정보입력 후 확인 버튼 
	protected JButton confirm_passB = new JButton("확인");    //비밀번호 찾기 정보입력 후 확인 버튼 
	protected JButton update_passB = new JButton("변경하기");  //비밀번호 찾기 비밀번호 변경하기 버튼
	protected JButton back_closeidB = new JButton("돌아가기");  //찾기 완료 후 돌아가기 버튼(해당 프레임 종료)

	protected JTextField name_idTF = new JTextField();       //아이디 찾기 이름 입력 텍스트필드
	protected JTextField email_idTF = new JTextField();      //아이디 찾기 이메일 입력 텍스트필드
	protected JTextField id_passTF = new JTextField();       //비밀번호 찾기 이메일 입력 텍스트필드
	protected JTextField name_passTF = new JTextField();     //비밀번호 찾기 이메일 입력 텍스트필드
	protected JTextField email_passTF = new JTextField();    //비밀번호 찾기 이메일 입력 텍스트필드
	
	protected JPasswordField pass_PF = new JPasswordField();  //비밀번호 입력 필드
	protected JPasswordField passre_PF = new JPasswordField();//비밀번호 재입력 필드

	private JLabel emptyL = new JLabel(" ");             //아이디 찾기,비밀번호 찾기 버튼 사이 공백만드는 라벨
	private JLabel name_idtitleL = new JLabel("성함");       //아이디 찾기 페이지 이름 타이틀 라벨
	private JLabel email_idtitleL = new JLabel("이메일주소");  //아이디 찾기 페이지 이메일 타이틀 라벨
	private JLabel id_passtitleL = new JLabel("아이디");		//비밀번호 찾기 아이디 타이틀 라벨
	private JLabel name_passtitleL = new JLabel("성함"); 	//비밀번호 찾기 이름 타이틀 라벨
	private JLabel email_passtitleL = new JLabel("이메일주소");	//비밀번호 찾기 이메일 타이틀 라벨
	protected JLabel error_idL = new JLabel();              //id찾기 경고문 출력 라벨 setText()로 문구 변경 
	protected JLabel error_passL = new JLabel();            //pass찾기 경고문 출력 라벨 setText()로 문구 변경
	protected JLabel wrong_passL = new JLabel();			 //pass설정 경고문 출력 라벨
	protected JLabel show_nameL = new JLabel();            //~님의 아이디는          출력라벨
	protected JLabel show_idL = new JLabel();              //"아이디명" 입니다. 출력라벨
	private JLabel pass_passtitleL = new JLabel("비밀번호 입력");		 //비밀번호 찾기 비밀번호 입력 타이틀 라벨
	private JLabel passre_passtitleL = new JLabel("비밀번호 재입력");	 //비밀번호 찾기 비밀번호 재입력 타이틀 라벨

	protected JOptionPane pass_updateD;
	protected CardLayout cardlayout = new CardLayout(0,0); //카드레이아웃
	private Font font = new Font("맑은 고딕",Font.BOLD,15); //컴포넌트에 적용시킬 폰트
	private Font warnF = new Font("맑은 고딕",Font.PLAIN,10);

	public FindIDPassFrame() {
		AppManager.getInstance().setFindIDPassFrame(this);
		
		setTitle("아이디/비밀번호 찾기");
		setSize(new Dimension(600,527));//높이 : 500(화면)+27(틀과 상태창)
		setResizable(false);
		setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
		setLocationRelativeTo(null); // 팝업창 뜨는 위치를 화면 중앙으로 설정
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		/*배경이 되는 패널*/
		mainP.setPreferredSize(new Dimension(600,500));
		mainP.setBackground(Color.WHITE);
		mainP.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
		mainP.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		add(mainP);

		/*버튼을 올릴 패널*/
		buttonbarP.setPreferredSize(new Dimension(580,30));
		buttonbarP.setBackground(Color.WHITE);
		buttonbarP.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
		mainP.add(buttonbarP);

		/*버튼 설정 및 버튼패널에 올리기*/
		find_idB.setPreferredSize(new Dimension(120,30));  //사이즈 지정
		find_passB.setPreferredSize(new Dimension(120,30));

		find_idB.setFont(font);                           //폰트 지정
		find_passB.setFont(font);

		find_idB.setBorder(new LineBorder(Color.red,3));  //테두리색 지정
		find_passB.setBorder(new LineBorder(Color.red,3));

		find_idB.setBackground(Color.RED);                //배경색 지정
		find_passB.setBackground(Color.WHITE);

		find_idB.setFocusPainted(false);                  //버튼 포커스 해제
		find_passB.setFocusPainted(false);

		buttonbarP.add(find_idB);                         //버튼패널에 버튼 추가
		buttonbarP.add(emptyL);
		buttonbarP.add(find_passB);

		/*중앙에 올릴 카드패널*/
		card_backgroundP.setPreferredSize(new Dimension(580,450));
		card_backgroundP.setLayout(cardlayout);
		mainP.add(card_backgroundP);

		setIDFindPanel();  //아이디찾기 패널, 비밀번호 찾기 패널 추가
		setPassFindPanel();

		setVisible(true);
	}//생성자

	public void setIDFindPanel() {
		/*아이디 찾기 패널(카드패널 위의 카드패널)*/
		find_idP.setPreferredSize(new Dimension(580,450));
		card_backgroundP.add(find_idP,"find_idB");
		find_idP.setLayout(cardlayout);

		/*아이디 찾기 정보 입력 패널*/
		first_idP.setPreferredSize(new Dimension(580,450));
		first_idP.setBackground(Color.WHITE);
		first_idP.setLayout(new FlowLayout(FlowLayout.CENTER,0,5));
		first_idP.setBorder(new CompoundBorder(
				BorderFactory.createLineBorder(Color.LIGHT_GRAY,1),
				BorderFactory.createEmptyBorder(95,115,100,115))
				);


		name_idtitleL.setFont(font);   //라벨 폰트 설정
		email_idtitleL.setFont(font);
		error_idL.setFont(warnF);
		name_idTF.setFont(font);        //텍스트 필드 폰트 설정
		email_idTF.setFont(font);
		confirm_idB.setFont(font);   //버튼 폰트 설정

		error_idL.setForeground(Color.RED);                    //경고문 글자색 빨간색 지정

		name_idtitleL.setPreferredSize(new Dimension(350,40));   //컴포넌트 사이즈 지정
		email_idtitleL.setPreferredSize(new Dimension(350,40));
		error_idL.setPreferredSize(new Dimension(350,20));
		name_idTF.setPreferredSize(new Dimension(350,40));
		email_idTF.setPreferredSize(new Dimension(350,40));
		confirm_idB.setPreferredSize(new Dimension(100,40));	

		name_idTF.setBorder(new LineBorder(Color.BLACK));         //텍스트 필드 테두리
		email_idTF.setBorder(new LineBorder(Color.BLACK));

		first_idP.add(name_idtitleL);                            //아이디 찾기 정보입력 창에 컴포넌트 추가
		first_idP.add(name_idTF);
		first_idP.add(email_idtitleL);
		first_idP.add(email_idTF);
		first_idP.add(error_idL);
		first_idP.add(confirm_idB);

		/*아이디 찾기 정보 출력 패널*/
		second_idP.setPreferredSize(new Dimension(580,450));
		second_idP.setBackground(Color.WHITE);
		second_idP.setLayout(new FlowLayout(FlowLayout.CENTER,0,10));
		second_idP.setBorder(new CompoundBorder(
				BorderFactory.createLineBorder(Color.LIGHT_GRAY,1),
				BorderFactory.createEmptyBorder(140,115,150,115))
				);

		show_nameL.setFont(font);                 			 //컴포넌트 폰트 지정
		show_idL.setFont(font);
		back_closeidB.setFont(font);

		show_nameL.setHorizontalAlignment(JLabel.CENTER);    //라벨 중앙정렬
		show_idL.setHorizontalAlignment(JLabel.CENTER);


		

		show_nameL.setPreferredSize(new Dimension(350,40));  //컴포넌트 크기지정
		show_idL.setPreferredSize(new Dimension(350,40));
		back_closeidB.setPreferredSize(new Dimension(100,40));

		second_idP.add(show_nameL);							 //아이디 찾기 정보출력 창에 컴포넌트 추가
		second_idP.add(show_idL);
		second_idP.add(back_closeidB);

		find_idP.add(first_idP);
		find_idP.add(second_idP,"confirm_idB");

	}//setIDFind()

	public void setPassFindPanel() {
		pass_updateD = new JOptionPane();  //다이어로그 생성용 옵션패널
		
		/*비밀번호 찾기 패널(카드패널 위의 카드패널)*/
		find_passP.setPreferredSize(new Dimension(580,450));
		card_backgroundP.add(find_passP,"find_passB");
		find_passP.setLayout(cardlayout);

		/*비밀번호 찾기 정보 입력 패널*/
		first_passP.setPreferredSize(new Dimension(580,450));
		first_passP.setBackground(Color.WHITE);
		first_passP.setLayout(new FlowLayout(FlowLayout.CENTER,0,5));
		first_passP.setBorder(new CompoundBorder(
				BorderFactory.createLineBorder(Color.LIGHT_GRAY,1),
				BorderFactory.createEmptyBorder(50,115,55,115))
				);

		id_passtitleL.setFont(font);            				   //컴포넌트 폰트 지정
		name_passtitleL.setFont(font);
		email_passtitleL.setFont(font);
		id_passTF.setFont(font);
		name_passTF.setFont(font);
		email_passTF.setFont(font);
		error_passL.setFont(warnF);
		confirm_passB.setFont(font);

		error_passL.setForeground(Color.RED);   				  //경고문 글자 빨강색 지정

		id_passtitleL.setPreferredSize(new Dimension(350,40));    //컴포넌트 사이즈 지정
		name_passtitleL.setPreferredSize(new Dimension(350,40));
		email_passtitleL.setPreferredSize(new Dimension(350,40));
		id_passTF.setPreferredSize(new Dimension(350,40));
		name_passTF.setPreferredSize(new Dimension(350,40));
		email_passTF.setPreferredSize(new Dimension(350,40));
		error_passL.setPreferredSize(new Dimension(350,20));
		confirm_passB.setPreferredSize(new Dimension(100,40));

		id_passTF.setBorder(new LineBorder(Color.BLACK));          //텍스트필드 테두리 색 지정
		name_passTF.setBorder(new LineBorder(Color.BLACK)); 
		email_passTF.setBorder(new LineBorder(Color.BLACK)); 

		first_passP.add(id_passtitleL);
		first_passP.add(id_passTF);
		first_passP.add(name_passtitleL);
		first_passP.add(name_passTF);
		first_passP.add(email_passtitleL);
		first_passP.add(email_passTF);
		first_passP.add(error_passL);
		first_passP.add(confirm_passB);
		
		/*비밀번호 찾기 정보 출력 패널*/
		second_passP.setPreferredSize(new Dimension(580,450));
		second_passP.setBackground(Color.WHITE);
		second_passP.setLayout(new FlowLayout(FlowLayout.CENTER,0,5));
		second_passP.setBorder(new CompoundBorder(
				BorderFactory.createLineBorder(Color.LIGHT_GRAY,1),
				BorderFactory.createEmptyBorder(70,115,75,115))
				);
		
		pass_passtitleL.setFont(font);								//폰트 설정
		passre_passtitleL.setFont(font);
		wrong_passL.setFont(warnF);
		update_passB.setFont(font);
		
		wrong_passL.setForeground(Color.RED);
		
		pass_passtitleL.setPreferredSize(new Dimension(350,40));	//컴포넌트 크기 지정
		passre_passtitleL.setPreferredSize(new Dimension(350,40)); 
		pass_PF.setPreferredSize(new Dimension(350,40));
		passre_PF.setPreferredSize(new Dimension(350,40));
		wrong_passL.setPreferredSize(new Dimension(350,20));
		update_passB.setPreferredSize(new Dimension(100,40));
		
		pass_PF.setBorder(new LineBorder(Color.BLACK));				//패스워드 필드 테두리 색
		passre_PF.setBorder(new LineBorder(Color.BLACK));
		
		second_passP.add(pass_passtitleL);
		second_passP.add(pass_PF);
		second_passP.add(passre_passtitleL);
		second_passP.add(passre_PF);
		second_passP.add(wrong_passL);
		second_passP.add(update_passB);
		
		find_passP.add(first_passP);
		find_passP.add(second_passP,"confirm_passB");
	}//setPassFind()

	public void addFindListener(ActionListener listener) {
		find_idB.addActionListener(listener);
		find_passB.addActionListener(listener);
		confirm_idB.addActionListener(listener);
		back_closeidB.addActionListener(listener);
		confirm_passB.addActionListener(listener);
		update_passB.addActionListener(listener);
	}//addFindListener()
}
