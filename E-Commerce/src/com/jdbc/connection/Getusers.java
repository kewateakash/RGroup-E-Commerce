package com.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.User;

public class Getusers {

	public static List<String> getUserNameList() {

		Connection con = null;
		List<String> userList = new ArrayList<>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/userdb?characterEncoding=utf8";
			con = DriverManager.getConnection(url, "root", "root");
			String sql = "select * from user";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				
				String userName = rs.getString(2);
				userList.add(userName);
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return userList;
	}

	public static List<String> getPasswordList() {

		Connection con = null;
		List<String> passList = new ArrayList<>();

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/userdb?characterEncoding=utf8";
			con = DriverManager.getConnection(url, "root", "root");
			String sql = "select * from user";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet result = pst.executeQuery();

			while (result.next()) {
				passList.add(result.getString(3));
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return passList;
	}

	public static int addUser(String userName, String pass) {
		Connection con = null;
		int i = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/userdb?characterEncoding=utf8";
			con = DriverManager.getConnection(url, "root", "root");
			String sql = "insert into user (user_name, user_pass, user_role) values (?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, userName);
			pst.setString(2, pass);
			pst.setString(3, "user");

			i = pst.executeUpdate();
			System.out.println("Rows updated>>" + i);

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	public static List<User> getAllUsers() {
		Connection con = null;
		List<User> users = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/userdb?characterEncoding=utf8";
			con = DriverManager.getConnection(url, "root", "root");
			String sql = "select * from user";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				int id = rs.getInt(1);
				String userName = rs.getString(2);
				String pass = rs.getString(3);
				String role = rs.getString(4);
				
				users.add(new User(id, userName, pass,role));	
			}
			

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;

	}
	public static void main(String[] args) {
//		List<User> user = getAllUsers();
//		
//		for(User i: user) {
//			System.out.println(i.getUserName());
//			System.out.println(i.getUserName() == "jamdhadetejas");
//			if(i.getUserName() == "jamdhadetejas") {
//				System.out.println("Ok");
//			}
//		}
//		System.out.println("---------------------");
//		for(int i=0; i<user.size();i++) {
//			System.out.println(user.get(i).getUserName());
//			System.out.println("jamdhadetejas".equals(user.get(i).getUserName()));
//			if(user.get(i).getUserName() == "jamdhadetejas") {
//				System.out.println("Ok");
//			}
//		}
	}

}