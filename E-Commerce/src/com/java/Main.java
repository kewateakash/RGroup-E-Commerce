package com.java;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import com.jdbc.connection.Getusers;
import com.jdbc.connection.OrderDetails;
import com.jdbc.connection.ProductsList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Map<String, Integer> cart = new HashMap<>();
		String user_name = null;
		String Password = null;
		String role = null;
		boolean isLogin = false;

		System.out.println("--------------------------------------------------------");
		System.out.println("|              WelCome to E-commerce App               |");
		System.out.println("--------------------------------------------------------");

//		System.out.println("========================================================");
//		System.out.println(" 1) Admin                                    2) User");
//		System.out.println("========================================================");

		List<String> userList = Getusers.getUserNameList();
		List<String> passList = Getusers.getPasswordList();
		List<User> user = Getusers.getAllUsers();
		System.out.println("========================================================");
		System.out.println("       1) Login         ||         2) SignUp ");
		System.out.println("========================================================");
		System.out.println("If you are new here then Sign Up ");
		int a = sc.nextInt();
		if (a == 1) {
			System.out.println("Enter your user name :");
			user_name = sc.next();
			System.out.println("Enter your Password :");
			Password = sc.next();
			if (userList.contains(user_name) && passList.contains(Password)) {
				isLogin = true;
				System.out.println("        Welcome to E-commerce Site " + Password.substring(0, 1).toUpperCase()
						+ Password.substring(1));
			} else {
				System.out.println("you have entered wrong username or password");
			}
		} else if (a == 2) {
			System.out.println("Enter your user name :");
			user_name = sc.next();
			System.out.println("Enter your Password :");
			Password = sc.next();
			Getusers.addUser(user_name, Password);
			System.out.println("Sign Up Succesful..........");

			userList = Getusers.getUserNameList();
			passList = Getusers.getPasswordList();

			System.out.println("Enter your user name :");
			user_name = sc.next();
			System.out.println("Enter your Password :");
			Password = sc.next();
			if (userList.contains(user_name) && passList.contains(Password)) {
				isLogin = true;
				System.out.println(
						"Welcome to E-commerce Site " + Password.substring(0, 1).toUpperCase() + Password.substring(1));
			} else {
				System.out.println("you have entered wrong username or password");
			}
		}

		else {
			System.out.println("you have provided the wronge input");
		}

		List<Product> prodList = ProductsList.getProducts();
		Collections.sort(prodList, new ProdNameComparator());
		System.out.println("--------------------------------------------------------------");
		if (isLogin) {
			System.out.println("   For product List press 3 ");
			int c = sc.nextInt();
			if (c == 3) {
				System.out.println("--------------------List of Product----------------------");

				for (int i = 1; i <= prodList.size(); i++) {

					System.out.println("  " + i + ")  " + prodList.get(i - 1).getProd_name());
					System.out.println("----------------------------------------------------------");
				}
				// System.out.println("Choose the product you want to Buy.....");
				System.out.println("How many products you want to Buy");
				int x = sc.nextInt();
				for (int i = 1; i <= x; i++) {
					System.out.println("Enter the product number you want to buy.");
					int j = sc.nextInt();
					System.out.println("Enter the product Quantity you want to buy.");
					int q = sc.nextInt();
					OrderDetails.addOrder(prodList.get(j - 1).getProd_name(), user_name, q,
							q * prodList.get(j - 1).getProd_price());
					cart.put(prodList.get(j - 1).getProd_name(), q * prodList.get(j - 1).getProd_price());
				}
				System.out.println("------------------------------------------------------------------------");
				System.out.println("Your Cart items are as follows.............");
				int Cartprice = 0;
				Set<String> set = cart.keySet();
				for (String s : set) {
					System.out.println("Item : " + s + ",   Total Price :" + cart.get(s));
					Cartprice += cart.get(s);
				}
				System.out.println("------------------------------------------------------------------------");
				System.out.println("Your total cart price is : "+ Cartprice);
				System.out.println("------------------------------------------------------------------------");

				for (User i : user) {
					if (user_name.equals(i.getUserName())) {
						role = i.getRole();
					}
				}
				if (role.equals("Admin")) {
					System.out.println("Enter 4 to check list of all users");

					int d = sc.nextInt();
					if (d == 4) {

						for (User j : user) {
							System.out.println("User Id: " + j.getId() + ",  User Name : " + j.getUserName()
									+ ",  User Role : " + j.getRole());
							System.out.println("-------------------------------------------------------------------");
						}
					}
				}
				// System.out.println("Sorry !! you are not Authorised to see this List as you
				// are not ADMIN");
				if (role.equals("Admin")) {

					System.out.println("To Check the quantity of each product press 5");
					int g = sc.nextInt();
					if (g == 5) {
						System.out.println("Enter the Id of product you want to search");
						int j = sc.nextInt();
						Product prod = ProductsList.getProductById(j);

						System.out.println("Product Name : " + prod.getProd_name());
						System.out.println("Product Quantity : " + prod.getProd_quantity());
						System.out.println("---------------------------------------------------------");

					} else {
						System.out.println("Sorry !! you have entered wrong input");
					}

					System.out.println("---------------------------------------------------------");
					if (role.equals("Admin")) {
						System.out.println("Enter username for user, whose order history you want to check");
						String s = sc.next();
						List<Order> orderList = OrderDetails.getOrderDetails(s);
						for (Order i : orderList) {
							System.out.println("Order Id : " + i.getOrder_id());
							System.out.println("Order user : " + i.getUser_name());
							System.out.println("Order product : " + i.getProd_name());
							System.out.println("Order quantity : " + i.getQuantity());
							System.out.println("Total Cost : " + i.getTotal_cost());
							System.out.println("---------------------------------------------------------");
						}
					}
				} else {
					System.out.println("Sorry !! you are authenticated to move ahead as you are not Admin");
				}

			} else {
				System.out.println("Sorry !! you have entered wrong input");
			}

		}
	}
}