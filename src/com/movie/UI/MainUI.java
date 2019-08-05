package com.movie.UI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class MainUI {
	static Dimension screensize=Toolkit.getDefaultToolkit().getScreenSize(); // 스크린사이즈를 가져옴
	static int width=screensize.width; // 화면넓이
	static int height=screensize.height; // 화면높이
	
	JFrame frame=new JFrame("CineBRO"); // 프레임 설정
	private JPanel mainP=new JPanel(); // 프레임을 덮을 패널	
	
	/* 메뉴탭 */
	private JPanel menuTap=new JPanel();
	protected JButton homeB=new JButton("HOME");
	protected JButton movieB=new JButton("현재상영작");
	protected JButton reservB=new JButton("예매하기");
	protected JButton checkB=new JButton("예매조회");
	protected JButton myPageB=new JButton("MY PAGE");
	
	/* 로고 이미지 */
	ImageIcon preImg=new ImageIcon("logo.png"); // 포스터
	Image originImg=preImg.getImage(); // ImageIcon을 Image로 전환
	Image changeImg=originImg.getScaledInstance(735,150,java.awt.Image.SCALE_SMOOTH); // 이미지 사이즈 가로 150, 세로 214
	ImageIcon logoImage=new ImageIcon(changeImg);
	
	/* 로고 패널  */
	private JPanel logoP=new JPanel();
	private JLabel logo=new JLabel(logoImage);
	
	private JPanel log_regBP=new JPanel();
	protected JButton loginB=new JButton("로그인");
	protected JButton registB=new JButton("회원가입");
	
	/* 카드레이아웃 패널 */
	protected final CardLayout card=new CardLayout();
	JPanel mainC=new JPanel(card);
	HomePanel homeC=new HomePanel();
	MoviePage movieC=new MoviePage();
	ReservationPanel reservC=new ReservationPanel();
	JPanel checkC=new JPanel();
	JPanel myPageC=new JPanel();
	
	public MainUI() {
		frame.setSize(800,600);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // 프레임 항상 최대화
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // X누르면 프레임종료
		mainP.setPreferredSize(new Dimension(1920,1040)); // 프레임 덮을 패널 1920x1080해상도 기준으로 사이즈 설정 ※하단 작업표시줄 감안
		mainP.setLayout(new BorderLayout());
		
		/* ---------------------- 로고 ---------------------- */
		logoP.setLayout(null);
		logoP.setPreferredSize(new Dimension(1500,150));
		logoP.setOpaque(false);
		
		logo.setOpaque(false);
		logoP.add(logo);
		logo.setBounds(593,0,735,150);
		
		/* 로그인&회원가입 버튼 */
		log_regBP.add(loginB); log_regBP.add(registB);
		
		logoP.add(log_regBP);
		log_regBP.setBounds(1700,5,200,30);
		
		/* -------------------- 메뉴탭 -------------------- */
		menuTap.setLayout(new GridLayout(0,1));
		menuTap.setBorder(BorderFactory.createEmptyBorder(20,200,450,40));
		menuTap.setOpaque(false);
		menuTap.setPreferredSize(new Dimension(350,800));
		
		Font buttonF=new Font("맑은 고딕",Font.BOLD,15);
		
		homeB.setFont(buttonF); // 버튼위 폰트 설정
		homeB.setFocusPainted(false); // 버튼 포커스 없앰
		homeB.setBorderPainted(false); // 버튼 윤곽선 없앰
		homeB.setBackground(Color.RED); // 버튼 배경색 설정
		
		movieB.setFont(buttonF);
		movieB.setFocusPainted(false);
		movieB.setBorderPainted(false);
		movieB.setBackground(Color.GRAY.brighter());
		
		reservB.setFont(buttonF);
		reservB.setFocusPainted(false);
		reservB.setBorderPainted(false);
		reservB.setBackground(Color.GRAY.brighter());
		
		checkB.setFont(buttonF);
		checkB.setFocusPainted(false);
		checkB.setBorderPainted(false);
		checkB.setBackground(Color.GRAY.brighter());
		
		myPageB.setFont(buttonF);
		myPageB.setFocusPainted(false);
		myPageB.setBorderPainted(false);
		myPageB.setBackground(Color.GRAY.brighter());
		
		menuTap.add(homeB); menuTap.add(movieB); menuTap.add(reservB);
		menuTap.add(checkB); menuTap.add(myPageB);
		
		/* ------------------- 카드레이아웃 ------------------- */
		homeC.setBackground(Color.BLACK);
		movieC.setBackground(Color.GRAY);
		reservC.setBackground(Color.BLUE);
		checkC.setBackground(Color.CYAN);
		myPageC.setBackground(Color.GREEN);
		
		mainC.add(homeC,"homeB"); mainC.add(movieC,"movieB"); mainC.add(reservC,"reservB");
		mainC.add(checkC,"checkB"); mainC.add(myPageC,"myPageB");
		
		/* 메인패널에 패널추가 */
		mainP.add(menuTap,BorderLayout.WEST);
		mainP.add(mainC,"Center");
		mainP.add(logoP,"North");
		
		/* -------------- 프레임 설정 ----------------- */
		
		JScrollPane mainScroll=new JScrollPane(mainP,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS
				,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); // 메인패널 스크롤판 생성 수직바 항상 보이게, 수평바 필요할때만 보이게 
		mainScroll.getVerticalScrollBar().setValue((1080-height)/2);
		mainScroll.getHorizontalScrollBar().setValue((1920-width)/2);
		frame.add(mainScroll); // 프레임에 스크롤 추가
		frame.setVisible(true); // 프레임을 항상 보이게함
	}//cons MainUI()
	
	public void addMainListener(ActionListener listener) {
		homeB.addActionListener(listener);
		movieB.addActionListener(listener);
		reservB.addActionListener(listener);
		checkB.addActionListener(listener);
		myPageB.addActionListener(listener);
		loginB.addActionListener(listener);
		registB.addActionListener(listener);
	}
}//MainUI
