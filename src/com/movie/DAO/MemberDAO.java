package com.movie.DAO;

import java.sql.ResultSet;

import com.movie.VO.MemberVO;
import com.movie.main.AppManager;

public class MemberDAO {
	DAOManager daoManager = AppManager.getInstance().getDAOManager();//데이터를 가져오는 클래스
	MemberVO memberVO = AppManager.getInstance().getDataManager().getMemberVO();	//데이터를 보관해줄 VO

	int result;
	ResultSet rs;

	public MemberDAO() {
		AppManager.getInstance().getDAOManager().setMemberDAO(this);
	}
	//------------------------------회원가입------------------------------//
	boolean Customer() {
		daoManager.connectDB();
		String sql= "INSERT INTO ( memberVOber_id, memberVOber_pw, memberVOber_name, memberVOber_sex, memberVOber_birthday, memberVOber_email) VALUES(?, ?, ?, ?, ?, ?)";
		try {
			daoManager.pt = daoManager.con.prepareStatement(sql);
			daoManager.pt.setString(1, memberVO.getId());
			daoManager.pt.setString(2, memberVO.getPwd());
			daoManager.pt.setString(3, memberVO.getName());
			daoManager.pt.setString(4, memberVO.getSex());
			daoManager.pt.setString(5, memberVO.getBirthday());
			daoManager.pt.setString(6, memberVO.getEmail());

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
		daoManager =AppManager.getInstance().getDAOManager(); 
		memberVO = AppManager.getInstance().getDataManager().getMemberVO();
		
		daoManager.connectDB();
		String sql= "SELECT * FROM memberVOber WHERE memberVOber_id = ?";
		try {
			daoManager.pt = daoManager.con.prepareStatement(sql);
			daoManager.pt.setString(1, memberVO.getId());
			rs=daoManager.pt.executeQuery();
			//--------------------아이디와 비밀번호가 같다면 회원정보를 불러와 저장-------------------//
			if(rs.next()) {
				if(memberVO.getPwd().equals(rs.getString(3))) {
					memberVO.setId(rs.getString("memberVO_id"));
					memberVO.setPwd(rs.getString("memberVO_pwd"));
					memberVO.setName(rs.getString("memberVO_name"));
					memberVO.setSex(rs.getString("memberVO_sex"));
					memberVO.setBirthday(rs.getString("memberVO_birthday"));
					memberVO.setEmail(rs.getString("memberVO_email"));
					return true;
				}
			}
			rs.close();
			daoManager.closeDB();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	//------------------------------중복검사------------------------------//
	boolean idCheck() {
		daoManager =AppManager.getInstance().getDAOManager(); 
		memberVO = AppManager.getInstance().getDataManager().getMemberVO();
		

		daoManager.connectDB();
		String sql="SELECT memberVOber_id FROM memberVOber";

		try {
			daoManager.pt=daoManager.con.prepareStatement(sql);
			rs= daoManager.pt.executeQuery();
			while(rs.next()) {
				if(memberVO.getId().equals(rs.getString(1)))
					return false;
			}
			rs.close();
			daoManager.closeDB();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return true;
	}
}