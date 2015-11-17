package com.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.models.Impl.User;
import com.services.UserService;


@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/index")
	public String mainPage() {
		return "index";
	}
	
	
	@RequestMapping(value = "/login")
	public String login() {
		return "login/login";
	}
	
	@RequestMapping(value = "/UpdateUser")
	public String updateUser() {
		return "login/UpdateUser";
	}
	
	@RequestMapping(value = "/getUserListPage")
	public String getUserListPage() {
		return "login/UserList";
	}
	
	@RequestMapping(value = "/signUp")
	public String signUp() {
		return "login/SignUp";
	}
	
	@RequestMapping(value = "/welcome")
	public String welcome() {
		return "Main/welcome";
	}
	
	@RequestMapping(value="/getUserList")
	public @ResponseBody Map<String , Object> getUserList() {
		
	    Map<String, Object> jsonObject = new HashMap<String, Object>();
	    jsonObject.put("result_list", userService.getUserList());

	    return jsonObject; 

	}
	
		
	@RequestMapping( value="/addUser", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody void addUser(@RequestBody User user) {
		userService.addUser(user);
	}
	
	@RequestMapping( value="/checkUser", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody boolean checkUser(@RequestBody User user) {
		return userService.checkUser(user.getId());
	}
	@RequestMapping( value="/getUser", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody User getUser(@RequestBody User user) {
		return userService.getUserInfo(user);
	}
	
	@RequestMapping( value="/checkSignIn", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody int checkSignIn(@RequestBody User user) {
		return userService.checkSignIn(user.getId(), user.getPasswd());
	}
		
	@RequestMapping( value="/updateUser", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody void updateUser(@RequestBody User user) {
		userService.updateUser(user);
	}

	@RequestMapping( value="/dropUser", method = RequestMethod.POST, produces = "application/json")
	public @ResponseBody void dropUser(@RequestBody String uid) {
		userService.dropUser(uid);

	}

	
	
	//public int checkSignIn(String id, String pw);
	
	/*public List getUserList();


	public User getUserInfo(User user);
	public boolean checkUser(String uid);
	public int checkSignIn(String id, String pw);
	public boolean checkId(String id);*/
}
