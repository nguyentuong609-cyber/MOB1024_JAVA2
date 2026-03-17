package Lab1;

public class Product {
    private String iD;
    private String name;
    private double basePrice;

    

    // getters and setters
    // IDs names, and price must have value
    public String getiD() {
        return this.iD;
    }
//    public void setiD(String iD) {
//        if(iD == null){
//            throw new IllegalArgumentException("Product must have ID");
//        }
//        this.iD = iD;
//    }
    
    public boolean setiD(String id) {
    	if(id == null || id == " " ) {
    		this.iD = id;
    		return false;
    	}
    	return true;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        if(name == null){
            throw new IllegalArgumentException("Product must have name!");
        }
        this.name = name;
    }
    public double getBasePrice() {
        return basePrice;
    }
//    public void setBasePrice(double basePrice) {
//        if(basePrice <= 0){
//            throw new IllegalArgumentException("Product must have a price!");
//        }
//        this.basePrice = basePrice;
//    }
    
    public boolean setBasePrice(double basePrice) {
    	if(basePrice < 0) {
    		return false;
    	}
    	this.basePrice = basePrice;
    	return true;
    }

    //constructor
    public Product() {
    }

    public Product(String iD, String name, double basePrice) {
        setiD(iD);
        setName(name);
        setBasePrice(basePrice);
    }

    public void printProduct(){
        System.out.println("This product: " +this.iD);
        System.out.println("Name: " + this.name);
        System.out.println("Product's base price: " + this.basePrice);
    }

    //Tax
    public double finalPrice(){
        return this.basePrice;
    }
       
}