package Bai02;

public class Product {
	public enum ProductCategory {
		FOOD,
		ELECTRONIC,
		CLOTHING
	}
	
	private String ID;
	private String Name;
	private double Price;
	private ProductCategory Category;
	
	public String getID() {
		return ID;
	}
	
	public void setID(String iD) {
		this.ID = iD;
	}
	
	public String getName() {
		return Name;
	}
	
	public void setName(String name) {
		this.Name = name;
	}
	
	public double getPrice() {
		return Price;
	}
	
	public void setPrice(double price) {
		this.Price = price;
	}
	
	public ProductCategory getCategory() {
		return Category;
	}
	
	public void setCategory(ProductCategory category) {
		this.Category = category;
	}
	
	public Product() {}
	
	public Product(String iD, String name, double price, ProductCategory category) {
		ID = iD;
		Name = name;
		Price = price;
		Category = category;
	}
	
	public void printProduct() {
		System.out.println("ID: " + getID());
		System.out.println("Name: "+ getName());
		System.out.println("Price: " + getPrice());
		System.out.println("Product Category: " + getCategory());
	}
	
	
}
