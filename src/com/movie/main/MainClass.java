package com.movie.main;

import com.movie.UI.MyActionListener;

public class MainClass {
	public static void main(String[] args) {
		MyActionListener my=new MyActionListener();
		my.mainListenerSet();
		my.bookingListenerSet();
		
		AppManager.getInstance().getMainUi();
	}
}