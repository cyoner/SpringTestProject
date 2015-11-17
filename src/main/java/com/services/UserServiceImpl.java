package com.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import com.models.Impl.User;



public class UserServiceImpl implements UserService{
	
	String url = "jdbc:mysql://localhost:3306/testRestFul";
	String id = "root";
	String pw = "123456";
	Connection con = null;
	ResultSet rs;
	Statement stmt;
	PreparedStatement ptmt; 
	String sql=null;
	
	public List getUserList(){
		List userlist = new ArrayList();
		User user = null;
		sql="select * from user";
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection(url, id, pw);
			stmt = con.createStatement();
			
			rs= stmt.executeQuery(sql);
			while (rs.next()) {
				user = new User(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getBoolean(6),rs.getInt(7));
				userlist.add(user);
			}
		} catch (Exception e) {
			System.out.println("DB load fail "+e.toString());
		}
		return userlist;
	}

	public void addUser( User user ){
		sql="insert into user( id, passwd, last_name, first_name, grade, verification) "
								+ "values (?,?,?,?,?,?) ";
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection(url, id, pw);
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, user.getId());
			ptmt.setString(2, user.getPasswd());
			ptmt.setString(3, user.getLast_name());
			ptmt.setString(4, user.getFirst_name());
			ptmt.setInt(5, 1);
			ptmt.setBoolean(6, false);
			int result = ptmt.executeUpdate();
		} catch (Exception e) {
			System.out.println("DB load fail "+e.toString());
		}
		
	}
	
	public boolean checkUser(String uid) {
		sql="select * from user where id = ?";
		boolean check=false;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection(url, id, pw);
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, uid);
			rs = ptmt.executeQuery();
			
			if(rs.next()) {check=true;}
			
		} catch (Exception e) {
			System.out.println("DB load fail "+e.toString());
		}
		return check;
	}
	
	public User getUserInfo(User user){
		
		User tempUser = null;
		int returnValue = 0;
		sql="select * from user where id = ?";
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection(url, id, pw);
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, user.getId());
			rs = ptmt.executeQuery();
			if(rs.next())
				tempUser = new User(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getBoolean(6),rs.getInt(7));
		} catch (Exception e) {
			System.out.println("DB load fail "+e.toString());
		}
		if (tempUser == null) {
			tempUser = user; 
		}
		return tempUser;
		
		
	}

	public int checkSignIn(String uid, String upw){
		
		User tempUser = null;
		int returnValue = 0;
		sql="select * from user where id = ?";
		System.out.println(uid + ' ' +  upw);
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection(url, id, pw);
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, uid);
			rs = ptmt.executeQuery();
			if(rs.next())
				tempUser = new User(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getBoolean(6),rs.getInt(7));
		} catch (Exception e) {
			System.out.println("DB load fail "+e.toString());
		}
		if (tempUser == null) returnValue = 1;
		else if ( !tempUser.getPasswd().equals(upw) ) returnValue = 2;
		else {
			returnValue = 3;
		}
		
		return returnValue;
	}
	
	public boolean checkId(String uid){
		
		User tempUser = null;
		boolean returnValue = false;
		sql="select * from user where id = ?";
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection(url, id, pw);
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, uid);
			rs = ptmt.executeQuery();
			
			if(rs.next())
				tempUser = new User(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5),rs.getBoolean(6),rs.getInt(7));
		} catch (Exception e) {
			System.out.println("DB load fail "+e.toString());
		}
		if (tempUser != null) returnValue = true; 
		
		return returnValue;
		
	}

	public int dropUser(String uid){
		sql="delete from user where id = ?";
		int numRows =0;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection(url, id, pw);
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, uid);
			numRows = ptmt.executeUpdate();  
		} catch (Exception e) {
		}
		return numRows;
	}
	public void updateUser(User user){
		System.out.println(1111);
		sql="update user set passwd=?, last_name=?, first_name=? where id = ?";
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con = DriverManager.getConnection(url, id, pw);
			ptmt = con.prepareStatement(sql);
			ptmt.setString(1, user.getPasswd());
			ptmt.setString(2, user.getLast_name());
			ptmt.setString(3, user.getFirst_name());
			ptmt.setString(4, user.getId());
			System.out.println(user.getId());
			int numRows = ptmt.executeUpdate();  
		} catch (Exception e) {
			System.out.println("DB load fail "+e.toString());
		}
	}

	
	
}
