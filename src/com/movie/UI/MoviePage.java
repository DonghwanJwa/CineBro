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
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.movie.DAO.MovieNowDAO;
import com.movie.VO.MovieNowVO;
import com.movie.main.AppManager;


public class MoviePage extends JPanel implements ActionListener{
	MovieNowVO nvo = AppManager.getInstance().getDataManager().getMovieNowVO();
	MovieNowDAO ndao = AppManager.getInstance().getDAOManager().getMovieNowDAO();
	List<MovieNowVO> nlist = ndao.movieNowList();

	private	JPanel movieList;	// 가장 상단에 올라가는 패널 
	private JPanel contents;	//	영화정보를 담은 패널들을 전부 출력할 패널
	private JPanel movieP	;	//영화 포스터와 버튼이 들어갈 패널
	private JPanel movieLine;	//영화정보를 담을 라벨이 들어간 패널
	private	JButton[] posterB=new JButton[nlist.size()];	//영화의 포스터를넣을 버튼

	JScrollPane scroll;			// 영화정보가 많아지면 사용될 스크롤 패널

	protected JLabel movieName;	//영화이름 라벨
	protected JLabel age;		//관람등급이 들어갈 라벨 
	protected JLabel genre;		//장르, 나라, 영화상영시간, 개봉일이 들어갈 패널
	protected JLabel director;	//영화감독이 들어갈 라벨
	protected JLabel actor;		//출연하는 배우들이 들어갈 라벨

	//	이미지 만들기	//
	ImageIcon img =new ImageIcon();
	//		폰트 객체 만들기		// 
	Font f1=new Font("맑은 고딕",Font.BOLD,40);
	Font f2=new Font("함초롱바탕",Font.PLAIN,15);//보통글씨로

	//	 패널 생성	 //
	public MoviePage() {

		setOpaque(false);
		posterB =new JButton[nlist.size()]; 
		contents =new JPanel();// 메인 패널 

		//		패널 설정		//
		setBorder(BorderFactory.createEmptyBorder(60,70,60,80));//	패널 공간 여백 만듦
		setPreferredSize(new Dimension(1550,860));//	크기지정
		contents.setBackground(Color.DARK_GRAY);// 패널 색 지정
//		setOpaque(false);	//패널을 투명하게

		//	스크롤바 사용을 위해 증가하는 방식으로 패널 크기지정	//
		contents.setPreferredSize(new Dimension(1400,270*(nlist.size()/2+1/2)));
		//		패널 정렬		//
		setLayout(new BorderLayout());
		contents.setLayout(new FlowLayout(FlowLayout.LEFT));
		/**내부 패널에 작은 패널들 추가**/
		for(int i=0; i<nlist.size(); i++) {
			add(MP(i));
		}
		add(contents,BorderLayout.CENTER);

		/**------------------------------DB이후------------------------------------**/
		//	스크롤 만들기		//
		scroll=new JScrollPane(contents,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		//	내부 패널에 스크롤 적용 후 상하스크롤 항상 보이게, 좌우스크롤 항상 숨김
		scroll.getVerticalScrollBar().setUnitIncrement(16);

		//		내부패널에 스크롤 적용	//
		add(scroll,BorderLayout.EAST);

	}//생성자

	//	패널 정리할 메서드	생성//
	public Component MP (int index) {

		movieP =new JPanel();	//	영화 포스터 버튼을 넣을 패널
		movieLine =new JPanel();//	영화정보를 넣을 패널
		movieList =new JPanel();//	위 두개의 정보가 모두 들어가는 패널
		//		패널  크기 설정		//
		movieP.setPreferredSize(new Dimension(270,255));
		movieLine.setPreferredSize(new Dimension(470,255));
		movieList.setPreferredSize(new Dimension(670,260));
		// 		패널 배경 색 지정		//
		movieP.setBackground(Color.BLACK);
		movieLine.setBackground(Color.BLACK);
		movieList.setBackground(Color.BLACK);

		//	영화정보에 사용될 패널,라벨,버튼(포스터 이미지) 만들기		//
		//		버튼에 넣을 이미지 생성		//
		ImageIcon preImg = new ImageIcon("pic/"+nlist.get(index).getImg());//포스터 넣을 이미지 객체 생성(배열 값)
		Image originImg = preImg.getImage();//ImageIcon을 Image로 전환
		Image changeImg = originImg.getScaledInstance(155,240,java.awt.Image.SCALE_SMOOTH);
		//이미지 사이즈 가로130,세로180,이미지를 스무스하게
		ImageIcon poster = new ImageIcon(changeImg);//Image로 ImageIcon 지정
		//			버튼 객체 생성			//
		posterB[index] = new JButton(poster);//포스터 DB
		//			라벨 객체생성			//
		movieName = new JLabel(nlist.get(index).getMovie_nameK());
		genre= new JLabel("개요: "+nlist.get(index).getGenre());
		age= new JLabel("상영시간:"+nlist.get(index).getAge());
		director= new JLabel("감독: "+nlist.get(index).getDirector());
		actor= new JLabel("출연: "+nlist.get(index).getActors());

		/*포스터 이미지 아이콘 사이즈 변환*/
		//		폰트 지정		//
		movieName.setFont(f1);	genre.setFont(f2);	age.setFont(f2);
		director.setFont(f2);	actor.setFont(f2);
		// 		글자 색 지정		//
		movieName.setForeground(Color.white);	genre.setForeground(Color.white);	
		age.setForeground(Color.white);		director.setForeground(Color.white);	
		actor.setForeground(Color.white);
		// 		버튼 설정		//
		posterB[index].setBackground(Color.black);
		posterB[index].setFocusPainted(false);//버튼 선택시 테두리 사용(안함)
		posterB[index].setBorderPainted(false);//버튼 테두리 사용(안함)
		posterB[index].setOpaque(true);//투명도를 (투명하게)
		posterB[index].addActionListener(this);// 버튼에 액션 추가

		// 			영화정보 패널에 라벨 넣기		//
		movieLine.add(movieName);	
		movieP.add(genre);
		movieP.add(age);	movieP.add(director);
		movieP.add(actor);
		movieLine.add(movieP);
		//			정보패널 정렬		//
		movieLine.setLayout(new GridLayout(0,1));
		movieP.setLayout(new GridLayout(0,1));
		//		패널 넣기		//
		movieList.add(posterB[index]);
		movieList.add(movieLine);

		contents.add(movieList);

		return contents;//contents 패널에 리턴
	}//MP()메서드
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj =e.getSource();
		for(int i=0; i<nlist.size(); i++) {
			if(obj==posterB[i]) {
				new MovieInfoPlus(i+1);
			}//if
		}//for
	}//ap() => 버튼 눌렀을 때 생성
}//moviePage class

