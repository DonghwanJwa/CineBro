package com.movie.UI;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MovieCancelPanel extends JOptionPane implements ActionListener{
	/**JOptionPane은 actionListener 메서드안에 들어가는 컨테이너중 하나**/
	/**새로운 경고 윈도우를 호출한다. 일반적인 버튼추가나, Frame메서드 사용 불가능**/
	/* 리스너 내부에서 if로 분기점을 만들어줘야됨
	 * 여기서는 메시지창 내부에 버튼을 YES_NO_OPTION 으로 만들어줌
	 * 
	 * 리스너 메서드 내부에서 쓰일 if구문)
	 * if(result == JOptionPane.CLOSED_OPTION)   //그냥 닫기버튼을 눌렀을때
	 * else if(result == JOptionPane.YES_OPTION) //Yes버튼을 눌렀을 때
	 * else if(result == JOptionPane.NO_OPTION)  //NO버튼을 눌렀을떄(그냥 else써도됨)
	 */
	/* 변수 생성 */
	JPanel mainP = new JPanel(); //예매문구(라벨)를 넣을 패널생성
	JPanel infoP = new JPanel(); //영화명,금액,날짜 등 예매 정보를 출력할 패널

	JLabel questionL = new JLabel("예매를 취소하시겠습니까?");                  //예매취소 확인창 문구들
	JLabel announ1L = new JLabel("※ 인터넷 예매 취소는 상영시간 20분 전까지 가능하며,");
	JLabel announ2L = new JLabel("예매 가능은 상영시간 30분 전까지 가능합니다.");

	JLabel number_titleL = new JLabel("예매번호 : ");//예약 정보 타이틀 라벨
	JLabel movie_titleL = new JLabel("영화명 : ");  
//	JLabel payment_titleL = new JLabel("금액 : ");
	JLabel date_titleL = new JLabel("날짜 : ");
	JLabel time_titleL = new JLabel("시간 : ");
	JLabel screen_titleL = new JLabel("상영관 : ");
	JLabel people_titleL = new JLabel("인원 : ");

	JLabel number_compL = new JLabel();           //예약 정보 출력 라벨   
	JLabel movie_compL = new JLabel();            //setText() 메서드 사용하여
//	JLabel payment_compL = new JLabel();          //예약정보마다 다른 정보 출력
	JLabel date_compL = new JLabel(); 
	JLabel time_compL = new JLabel();
	JLabel screen_compL = new JLabel();
	JLabel people_compL = new JLabel();

	ImageIcon preImg; //포스터 초기 이미지아이콘
	ImageIcon poster; //수정된 포스터 이미지아이콘
	
	int result; //Dialog의 예,아니오 버튼 이벤트를 위한 객체
	
	Font font = new Font("맑은 고딕",Font.BOLD,15); //라벨에 적용시킬 폰트
	

	public MovieCancelPanel(FakeReserveVO vo) {
		/*포스터 이미지 아이콘 사이즈 변환*/
		preImg = new ImageIcon(setPoster(vo));//포스터 넣는란
		Image originImg = preImg.getImage();//ImageIcon을 Image로 전환
		Image changeImg = originImg.getScaledInstance(150,200,java.awt.Image.SCALE_SMOOTH);
		//이미지 사이즈 가로120,세로160,이미지를 스무스하게
		
		try {
		poster = new ImageIcon(changeImg);
		//Image로 ImageIcon 지정		
		}catch(Exception e) {
			poster = null;
		}//이미지 불러오기 실패시 공란으로 패널 출력

		/*예매 문구 넣기*/
		mainP.setPreferredSize(new Dimension(500, 225));       //패널의 크기 지정
		mainP.setLayout(new FlowLayout(FlowLayout.CENTER,0,5));//패널내부 레이아웃 지정: 플로우 중앙

		questionL.setPreferredSize(new Dimension(500,25));     //라벨 크기 설정(mainP의 가로에 딱맞게)
		announ1L.setPreferredSize(new Dimension(500,25));
		announ2L.setPreferredSize(new Dimension(500,25));

		infoP.setPreferredSize(new Dimension(500,125));         //infoP 크기 및 레이아웃 설정
		infoP.setLayout(new FlowLayout(FlowLayout.LEFT,0,5));

		mainP.add(questionL);   mainP.add(infoP);              //메인패널에 예약취소 라벨 및 패널 추가
		mainP.add(announ1L);    mainP.add(announ2L);

		number_titleL.setPreferredSize(new Dimension(80,25));  //예약 정보 타이틀 라벨 크기지정
		movie_titleL.setPreferredSize(new Dimension(80,25));   
//		payment_titleL.setPreferredSize(new Dimension(80,25));
		date_titleL.setPreferredSize(new Dimension(80,25));
		time_titleL.setPreferredSize(new Dimension(80,25));
		screen_titleL.setPreferredSize(new Dimension(80,25));
		people_titleL.setPreferredSize(new Dimension(80,25));

		number_compL.setPreferredSize(new Dimension(420,25));  //예약 정보 출력 라벨 크기지정
		movie_compL.setPreferredSize(new Dimension(170,25));   
//		payment_compL.setPreferredSize(new Dimension(170,25));
		date_compL.setPreferredSize(new Dimension(170,25));
		time_compL.setPreferredSize(new Dimension(170,25));
		screen_compL.setPreferredSize(new Dimension(170,25));
		people_compL.setPreferredSize(new Dimension(170,25));

		infoP.add(number_titleL); infoP.add(number_compL);      //infoP에 예약 정보 라벨 추가
		infoP.add(movie_titleL);  infoP.add(movie_compL);
//		infoP.add(payment_titleL);infoP.add(payment_compL);
		infoP.add(date_titleL);   infoP.add(date_compL);
		infoP.add(time_titleL);   infoP.add(time_compL);
		infoP.add(screen_titleL); infoP.add(screen_compL);
		infoP.add(people_titleL); infoP.add(people_compL);

		setComp(vo); //DB정보를 불러와서 라벨에 입력하는 메서드

		questionL.setFont(font);                                   //폰트 설정
		announ1L.setFont(font);       announ2L.setFont(font);
		number_titleL.setFont(font);  number_compL.setFont(font);
		movie_titleL.setFont(font);   movie_compL.setFont(font);
//		payment_titleL.setFont(font); payment_compL.setFont(font);
		date_titleL.setFont(font);    date_compL.setFont(font);
		time_titleL.setFont(font);    time_compL.setFont(font);
		screen_titleL.setFont(font);  screen_compL.setFont(font);
		people_titleL.setFont(font);  people_compL.setFont(font);

		/*경고창 생성*/
		result = showConfirmDialog(null,mainP,"예매취소",
				JOptionPane.YES_NO_OPTION,PLAIN_MESSAGE,poster);
		//showConfirmDialog(메시지창 다이얼로그가 어떤 Frame에서 나타나게 될 것인지를 정해주는 변수,출력할 메세지(Object),
		//메시지창 제목(String),버튼옵션 종류,메세지 경고스티커 종류,메시지창 좌측에 넣을 이미지(경고이미지였으나 포스터로 바꿈));
	}//생성자

	public String setPoster(FakeReserveVO vo) {           //DB 예약정보중 포스터 입력 메서드
		/* 영화예매 DAO 메서드 */
		return vo.getMovie_poster();
	}

	public void setComp(FakeReserveVO vo) {               //DB 예약정보 입력하기
		/* 영화예매 DAO 메서드 */
		number_compL.setText(vo.getRes_num());
		movie_compL.setText(vo.getMovie_name());
//		payment_compL.setText(vo.get);
		date_compL.setText(vo.getRes_date());
		time_compL.setText(vo.getRes_time());
		screen_compL.setText(vo.getRes_cinema());
		people_compL.setText(vo.getRes_ticketnum());	
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(result == JOptionPane.CLOSED_OPTION) {    //그냥 닫기버튼을 눌렀을때
			
		}else if(result == JOptionPane.YES_OPTION) {//Yes버튼을 눌렀을 때
			//DAO delete 실행 
		}else if(result == JOptionPane.NO_OPTION)  {//NO버튼을 눌렀을떄(그냥 else써도됨)
			
		}//=> 실행문장은 Reserveinfo class파일에 있음
	}//ap()

}//MovieCancelPanel class
