package com.movie.DAO;

import java.sql.ResultSet;
import java.util.Vector;

import com.movie.VO.CinemaVO;
import com.movie.VO.MovieVO;
import com.movie.main.AppManager;

public class BookingDAO {
	DAOManager daoManager = AppManager.getInstance().getDAOManager();
	
	String sql=null;
	ResultSet rs=null;
	
	public BookingDAO() {
		AppManager.getInstance().getDAOManager().setBookingDAO(this);
	}
	
	public Vector<MovieVO> movieNameList(){
		daoManager.connectDB();

		Vector<MovieVO> nameList=new Vector<MovieVO>();
		String sql="SELECT movie_code,movie_nameK,movie_nameE FROM MovieData";

		try {
			daoManager.pt=daoManager.con.prepareStatement(sql);
			rs=daoManager.pt.executeQuery();
			while(rs.next()) {
				MovieVO m=new MovieVO();
				m.setMovie_code(rs.getInt("movie_code"));
				m.setMovie_nameK(rs.getString("movie_nameK"));
				m.setMovie_nameE(rs.getString("movie_nameE"));
				nameList.add(m);
			} // while
			if(rs != null) rs.close();
			daoManager.closeDB();
		}catch(Exception e) {e.printStackTrace();}// try-catch		

		return nameList;
	}// movieNameList()
	
	public Vector<CinemaVO> cinemaList(int movie_code){
		daoManager.connectDB();
		
		Vector<CinemaVO> cinemaList=new Vector<>();
		String sql="SELECT * FROM cinema WHERE movie_code=?";
		try {
			daoManager.pt=daoManager.con.prepareStatement(sql);
			daoManager.pt.setInt(1,movie_code);
			rs=daoManager.pt.executeQuery();
			while(rs.next()) {
				CinemaVO m=new CinemaVO();
				m.setScreen(rs.getString("screen"));
				cinemaList.add(m);
			} // while
			if(rs != null) rs.close();
			daoManager.closeDB();
		}catch(Exception e) { e.printStackTrace(); }
		
		return cinemaList;
	}
}
