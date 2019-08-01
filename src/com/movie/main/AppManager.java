package com.movie.main;

import com.movie.UI.MainUI;

public class AppManager {
	private static AppManager appManager=null;
	private MainUI mainUi;
	
	private AppManager() {} // 싱글톤 패턴
	
	public MainUI getMainUi() {		return mainUi;  	}
	
	public void setMainUi(MainUI mainUi) {		this.mainUi = mainUi;		}
	
}//AppManager class ( SingleTon ) 
