package com.movie.panel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
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
	JPanel room=new JPanel();
	JPanel time01=new JPanel();
	JPanel time02=new JPanel();
	TimeButton timeButton01=new TimeButton();
	TimeButton timeButton02=new TimeButton();
	JLabel roomLabel01,roomLabel02;
	
	/* 날짜 선택 */
	JPanel days=new JPanel();
	
	/* 인원 선택 */
	JPanel people=new JPanel();
	PeopleButton peopleB01=new PeopleButton();
	PeopleButton peopleB02=new PeopleButton();
	JLabel adult,child;
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
		JScrollPane scroll01=new JScrollPane(movieList,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		// movieList에 스크롤을 추가, 수직스크롤 항상보이게, 수평스크롤 항상 숨김
		scroll01.setPreferredSize(new Dimension(300,400));
		movie.add(scroll01); // 스크롤을 movie패널에 추가
		/* 영화관선택 패널 설정 */
		cinema.setLayout(new BorderLayout());
		/* 영화관 목록 삽입 */
		cinemaL=new Vector<>();
		for(int i=0;i<10;i++) {
			cinemaL.add(i+"번째 영화관");
		}//for
		/* 영화목록 리스트 생성&설정 */
		cinemaList=new JList(cinemaL);
		cinemaList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		cinemaList.setFont(font);
		cinema.add(cinemaList,BorderLayout.CENTER);
		/* 스크롤 생성 설정 */
		JScrollPane scroll02=new JScrollPane(cinemaList,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scroll02.setPreferredSize(new Dimension(300,300));
		cinema.add(scroll02);
		/* 영화시간 선택 */
		time01.add(timeButton01);
		time02.add(timeButton02);
		/* 상영관 설정 */
		roomLabel01=new JLabel("   1관");
		roomLabel02=new JLabel("   2관");
		room.setLayout(new GridLayout(0,1)); // 상영관 정보 배치관리자 설정
		/* 상영관정보+시간버튼 추가 */
		room.add(roomLabel01); room.add(time01);
		room.add(roomLabel02); room.add(time02);
		/* 인원수 선택 패널 */
		people.setLayout(new GridLayout(0,1));
		adult=new JLabel("   성인");
		child=new JLabel("   청소년");
		people.add(adult); people.add(peopleB01);
		people.add(child); people.add(peopleB02);
		
		/* 메인패널에 보조패널 추가 */
		add(movie);	add(cinema);
		add(room);	add(days);
		add(people); add(info);
	}//cons ReservationPanel()
	
	/* 상용화 버튼 클래스 생성 */
	class TimeButton extends JPanel{
		JButton[] button=new JButton[4];
		
		public TimeButton() {
			for(int i=0;i<4;i++) {
				button[i]=new JButton();
				button[i].setPreferredSize(new Dimension(70,25));
				add(button[i]);
			}//for
			button[0].setText("10:00");
			button[1].setText("13:00");
			button[2].setText("16:00");
			button[3].setText("19:00");
		}//cons TimeButton()
	}//TimeButton inner class
	class PeopleButton extends JPanel{
		JButton[] button=new JButton[8];
		
		public PeopleButton() {
			for(int i=0;i<8;i++) {
				button[i]=new JButton((i+1)+"");
				button[i].setPreferredSize(new Dimension(50,20));
				add(button[i]);
				}//for
		}
	}//PeoPleButton inner class
}//Reservation class
