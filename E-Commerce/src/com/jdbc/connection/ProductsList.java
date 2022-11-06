package com.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.Product;

public class ProductsList {

	public static List<Product> getProducts() {

		Connection con = null;
		List<Product> product = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/productdb?characterEncoding=utf8";
			con = DriverManager.getConnection(url, "root", "root");
			String sql = "select * from product";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet result = pst.executeQuery();
			while (result.next()) {
				int prod_id = result.getInt(1);
				// System.out.println(prod_id);
				String prod_description = result.getString(2);
				// System.out.println(prod_description);
				String prod_name = result.getString(3);
				// System.out.println(prod_name);
				int prod_price = result.getInt(4);
				// System.out.println(prod_price);
				int prod_quantity = result.getInt(5);
				// System.out.println(prod_quantity);

				product.add(new Product(prod_id, prod_description, prod_name, prod_price, prod_quantity));
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

		return product;

	}

	public static Product getProductById(int id) {
		
		Product prod = null;
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/productdb?characterEncoding=utf8";
			con = DriverManager.getConnection(url, "root", "root");
			String sql = "select * from product where prod_id = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet result = pst.executeQuery();
			while (result.next()) {
				int prod_id = result.getInt(1);
				// System.out.println(prod_id);
				String prod_description = result.getString(2);
				// System.out.println(prod_description);
				String prod_name = result.getString(3);
				// System.out.println(prod_name);
				int prod_price = result.getInt(4);
				// System.out.println(prod_price);
				int prod_quantity = result.getInt(5);
				// System.out.println(prod_quantity);
				
				prod = new Product(prod_id, prod_description, prod_name, prod_price, prod_quantity);
				
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

		return prod;

	}

	public static void main(String[] args) {
		// addOrder("Xiaomi TV", 2, 0);

//		List<Product> list =getProducts();
//		
//		for(Product i :list) {
//			System.out.println(i);
//			System.out.println(i.getProd_id());
//			System.out.println(i.getProd_description());
//			System.out.println(i.getProd_name());
//			System.out.println(i.getProd_price());
//			System.out.println(i.getProd_quantity());
//			System.out.println("+++++++++++++++++++++++++++++");
//		}
	}

}
