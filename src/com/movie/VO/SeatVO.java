package com.movie.VO;

import com.movie.main.AppManager;

/**좌석 테이블 VO**/
public class SeatVO {
	private String seat_Num;
	private String screen;
	private String seatrow;
	private String seatcol;
	


	public SeatVO() {
		AppManager.getInstance().getDataManager().setSeatVO(this);
	}
	
	/* getter */
	public String getSeat_Num() {		return seat_Num;	}
	public String getScreen()   {		return screen;		}
	public String getSeatrow()  {		return seatrow;		}
	public String getSeatcol()  {		return seatcol;		}
	
	/* setter */
	public void setSeat_Num(String seat_Num) {	    this.seat_Num = seat_Num;	}
	public void setScreen(String screen) 	 {	    this.screen = screen; 		}
	public void setSeatrow(String seatrow)   {		this.seatrow = seatrow;		}
	public void setSeatcol(String seatcol)   {		this.seatcol = seatcol;		}
}
