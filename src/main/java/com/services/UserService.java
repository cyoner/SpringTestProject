package com.services;
import java.util.List;

import com.models.Impl.User;

public interface UserService {
	

	public List getUserList();
	public void addUser(User user);
	public void dropUser(String uid);
	public void updateUser(User user);

	public User getUserInfo(User user);
	public boolean checkUser(String uid);
	public int checkSignIn(String id, String pw);
	public boolean checkId(String id);

}
