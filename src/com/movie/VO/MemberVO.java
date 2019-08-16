package com.movie.VO;

import com.movie.main.AppManager;

public class MemberVO {
	
	//---회원관련 VO 생성---//
	private String id;
	private String pwd;
	private String name;
	private String sex;
	private String birth;
	private String email;
	
	public MemberVO() {
		AppManager.getInstance().getDataManager().setMemberVO(this);
	}
	
	public void resetMemberVO() {
		setId(null);
		setPwd(null);
		setName(null);
		setSex(null);
		setBirth(null);
		setEmail(null);
	}
	
	// ------------------------------ set ----------------------------- //
	public void setId(String id) 			{   	this.id = id;				}
	public void setPwd(String pwd) 			{		this.pwd = pwd;				}
	public void setName(String name) 		{		this.name = name;			}
	public void setSex(String sex) 			{ 		this.sex = sex;				}
	public void setBirth(String birth)		{		this.birth = birth;			}
	public void setEmail(String email) 		{		this.email = email;			}

	// ------------------------------ get ----------------------------- //
	public String getId() 					{		return id;			}
	public String getPwd() 					{ 	  	return pwd;			}
	public String getName() 				{	 	return name; 		}
	public String getSex() 					{	  	return sex;			}
	public String getBirth() 				{ 		return birth;		}
	public String getEmail() 				{	  	return email;		}
	
	
}
