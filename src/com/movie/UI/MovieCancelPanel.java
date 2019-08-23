package com.movie.UI;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.movie.DAO.BCheckDAO;
import com.movie.VO.BookingVO;
import com.movie.VO.MovieNowVO;
import com.movie.VO.MovietimeVO;
import com.movie.main.AppManager;

public class MovieCancelPanel extends JOptionPane{
	JPanel mainP = new JPanel(); //예매문구(라벨)를 넣을 패널생성
	JPanel infoP = new JPanel(); //영화명,금액,날짜 등 예매 정보를 출력할 패널

	JLabel questionL = new JLabel("예매를 취소하시겠습니까?");                  //예매취소 확인창 문구들
	JLabel announ1L = new JLabel("※ 예매 취소시 복구가 불가능 합니다.");
	JLabel announ2L = new JLabel("	신중하게 취소를 선택해 주세요.");

	JLabel number_titleL = new JLabel("예매번호 : ");//예약 정보 타이틀 라벨
	JLabel movie_titleL = new JLabel("영화명 : ");  
	JLabel payment_titleL = new JLabel("금액 : ");
	JLabel date_titleL = new JLabel("날짜 : ");
	JLabel time_titleL = new JLabel("시간 : ");
	JLabel screen_titleL = new JLabel("상영관 : ");
	JLabel seat_titleL = new JLabel("좌석 : ");

	JLabel number_compL = new JLabel();           //예약 정보 출력 라벨   
	JLabel movie_compL = new JLabel();            //setText() 메서드 사용하여
	JLabel payment_compL = new JLabel();          //예약정보마다 다른 정보 출력
	JLabel date_compL = new JLabel(); 
	JLabel time_compL = new JLabel();
	JLabel screen_compL = new JLabel();
	JLabel seat_compL = new JLabel();

	ImageIcon preImg; //포스터 초기 이미지아이콘
	ImageIcon poster; //수정된 포스터 이미지아이콘
	
	int result; //Dialog의 예,아니오 버튼 이벤트를 위한 객체
	
	Font font = new Font("맑은 고딕",Font.BOLD,15); //라벨에 적용시킬 폰트
	BCheckDAO bdao = AppManager.getInstance().getDAOManager().getBcheckDAO();

	public MovieCancelPanel(BookingVO vo) {
		
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
		mainP.setPreferredSize(new Dimension(500, 250));       //패널의 크기 지정
		mainP.setLayout(new FlowLayout(FlowLayout.CENTER,0,5));//패널내부 레이아웃 지정: 플로우 중앙

		questionL.setPreferredSize(new Dimension(500,25));     //라벨 크기 설정(mainP의 가로에 딱맞게)
		announ1L.setPreferredSize(new Dimension(500,25));
		announ2L.setPreferredSize(new Dimension(500,25));

		infoP.setPreferredSize(new Dimension(500,150));         //infoP 크기 및 레이아웃 설정
		infoP.setLayout(new FlowLayout(FlowLayout.LEFT,0,5));

		mainP.add(questionL);   mainP.add(infoP);              //메인패널에 예약취소 라벨 및 패널 추가
		mainP.add(announ1L);    mainP.add(announ2L);

		number_titleL.setPreferredSize(new Dimension(80,25));  //예약 정보 타이틀 라벨 크기지정
		movie_titleL.setPreferredSize(new Dimension(80,30));   
		payment_titleL.setPreferredSize(new Dimension(80,30));
		date_titleL.setPreferredSize(new Dimension(80,30));
		time_titleL.setPreferredSize(new Dimension(80,30));
		screen_titleL.setPreferredSize(new Dimension(80,40));
		seat_titleL.setPreferredSize(new Dimension(80,40));

		number_compL.setPreferredSize(new Dimension(420,25));  //예약 정보 출력 라벨 크기지정
		movie_compL.setPreferredSize(new Dimension(170,30));   
		payment_compL.setPreferredSize(new Dimension(170,30));
		date_compL.setPreferredSize(new Dimension(170,30));
		time_compL.setPreferredSize(new Dimension(170,30));
		screen_compL.setPreferredSize(new Dimension(170,40));
		seat_compL.setPreferredSize(new Dimension(170,40));

		infoP.add(number_titleL); infoP.add(number_compL);      //infoP에 예약 정보 라벨 추가
		infoP.add(movie_titleL);  infoP.add(movie_compL);
		infoP.add(payment_titleL);infoP.add(payment_compL);
		infoP.add(date_titleL);   infoP.add(date_compL);
		infoP.add(time_titleL);   infoP.add(time_compL);
		infoP.add(screen_titleL); infoP.add(screen_compL);
		infoP.add(seat_titleL); infoP.add(seat_compL);

		setComp(vo); //DB정보를 불러와서 라벨에 입력하는 메서드

		questionL.setFont(font);                                   //폰트 설정
		announ1L.setFont(font);       announ2L.setFont(font);
		number_titleL.setFont(font);  number_compL.setFont(font);
		movie_titleL.setFont(font);   movie_compL.setFont(font);
		payment_titleL.setFont(font); payment_compL.setFont(font);
		date_titleL.setFont(font);    date_compL.setFont(font);
		time_titleL.setFont(font);    time_compL.setFont(font);
		screen_titleL.setFont(font);  screen_compL.setFont(font);
		seat_titleL.setFont(font);  seat_compL.setFont(font);

		/*경고창 생성*/
		result = showConfirmDialog(null,mainP,"예매취소",
				JOptionPane.YES_NO_OPTION,PLAIN_MESSAGE,poster);
	}//생성자

	public String setPoster(BookingVO vo) {           //DB 예약정보중 포스터 입력 메서드
		MovieNowVO mn = bdao.getMovieBasicInfo(vo);
		/* 영화예매 DAO 메서드 */
		return "pic/"+mn.getImg();
	}

	public void setComp(BookingVO vo) {               //DB 예약정보 입력하기
		MovieNowVO mn = bdao.getMovieBasicInfo(vo);
		MovietimeVO mt = bdao.getMovietimeInfo(vo);
		List<String> seat = bdao.getMovieSeatNum(vo);
		String[] moviedate = mt.getScreendate().split("-");
		String bcode = vo.getBooking_code()+"";
		String seatN = "";
		
		for(int i=0;i<seat.size();i++) {
			if(i==4) {
				seatN+="<br>";
			}
			seatN+=seat.get(i).substring(2,seat.get(i).length())+" ";
		}
		seatN+="</body></html>";
		
		if(vo.getBooking_code()<10) {
			bcode = "000"+bcode;
		}else if(vo.getBooking_code()<99) {
			bcode = "00"+bcode;
		}else if(vo.getBooking_code()<999) {
			bcode = "0"+bcode;
		}
		
		/* 영화예매 DAO 메서드 */
		number_compL.setText("0120-"+moviedate[1]+moviedate[2]+"-"+bcode);
		movie_compL.setText(mn.getMovie_nameK());
		payment_compL.setText(vo.getPrice()+"원");
		date_compL.setText(moviedate[0]+"년 "+moviedate[1]+"월 "+moviedate[2]+"일");
		time_compL.setText(mt.getScreentime());
		screen_compL.setText(mt.getScreen());
		seat_compL.setText("<html><body>"+seatN);	
	}

}//MovieCancelPanel class
