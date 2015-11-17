package com.models.Impl;

public class User {
	
	private String id;
	private String passwd;
	private String passwd2;
	private String first_name;
	private String last_name;
	private int grade;
	private int index;
	private int loginState;
	private boolean verification;
	
	
	
	public int getLoginState() {
		return loginState;
	}

	public void setLoginState(int loginState) {
		this.loginState = loginState;
	}

	public User(String id, String passwd, String first_name, String last_name, int grade,
			boolean verification, int index) {
		super();
		this.id = id;
		this.passwd = passwd;
		this.first_name = first_name;
		this.last_name = last_name;
		this.grade = grade;
		this.index = index;
		this.verification = verification;
	}

	public User(String id, String passwd, String first_name, String last_name) {
		super();
		this.id = id;
		this.passwd = passwd;
		this.first_name = first_name;
		this.last_name = last_name;
		this.grade = 1;
		this.verification = false;
	}
	
	public User(String id, String passwd, String name, int index) {
		this.id = id;
		this.passwd = passwd;
		
		this.index = index;
	}
	
	public User() {
		this.id = null;
		this.passwd = null;
		
		this.index = 0;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPasswd() {
		return passwd;
	}
	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	
	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public boolean isVerification() {
		return verification;
	}

	public void setVerification(boolean verification) {
		this.verification = verification;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	
}
