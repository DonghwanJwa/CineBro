
package com.movie.VO;

import com.movie.main.AppManager;

public class DataManager {
	private CinemaVO cinemaVO;
	private MovieVO movieVO;
	private MovieNowVO MovieNowVO;
	private MemberVO memberVO;

	public DataManager() {
		AppManager.getInstance().setDataManager(this);
	}
	//------------------------------set-----------------------------//

	public void setCinemaVO(CinemaVO cinemaVO) 		 {	this.cinemaVO = cinemaVO;		}
	public void setMemberVO(MemberVO memberVO)		 {	this.memberVO = memberVO;		}
	public void setMovieVO(MovieVO movieVO) 		 {	this.movieVO = movieVO;			}
	public void setMovieNowVO(MovieNowVO movieNowVO) {	this.MovieNowVO = movieNowVO;	}

	//------------------------------get-----------------------------//
	public CinemaVO getCinemaVO() 	  {	return cinemaVO;	}
	public MemberVO getMemberVO() 	  {	return memberVO;	}
	public MovieVO getMovieVO() 	  {	return movieVO;		}
	public MovieNowVO getMovieNowVO() {	return MovieNowVO;	}


}
