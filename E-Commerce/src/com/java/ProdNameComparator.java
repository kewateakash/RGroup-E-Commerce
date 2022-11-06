package com.java;

import java.util.Comparator;

public class ProdNameComparator implements Comparator<Product> {

	@Override
	public int compare(Product p1, Product p2) {
		// TODO Auto-generated method stub
		return p1.getProd_name().compareTo(p2.getProd_name());
	}

}
