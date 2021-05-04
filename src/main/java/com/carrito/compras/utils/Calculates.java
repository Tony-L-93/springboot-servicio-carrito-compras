package com.carrito.compras.utils;

import java.util.ArrayList;
import java.util.List;

import com.carrito.compras.model.Product;

public class Calculates {

	public static List<Float> totalPrice(List<Product> products) {
		List<Float> infoPrice = new ArrayList<>();
		float discount = 0;
		float totalPrice = (float) products.stream().mapToDouble(p -> p.getPrice()).sum();

		if (products.size() >= 5 && products.size() < 10) {
			totalPrice = (float) (totalPrice * 0.95);
			discount = 95;
		}
		if (products.size() >= 10) {
			totalPrice = (float) (totalPrice * 0.90);
			discount = 90;
		}
		infoPrice.add(totalPrice);
		infoPrice.add(discount);
		return infoPrice;
	}

	public static List<Float> totalPricePromotion(List<Product> products, Double totalSpent) {
		List<Float> infoPrice = new ArrayList<>();
		float discount = 0;
		float totalPrice = (float) products.stream().mapToDouble(p -> p.getPrice()).sum();

		if (products.size() >= 5 && products.size() < 10) {
			totalPrice = (float) (totalPrice * 0.95);
			discount = 95;
		}
		if (products.size() >= 10) {
			if(totalSpent>=10000) {
				totalPrice = (float) ((totalPrice * 0.90)-500);
				discount = 90;
			}
			else {
			totalSpent=totalSpent*0.05;
			totalPrice = (float) ((totalPrice * 0.90)-totalSpent);
			discount = 90;
			}
		}
		infoPrice.add(totalPrice);
		infoPrice.add(discount);
		return infoPrice;
	}
}
