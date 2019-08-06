package com.movie.VO;

import com.movie.main.AppManager;

public class MemberVO {
	
	//***회원관련 VO 생성***//
	private String id;
	private String pwd;
	private String name;
	private String sex;
	private String birthday;
	private String email;
	
	public MemberVO() {
		AppManager.getInstance().getDataManager().setMemberVO(this);;
}
	
	//******************************set*****************************//
	public void setId(String id) {				this.id = id;	}
	public void setPwd(String pwd) {			this.pwd = pwd;	}
	public void setName(String name) {			this.name = name;	}
	public void setSex(String sex) { 			this.sex = sex;	}
	public void setBirthday(String birthday) {	this.birthday = birthday;	}
	public void setEmail(String email) {		this.email = email;	}

	//******************************get*****************************//
	public String getId() {		  return id;	}
	public String getPwd() { 	  return pwd; }
	public String getName() {	  return name; }
	public String getSex() {	  return sex;	}
	public String getBirthday() { return birthday; }
	public String getEmail() {	  return email;	}
	
	
}
