package com.movie.DAO;

public class MovieNowDAO {

	//*********기본 영화 정보*********//
	private String movieCode;//영화를 식별할 영화코드
	private String title;//영화이름
	private String genre;//영화장르
	private String runningTime;//영화시간
	private String director;//감독
	private String Screentime;
	private String Actors;
	private String WP;

	//**********영화예고편**********//
	private String Video;//배열 or 컬렉션으로
	private String Teaser;//영화 티저영상
	private String preview1;
	private String preview2;
	//******************************set*****************************//

	public void setMovieCode(String movieCode)	 	{ this.movieCode = movieCode; }
	public void setTitle(String title) 				{ this.title = title;	}
	public void setGenre(String genre) 				{ this.genre = genre;	}
	public void setRunningTime(String runningTime) 	{ this.runningTime = runningTime; }
	public void setDirector(String director) 		{	this.director = director;	}
	public void setScreentime(String screentime) 	{	this.Screentime = screentime;	}
	public void setActors(String actors) 	 		{	Actors = actors;	}
	public void setWP(String wP) 		 	 		{	WP = wP;	}
	public void setVideo(String video)				{	Video = video;	}
	public void setTeaser(String teaser)			{	Teaser = teaser;	}
	public void setPreview1(String preview1)		{	this.preview1 = preview1;	}
	public void setPreview2(String preview2) 		{	this.preview2 = preview2;	}

	//******************************get*****************************//

	public String getMovieCode() {	 return movieCode;	}
	public String getTitle() 		{ return title;		}
	public String getGenre() 		{ return genre;		}
	public String getRunningTime()  { return runningTime; }
	public String getDirector()     { return director;	 }
	public String getScreentime()   {  return Screentime; }
	public String getActors() 		{ return Actors;	}
	public String getWP() 			{ return WP;		}
	public String getVideo() 		{ return Video;		}
	public String getTeaser() 		{ return Teaser;	}
	public String getPreview1() 	{ return preview1;	}
	public String getPreview2() 	{ return preview2;	}

}


