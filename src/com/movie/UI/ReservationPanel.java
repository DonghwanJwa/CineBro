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
import java.util.Calendar;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ReservationPanel extends JPanel implements ActionListener,ListSelectionListener{
	String[] time= {"08:30","11:00","15:20","17:00","19:50","21:40","23:50","25:10"};
	SetCalendar setCal=new SetCalendar();
	// 카드레이아웃 설정

	protected final CardLayout CARD=new CardLayout();
	
	// ------------------------------------- 캘린더 컴포넌트 메서드

//	Calendar cal=Calendar.getInstance(); // 캘린더 인스턴스 생성
//	private JPanel calP=new JPanel(new GridLayout(7,7));
//	private JPanel monthCalP=new JPanel(new BorderLayout());
//	private JPanel monthButtonP=new JPanel(new FlowLayout(FlowLayout.CENTER,20,0));
//	private String[] calWeek= {"일","월","화","수","목","금","토"};
//	
//	private JLabel[] calWeekL=new JLabel[7];
//	protected JButton[] calDate=new JButton[32];
//	protected JButton nextMonth=new JButton("▶");
//	protected JButton preMonth=new JButton("◀");
//	protected JLabel calMonth=new JLabel("");
//	protected JLabel calYear=new JLabel("2019년");
//
//	private int startDay; // 각 월 시작 일
//	private int lastDay; // 각 월 마지막 일
//
//	private int year; // 현재 년도
//	private int month; // 월
//	private int date; // 일
//	private int sunday=1;
//	private int indexDay=1;

	// ------------------------------------- 버튼그룹 메서드

	private JPanel timeGroup=new JPanel();
	private JPanel peopleGroup=new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JLabel timeChoiceLabel=new JLabel("시간");
	private JLabel peopleChoiceLabel=new JLabel("인원");
	protected JLabel adultL=new JLabel("성인");
	protected JLabel childL=new JLabel("청소년");
	protected JButton[] timeB=new JButton[time.length+1];
	protected JButton[] adultB=new JButton[8];
	protected JButton[] childB=new JButton[8];

	// ------------------------------------- 홈패널

	/* 카드레이아웃 패널 */
	private JPanel reservCard=new JPanel(CARD);
	private JPanel homeCard=new JPanel(new BorderLayout()); // 홈 카드패널
	private JPanel seatCard=new JPanel(); // 좌석 카드패널
	private JPanel paymentCard=new JPanel(); // 결제 카드패널

	/* 홈 패널 */
	private JPanel topPanel=new JPanel(new FlowLayout());
	private JPanel bottomPanel=new JPanel(new FlowLayout(FlowLayout.CENTER,50,0));
	private JPanel calendar=new JPanel(new BorderLayout());
	private JPanel timeChoice=new JPanel();
	private JPanel peopleChoice=new JPanel(); 

	private JPanel info=new JPanel(new BorderLayout()); // 카드레이아웃 미포함
	private JPanel infoTop=new JPanel();
	private JPanel infoName=new JPanel(new FlowLayout(FlowLayout.CENTER));
	private JPanel infoLabel=new JPanel(new BorderLayout(20,0));
	private JPanel infoWestLP=new JPanel(new GridLayout(0,1));
	private JPanel infoCenterLP=new JPanel(new GridLayout(0,1));
	private JPanel infoCenter=new JPanel(new BorderLayout(0,40));
	private JPanel infoBottom=new JPanel();
	private JPanel dayGroupLP=new JPanel(new FlowLayout(FlowLayout.LEFT,0,2));
	private JPanel peopleGroupLP=new JPanel(new FlowLayout(FlowLayout.LEFT,0,2));
	private JPanel movieListPanel=new JPanel(new BorderLayout());
	private JPanel cinemaListPanel=new JPanel(new BorderLayout());
	
	protected JPanel calendarPanel=new JPanel(new BorderLayout());

	// - 서브라벨
	private JLabel movieChoiceLabel=new JLabel("    영화");
	private JLabel cinemaChoiceLabel=new JLabel("    상영관");
	private JLabel dayChoiceLabel=new JLabel("    날짜");

	// --------------------------------- 좌석 패널
	
	private JPanel seatPanel=new JPanel();
	private JPanel leftArea=new JPanel(new GridLayout(12,5,1,1));
	private JPanel centerArea=new JPanel(new GridLayout(12,10,1,1));
	private JPanel rightArea=new JPanel(new GridLayout(12,5,1,1));
	private JPanel areaLine=new JPanel(new GridLayout(12,1,1,1));
	
	protected JButton[][] leftSeat=new JButton[12][5];
	protected JButton[][] centerSeat=new JButton[12][10];
	protected JButton[][] rightSeat=new JButton[12][5];
	
	protected JLabel[] seatLine=new JLabel[12];
	
	/* 결제 패널 */

	// ----------------------------------- 리스트

	Vector<String> movieVector=new Vector<>(); // 각 리스트에 들어갈 벡터 생성
	Vector<String> cinemaVector=new Vector<>();
	protected JList movieList=new JList(movieVector);
	protected JList cinemaList=new JList(cinemaVector);

	// ---------------------------------- 정보라벨

	protected JLabel movieNameL=new JLabel("영화제목");
	protected JLabel daysL=new JLabel("날짜");
	protected JLabel setDaysL=new JLabel();
	protected JLabel setTimesL=new JLabel();
	protected JLabel cinemaL=new JLabel("상영관");
	protected JLabel setCinemaL=new JLabel("3");
	protected JLabel seatL=new JLabel("좌석");
	protected JLabel setSeatL=new JLabel("3"); 
	protected JLabel peopleL=new JLabel("인원");
	protected JLabel setAdultL=new JLabel();
	protected JLabel setChildL=new JLabel();
	protected JLabel priceL=new JLabel("가격");
	protected JLabel setPriceL=new JLabel("5");


	// ---------------------------------- 정보패널 버튼

	protected JButton moviePosterB=new JButton("포스터 삽입");
	protected JButton infoNextB=new JButton("다음단계");
	protected JButton seatNextB=new JButton("다음단계");
	protected JButton seatBackB=new JButton("이전단계");

	public ReservationPanel() {
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createEmptyBorder(50,150,200,200));			

		/* 정보패널 구축 */
		Font setLabelFont=new Font("맑은 고딕",Font.BOLD,15);
		Font labelFont=new Font("맑은 고딕",Font.PLAIN,12); 
		info.setPreferredSize(new Dimension(300,700));
		info.setBorder(BorderFactory.createEmptyBorder(20,0,20,0)); // 정보패널 패딩
		info.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		moviePosterB.setPreferredSize(new Dimension(250,300));

		infoTop.add(moviePosterB); // 정보패널 상단 

		infoCenter.setBorder(BorderFactory.createEmptyBorder(0,0,80,0));
		infoLabel.setBorder(BorderFactory.createEmptyBorder(0,30,0,0));

		infoName.add(movieNameL); // 영화명 라벨
		dayGroupLP.add(setDaysL); dayGroupLP.add(setTimesL);
		peopleGroupLP.add(setAdultL); peopleGroupLP.add(setChildL);
		
		infoWestLP.add(daysL);    infoCenterLP.add(dayGroupLP);
		infoWestLP.add(cinemaL);  infoCenterLP.add(setCinemaL);
		infoWestLP.add(seatL);    infoCenterLP.add(setSeatL);
		infoWestLP.add(peopleL);  infoCenterLP.add(peopleGroupLP);
		infoWestLP.add(priceL);   infoCenterLP.add(setPriceL); // 2줄라벨 모음

		infoLabel.add(infoWestLP,"West"); infoLabel.add(infoCenterLP,"Center");
		infoCenter.add(infoName,"North"); infoCenter.add(infoLabel,"Center");

		movieNameL.setFont(setLabelFont);
		daysL.setFont(labelFont);   setDaysL.setFont(setLabelFont); setTimesL.setFont(setLabelFont);
		cinemaL.setFont(labelFont); setCinemaL.setFont(setLabelFont);
		seatL.setFont(labelFont);   setSeatL.setFont(setLabelFont);
		peopleL.setFont(labelFont); setAdultL.setFont(setLabelFont); setChildL.setFont(setLabelFont);
		priceL.setFont(labelFont);	setPriceL.setFont(setLabelFont);

		infoNextB.setPreferredSize(new Dimension(280,40)); // 다음버튼 크기설정
		infoNextB.addActionListener(this);
		infoBottom.add(infoNextB); // 정보패널 하단
		seatBackB.setVisible(false); seatBackB.setPreferredSize(new Dimension(130,40));
		seatNextB.setVisible(false); seatNextB.setPreferredSize(new Dimension(130,40));
		seatBackB.addActionListener(this);
		seatNextB.addActionListener(this);
		infoBottom.add(seatBackB); infoBottom.add(seatNextB);

		info.add(infoTop,"North");
		info.add(infoCenter,"Center"); 
		info.add(infoBottom,"South");

		// ------------------ 카드패널에 패널, 키설정

		reservCard.add(homeCard,"home"); // 예매 카드패널
		reservCard.add(seatCard,"seat"); // 좌석 카드패널 
		reservCard.add(paymentCard,"payment"); // 결제 카드패널
		reservCard.setBorder(BorderFactory.createEmptyBorder(20,0,20,0)); // 카드패널 패딩

		// ------------------ 예매 카드패널

		// ------ 상단 패널 구축

		cinemaList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // 리스트 설정 단일선택 모델
		cinemaList.setPreferredSize(new Dimension(200,650)); // 리스트 크기 지정
		movieList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); //
		movieList.setPreferredSize(new Dimension(200,650));
		calendar.setPreferredSize(new Dimension(400,400)); // 달력 패널 크기지정
		calendar.setBackground(Color.ORANGE);

		movieList.setFont(new Font("맑은 고딕",Font.PLAIN,20));
		cinemaList.setFont(new Font("맑은 고딕",Font.PLAIN,20));

		/* 리스트 항목 작성 */
		for(int i=0;i<12;i++) {
			movieVector.add(i+"번째 영화");
			cinemaVector.add(i+"번째 상영관");
		}//for
		movieList.addListSelectionListener(this);
		cinemaList.addListSelectionListener(this);		

		// --- 리스트 스크롤생성
		JScrollPane movieListSp=new JScrollPane(movieList,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); // 스크롤, 수직바 항상, 수평바 필요할때
		movieListSp.setPreferredSize(new Dimension(240,400)); // 스크롤판 사이즈 설정
		JScrollPane cinemaListSp=new JScrollPane(cinemaList,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		cinemaListSp.setPreferredSize(new Dimension(240,400));

		Font choiceLabelFont=new Font("맑은 고딕",Font.BOLD,20);

		/* --- 라벨, 리스트 추가한 패널 구성 */
		movieListPanel.add(movieChoiceLabel,"North");   movieListPanel.add(movieListSp,"Center");
		cinemaListPanel.add(cinemaChoiceLabel,"North"); cinemaListPanel.add(cinemaListSp,"Center");
		calendarPanel.add(dayChoiceLabel,"North");      calendarPanel.add(setCal,"Center");
//		setCalendar();
		
		movieChoiceLabel.setFont(choiceLabelFont);      cinemaChoiceLabel.setFont(choiceLabelFont);
		dayChoiceLabel.setFont(choiceLabelFont);

		topPanel.add(movieListPanel); topPanel.add(cinemaListPanel); topPanel.add(calendarPanel);

		// ------ 하단 패널 구축
		Font bottomLabelFont=new Font("맑은 고딕",Font.BOLD,13);
		
		bottomPanel.setPreferredSize(new Dimension(1000,150));
		timeChoice.setBackground(Color.WHITE);
		timeChoice.setPreferredSize(new Dimension(600,150));
		timeChoice.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		peopleChoice.setBackground(Color.WHITE);
		peopleChoice.setPreferredSize(new Dimension(200,150));
		peopleChoice.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		
		timeChoiceLabel.setFont(bottomLabelFont); peopleChoiceLabel.setFont(bottomLabelFont);

		timeChoice.add(timeChoiceLabel);	    timeChoice.add(setTimeButton());
		peopleChoice.add(peopleChoiceLabel);	peopleChoice.add(setPeopleButton());

		bottomPanel.add(timeChoice);            bottomPanel.add(peopleChoice); // 하단패널에 들어갈 패널 삽입

		homeCard.add(topPanel,BorderLayout.CENTER); homeCard.add(bottomPanel,BorderLayout.SOUTH);
		// 홈 카드레이아웃 설정된 패널에 상단패널과 하단패널 삽입


		// ------------------ 좌석 카드패널

		setCinemaSeat();

		// ------------------ 결제 카드패널

		/* 메인패널 구축 */
		add(reservCard,BorderLayout.CENTER); add(info,BorderLayout.EAST);
	}//cons

	// --- 시간선택 버튼 컴포넌트 메서드	
	public Component setTimeButton() {
		timeGroup.setPreferredSize(new Dimension(600,123));
		timeGroup.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		timeGroup.setOpaque(false);
		for(int i=0;i<time.length;i++) {
			timeB[i]=new JButton(time[i]);
			timeB[i].setContentAreaFilled(false);
			timeB[i].addActionListener(this);
			timeGroup.add(timeB[i]);
		}//for
		return timeGroup;
	}//setTimeButton()

	// --- 인원선택 버튼 컴포넌트 메서드
	public Component setPeopleButton() {
		Font ageLabelFont=new Font("맑은 고딕",Font.BOLD,13);
		JPanel adultP=new JPanel(new BorderLayout(0,5));
		JPanel adultButtonP=new JPanel();
		JPanel childP=new JPanel(new BorderLayout(0,5));
		JPanel childButtonP=new JPanel();
		
		peopleGroup.setPreferredSize(new Dimension(200,150));
		peopleGroup.setOpaque(false);
		peopleGroup.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		adultL.setFont(ageLabelFont); childL.setFont(ageLabelFont);		
		adultP.add(adultL,"North");
		adultP.add(adultButtonP,"Center");
		for(int i=0;i<adultB.length;i++) {
			adultB[i]=new JButton((i+1)+"");
			adultB[i].setFont(new Font("맑은 고딕",Font.BOLD,10));
			adultB[i].setMargin(new Insets(0,3,0,3));
			adultB[i].setContentAreaFilled(false);
			adultB[i].addActionListener(this);
			adultButtonP.add(adultB[i]);
		}//for
		childP.add(childL,"North");
		childP.add(childButtonP,"Center");
		for(int i=0;i<childB.length;i++) {
			childB[i]=new JButton((i+1)+"");
			childB[i].setFont(new Font("맑은 고딕",Font.BOLD,10));
			childB[i].setMargin(new Insets(0,3,0,3));
			childB[i].setContentAreaFilled(false);
			childB[i].addActionListener(this);
			childButtonP.add(childB[i]);
		}//for
		peopleGroup.add(adultP);
		peopleGroup.add(childP);
		return peopleGroup;
	}//setPeopleButton()

	// --- 날짜선택 캘린더 컴포넌트 메서드
//	public void setCalendar() {
//		calMonth.setText("8");
//		calYear.setHorizontalAlignment(JLabel.CENTER); // 라벨 중앙설정
//		calMonth.setHorizontalAlignment(JLabel.CENTER);
//		// --- 년 / 월 설정 버튼
//		
//		monthButtonP.add(preMonth);
//		monthButtonP.add(calMonth);
//		monthButtonP.add(nextMonth);
//		
//		preMonth.setContentAreaFilled(false);
//		preMonth.setBorderPainted(false);
//		nextMonth.setContentAreaFilled(false);
//		nextMonth.setBorderPainted(false);
//		
//		nextMonth.addActionListener(this);
//		
//		// --- 캘린더 날짜 구성
//		year=2019; 
//		month=Integer.parseInt(calMonth.getText()); // 컴포넌트위 문자열을 정수로 반환
//		
//		cal.set(Calendar.YEAR, year);
//		cal.set(Calendar.MONTH, month-1);
//		cal.set(Calendar.DATE, 1);
//		
//		startDay=cal.get(Calendar.DAY_OF_WEEK); // 현재 월 시작 요일
//		lastDay=cal.getActualMaximum(Calendar.DATE); // 월 마지막 날짜
//		// 버튼 설정		
//		for(int i=0;i<calDate.length;i++) {
//			String sday="";
//			if(i<10) {
//				sday=" "+i;
//			}else {
//				sday=""+i;
//			}
//			calDate[i]=new JButton(sday);
//		}//for
//		for(int i=0;i<calWeek.length;i++) {
//			calWeekL[i]=new JLabel(calWeek[i]);
//			calWeekL[i].setHorizontalAlignment(JLabel.CENTER);
//			calP.add(calWeekL[i]);
//		}//for
//		for(int i=1;i<startDay;i++) {
//			calP.add(new JLabel(""));
//			sunday++;
//		}//for
//		for(int j=0;j<lastDay;j++) {
//			if(sunday%7==1) calDate[indexDay].setForeground(Color.RED);
//			else if(sunday%7==0) calDate[indexDay].setForeground(Color.BLUE);
//			else calDate[indexDay].setForeground(Color.BLACK);
//			sunday++;
//			calP.add(calDate[indexDay++]);
//		}//for
//		while(calP.getComponentCount()<49) {
//			calP.add(new JLabel(""));
//		}//while
//		for(int i=0;i<calDate.length;i++) {
//			calDate[i].setBackground(Color.WHITE);
//			calDate[i].addActionListener(this);
//		}//for		
//		monthCalP.add(monthButtonP,"North"); monthCalP.add(calP,"Center");		
//		calendar.add(calYear,"North");	     calendar.add(monthCalP,"Center");
//		calendarPanel.add(calendar,"Center");
//	}//setCalendar()

	public void setCinemaSeat() {
		char lineName='A';
		int index=1;
		for(int i=0;i<12;i++) {
			seatLine[i]=new JLabel(lineName+"");
			lineName++;
			areaLine.add(seatLine[i]);
		}//for
		// 왼쪽구역 좌석 배치
		for(int i=0;i<12;i++) {
			for(int j=0;j<5;j++) {
				leftSeat[i][j]=new JButton();
				leftSeat[i][j].setText(index+"");
				leftSeat[i][j].setMargin(new Insets(0,3,0,3));
				if(index==5) {
					index=0;
				}//
				index++;		
				leftArea.add(leftSeat[i][j]);
			}// inner for
		}// outer for
		index=6;
		for(int i=0;i<12;i++) {
			for(int j=0;j<10;j++) {
				centerSeat[i][j]=new JButton();
				centerSeat[i][j].setText(index+"");
				centerSeat[i][j].setMargin(new Insets(0,0,0,0));
				if(index==15) {
					index=5;
				}
				index++;
				centerArea.add(centerSeat[i][j]);
			}// inner for
		}// outer for
		index=16;
		for(int i=0;i<12;i++) {
			for(int j=0;j<5;j++) {
				rightSeat[i][j]=new JButton();
				rightSeat[i][j].setText(index+"");
				rightSeat[i][j].setMargin(new Insets(0,0,0,0));
				if(index==20) {
					index=15;
				}//if
				index++;
				rightArea.add(rightSeat[i][j]);
			}// inner for
		}// outer for
		seatCard.add(areaLine);
		seatCard.add(leftArea);
		seatCard.add(centerArea);
		seatCard.add(rightArea);
		
	}//setCinemaSeat()
	
	@Override
	public void actionPerformed(ActionEvent e) {
		int i=0; // 반복문 매개변수
		Object obj=e.getSource();
		// --- 성인, 청소년 버튼 이벤트
		for(i=0;i<adultB.length;i++) {
			if(obj==timeB[i]) {
				setTimesL.setText(" "+timeB[i].getText());
				break;
			}else if(obj==adultB[i]){
				setAdultL.setText(adultL.getText()+adultB[i].getText()+"명");
				break;
			}
		}//for
		for(int j=0;j<childB.length;j++) {
			if(obj==childB[j]){
				setChildL.setText(","+childL.getText()+childB[j].getText()+"명");
				break;
			}
		}//for
		// --- 캘린더 버튼 이벤트
//		if(obj==nextMonth) {
//			month++;
//			calMonth.setText(month+"");
//			calP.getComponent(48).repaint();
//		}//if
//		for(i=0;i<calDate.length;i++) {
//			if(obj==calDate[i]) {
//				setDaysL.setText(calYear.getText()+" "+calMonth.getText()+"월 "+calDate[i].getText()+"일");
//				break;
//			}//if
//		}//for
		// --- 다음, 이전단계 버튼 이벤트
		if(obj==infoNextB) {
			nextCard();
		}//if
		if(obj==seatBackB) {
			infoNextB.setVisible(true);
			seatNextB.setVisible(false);
			seatBackB.setVisible(false);
			CARD.previous(reservCard);
		}//if
		if(obj==seatNextB) {
			nextCard();
		}//if
		
	}//aP()

	public void nextCard() {
		infoNextB.setVisible(false);
		seatBackB.setVisible(true);
		seatNextB.setVisible(true);
		CARD.next(reservCard);
	}//nextCard()

	@Override
	public void valueChanged(ListSelectionEvent e) {
		Object obj=e.getSource();
		if(obj==movieList) {
			movieNameL.setText(movieList.getSelectedValue()+"");
		}else if(obj==cinemaList) {
			setCinemaL.setText(cinemaList.getSelectedValue()+"");
		}//if else
	}
}//Reservation class
