package com.movie.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import com.movie.DAO.DAOMovie;
import com.movie.frame.MainFrame;

/**주의!! 마지막에 main()메서드 없앨것!!!**/
/**상영작 정보 패널**/
/*영화 포스터와 간단한 정보 리스트로 출력되게 만들것*/
/* 1. 포스터,정보패널을 묶는 작은패널 하나만 만들자(내부클래스처리)
 * 2. 내부패널을 FlowLayout 처리(영화갯수 증가시 형태가 깨지지 않고 쌓일수 있도록)
 * 3. 영화정보가 추가될 때마다 작은패널이 증가하는 형태로 만들자.
 */
/* 하다보니 알게된 정보들
 * 1. 보더레이아웃은 setPreferredSize로 내부 패널의 크기를 보존하여 
 *    위치를 지정시킬 수 있다.
 * 2. 그리드 레이아웃은 무슨짓을해도 크기를 균등히 맞춰버린다.
 * 3. 스크롤바는 생성시에 기준이될 패널을 입력해야하고,
 *    add를 통해서 패널 혹은 프레임에 올려주면 된다.
 *    주의! 스크롤은 지정된 패널(innerPanel)의 크기를 자동으로 인식해서 바의 길이를 생성한다.
 *		     따라서 지정된 패널을 고정된 크기로 지정한다면, 담아야 하는 내용물(컴포넌트)이 패널보다 큰 경우에도
 *         스크롤이 늘어나지 않는다.
 * 4. FlowLayout.LEFT 혹은 .RIGHT로 왼쪽정렬, 오른쪽정렬 조정가능
 */

public class CurrentMoviePanel extends JPanel {
	JPanel innerPanel;
	JScrollPane scroll;
	Font font1,font2;
	DAOMovie daoMovie = new DAOMovie();//영화정보 DB

	public CurrentMoviePanel() {
		/**폰트**/
		font1 = new Font("맑은 고딕",Font.PLAIN,15);
		font2 = new Font("맑은 고딕",Font.BOLD,30);

		/** 메인 패널 설정**/
		setPreferredSize(new Dimension(1400, 860));//메인패널 크기 지정
		setBackground(Color.BLACK);//메인패널 색 지정
		setBorder(BorderFactory.createEmptyBorder(50,90,80,90));//메인패널 패딩(상 50 하 80 밀어넣고,좌우 90밀어넣음)
		//내부크기 (1200,700)이 되었음 ->넘어가면 내부에 들어가는 컴포넌트들 잘림
		setLayout(new BorderLayout());//보더 레이아웃 지정

		/** 메인 패널 내부에 패널 넣기(정렬용) **/
		innerPanel = new JPanel();//내부 패널 생성
		innerPanel.setBackground(Color.DARK_GRAY);//내부패널 배경색 지정
		innerPanel.setPreferredSize(new Dimension(1200,249*(daoMovie.getMovie().length/2+1/2)));
		//내부 패널 사이즈(높이)는 상영되는 영화수에 비례해서 증가해야 하므로 다음과 같이 지정했음
		innerPanel.setLayout(new FlowLayout(FlowLayout.LEFT));//FlowLayout 왼쪽정렬 지정

		/**내부 패널에 작은 패널들 추가**/
		for(int i=0;i<daoMovie.getMovie().length;i++) {
			innerPanel.add(new PosterInfoPanel(i));
		}

		/**메인패널에 내부 패널 추가**/
		add(innerPanel,BorderLayout.CENTER);//메인패널에 내부패널 추가

		/**스크롤 만들기 : 상영하는 영화의 갯수가 충분하지 않으면 스크롤바 생성안됨**/
		if(daoMovie.getMovie().length>5) {
			scroll=new JScrollPane(innerPanel,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
					JScrollPane.HORIZONTAL_SCROLLBAR_NEVER); 
			// 내부 패널에 스크롤 적용 후 상하스크롤 항상 보이게, 좌우스크롤 항상 숨김

			/**스크롤 추가**/
			add(scroll,BorderLayout.EAST); // 메인패널에 스크롤 추가
		}

	}//CurrentMoviePanel 생성자

	/**영화 포스터와 정보패널을 넣을 작은패널 생성 내부클래스**/
	class PosterInfoPanel extends JPanel{
		JPanel posterPanel,infoPanel,infoMiniPanel;
		JButton posterButton;
		JLabel nameLabel,genreLabel,timeLabel,direcLabel,actLabel;
		/* 정보 : 포스터 가로세로 비율 (1:1.43)*/

		public PosterInfoPanel(int index) {			

			/** 포스터,정보 패널 **/
			posterPanel = new JPanel();//패널 객체 생성
			infoPanel = new JPanel();

			posterPanel.setPreferredSize(new Dimension(190,233));//패널 크기 지정
			infoPanel.setPreferredSize(new Dimension(390,233));

			posterPanel.setBackground(Color.LIGHT_GRAY);//패널 배경색 지정
			infoPanel.setBackground(Color.LIGHT_GRAY);

			infoPanel.setLayout(new GridLayout(0,1));

			/**포스터 버튼 만들기 & 포스터 패널에 넣기**/
			/*포스터 이미지 아이콘 사이즈 변환*/
			ImageIcon preImg = new ImageIcon(daoMovie.getMovie()[index][1]);//포스터 넣는란
			Image originImg = preImg.getImage();//ImageIcon을 Image로 전환
			Image changeImg = originImg.getScaledInstance(150,214,java.awt.Image.SCALE_SMOOTH);
			//이미지 사이즈 가로150,세로214,이미지를 스무스하게
			ImageIcon poster = new ImageIcon(changeImg);
			//Image로 ImageIcon 지정

			posterButton = new JButton(poster);//포스터DB

			posterButton.setBackground(Color.LIGHT_GRAY);//버튼 배경색 지정(버튼패널색과 같게)
			posterButton.setFocusPainted(false);//버튼 선택시 테두리 사용(안함)
			posterButton.setBorderPainted(false);//버튼 테두리 사용(안함)
			posterButton.setOpaque(false);//투명도를 (투명하게)
			posterPanel.add(posterButton);//버튼 패널에 버튼 추가

			/**정보 라벨 만들기 & 정보 패널에 정보 라벨들 넣기**/
			/*라벨 객체 생성*/
			nameLabel = new JLabel(daoMovie.getMovie()[index][0]);//제목DB
			genreLabel = new JLabel("개요: "+daoMovie.getMovie()[index][2]);//장르(개요)DB
			timeLabel = new JLabel(daoMovie.getMovie()[index][3]);//러닝타임DB
			direcLabel = new JLabel("감독: "+daoMovie.getMovie()[index][4]);//감독DB
			actLabel = new JLabel("출연: "+daoMovie.getMovie()[index][5]);//출연DB

			/*폰트 지정*/
			nameLabel.setFont(font2); genreLabel.setFont(font1);
			timeLabel.setFont(font1); direcLabel.setFont(font1);
			actLabel.setFont(font1);

			/*장르와 러닝타임을 같은줄에 넣기 위해 패널 하나 추가*/
			infoMiniPanel = new JPanel();
			infoMiniPanel.setBackground(Color.LIGHT_GRAY);
			infoMiniPanel.setLayout(new GridLayout(1,2));
			infoMiniPanel.add(direcLabel); infoMiniPanel.add(timeLabel);

			/*정보 패널에 정보 라벨들 넣기*/
			infoPanel.add(nameLabel); infoPanel.add(infoMiniPanel);
			infoPanel.add(genreLabel); infoPanel.add(actLabel);

			add(posterPanel); add(infoPanel);
		}

	}//posterInfoPanel class
}//CurrentMoviePanel class
