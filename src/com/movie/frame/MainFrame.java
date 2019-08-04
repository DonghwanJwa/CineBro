package com.movie.frame;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.movie.UI.LoginPage;
import com.movie.UI.MoviePage;
import com.movie.UI.MoviePanel;
import com.movie.UI.MovieReservationCheckPanel;
import com.movie.UI.MyPagePanel;
import com.movie.UI.ReservationPanel;

public class MainFrame extends JFrame implements ActionListener{
	/*메인프레임 변수*/
	private JPanel mainP,menuP,infoP,info_movieP,mainCardP,right_EmptyP;
	private JButton homeB,now_movieB,reservationB,checkB,myPageB;
	private final CardLayout card=new CardLayout();

	static Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize(); // 화면해상도 가져옴
	static int width=screenSize.width;
	static int height=screenSize.height;

	ImageIcon background;

	MoviePanel home_P=new MoviePanel();
	LogoPanel logoP=new LogoPanel();
	ReservationPanel reservationP=new ReservationPanel();
	MovieReservationCheckPanel checkP=new MovieReservationCheckPanel();
	MoviePage now_movieP=new MoviePage();
	MyPagePanel myPageP=new MyPagePanel();

	public MainFrame() {
		Font font=new Font("맑은 고딕",Font.BOLD,15);
		setExtendedState(JFrame.MAXIMIZED_BOTH);; // 프레임 열릴때 전체화면으로 오픈됨

		/* 메인패널 설정 */
		background = new ImageIcon("background.jpg"); //배경화면 아이콘 객체 생성
		mainP=new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				g.drawImage(background.getImage(),0,0,null);
				setOpaque(false);
				super.paintComponent(g);
			}
		};//mainP에 이미지 입힘(배경화면 설정)

		mainP.setPreferredSize(new Dimension(1920,1040));
		//해상도 1920,1080 기준으로 페이지 사이즈 제작
		//하단 작업표시줄의 높이가 40픽셀이므로, 메인프레임 높이를 1040으로 설정

		mainP.setLayout(new BorderLayout());

		/* 메인 외 다른 패널 생성 */
		menuP=new JPanel();
		infoP=new JPanel();
		info_movieP=new JPanel();
		mainCardP=new JPanel();
		right_EmptyP=new JPanel();

		/* 메뉴 패널 설정 */
		menuP.setLayout(new GridLayout(0,1));
		menuP.setBorder(BorderFactory.createEmptyBorder(20,200,450,40)); // 패널 내부공백 설정
		menuP.setOpaque(false);
		menuP.setPreferredSize(new Dimension(350,800));

		/*우측 공백 패널 설정*/
		right_EmptyP.setPreferredSize(new Dimension(150,800));
		right_EmptyP.setOpaque(false);

		/* 버튼 생성 */
		homeB=new JButton("HOME");
		now_movieB=new JButton("현재상영작");
		reservationB=new JButton("예매하기");
		checkB=new JButton("예매조회");
		myPageB=new JButton("MY PAGE");

		/* 버튼 설정 */
		homeB.setFont(font);                 //버튼 폰트
		now_movieB.setFont(font);
		reservationB.setFont(font);
		checkB.setFont(font);
		myPageB.setFont(font);

		homeB.setFocusPainted(false);        //버튼 포커스
		now_movieB.setFocusPainted(false);
		reservationB.setFocusPainted(false);
		checkB.setFocusPainted(false);
		myPageB.setFocusPainted(false);

		homeB.setBorderPainted(false);       //윤곽선 설정
		now_movieB.setBorderPainted(false);
		reservationB.setBorderPainted(false);
		checkB.setBorderPainted(false);
		myPageB.setBorderPainted(false);

		homeB.setBackground(Color.RED.brighter());      // 버튼 배경색 설정
		now_movieB.setBackground(Color.GRAY.brighter());
		reservationB.setBackground(Color.GRAY.brighter());
		checkB.setBackground(Color.GRAY.brighter());
		myPageB.setBackground(Color.GRAY.brighter());

		/* 버튼에 이벤트 추가 */
		homeB.addActionListener(this);
		now_movieB.addActionListener(this);
		reservationB.addActionListener(this);
		checkB.addActionListener(this);
		myPageB.addActionListener(this);

		/* 메뉴에 버튼 추가*/
		menuP.add(homeB); menuP.add(now_movieB); menuP.add(reservationB);
		menuP.add(checkB); menuP.add(myPageB);

		/* 정보 패널 설정 */
		infoP.setPreferredSize(new Dimension(1500,150));
		infoP.setBackground(Color.LIGHT_GRAY); // 인포패널 배경색 변경

		/* 정보/영화 패널 설정 */
		info_movieP.setLayout(new BorderLayout());

		/* 정보/영화 패널에 정보, 영화패널 합침 */
		info_movieP.add(home_P,BorderLayout.CENTER);
		info_movieP.add(infoP,BorderLayout.SOUTH);

		/* 카드 패널 배치관리자 변경 */
		mainCardP.setLayout(card);

		/* 카드패널에 넣을 패널 생성&설정 */
		reservationP.setBackground(Color.CYAN);
		
		/* 카드패널 배경 투명도 설정*/
		mainCardP.setOpaque(false);
		myPageP.setOpaque(false);

		/* 카드패널에 패널 추가 */
		mainCardP.add(info_movieP,"homeB");      // 카드패널에 패널추가하고 키설정
		mainCardP.add(now_movieP,"now_movieB"); 
		mainCardP.add(reservationP,"reservationB"); 
		mainCardP.add(checkP,"checkB");
		mainCardP.add(myPageP,"myPageB");

		/* 메인 패널에 나머지 패널추가 */
		mainP.add(menuP,BorderLayout.WEST);
		mainP.add(right_EmptyP,BorderLayout.EAST);
		mainP.add(mainCardP,BorderLayout.CENTER); // 영화/정보 패널 합친 패널
		mainP.add(logoP,BorderLayout.NORTH);		
		add(mainP); // 프레임에 메인패널 추가

		/* 스크롤생성 */
		JScrollPane scroll=new JScrollPane(mainP,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS); // 메인 프레임에 스크롤 적용 후 상하스크롤 항상 보이게, 좌우스크롤 항상 숨김
		scroll.getVerticalScrollBar().setValue((1080-height)/2); //프로그램 시작시 상하 스크롤바 시작지점
		scroll.getHorizontalScrollBar().setValue((1920-width)/2);//프로그램 시작시 좌우 스크롤바 시작지점
		/*
		 *   프로그램이 해상도 1920,1080에 맞춰져 있기 때문에, 이보다 작은 해상도에서는 프로그램 첫시작시 불편하게(?) 시작됨
		 *   이를 방지하기 위해서 최대한 중앙에 맞춰서 나타나도록 설정(1920-화면해상도)/2 
		 *   => 화면의 차이 길이 만큼 스크롤바가 생기는데, 이를 반으로 나눈값이 스크롤바의 중앙값이 됨
		 */ 

		add(scroll); // 프레임에 스크롤 추가

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // X키눌러 프레임종료
		setVisible(true); // 항상 보이게 함
	}//cons MainFrame()
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==homeB) {
			homeB.setBackground(Color.RED); // 버튼클릭시 클릭한 버튼 배경색 변경
			now_movieB.setBackground(Color.GRAY.brighter());
			reservationB.setBackground(Color.GRAY.brighter());
			checkB.setBackground(Color.GRAY.brighter());
			myPageB.setBackground(Color.GRAY.brighter());
			card.show(mainCardP,"homeB"); // "homeB"키가 적용된 카드레이아웃 보여줌

		}//if
		if(e.getSource()==now_movieB){
			homeB.setBackground(Color.GRAY.brighter());
			now_movieB.setBackground(Color.RED);
			reservationB.setBackground(Color.GRAY.brighter());
			checkB.setBackground(Color.GRAY.brighter());
			myPageB.setBackground(Color.GRAY.brighter());
			card.show(mainCardP,"now_movieB");
		}//if
		if(e.getSource()==reservationB) {
			homeB.setBackground(Color.GRAY.brighter());
			now_movieB.setBackground(Color.GRAY.brighter());
			reservationB.setBackground(Color.RED);
			checkB.setBackground(Color.GRAY.brighter());
			myPageB.setBackground(Color.GRAY.brighter());
			card.show(mainCardP,"reservationB");
		}//if
		if(e.getSource()==checkB) {
			homeB.setBackground(Color.GRAY.brighter());
			now_movieB.setBackground(Color.GRAY.brighter());
			reservationB.setBackground(Color.GRAY.brighter());
			checkB.setBackground(Color.RED);
			myPageB.setBackground(Color.GRAY.brighter());
			card.show(mainCardP,"checkB");
		}//if
		if(e.getSource()==myPageB) {
			homeB.setBackground(Color.GRAY.brighter());
			now_movieB.setBackground(Color.GRAY.brighter());
			reservationB.setBackground(Color.GRAY.brighter());
			checkB.setBackground(Color.GRAY.brighter());
			myPageB.setBackground(Color.RED);
			card.show(mainCardP,"myPageB");
		}//if
	}//aP() => 버튼 클릭시 발생 이벤트

	class LogoPanel extends JPanel {
		JButton login,regist;
		JLabel logoL;
		JPanel buttonPanel;

		public LogoPanel() {
			setLayout(null); // 로고패널 레이아웃 해제
			setPreferredSize(new Dimension(1500,150));
			setOpaque(false);

			/* 로고 이미지 생성*/
			ImageIcon preImg = new ImageIcon("logo.png");//포스터 넣는란
			Image originImg = preImg.getImage();//ImageIcon을 Image로 전환
			Image changeImg = originImg.getScaledInstance(735,150,java.awt.Image.SCALE_SMOOTH);
			//이미지 사이즈 가로150,세로214
			ImageIcon logoI = new ImageIcon(changeImg);

			/* 로고 라벨 생성*/
			logoL = new JLabel(logoI);
			logoL.setOpaque(false);
			add(logoL);
			logoL.setBounds(593,0,735,150);

			/* 버튼 객체 생성 */
			login=new JButton("로그인");
			regist=new JButton("회원가입");
			/* 버튼 이벤트 작성 */
			login.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					new LoginPage();
				}//aP() => 버튼을 눌렀을때 실행			
			}); // 로그인 버튼에 이벤트 생성
			regist.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					new SignUp();
				}				
			});
			/* 패널 생성 */
			buttonPanel=new JPanel();
			/* 패널 설정 */
			buttonPanel.setOpaque(false);
			/* 패널에 버튼 추가 */
			buttonPanel.add(login);
			buttonPanel.add(regist);
			/* 로고패널에 컴포넌트 추가 */
			add(buttonPanel);
			buttonPanel.setBounds(1700,5,200,30);
		}//cons LogoPanel()
	}//LogoPanel class
}//MainFrame class