package com.movie.VO;

public class MovieVO {

	//*********기본 영화 정보*********//
	
	private int movie_code;			//영화를 식별할 영화코드
	private String movie_nameK;		//한국영화이름 
	private String movie_nameE; 	//영어영화이름
	private String movie_img;		//영화포스터
	private String audience;		//관람객 평점
	private String criticism;		//평론가 평점
	private String genre;			//영화장르(장르 , 나라, 러닝타임, 개봉일)
	private String director;		//감독
	private String actors;			//영화배우
	private String age;				//나이등급
	private String people;			//누적관객
	
	
	//**********영화예고편**********//
	
	private String teaser;			//영화 티저영상
	private String teaser_img;		//영화 티저영상 이미지
	private String oneview;			//예고편1
	private String oneview_img;		//예고편1 이미지
	private String twoview;			//예고편2
	private String twoview_img;		//예고편2 이미지
	private String threeview;		//예고편3
	private String threeview_img;	//예고편3 이미지
	
	//******************************set*****************************//
 
	public void setMovie_code	(int movie_code) 			{this.movie_code = movie_code;}
	public void setMovie_nameK	(String movie_nameK) 		{this.movie_nameK = movie_nameK;}
	public void setMovie_nameE	(String movie_nameE) 		{this.movie_nameE = movie_nameE;}
	public void setMovie_img	(String movie_img) 			{this.movie_img = movie_img;}
	public void setAudience		(String audience) 			{this.audience = audience;}
	public void setCriticism	(String criticism) 			{this.criticism = criticism;}
	public void setActors		(String actors) 			{this.actors = actors;}
	public void setPeople		(String people) 			{this.people = people;}
	public void setGenre		(String genre) 				{this.genre = genre;}
	public void setAge			(String age)				{this.age = age;}
	public void setDirector		(String director) 			{this.director = director;}
	public void setTeaser		(String teaser)				{this.teaser = teaser;}
	public void setTeaser_img	(String teaser_img)			{this.teaser_img = teaser_img;}	
	public void setOneView		(String oneview)			{this.oneview = oneview;}
	public void setOneView_img	(String oneview_img)		{this.oneview_img = oneview_img;}
	public void setTwoView		(String twoview)			{this.twoview = twoview;}
	public void setTwoView_img	(String twoview_img) 		{this.twoview_img = twoview_img;}
	public void setThreeView	(String threeview) 			{this.threeview = threeview;}	
	public void setThreeView_img(String threeview_img) 		{this.threeview_img = threeview_img;}

	//******************************get*****************************//

	public int getMovie_code() 			{return movie_code;}
	public String getMovie_nameK() 		{return movie_nameK;}
	public String getMovie_nameE() 		{return movie_nameE;}
	public String getMovie_img() 		{return movie_img;}
	public String getAudience() 		{return audience;}
	public String getCriticism() 		{return criticism;}
	public String getActors() 			{return actors;}
	public String getPeople() 			{return people;}
	public String getGenre() 			{return genre;}
	public String getAge()				{return age;}
	public String getDirector()     	{return director;}
	public String getTeaser() 			{return teaser;}
	public String setTeaser_img()		{return teaser_img;}				
	public String setOneView()			{return oneview;}			
	public String setOneView_img()		{return oneview_img;}		
	public String setTwoView()			{return twoview;}			
	public String setTwoView_img()		{return twoview_img;} 		
	public String setThreeView()		{return threeview;} 				
	public String setThreeView_img()	{return threeview_img;} 		
	
}