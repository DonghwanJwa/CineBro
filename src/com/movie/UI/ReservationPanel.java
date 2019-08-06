package com.movie.UI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class ReservationPanel extends JPanel{
	// 카드레이아웃 설정
	protected final CardLayout CARD=new CardLayout();
	
	// ------------------------------------- 시간버튼 메서드
	
	String[] time= {"08:30","11:00","15:20","17:00","19:50","21:40","23:50","25:10","05:02"};
	
	private JPanel timeGroup=new JPanel();
	protected JButton[] timeB=new JButton[time.length+1];
	
	// ------------------------------------- 홈패널
	
	/* 카드레이아웃 패널 */
	private JPanel reservCard=new JPanel(CARD);
	private JPanel homeCard=new JPanel(new BorderLayout()); // 홈 카드패널
	private JPanel seatCard=new JPanel(); // 좌석 카드패널
	private JPanel paymentCard=new JPanel(); // 결제 카드패널
	
	/* 홈 패널 */
	private JPanel topPanel=new JPanel(new FlowLayout(FlowLayout.CENTER,90,0));
	private JPanel bottomPanel=new JPanel();
	private JPanel calendar=new JPanel();
	private JPanel timeChoice=new JPanel();
	private JPanel peopleChoice=new JPanel();
	private JPanel info=new JPanel(new BorderLayout()); // 카드레이아웃 미포함
	private JPanel infoTop=new JPanel();
	private JPanel infoCenter=new JPanel(new GridLayout(0,1));
	private JPanel infoBottom=new JPanel();
	private JPanel movieListPanel=new JPanel(new BorderLayout(0,8));
	private JPanel cinemaListPanel=new JPanel(new BorderLayout(0,8));
	private JPanel calendarPanel=new JPanel(new BorderLayout(0,8));
	
	// - 서브라벨
	private JLabel movieChoiceLabel=new JLabel("    영화선택");
	private JLabel cinemaChoiceLabel=new JLabel("    상영관선택");
	private JLabel dayChoiceLabel=new JLabel("    날짜선택");
	
	/* 좌석 패널 */
	
	/* 결제 패널 */
	
	// ----------------------------------- 리스트
	
	Vector<String> movieVector=new Vector<>(); // 각 리스트에 들어갈 벡터 생성
	Vector<String> cinemaVector=new Vector<>();
	protected JList movieList=new JList(movieVector);
	protected JList cinemaList=new JList(cinemaVector);
	
	// ---------------------------------- 정보라벨
	
	protected JLabel daysL=new JLabel("날짜");
	protected JLabel cinemaL=new JLabel("상영관");
	protected JLabel seatL=new JLabel("좌석");
	protected JLabel peopleL=new JLabel("인원");
	protected JLabel priceL=new JLabel("가격");
	
	// ---------------------------------- 정보패널 버튼
	
	protected JButton moviePosterB=new JButton("포스터 삽입");
	protected JButton nextB=new JButton("다음단계");
	
	public ReservationPanel() {
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createEmptyBorder(50,50,50,50));					
		
		/* 정보패널 구축 */
		info.setPreferredSize(new Dimension(300,800));
		info.setBorder(BorderFactory.createEmptyBorder(20,0,20,0)); // 정보패널 패딩 
		moviePosterB.setPreferredSize(new Dimension(250,300));
		
		infoTop.add(moviePosterB); // 정보패널 상단 
		
		infoCenter.add(daysL); infoCenter.add(cinemaL); infoCenter.add(seatL);
		infoCenter.add(peopleL); infoCenter.add(priceL); // 정보패널 중단
		
		infoBottom.add(nextB); // 정보패널 하단
		
		info.add(infoTop,"North"); info.add(infoCenter,"Center"); info.add(infoBottom,"South");
		
		// ------------------ 카드패널에 패널, 키설정
		
		reservCard.add(homeCard,"home"); // 예매 카드패널
		reservCard.add(seatCard,"seat"); // 좌석 카드패널 
		reservCard.add(paymentCard,"payment"); // 결제 카드패널
		reservCard.setBorder(BorderFactory.createEmptyBorder(20,0,20,0)); // 카드패널 패딩

		// ------------------ 예매 카드패널
		
		// ------ 상단 패널 구축
		cinemaList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // 리스트 설정 단일선택 모델
		cinemaList.setPreferredSize(new Dimension(260,650)); // 리스트 크기 지정
		movieList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //
		movieList.setPreferredSize(new Dimension(260,650));
		calendar.setPreferredSize(new Dimension(300,400)); // 달력 패널 크기지정
		calendar.setBackground(Color.ORANGE);
		
		JScrollPane movieListSp=new JScrollPane(movieList,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); // 스크롤, 수직바 항상, 수평바 필요할때
		movieListSp.setPreferredSize(new Dimension(300,400)); // 스크롤판 사이즈 설정
		JScrollPane cinemaListSp=new JScrollPane(cinemaList,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		cinemaListSp.setPreferredSize(new Dimension(300,400));
		
		Font choiceLabelFont=new Font("맑은 고딕",Font.BOLD,20);
		
		/* --- 라벨, 리스트 추가한 패널 구성 */
		movieListPanel.add(movieChoiceLabel,"North"); movieListPanel.add(movieListSp,"Center");
		cinemaListPanel.add(cinemaChoiceLabel,"North"); cinemaListPanel.add(cinemaListSp,"Center");
		calendarPanel.add(dayChoiceLabel,"North"); calendarPanel.add(calendar,"Center");
		
		movieChoiceLabel.setFont(choiceLabelFont); cinemaChoiceLabel.setFont(choiceLabelFont);
		dayChoiceLabel.setFont(choiceLabelFont);
		
		topPanel.add(movieListPanel); topPanel.add(cinemaListPanel); topPanel.add(calendarPanel);
		
		// ------ 하단 패널 구축
		timeChoice.setBackground(Color.CYAN);
		timeChoice.setPreferredSize(new Dimension(585,300));
		peopleChoice.setBackground(Color.GREEN);
		peopleChoice.setPreferredSize(new Dimension(480,300));
		timeChoice.add(setTimeButton());
		bottomPanel.add(timeChoice); bottomPanel.add(peopleChoice); // 하단패널에 들어갈 패널 삽입
		
		homeCard.add(topPanel,BorderLayout.CENTER); homeCard.add(bottomPanel,BorderLayout.SOUTH);
		// 홈 카드레이아웃 설정된 패널에 상단패널과 하단패널 삽입
		
		
		// ------------------ 좌석 카드패널
		
		
		
		// ------------------ 결제 카드패널

		/* 메인패널 구축 */
		add(reservCard,BorderLayout.CENTER); add(info,BorderLayout.EAST);		
	}//cons
	
	// --- 시간선택 버튼 컴포넌트 메서드
	public Component setTimeButton() {
		for(int i=0;i<time.length;i++) {
			timeB[i]=new JButton(time[i]);
			
			timeGroup.add(timeB[i]);
		}//for
		return timeGroup;
	}//setTimeButton()
	// --- 날짜선택 캘린더 컴포넌트 메서드
	public Component setCalendar() {
		
		return calendar;
	}
}//Reservation class
