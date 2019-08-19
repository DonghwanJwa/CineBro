package com.movie.DAO;

import java.awt.Font;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
/* 사용전!
 * LIB 폴터에 추가되어있는 mail-1.4.7 jar를 연결 시킨 후 구동해야됨
 * 프로젝트폴더 우측버튼 클릭 -> properties -> java build path
 * -> (상단)Libraries ->(우측)add external jars -> 해당 LIB 폴더안에 파일 선택
 * -> Apply and close
 */
public class AuthMail {

	public String randomAuthNum() {		//인증번호생성
		String security="";
		for(int i=0;i<6;i++){
			char p01=(char)(Math.random()*26+97);
			if(i%2==0){
				security+=(int)(Math.random()*10);
			}else{
				security+=p01;
			}//if
		}//for	      
		return security;
	}//randomAuthNum()

	public void Auth_Email(String email,String security){	//인증번호 보내기
		String id = "cine190823@gmail.com";
		String pw = "swing190823!";
		
		//STMP 서버 정보를 설정
		Properties p = System.getProperties();
		p.put("mail.smtp.host", "smtp.gmail.com"); //"mail.smtp.host" : 이메일 발송을 처리해줄 STMP 서버
		p.put("mail.smtp.port", 465);         	   //"mail.smtp.port "은 SMTP서버와 통신하는 포트를 말하는데 gmail일 경우 465
		p.put("mail.smtp.auth","true");            
		p.put("mail.smtp.ssl.enable", "true"); 
		p.put("mail.smtp.ssl.trust", "smtp.gmail.com");

		Session session = Session.getDefaultInstance(p, new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(id, pw);
			}
		});

		/* 텍스트필드에서 이메일 가져오기 =>매게변수 email */
		String charSet = "UTF-8" ;
		try{
			MimeMessage msg = new MimeMessage(session);
			msg.setSentDate(new Date());
			String fromName = id ;
			InternetAddress from = new InternetAddress() ;
			try{
				from = new InternetAddress(new String(fromName.getBytes(charSet), "8859_1") + "<cine190823@gmail.com>");
				//from = new InternetAddress("<ksu4675447@gmail.com>","8859_1");
			}catch(UnsupportedEncodingException uee){
				uee.printStackTrace();
			}
			msg.setFrom(from);
			InternetAddress to = new InternetAddress(email);
			msg.setRecipient(Message.RecipientType.TO, to);
			msg.setSubject("안녕하세요 CineBro 입니다.", charSet);
			msg.setText("고객님이 입력하실 보안코드는 ", "euc-kr");
			msg.setText(security, "euc-kr");
			msg.setText(" 입니다.", "euc-kr");
			msg.setText("정확하게 입력하시기 바랍니다.", "euc-kr");
			msg.setText("감사합니다.", "euc-kr");
			//본문이 깨져서 국내용 유니코드로 변경하였음
			msg.setHeader("content-Type", "text/html"); //이메일 헤더가 본문내용으로 발송

			Transport.send(msg);

		}catch (AddressException addr_e) {
			addr_e.printStackTrace();
		}catch (MessagingException msg_e) {
			msg_e.printStackTrace();
		}//try~catch
	}//
}
