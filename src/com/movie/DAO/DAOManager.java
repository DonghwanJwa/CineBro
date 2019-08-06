package com.movie.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAOManager {
	private CinemaDAO cinemaDAO;
	private MovieDAO movieDAO;
	private MovieNowDAO movieNowDAO;
	
	
	
	// ------- DB 커넥트 변수
	String driver="oracle.jdbc.OracleDriver";
	String url="jdbc:oracle:thin:@localhost:1521:xe";
	String user="cinema";
	String password="swing";

	Connection con=null;
	PreparedStatement pt=null;

	public void ConnectDB() {
		try {
			Class.forName(driver);
			con=DriverManager.getConnection(url, user, password);
		}catch(Exception e) {e.printStackTrace();}
	}//connectDB()

	public void closeDB() {
		try {
			if(pt != null) pt.close();
			if(con != null) pt.close();
		}catch(Exception e) {e.printStackTrace();}
	}//closeDB()

}//DAOManager
