package com.movie.UI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
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
	
	// ------------------------------------- 패널
	
	/* 카드레이아웃 패널 */
	private JPanel reservCard=new JPanel(CARD);
	private JPanel homeCard=new JPanel(new BorderLayout()); // 홈 카드패널
	private JPanel seatCard=new JPanel(); // 좌석 카드패널
	private JPanel paymentCard=new JPanel(); // 결제 카드패널
	
	/* 홈 패널 */
	private JPanel topPanel=new JPanel(new FlowLayout());
	private JPanel bottomPanel=new JPanel();
	private JPanel calendar=new JPanel();
	private JPanel timeChoice=new JPanel();
	private JPanel peopleChoice=new JPanel();
	private JPanel info=new JPanel(new BorderLayout()); // 카드레이아웃 미포함
	private JPanel infoTop=new JPanel();
	private JPanel infoCenter=new JPanel(new GridLayout(0,1));
	private JPanel infoBottom=new JPanel();
	
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
	
		
		
		
		// ------------------ 예매 카드패널
		
		/* 상단패널 구축 */
		cinemaList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // 리스트 설정 단일선택 모델
		cinemaList.setPreferredSize(new Dimension(260,650)); // 리스트 크기 지정
		movieList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //
		movieList.setPreferredSize(new Dimension(260,650));
		calendar.setPreferredSize(new Dimension(300,400)); // 달력 패널 크기지정
		calendar.setBackground(Color.ORANGE);
		
		JScrollPane movieListSp=new JScrollPane(movieList,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		movieListSp.setPreferredSize(new Dimension(300,400));
		JScrollPane cinemaListSp=new JScrollPane(cinemaList,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		cinemaListSp.setPreferredSize(new Dimension(300,400));
		
		topPanel.add(movieListSp); topPanel.add(cinemaListSp); topPanel.add(calendar);
		
		/* 하단패널 구축 */
		timeChoice.setBackground(Color.CYAN);
		timeChoice.setPreferredSize(new Dimension(600,300));
		peopleChoice.setBackground(Color.GREEN);
		peopleChoice.setPreferredSize(new Dimension(500,300));
		bottomPanel.add(timeChoice); bottomPanel.add(peopleChoice);
		
		
		
		homeCard.add(topPanel,BorderLayout.CENTER); homeCard.add(bottomPanel,BorderLayout.SOUTH);
		
		// ------------------ 카드패널에 패널, 키설정
		
		reservCard.add(homeCard,"home");
		reservCard.add(seatCard,"seat");
		reservCard.add(paymentCard,"payment");
		
		/* 정보패널 구축 */
		info.setPreferredSize(new Dimension(300,800));
		moviePosterB.setPreferredSize(new Dimension(250,300));
		
		infoTop.add(moviePosterB); // 정보패널 상단 
		
		infoCenter.add(daysL); infoCenter.add(cinemaL); infoCenter.add(seatL);
		infoCenter.add(peopleL); infoCenter.add(priceL); // 정보패널 중단
		
		infoBottom.add(nextB); // 정보패널 하단
		
		info.add(infoTop,"North"); info.add(infoCenter,"Center"); info.add(infoBottom,"South");
		/* 메인패널 구축 */
		add(reservCard,BorderLayout.CENTER); add(info,BorderLayout.EAST);
		
		// ------------------ 좌석 카드패널
		
		// ------------------ 결제 카드패널
	}//cons	
	
	public Component setCalendar() {
		
		return calendar;
	}
}//Reservation class
