package com.movie.VO;

import com.movie.main.AppManager;

/**예매좌석 테이블**/
public class DayseatVO {
	private int seat_status;	//예매유무(0,1)
	private String seat_Num;	//좌석번호
	private String screen;		//상영관
	private String time_code; 	//시간코드

	public DayseatVO() {
		AppManager.getInstance().getDataManager().setDayseatVO(this);
	}
	
	/* getter */
	public int getSeat_status() 	{		return seat_status;		}
	public String getSeat_Num() 	{		return seat_Num;		}
	public String getScreen() 		{		return screen;			}
	public String getTime_code() 	{		return time_code;		}
	
	/* setter */
	public void setSeat_status(int seat_status)	 {		this.seat_status = seat_status;		}
	public void setSeat_Num(String seat_Num)	 {		this.seat_Num = seat_Num;			}
	public void setScreen(String screen)		 {		this.screen = screen;				}
	public void setTime_code(String time_code) 	 {		this.time_code = time_code;			}
	
	
}
