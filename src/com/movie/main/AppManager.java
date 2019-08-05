package com.movie.main;

import com.movie.UI.LoginPage;
import com.movie.UI.MainUI;
import com.movie.UI.MyActionListener;
import com.movie.frame.SignUP;

public class AppManager {
	private static AppManager appManager=null;
	private MyActionListener myListener;
	private MainUI mainUi;
	private LoginPage login_page;
	private SignUP signUp;

	private AppManager() {} 
	// 싱글톤 
	public static AppManager getInstance() {
		if(appManager == null) {
			appManager=new AppManager();
		}//if
		return appManager;
	}//getInstance

	public LoginPage getLogin() {		return login_page;		}
	public SignUP getSignUp() {		return signUp;		}
	public MainUI getMainUi() {		return mainUi;  	}
	public MyActionListener getMyListener() {		return myListener;		}

	public void setLogin(LoginPage login) {		this.login_page = login;		}
	public void setSignUp(SignUP signUp) {  	this.signUp = signUp; 		}
	public void setMainUi(MainUI mainUi) {		this.mainUi = mainUi;		}
	public void setMyListener(MyActionListener myListener) {	this.myListener = myListener;	}
}//AppManager class ( SingleTon ) 
