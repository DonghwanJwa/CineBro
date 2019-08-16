package com.movie.UI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.movie.DAO.MovieNowDAO;
import com.movie.VO.MovieNowVO;
import com.movie.main.AppManager;


public class MoviePage extends JPanel {
	private	JPanel MovieList ;// 가장 상단에 올라가는 패널 

	JScrollPane scroll;			// 영화정보가 많아지면 사용될 스크롤 패널

	//	이미지 만들기	//
	ImageIcon img =new ImageIcon();
	//		폰트 객체 만들기		// 
	Font f1=new Font("함초롱바탕",Font.BOLD,30);
	Font f2=new Font("함초롱바탕",Font.PLAIN,15);//보통글씨로

	MovieNowVO nvo = AppManager.getInstance().getDataManager().getMovieNowVO();
	MovieNowDAO ndao = AppManager.getInstance().getDAOManager().getMovieNowDAO();

	ArrayList<MovieNowVO> nlist = ndao.movieNowList();
	//	 패널 생성	 //
	public MoviePage() {


		MovieList =new JPanel();// 메인 패널

		//		패널 설정		//
		MovieList.setBorder(BorderFactory.createEmptyBorder(60,70,60,80));//패널 공간 여백 만듦
		MovieList.setPreferredSize(new Dimension(1400,860));//크기지정
		MovieList.setBackground(Color.cyan);


		//스크롤바 사용을 위해 증가하는 방식으로 패널 크기지정

		MovieList.setLayout(new BorderLayout());

		/**내부 패널에 작은 패널들 추가**/
		for(int i=0; i<nlist.size(); i++) {
			
			MovieList.add(new MP(i));
			add(MovieList);
//			MovieList.add(contents,BorderLayout.CENTER);
		}


		/**------------------------------DB이후------------------------------------**/
		//				//	스크롤 만들기		//
		//				scroll=new JScrollPane(contents,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
		//						JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		//				//	내부 패널에 스크롤 적용 후 상하스크롤 항상 보이게, 좌우스크롤 항상 숨김
		//				scroll.getVerticalScrollBar().setUnitIncrement(16);
		//				//		내부패널에 스크롤 적용	//
		//				MovieList.add(scroll,BorderLayout.EAST);

	}//생성자


	//	패널 정리할 컴 ㅓ	생성//
	class MP extends JPanel {
		private JPanel MovieP 	=new JPanel();	//영화 포스터와 버튼이 들어갈 패널
		private JPanel MovieLine=new JPanel();	//영화정보를 담을 라벨이 들어간 패널
		private	JButton PosterB; 	//영화의 포스터를넣을 버튼
		
		private JPanel contents ;//	영화정보를 담은 패널들을 전부 출력할 패널
		protected JLabel MovieName;	//영화이름 라벨
		protected JLabel age;		//관람등급이 들어갈 라벨 
		protected JLabel genre;		//장르, 나라, 영화상영시간, 개봉일이 들어갈 패널
		protected JLabel Directer;	//영화감독이 들어갈 라벨
		protected JLabel actor;		//출연하는 배우들이 들어갈 라벨
			MP(int index){

			contents.setLayout(new FlowLayout(FlowLayout.LEFT));

			contents =new JPanel();//포스터 및 영화 정보를 모두 넣을 패널
			contents.setBackground(Color.lightGray);
			contents.setPreferredSize(new Dimension(1200,249*(nlist.size()/2+1/2)));
			//		패널  설정		//
			MovieP.setPreferredSize(new Dimension(190,233));
			MovieLine.setPreferredSize(new Dimension(390,233));

			//	영화정보에 사용될 패널,라벨,버튼(포스터 이미지) 만들기		//
			//		버튼에 넣을 이미지 생성		//
			MovieLine.setLayout(new GridLayout(0,1));
			ImageIcon preImg = new ImageIcon("pic/"+nlist.get(0+index).getImg());//포스터 넣을 이미지 객체 생성(배열 값)
			Image originImg = preImg.getImage();//ImageIcon을 Image로 전환
			Image changeImg = originImg.getScaledInstance(150,220,java.awt.Image.SCALE_SMOOTH);
			//이미지 사이즈 가로130,세로180,이미지를 스무스하게
			ImageIcon poster = new ImageIcon(changeImg);//Image로 ImageIcon 지정

			//			버튼 객체 생성			//
			PosterB = new JButton(poster);//포스터 DB

			//	라벨 객체생성	//
			MovieName = new JLabel(nlist.get(0+index).getMovie_nameK());
			genre= new JLabel("개요: "+nlist.get(0+index).getGenre());
			age= new JLabel("상영시간:"+nlist.get(0+index).getAge());
			Directer= new JLabel("감독: "+nlist.get(0+index).getDirector());
			actor= new JLabel("출연: "+nlist.get(0+index).getActors());

			/*포스터 이미지 아이콘 사이즈 변환*/
			//	폰트 지정		//
			MovieName.setFont(f1);	genre.setFont(f2);	age.setFont(f2);
			Directer.setFont(f2);	actor.setFont(f2);
			// 	버튼 설정	//
			PosterB.setBackground(Color.GRAY);
			PosterB.setFocusPainted(false);//버튼 선택시 테두리 사용(안함)
			PosterB.setBorderPainted(false);//버튼 테두리 사용(안함)
			PosterB.setOpaque(true);//투명도를 (투명하게)

			// 			영화정보 패널에 라벨 넣기		//
			MovieLine.add(MovieName);	
			MovieP.add(genre);
			MovieP.add(age);	MovieP.add(Directer);
			MovieP.add(actor);
			//			정보패널 정렬		//
			MovieP.setLayout(new GridLayout(0,1));
			MovieLine.add(MovieP);
			contents.add(PosterB);
			contents.add(MovieLine);}
			public void setContents(JPanel contents) {
				this.contents = contents;
			}
			public JPanel getContents() {
				return contents;
			}
	}//생성자




}
