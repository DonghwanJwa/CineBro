package com.movie.VO;

import com.movie.main.AppManager;

/**예매한 좌석 테이블**/
public class BookedseatVO {
	private int booking_code;	//예매코드
	private String screen;		//상영관
	private String seat_Num;	//좌석번호
	
	public BookedseatVO() {
		AppManager.getInstance().getDataManager().setBookedseatVO(this);;
	}
	
	/* getter */
	public int getBooking_code()	 {		return booking_code;	}
	public String getScreen()		 {		return screen;			}
	public String getSeat_Num() 	 {		return seat_Num;		}
	
	/* setter */
	public void setBooking_code(int booking_code) {		this.booking_code = booking_code;	}
	public void setScreen(String screen)		  {		this.screen = screen;				}
	public void setSeat_Num(String seat_Num) 	  {		this.seat_Num = seat_Num;			}
	
	
	
	
}
