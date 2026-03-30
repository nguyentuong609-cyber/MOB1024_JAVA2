package MainFolder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DocumentService {
	private List<Document> documents = new ArrayList<Document>();
	
	//create a document
	public void createDocument(Scanner sc) {
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
				System.out.print("Document's title: ");
				addDoc.setTitleDoc(sc.nextLine());
				break;
			} catch (IllegalArgumentException e) {
				System.out.println("Error: "+e.getMessage());
			}
		}
		
		while(true) {
			try {
				System.out.print("Document's category: ");
				addDoc.setCategoryDoc(sc.nextLine());;
				break;
			} catch (IllegalArgumentException e) {
				System.out.println("Error: "+e.getMessage());
			}
		}
		
		while(true) {
			try {
				System.out.print("Document's published year: ");
				addDoc.setPublishYearDoc(sc.nextInt());;;
				break;
			} catch (IllegalArgumentException e) {
				System.out.println("Error: "+e.getMessage());
			}
		}
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
	
	public void addCopyToDocument(String docId, Copy copy) throws Exception {
	    Document doc = findById(docId);
	    if (doc == null) {
	        throw new Exception("Document not found!");
	    }
	    doc.addCopy(copy);
	}
	
	// Edit a single document
	public void updateDocument(String id, String newTitle, String newAuthor) {
	    Document doc = findById(id);
	    if (doc == null) throw new IllegalArgumentException("Document not found!");
	    doc.setTitleDoc(newTitle);
	    doc.setAuthorDoc(newAuthor);
	}
	
	// View all documents
	public List<Document> getAllDocuments() {
	    return documents;
	}
	
	// Remove a copy from a document
	public void removeCopyFromDocument(String docId, String copyId) throws Exception {
	    Document doc = findById(docId);
	    if (doc == null) throw new Exception("Document not found!");
	    doc.removeCopy(copyId);
	}

}
