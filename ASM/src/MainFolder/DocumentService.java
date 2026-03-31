package MainFolder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DocumentService {
	private List<Document> documents = new ArrayList<Document>();
	
	//create a document
	public Document createDocument(Scanner sc) {
		Document addDoc = new Document();
		
		while(true) {
			try {
				System.out.print("Document's ID: ");
				addDoc.setDocumentId(sc.nextLine());
				break;
			} catch (IllegalArgumentException e) {
				System.out.println("Error: "+e.getMessage());
			}
		}
		
		while(true) {
			try {
				System.out.print("Document's title: ");
				addDoc.setTitleDoc(sc.nextLine());
				break;
			} catch (IllegalArgumentException e) {
				System.out.println("Error: "+e.getMessage());
			}
		}
		
		while(true) {
			try {
				System.out.print("Document's author: ");
				addDoc.setAuthorDoc(sc.nextLine());
				break;
			} catch (IllegalArgumentException e) {
				System.out.println("Error: "+e.getMessage());
			}
		}
		
		
		while(true) {
			try {
				System.out.print("Document's category: ");
				addDoc.setCategoryDoc(sc.nextLine());
				break;
			} catch (IllegalArgumentException e) {
				System.out.println("Error: "+e.getMessage());
			}
		}
		
		while(true) {
			try {
				System.out.print("Document's published year: ");
				addDoc.setPublishYearDoc(Integer.parseInt(sc.nextLine()));
				break;
			} catch (IllegalArgumentException e) {
				System.out.println("Error: "+e.getMessage());
			}
		}
		
		return addDoc;
	}
	
	//add document to the list.
	public void addDocument(Document doc) throws Exception { 
	    for (Document d : documents) {
	        if (d.getDocumentId().equals(doc.getDocumentId())) {
	            throw new Exception("Duplicate document ID!");
	        }
	    }
	    documents.add(doc);
	}
	// find document by ID.
	public Document findById(String id) {
	    for (Document d : documents) {
	        if (d.getDocumentId().equals(id)) {
	            return d;
	        }
	    }
	    return null;
	}
	
	public void deleteDocument(String id) {
	    documents.removeIf(d -> d.getDocumentId().equals(id));
	}
	
	//create copy of the document.
	public Copy createCopy(Scanner sc) {
	    Copy addCopy = new Copy();

	    while(true) {
	        try {
	            System.out.print("Copy ID: ");
	            addCopy.setCopyId(sc.nextLine());
	            break;
	        } catch (IllegalArgumentException e) {
	            System.out.println("Error: " + e.getMessage());
	        }
	    }

	    System.out.println("Select Status: ");
	    System.out.println("1. NEW");
	    System.out.println("2. GOOD");
	    System.out.println("3. USED");
	    System.out.print("Choose: ");
	    int statusChoice = sc.nextInt();
	    sc.nextLine();

	    switch (statusChoice) {
	    case 1: addCopy.setStatus(CopyStatus.Status.NEW); break;
	    case 2: addCopy.setStatus(CopyStatus.Status.GOOD); break;
	    case 3: addCopy.setStatus(CopyStatus.Status.USED); break;
	    default: 
	        System.out.println("Invalid choice, default = NEW");
	        addCopy.setStatus(CopyStatus.Status.NEW);
	}

	    return addCopy;
	}
	
	public void addCopyToDocument(String docId, Copy copy) throws Exception {
	    Document doc = findById(docId);
	    if (doc == null) {
	        throw new Exception("Document not found!");
	    }
	    doc.addCopy(copy);
	}
	
	// Edit a single document
	public void updateDocument(String id, String newTitle, String newAuthor, String newCategory, int newPublishYear) {
	    Document docFound = findById(id);
	    if (docFound == null) throw new IllegalArgumentException("Document not found!");
	    docFound.setTitleDoc(newTitle);
	    docFound.setAuthorDoc(newAuthor);
	    docFound.setCategoryDoc(newCategory);
	    docFound.setPublishYearDoc(newPublishYear);
	}
	
	// View all documents
	public void displayAllDocuments() {
	    for (Document d : documents) {
	        System.out.println(d);
	    }
	}
	
	public List<Document> getAllDocuments() {
	    return documents;
	}
	
	// Remove a copy from the it's document.
	public void removeCopyFromDocument(String docId, String copyId) throws Exception {
	    Document doc = findById(docId);
	    if (doc == null) throw new Exception("Document not found!");
	    doc.removeCopy(copyId);
	}
	
	public void displayAllCopies() {
	    for (Document d : documents) {
	        System.out.println("Document ID: " + d.getDocumentId());
	        System.out.println("Title: " + d.getTitleDoc());

	        if (d.getCopies().isEmpty()) {
	            System.out.println("  No copies.");
	        } else {
	            for (Copy c : d.getCopies()) {
	                System.out.println("  " + c);
	            }
	        }

	        System.out.println("----------------------");
	    }
	}

}
