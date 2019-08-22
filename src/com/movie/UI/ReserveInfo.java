package com.movie.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.movie.DAO.BCheckDAO;
import com.movie.VO.BookingVO;
import com.movie.VO.MovieNowVO;
import com.movie.VO.MovietimeVO;
import com.movie.main.AppManager;

/** 예매 확인 페이지의 기능을 확인하기 위해서 **/
/** Fake(가짜) VO,DAO 만듦                    **/
/* -------------- MainUi 내부클래스 컴포넌트 --------------- */

//제목(2D,3D,4D,IMAX) 예매번호 : 0000-0000-0000-000
//관람일시 년월일시분, 상영관 몇관
//관람 극장(장소)(극장정보버튼), 관람 좌석번호 몇열 몇번
//결제 날짜 년월일, 매수 몇매 
//맨 아래 오른쪽에 예매취소버튼
public class ReserveInfo extends JPanel implements ActionListener{
	private List<MovieUi> reserveP;

	/* 패널 생성 */
	private JPanel mainP = new JPanel();
	protected JPanel movieP = new JPanel();
	protected JPanel movieBackgroundP = new JPanel();
	private JLabel titleL;

	Font labelFont = new Font("맑은 고딕",Font.BOLD,30);
	JScrollPane scroll;
	
	BCheckDAO bdao = AppManager.getInstance().getDAOManager().getBcheckDAO();
	MainUI mu;
	List<BookingVO> rlist; 
	
	public ReserveInfo() {
		setOpaque(false);
	}//생성자

	public Component setTitleL() {
		titleL = new JLabel("예매정보조회");
		titleL.setForeground(Color.WHITE);
		titleL.setFont(labelFont);
		return titleL;
	}//setTitleL() : 타이틀 라벨 생성 메서드

	public Component setMovieP() {
		mu = AppManager.getInstance().getMainUi();
		rlist = bdao.getBookingCode(mu.myPageC.idCL.getText());
		reserveP = new ArrayList<MovieUi>();
		movieP.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
		movieP.setOpaque(false);
		for(int i=0;i<rlist.size();i++) {
			reserveP.add(i,new MovieUi(rlist.get(i)));
			movieP.add(reserveP.get(i));
			reserveP.get(i).setOpaque(false);
			reserveP.get(i).addReserveCheckListner(this);	//각 예약의 취소버튼 이벤트를 ReserveInfo 이벤트 리스너에 등록
		}//for
		movieP.setPreferredSize(new Dimension(1100,320*reserveP.size()));
		// panel_m 패널 하나의 높이가 220, 나중에 예약 하나당 220씩 증가하는식으로 수정해야함->스크롤바 때문

		return movieP;
	}//setMovieP각각의 예매정보 패널 

	public void setMainP() {
		/* 메인패널 설정 */
		mainP.setOpaque(false);
		mainP.setPreferredSize(new Dimension(1400,810));		
		mainP.setBorder(BorderFactory.createEmptyBorder(0,40,80,260));//메인패널 패딩
		mainP.setLayout(new BorderLayout());
		mainP.add(setTitleL(),BorderLayout.NORTH);
		movieBackgroundP.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
		movieBackgroundP.setOpaque(false);
		movieBackgroundP.add(setMovieP());
		/* 스크롤 만들기 */
		scroll=new JScrollPane(movieBackgroundP,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);   // 내부 패널에 스크롤 적용 후 상하스크롤 항상 보이게, 좌우스크롤 항상 숨김		
		scroll.getVerticalScrollBar().setUnitIncrement(16);// 스크롤 속도 지정
		scroll.getViewport().setBackground(Color.BLACK);
		scroll.setBorder(BorderFactory.createEmptyBorder());

		/* 스크롤패널 추가 */
		mainP.add(scroll,BorderLayout.CENTER); // 메인패널에 스크롤패널 추가

		add(mainP);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i=0;i<rlist.size();i++) {
			if(e.getSource()==reserveP.get(i).cancleB) {
				MovieCancelPanel mcpanel = new MovieCancelPanel(rlist.get(i));
				if(mcpanel.result==JOptionPane.CLOSED_OPTION) {
					return;
				}else if(mcpanel.result==JOptionPane.NO_OPTION) {
					return;
				}else if(mcpanel.result==JOptionPane.YES_OPTION) {
					/**이부분 수정들어가야됨**/
					bdao.cancelReserveBookedseat(rlist.get(i).getBooking_code());
					bdao.cancelReserveBooking(rlist.get(i).getBooking_code());
					movieP.removeAll();
					movieBackgroundP.add(setMovieP());
					movieBackgroundP.revalidate();
					movieBackgroundP.repaint();
				}
			}//if
		}//for
	}//aP();
}//MovieReservationCheckPanel class

/* 예약정보패널 클래스 */
class MovieUi extends JPanel{
	JPanel panel_m = new JPanel();
	JPanel posterP = new JPanel();
	JPanel infoP = new JPanel();
	JPanel cancleP = new JPanel();

	/* 라벨 생성 */
	JLabel posterName=new JLabel();			//포스터명
	JLabel posterL=new JLabel();			//포스터를 올릴 라벨
	JLabel movieNameL=new JLabel();				//영화명
	JLabel reserveNumL=new JLabel();			//예약번호
	JLabel dateL=new JLabel();				//상영날짜
	JLabel timeL=new JLabel();				//상영시간
	JLabel screenL=new JLabel();				//상영관
	JLabel priceL=new JLabel();				//금액
	JLabel seatL=new JLabel();				//좌석번호

	/* 폰트 객체생성&폰트만드는 곳 */
	Font titleFont = new Font("맑은 고딕",Font.BOLD,30);
	Font subLabelFont = new Font("맑은 고딕",Font.BOLD,20);

	JButton cancleB = new JButton("예매취소");
	BCheckDAO bdao = AppManager.getInstance().getDAOManager().getBcheckDAO();
	
	public MovieUi(BookingVO vo) {
		setOpaque(false);
		add(setReservePanel(vo));
	}//생성자

	public Component setReservePanel(BookingVO vo) {
		/* 메인패널 */
		panel_m.setOpaque(false);
		panel_m.setLayout(new FlowLayout());

		/* 메인패널에 포스터패널이랑 인포패널추가 */
		panel_m.add(setPoster(vo));
		panel_m.add(setInfo(vo));

		return panel_m;
	}

	public Component setPoster(BookingVO vo){
		MovieNowVO mn = bdao.getMovieBasicInfo(vo);
		/* 포스터 이미지 아이콘 사이즈 변환 */
		ImageIcon preImg = new ImageIcon("pic/"+mn.getImg());//포스터 넣는란
		Image originImg = preImg.getImage();//ImageIcon을 Image로 전환
		Image changeImg = originImg.getScaledInstance(210,300,java.awt.Image.SCALE_SMOOTH);
		// 이미지 사이즈 가로210,세로300,이미지를 스무스하게
		ImageIcon poster = new ImageIcon(changeImg);

		/* 라벨 객체 생성*/
		posterL.setIcon(poster);

		/* 포스터패널 */
		posterP.setBackground(Color.white);
		posterP.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
		posterP.setPreferredSize(new Dimension(210,300));

		/* 포스터 라벨 이것저것들 */
		posterL.setBackground(Color.white);
		posterP.add(posterL);

		return posterP;
	}//setPoster()

	public Component setInfo(BookingVO vo) {
		MovieNowVO mn = bdao.getMovieBasicInfo(vo);
		MovietimeVO mt = bdao.getMovietimeInfo(vo);
		String[] seatNC = bdao.getMovieSeatNum(vo).split("관");
		String seatNum = seatNC[1];
		String[] moviedate = mt.getScreendate().split("-");
		String bcode = vo.getBooking_code()+"";
		
		if(vo.getBooking_code()<10) {
			bcode = "000"+bcode;
		}else if(vo.getBooking_code()<99) {
			bcode = "00"+bcode;
		}else if(vo.getBooking_code()<999) {
			bcode = "0"+bcode;
		}
		
		/* 라벨 객체생성 */
		movieNameL.setText(mn.getMovie_nameK());
		reserveNumL.setText("0120-"+moviedate[1]+moviedate[2]+"-"+bcode);
		dateL.setText("상영일    : "+moviedate[0]+"년 "+moviedate[1]+"월 "+moviedate[2]+"일");
		timeL.setText("상영시간 : "+mt.getScreentime());
		screenL.setText("상영관    :"+mt.getScreen());
		priceL.setText("결제금액 :"+vo.getPrice()+"원");
		seatL.setText("좌석번호 :"+seatNum);

		/* 버튼 설정*/
		cancleB.setPreferredSize(new Dimension(90,30));
		cancleB.setFont(new Font("맑은 고딕",Font.BOLD,13));
		cancleB.setBackground(Color.RED);
		cancleB.setBorderPainted(false);
		cancleB.setFocusPainted(false);


		/* 인포(설명)패널 */
		infoP.setLayout(new GridLayout(4,1));
		infoP.setBackground(Color.white);
		infoP.setPreferredSize(new Dimension(800,300));
		infoP.setBorder(BorderFactory.createEmptyBorder(5,20,5,20));
		cancleP.setLayout(new FlowLayout(FlowLayout.RIGHT,80,20));
		cancleP.setBackground(Color.white);
		cancleP.add(cancleB);

		/* 라벨폰트 지정 */
		movieNameL.setFont(titleFont);        	 reserveNumL.setFont(subLabelFont);
		dateL.setFont(subLabelFont);         timeL.setFont(subLabelFont);
		screenL.setFont(subLabelFont); 		 seatL.setFont(subLabelFont);
		priceL.setFont(subLabelFont);  	

		/* 라벨을 인포패널에 추가 */
		infoP.add(movieNameL);
		infoP.add(reserveNumL);
		infoP.add(dateL);
		infoP.add(timeL); 
		infoP.add(screenL); 
		infoP.add(priceL);
		infoP.add(seatL);
		infoP.add(cancleP);

		return infoP;       
	}

	public void addReserveCheckListner(ActionListener listener) {
		cancleB.addActionListener(listener);     //취소버튼 이벤트처리
	}//addFindListener()

}//MovieUi class