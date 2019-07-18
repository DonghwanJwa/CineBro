package com.movie.panel;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JPanel;

public class ReservationPanel extends JPanel{
	static Dimension screenSize=Toolkit.getDefaultToolkit().getScreenSize(); // 화면해상도 가져옴
	static int width=screenSize.width;
	static int height=screenSize.height;
	JPanel movie,cine_time,day_people,movieInfo,cinema,time,days,people;
		
	public ReservationPanel() {
		
	}//cons ReservationPanel()
}//Reservation class
