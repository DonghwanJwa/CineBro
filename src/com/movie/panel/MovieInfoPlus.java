package com.movie.panel;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**영화 상세정보 패널(페이지 만들기)**/
public class MovieInfoPlus extends JPanel implements ActionListener{
	private JPanel panel1,panel2,backP;
	JButton back;
	/* 하늘이가 원하는것
	 * 내부클래스 4개를 생성하여 Panel을 만든다.
	 * 4개의 부품 패널을 하나의 main Panel에 넣는다
	 * main Panel 을 frame 에 넣어서 실제로 확인해본다.
	 */
	CardLayout cards=new CardLayout();
	public MovieInfoPlus(){

		/**패널에 패널 올리기 첫번째**/
		/*뒤로가기 버튼 만들기*/
		back = new JButton("X");
		back.setBackground(Color.RED);
		back.setForeground(Color.WHITE);
		back.setFocusPainted(false);
		back.setBorderPainted(false);
		back.setOpaque(true);
		back.addActionListener(this);
		
		backP = new JPanel();
		backP.setPreferredSize(new Dimension(550, 40));
		backP.setLayout(new FlowLayout(FlowLayout.RIGHT));
		backP.add(back);
		
		InfoPanel infopanel = new InfoPanel();//인포패널 객체
		ReviewPanel reviewpanel = new ReviewPanel();//리뷰패널 객체
		panel1 = new JPanel();//패널1 객체 생성
		panel1.setPreferredSize(new Dimension(550,450));//패널사이즈 지정
		panel1.add(backP);
		panel1.add(infopanel); panel1.add(reviewpanel);//패널1에 인포,리뷰 패널 올림

		/**포스터패널과 패널1을 올릴 패널만들기**/
		PosterPanel posterpanel = new PosterPanel();//포스터 패널 객체
		panel2 = new JPanel();//패널2 객체 생성
		panel2.setPreferredSize(new Dimension(900,450));
		panel2.add(posterpanel); panel2.add(panel1);

		/**패널2와 시리즈 패널을 메인 패널에 올리기**/
		SeriesPanel seriespanel = new SeriesPanel();//시리즈 패널 객체
		setPreferredSize(new Dimension(900,700));
		setBackground(Color.BLACK);
		add(panel2); add(seriespanel);//메인 패널에 올림

	}//MovieInfoPlus 생성자

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()=="back") {
		
		}
	}

	/**영화 포스터 넣을 패널(moive)**/
	class PosterPanel extends JPanel{
		ImageIcon poster;
		JButton posterB;
					
		public PosterPanel() {
			setBackground(Color.RED);//배경색
			setPreferredSize(new Dimension(300,490));//사이즈 지정
			setBorder(BorderFactory.createEmptyBorder(25,100,25,100));//패널 내 가로세로 여유공간 만들기

			/*포스터 이미지 조정*/
			ImageIcon preImg = new ImageIcon("lionking.jpg");//포스터 넣는란
			Image originImg = preImg.getImage();//ImageIcon을 Image로 전환
			Image changeImg = originImg.getScaledInstance(269,385,java.awt.Image.SCALE_SMOOTH);
			//이미지 사이즈 가로290,세로415,이미지를 스무스하게
			ImageIcon poster = new ImageIcon(changeImg);
			
			/*포스터에 버튼넣기*/
			posterB = new JButton(poster);
			posterB.setBackground(Color.RED);
			posterB.setFocusPainted(false);
			posterB.setBorderPainted(false);
			posterB.setOpaque(false);
			
			add(posterB);
		}	
	}//PosterPanel class

	/**영화 정보를 넣을 패널(name)**/
	class InfoPanel extends JPanel{
		public InfoPanel() {
			setBackground(Color.GREEN);
			setPreferredSize(new Dimension(550,220));
		}	
	}//InfoPanel class

	/**영화 리뷰를 넣을 패널(review)**/
	class ReviewPanel extends JPanel{
		public ReviewPanel() {
			setBackground(Color.BLUE);
			setPreferredSize(new Dimension(550,120));
		}
	}//ReciewPanel class

	/**영화 시리즈 연관 영화 정보 넣을 패널(series)**/
	class SeriesPanel extends JPanel{
		public SeriesPanel() {
			setBackground(Color.YELLOW);
			setPreferredSize(new Dimension(900,230));
		}
	}//SeriesPanel class
}
