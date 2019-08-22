package com.movie.DAO;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.movie.VO.BookingVO;
import com.movie.VO.DataManager;
import com.movie.VO.MovieNowVO;
import com.movie.VO.MovietimeVO;
import com.movie.main.AppManager;

public class BCheckDAO {
	DAOManager daoManager = AppManager.getInstance().getDAOManager();
	DataManager dataManager = AppManager.getInstance().getDataManager();

	String sql=null;
	ResultSet rs=null;

	public BCheckDAO() {
		AppManager.getInstance().getDAOManager().setBCheckDAO(this);
	}

	// --- 예약정보를 가져오는 메서드
	public List<BookingVO> getBookingCode(String id) {
		List<BookingVO> list = new ArrayList<>();

		daoManager.connectDB();
		sql = "select * from booking where member_id=? order by booking_code asc";
		try {
			daoManager.pt = daoManager.con.prepareStatement(sql);
			daoManager.pt.setString(1,id);
			rs = daoManager.pt.executeQuery();
			while(rs.next()) {
				BookingVO b = new BookingVO();
				b.setBooking_code(rs.getInt("booking_code"));
				b.setPrice(rs.getInt("price"));
				b.setSeatcount(rs.getInt("seatcount"));
				b.setMovie_code(rs.getInt("movie_code"));
				b.setTime_code(rs.getString("time_code"));;
				list.add(b);
			}//while			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try{
				if(rs!=null) rs.close();
				daoManager.closeDB();
			}catch(Exception e) {
				e.printStackTrace();
			}//try~catch
		}//finally		
		return list;
	}

	// --- 예약된 영화정보(영화명,포스터명)을 가져오는 메서드
	public MovieNowVO getMovieBasicInfo(BookingVO vo) {
		MovieNowVO mo = new MovieNowVO();
		daoManager.connectDB();
		sql = "select * from MovieData where movie_code=?";

		try {
			daoManager.pt = daoManager.con.prepareStatement(sql);
			daoManager.pt.setInt(1,vo.getMovie_code());
			rs = daoManager.pt.executeQuery();
			
			if(rs.next()) {
				mo.setMovie_nameK(rs.getString("movie_nameK"));
				mo.setImg(rs.getString("movie_img"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try{
				if(rs!=null) rs.close();
				daoManager.closeDB();
			}catch(Exception e) {
				e.printStackTrace();
			}//try~catch
		}//finally
		return	mo;
	}
	
	// --- 예약된 영화정보(상영날짜, 상영시간, 상영관)을 가져오는 메서드
	public MovietimeVO getMovietimeInfo(BookingVO vo) {
		MovietimeVO mv = new MovietimeVO();
		Date dateS = null;
		daoManager.connectDB();
		sql = "select * from movietime where time_code=?";
			
		try {
			daoManager.pt = daoManager.con.prepareStatement(sql);
			daoManager.pt.setString(1,vo.getTime_code());
			rs = daoManager.pt.executeQuery();
			
			if(rs.next()) {
				dateS = rs.getDate("screendate");
				SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
				String date = transFormat.format(dateS);

				mv.setScreendate(date);
				mv.setScreentime(rs.getString("screentime"));
				mv.setScreen(rs.getString("screen"));
			}		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				daoManager.closeDB();
			}catch(Exception e) {
				e.printStackTrace();
			}//try~catch
		}//finally
		return mv;
	}
	
	// --- 예약된 영화정보(좌석번호)를 가져오는 메서드
	public String getMovieSeatNum(BookingVO vo) {
		String seatNum = "";
		daoManager.connectDB();
		sql = "select * from booked_seat where booking_code=?";
		
		try {
			daoManager.pt = daoManager.con.prepareStatement(sql);
			daoManager.pt.setInt(1,vo.getBooking_code());
			rs = daoManager.pt.executeQuery();
			
			while(rs.next()) {
				seatNum = seatNum+" "+rs.getString("seat_Num");
			}					
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs!=null) rs.close();
				daoManager.closeDB();
			}catch(Exception e) {
				e.printStackTrace();
			}//try~catch
		}//finally
		return seatNum;
	}
	
	// --- 예약된 영화 취소 메서드(booked_seat)
	public int cancelReserveBookedseat(int booking_code) {
		int re = -1;
		daoManager.connectDB();
		sql = "delete from booked_seat where booking_code=?";
		try {
			daoManager.pt = daoManager.con.prepareStatement(sql);
			daoManager.pt.setInt(1,booking_code);
			re = daoManager.pt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				daoManager.closeDB();
			}catch(Exception e) {
				e.printStackTrace();
			}//try~catch
		}//finally	
		return re;		
	}
	// --- 예약된 영화 취소 메서드(booking)
	public int cancelReserveBooking(int booking_code) {
		int re = -1;
		daoManager.connectDB();
		sql = "delete from Booking where booking_code=?";
		try {
			daoManager.pt = daoManager.con.prepareStatement(sql);
			daoManager.pt.setInt(1,booking_code);
			re = daoManager.pt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				daoManager.closeDB();
			}catch(Exception e) {
				e.printStackTrace();
			}//try~catch
		}//finally	
		return re;	
	}
}
