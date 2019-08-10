package com.movie.DAO;

public class MovieNowDAO {

	// --------- 기본 영화 정보 --------- //
	private String movieCode;//영화를 식별할 영화코드
	private String title;//영화이름
	private String genre;//영화장르
	private String runningTime;//영화시간
	private String director;//감독
	private String Screentime;
	private String actors;

	// ---------- 영화예고편 ---------- //
	private String video;//배열 or 컬렉션으로
	private String teaser;//영화 티저영상
	private String preview1;
	private String preview2;
	
	// ------------------------------ set ------------------------ //
	public void setMovieCode(String movieCode)	 	{ 	this.movieCode = movieCode;		}
	public void setTitle(String title) 				{	this.title = title;				}
	public void setGenre(String genre) 				{ 	this.genre = genre;				}
	public void setRunningTime(String runningTime) 	{	this.runningTime = runningTime; }
	public void setDirector(String director) 		{	this.director = director;		}
	public void setScreentime(String screentime) 	{	this.Screentime = screentime;	}
	public void setActors(String actors) 	 		{	this.actors = actors;			}
	public void setVideo(String video)				{	this.video = video;				}
	public void setTeaser(String teaser)			{	this.teaser = teaser;			}
	public void setPreview1(String preview1)		{	this.preview1 = preview1;		}
	public void setPreview2(String preview2) 		{	this.preview2 = preview2;		}

	// ------------------------------ get ----------------------------- //
	public String getMovieCode()    {	 return movieCode;	 }
	public String getTitle() 		{	 return title;		 }
	public String getGenre() 		{	 return genre;		 }
	public String getRunningTime()  { 	 return runningTime; }
	public String getDirector()     {	 return director;	 }
	public String getScreentime()   { 	 return Screentime;  }
	public String getActors() 		{ 	 return actors;		 }
	public String getVideo() 		{ 	 return video;		 }
	public String getTeaser() 		{ 	 return teaser;	     }
	public String getPreview1() 	{	 return preview1;	 }
	public String getPreview2() 	{ 	 return preview2;	 }

}


