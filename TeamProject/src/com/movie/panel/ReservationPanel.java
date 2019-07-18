package com.movie.panel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class ReservationPanel extends JPanel{	
	/* 영화 선택 */
	JPanel movie=new JPanel();
	Vector<String> movieL; // 임시 영화리스트
	JList movieList;
	
	/* 영화관 선택 */
	JPanel cinema=new JPanel();
	JList cinemaList=new JList();
	Vector<String> cinemaL=new Vector<>();
	
	/* 영화시간 선택 */
	JPanel time_room=new JPanel();
	JPanel time=new JPanel();
	JPanel room=new JPanel();
	
	/* 날짜 선택 */
	JPanel days=new JPanel();
	
	/* 인원 선택 */
	JPanel people=new JPanel();
	
	/* 최종정보&버튼 */
	JPanel info=new JPanel();
	
	public ReservationPanel() {
		setBorder(BorderFactory.createEmptyBorder(50,50,50,50));
		Font font=new Font("맑은 고딕",Font.BOLD,15);
		/* 영화선택 패널 설정 */
		movie.setLayout(new BorderLayout());
		/* 영화목록 삽입 */ 
		movieL=new Vector<>();
		for(int i=0;i<30;i++) {
			movieL.add(i+"번째 영화");
		}//for
		/* 영화목록 리스트 생성&설정*/
		movieList=new JList(movieL);
		movieList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		movieList.setFont(font);
		movie.add(movieList,BorderLayout.CENTER); // 영화목록을 movie패널에 추가		
		/* 스크롤 생성&설정 */
		JScrollPane scroll=new JScrollPane(movieList,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		// movieList에 스크롤을 추가, 수직스크롤 항상보이게, 수평스크롤 항상 숨김
		scroll.setPreferredSize(new Dimension(300,400));
		movie.add(scroll); // 스크롤을 movie패널에 추가
		
		/* 메인패널에 보조패널 추가 */
		add(movie);	add(cinema);
		add(time_room);	add(days);
		add(people); add(info);
	}//cons ReservationPanel()
}//Reservation class
