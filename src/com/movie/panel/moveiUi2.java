package com.movie.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class moveiUi2 extends JPanel {

	JPanel mainP,moveiP;
	moveiUi aladin,toystoy,spiderman;
	JLabel Reservationinfocheck;
	
	moveiUi2() { 
	
		mainP = new JPanel();
		moveiP = new JPanel();
		Font font = new Font("굴림체",Font.BOLD,30);
		Reservationinfocheck = new JLabel("예매정보조회");
		Reservationinfocheck.setFont(font);
		
		mainP.setLayout(new BorderLayout());
		Reservationinfocheck.setBackground(Color.WHITE);
		mainP.add(Reservationinfocheck,BorderLayout.NORTH);
		moveiP.setLayout(new GridLayout(0,1));
		
	
		aladin = new moveiUi("aladin.jpg","알라딘 2D","예매 번호 : 1234-5678-999","상영 시간  10시 20분",
				"관람 극장   CGV용산","상영관   5관 IMAX관","G열 15번","결제 날짜   2019년 07월 20일","매수  2매");
		toystoy = new moveiUi("spiderman.jpg","알라딘 2D","예매 번호 : 1234-5678-999","상영 시간  10시 20분",
				"관람 극장   CGV용산","상영관   5관 IMAX관","G열 15번","결제 날짜   2019년 07월 20일","매수  2매");
		spiderman = new moveiUi("toystory4.jpg","알라딘 2D","예매 번호 : 1234-5678-999","상영 시간  10시 20분",
				"관람 극장   CGV용산","상영관   5관 IMAX관","G열 15번","결제 날짜   2019년 07월 20일","매수  2매");
	
	
		moveiP.add(aladin);
		moveiP.add(toystoy);
		moveiP.add(spiderman);

		mainP.add(moveiP,BorderLayout.CENTER);
		
		add(mainP);
	
	}
	
	public static void main(String[] args) {

		JFrame f = new JFrame();
		f.add(new moveiUi2());
		f.pack();
		f.setVisible(true);
	}

}
