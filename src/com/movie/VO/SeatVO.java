package com.movie.VO;

import com.movie.main.AppManager;

/**좌석 테이블 VO**/
public class SeatVO {
	private String seat_Num;
	private String screen;
	
	public SeatVO() {
		AppManager.getInstance().getDataManager().setSeatVO(this);
	}
	
	/* getter */
	public String getSeat_Num() {		return seat_Num;	}
	public String getScreen()   {		return screen;		}
	
	/* setter */
	public void setSeat_Num(String seat_Num) {	this.seat_Num = seat_Num;	}
	public void setScreen(String screen) 	 {	this.screen = screen; 		}
}
