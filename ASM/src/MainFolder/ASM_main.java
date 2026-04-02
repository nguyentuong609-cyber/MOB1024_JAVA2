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
				8. Remove copy from document.
				9. Exit.

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
		
		//Load data when program starts
		FileService.loadFromFile(list);

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
					while (true) {
						clearScreen();
						try {
							System.out.println("Adding a document:");
		                    Document addDoc = list.createDocument(sc);
		                    list.addDocument(addDoc);
		                    System.out.println(" Document added!");
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
				    while(true) {
				    	System.out.println("Editing document: ");
				        System.out.print("Enter Document ID to edit: ");
				        String editId = sc.nextLine();
				        
				        Document editDoc = list.findById(editId);
				        if (editDoc == null) {
				            System.out.println("Document not found!");
				        } else {
				            // Title
				            while(true) {
				                try {
				                    System.out.print("New title: ");
				                    editDoc.setTitleDoc(sc.nextLine());
				                    break;
				                } catch (IllegalArgumentException e) {
				                    System.out.println("Error: " + e.getMessage());
				                }
				            }

				            // Author
				            while(true) {
				                try {
				                    System.out.print("New author: ");
				                    editDoc.setAuthorDoc(sc.nextLine());
				                    break;
				                } catch (IllegalArgumentException e) {
				                    System.out.println("Error: " + e.getMessage());
				                }
				            }

				            // Category
				            while(true) {
				                try {
				                    System.out.print("New category: ");
				                    editDoc.setCategoryDoc(sc.nextLine());
				                    break;
				                } catch (IllegalArgumentException e) {
				                    System.out.println("Error: " + e.getMessage());
				                }
				            }

				            // Year
				            while(true) {
				                try {
				                    System.out.print("New published year: ");
				                    editDoc.setPublishYearDoc(Integer.parseInt(sc.nextLine()));
				                    break;
				                } catch (IllegalArgumentException e) {
				                    System.out.println("Error: " + e.getMessage());
				                }
				            }

				            System.out.println("Document updated!");
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
				    	System.out.println("Delete Document.");
				        System.out.print("Enter Document ID to delete: ");
				        String deleteId = sc.nextLine();

				        try {
				            list.deleteDocument(deleteId);
				            System.out.println("Document deleted!");
				        } catch (Exception e) {
				            System.out.println("Error: " + e.getMessage());
				        }

				        System.out.print("Continue ? (y/n): ");
				        if (sc.nextLine().equalsIgnoreCase("n")) 
				            break;
				    }
				    promptEnterKey(sc);
				    break;
				    
				case 5:
					clearScreen();
					while(true) {
						System.out.println("Add Document Copy:");
					    System.out.print("Enter Document ID: ");
					    String docId = sc.nextLine();

					    try {
					        Copy copy = list.createCopy(sc);
					        list.addCopyToDocument(docId, copy);
					        System.out.println("Copy added!");
					    } catch (Exception e) {
					        System.out.println(e.getMessage());
					    }
					    
					    System.out.print("Continue ? (y/n): ");
				        if (sc.nextLine().equalsIgnoreCase("n")) 
				            break;
					}
				    promptEnterKey(sc);
				    break;
				    
				case 6:
				    clearScreen();
				    System.out.println("Display Document Copy:");
				    System.out.print("Enter Document ID: ");
				    String viewId = sc.nextLine();

				    Document viewDoc = list.findById(viewId);

				    if (viewDoc == null) {
				        System.out.println("Document not found!");
				    } else {
				        if (viewDoc.getCopies().isEmpty()) {
				            System.out.println("No copies found for this document.");
				        } else {
				            System.out.println("Copies for Document: " + viewId);
				            System.out.println("----------------------");
				            for (Copy c : viewDoc.getCopies().values()) {
				                System.out.println(c);
				            }
				        }
				    }

				    promptEnterKey(sc);
				    break;
				    
				case 7:
				    clearScreen();
				    System.out.println("View Copy Status:");
				    System.out.print("Enter Document ID: ");
				    String statusDocId = sc.nextLine();

				    Document statusDoc = list.findById(statusDocId);
				    if (statusDoc == null) {
				        System.out.println("❌ Document not found!");
				    } else {
				        System.out.print("Enter Copy ID: ");
				        String statusCopyId = sc.nextLine();

				        Copy foundCopy = statusDoc.findCopyById(statusCopyId);
				        if (foundCopy == null) {
				            System.out.println("Copy not found!");
				        } else {
				            System.out.println("Copy ID : " + foundCopy.getCopyId());
				            System.out.println("Status  : " + foundCopy.getStatus());
				        }
				    }

				    promptEnterKey(sc);
				    break;
				    
				case 8:
					clearScreen();
					while(true) {
						System.out.println("Delete copy from document");
						System.out.print("Enter Document ID: ");
					    String deleteDocId = sc.nextLine();

					    Document deleteDoc = list.findById(deleteDocId);
					    if (deleteDoc == null) {
					        System.out.println("❌ Document not found!");
					    }else {
					        System.out.print("Enter Copy ID: ");
					        String deleteCopyId = sc.nextLine();

					        Copy deleteCopy = deleteDoc.findCopyById(deleteCopyId);
					        if (deleteCopy == null) {
					            System.out.println("Copy not found!");
					        } else {
					        	try {
					        		list.removeCopyFromDocument(deleteDocId, deleteCopyId);
					        		System.out.println("Copy deleted!");
					        	} catch (Exception e){
					        		System.out.println("Error: " + e.getMessage());
					        	}
					            
					        }
					    }
					    
					    System.out.print("Continue ? (y/n): ");
				        if (sc.nextLine().equalsIgnoreCase("n")) 
				            break;
					}
					
					promptEnterKey(sc);
					break;
					
				case 9:
					clearScreen();
					FileService.saveToFile(list.getAllDocuments());
					System.out.println("Good Bye");
					break;
				
				default:
				    System.out.println("Invalid choice!");
				    promptEnterKey(sc);
				    break;
			}
		} while (choice != 9);
		sc.close();
	}
}