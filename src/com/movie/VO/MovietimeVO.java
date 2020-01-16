package com.movie.VO;

import com.movie.main.AppManager;
/**상영일정 테이블 VO**/
public class MovietimeVO {
	private String time_code;	//시간코드
	private String screentime;	//상영시간
	private String screendate;	//상영일자
	private int movie_code;		//영화코드
	private String screen;		//상영관
	
	public MovietimeVO() {
		AppManager.getInstance().getDataManager().setMovietimeVO(this);
	}

	/* getter */
	public String getTime_code() 	{		return time_code;		}
	public String getScreentime() 	{		return screentime;		}
	public String getScreendate() 	{		return screendate;		}
	public int getMovie_code() 		{		return movie_code;		}
	public String getScreen() 		{		return screen;			}
	
	/* setter */
	public void setTime_code(String time_code) 		{		this.time_code = time_code;		}
	public void setScreentime(String screentime)	{		this.screentime = screentime;	}
	public void setScreendate(String screendate)	{		this.screendate = screendate;	}
	public void setMovie_code(int movie_code) 		{		this.movie_code = movie_code;	}
	public void setScreen(String screen) 			{		this.screen = screen;			}
	
	
}
