
package com.movie.DAO;

import java.sql.ResultSet;

import com.movie.VO.MemberVO;
import com.movie.main.AppManager;

public class SignUpDAO {
	DAOManager daomanager = AppManager.getInstance().getDAOManager();
	MemberVO m = AppManager.getInstance().getDataManager().getMemberVO();

	ResultSet rs = null;
	String sql = null;

	public SignUpDAO() {
		AppManager.getInstance().getDAOManager().setSignupDAO(this);
	}

	public int insertMember(MemberVO m) {
		int re = -1;
		try {
			daomanager.connectDB();
			sql = "insert into member values(?,?,?,?,?,?)";
			daomanager.pt = daomanager.con.prepareStatement(sql);
			daomanager.pt.setString(1, m.getId());
			daomanager.pt.setString(2, m.getPwd());
			daomanager.pt.setString(3, m.getName());
			daomanager.pt.setString(4, m.getSex());
			daomanager.pt.setString(5, m.getBirthday());
			daomanager.pt.setString(6, m.getEmail());
			re = daomanager.pt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				daomanager.closeDB();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} // finally
		return re;
	}

	public int selectIdcheck(String m) {
		int re = -1;
		try {
			daomanager.connectDB();
			sql = "select * from member where member_id = ? ";
			daomanager.pt = daomanager.con.prepareStatement(sql);
			daomanager.pt.setString(1, m);
			rs = daomanager.pt.executeQuery();

			if (rs.next()) {// 검색된 코드가 있다면 참
				re = 1;// 중복 아이디 있음
			} else {
				re = 0;// 중복 아이디 없음
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				daomanager.closeDB();
				if(rs!=null) rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return re;
	}
}
