package com.movie.panel;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class MoviePanel extends JPanel implements ActionListener{
		CardLayout cards=new CardLayout();
		JPanel buttons,card_panel;
		JButton[] movie=new JButton[8];
		MovieInfoPanel movieInfo=new MovieInfoPanel();
	
	public MoviePanel() {
//		card_panel=new JPanel();
		/* 패널설정 */
		setLayout(cards);
		setBorder(BorderFactory.createEmptyBorder(20,100,20,200));
		setBackground(Color.WHITE);
		/* 카드레이아웃 패널 설정 */
		buttons=new JPanel();
		buttons.setLayout(new GridLayout(2,4,40,20));
		/* 버튼 생성 및 설정 */
		for(int i=0;i<8;i++) {
			movie[i]=new JButton((i+1)+"번째 포스터");
			movie[i].addActionListener(this);
			buttons.add(movie[i]);		
		}//for
		add(buttons,"home");
		add(movieInfo,"movie_one");
	}//cons MoviePanel()
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==movie[0]){
			cards.show(this,"movie_one");
		}//if
		
	}//aP() => 버튼을 눌렀을 때 실행
}//MoviePanel class
