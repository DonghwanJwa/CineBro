package com.movie.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class MovieInfoPlus extends JPanel implements ActionListener {

	private JPanel backpanel=new JPanel();				//뒤로가기가 있는 패널
	private JPanel posterpanel=new JPanel();			//포스터를 올리는 패널
	private JPanel button_infopanel=new JPanel();		//인포패널에 모든것을 올리는 큰패널
	private JPanel toppanel=new JPanel();				//포스터 패널과 인포패널을 올린 패널
	private JPanel moviename=new JPanel();				//영화 이름을 올릴 패널
	private JPanel moviescore=new JPanel();				//영화 평점을 올릴 패널
	private JPanel koreanmoviepanel=new JPanel();		//한글 영화이름 올릴 패널
	private JPanel englishmoviepanel=new JPanel();		//영어 영화 이름 올릴 패널
	private JPanel seriespanel=new JPanel();			//시리즈내용을 올릴 패널
	private JPanel audiencescore=new JPanel();			//관람평점을 올릴 패널
	private JPanel reporterscore=new JPanel();			//전문가 평점을 올릴 패널
	private JPanel nullpanel=new JPanel();				//영화이름패널과 영화점수 패널사이 공백을 위한 패널
	private JPanel genrepanel=new JPanel();				//영화장르를 넣을 패널
	private JPanel directorpanel=new JPanel();			//감독명을 올릴 패널
	private JPanel appearancepanel=new JPanel();		//출연진패널
	private JPanel agepanel=new JPanel();				//관람가능 연령을 올릴 패널
	private JPanel viewcountpanel=new JPanel();			//흥행 관람숫자 패널
	private JPanel videopanel=new JPanel();				//동영상을 올릴패널
	private JPanel infopanel=new JPanel();				//인포패널 클래스 객체생성
	
	private JLabel movienameL;
	private JLabel movieing;
	private JLabel englishmovienameL;
	private JLabel audiencescoreL;						//관람객 라벨
	private JLabel reporterscoreL;						//전문가평점 라벨
	private JLabel genretitleL;							//개요 라벨
	private JLabel genreL;								//장르 라벨
	private JLabel posterL;								//포스터 올린라벨
	private JLabel videoL;								//동영상이란 한글 올린 라벨
	private JLabel agetitleL;							//등급 라벨
	private JLabel ageL;								//~세 연령가 라벨
	private JLabel directortitleL;						//감독 라벨
	private JLabel directorL;							//감독명 라벨
	private JLabel appearancepaneltitleL;				//출연 라벨
	private JLabel appearancepanelL;					//출연자 이름 라벨
	private JLabel viewtitleL;							//누적관객 라벨
	private JLabel viewL;								//누적관객수 라벨
	
	
	private JButton back;							//뒤로가기 버튼
	private JButton reserveB;						//예매하기 버튼
	private JButton videoB;							//리뷰 동영상 맨왼쪽
	private JButton videoB2;						//리뷰 동영상 두번쨰
	private JButton videoB3;						//리뷰 동영상 세번째
	private JButton videoB4;						//리뷰 동영상 네번쨰


	public MovieInfoPlus() {
		setposterpanel();
		setinfopanel();
		seriespanel();

		/** 뒤로가기 버튼 만들기 **/
		back = new JButton("BACK");
		back.setBackground(Color.RED); //버튼배경
		back.setForeground(Color.WHITE);//버튼글짜색
		back.setFocusPainted(false); //클릭테두리색
		back.setBorderPainted(false);//그냥테두리색
		back.setOpaque(true);		//투명도 true면 불투명 false면 투명
		back.addActionListener(this); //클릭이벤트


		backpanel = new JPanel(); //뒤로가기 패널 생성
		backpanel.setPreferredSize(new Dimension(550,40));// 뒤로가기 패널 사이즈 설정
		backpanel.setLayout(new FlowLayout(FlowLayout.RIGHT));//뒤로가기 패널 오른쪽 정렬
		backpanel.setBackground(Color.WHITE);
		backpanel.add(back);// 뒤로가기패널에 뒤로가기 버튼 추가

		/** 패널 위에 올릴 패널 **/



		button_infopanel = new JPanel();//패널 1 객체 생성
		button_infopanel.setPreferredSize(new Dimension(550,550));//패널1 사이즈 설정
		button_infopanel.add(backpanel,BorderLayout.NORTH);//뒤로가기 패널을 패널1에 추가
		button_infopanel.add(infopanel,BorderLayout.CENTER);
		infopanel.setBackground(Color.white);

		/** 포스터패널과 패널1을 올릴 패널만들기 **/
		//포스터패널 객체 생성
					//패널2 객체 생성
		toppanel.setPreferredSize(new Dimension(900,525));//패널2 사이즈 설정
		toppanel.add(posterpanel,BorderLayout.WEST); 
		toppanel.add(button_infopanel);//인포버튼패널을 탑패널에 올림!!
		toppanel.setBackground(Color.WHITE);
	
		/** 패널2와 시리즈패널을 메인 패널에 올리기**/
		
		seriespanel.setPreferredSize(new Dimension(900,700));
		seriespanel.setBackground(Color.BLACK);
		add(toppanel); 
		
		add(seriespanel);//메인 패널에 올림

		
	}//MovieInfoPlus생성자

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()=="back") {

		}//if
		if(e.getSource()==videoB) {
			try {
				Thread.sleep(5000);		
				Runtime.getRuntime().exec("C:\\Program Files\\Internet Explorer\\iexplore.exe \"http://www.google.com\"");
			}catch(Exception ie) {
				ie.printStackTrace();
			}	
		}

		if(e.getSource()=="") {

		}
	}//actionPerformed()

	/**영화 포스터 넣을 패널(PosetPenel)**/




	public void setposterpanel() { 
		posterpanel.setBackground(Color.WHITE);//포스터패널 색 지정
		posterpanel.setPreferredSize(new Dimension(300,490));//setPreferredSize 는 
		posterpanel.setLayout(new FlowLayout());
		posterpanel.setBorder(BorderFactory.createEmptyBorder(30,0,0,0));
		//강력한 크기지정 메서드이다. >setSize

		/** 포스터 이미지 조정**/
		ImageIcon mainposter = new ImageIcon("Exit.jpg");//포스터 넣는칸
		Image originImg = mainposter.getImage();//ImagIcon을 Image로 전환
		Image changeImg = originImg.getScaledInstance(275,400,java.awt.Image.SCALE_SMOOTH);
		//이미지 사이즈 가로 269,385이미지를 스무스하게 만들어줌
		ImageIcon poster = new ImageIcon(changeImg);

		/** 포스터에 버튼넣기**/
		posterL =new JLabel(poster);
		posterL.setBackground(Color.WHITE);		
		posterL.setOpaque(true);
		posterpanel.add(posterL);


		reserveB=new JButton("예매하기");
		reserveB.setBackground(Color.RED); //버튼배경
		reserveB.setForeground(Color.WHITE);//버튼글짜색
		reserveB.setFocusPainted(false); //클릭테두리색
		reserveB.setBorderPainted(false);//그냥테두리색
		reserveB.setOpaque(true);		//투명도 true면 불투명 false면 투명
		reserveB.addActionListener(this);

		posterpanel.add(reserveB);

	}//PostPanel 생성자
	//PosterPanel
	/** 영화정보를 넣을 InfoPanel **/

	//static class InfoPanel extends JPanel{
	public void setinfopanel() {
		/*iNFO PANEL 설정*/
		
		infopanel.setBackground(Color.GREEN);
		infopanel.setPreferredSize(new Dimension(550,500));
		infopanel.setLayout(new FlowLayout(FlowLayout.LEFT));

		//infopanel은 Infoin,infoin2 올릴 패널
		
		
		moviename.setBackground(Color.WHITE);
		moviename.setPreferredSize(new Dimension(530,100));
		koreanmoviepanel.setBackground(Color.WHITE);
		koreanmoviepanel.setPreferredSize(new Dimension(520,60));
		englishmoviepanel.setBackground(Color.WHITE);
		englishmoviepanel.setPreferredSize(new Dimension(520,25));
		infopanel.add(moviename);
		
		movienameL=new JLabel("엑시트");
		movieing=new JLabel(" 상영중▶");


		movienameL.setFont(new Font("맑은 고딕",Font.BOLD,39));
		movienameL.setBackground(Color.WHITE);

		movieing.setBackground(Color.blue);
		movieing.setForeground(Color.WHITE);
		movieing.setFont(new Font("맑은 고딕",Font.BOLD,20));

		koreanmoviepanel.add(movienameL);koreanmoviepanel.add(movieing);
		moviename.setLayout(new FlowLayout(FlowLayout.LEFT));
		koreanmoviepanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		moviename.add(koreanmoviepanel);  moviename.add(englishmoviepanel);

		englishmovienameL=new JLabel(" Exit,2019");
		englishmovienameL.setFont(new Font("맑은 고딕",Font.BOLD,15));

		englishmoviepanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		englishmovienameL.setBackground(Color.WHITE);
		englishmoviepanel.add(englishmovienameL);

		/** 영화이름과 영화점수 사이 공백을 위한 패널 **/
		
		nullpanel.setPreferredSize(new Dimension(530,3));
		nullpanel.setBackground(Color.white);
		infopanel.add(nullpanel);


		
		moviescore.setPreferredSize(new Dimension(530,100));
		infopanel.add(moviescore);
		moviescore.setBackground(Color.WHITE);

		
		audiencescore.setPreferredSize(new Dimension(520,40));
		audiencescore.setBackground(Color.WHITE);
		infopanel.add(audiencescore);
		moviescore.add(audiencescore);

		/** audiencescore 관람객 평점 설정 **/

		audiencescoreL=new JLabel(" 관람객    ★★★★☆  8.42  네티즌  ★★★☆☆  6.43");
		audiencescoreL.setFont(new Font("맑은 고딕",Font.BOLD,20));
		audiencescore.setLayout(new FlowLayout(FlowLayout.LEFT));
		audiencescoreL.setBackground(Color.WHITE);
		audiencescore.add(audiencescoreL);

		
		reporterscore.setPreferredSize(new Dimension(520,40));
		reporterscore.setBackground(Color.WHITE);
		infopanel.add(reporterscore);
		moviescore.add(reporterscore);

		reporterscoreL=new JLabel(" 평론가    ★★★★☆  8.11");
		reporterscoreL.setFont(new Font("맑은 고딕",Font.BOLD,20));
		reporterscore.setLayout(new FlowLayout(FlowLayout.LEFT));
		reporterscoreL.setBackground(Color.WHITE);
		reporterscore.add(reporterscoreL);
		
		
		genrepanel.setPreferredSize(new Dimension(520,45));
		genrepanel.setBackground(Color.WHITE);
		infopanel.add(genrepanel);

		genretitleL=new JLabel(" 개요  ");
		genretitleL.setFont(new Font("맑은 고딕",Font.BOLD,25));
		genrepanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		genrepanel.add(genretitleL);

		genreL=new JLabel(" 액션,코미디   한국   103분   2019.07.31개봉");
		genreL.setFont(new Font("맑은 고딕",Font.BOLD,20));
		genreL.setForeground(Color.GRAY);
		genrepanel.add(genreL);			

		
		directorpanel.setPreferredSize(new Dimension(520,45));
		directorpanel.setBackground(Color.WHITE);
		infopanel.add(directorpanel);

		directortitleL=new JLabel(" 감독  ");
		directortitleL.setFont(new Font("맑은 고딕",Font.BOLD,25));
		directorpanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		directorpanel.add(directortitleL);

		directorL=new JLabel(" 이상근");
		directorL.setFont(new Font("맑은 고딕",Font.BOLD,20));
		directorL.setForeground(Color.GRAY);
		directorpanel.add(directorL);

		
		appearancepanel.setPreferredSize(new Dimension(520,45));
		appearancepanel.setBackground(Color.WHITE);
		infopanel.add(appearancepanel);
		
		appearancepaneltitleL=new JLabel(" 출연  ");
		appearancepaneltitleL.setFont(new Font("맑은 고딕",Font.BOLD,25));
		appearancepanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		appearancepanel.add(appearancepaneltitleL);

		appearancepanelL=new JLabel(" 조정석(용남), 윤아(의주), 고두심(현옥)");
		appearancepanelL.setFont(new Font("맑은 고딕",Font.BOLD,20));
		appearancepanelL.setForeground(Color.GRAY);
		appearancepanel.add(appearancepanelL);

		
		agepanel.setPreferredSize(new Dimension(520,45));
		agepanel.setBackground(Color.WHITE);
		infopanel.add(agepanel);

		agetitleL=new JLabel(" 등급  ");
		agetitleL.setFont(new Font("맑은 고딕",Font.BOLD,25));
		agepanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		agepanel.add(agetitleL);

		ageL=new JLabel(" 12세 관람가");
		ageL.setFont(new Font("맑은 고딕",Font.BOLD,20));
		ageL.setForeground(Color.GRAY);
		agepanel.add(ageL);

		
		viewcountpanel.setPreferredSize(new Dimension(520,45));
		viewcountpanel.setBackground(Color.WHITE);
		infopanel.add(viewcountpanel);

		viewtitleL=new JLabel(" 흥행  ");
		viewtitleL.setFont(new Font("맑은 고딕",Font.BOLD,25));
		viewcountpanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		viewcountpanel.add(viewtitleL);

		viewL=new JLabel(" 누적관객 4,532,156");
		viewL.setFont(new Font("맑은 고딕",Font.BOLD,20));
		viewL.setForeground(Color.GRAY);
		viewcountpanel.add(viewL);

	}

	//ReviewPanel
	/** 영화 시리즈 연관 영화 정보 넣을 패널(Series) **/
	//class SeriesPanel extends JPanel implements ActionListener{
	public void seriespanel() {
		
		seriespanel.setBackground(Color.WHITE);
		seriespanel.setPreferredSize(new Dimension(900,230));

		
		videopanel.setPreferredSize(new Dimension(900,27));
		videopanel.setBackground(Color.WHITE);
		videopanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		seriespanel.add(videopanel);

		videoL=new JLabel("   동영상");
		videoL.setFont(new Font("맑은 고딕",Font.BOLD,18));
		viewcountpanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		videoL.setOpaque(true);
		videopanel.add(videoL);

		/** 미리보기 동영상 넣기 **/
		ImageIcon videoposter1 = new ImageIcon("video1.jpg");//포스터 넣는칸
		Image origin_videoI = videoposter1.getImage();//ImagIcon을 Image로 전환
		Image change_videoI = origin_videoI.getScaledInstance(200,160,java.awt.Image.SCALE_SMOOTH);
		//이미지 사이즈 가로 269,385이미지를 스무스하게 만들어줌
		ImageIcon videoposterB = new ImageIcon(change_videoI);

		videoB=new JButton();
		videoB.setPreferredSize(new Dimension(200,160));
		videoB.setFocusPainted(false); //클릭테두리색
		//			videoB.setBorderPainted(false);//그냥테두리색
		videoB.setOpaque(true);		//투명도 true면 불투명 false면 투명
		videoB.addActionListener(this);
		seriespanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		videoB.setIcon(videoposterB);
		seriespanel.add(videoB);

		/** 미리보기 동영상 2번쨰 **/
		ImageIcon videoposter2 = new ImageIcon("video2.jpg");//포스터 넣는칸
		Image origin_videoI2 = videoposter2.getImage();//ImagIcon을 Image로 전환
		Image change_videoI2 = origin_videoI2.getScaledInstance(200,160,java.awt.Image.SCALE_SMOOTH);
		//이미지 사이즈 가로 269,385이미지를 스무스하게 만들어줌
		ImageIcon videoposterB2 = new ImageIcon(change_videoI2);

		videoB2=new JButton();
		videoB2.setPreferredSize(new Dimension(200,160));
		videoB2.setFocusPainted(false); //클릭테두리색
		//			videoB2.setBorderPainted(false);//그냥테두리색
		videoB2.setOpaque(true);		//투명도 true면 불투명 false면 투명
		videoB2.addActionListener(this);
		setLayout(new FlowLayout(FlowLayout.LEFT));
		videoB2.setIcon(videoposterB2);
		seriespanel.add(videoB2);

		/** 미리보기 동영상 3번쨰 **/
		ImageIcon videoposter3 = new ImageIcon("video3.jpg");//포스터 넣는칸
		Image origin_videoI3 = videoposter3.getImage();//ImagIcon을 Image로 전환
		Image change_videoI3 = origin_videoI3.getScaledInstance(200,160,java.awt.Image.SCALE_SMOOTH);
		//이미지 사이즈 가로 269,385이미지를 스무스하게 만들어줌
		ImageIcon videoposterB3 = new ImageIcon(change_videoI3);

		videoB3=new JButton();
		videoB3.setPreferredSize(new Dimension(200,160));
		videoB3.setFocusPainted(false); //클릭테두리색
		//			videoB3.setBorderPainted(false);//그냥테두리색
		videoB3.setOpaque(true);		//투명도 true면 불투명 false면 투명
		videoB3.addActionListener(this);
		seriespanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		videoB3.setIcon(videoposterB3);
		seriespanel.add(videoB3);

		/** 미리보기 동영상 4번째 **/
		ImageIcon videoposter4 = new ImageIcon("video4.jpg");//포스터 넣는칸
		Image origin_videoI4 = videoposter4.getImage();//ImagIcon을 Image로 전환
		Image change_videoI4 = origin_videoI4.getScaledInstance(200,160,java.awt.Image.SCALE_SMOOTH);
		//이미지 사이즈 가로 269,385이미지를 스무스하게 만들어줌
		ImageIcon videoposterB4 = new ImageIcon(change_videoI4);

		videoB4=new JButton();
		videoB4.setPreferredSize(new Dimension(200,160));
		videoB4.setFocusPainted(false); //클릭테두리색
		//			videoB4.setBorderPainted(false);//그냥테두리색
		videoB4.setOpaque(true);		//투명도 true면 불투명 false면 투명
		videoB4.addActionListener(this);
		seriespanel.setLayout(new FlowLayout(FlowLayout.CENTER,18,8));
		videoB4.setIcon(videoposterB4);
		seriespanel.add(videoB4);
		//생성자



	}
	public static void main(String[] args) {
		MovieInfoPlus re=new MovieInfoPlus();
		JFrame f=new JFrame();
		f.setSize(1000,800);
		f.add(new MovieInfoPlus());
		f.setVisible(true);

		

	}//main()
}//movieinfoplusclass

