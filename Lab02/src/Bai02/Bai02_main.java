package Bai02;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Bai02.Product.ProductCategory;

public class Bai02_main {
	public static void main(String[] args) {
		ArrayList<Product> list = new ArrayList<Product>();
		
		list.add(new Product("F001", "Chicken", 500, Product.ProductCategory.FOOD));
		list.add(new Product("F002", "Beef", 650, Product.ProductCategory.FOOD));
		list.add(new Product("F003", "Rice", 200, Product.ProductCategory.FOOD));

		list.add(new Product("E001", "Laptop", 15000, Product.ProductCategory.ELECTRONIC));
		list.add(new Product("E002", "Smartphone", 8000, Product.ProductCategory.ELECTRONIC));

		list.add(new Product("C001", "T-Shirt", 300, Product.ProductCategory.CLOTHING));
		list.add(new Product("C002", "Jeans", 700, Product.ProductCategory.CLOTHING));
		list.add(new Product("C003", "Jacket", 1200, Product.ProductCategory.CLOTHING));
		
		for(Product x : list) {
			x.printProduct();
			System.out.println("");
		}
		
		
		Map<ProductCategory, Integer> map = new HashMap<ProductCategory, Integer>();
		for(Product x : list) {
			ProductCategory type = x.getCategory();
			
			if(map.containsKey(type)) {
				map.put(type, map.get(type) +1);
			}
			else {
				map.put(type, 1);
			}
		}
		
		System.out.println("So Luong SP: ");
		for(ProductCategory type : map.keySet()) {
			System.out.println(type + " : " + map.get(type));
		}
		
		Map<ProductCategory, Double> map2 = new HashMap<Product.ProductCategory, Double>();
		for(Product x : list) {
			ProductCategory type = x.getCategory();
			double price = x.getPrice();
			
			if(map2.containsKey(type)) {
				map2.put(type, map2.get(type) + price);
			}
			else {
				map2.put(type, price);
			}
		}
		
		
		System.out.println("Tinh tong: ");
		for(ProductCategory type : map2.keySet()) {
			System.out.println(type + " : " + map2.get(type));
		}
	}
}
