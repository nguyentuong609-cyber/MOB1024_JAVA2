package MainFolder;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class DocumentService {
	private Map<String, Document> documents = new LinkedHashMap<>();
	
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
        if (documents.containsKey(doc.getDocumentId())) {
            throw new Exception("Duplicate document ID!");
        }
        documents.put(doc.getDocumentId(), doc);
    }
	
	// find document by ID.
	public Document findById(String id) {
        return documents.get(id);
    }

	
	// delete document by ID
    public void deleteDocument(String id) throws Exception {
        if (!documents.containsKey(id)) {
            throw new Exception("Document not found!");
        }
        documents.remove(id);
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
	    int statusChoice = Integer.parseInt(sc.nextLine());

	    switch (statusChoice) {
	    case 1: addCopy.setStatus(CopyStatus.NEW); break;
	    case 2: addCopy.setStatus(CopyStatus.GOOD); break;
	    case 3: addCopy.setStatus(CopyStatus.USED); break;
	    default: 
	        System.out.println("Invalid choice, default = NEW");
	        addCopy.setStatus(CopyStatus.NEW);
	}

	    return addCopy;
	}
	
	// apply the copy to the document
	public void addCopyToDocument(String docId, Copy copy) throws Exception {
	    Document doc = findById(docId);
	    if (doc == null) {
	        throw new Exception("Document not found!");
	    }
	    copy.setDocumentId(docId);
	    doc.addCopy(copy);
	}
	
	// edit document
    public void updateDocument(String id, String newTitle, String newAuthor, String newCategory, int newPublishYear) {
        Document doc = findById(id);
        if (doc == null) throw new IllegalArgumentException("Document not found!");
        doc.setTitleDoc(newTitle);
        doc.setAuthorDoc(newAuthor);
        doc.setCategoryDoc(newCategory);
        doc.setPublishYearDoc(newPublishYear);
    }
	
	// View all documents
    public void displayAllDocuments() {
        if (documents.isEmpty()) {
            System.out.println("No documents found.");
            return;
        }
        for (Document d : documents.values()) {
            System.out.println(d);
        }
    }

	
	// Remove a copy from the it's document.
    public void removeCopyFromDocument(String docId, String copyId) throws Exception {
        Document doc = findById(docId);
        if (doc == null) throw new Exception("Document not found!");
        doc.removeCopy(copyId);
    }
	
    public void displayAllCopies() {
        if (documents.isEmpty()) {
            System.out.println("No documents found.");
            return;
        }
        for (Document d : documents.values()) {
            System.out.println("Document ID : " + d.getDocumentId());
            System.out.println("Title       : " + d.getTitleDoc());
            if (d.getCopies().isEmpty()) {
                System.out.println("  No copies.");
            } else {
                for (Copy c : d.getCopies().values()) { // ← .values() instead of direct loop
                    System.out.println("  " + c);
                }
            }
            System.out.println("----------------------");
        }
    }
    
    public Map<String, Document> getAllDocuments() {
        return documents;
    }

}