package com.movie.UI;

import java.awt.CardLayout;

import javax.swing.JList;
import javax.swing.JPanel;

public class ReservationPanel extends JPanel{
	// 카드레이아웃 설정
	final CardLayout CARD=new CardLayout();
	// ------------------------------------- 패널
	JPanel reservCard=new JPanel(CARD);
	JPanel reservMain=new JPanel();
	
	// ----------------------------------- 리스트
	JList movieList=new JList();
	JList cinemaList=new JList();
	
	public ReservationPanel() {
		
	}
}//Reservation class
