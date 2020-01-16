package com.movie.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import com.movie.main.AppManager;

public class DAOManager {
	private CinemaDAO cinemaDAO;
	private MovieDAO movieDAO;
	private MovieNowDAO movieNowDAO;
	private MemberDAO memberDAO;
	private BookingDAO bookingDAO;
	private BCheckDAO bcheckDAO;
	
	// ------- DB 커넥트 변수 ------- //
	String driver="oracle.jdbc.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String user="DB User명";
	String password="비밀번호";

	Connection con=null;
	PreparedStatement pt=null;

	public DAOManager() {
		// ------- 싱글턴 패턴 적용 ------- //	
		AppManager.getInstance().setDAOManager(this);
	}

	public void connectDB() {
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url, user, password);
		}catch(Exception e) {e.printStackTrace();}
	}//connectDB()

	public void closeDB() {
		try {
			if(pt != null) pt.close();
			if(con != null) pt.close();
		}catch(Exception e) {e.printStackTrace();}
	}//closeDB()


	// ------------------------------set 메서드----------------------------- //

	public void setCinemaDAO(CinemaDAO cinemaDAO) 		{ this.cinemaDAO = cinemaDAO;	  }	
	public void setMovieDAO(MovieDAO movieDAO) 			{ this.movieDAO = movieDAO;       }	
	public void setMovieNowDAO(MovieNowDAO movieNowDAO) { this.movieNowDAO = movieNowDAO; }	
	public void setMemberDAO(MemberDAO memberDAO) 		{ this.memberDAO = memberDAO;     }	
	public void setBookingDAO(BookingDAO bookingDAO) 	{ this.bookingDAO = bookingDAO;   }
	public void setBcheckDAO(BCheckDAO bcheckDAO) 		{ this.bcheckDAO = bcheckDAO;     }
	
	// ------------------------------get 메서드----------------------------- //
	
	public CinemaDAO getCinemaDAO() 	{ return cinemaDAO;	  } 	
	public MovieDAO getMovieDAO()		{ return movieDAO;    }	
	public MovieNowDAO getMovieNowDAO() { return movieNowDAO; }	
	public MemberDAO getMemberDAO() 	{ return memberDAO;	  }	
	public BookingDAO getBookingDAO()   { return bookingDAO;  }
	public BCheckDAO getBcheckDAO() 	{ return bcheckDAO;	  }



}//DAOManager
