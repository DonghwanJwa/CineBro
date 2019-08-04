package com.movie.UI;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MovieCancelPanel extends JOptionPane{
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
	public MovieCancelPanel() {
		/*포스터 이미지 아이콘 사이즈 변환*/
		ImageIcon preImg = new ImageIcon("lionking.jpg");//포스터 넣는란
		Image originImg = preImg.getImage();//ImageIcon을 Image로 전환
		Image changeImg = originImg.getScaledInstance(150,200,java.awt.Image.SCALE_SMOOTH);
		//이미지 사이즈 가로120,세로160,이미지를 스무스하게
		ImageIcon poster = new ImageIcon(changeImg);
		//Image로 ImageIcon 지정

		/*라벨에 적용시킬 폰트*/
		Font font = new Font("맑은 고딕",Font.BOLD,15);

		/*예매 문구 넣기*/
		JPanel panel = new JPanel();//예매문구(라벨)를 넣을 패널생성
		panel.setPreferredSize(new Dimension(400, 150));//패널의 크기 지정
		panel.setLayout(new GridLayout(5,1));//패널내부 레이아웃 지정: 5행1열
		JLabel anoun1 = new JLabel("예매를 취소하시겠습니까?");               //예매취소 확인창 문구들 만듦.
		JLabel anoun2 = new JLabel("영화명:            "+"금액:   ");    //라벨 내부에선 \n이 적용안되므로
		JLabel anoun3 = new JLabel("날짜:  "+"시간:  "+"관:  "+"인원:  ");//줄바꿈을 위해선 라벨을 각각 넣어줘야됨
		JLabel anoun4 = new JLabel("※ 인터넷 예매 취소는 상영시간 20분 전까지 가능하며,");
		JLabel anoun5 = new JLabel("예매 가능은 상영시간 30분 전까지 가능합니다.");

		anoun1.setFont(font); anoun2.setFont(font);//폰트 지정
		anoun3.setFont(font); anoun4.setFont(font);
		anoun5.setFont(font);

		panel.add(anoun1);	panel.add(anoun2);//패널에 문구 넣기
		panel.add(anoun3);	panel.add(anoun4);
		panel.add(anoun5);

		/*경고창 생성*/
		showConfirmDialog(null,panel,"예매취소",
				JOptionPane.YES_NO_OPTION,PLAIN_MESSAGE,poster);
		//showConfirmDialog(메시지창 다이얼로그가 어떤 Frame에서 나타나게 될 것인지를 정해주는 변수,출력할 메세지(Object),
		//메시지창 제목(String),버튼옵션 종류,메세지 경고스티커 종류,메시지창 좌측에 넣을 이미지(경고이미지였으나 포스터로 바꿈));
	}//생성자

	public static void main(String[] args) {
		new MovieCancelPanel();
	}//main() 나중에 지워야됨!!

}
