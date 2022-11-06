package com.java;

public class Product {
	private int prod_id;
	private String prod_description;
	private String prod_name;
	private int prod_price;
	private int prod_quantity;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int prod_id, String prod_description, String prod_name, int prod_price, int prod_quantity) {
		super();
		this.prod_id = prod_id;
		this.prod_description = prod_description;
		this.prod_name = prod_name;
		this.prod_price = prod_price;
		this.prod_quantity = prod_quantity;
	}

	public int getProd_id() {
		return prod_id;
	}

	public void setProd_id(int prod_id) {
		this.prod_id = prod_id;
	}

	public String getProd_description() {
		return prod_description;
	}

	public void setProd_description(String prod_description) {
		this.prod_description = prod_description;
	}

	public String getProd_name() {
		return prod_name;
	}

	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}

	@Override
	public String toString() {
		return "Product [prod_id=" + prod_id + ", prod_description=" + prod_description + ", prod_name=" + prod_name
				+ ", prod_price=" + prod_price + ", prod_quantity=" + prod_quantity + "]";
	}

	public int getProd_price() {
		return prod_price;
	}

	public void setProd_price(int prod_price) {
		this.prod_price = prod_price;
	}

	public int getProd_quantity() {
		return prod_quantity;
	}

	public void setProd_quantity(int prod_quantity) {
		this.prod_quantity = prod_quantity;
	}
	
	
}
