package com.movie.UI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import com.movie.DAO.CinemaDAO;
import com.movie.DAO.MovieDAO;

public class ReservationPanel extends JPanel{
	// 카드레이아웃 설정
	protected final CardLayout CARD=new CardLayout();
	
	// ------------------------------------- 패널
	
	/* 카드레이아웃 패널 */
	private JPanel reservCard=new JPanel(CARD); // 홈
	private JPanel seetCard=new JPanel(); // 좌석 카드패널
	private JPanel paymentCard=new JPanel(); // 결제 카드패널
	
	/* 홈 패널 */
	private JPanel reservMain=new JPanel();
	private JPanel movieChoice=new JPanel();
	private JPanel cinemaChoice=new JPanel();
	private JPanel calendar=new JPanel();
	private JPanel cine_daysChoice=new JPanel();
	private JPanel peopleChoice=new JPanel();
	private JPanel info=new JPanel(); // 카드레이아웃 미포함
	/* 좌석 패널 */
	
	/* 결제 패널 */
	
	// ----------------------------------- 리스트
	
	Vector<MovieDAO> movieVector=new Vector<>(); // 각 리스트에 들어갈 벡터 생성
	Vector<CinemaDAO> cinemaVector=new Vector<>();
	protected JList movieList=new JList(movieVector);
	protected JList cinemaList=new JList(cinemaVector);
	
	// ---------------------------------- 정보라벨
	
	protected JLabel cinemaL=new JLabel("극장");
	protected JLabel daysL=new JLabel("날짜");
	protected JLabel peopleL=new JLabel("인원");
	protected JLabel seetL=new JLabel("좌석");
	protected JLabel priceL=new JLabel("가격");
	
	public ReservationPanel() {
				
	}//cons	
	
	public Component setCalendar() {
		
		return calendar;
	}
}//Reservation class
