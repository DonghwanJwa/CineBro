


package com.movie.DAO;

import java.sql.ResultSet;

public class MemberDAO {
	DataManager DM;//데이터를 가져오는 클래스
	Member mem;	//데이터를 보관해줄 VO
	
	int result;
	ResultSet rs;
	
	public MemberDAO() {
		//		싱글턴 적용할 생성자?
	}
	//------------------------------회원가입------------------------------//
	boolean Customer() {
		DM.ConnectDB();
		String sql= "INSERT INTO ( member_id, member_pw, member_name, member_sex, member_birthday, member_email) VALUES(?, ?, ?, ?, ?, ?)";
		try {
			DM.pt = DM.con.prepareStatement(sql);
			DM.pt.setString(1, mem.getId());
			DM.pt.setString(2, mem.getPwd());
			DM.pt.setString(3, mem.getName());
			DM.pt.setString(4, mem.getSex());
			DM.pt.setString(5, mem.getBirthday());
			DM.pt.setString(6, mem.getEmail());

		}catch(Exception e) {e.printStackTrace();}
		//		result값이 참일 때
		if(result > 0) {
			return true;
		}else {
			return false;
			}//if else
	}
	//------------------------------로그인 기능------------------------------//
	boolean login() {
		DM.ConnectDB();
		String sql= "SELECT * FROM member WHERE member_id = ?";
		try {
			DM.pt = DM.con.prepareStatement(sql);
			DM.pt.setString(1, mem.getId());
			rs=DM.pt.executeQuery();
			//--------------------아이디와 비밀번호가 같다면 회원정보를 불러와 저장-------------------//
			if(rs.next()) {
				if(mem.getPwd().equals(rs.getString(3))) {
					mem.setId(rs.getString("mem_id"));
					mem.setPwd(rs.getString("mem_pwd"));
					mem.setName(rs.getString("mem_name"));
					mem.setSex(rs.getString("mem_sex"));
					mem.setBirthday(rs.getString("mem_birthday"));
					mem.setEmail(rs.getString("mem_email"));
					return true;
				}
			}
			rs.close();
			DM.CloseDB();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	//------------------------------중복검사------------------------------//
	boolean idCheck() {
		
		
		DM.ConnectDB();
		String sql="SELECT member_id FROM member";
		
		try {
			DM.pt=DM.con.prepareStatement(sql);
			rs= DM.pt.executeQuery();
			while(rs.next()) {
				if(mem.getId().equals(rs.getString(1)))
					return false;
			}
			rs.close();
			DM.CloseDB();
		}catch(Exception e) {
			e.printStackTrace();
			}
	}
}