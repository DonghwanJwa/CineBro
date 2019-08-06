package com.movie.DAO;

public class MemberVO {
	
	//---회원관련 VO 생성---//
	private String id;
	private String pwd;
	private String name;
	private String sex;
	private String birthday;
	private String email;
	
	public Member() {
		//싱글턴 넣을 생성자//
	}
	
	//------------------------------set-----------------------------//
	public void setId(String id) {
		this.id = id;
	}
	public void setPwd(String pw) {
		this.pwd = pwd;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	//------------------------------get-----------------------------//
	public String getId() {
		return id;
	}
	public String getPwd() {
		return pwd;
	}
	public String getName() {
		return name;
	}
	public String getSex() {
		return sex;
	}
	public String getBirthday() {
		return birthday;
	}
	public String getEmail() {
		return email;
	}
	
	
}
