package com.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataConnection {

	public static void main(String[] args) {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/productdb?characterEncoding=utf8";
			con =DriverManager.getConnection(url, "root", "root");
			String sql="insert into product (prod_id,prod_description,prod_name,prod_price,prod_quantity) values (?,?,?,?,?)";
			PreparedStatement pst =con.prepareStatement(sql);
			pst.setInt(1, 11);
			pst.setString(2, "Tables");
			pst.setString(3, "Micromax");
			pst.setInt(4, 4500);
			pst.setInt(5, 8);
			int i = pst.executeUpdate();
			System.out.println("Row inserted.."+i);
		} catch (ClassNotFoundException | SQLException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
