package main;

import java.util.List;
import java.util.Scanner;

import entity.Tree;
import repository.TreeRepository;

public class Lab06Tree_main {
	static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		
		TreeRepository treeRepo = new TreeRepository();
		boolean running = true;
		
		while(running) {
			printMenu();
			int choice = getChoice();
			
			switch(choice) {
				case 1 -> {
					System.out.println("Case 1: Add Tree");
					
				}
				case 2 -> {
					System.out.println("Case 2: Display All Tree");
					treeRepo.showAll();
				}
				case 3 -> {
					System.out.println("Case 3: Find via ID");
					System.out.print("Input ID to find:");
					int id = Integer.parseInt(scanner.nextLine());
					treeRepo.showByID(id);
				}
				case 4 -> {
					System.out.println("Case 4: Remove Tree");
					
				}
				case 5 -> {
					System.out.println("Case 5: Update Tree");
					
					}
				case 0 -> {
						System.out.println("Case 0: Exiting");
						running = false;
					}
			}
		}
		
//		DISPLAY EVERYTHING
//		TreeRepository treerepo = new TreeRepository();
//		List<Tree> list = treerepo.findAll();
//		list.stream().forEach(System.out::println);
	}
	
    static void printMenu() {
        System.out.println("\n===== MENU =====");
        System.out.println("1. Add Tree");
        System.out.println("2. Display All Tree");
        System.out.println("3. Find Tree via ID");
        System.out.println("4. Remove Tree");
        System.out.println("5. Update Tree");
        System.out.println("0. Exit");
        System.out.print("Your choice: ");
    }
    static int getChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
