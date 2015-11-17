package com.services;
import java.util.List;

import com.models.Impl.User;

public interface UserService {
	
	public void addUser(User user);
	public void updateUser(User user);
	public boolean checkUser(String uid);
	public boolean checkId(String id);
	public int dropUser(String uid);
	public int checkSignIn(String id, String pw);
	public User getUserInfo(User user);
	public List getUserList();	
	
	

}
