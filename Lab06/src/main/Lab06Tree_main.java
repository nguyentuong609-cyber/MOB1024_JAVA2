package main;

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
					System.out.print("Ender node name:");
					String nodeName = scanner.nextLine();
					System.out.print("Ender Parent ID:");
					int parentID = Integer.parseInt(scanner.nextLine());
					System.out.print("Enter Level: ");
					int level = Integer.parseInt(scanner.nextLine());
					
					Tree treeAdd = new Tree();
					treeAdd.setNode_name(nodeName);
					treeAdd.setParent_id(parentID);
					treeAdd.setLevel(level);
					
					treeRepo.insertTree(treeAdd);
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
					System.out.print("Insert ID to delete: ");
					int id = Integer.parseInt(scanner.nextLine());
					Boolean deleted = treeRepo.deleteTree(id);
					if (deleted) {
						System.out.println("Successful Deletion");
					}else {
						System.out.println("Cant delete with " + id);
					}
				}
				
				
				case 5 -> {
					System.out.println("Case 5: Update Tree");
					System.out.print("Insert ID to update: ");
					int id = Integer.parseInt(scanner.nextLine());
					System.out.print("Ender node name:");
					String nodeName = scanner.nextLine();
					System.out.print("Ender Parent ID:");
					int parentID = Integer.parseInt(scanner.nextLine());
					System.out.print("Enter Level: ");
					int level = Integer.parseInt(scanner.nextLine());
					
					Tree treeUpdate = new Tree(id, nodeName, parentID, level);
					
					Boolean updated = treeRepo.updateTree(treeUpdate);
					if (updated) { 
						System.out.println("Successfully Updated");
					}
					else {
						System.out.println("Update failed");
						}
					
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
