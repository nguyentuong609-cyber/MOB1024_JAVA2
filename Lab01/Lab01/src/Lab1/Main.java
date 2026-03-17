package Lab1;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Comparator;

public class Main {
	 public static void main(String[] args) {
	        ArrayList<Product> list = new ArrayList<>();
	        
//	        list.add(new Product("P01", "Pen", 20));
//	        list.add(new Product("P02", "Book", 100));
//	        list.add(new Product("P03", "Mouse", 150));
//
//	        list.add(new ImportedProduct("P04", "Laptop", 1000, 0.1, 20000));
//	        list.add(new ImportedProduct("P05", "Phone", 800, 0.15, 15000));
//
	        
	        
	        ImportedProductDAO dao = new ImportedProductDAO();
	        dao.NewImportedProduct();
	        list.add(dao);
	        
	        for(Product x : list){
	            x.printProduct();
	            System.out.println("");
	        }
	        
	    }
}
