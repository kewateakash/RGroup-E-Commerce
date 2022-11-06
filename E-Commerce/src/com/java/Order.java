package com.java;

public class Order {
	private int order_id;
	private String prod_name;
	private String user_name;
	private int quantity;
	private int total_cost;
	
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Order(int order_id, String prod_name, String user_name, int quantity, int total_cost) {
		super();
		this.order_id = order_id;
		this.prod_name = prod_name;
		this.user_name = user_name;
		this.quantity = quantity;
		this.total_cost = total_cost;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public String getProd_name() {
		return prod_name;
	}

	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getTotal_cost() {
		return total_cost;
	}

	public void setTotal_cost(int total_cost) {
		this.total_cost = total_cost;
	}
	
	
	

}
