package com.movie.frame;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.movie.panel.MoviePanel;
import com.movie.panel.ReservationPanel;

public class MainFrame extends JFrame implements ActionListener{
	private final CardLayout card=new CardLayout();
	private JPanel menu,movie,main,info,info_movie,card_panel;
	private JPanel now_movieP,checkP,myPageP;
	private JButton home,now_movie,reservation,check,myPage;
	static Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize(); // 화면해상도 가져옴
	static int width=screenSize.width;
	static int height=screenSize.height;
	MoviePanel home_P=new MoviePanel();
	LogoPanel logo=new LogoPanel();
	ReservationPanel reservationP=new ReservationPanel();
	
	public MainFrame() {
		Font font=new Font("맑은 고딕",Font.BOLD,20);
		setSize(800,700); // 프레임 사이즈 설정
		
		/* 메인패널 설정 */
		main=new JPanel();
		main.setPreferredSize(new Dimension(screenSize.width,screenSize.height));
		main.setLayout(new BorderLayout());
		main.setBackground(Color.WHITE);
		/* 패널 생성 */
		menu=new JPanel();
		movie=new JPanel();
		info=new JPanel();
		info_movie=new JPanel();
		card_panel=new JPanel();
		/* 메뉴 패널 설정 */
		menu.setLayout(new GridLayout(0,1));
		menu.setBorder(BorderFactory.createEmptyBorder(20,200,20,40)); // 패널 내부공백 설정
		menu.setBackground(Color.WHITE);
		if(width==1920 && height==1080) {
		menu.setPreferredSize(new Dimension(500,800));
		}else if(width==1600 && height==900) {
			
		}//if else if => 해상도별 사이즈 변경
		/* 버튼 생성 */
		home=new JButton("HOME");
		now_movie=new JButton("현재상영작");
		reservation=new JButton("예매하기");
		check=new JButton("예매조회");
		myPage=new JButton("MY PAGE");
		/* 버튼 설정 */
		home.setFont(font);	home.setFocusPainted(false); home.setBorderPainted(false); // 버튼 폰트, 포커스, 윤곽선 설정
		home.setBackground(Color.GRAY.brighter()); // 버튼 배경색 설정
		now_movie.setFont(font); now_movie.setFocusPainted(false); now_movie.setBorderPainted(false);
		now_movie.setBackground(Color.GRAY.brighter());
		reservation.setFont(font); reservation.setFocusPainted(false); reservation.setBorderPainted(false);
		reservation.setBackground(Color.GRAY.brighter());
		check.setFont(font); check.setFocusPainted(false); check.setBorderPainted(false);
		check.setBackground(Color.GRAY.brighter());
		myPage.setFont(font); myPage.setFocusPainted(false); myPage.setBorderPainted(false);
		myPage.setBackground(Color.GRAY.brighter());
		/* 버튼에 이벤트 추가 */
		home.addActionListener(this);
		now_movie.addActionListener(this);
		reservation.addActionListener(this);
		check.addActionListener(this);
		myPage.addActionListener(this);
		/* 메뉴에 버튼 추가*/
		menu.add(home); menu.add(now_movie); menu.add(reservation);
		menu.add(check); menu.add(myPage);
		/* 로고 패널 설정 */
		if(width==1920 && height==1080) {
		}else if(width==1600 && height==900) {
			
		}// 해상도 변경시
		logo.setBackground(Color.YELLOW); // 로고패널 배경색 변경
		/* 영화포스터 패널 설정 */
		
		/* 정보 패널 설정 */
		if(width==1920 && height==1080) {
		info.setPreferredSize(new Dimension(1500,150));
		}else if(width==1600 && height==900) {
			
		}// 해상도 변경시
		info.setBackground(Color.YELLOW); // 인포패널 배경색 변경
		/* 정보/영화 패널 설정 */
		info_movie.setLayout(new BorderLayout());
		/* 정보/영화 패널에 정보, 영화패널 합침 */
		info_movie.add(home_P,BorderLayout.CENTER);
		info_movie.add(info,BorderLayout.SOUTH);
		/* 카드 패널 배치관리자 변경 */
		card_panel.setLayout(card);
		/* 카드패널에 넣을 패널 생성&설정 */
		now_movieP=new JPanel();
		now_movieP.setBackground(Color.BLUE);
		reservationP.setBackground(Color.CYAN);
		checkP=new JPanel();
		checkP.setBackground(Color.GREEN);
		myPageP=new JPanel();
		myPageP.setBackground(Color.ORANGE);
		/* 카드패널에 패널 추가 */
		card_panel.add(info_movie,"home"); card_panel.add(now_movieP,"now_movie"); // 카드패널에 패널추가하고 키설정
		card_panel.add(reservationP,"reservation"); card_panel.add(checkP,"check");
		card_panel.add(myPageP,"myPage");
		
		/* 메인 패널에 나머지 패널추가 */
		main.add(menu,BorderLayout.WEST);
		main.add(card_panel,BorderLayout.CENTER); // 영화/정보 패널 합친 패널
		main.add(logo,BorderLayout.NORTH);		
		add(main); // 프레임에 메인패널 추가
		/* 스크롤생성 */
		JScrollPane scroll=new JScrollPane(main,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); // 메인 프레임에 스크롤 적용 후 상하스크롤 항상 보이게, 좌우스크롤 항상 숨김
		add(scroll); // 프레임에 스크롤 추가
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // X키눌러 프레임종료
		setVisible(true); // 항상 보이게 함
	}//cons MainFrame()
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==home) {
			home.setBackground(Color.RED); // 버튼클릭시 클릭한 버튼 배경색 변경
			now_movie.setBackground(Color.GRAY.brighter());
			reservation.setBackground(Color.GRAY.brighter());
			check.setBackground(Color.GRAY.brighter());
			myPage.setBackground(Color.GRAY.brighter());
			card.show(card_panel,"home"); // "home"키가 적용된 카드레이아웃 보여줌
		}//if
		if(e.getSource()==now_movie){
			home.setBackground(Color.GRAY.brighter());
			now_movie.setBackground(Color.RED);
			reservation.setBackground(Color.GRAY.brighter());
			check.setBackground(Color.GRAY.brighter());
			myPage.setBackground(Color.GRAY.brighter());
			card.show(card_panel,"now_movie");
		}//if
		if(e.getSource()==reservation) {
			home.setBackground(Color.GRAY.brighter());
			now_movie.setBackground(Color.GRAY.brighter());
			reservation.setBackground(Color.RED);
			check.setBackground(Color.GRAY.brighter());
			myPage.setBackground(Color.GRAY.brighter());
			card.show(card_panel,"reservation");
		}//if
		if(e.getSource()==check) {
			home.setBackground(Color.GRAY.brighter());
			now_movie.setBackground(Color.GRAY.brighter());
			reservation.setBackground(Color.GRAY.brighter());
			check.setBackground(Color.RED);
			myPage.setBackground(Color.GRAY.brighter());
			card.show(card_panel,"check");
		}//if
		if(e.getSource()==myPage) {
			home.setBackground(Color.GRAY.brighter());
			now_movie.setBackground(Color.GRAY.brighter());
			reservation.setBackground(Color.GRAY.brighter());
			check.setBackground(Color.GRAY.brighter());
			myPage.setBackground(Color.RED);
			card.show(card_panel,"myPage");
		}//if
	}//aP() => 버튼 클릭시 발생 이벤트
	class LogoPanel extends JPanel {
		JButton login,regist;
		JPanel logo,buttonPanel;
		
		public LogoPanel() {
			setLayout(null); // 로고패널 레이아웃 해제
			setPreferredSize(new Dimension(1500,150));
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
					new SignUP();
				}				
			});
			/* 패널 생성 */
			buttonPanel=new JPanel();
			/* 패널 설정 */
			buttonPanel.setBackground(Color.WHITE);
			/* 패널에 버튼 추가 */
			buttonPanel.add(login);
			buttonPanel.add(regist);
			/* 로고패널에 컴포넌트 추가 */
			add(buttonPanel);
			buttonPanel.setBounds(1700,5,200,30);
		}//cons LogoPanel()
	}//LogoPanel class
}//MainFrame class