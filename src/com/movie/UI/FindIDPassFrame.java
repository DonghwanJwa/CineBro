package com.movie.UI;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

/**아이디/비밀번호 찾기 Frame**/
/* 아이디패널 클래스, 비밀번호 찾기 패널 클래스 따로 생성
 * 각 패널은 각각의 버튼에 따라 보여지게 된다.(CardLayout(?))
 */
public class FindIDPassFrame extends JFrame implements ActionListener{
	JPanel mainP = new JPanel();                 //배경이 되는 패널
	JPanel buttonbarP = new JPanel();            //버튼이 올라갈 패널(상단)
	JPanel card_backgroundP = new JPanel();      //주요 패널들을 카드패널로 올릴 패널
	JPanel idFindP = new JPanel();               //아이디 찾기 화면 패널
	JPanel passFindP = new JPanel();             //비밀번호 찾기 화면 패널
	JPanel first_idP = new JPanel();             //아이디 찾기 정보 입력 패널(입력:성함,이메일)
	JPanel second_idP = new JPanel();            //아이디 찾기 정보 출력 패널(출력:아이디)
	JPanel first_passP = new JPanel();           //비밀번호 찾기 정보 입력 패널(입력:아이디,성함,이메일)
	JPanel second_passP = new JPanel();          //비밀번호 찾기 정보 수정 패널(수정:비밀번호)

	JButton idFindB = new JButton("아이디 찾기");    //아이디 찾기,비밀번호 찾기 패널 전환버튼
	JButton passFindB = new JButton("비밀번호 찾기");
	JButton id_confirmB = new JButton("확인");    //아이디 찾기 정보입력 후 확인 버튼 
	JButton back_closeB = new JButton("돌아가기");  //찾기 완료 후 돌아가기 버튼(해당 프레임 종료)

	JTextField nameTF = new JTextField();       //이름 입력 텍스트필드
	JTextField emailTF = new JTextField();      //이메일 입력 텍스트필드

	JLabel emptyL = new JLabel(" ");             //아이디 찾기,비밀번호 찾기 버튼 사이 공백만드는 라벨
	JLabel name_titleL = new JLabel("성함");       //이름 타이틀 라벨
	JLabel email_titleL = new JLabel("이메일주소");  //이메일 타이틀 라벨
	JLabel id_errorL = new JLabel();              //id찾기 경고문 출력 라벨 setText()로 문구 변경 및 setForeground()로 색바꿔 사용
	JLabel pass_errorL = new JLabel("입력된 정보가 올바르지 않습니다.");//pass찾기 경고문 출력 라벨 setForeground()로 색바꿔 사용
	JLabel show_nameL = new JLabel();            //~님의 아이디는          출력라벨
	JLabel show_idL = new JLabel();              //"아이디명" 입니다. 출력라벨

	CardLayout cardlayout = new CardLayout(0,0); //카드레이아웃
	Font font = new Font("맑은 고딕",Font.BOLD,15); //컴포넌트에 적용시킬 폰트
	Font warnF = new Font("맑은 고딕",Font.PLAIN,10);

	public FindIDPassFrame() {
		setTitle("아이디/비밀번호 찾기");
		setSize(new Dimension(600,527));//높이 : 500(화면)+27(틀과 상태창)
		setResizable(false);
		setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		/*배경이 되는 패널*/
		mainP.setPreferredSize(new Dimension(600,500));
		mainP.setBackground(Color.WHITE);
		mainP.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
		mainP.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		add(mainP);

		/*버튼을 올릴 패널*/
		buttonbarP.setPreferredSize(new Dimension(580,30));
		buttonbarP.setBackground(Color.WHITE);
		buttonbarP.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
		mainP.add(buttonbarP);

		/*버튼 설정 및 버튼패널에 올리기*/
		idFindB.setPreferredSize(new Dimension(120,30));  //사이즈 지정
		passFindB.setPreferredSize(new Dimension(120,30));

		idFindB.setFont(font);                           //폰트 지정
		passFindB.setFont(font);

		idFindB.setBorder(new LineBorder(Color.red,3));  //테두리색 지정
		passFindB.setBorder(new LineBorder(Color.red,3));

		idFindB.setBackground(Color.RED);                //배경색 지정
		passFindB.setBackground(Color.WHITE);

		idFindB.setFocusPainted(false);                  //버튼 포커스 해제
		passFindB.setFocusPainted(false);

		idFindB.addActionListener(this);                 //이벤트 추가
		passFindB.addActionListener(this);

		buttonbarP.add(idFindB);                         //버튼패널에 버튼 추가
		buttonbarP.add(emptyL);
		buttonbarP.add(passFindB);

		/*중앙에 올릴 카드패널*/
		card_backgroundP.setPreferredSize(new Dimension(580,450));
		card_backgroundP.setLayout(cardlayout);
		mainP.add(card_backgroundP);

		setIDFindPanel();  //아이디찾기 패널, 비밀번호 찾기 패널 추가
		setPassFindPanel();

		setVisible(true);
	}//생성자

	public void setIDFindPanel() {
		/*아이디 찾기 패널(카드패널 위의 카드패널)*/
		idFindP.setPreferredSize(new Dimension(580,450));
		card_backgroundP.add(idFindP,"idFindB");
		idFindP.setLayout(cardlayout);

		/*아이디 찾기 정보 입력 패널*/
		first_idP.setPreferredSize(new Dimension(580,450));
		first_idP.setBackground(Color.WHITE);
		first_idP.setLayout(new FlowLayout(FlowLayout.CENTER,0,5));
		first_idP.setBorder(new CompoundBorder(
				BorderFactory.createLineBorder(Color.LIGHT_GRAY,1),
				BorderFactory.createEmptyBorder(95,115,100,115))
				);


		name_titleL.setFont(font);   //라벨 폰트 설정
		email_titleL.setFont(font);
		id_errorL.setFont(warnF);
		nameTF.setFont(font);        //텍스트 필드 폰트 설정
		emailTF.setFont(font);
		id_confirmB.setFont(font);   //버튼 폰트 설정
		
		id_errorL.setForeground(Color.RED);                    //경고문 글자색 빨간색 지정
		
		id_confirmB.addActionListener(this);                   //확인버튼 이벤트 추가
		
		name_titleL.setPreferredSize(new Dimension(350,40));   //컴포넌트 사이즈 지정
		email_titleL.setPreferredSize(new Dimension(350,40));
		id_errorL.setPreferredSize(new Dimension(350,20));
		nameTF.setPreferredSize(new Dimension(350,40));
		emailTF.setPreferredSize(new Dimension(350,40));
		id_confirmB.setPreferredSize(new Dimension(100,40));	
		
		nameTF.setBorder(new LineBorder(Color.BLACK));         //텍스트 필드 테두리
		emailTF.setBorder(new LineBorder(Color.BLACK));
		
		first_idP.add(name_titleL);                            //아이디 찾기 정보입력 창에 컴포넌트 추가
		first_idP.add(nameTF);
		first_idP.add(email_titleL);
		first_idP.add(emailTF);
		first_idP.add(id_errorL);
		first_idP.add(id_confirmB);

		/*아이디 찾기 정보 출력 패널*/
		second_idP.setPreferredSize(new Dimension(580,450));
		second_idP.setBackground(Color.WHITE);
		second_idP.setLayout(new FlowLayout(FlowLayout.CENTER,0,10));
		second_idP.setBorder(new CompoundBorder(
				BorderFactory.createLineBorder(Color.LIGHT_GRAY,1),
				BorderFactory.createEmptyBorder(140,115,150,115))
				);
		
		show_nameL.setFont(font);                 			 //컴포넌트 폰트 지정
		show_idL.setFont(font);
		back_closeB.setFont(font);
		
		show_nameL.setHorizontalAlignment(JLabel.CENTER);    //라벨 중앙정렬
		show_idL.setHorizontalAlignment(JLabel.CENTER);
		
		
		back_closeB.addActionListener(this);                 //버튼 이벤트 등록
		
		show_nameL.setPreferredSize(new Dimension(350,40));  //컴포넌트 크기지정
		show_idL.setPreferredSize(new Dimension(350,40));
		back_closeB.setPreferredSize(new Dimension(100,40));
		
		second_idP.add(show_nameL);							 //아이디 찾기 정보출력 창에 컴포넌트 추가
		second_idP.add(show_idL);
		second_idP.add(back_closeB);

		idFindP.add(first_idP);
		idFindP.add(second_idP,"id_confirmB");
		
	}//setIDFind()

	/**비밀번호 찾기 패널 만들어야됨**/
	public void setPassFindPanel() {
		/*비밀번호 찾기 패널(카드패널 위의 카드패널)*/
		passFindP.setPreferredSize(new Dimension(580,450));
		card_backgroundP.add(passFindP,"passFindB");
		passFindP.setLayout(cardlayout);
		
	}//setPassFind()


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==idFindB) {
			idFindB.setBackground(Color.RED);            //상단의 버튼 색 변경
			passFindB.setBackground(Color.WHITE);			
			nameTF.setText("");					         //텍스트필드 비움
			emailTF.setText("");					
			cardlayout.show(card_backgroundP,"idFindB"); //아이디찾기 버튼 클릭 시 아이디 찾기 패널로 전환
		}
		if(e.getSource()==passFindB) {
			idFindB.setBackground(Color.WHITE);          //상단의 버튼 색 변경
			passFindB.setBackground(Color.RED);
			cardlayout.show(card_backgroundP,"passFindB");//비밀번호 찾기 버튼 클릭 시 비밀번호 찾기 패널로 전환
		}
		if(e.getSource()==id_confirmB) {
			/**아이디 찾기 중 : 입력된 아이디,이메일과 DB의 아이디,이메일 같은지 비교하여, 같으면 페이지 넘어가기 활성**/
			/**            이후, DB에서 지정된 ID값을 가져와 라벨에 출력**/
			if((nameTF.getText().trim().equals("")) || (emailTF.getText().trim().equals(""))) {
				id_errorL.setText("정보가 입력되지 않았습니다.");
			}else {
//			else if(nameTF.getText==VO데이터){
			id_errorL.setText("");
			show_nameL.setText("이름 DB에서 가져온 님 의 아이디는");
			show_idL.setText("\"아이디 DB에서 가저옴\" 입니다");
			cardlayout.show(idFindP,"id_confirmB");
			}
//			}else {
//			id_errorL.setText("일치하는 정보의 아이디가 없습니다.");
//			id_errorL.setForeground(Color.RED);
//			}
		}
		if(e.getSource()==back_closeB) {
			dispose();
		}
	}//ap()

	public static void main(String[] args) {
		new FindIDPassFrame();
	}//main() 나중에 지워야됨!!

}
