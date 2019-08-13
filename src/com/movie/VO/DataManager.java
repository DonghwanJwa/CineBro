
package com.movie.VO;

import com.movie.main.AppManager;

public class DataManager {
	private CinemaVO cinemaVO;
	private MovieVO movieVO;
	private MovieNowVO MovieNowVO;
	private MemberVO memberVO;
	private SeatVO seatVO;
	private MovietimeVO movietimeVO;
	private DayseatVO dayseatVO;
	private BookingVO bookingVO;
	private BookedseatVO bookedseatVO;

	public DataManager() {
		AppManager.getInstance().setDataManager(this);
	}
	
	//------------------------------set-----------------------------//
	public void setCinemaVO(CinemaVO cinemaVO) 			   {		this.cinemaVO = cinemaVO;			}
	public void setMemberVO(MemberVO memberVO)			   {		this.memberVO = memberVO;			}
	public void setMovieVO(MovieVO movieVO) 			   {		this.movieVO = movieVO;				}
	public void setMovieNowVO(MovieNowVO movieNowVO) 	   {		this.MovieNowVO = movieNowVO;		}
	public void setSeatVO(SeatVO seatVO) 				   {		this.seatVO = seatVO; 				}
	public void setMovietimeVO(MovietimeVO movietimeVO)    {		this.movietimeVO = movietimeVO;		}
	public void setDayseatVO(DayseatVO dayseatVO) 		   {		this.dayseatVO = dayseatVO;			}
	public void setBookingVO(BookingVO bookingVO) 		   {		this.bookingVO = bookingVO;			}
	public void setBookedseatVO(BookedseatVO bookedseatVO) {		this.bookedseatVO = bookedseatVO;	}

	//------------------------------get-----------------------------//
	public CinemaVO getCinemaVO() 		  {		return cinemaVO;		}
	public MemberVO getMemberVO() 		  {		return memberVO;		}
	public MovieVO getMovieVO() 	 	  {		return movieVO;			}
	public MovieNowVO getMovieNowVO() 	  {		return MovieNowVO;		}
	public SeatVO getSeatVO() 		 	  {		return seatVO;			}
	public MovietimeVO getMovietimeVO()	  {		return movietimeVO;		}
	public DayseatVO getDayseatVO()		  {		return dayseatVO;		}
	public BookingVO getBookingVO() 	  {		return bookingVO;		}
	public BookedseatVO getBookedseatVO() {		return bookedseatVO;	}


}
