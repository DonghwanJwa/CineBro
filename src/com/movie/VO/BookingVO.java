package com.movie.VO;

import com.movie.main.AppManager;

/**예매 테이블 VO**/
public class BookingVO {
	private int booking_code;	//예약번호
	private int price;			//금액
	private int seatcount;		//좌석수
	private int movie_code;		//영화코드
	private String member_id;	//회원아이디
	private String time_code;	//시간코드
	
	public BookingVO() {
		AppManager.getInstance().getDataManager().setBookingVO(this);
	}
	
	/* getter */
	public int getBooking_code()	 {		return booking_code;	}
	public int getPrice() 			 {		return price;			}
	public int getSeatcount() 		 {		return seatcount;		}
	public int getMovie_code() 		 {		return movie_code;		}
	public String getMember_id()	 {		return member_id;		}
	public String getTime_code() 	 {		return time_code;		}
	
	/* setter */
	public void setBooking_code(int booking_code) 	{		this.booking_code = booking_code;	}
	public void setPrice(int price) 				{		this.price = price;					}
	public void setSeatcount(int seatcount) 		{		this.seatcount = seatcount;			}
	public void setMovie_code(int movie_code) 		{		this.movie_code = movie_code;		}
	public void setMember_id(String member_id) 		{		this.member_id = member_id;			}
	public void setTime_code(String time_code) 		{		this.time_code = time_code;			}
	
	
}
