package com.movie.VO;

import com.movie.main.AppManager;

/**상영관 테이블 VO**/
public class CinemaVO {
	private String screen;		//상영관
	private int movie_code;		//영화코드	
	
	public CinemaVO() {
		AppManager.getInstance().getDataManager().setCinemaVO(this);
	}
	
	/* getter */
	public String getScreen()  {	return screen;		}
	public int getMovie_code() {	return movie_code;	}
	
	/* setter */
	public void setScreen(String screen)      {	this.screen = screen;			}
	public void setMovie_code(int movie_code) {	this.movie_code = movie_code;	}
	
}
