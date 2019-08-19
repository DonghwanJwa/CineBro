package com.movie.DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;

import com.movie.VO.MovieNowVO;
import com.movie.VO.MovieVO;
import com.movie.main.AppManager;

public class MovieDAO {
	DAOManager daoManager = AppManager.getInstance().getDAOManager();	//싱글톤 사용
	MovieVO m=AppManager.getInstance().getDataManager().getMovieVO();	//싱글톤 내용을 객체 m으로 저장
	String sql=null;													//sql 초기값 지정
	ResultSet rs;														//ResultSet rs로 객체초기화

	public MovieDAO(){
		AppManager.getInstance().getDAOManager().setMovieDAO(this);
	}

	// DB에 저장되어 있는 모든 영화를 리턴해주는 메소드
	public MovieVO getMovieInfo(int i){
		daoManager = AppManager.getInstance().getDAOManager();
		m = AppManager.getInstance().getDataManager().getMovieVO();
		// 모든 DB를 뒤져 Movies에 저장
		try {
			daoManager.connectDB();
			String sql = "SELECT * FROM MovieData where movie_code=? order by movie_code asc";
			daoManager.pt = daoManager.con.prepareStatement(sql);
			daoManager.pt.setInt(1, i);
			rs = daoManager.pt.executeQuery();
			while(rs.next()){
				m.setMovie_code(rs.getInt("movie_code"));
				m.setMovie_nameK(rs.getString("movie_nameK"));
				m.setMovie_nameE(rs.getString("movie_nameE"));
				m.setMovie_img(rs.getString("movie_img"));
				m.setAudience(rs.getString("audience"));
				m.setCriticism(rs.getString("criticism"));
				m.setActors(rs.getString("actors"));
				m.setPeople(rs.getString("people"));
				m.setGenre(rs.getString("gerne"));
				m.setAge(rs.getString("age"));
				m.setDirector(rs.getString("director"));
				m.setTeaser(rs.getString("teaser"));
				m.setTeaser_img(rs.getString("teaser_img"));
				m.setOneView(rs.getString("oneview"));
				m.setOneView_img(rs.getString("oneview_img"));
				m.setTwoView(rs.getString("twoview"));
				m.setTwoView_img(rs.getString("twoview_img"));
				m.setThreeView(rs.getString("threeview"));
				m.setThreeView_img(rs.getString("threeview_img"));

			}
		} catch (Exception e){
			e.printStackTrace();
		}finally {
			try {
				daoManager.closeDB();			
				if(rs != null) rs.close();	
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return m;
		//모든 영화 ArrayList 리턴
	}	
}