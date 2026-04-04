package Bai01;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Lab05_main {
	public static void main(String[] args) {
		List<String> listName = Arrays.asList("Quốc Anh", "Cát Tường");
		String filePath = "data.txt";
		
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
			for(String name : listName) {
				writer.write(name);
				writer.newLine();
			}
			writer.close();
			System.out.println("Finished writing "+ filePath);
		} catch(IOException e) {
			System.out.println("Something went wrong: "+ e.getMessage());
		} finally {
			System.out.println("Finished writing file");
		}
		
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(filePath));
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}
			System.out.println("Finsihed loading the file");
		} catch (IOException e) {
			System.out.println("Error: " +e.getMessage());
		} finally {
			System.out.println("Finished loading the file");
		}
				
	}	
}
