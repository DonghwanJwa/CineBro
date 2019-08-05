package com.movie.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.movie.main.AppManager;

public class MovieReservationCheckPanel extends JPanel {
	/* 패널 생성 */
	JPanel mainP = new JPanel();
	JPanel movieP = new JPanel();
	
	MovieUi aladdin = new MovieUi("aladdin.jpg","알라딘 2D","예매 번호 : 1234-5678-999","상영 시간  10시 20분",
			"관람 극장   CGV용산","상영관   5관 IMAX관","G열 15번","결제 날짜   2019년 07월 20일","매수  2매");;
	MovieUi toystoy = new MovieUi("spiderman.jpg","알라딘 2D","예매 번호 : 1234-5678-999","상영 시간  10시 20분",
			"관람 극장   CGV용산","상영관   5관 IMAX관","G열 15번","결제 날짜   2019년 07월 20일","매수  2매");;
	MovieUi spiderman = new MovieUi("toystory.jpg","알라딘 2D","예매 번호 : 1234-5678-999","상영 시간  10시 20분",
			"관람 극장   CGV용산","상영관   5관 IMAX관","G열 15번","결제 날짜   2019년 07월 20일","매수  2매");;
	MovieUi parasite = new MovieUi("parasite.jpg","알라딘 2D","예매 번호 : 1234-5678-999","상영 시간  10시 20분",
			"관람 극장   CGV용산","상영관   5관 IMAX관","G열 15번","결제 날짜   2019년 07월 20일","매수  2매");;
	
	JLabel Reservationinfocheck = new JLabel("예매정보조회");
	
	/* -------------- MainUi 내부클래스 컴포넌트 --------------- */
	
	//제목(2D,3D,4D,IMAX) 예매번호 : 0000-0000-0000-000
	//관람일시 년월일시분, 상영관 몇관
	//관람 극장(장소)(극장정보버튼), 관람 좌석번호 몇열 몇번
	//결제 날짜 년월일, 매수 몇매 
	//맨 아래 오른쪽에 예매취소버튼
	JPanel panel_m = new JPanel();
	JPanel posterP = new JPanel();
	JPanel infoP = new JPanel();
	JPanel cancleP = new JPanel();
	/* 라벨 생성 */
	JLabel posterName;
	JLabel posterL;
	JLabel titleI;
	JLabel reservationnumberI;
	JLabel dateI;
	JLabel theaterI;
	JLabel viewingplaceI;
	JLabel seatnumberI;
	JLabel paymentdateI;
	JLabel sheetofpaperI;
	
	JButton cancleB = new JButton("예매취소");

	public MovieReservationCheckPanel() {
		/* 폰트 객체생성&폰트만드는 곳 */
		Font labelFont = new Font("굴림체",Font.BOLD,30);
				
		/* 예매정보조호 라벨 */
		Reservationinfocheck.setFont(labelFont);
		Reservationinfocheck.setBackground(Color.WHITE);
		
		/* 메인 & 무비패널 설정 */
		mainP.setPreferredSize(new Dimension(1400,810));
		movieP.setPreferredSize(new Dimension(1100,320*4));
		// panel_m 패널 하나의 높이가 220, 나중에 예약 하나당 220씩 증가하는식으로 수정해야함->스크롤바 때문
		
		mainP.setBorder(BorderFactory.createEmptyBorder(50,90,80,210));//메인패널 패딩
		mainP.setLayout(new BorderLayout());
		movieP.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
		
		mainP.add(Reservationinfocheck,BorderLayout.NORTH);
		
		/* 예약정보 패널 추가 */
		movieP.add(aladdin);
		movieP.add(toystoy);
		movieP.add(spiderman);
		movieP.add(parasite);
		
		/* 무비패널,메인패널 추가 */
		mainP.add(movieP,BorderLayout.CENTER);
		add(mainP);

		/* 스크롤 만들기 */
		JScrollPane scroll=new JScrollPane(movieP,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); 
		// 내부 패널에 스크롤 적용 후 상하스크롤 항상 보이게, 좌우스크롤 항상 숨김
		scroll.getVerticalScrollBar().setUnitIncrement(16);

		/* 스크롤 추가 */
		mainP.add(scroll,BorderLayout.EAST); // 메인패널에 스크롤 추가

	}//생성자

	/* 내부클래스처리 */
	class MovieUi extends JPanel implements ActionListener{

		MovieUi(String posterName,String title,String reservationnumber,String date,
				String theater,String viewingplace,String seatnumber,
				String paymentdate,String sheetofpaper){
			
			/* 폰트 객체생성&폰트만드는 곳 */
			Font titleFont = new Font("굴림체",Font.BOLD,30);
			Font subLabelFont = new Font("굴림체",Font.BOLD,20);
								
			/* 포스터 이미지 아이콘 사이즈 변환 */
			ImageIcon preImg = new ImageIcon(posterName);//포스터 넣는란
			Image originImg = preImg.getImage();//ImageIcon을 Image로 전환
			Image changeImg = originImg.getScaledInstance(210,300,java.awt.Image.SCALE_SMOOTH);
			// 이미지 사이즈 가로210,세로300,이미지를 스무스하게
			ImageIcon poster = new ImageIcon(changeImg);

			/* 라벨 객체생성 */
			titleI = new JLabel(title);
			posterL = new JLabel(poster);
			reservationnumberI = new JLabel(reservationnumber);
			dateI = new JLabel(date);
			theaterI = new JLabel(theater);
			viewingplaceI = new JLabel(viewingplace);
			seatnumberI = new JLabel(seatnumber);
			paymentdateI = new JLabel(paymentdate);
			sheetofpaperI = new JLabel(sheetofpaper);

			/* 메인패널 */
			panel_m.setBackground(null);
			panel_m.setLayout(new FlowLayout());

			/* 포스터패널 */
			posterP.setBackground(Color.white);
			posterP.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
			posterP.setPreferredSize(new Dimension(210,300));

			/* 포스터버튼이것저것들 */
			posterL.setBackground(Color.white);
			posterP.add(posterL);

			/* 인포(설명)패널 */
			infoP.setLayout(new GridLayout(4,1));
			infoP.setBackground(Color.white);
			infoP.setPreferredSize(new Dimension(800,300));
			infoP.setBorder(BorderFactory.createEmptyBorder(5,20,5,20));
			cancleP.setLayout(new FlowLayout(FlowLayout.RIGHT,80,10));
			cancleP.setBackground(Color.white);
			cancleB.addActionListener(this);          //취소버튼 이벤트처리
			cancleP.add(cancleB);

			/* 라벨폰트 지정 */
			titleI.setFont(titleFont);         reservationnumberI.setFont(subLabelFont);
			dateI.setFont(subLabelFont);         theaterI.setFont(subLabelFont);
			viewingplaceI.setFont(subLabelFont); seatnumberI.setFont(subLabelFont);
			paymentdateI.setFont(subLabelFont);  sheetofpaperI.setFont(subLabelFont);

			/* 라벨을 인포패널에 추가 */
			infoP.add(titleI);
			infoP.add(reservationnumberI);
			infoP.add(dateI);
			infoP.add(viewingplaceI); // 관람극장
			infoP.add(theaterI); // 상영관
			infoP.add(paymentdateI);
			infoP.add(seatnumberI);
			infoP.add(cancleP);
			
			/* 메인패널에 포스터패널이랑 인포패널추가하고 메인패널을 moveiUi에 추가 */

			panel_m.add(posterP);
			panel_m.add(infoP);
			add(panel_m);
			// 버튼이랑 좌석번호를 예매취소패널에 한번에 넣는다
		}// 생성자
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==cancleB) {
				new MovieCancelPanel();
			}
		}//aP()		
	}//MovieUi class
}//MovieReservationCheckPanel class
