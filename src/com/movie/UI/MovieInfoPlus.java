package com.movie.UI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
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
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.movie.DAO.MovieDAO;
import com.movie.VO.MovieVO;
import com.movie.main.AppManager;

/** 8월 13일에 오면 얼타지말고 주석 달아 **/
public class MovieInfoPlus extends JDialog implements ActionListener {

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
	private JLabel movieingL;
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



	private JButton reserveB;						//예매하기 버튼
	private JButton videoB;							//리뷰 동영상 맨왼쪽
	private JButton videoB2;						//리뷰 동영상 두번쨰
	private JButton videoB3;						//리뷰 동영상 세번째
	private JButton videoB4;						//리뷰 동영상 네번쨰
	
	
	MovieDAO dao = AppManager.getInstance().getDAOManager().getMovieDAO();	//싱글톤입력
	MainUI main = AppManager.getInstance().getMainUi();
	

	public MovieInfoPlus(int i) {


		setposterpanel(dao.getMovieInfo(i));	// setposterpanel 메서드에 getMovieInfo가져오기
		setinfopanel(dao.getMovieInfo(i));		// setinfopanel메서드에 getMovieInfo가져오기
		seriespanel(dao.getMovieInfo(i));		// seriespanel메서드에 getMovieInfo가져오기 


		/** 패널 위에 올릴 패널 **/

		button_infopanel = new JPanel();							//인포패널을 올릴 큰 패널
		button_infopanel.setPreferredSize(new Dimension(550,550));	//버튼패널 사이즈 설정
		button_infopanel.add(infopanel,BorderLayout.CENTER);		//버튼패널에 인포패널 중앙 배치
		button_infopanel.setBackground(Color.BLACK);				//버튼패널 배경색 지정

		infopanel.setBackground(Color.BLACK);						//인포패널 배경색 지정

		/** 	포스터패널과 패널1을 올릴 패널만들기 		**/
		toppanel.setPreferredSize(new Dimension(900,525));			//탑패널 사이즈 설정
		toppanel.add(posterpanel,BorderLayout.WEST); 				//탑패널에 포스터패널을 왼쪽에 배치
		toppanel.add(button_infopanel);								//인포버튼패널을 탑패널에 올림!!
		toppanel.setBackground(Color.BLACK);						//탑패널 배경색 지정

		/** 	패널2와 시리즈패널을 메인 패널에 올리기	**/

		seriespanel.setPreferredSize(new Dimension(900,700));		//동영상패널과 동영상글자패널을 올릴 시리즈 패널 생성
		seriespanel.setBackground(Color.BLACK);						//시리즈 패널 배경색 검정
		add(toppanel); 												//시리즈 패널에 탑패널 올림


		add(seriespanel);											//메인 패널에 시리즈 패널올림
		setSize(new Dimension(900,800));							//제일큰패널 사이즈 지정
		getContentPane().setBackground(Color.BLACK);				//배경색 지정
		setLocationRelativeTo(null);								//창이 켜졌을때 어디에 배치 할지 정함 Null값은 중앙
		setVisible(true);											//패널을 보이게함
	}//MovieInfoPlus생성자
	
	
	/** 동영상 버튼들에 url 연결하기 **/
	@Override
	public void actionPerformed(ActionEvent e) {							//엑션이벤트 e객체 생성
		MovieVO m =AppManager.getInstance().getDataManager().getMovieVO();	//싱글톤 사용
		if(e.getSource()==videoB) {											//videoB 버튼에 이벤트 생성
			try {															//videoB를 눌렀을떄 
				Thread.sleep(500);											//0.5초후 실행하기
				Runtime.getRuntime().exec(m.getTeaser());					//Runtime.getRuntime().exec(url)메서드로 url 불러오기
			}catch(Exception ie) {												
				ie.printStackTrace();										//이하 반복
			}//try~catch	
			return; 														//다음 if 절 자동실행 방지
		}//if
		if(e.getSource()==videoB2) {
			try {
				Thread.sleep(500);
				Runtime.getRuntime().exec(m.getOneView());
			}catch(Exception ie) {
				ie.printStackTrace();
			}//try~catch
			return;
		}//if
		if(e.getSource()==videoB3) {
			try {
				Thread.sleep(500);
				Runtime.getRuntime().exec(m.getTwoView());
			}catch(Exception ie) {
				ie.printStackTrace();
			}//try~catch
			return;
		}//if
		if(e.getSource()==videoB4) {
			try {
				Thread.sleep(500);
				Runtime.getRuntime().exec(m.getThreeView());
			}catch(Exception ie) {
				ie.printStackTrace();
			}//try~catch
			return;
		}//if
	}//actionPerformed()

	/**영화 포스터 넣을 패널(PosetPenel)**/

	public void setposterpanel(MovieVO m) { 								//setposterpanel()메서드에 MovieVO 내용 저장한 m객체 생성

		posterpanel.setBackground(Color.BLACK);								//포스터패널 색 지정
		posterpanel.setPreferredSize(new Dimension(300,490));				//포스터를 올릴 패널 사이즈 지정 
		posterpanel.setLayout(new FlowLayout());							
		posterpanel.setBorder(BorderFactory.createEmptyBorder(30,0,0,0));	//BorderFactory.createEmptyBorder는 패딩이라고 부르며
																			//상좌하우 순이며 그쪽에 얼마만큼 띄울건지 숫자 입력


		/** 	포스터 이미지 조정		**/

		ImageIcon mainposter = new ImageIcon("pic/"+m.getMovie_img());							//포스터 넣는칸
		Image originImg = mainposter.getImage();												//ImagIcon을 Image로 전환
		Image changeImg = originImg.getScaledInstance(275,400,java.awt.Image.SCALE_SMOOTH);		
		//이미지 사이즈 가로 269,385이미지를 스무스하게 만들어줌
		ImageIcon poster = new ImageIcon(changeImg);											
		


		/** 포스터에 버튼넣기	**/

		posterL =new JLabel(poster);				//posterL이란 라벨에 poster 넣음
		posterL.setBackground(Color.BLACK);			//posterL 배경색 지정
		posterL.setOpaque(true);					//posterL 보이게 함
		posterpanel.add(posterL);					//포스터패널에 포스터L 올림


		reserveB=new JButton("예매하기");				//예매하기 버튼 생성
		reserveB.setBackground(Color.red); 			//버튼배경
		reserveB.setForeground(Color.black);		//버튼글짜색
		reserveB.setFocusPainted(false); 			//클릭테두리색
		reserveB.setBorderPainted(false);			//그냥테두리색
		reserveB.setOpaque(true);					//투명도 true면 불투명 false면 투명

		posterpanel.add(reserveB);					//포스터패널에 reserveB 버튼 넣음
		
		
		reserveB.addActionListener(new ActionListener(){			//예매하기 버튼에 이벤트 등록			
			@Override
			public void actionPerformed(ActionEvent e) {			//ActionPerformed메서드 호출
				dispose();											//예매하기 눌렀을때 상세정보페이지 꺼짐
				main.homeB.setBackground(Color.gray.brighter());	//꺼진뒤 HOME버튼 회색
				main.movieB.setBackground(Color.GRAY.brighter());	//현제상영작 회색
				main.reservB.setBackground(Color.RED);				//예매페이지 빨간색으로 하여 눌르든한 색넣음
				main.checkB.setBackground(Color.GRAY.brighter());	//예매조회 회색
				main.myPageB.setBackground(Color.GRAY.brighter());	//My Page 회색
				main.card.show(main.mainC,"reservB"); 				//예매페이지를 보여주게 만듬!
			}
		});
	}//PosterPanel 생성자

	
	/** 영화정보를 넣을 InfoPanel **/


	/**	iNFO PANEL 설정	**/
	public void setinfopanel(MovieVO m) {						//setinfopanel()에 MovieVO를 m객체로 만들어 넣음

		infopanel.setBackground(Color.BLACK);					//인포패널 배경색 지정
		infopanel.setPreferredSize(new Dimension(550,500));		//인포패널 사이즈 지정
		infopanel.setLayout(new FlowLayout(FlowLayout.LEFT));	//인포패널 왼쪽으로 정렬

		/** infopanel은 Infoin,infoin2 올릴 패널 **/


		moviename.setBackground(Color.BLACK);						//moviename 패널 배경색 지정
		moviename.setPreferredSize(new Dimension(530,100));			//moviename 패널 크기 지정
		koreanmoviepanel.setBackground(Color.BLACK);				//한글영화 이름 패널 배경색 지정
		koreanmoviepanel.setPreferredSize(new Dimension(520,60));	//한글영화 이름 패널 사이즈 지정
		englishmoviepanel.setBackground(Color.BLACK);				//영어영화 이름 패널 배경색 지정
		englishmoviepanel.setPreferredSize(new Dimension(520,25));	//영어영화 이름 패널 사이즈 지정
		infopanel.add(moviename);									//인포패널에 moviename 패널 올림

		movienameL=new JLabel(m.getMovie_nameK());					//한글영화 이름 라벨에 한글영화DB 넣음
		movieingL=new JLabel(" 상영중▶");								//한글영화 뒤에 상영중 라벨 


		movienameL.setFont(new Font("맑은 고딕",Font.BOLD,39));		//한글영화 이름 폰트 지정
		movienameL.setBackground(Color.BLACK);						//한글영화 라벨 배경색 지정
		movienameL.setForeground(Color.WHITE);						//한글영화 이름 색깔 지정
		
		movieingL.setBackground(Color.blue);						//상영중 라벨 배경색 지정
		movieingL.setForeground(Color.white);						//상영중 라벨 글자색 지정
		movieingL.setFont(new Font("맑은 고딕",Font.BOLD,20));			//상영중 폰트 지정
		movieingL.setOpaque(true);									//상영중 라벨이 보이게함 

		koreanmoviepanel.add(movienameL);koreanmoviepanel.add(movieingL);	//koreanmoviepanle에 한글영화이름 패널과 상영중 패널을 올림
		moviename.setLayout(new FlowLayout(FlowLayout.LEFT));				//한글영화 이름을 왼쪽 정렬
		koreanmoviepanel.setLayout(new FlowLayout(FlowLayout.LEFT));		//한글영화 패널을 왼쪽 정렬
		moviename.add(koreanmoviepanel);  moviename.add(englishmoviepanel);	//영화이름 패널에 한글영화 이름 패널과 영어영화 이름 패널을 올림
		moviename.setBackground(Color.BLACK);
		
		englishmovienameL=new JLabel(m.getMovie_nameE());					//영어영화 이름라벨에 영어영화 이름 DB연결
		englishmovienameL.setFont(new Font("맑은 고딕",Font.BOLD,18));			//영어영화 이름 폰트 지정

		englishmovienameL.setBackground(Color.BLACK);						//영어영화 라벨 배경색 지정
		englishmovienameL.setForeground(Color.WHITE);						//영어영화 글자색 지정
		
		englishmoviepanel.setLayout(new FlowLayout(FlowLayout.LEFT));		//영어영화 이름 패널을 왼쪽 정렬
		englishmoviepanel.add(englishmovienameL);							//영어영화 패널에 영어영화 라벨 올림

		/** 영화이름과 영화점수 사이 공백을 위한 패널 **/

		nullpanel.setPreferredSize(new Dimension(530,3));					//영화 이름 패널과 밑에 정보칸 공백을 위해 Nullpanel 만듬
		nullpanel.setBackground(Color.black);								//배경색 지정
		infopanel.add(nullpanel);											//인포패널에 눌패널 올림



		moviescore.setPreferredSize(new Dimension(530,100));				//영화평점 패널 사이즈지정
		infopanel.add(moviescore);											//인포패널에 영화평점 패널 올림
		moviescore.setBackground(Color.BLACK);								//영화평점 패널 배경색 지정

		/** audiencescore 관람객 평점 설정 **/

		audiencescore.setPreferredSize(new Dimension(520,40));				//관람객 평점 패널 사이즈 지정
		audiencescore.setBackground(Color.BLACK);							//관람객 평점 패널 배경색 지정
		infopanel.add(audiencescore);										//인포패널에 관람객 평점 패널 올림
		moviescore.add(audiencescore);										//영화평점패널에 관람객 평점 패널 올림


		audiencescoreL=new JLabel(m.getAudience());							//관람객 평점라벨에 관람객평점 DB연결
		audiencescoreL.setFont(new Font("맑은 고딕",Font.BOLD,20));			//관람객 평점라벨 폰트지정
		audiencescoreL.setBackground(Color.BLACK);							//관람객 평점라벨 배경색 지정
		audiencescoreL.setForeground(Color.WHITE);
		audiencescore.setLayout(new FlowLayout(FlowLayout.LEFT));			//관람객 평점라벨 위치 왼쪽 정렬
		audiencescore.add(audiencescoreL);									//관람객 평점패널에 관람객라벨올림

		/** reporterscore 평론가 평점 패널 **/
		
		reporterscore.setPreferredSize(new Dimension(520,40));				//평론가 패널에 사이즈 지정
		reporterscore.setBackground(Color.BLACK);							//평론가 패널에 색 지정
		infopanel.add(reporterscore);										//인포패널에 전문가패널 올림
		moviescore.add(reporterscore);										//영화평점 패널에 전문가패널 올림

		reporterscoreL=new JLabel(m.getCriticism());						//평론가 라벨에 전문가 DB연결 
		reporterscoreL.setFont(new Font("맑은 고딕",Font.BOLD,20));			//평론가 라벨 폰트 지정
		reporterscoreL.setBackground(Color.BLACK);							//평론가 라벨 배경색 지정
		reporterscoreL.setForeground(Color.WHITE);
		reporterscore.setLayout(new FlowLayout(FlowLayout.LEFT));			//평론가 라벨 왼쪽 정렬
		reporterscore.add(reporterscoreL);									//평론가 패널에 평론가 라벨 올림

		
		//** genre 장르 패널 생성 **/
		
		genrepanel.setPreferredSize(new Dimension(520,45));					//장르패널 사이즈 지정
		genrepanel.setBackground(Color.BLACK);								//장르패널 배경색 지정
		infopanel.add(genrepanel);											//인포패널에 장르패널 올림

		genretitleL=new JLabel(" 개요  ");									//개요라는 라벨 생성
		genretitleL.setFont(new Font("맑은 고딕",Font.BOLD,25));				//개요 라벨 폰트 지정
		genretitleL.setForeground(Color.WHITE);                             //개요 라벨 글자색 지정
		genrepanel.setLayout(new FlowLayout(FlowLayout.LEFT));				//개요 패널 왼쪽 정렬
		genrepanel.add(genretitleL);										//장르패널에 개요 라벨 올림

		genreL=new JLabel(m.getGenre());									//장르라벨에 장르DB연결
		genreL.setFont(new Font("맑은 고딕",Font.BOLD,15));					//장르라벨 폰트 지정
		genreL.setForeground(Color.PINK);									//장르라벨 글자색 지정
		genrepanel.add(genreL);												//장르패널에 장르라벨 추가
		
		/** 감독 패널 생성 **/

		directorpanel.setPreferredSize(new Dimension(520,45));				//감독패널 사이즈 지정
		directorpanel.setBackground(Color.BLACK);							//감독패널 배경색 지정
		infopanel.add(directorpanel);										//인포패널에 감독패널 추가

		directortitleL=new JLabel(" 감독  ");									//감독 라벨 생성
		directortitleL.setFont(new Font("맑은 고딕",Font.BOLD,25));			//감독 라벨 폰트 지정
		directortitleL.setForeground(Color.WHITE);                          //감독 라벨 글자색 지정
		directorpanel.setLayout(new FlowLayout(FlowLayout.LEFT));			//감독패널 왼쪽 정렬
		directorpanel.add(directortitleL);									//감독패널에 감독라벨 추가

		directorL=new JLabel(m.getDirector());								//감독이름 라벨에 감독이름 DB연결
		directorL.setFont(new Font("맑은 고딕",Font.BOLD,15));					//감독이름 라벨 폰트 지정
		directorL.setForeground(Color.PINK);								//감독이름 라벨 글자색 지정
		directorpanel.add(directorL);										//감독패널에 감독라벨 추가

		/** 출연 패널 생성 **/
		
		appearancepanel.setPreferredSize(new Dimension(520,45));			//출연 패널 사이즈 지정
		appearancepanel.setBackground(Color.BLACK);							//출연 패널 배경색 지정
		infopanel.add(appearancepanel);										//인포패널에 출연패널 추가

		appearancepaneltitleL=new JLabel(" 출연  ");							//출연 라벨 생성
		appearancepaneltitleL.setFont(new Font("맑은 고딕",Font.BOLD,25));		//출연 라벨 폰트 지정
		appearancepaneltitleL.setForeground(Color.WHITE);                   //출연 라벨 글자색 지정
		appearancepanel.setLayout(new FlowLayout(FlowLayout.LEFT));			//출연 패널 왼쪽 정렬
		appearancepanel.add(appearancepaneltitleL);							//출연 패널에 출연라벨 올림

		appearancepanelL=new JLabel(m.getActors());							//출연자 목록 라벨에 DB 연결
		appearancepanelL.setFont(new Font("맑은 고딕",Font.BOLD,15));			//출연자 목록 라벨 폰트 지정
		appearancepanelL.setForeground(Color.PINK);							//출연자 목록 라벨 글자색 지정
		appearancepanel.add(appearancepanelL);								//출연 패널에 출연자 목록 라벨 추가

		/** 영화 나이 등급 패널 생성 **/
		
		agepanel.setPreferredSize(new Dimension(520,45));					//영화 등급 패널 사이즈 지정
		agepanel.setBackground(Color.BLACK);								//영화 등급 패널 배경색 지정
		infopanel.add(agepanel);											//인포패널에 영화 등급 패널 올림 

		agetitleL=new JLabel(" 등급  ");										//등급 라벨 생성
		agetitleL.setFont(new Font("맑은 고딕",Font.BOLD,25));					//등급 라벨 폰트 지정
		agetitleL.setForeground(Color.WHITE);                               //등급 라벨 글자색 지정
		agepanel.setLayout(new FlowLayout(FlowLayout.LEFT));				//등급 패널 왼쪽 정렬
		agepanel.add(agetitleL);											//등급패널에 '등급'라벨 추가

		ageL=new JLabel(m.getAge());										//관람 등급 라벨에 DB 연결
		ageL.setFont(new Font("맑은 고딕",Font.BOLD,15));						//관람 등급 라벨 폰트 지정
		ageL.setForeground(Color.PINK);										//관람 등급 라벨 글자색 지정
		agepanel.add(ageL);													//등급 패널에 등급 라벨 추가


		viewcountpanel.setPreferredSize(new Dimension(520,45));				//누적관객 패널 사이즈 지정
		viewcountpanel.setBackground(Color.BLACK);							//누적관객 패널 배경색 지정
		infopanel.add(viewcountpanel);										//인포패널에 누적관객 패널 추가
		
		/** view 누적관객 패널 생성 **/
		
		viewtitleL=new JLabel(" 흥행  ");										//'흥행'라벨 생성
		viewtitleL.setFont(new Font("맑은 고딕",Font.BOLD,25));				//'흥행'라벨 폰트 지정
		viewtitleL.setForeground(Color.WHITE); 								//'흥행'라벨 글자색 지정
		viewcountpanel.setLayout(new FlowLayout(FlowLayout.LEFT));			//누적관객 패널 왼쪽 정렬
		viewcountpanel.add(viewtitleL);										//누전관객 패널에 '흥행'라벨 추가

		viewL=new JLabel(m.getPeople());									//누적관객수 라벨 DB 연결
		viewL.setFont(new Font("맑은 고딕",Font.BOLD,15));						//누적관객수 라벨 폰트 지정
		viewL.setForeground(Color.PINK);									//누적관객수 글자색 지정
		viewcountpanel.add(viewL);											//누적관객 패널에 누적관객수 라벨 추가

	}

	//ReviewPanel
	/** 영화 시리즈 연관 영화 정보 넣을 패널(Series) **/
	public void seriespanel(MovieVO m) {							//시리즈 메서드에 MovieVO 클래스를 객체m으로 호출

		seriespanel.setBackground(Color.BLACK);						//시리즈 패널 배경색 지정
		seriespanel.setPreferredSize(new Dimension(900,230));		//시리즈 패널 사이즈 지정


		videopanel.setPreferredSize(new Dimension(850,27));			//'동영상' 글자 입력할 패널 비디오 패널 생성
		videopanel.setBackground(Color.DARK_GRAY);					//비디오 패널 배경색 지정
		videopanel.setLayout(new FlowLayout(FlowLayout.LEFT));		//비디오 패널 왼쪽 정렬
		seriespanel.add(videopanel);								//시리즈패널에 비디오 패널 추가

		videoL=new JLabel("   동영상");								//'동영상' 라벨 생성
		videoL.setFont(new Font("맑은 고딕",Font.BOLD,17));			//'동영상' 라벨 폰트 지정
		videoL.setBackground(Color.DARK_GRAY);
		videoL.setOpaque(true);										//'동영상' 라벨을 보이게 함
		videoL.setForeground(Color.WHITE); 							//'동영상' 라벨 글자색 지정
		videopanel.add(videoL);										//비디오 패널에 '동영상'라벨 추가





		/** 			미리보기 동영상 넣기 				**/
		ImageIcon videoposter1 = new ImageIcon("pic/"+m.getTeaser_img());		//동영상1에 동영상1 DB 이미지 연결
		Image origin_videoI = videoposter1.getImage();//ImagIcon을 Image로 전환
		Image change_videoI = origin_videoI.getScaledInstance(200,160,java.awt.Image.SCALE_SMOOTH);
		//이미지 사이즈 가로 269,385이미지를 스무스하게 만들어줌
		ImageIcon videoposterB = new ImageIcon(change_videoI);

		videoB=new JButton();									//동영상1에 올릴 비디오버튼1 생성
		videoB.setPreferredSize(new Dimension(200,160));		//비디오버튼1 사이즈 지정
		videoB.setFocusPainted(false); 							//클릭테두리색
		videoB.setOpaque(true);									//투명도 true면 불투명 false면 투명
		videoB.addActionListener(this);							//비디오버튼1 엑션이벤트 넣어줌
		seriespanel.setLayout(new FlowLayout(FlowLayout.LEFT));	//시리즈패널 왼쪽정렬
		videoB.setIcon(videoposterB);							//시리즈 패널에 동영상1 이미지버튼 올림 
		seriespanel.add(videoB);

		/** 미리보기 동영상 2번쨰 **/
		ImageIcon videoposter2 = new ImageIcon("pic/"+m.getOneView_img());		//동영상2에 동영상2 DB 이미지 연결
		Image origin_videoI2 = videoposter2.getImage();							//ImagIcon을 Image로 전환
		Image change_videoI2 = origin_videoI2.getScaledInstance(200,160,java.awt.Image.SCALE_SMOOTH);
		//이미지 사이즈 가로 269,385이미지를 스무스하게 만들어줌//
		ImageIcon videoposterB2 = new ImageIcon(change_videoI2);				//이미지 클래스로 사이즈 지정해준뒤
		//다시 이미지아이콘으로 바꾼다
		//이유는 버튼을 넣기위해 *쌉중요

		videoB2=new JButton();													//비디오2 버튼 생성
		videoB2.setPreferredSize(new Dimension(200,160));						//비디오2 버튼 사이즈 지정
		videoB2.setFocusPainted(false); 										//클릭테두리색
		videoB2.setOpaque(true);												//투명도 true면 불투명 false면 투명
		videoB2.addActionListener(this);										//비디오버튼2 액션이벤트 넣어줌
		setLayout(new FlowLayout(FlowLayout.LEFT));								//비디오버튼2 왼쪽정렬
		videoB2.setIcon(videoposterB2);											//비디오버튼2에 동영상2 이미지 올림
		seriespanel.add(videoB2);												//시리즈패널에 비디오버튼2 올림

		/** 미리보기 동영상 3번쨰 **/
		ImageIcon videoposter3 = new ImageIcon("pic/"+m.getTwoView_img());		//동영상3이미지에 동영상3 DB 이미지 연결
		Image origin_videoI3 = videoposter3.getImage();							//ImagIcon을 Image로 전환
		Image change_videoI3 = origin_videoI3.getScaledInstance(200,160,java.awt.Image.SCALE_SMOOTH);
		//이미지 사이즈 가로 269,385이미지를 스무스하게 만들어줌 //
		ImageIcon videoposterB3 = new ImageIcon(change_videoI3);				//이미지 사이즈 지정해둔뒤
		//다시 이미지 아이콘으로 변경

		videoB3=new JButton();													//동영상3 이미지 연결할 비디오3 버튼 생성
		videoB3.setPreferredSize(new Dimension(200,160));						//비디오3 버튼 사이즈 지정
		videoB3.setFocusPainted(false); 										//클릭테두리색 없음 지정
		videoB3.setOpaque(true);												//투명도 true면 불투명 false면 투명
		videoB3.addActionListener(this);										//비디오3 액션이벤트 만듬
		seriespanel.setLayout(new FlowLayout(FlowLayout.LEFT));					//시리즈패널 왼쪽 정렬
		videoB3.setIcon(videoposterB3);											//비디오3버튼에 동영상3이미지 추가
		seriespanel.add(videoB3);												//시리즈패널에 비디오3 버튼 추가



		/** 미리보기 동영상 4번째 **/
		ImageIcon videoposter4 = new ImageIcon("pic/"+m.getThreeView_img());//동영상4이미지에 동영상4 DB 이미지 연결
		Image origin_videoI4 = videoposter4.getImage();						//ImagIcon을 Image로 전환
		Image change_videoI4 = origin_videoI4.getScaledInstance(200,160,java.awt.Image.SCALE_SMOOTH);
		//이미지 사이즈 가로 269,385이미지를 스무스하게 만들어줌
		ImageIcon videoposterB4 = new ImageIcon(change_videoI4);			//이미지클래스를 이미지아이콘으로 바꿔서 저장

		videoB4=new JButton();												//동영상4 이미지 연결할 비디오4 버튼생성
		videoB4.setPreferredSize(new Dimension(200,160));					//비디오4 버튼 사이즈 지정
		videoB4.setFocusPainted(false); 									//클릭테두리색		
		videoB4.setOpaque(true);											//투명도 true면 불투명 false면 투명
		videoB4.addActionListener(this);									//비디오4버튼에 액션이벤트 만듬
		seriespanel.setLayout(new FlowLayout(FlowLayout.CENTER,18,8));		//시리즈패널 중앙에 정렬후 여백 지정
		videoB4.setIcon(videoposterB4);										//비디오버튼4에 동영상4 이미지 연결
		seriespanel.add(videoB4);											//시리즈패널에 비디오버튼4 추가




	}
	
}//movieinfoplusclass

