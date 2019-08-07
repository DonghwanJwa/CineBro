package com.movie.main;

import com.movie.DAO.DAOManager;
import com.movie.UI.LoginPage;
import com.movie.UI.MainUI;
import com.movie.UI.MyActionListener;
import com.movie.UI.SignUpFrame;
import com.movie.VO.DataManager;

public class AppManager {
	private static AppManager appManager=null;
	private MyActionListener myListener;
	private MainUI mainUi;
	private LoginPage login_page;
	private SignUpFrame signUp;
	private DAOManager daoManager;
	private DataManager dataManager;
	
	// 싱글톤 
	public static AppManager getInstance() {
		if(appManager == null) {
			appManager=new AppManager();	
		}//if
		return appManager;
	}//getInstance

	//******************************get 메서드*****************************//
	public LoginPage getLogin() {		return login_page;		}
	public SignUpFrame getSignUpFrame() {		return signUp;		}
	public MainUI getMainUi() {		return mainUi;  	}
	public MyActionListener getMyListener() {		return myListener;		}
	public DAOManager getDAOManager() {	return daoManager;	}
	public DataManager getDataManager() { return dataManager;	}
	
	//******************************set 메서드*****************************//
	public void setLogin(LoginPage login) {		this.login_page = login;		}
	public void setSignUpFrame(SignUpFrame signUp) {  	this.signUp = signUp; 		}
	public void setMainUi(MainUI mainUi) {		this.mainUi = mainUi;		}
	public void setMyListener(MyActionListener myListener) {	this.myListener = myListener;	}
	public void setDAOManager(DAOManager daoManager) { this.daoManager = daoManager;	}
	public void setDataManager(DataManager dataManager) { this.dataManager=dataManager;	}
}//AppManager class ( SingleTon ) 
