package com.movie.UI;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import com.movie.DAO.MovieDAO;
import com.movie.main.AppManager;

public class HomePanel extends JPanel implements ActionListener{
	JPanel buttons;
	JButton[] movie=new JButton[8];
	ImageIcon poster;
	MovieDAO mdao = AppManager.getInstance().getDAOManager().getMovieDAO();

	public HomePanel() {
		/* 패널설정 */
		setBorder(BorderFactory.createEmptyBorder(20,150,20,200));

		/* 카드레이아웃 패널 설정 */
		buttons=new JPanel();
		buttons.setLayout(new GridLayout(2,4,20,10));
		buttons.setPreferredSize(new Dimension(1300,900));
		buttons.setOpaque(false);	//buttons 투명하게

		/* 버튼 생성 및 설정 */
		for(int i=0;i<8;i++) {
			movie[i]=new JButton();
			movie[i].addActionListener(this);
			movie[i].setBorderPainted(false);		//버튼 테두리 삭제
			movie[i].setFocusPainted(false);		//버튼 선택시 나타나는 테두리 삭제
			movie[i].setContentAreaFilled(false);	//버튼 배경 지우기
			buttons.add(movie[i]);				
		}//for

		setPosterImage(); 	//버튼에 포스터 넣는 메서드
		add(buttons);
	}//cons MoviePanel()

	public void setPosterImage() {
		for(int i=0;i<8;i++) {
			try {
				ImageIcon mainposter = new ImageIcon("pic/"+mdao.getMovieInfo(i+1).getMovie_img());//포스터 넣는칸
				Image originImg = mainposter.getImage();//ImagIcon을 Image로 전환
				Image changeImg = originImg.getScaledInstance(300,420,java.awt.Image.SCALE_SMOOTH);
				//이미지 사이즈 가로 269,385이미지를 스무스하게 만들어줌
				ImageIcon poster = new ImageIcon(changeImg);
				movie[i].setIcon(poster);
			}catch(Exception e) {
				e.printStackTrace();
			}//try~catch
		}//for
	}//setPosterImage() : 버튼에 포스터 이미지 넣어주는 메서드

	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0;i<8;i++) {
			if(e.getSource()==movie[i]) {
				new MovieInfoPlus(i+1);
			}//if
		}//for		
	}//aP() => 버튼을 눌렀을 때 실행
}//MoviePanel class
