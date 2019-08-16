package com.movie.DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.movie.VO.MovieNowVO;
import com.movie.main.AppManager;

public class MovieNowDAO {
	//
	DAOManager daoManager = AppManager.getInstance().getDAOManager();
	MovieNowVO mvo= AppManager.getInstance().getDataManager().getMovieNowVO();
	int result ;
	ResultSet rs = null;
	String sql =null;	//sql 값 초기화
	
	public MovieNowDAO() {
		AppManager.getInstance().getDAOManager().setMovieNowDAO(this);
	}//생성자
	public List<MovieNowVO> movieNowList() {
		//---------sql 문 작성---------//
		String sql="SELECT  movie_code, movie_nameK, movie_nameE, movie_img, age, gerne, director, actors FROM moviedata ";
		//---------데이터를 넣어줄 list 생성---------//
		List<MovieNowVO> nlist = new ArrayList<MovieNowVO>();
		try {
			daoManager.connectDB();//DB연결 메서드
			daoManager.pt = daoManager.con.prepareStatement(sql);//쿼리문
			//						daoManager.pt.setString(1, "movie_code");
			rs= daoManager.pt.executeQuery();
			while(rs.next()) {
				MovieNowVO movie =new MovieNowVO();
				/*DAO를 통해 입력되는 데이터를 전부 담기위해서는 초기화 과정을 통해 새로운 객체를 생성해주어야 한다.(기억하자)
				 * 만일 이사항을 무시하고 지나가게되면 해당 객체의 주소값이 같아지며 마지막에 남아있는 객체만이 데이터에 들어가게된다.*/
				
				//sql문에 해당되는 데이터를 DB에서 찾아 nlist에 순서대로 저장
				movie.setMovie_code(rs.getInt("movie_code"));
				movie.setMovie_nameK(rs.getString("movie_nameK"));
				movie.setMovie_nameE(rs.getString("movie_nameE"));
				movie.setImg(rs.getString("movie_img"));
				movie.setAge(rs.getString("age"));
				movie.setGenre(rs.getString("gerne"));
				movie.setDirector(rs.getString("director"));
				movie.setActors(rs.getString("actors"));
				nlist.add(movie);

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