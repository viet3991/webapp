package model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	private List<Product> items; // list of item in cart

	// constructor
	public Cart() {
		this.items = new ArrayList<Product>();
	}
	
	// add a new product to cart
	public void add(Product p) {
		for(Product x : items) {
			if (p.getId() == x.getId()) {
				x.setNumber(x.getNumber() + 1);
				return;
			}
		}
		items.add(p);
	}
	
	// sub a new product to cart
		public void sub(Product p) {
			for(Product x : items) {
				if (p.getId() == x.getId()) {
					if (x.getNumber() >= 2) {
						x.setNumber(x.getNumber() - 1);
						return;
					} else {
						return;
					} 	
				}
			}
		items.add(p);

		}
	
	// remove a product from cart
	public void remove(int id) {
		for (Product x : items) {
			if (x.getId() == id) {
				items.remove(x);
				return;
			}
		}
	}
	
	// return total amount of cart
	public double getAmount() {
		double sum = 0;
		for (Product x : items) {
			sum += x.getPrice() * x.getNumber();
		}
		return Math.round(sum * 100.0) / 100.0;
	}
	
	// return list of product in cart
	public List<Product> getItems() {
		return this.items;
	}
}
