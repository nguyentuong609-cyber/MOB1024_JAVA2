package Bai01;
import java.util.ArrayList;



public class testLamba {
	public static void main(String[] args) {
		ArrayList<String> names = new ArrayList<>();

        names.add("Tony");
        names.add("Alexander");
        names.add("Chris");
        names.add("Jonathan");
        names.add("Linh");
        names.add("Michael");
        names.add("Anna");
        names.add("Sophia");
        names.add("David");
        names.add("Isabella");

        System.out.println("All names:");
        names.forEach(name -> System.out.println(name));
        
        for(String x : names) {
        	System.out.println(x);
        }

        System.out.println("\nNames length > 5:");
        names.stream()
             .filter(name -> name.length() > 5)
             .filter(name -> name.contains("L"))
             .forEach(name -> System.out.println(name));
// 			 .forEach(System.out :: printLn)
        
//        for(String x : names) {
//        	if(x.length() > 5) {
//        		System.out.println(x);
//        	}
//        }

        System.out.println("\nSorted A-Z:");
        names.stream()
             .sorted()
             .forEach(name -> System.out.println(name));

        System.out.println("\nSorted by length:");
        names.stream()
             .sorted((a, b) -> a.length() - b.length())
             .forEach(name -> System.out.println(name));
	}
}