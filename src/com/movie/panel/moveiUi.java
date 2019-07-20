package com.movie.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class moveiUi extends JPanel {
	//제목(2D,3D,4D,IMAX) 예매번호 : 0000-0000-0000-000
	//관람일시 녀월일시분, 상영관 몇관
	//관람 극장(장소)(극장정보버튼), 관람 좌석번호 몇열 몇번
	//결제 날짜 년월일, 매수 몇매 
	//맨 아래 오른쪽에 예매취소버튼
	JPanel panel_m,posterP,infoP,cancleP,cancleP2;
	JLabel posterName,titleI,ReservationnumberI,dateI,theaterI,
	       viewingplaceI,SeatnumberI,PaymentdateI,sheetofpaperI;
	JButton cancleB,posterB;
	
	moveiUi(String posterName,String title,String Reservationnumber,String date,
			String theater,String viewingplace,String Seatnumber,
			String Paymentdate,String sheetofpaper){
		
		/*객체생성하는 곳*/
		panel_m = new JPanel();
		posterP = new JPanel();
		infoP = new JPanel();
		cancleP = new JPanel();
		cancleP2 = new JPanel();
		/*버튼 객체 생성하는 곳*/
		posterB = new JButton(new ImageIcon(posterName));
		cancleB = new JButton("예매취소");
		
		/*폰트 객체생성&폰트만드는 곳*/
		Font font = new Font("굴림체",Font.BOLD,30);
		Font font1 = new Font("굴림체",Font.BOLD,20);
		Font font2 = new Font("굴림체",Font.BOLD,20);
		
		/*라벨 객체생성*/
		titleI = new JLabel(title);
		ReservationnumberI = new JLabel(Reservationnumber);
		dateI = new JLabel(date);
		theaterI = new JLabel(theater);
		viewingplaceI = new JLabel(viewingplace);
		SeatnumberI = new JLabel(Seatnumber);
		PaymentdateI = new JLabel(Paymentdate);
		sheetofpaperI = new JLabel(sheetofpaper);
		
		/*메인패널*/
		panel_m.setBackground(null);
		panel_m.setLayout(new FlowLayout());
		
		/*포스터패널*/
		posterP.setBackground(Color.white);
		posterP.setPreferredSize(new Dimension(140,200));
		
		/*포스터버튼이것저것들*/
		posterB.setBackground(Color.white);
		posterB.setFocusPainted(false);
		posterB.setBorderPainted(false);
		posterB.setOpaque(false);
		posterP.add(posterB);
		
		/*인포(설명)패널*/
		infoP.setLayout(new GridLayout(4,1));
		infoP.setBackground(Color.white);
		infoP.setPreferredSize(new Dimension(600,200));
		cancleP.setLayout(new FlowLayout(FlowLayout.LEFT));
		cancleP2.setLayout(new FlowLayout(FlowLayout.RIGHT));
		cancleP.setBackground(Color.white);
		cancleP2.setBackground(Color.white);
		cancleP2.add(cancleB);
		cancleP.add(SeatnumberI);
		
		/*라벨폰트 지정*/
		titleI.setFont(font);ReservationnumberI.setFont(font1);
		dateI.setFont(font2);theaterI.setFont(font2);
		viewingplaceI.setFont(font2);SeatnumberI.setFont(font2);
		PaymentdateI.setFont(font2);sheetofpaperI.setFont(font2);
		
		/*라벨을 인포페널에 추가*/
		infoP.add(titleI);
		infoP.add(ReservationnumberI);
		infoP.add(dateI);
		infoP.add(viewingplaceI);//관람극장
		infoP.add(theaterI);//상영관
		infoP.add(PaymentdateI);
		infoP.add(cancleP);
		infoP.add(cancleP2);
		
		/*메인패널에 포스터패널이랑 인포패널추가하고 메인패널을 moveiUi에 추가*/
		
		panel_m.add(posterP);
		panel_m.add(infoP);
		add(panel_m);
		//버튼이랑 좌석번호를 예매취소패널에 한번에 넣는다
	}

	public static void main(String[] args) {
		JFrame f = new JFrame();
		
		f.add(new moveiUi("aladin.jpg","알라딘 2D","예매 번호 : 1234-5678-999","상영 시간  10시 20분",
			"관람 극장   CGV용산","상영관   5관 IMAX관","G열 15번","결제 날짜   2019년 07월 20일","매수  2매"));
		f.setSize(1000,1000);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setVisible(true);
		
	}

}
