package com.movie.DAO;

import java.sql.ResultSet;

import com.movie.VO.MovieNowVO;
import com.movie.main.AppManager;

public class MovieNowDAO {

	DAOManager daoManager = AppManager.getInstance().getDAOManager();
	MovieNowVO movieNowVO = AppManager.getInstance().getDataManager().getMovieNowVO();
	
	int result;
	ResultSet rs;
	
	public MovieNowDAO() {
		AppManager.getInstance().getDAOManager().setMovieNowDAO(this);
	}//생성자
	//-----------------------------영화정보 DB 입력-----------------------------//
	public MovieNowVO movieNowList(String movie_code) {
		String sql="SELECT  movie_code, movie_nameE, movie_img, age, gerne, director, actors FROM movietest where movie_code = ?";
		try {
			daoManager.connectDB();

			daoManager.pt = daoManager.con.prepareStatement(sql);
			daoManager.pt.setString(1, movie_code);
			rs= daoManager.pt.executeQuery();
			
			while(rs.next()) {
//				 movieNowVO.setMovie_code(rs.getInt("movie_code"));
				 movieNowVO.setMovie_nameK(rs.getString("movie_nameK"));
				 movieNowVO.setMovie_nameE(rs.getString("movie_nameE"));
				 movieNowVO.setImg(rs.getString("movie_img"));
				 movieNowVO.setAge(rs.getString("age"));
				 movieNowVO.setGenre(rs.getString("genre"));
				 movieNowVO.setDirector(rs.getString("director"));
				 movieNowVO.setActors(rs.getString("actors"));
			}
		}catch(Exception e) {e.printStackTrace();
		
		}finally {
			
			try {
				
				if(rs!=null)rs.close();
				daoManager.closeDB();
				
			}catch(Exception e) {e.printStackTrace();}
			
		}//finally
		return movieNowVO;
	}//movieNowList()
}


