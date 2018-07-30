package cn.edu.lingnan.usersys.usermgr.domain;

import java.util.Date;

public class UserVO {
	private String uno;     //主键
	private String uname;   //姓名
	private String passwd;  //密码
	private String superuser;  //权限
	private String sex;     //性别
	private Date birth;     //生日
	private String mail;    //邮箱
	private int status;     //是否可见（状态）
	
	public String getUno() {
		return uno;
	}
	public void setUno(String uno) {
		this.uno = uno;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getSuperuser() {
		return superuser;
	}
	public void setSuperuser(String superuser) {
		this.superuser = superuser;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

}
