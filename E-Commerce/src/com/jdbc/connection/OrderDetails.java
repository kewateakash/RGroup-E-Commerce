package com.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.Order;

public class OrderDetails {

	public static void addOrder(String prod_name, String user_name, int quantity, int total_price) {

		try {
			String sql = "insert into orderTable (prod_name,user_name, quantity, total_price) values(?,?,?,?)";
			// load driver class
			Class.forName("com.mysql.jdbc.Driver");
			// establish connection
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/orderdb?characterEncoding=utf8",
					"root", "root");
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, prod_name);
			pst.setString(2, user_name);
			pst.setInt(3, quantity);
			pst.setInt(4, total_price);
			pst.executeUpdate();
			// System.out.println("Rows updated>>" + i);

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static List<Order> getOrderDetails(String user_name) {
		Connection con = null;
		List<Order> order_Details = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/orderdb?characterEncoding=utf8";
			con = DriverManager.getConnection(url, "root", "root");
			String sql = "select * from orderTable where user_name = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, user_name);
			ResultSet result = pst.executeQuery();
			while (result.next()) {
				int order_id = result.getInt(1);
				// System.out.println(prod_id);
				String user = result.getString(2);
				String prod_name = result.getString(3);
				// System.out.println(prod_name);
				int prod_price = result.getInt(5);
				// System.out.println(prod_price);
				int prod_quantity = result.getInt(4);
				// System.out.println(prod_quantity);

				order_Details.add(new Order(order_id, prod_name, user, prod_quantity, prod_price));
			}

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return order_Details;

	}

}
