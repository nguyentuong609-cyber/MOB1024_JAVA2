package MainFolder;

import java.util.Scanner;

public class ASM_main {

	static void mainMenu() {
		String menu = """
				1. Add Document.
				2. Display documents.
				3. Edit Document.
				4. Delete Document.
				5. Add Document Copy.
				6. Display Document Copy.
				7. Document Copy Status.

				Choose a number:
				""";
		System.out.print(menu);
	}

	static void clearScreen() {
		for (int i = 0; i < 30; i++) {
			System.out.println();
		}
	}

	static void promptEnterKey(Scanner scanner) {
		System.out.println("Press \"ENTER\" to continue...");
		scanner.nextLine();
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		DocumentService list = new DocumentService();

		do {
			clearScreen();
			mainMenu();
			while (true) {
			    try {
			        choice = Integer.parseInt(sc.nextLine());
			        break;
			    } catch (Exception e) {
			        System.out.print("Invalid input. Enter a number: ");
			    }
			}
			switch (choice) {
				case 1:
					clearScreen();
					while (true) {
						try {
							System.out.println("Adding a document:");
		                    Document addDoc = list.createDocument(sc);
		                    list.addDocument(addDoc);
		                    System.out.println(" Document added!");
		                    promptEnterKey(sc);
		                } catch (IllegalArgumentException e) {
		                    System.out.println("Invalid input: " + e.getMessage());
		                } catch (Exception e) {
		                    System.out.println("Error: " + e.getMessage());
		                }
						
						System.out.print("Continue ? (y/n): ");
						if (sc.nextLine().equalsIgnoreCase("n")) 
							break;
					}
					promptEnterKey(sc);
					break;
				    
				case 2:
					clearScreen();
					System.out.println("Display all Documents: ");
					list.displayAllDocuments();
					promptEnterKey(sc);
					break;
					
				case 3:
					clearScreen();
					System.out.println("Editing document: ");
					while(true) {
						System.out.print("Enter Document ID to edit: ");
					    String editId = sc.nextLine();
					    
					    try {
					        System.out.print("New title: ");
					        String newTitle = sc.nextLine();

					        System.out.print("New author: ");
					        String newAuthor = sc.nextLine();
					        
					        System.out.print("New category: ");
					        String newCategory = sc.nextLine();
					        
					        System.out.print("New published year: ");
					        int newYear = Integer.parseInt(sc.nextLine());

					        list.updateDocument(editId, newTitle, newAuthor, newCategory, newYear);
					        System.out.println("Document updated!");
					    } catch (Exception e) {
					        System.out.println(e.getMessage());
					    }
					    System.out.print("Continue ? (y/n): ");
						if (sc.nextLine().equalsIgnoreCase("n")) 
							break;
					    
					}
					
					promptEnterKey(sc);
					break;
					
				case 4:
				    clearScreen();
				    
				    while(true) {
				    	System.out.print("Enter Document ID to delete: ");
					    String deleteId = sc.nextLine();

					    list.deleteDocument(deleteId);

					    System.out.println("Delete operation completed.");
					    System.out.print("Continue ? (y/n): ");
						if (sc.nextLine().equalsIgnoreCase("n")) 
							break;
				    }
				    promptEnterKey(sc);
				    break;
				    
				case 5:
					clearScreen();
				    System.out.print("Enter Document ID: ");
				    String docId = sc.nextLine();

				    try {
				        Copy copy = list.createCopy(sc);
				        list.addCopyToDocument(docId, copy);
				        System.out.println("Copy added!");
				    } catch (Exception e) {
				        System.out.println(e.getMessage());
				    }

				    promptEnterKey(sc);
				    break;
				    
				case 6:
					clearScreen();
				    System.out.print("Enter Document ID: ");
				    String viewId = sc.nextLine();

				    Document doc = list.findById(viewId);

				    if (doc == null) {
				        System.out.println("Document not found!");
				    } else {
				       
				    }

				    promptEnterKey(sc);
				    break;
				case 8:
					clearScreen();
					System.out.println("Good Bye");
					break;
				
				default:
				    System.out.println("Invalid choice!");
				    promptEnterKey(sc);
				    break;
			}
		} while (choice != 8);
	}
}
