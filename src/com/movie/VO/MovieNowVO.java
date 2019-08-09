package com.movie.VO;

import com.movie.DAO.DAOManager;
import com.movie.main.AppManager;

public class MovieNowVO {
	//---------기본 영화 정보---------//
	private int movie_code;//영화를 식별할 영화코드
	private String movie_nameK;//영화이름(한국)
	private String movie_nameE;//영화이름(영어)
	private String img;	//영화 이미지
	private String genre;//영화장르
	private	String age;//상영등급

	private String director;//감독
	private String actors;

	public MovieNowVO() {
		AppManager.getInstance().getDataManager().setMovieNowVO(this);
		
	}

	//------------------------------set메서드-----------------------------//

	public void setMovie_code(int movie_code)		{ this.movie_code = movie_code;	 	}
	public void setMovie_nameE(String movie_nameE) 	{ this.movie_nameE = movie_nameE;	}
	public void setMovie_nameK(String movie_nameK) 	{ this.movie_nameK = movie_nameK;	}
	public void setGenre(String genre) 				{ this.genre = genre;				}
	public void setImg(String img)					{ this.img = img;					}
	public void setDirector(String director) 		{ this.director = director;			}
	public void setActors(String actors) 	 		{ this.actors = actors;				}
	public void setAge(String age) 					{ this.age = age;					}
	
	//------------------------------get 메서드-----------------------------//

	public int getMovie_code() 		{ 	return movie_code; 	}
	public String getMovie_nameE() 	{ 	return movie_nameE;	}
	public String getMovie_nameK() 	{ 	return movie_nameK;	}
	public String getGenre() 		{ 	return genre;		}
	public String getImg() 			{	return img;			}
	public String getDirector()     { 	return director; 	}
	public String getActors() 		{ 	return actors;		}
		public String getAge() 		{	return age;			}
	
}
