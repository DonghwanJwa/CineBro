package com.movie.DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;

import com.movie.VO.MovieNowVO;
import com.movie.main.AppManager;

public class MovieNowDAO {
	//d
	DAOManager daoManager = AppManager.getInstance().getDAOManager();
	MovieNowVO mvo= AppManager.getInstance().getDataManager().getMovieNowVO();
	int result;
	ResultSet rs;

	public MovieNowDAO() {
		AppManager.getInstance().getDAOManager().setMovieNowDAO(this);
	}//생성자
	//입력된 영화정보를 되돌려주는 컬렉션 메서드 생성 //
	//	public MovieNowVO movieList(int i) {
	//		daoManager = AppManager.getInstance().getDAOManager();
	//		m = AppManager.getInstance().getDataManager().getMovieNowVO();
	//		try {
	//			String sql="SELECT  movie_code, movie_nameE, movie_img, age, gerne, director, actors FROM movietest where movie_code = ? ";
	//			daoManager.connectDB();//DB연결 메서드
	//			daoManager.pt = daoManager.con.prepareStatement(sql);//쿼리문
	//			daoManager.pt.setInt(1, i);
	//			rs= daoManager.pt.executeQuery();
	//
	//			while(rs.next()) {
	//				//sql문에 해당되는 데이터를 DB에서 찾아 nlist에 순서대로 저장
	//				m.setMovie_code(rs.getString("movie_code"));
	//				m.setMovie_nameK(rs.getString("movie_nameK"));
	//				m.setMovie_nameE(rs.getString("movie_nameE"));
	//				m.setImg(rs.getString("movie_img"));
	//				m.setAge(rs.getString("age"));
	//				m.setGenre(rs.getString("genre"));
	//				m.setDirector(rs.getString("director"));
	//				m.setActors(rs.getString("actors"));
	//			}
	//		}catch(Exception e) {e.printStackTrace();
	//		}finally {
	//			try {	
	//				if(rs!=null)rs.close();
	//				daoManager.closeDB();
	//			}catch(Exception e) {e.printStackTrace();}
	//		}//finally
	//		return m;
	//	}	
	//}
	public ArrayList<MovieNowVO> movieNowList() {
		//---------sql 문 작성---------//
		String sql="SELECT  movie_code,movie_nameK, movie_nameE, movie_img, age, gerne, director, actors FROM moviedata";
		//---------데이터를 넣어줄 list 생성---------//
		ArrayList<MovieNowVO> nlist = new ArrayList<MovieNowVO>();
		try {
			daoManager.connectDB();//DB연결 메서드
			daoManager.pt = daoManager.con.prepareStatement(sql);//쿼리문
			//			daoManager.pt.setString(1, movie_code);
			rs= daoManager.pt.executeQuery();

			while(rs.next()) {
				//sql문에 해당되는 데이터를 DB에서 찾아 nlist에 순서대로 저장
				mvo.setMovie_code(rs.getString("movie_code"));
				mvo.setMovie_nameK(rs.getString("movie_nameK"));
				mvo.setMovie_nameE(rs.getString("movie_nameE"));
				mvo.setImg(rs.getString("movie_img"));
				mvo.setAge(rs.getString("age"));
				mvo.setGenre(rs.getString("gerne"));
				mvo.setDirector(rs.getString("director"));
				mvo.setActors(rs.getString("actors"));
				nlist.add(mvo);
			}
		}catch(Exception e) {e.printStackTrace();		
		}finally {
			try {	
				if(rs!=null)rs.close();
				daoManager.closeDB();
			}catch(Exception e) {e.printStackTrace();}
		}//finally
		return nlist;
	}//movieNowList()	
}


