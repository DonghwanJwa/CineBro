package com.movie.UI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JToggleButton;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.movie.DAO.BookingDAO;
import com.movie.VO.CinemaVO;
import com.movie.VO.MovieVO;
import com.movie.VO.MovietimeVO;
import com.movie.VO.SeatVO;
import com.movie.main.AppManager;

public class ReservationPanel extends JPanel implements ActionListener,ListSelectionListener{
	BookingDAO bdao=AppManager.getInstance().getDAOManager().getBookingDAO();

	// --- 카드레이아웃 설정

	protected final CardLayout CARD=new CardLayout();

	// ------------------------------------- 시간 버튼 설정용 리스트, 멤버변수

	List<String> time=new ArrayList<>();
	String screenNum; // 상영관별 시간, 날짜 가져올 멤버변수
	Date screendate;

	// ------------------------------------- 캘린더 컴포넌트 메서드

	Calendar cal=Calendar.getInstance(); // 캘린더 인스턴스 생성
	private JPanel calP=new JPanel(new GridLayout(7,7));
	private JPanel monthCalP=new JPanel(new BorderLayout());
	private JPanel monthButtonP=new JPanel(new FlowLayout(FlowLayout.CENTER,20,0));
	private String[] calWeek= {"일","월","화","수","목","금","토"};

	private JLabel[] calWeekL=new JLabel[7];
	protected JToggleButton[] calDate=new JToggleButton[32];
	protected ButtonGroup calDateBG=new ButtonGroup();
	protected JButton nextMonth=new JButton("▶");
	protected JButton preMonth=new JButton("◀");
	protected JLabel calMonth=new JLabel("");
	protected JLabel calYear=new JLabel("2019");

	private int startDay; // 각 월 시작 일
	private int lastDay; // 각 월 마지막 일

	private int year; // 현재 년도
	private int month; // 월
	private int date; // 일
	private int sunday=1;
	private int indexDay=1;

	// ------------------------------------- 버튼그룹 메서드

	List<JToggleButton> timeBList=new ArrayList<>();
	private int adultCount;
	private int childCount;
	private JPanel timeGroup=new JPanel();
	private JPanel peopleGroup=new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JLabel timeChoiceLabel=new JLabel("시간");
	private JLabel peopleChoiceLabel=new JLabel("인원");
	protected JLabel adultL=new JLabel("성인");
	protected JLabel childL=new JLabel("청소년");
	protected JToggleButton[] adultB=new JToggleButton[9];
	protected JToggleButton[] childB=new JToggleButton[9];
	protected ButtonGroup adultBG=new ButtonGroup();
	protected ButtonGroup childBG=new ButtonGroup();
	protected ButtonGroup timeBG=new ButtonGroup();

	// ------------------------------------- 홈패널

	/* 카드레이아웃 패널 */
	private JPanel reservCard=new JPanel(CARD);
	private JPanel homeCard=new JPanel(new BorderLayout()); // 홈 카드패널
	private JPanel seatCard=new JPanel(new FlowLayout(FlowLayout.CENTER,0,70)); // 좌석 카드패널
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

	// --- 서브라벨

	private JLabel movieChoiceLabel=new JLabel("    영화");
	private JLabel cinemaChoiceLabel=new JLabel("    상영관");
	private JLabel dayChoiceLabel=new JLabel("    날짜");

	// --------------------------------- 좌석 패널

	private JPanel seatPanel=new JPanel(new FlowLayout(FlowLayout.CENTER,10,0)); // 좌석 구역 패널
	private JPanel leftArea=new JPanel(new GridLayout(12,5,1,1)); // 왼쪽 구역 좌석
	private JPanel centerArea=new JPanel(new GridLayout(12,10,1,1)); // 중앙 구역 좌석
	private JPanel rightArea=new JPanel(new GridLayout(12,5,1,1)); // 오른쪽 구역 좌석
	private JPanel areaLine=new JPanel(new GridLayout(12,1,1,7)); // 좌석 열표시
	private JPanel seatChoice=new JPanel(new BorderLayout());
	private JPanel seatChoiceP=new JPanel(new GridLayout(4,2,3,2));

	private JPanel lineSeatP=new JPanel(new BorderLayout(20,30));

	protected List<JButton> seatButton=new ArrayList<>();
	protected JButton[][] leftSeat=new JButton[12][5];
	protected JButton[][] centerSeat=new JButton[12][10];
	protected JButton[][] rightSeat=new JButton[12][5];
	protected JButton seatReset=new JButton("좌석초기화");

	int index=0; // 좌석라벨 인덱스
	ArrayList<JLabel> seatList=new ArrayList<>(); // 좌석 리스트
	protected JLabel[] seatChoiceL=new JLabel[8];
	protected JLabel[] seatLine=new JLabel[12]; // 좌석 열 번호
	private JLabel screen=new JLabel("SCREEN");

	/* 결제 패널 */

	// ----------------------------------- 리스트

	int movie_code; // 무비 코드 저장용 멤버변수
	Vector<Integer> codeVector=new Vector<>(); // 각 영화 이름에 대한 코드를 저장할 벡터, 무비코드로 영화클릭시 해당하는 상영관 항목 생성
	Vector<String> movieVector=new Vector<>(); // 각 리스트에 들어갈 벡터 생성
	Vector<String> cinemaVector=new Vector<>();
	protected JList movieList=new JList(movieVector); // J리스트 생성
	protected JList cinemaList=new JList();

	// ---------------------------------- 정보라벨

	protected JLabel movieNameL=new JLabel("영화제목");
	protected JLabel daysL=new JLabel("날짜");
	protected JLabel setDaysL=new JLabel();
	protected JLabel setTimesL=new JLabel();
	protected JLabel cinemaL=new JLabel("상영관");
	protected JLabel setCinemaL=new JLabel("3");
	protected JLabel seatL=new JLabel("좌석");
	protected JLabel setSeatL=new JLabel(""); 
	protected JLabel peopleL=new JLabel("인원");
	protected JLabel setAdultL=new JLabel();
	protected JLabel setChildL=new JLabel();
	protected JLabel priceL=new JLabel("가격");
	protected JLabel setPriceL=new JLabel("5");

	// ---------------------------------- 정보패널 버튼

	Vector<String> movieImg=new Vector<>(); // 포스터 삽입용 벡터생성
	protected JButton moviePosterB=new JButton("포스터 삽입");
	protected JButton infoNextB=new JButton("다음단계");
	protected JButton seatNextB=new JButton("다음단계");
	protected JButton seatBackB=new JButton("이전단계");

	public ReservationPanel() {
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createEmptyBorder(50,150,200,200));			

		/* 정보패널 구축 */
		Font setLabelFont=new Font("맑은 고딕",Font.BOLD,13);
		Font labelFont=new Font("맑은 고딕",Font.PLAIN,12); 
		info.setPreferredSize(new Dimension(300,700));
		info.setBorder(BorderFactory.createEmptyBorder(20,0,20,0)); // 정보패널 패딩
		info.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		moviePosterB.setPreferredSize(new Dimension(250,300));
		moviePosterB.setContentAreaFilled(false);
		moviePosterB.setBorderPainted(false);

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
		Vector<MovieVO> mV=bdao.movieNameList();
		if((mV != null) && mV.size()>0) {
			for(int i=0;i<mV.size();i++) {
				MovieVO mvo=mV.get(i);
				movieVector.add(mvo.getMovie_nameK());
				movieImg.add(mvo.getMovie_img());
				codeVector.add(mvo.getMovie_code());
			}// for
		}// if

		// --- 리스트 스크롤생성

		JScrollPane movieListSp=new JScrollPane(movieList,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED); // 스크롤, 수직바 항상, 수평바 필요할때
		movieListSp.setPreferredSize(new Dimension(240,400)); // 스크롤판 사이즈 설정
		JScrollPane cinemaListSp=new JScrollPane(cinemaList,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		cinemaListSp.setPreferredSize(new Dimension(240,400));

		Font choiceLabelFont=new Font("맑은 고딕",Font.BOLD,20);

		// --- 각 리스트 선택이벤트 등록

		movieList.addListSelectionListener(this);
		cinemaList.addListSelectionListener(this);

		/* --- 라벨, 리스트 추가한 패널 구성 */
		movieListPanel.add(movieChoiceLabel,"North");   movieListPanel.add(movieListSp,"Center");
		cinemaListPanel.add(cinemaChoiceLabel,"North"); cinemaListPanel.add(cinemaListSp,"Center");
		calendarPanel.add(dayChoiceLabel,"North");      setCalendar();


		movieChoiceLabel.setFont(choiceLabelFont);      cinemaChoiceLabel.setFont(choiceLabelFont);
		dayChoiceLabel.setFont(choiceLabelFont);

		topPanel.add(movieListPanel); topPanel.add(cinemaListPanel); topPanel.add(calendarPanel);

		// ------ 하단 패널 구축
		Font bottomLabelFont=new Font("맑은 고딕",Font.BOLD,13);

		bottomPanel.setPreferredSize(new Dimension(1000,150));
		timeChoice.setBackground(Color.WHITE);
		timeChoice.setPreferredSize(new Dimension(550,150));
		timeChoice.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		peopleChoice.setBackground(Color.WHITE);
		peopleChoice.setPreferredSize(new Dimension(230,150));
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
		return timeGroup;
	}//setTimeButton()

	// --- 인원선택 버튼 컴포넌트 메서드
	public Component setPeopleButton() {
		UIManager.put("ToggleButton.select", Color.RED); // 토글버튼 선택모델 색상 변경
		Font ageLabelFont=new Font("맑은 고딕",Font.BOLD,13);
		JPanel adultP=new JPanel(new BorderLayout(0,5));
		JPanel adultButtonP=new JPanel();
		JPanel childP=new JPanel(new BorderLayout(0,5));
		JPanel childButtonP=new JPanel();

		peopleGroup.setPreferredSize(new Dimension(230,150));
		peopleGroup.setOpaque(false);
		peopleGroup.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		adultL.setFont(ageLabelFont); childL.setFont(ageLabelFont);
		adultP.add(adultL,"North");
		adultP.add(adultButtonP,"Center");
		for(int i=0;i<adultB.length;i++) {
			adultB[i]=new JToggleButton(i+"");
			adultBG.add(adultB[i]);
			adultB[i].setFont(new Font("맑은 고딕",Font.BOLD,10));
			adultB[i].setMargin(new Insets(0,3,0,3));
			adultB[i].setBackground(Color.BLACK);
			adultB[i].setForeground(Color.WHITE);
			adultB[i].addActionListener(this);
			adultButtonP.add(adultB[i]);
			SwingUtilities.updateComponentTreeUI(adultB[i]); // 토글버튼 선택모델 적용
		}//for
		childP.add(childL,"North");
		childP.add(childButtonP,"Center");
		for(int i=0;i<childB.length;i++) {
			childB[i]=new JToggleButton(i+"");
			childBG.add(childB[i]);
			childB[i].setFont(new Font("맑은 고딕",Font.BOLD,10));
			childB[i].setMargin(new Insets(0,3,0,3));
			childB[i].setBackground(Color.BLACK);
			childB[i].setForeground(Color.WHITE);
			childB[i].addActionListener(this);
			childButtonP.add(childB[i]);
		}//for
		peopleGroup.add(adultP);
		peopleGroup.add(childP);
		return peopleGroup;
	}//setPeopleButton()

	// --- 날짜선택 캘린더 컴포넌트 메서드
	public void setCalendar() {
		calMonth.setText("08");
		calYear.setHorizontalAlignment(JLabel.CENTER); // 라벨 중앙설정
		calMonth.setHorizontalAlignment(JLabel.CENTER);


		// --- 년 / 월 설정 버튼

		monthButtonP.add(preMonth);
		monthButtonP.add(calMonth);
		monthButtonP.add(nextMonth);

		preMonth.setContentAreaFilled(false);
		preMonth.setBorderPainted(false);
		nextMonth.setContentAreaFilled(false);
		nextMonth.setBorderPainted(false);

		nextMonth.addActionListener(this);

		// --- 캘린더 날짜 구성
		year=2019; 
		month=Integer.parseInt(calMonth.getText()); // 컴포넌트위 문자열을 정수로 반환

		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month-1);
		cal.set(Calendar.DATE, 1);

		startDay=cal.get(Calendar.DAY_OF_WEEK); // 현재 월 시작 요일
		lastDay=cal.getActualMaximum(Calendar.DATE); // 월 마지막 날짜
		// 버튼 설정		
		for(int i=0;i<calDate.length;i++) {
			String sday="";
			if(i<10) {
				sday=" "+i;
			}else {
				sday=""+i;
			}
			calDate[i]=new JToggleButton(sday);
			calDateBG.add(calDate[i]);			
		}//for
		for(int i=0;i<calWeek.length;i++) {
			calWeekL[i]=new JLabel(calWeek[i]);
			calWeekL[i].setHorizontalAlignment(JLabel.CENTER);
			calP.add(calWeekL[i]);
		}//for
		for(int i=1;i<startDay;i++) {
			calP.add(new JLabel(""));
			sunday++;
		}//for
		for(int j=0;j<lastDay;j++) {
			if(sunday%7==1) calDate[indexDay].setForeground(Color.RED);
			else if(sunday%7==0) calDate[indexDay].setForeground(Color.BLUE);
			else calDate[indexDay].setForeground(Color.BLACK);
			sunday++;
			calP.add(calDate[indexDay++]);
		}//for
		while(calP.getComponentCount()<49) {
			calP.add(new JLabel(""));
		}//while
		for(int i=0;i<calDate.length;i++) {
			calDate[i].setBackground(Color.WHITE);
			calDate[i].addActionListener(this);
		}//for
		monthCalP.add(monthButtonP,"North"); monthCalP.add(calP,"Center");		
		calendar.add(calYear,"North");	     calendar.add(monthCalP,"Center");
		calendarPanel.add(calendar,"Center");
	}//setCalendar()

	public void setCinemaSeat() {
		char lineName='A'; // 열 이름
		int index=1; // 좌석배치 인덱스
		// --- 열 이름
		for(int i=0;i<12;i++) {
			seatLine[i]=new JLabel(lineName+"");
			lineName++;
			areaLine.add(seatLine[i]);
		}//for		
		//		// 왼쪽구역 좌석 배치
		//		for(int i=0;i<12;i++) {
		//			for(int j=0;j<5;j++) {
		//				leftSeat[i][j]=new JButton();
		//				leftSeat[i][j].setText(index+"");
		//				leftSeat[i][j].setMargin(new Insets(0,3,0,3));
		//				leftSeat[i][j].setBackground(Color.BLACK);
		//				leftSeat[i][j].setForeground(Color.WHITE);
		//				leftSeat[i][j].addActionListener(this);
		//				if(index==5) {
		//					index=0;
		//				}// if
		//				index++;		
		//				leftArea.add(leftSeat[i][j]);
		//			}// inner for
		//		}// outer for
		//		// --- 중앙구역 좌석
		//		index=6;
		//		for(int i=0;i<12;i++) {
		//			for(int j=0;j<10;j++) {
		//				centerSeat[i][j]=new JButton();
		//				centerSeat[i][j].setText(index+"");
		//				centerSeat[i][j].setMargin(new Insets(0,0,0,0));
		//				centerSeat[i][j].setBackground(Color.BLACK);
		//				centerSeat[i][j].setForeground(Color.WHITE);
		//				centerSeat[i][j].addActionListener(this);
		//				if(index==15) {
		//					index=5;
		//				}// if
		//				index++;
		//				centerArea.add(centerSeat[i][j]);
		//			}// inner for
		//		}// outer for
		//		// --- 오른쪽 구역 좌석
		//		index=16;
		//		for(int i=0;i<12;i++) {
		//			for(int j=0;j<5;j++) {
		//				rightSeat[i][j]=new JButton();
		//				rightSeat[i][j].setText(index+"");
		//				rightSeat[i][j].setMargin(new Insets(0,0,0,0));
		//				rightSeat[i][j].setBackground(Color.BLACK);
		//				rightSeat[i][j].setForeground(Color.WHITE);	
		//				rightSeat[i][j].addActionListener(this);
		//				if(index==20) {
		//					index=15;
		//				}//if
		//				index++;
		//				rightArea.add(rightSeat[i][j]);
		//			}// inner for
		//		}// outer for
		seatReset.addActionListener(this);
		seatChoice.add(seatChoiceP,"Center"); seatChoice.add(seatReset,"South"); 

		seatChoice.setPreferredSize(new Dimension(120,0));
		seatChoice.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		//		seatPanel.add(leftArea); seatPanel.add(centerArea); seatPanel.add(rightArea); // 좌석 구역 배치
		screen.setPreferredSize(new Dimension(0,30));
		screen.setHorizontalAlignment(JLabel.CENTER);
		screen.setOpaque(true);
		screen.setBackground(new Color(225,225,225));
		screen.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		lineSeatP.add(areaLine,"West"); lineSeatP.add(seatPanel,"Center"); 
		lineSeatP.add(screen,"North"); lineSeatP.add(seatChoice,"East");
		seatCard.add(lineSeatP);
	}//setCinemaSeat()

	@Override
	public void actionPerformed(ActionEvent e) {
		int i=0; // 반복문 매개변수
		Object obj=e.getSource();
		// --- 시간 버튼
		for(i=0;i<timeBList.size();i++) {
			if(obj==timeBList.get(i)) {
				setTimesL.setText(" "+timeBList.get(i).getText());
			}// if		
		}// for
		// --- 성인, 청소년 버튼 이벤트
		for(i=0;i<adultB.length;i++) {
			int j=7;
			if(obj==adultB[i]){
				setAdultL.setText(adultL.getText()+adultB[i].getText()+"명");
				adultCount=Integer.parseInt(adultB[i].getText());
			}// if else
			// 0선택 => 초기화
			if(obj==adultB[0]) {
				childB[1].setEnabled(true);
				childB[2].setEnabled(true);
				childB[3].setEnabled(true);
				childB[4].setEnabled(true);
				childB[5].setEnabled(true);
				childB[6].setEnabled(true);
				childB[7].setEnabled(true);
				childB[8].setEnabled(true);
			}// if
			// 성인 1명 버튼 눌렀을 때			
			if(obj==adultB[1]) {
				childB[1].setEnabled(true);
				childB[2].setEnabled(true);
				childB[3].setEnabled(true);
				childB[4].setEnabled(true);
				childB[5].setEnabled(true);
				childB[6].setEnabled(true);
				childB[7].setEnabled(true);
				childB[8].setEnabled(false);
			}// if
			// 성인 2명 버튼 눌렀을 때
			if(obj==adultB[2]) {
				childB[1].setEnabled(true);
				childB[2].setEnabled(true);
				childB[3].setEnabled(true);
				childB[4].setEnabled(true);
				childB[5].setEnabled(true);
				childB[6].setEnabled(true);
				childB[7].setEnabled(false);
				childB[8].setEnabled(false);
			};// if
			// 성인 3명 버튼 눌렀을 때
			if(obj==adultB[3]) {
				childB[1].setEnabled(true);
				childB[2].setEnabled(true);
				childB[3].setEnabled(true);
				childB[4].setEnabled(true);
				childB[5].setEnabled(true);
				childB[6].setEnabled(false);
				childB[7].setEnabled(false);
				childB[8].setEnabled(false);
			}// if			
			// 성인 4명 버튼 눌렀을 때
			if(obj==adultB[4]) {
				childB[1].setEnabled(true);
				childB[2].setEnabled(true);
				childB[3].setEnabled(true);
				childB[4].setEnabled(true);
				childB[5].setEnabled(false);
				childB[6].setEnabled(false);
				childB[7].setEnabled(false);
				childB[8].setEnabled(false);
			}// if
			// 성인 5
			if(obj==adultB[5]) {
				childB[1].setEnabled(true);
				childB[2].setEnabled(true);
				childB[3].setEnabled(true);
				childB[4].setEnabled(false);
				childB[5].setEnabled(false);
				childB[6].setEnabled(false);
				childB[7].setEnabled(false);
				childB[8].setEnabled(false);
			}// if
			// 성인 6
			if(obj==adultB[6]) {
				childB[1].setEnabled(true);
				childB[2].setEnabled(true);
				childB[3].setEnabled(false);
				childB[4].setEnabled(false);
				childB[5].setEnabled(false);
				childB[6].setEnabled(false);
				childB[7].setEnabled(false);
				childB[8].setEnabled(false);
			}// if
			// 성인 7
			if(obj==adultB[7]) {
				childB[1].setEnabled(true);
				childB[2].setEnabled(false);
				childB[3].setEnabled(false);
				childB[4].setEnabled(false);
				childB[5].setEnabled(false);
				childB[6].setEnabled(false);
				childB[7].setEnabled(false);
				childB[8].setEnabled(false);
			}// if
			// 성인 8
			if(obj==adultB[8]) {
				childB[1].setEnabled(false);
				childB[2].setEnabled(false);
				childB[3].setEnabled(false);
				childB[4].setEnabled(false);
				childB[5].setEnabled(false);
				childB[6].setEnabled(false);
				childB[7].setEnabled(false);
				childB[8].setEnabled(false);
			}// if
		}// for
		// 청소년 버튼
		for(int j=0;j<childB.length;j++) {
			if(obj==childB[j]){
				setChildL.setText(","+childL.getText()+childB[j].getText()+"명");
				childCount=Integer.parseInt(childB[j].getText());
			}// if
			// 0 선택 => 초기화
			if(obj==childB[0]) {
				adultB[1].setEnabled(true);
				adultB[2].setEnabled(true);
				adultB[3].setEnabled(true);
				adultB[4].setEnabled(true);
				adultB[5].setEnabled(true);
				adultB[6].setEnabled(true);
				adultB[7].setEnabled(true);
				adultB[8].setEnabled(true);
			}// if
			if(obj==childB[1]) {
				adultB[1].setEnabled(true);
				adultB[2].setEnabled(true);
				adultB[3].setEnabled(true);
				adultB[4].setEnabled(true);
				adultB[5].setEnabled(true);
				adultB[6].setEnabled(true);
				adultB[7].setEnabled(true);
				adultB[8].setEnabled(false);
			}// if
			if(obj==childB[2]) {
				adultB[1].setEnabled(true);
				adultB[2].setEnabled(true);
				adultB[3].setEnabled(true);
				adultB[4].setEnabled(true);
				adultB[5].setEnabled(true);
				adultB[6].setEnabled(true);
				adultB[7].setEnabled(false);
				adultB[8].setEnabled(false);
			}// if
			if(obj==childB[3]) {
				adultB[1].setEnabled(true);
				adultB[2].setEnabled(true);
				adultB[3].setEnabled(true);
				adultB[4].setEnabled(true);
				adultB[5].setEnabled(true);
				adultB[6].setEnabled(false);
				adultB[7].setEnabled(false);
				adultB[8].setEnabled(false);
			}// if
			if(obj==childB[4]) {
				adultB[1].setEnabled(true);
				adultB[2].setEnabled(true);
				adultB[3].setEnabled(true);
				adultB[4].setEnabled(true);
				adultB[5].setEnabled(false);
				adultB[6].setEnabled(false);
				adultB[7].setEnabled(false);
				adultB[8].setEnabled(false);
			}// if
			if(obj==childB[5]) {
				adultB[1].setEnabled(true);
				adultB[2].setEnabled(true);
				adultB[3].setEnabled(true);
				adultB[4].setEnabled(false);
				adultB[5].setEnabled(false);
				adultB[6].setEnabled(false);
				adultB[7].setEnabled(false);
				adultB[8].setEnabled(false);
			}// if
			if(obj==childB[6]) {
				adultB[1].setEnabled(true);
				adultB[2].setEnabled(true);
				adultB[3].setEnabled(false);
				adultB[4].setEnabled(false);
				adultB[5].setEnabled(false);
				adultB[6].setEnabled(false);
				adultB[7].setEnabled(false);
				adultB[8].setEnabled(false);
			}// if
			if(obj==childB[7]) {
				adultB[1].setEnabled(true);
				adultB[2].setEnabled(false);
				adultB[3].setEnabled(false);
				adultB[4].setEnabled(false);
				adultB[5].setEnabled(false);
				adultB[6].setEnabled(false);
				adultB[7].setEnabled(false);
				adultB[8].setEnabled(false);
			}// if
			// 청소년 8
			if(obj==childB[8]) {
				adultB[1].setEnabled(false);
				adultB[2].setEnabled(false);
				adultB[3].setEnabled(false);
				adultB[4].setEnabled(false);
				adultB[5].setEnabled(false);
				adultB[6].setEnabled(false);
				adultB[7].setEnabled(false);
				adultB[8].setEnabled(false);
			}// if
		}// for
		// --- 캘린더 버튼 이벤트
		if(obj==nextMonth) {
			month++;
			calMonth.setText(month+"");
			calendar.removeAll();
			calendar.revalidate();
			calendar.add(calP,"Center");
			calendar.add(monthCalP,"Center");
			calendar.repaint();
		}// if
		for(i=0;i<calDate.length;i++) {
			// --- 캘린더 버튼 클릭시
			if(obj==calDate[i]) {
				setDaysL.setText(calYear.getText()+"년"+calMonth.getText()+"월 "+calDate[i].getText()+"일");
				// 날짜 시간 리스트 생성
				screendate=Date.valueOf(calYear.getText()+"-"+calMonth.getText()+"-"+calDate[i].getText());
				screenNum=(String)cinemaList.getSelectedValue();
				List<MovietimeVO> mL=bdao.DayTimeList(screendate,screenNum);
				if((mL != null) && mL.size()>0) {
					for(int j=0;j<mL.size();j++) {
						MovietimeVO mtvo=mL.get(j);
						time.add(mtvo.getScreentime());
					}// for
				}// if
				for(int j=0;j<time.size();j++) {
					if(timeGroup.getComponentCount()<=5) {
						timeBList.add(new JToggleButton());
					}// if
					timeBList.get(j).setBackground(Color.BLACK);
					timeBList.get(j).setForeground(Color.WHITE);
					timeBList.get(j).setText(time.get(j));
					timeBList.get(j).addActionListener(this);
					timeBG.add(timeBList.get(j));
					timeGroup.add(timeBList.get(j));
					if(j==4) {
						time.clear();
					}
				}// for
				break;
			}// if
		}// for

		// --- 다음, 이전단계 버튼 이벤트
		if(obj==infoNextB) {
			nextCard();
		}// if
		if(obj==seatBackB) {
			infoNextB.setVisible(true);
			seatNextB.setVisible(false);
			seatBackB.setVisible(false);
			CARD.previous(reservCard);
		}// if
		if(obj==seatNextB) {
			nextCard();
		}// if
		// --- 좌석 선택 버튼
		//		for(i=0;i<12;i++) {
		//			for(int j=0;j<5;j++) {
		//				if(obj==leftSeat[i][j]) {
		//					if(leftSeat[i][j].getBackground()==Color.BLACK) {
		//						if(0<=index && index<(adultCount+childCount)) {
		//							leftSeat[i][j].setBackground(Color.RED);
		//							seatList.add(new JLabel());
		//							seatChoiceP.add(seatList.get(index),"Center");
		//							seatList.get(index).setText(seatLine[i].getText()+leftSeat[i][j].getText());
		//							seatList.get(index).setHorizontalAlignment(JLabel.CENTER);
		//							if(index==0) {
		//								setSeatL.setText(setSeatL.getText().concat(seatList.get(index).getText()));
		//							}else {
		//								setSeatL.setText(setSeatL.getText().concat(" "+seatList.get(index).getText()));
		//							}// if else
		//							index++;
		//						}else {
		//							JOptionPane.showMessageDialog(null,"모두 선택하셨습니다!");
		//						}// if else
		//					}else if(leftSeat[i][j].getBackground()==Color.RED) {
		//						leftSeat[i][j].setBackground(Color.BLACK);
		//						for(int k=0;k<seatList.size();k++) {
		//							if(seatList.get(k).getText().equals(seatLine[i].getText()+leftSeat[i][j].getText())) {
		//								setSeatL.setText(setSeatL.getText().replace(" "+seatList.get(k).getText(),"")
		//										.replace(seatList.get(k).getText(),""));
		//								seatChoiceP.remove(seatList.get(k));
		//								seatList.remove(k);
		//								seatChoiceP.revalidate();
		//								seatChoiceP.repaint();
		//								index--;
		//							}// if
		//						}// for
		//					}// if else if
		//				}// leftSeat 버튼 클릭시
		//				if(obj==rightSeat[i][j]) {
		//					if(rightSeat[i][j].getBackground()==Color.BLACK) {
		//						if(0<=index && index<(adultCount+childCount)) {
		//							rightSeat[i][j].setBackground(Color.RED);
		//							seatList.add(new JLabel());
		//							seatChoiceP.add(seatList.get(index),"Center");
		//							seatList.get(index).setText(seatLine[i].getText()+rightSeat[i][j].getText());
		//							seatList.get(index).setHorizontalAlignment(JLabel.CENTER);
		//							if(index==0) {
		//								setSeatL.setText(setSeatL.getText().concat(seatList.get(index).getText()));
		//							}else {
		//								setSeatL.setText(setSeatL.getText().concat(" "+seatList.get(index).getText()));
		//							}// if else
		//							index++;	
		//						}else {
		//							JOptionPane.showMessageDialog(null,"모두 선택하셨습니다!");
		//						}// if else
		//					}else if(rightSeat[i][j].getBackground()==Color.RED) {
		//						rightSeat[i][j].setBackground(Color.BLACK);
		//						for(int k=0;k<seatList.size();k++) {
		//							if(seatList.get(k).getText().equals(seatLine[i].getText()+rightSeat[i][j].getText())) {
		//								setSeatL.setText(setSeatL.getText().replace(" "+seatList.get(k).getText(),"")
		//										.replace(seatList.get(k).getText(),""));
		//								seatChoiceP.remove(seatList.get(k));
		//								seatList.remove(k);
		//								seatChoiceP.revalidate();
		//								seatChoiceP.repaint();
		//								index--;
		//							}// if
		//						}// for
		//					}// if else if
		//				}// leftSeat 버튼 클릭시
		//			}// inner for
		//		}// outer for
		//		for(i=0;i<12;i++) {
		//			for(int j=0;j<10;j++) {
		//				if(obj==centerSeat[i][j]) {
		//					if(centerSeat[i][j].getBackground()==Color.BLACK) {
		//						if(0<=index && index<(adultCount+childCount)) {
		//							centerSeat[i][j].setBackground(Color.RED);
		//							seatList.add(new JLabel());
		//							seatChoiceP.add(seatList.get(index),"Center");
		//							seatList.get(index).setText(seatLine[i].getText()+centerSeat[i][j].getText());
		//							seatList.get(index).setHorizontalAlignment(JLabel.CENTER);
		//							if(index==0) {
		//								setSeatL.setText(setSeatL.getText().concat(seatList.get(index).getText()));
		//							}else {
		//								setSeatL.setText(setSeatL.getText().concat(" "+seatList.get(index).getText()));
		//							}// if else
		//							index++;	
		//						}else {
		//							JOptionPane.showMessageDialog(null,"모두 선택하셨습니다!");
		//						}// if else
		//					}else if(centerSeat[i][j].getBackground()==Color.RED) {
		//						centerSeat[i][j].setBackground(Color.BLACK);
		//						for(int k=0;k<seatList.size();k++) {
		//							if(seatList.get(k).getText().equals(seatLine[i].getText()+centerSeat[i][j].getText())) {
		//								setSeatL.setText(setSeatL.getText().replace(" "+seatList.get(k).getText(),"")
		//										.replace(seatList.get(k).getText(),""));
		//								seatChoiceP.remove(seatList.get(k));
		//								seatList.remove(k);
		//								seatChoiceP.revalidate();
		//								seatChoiceP.repaint();
		//								index--;
		//							}// if
		//						}// for
		//					}// if else if
		//				}// leftSeat 버튼 클릭시
		//			}// inner for
		//		}// outer for
		for(i=0;i<seatButton.size();i++) {
			if(obj==seatButton.get(i)) {
				if(seatButton.get(i).getBackground()==Color.BLACK) {
					if(0<=index && index<(adultCount+childCount)) {
						seatButton.get(i).setBackground(Color.RED);
						seatList.add(new JLabel());
						seatChoiceP.add(seatList.get(index),"Center");
						for(int j=0;j<12;j++) {
							seatList.get(index).setText(seatLine[j].getText()+seatButton.get(i).getText());
							seatList.get(index).setHorizontalAlignment(JLabel.CENTER);
						}// fo
						if(index==0) {
							setSeatL.setText(setSeatL.getText().concat(seatList.get(index).getText()));
						}else {
							setSeatL.setText(" "+setSeatL.getText().concat(seatList.get(index).getText()));
						}// if else
						index++;
					}else {
						JOptionPane.showMessageDialog(null,"모두 선택하셨습니다!");
					}// 인원수 초과 시
				}else if(seatButton.get(i).getBackground()==Color.RED) {
					seatButton.get(i).setBackground(Color.BLACK);
					for(int k=0;k<seatList.size();k++) {
						for(int j=0;j<12;j++) {
							if(seatList.get(k).getText().equals(seatLine[j].getText()+seatButton.get(i).getText())){
								setSeatL.setText(setSeatL.getText().replace(" "+seatList.get(k).getText(),"")
										.replace(seatList.get(k).getText(),""));
								seatChoiceP.remove(seatList.get(k));
								seatList.remove(k);
								seatChoiceP.revalidate();
								seatChoiceP.repaint();
								index--;
							}// if
						}// inner for
					}// outer for
				}// if else
			}// 좌석버튼 클릭 시
		}// outer for
		if(obj==seatReset) {
			for(i=0;i<12;i++) {
				for(int j=0;j<5;j++) {
					leftSeat[i][j].setBackground(Color.BLACK);
					rightSeat[i][j].setBackground(Color.BLACK);
				}// inner for
			}// outer for
			for(i=0;i<12;i++) {
				for(int j=0;j<10;j++) {
					centerSeat[i][j].setBackground(Color.BLACK);
				}// inner for
			}// outer for
			for(int k=0;k<seatList.size();k++) {
				seatChoiceP.removeAll();
				seatList.remove(k);
				seatChoiceP.revalidate();
				seatChoiceP.repaint();
			}//for
			setSeatL.setText("");
			index=0;
		}// if
	}//aP()

	@Override
	public void valueChanged(ListSelectionEvent e) {
		Object obj=e.getSource();
		if(!e.getValueIsAdjusting()) {
			// 영화 리스트 선택 했을 시
			if(obj==movieList) {
				movieNameL.setText((String)movieList.getSelectedValue()); // 영화이름제목 라벨 작성
				for(int i=0;i<movieVector.size();i++) {
					if(movieNameL.getText().equals(movieVector.get(i))){
						movie_code=codeVector.get(i);
						// --- 포스터 버튼에 해당하는 이미지 삽입
						ImageIcon mainposter = new ImageIcon("pic/"+movieImg.get(i));		
						Image originImg = mainposter.getImage();
						Image changeImg = originImg.getScaledInstance(250,300,Image.SCALE_SMOOTH);		
						ImageIcon poster = new ImageIcon(changeImg);

						moviePosterB.setIcon(poster);
					}// if
				}// for
				// 상영관 리스트 출력
				Vector<CinemaVO> cV=bdao.cinemaList(movie_code);
				if((cV != null) && cV.size()>0) {
					for(int i=0;i<cV.size();i++) {
						CinemaVO cvo=cV.get(i);
						cinemaVector.clear();
						cinemaVector.add(cvo.getScreen());
					}// for
					cinemaList.setListData(cinemaVector);
				}// if
				// 상영관리스트 선택했을 시
			}else if(obj==cinemaList) {			
				setCinemaL.setText((String)cinemaList.getSelectedValue());
				// 좌석 배치
				screenNum=cinemaList.getSelectedValue()+"";
				List<SeatVO> sV=bdao.setScreenSeat(screenNum);
				if((sV != null) && sV.size()>0) {
					for(int i=0;i<sV.size();i++) {
						SeatVO svo=sV.get(i);
						seatButton.add(new JButton());
						seatButton.get(i).setText(svo.getSeatcol());
						seatButton.get(i).setMargin(new Insets(2,0,2,0));
						seatButton.get(i).setBackground(Color.BLACK);
						seatButton.get(i).setForeground(Color.WHITE);
						seatButton.get(i).addActionListener(this);

						int seatPlace=Integer.parseInt(seatButton.get(i).getText());
						if(seatPlace<=5) {
							seatButton.get(i).setMargin(new Insets(2,3,2,3));
							seatButton.get(i).setText(svo.getSeatrow()+svo.getSeatcol());
							leftArea.add(seatButton.get(i));
							seatPanel.add(leftArea);							
						}else if(5<seatPlace && seatPlace<=15) {
							seatButton.get(i).setText(svo.getSeatrow()+svo.getSeatcol());
							centerArea.add(seatButton.get(i));
							seatPanel.add(centerArea);
						}else if(seatPlace<=20) {
							seatButton.get(i).setText(svo.getSeatrow()+svo.getSeatcol());
							rightArea.add(seatButton.get(i));
							seatPanel.add(rightArea);
						}// 제발


					} // for
				}// if
			}//if else
		}// 리스트 항목에서 버튼을 뗐을 때
	}//vC()

	public void nextCard() {
		infoNextB.setVisible(false);
		seatBackB.setVisible(true);
		seatNextB.setVisible(true);
		CARD.next(reservCard);
	}//nextCard()
}//Reservation class
