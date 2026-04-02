package MainFolder;

import java.util.LinkedHashMap;
import java.util.Map;

public class Document {
	private String documentId;    
    private String titleDoc;         
    private String authorDoc;  
    private String categoryDoc;
    private int publishYearDoc;
    
    private Map<String, Copy> copies = new LinkedHashMap<>();
    
    
    public String getDocumentId() {
		return documentId;
	}



	public void setDocumentId(String documentId) {
		if(documentId == null || documentId.isBlank()) {
			throw new IllegalArgumentException("ID must not be emptied.");
		}
		this.documentId = documentId;
	}



	public String getTitleDoc() {
		return titleDoc;
	}



	public void setTitleDoc(String titleDoc) {
		if(titleDoc == null || titleDoc.isBlank()) {
			throw new IllegalArgumentException("Document must have a title.");
		}
		this.titleDoc = titleDoc;
	}



	public String getAuthorDoc() {
		return authorDoc;
	}



	public void setAuthorDoc(String authorDoc) {
		if(authorDoc == null || authorDoc.isBlank()) {
			throw new IllegalArgumentException("Document must have author name.");
		}
		this.authorDoc = authorDoc;
	}



	public String getCategoryDoc() {
		return categoryDoc;
	}



	public void setCategoryDoc(String categoryDoc) {
		if(categoryDoc == null || categoryDoc.isBlank()) {
			throw new IllegalArgumentException("Document must have a category.");
		}
		this.categoryDoc = categoryDoc;
	}



	public int getPublishYearDoc() {
		return publishYearDoc;
	}



	public void setPublishYearDoc(int publishYearDoc) {
		if(publishYearDoc < 0) {
			throw new IllegalArgumentException("Document must have a valid year.");
		}
		this.publishYearDoc = publishYearDoc;
	}



	public Map<String, Copy> getCopies() {
		return copies;
	}



	public void setCopies(Map<String,Copy> copies) {

		this.copies = copies;
	}

	
	public Document() {
	    this.copies = new LinkedHashMap<String, Copy>();
	}
	
	public Document(String documentId, String title, String author, String category,int publishYear) {
	    this.documentId = documentId;
	    this.titleDoc = title;
	    this.authorDoc = author;
	    this.categoryDoc = category;
	    this.publishYearDoc = publishYear;
	    this.copies = new LinkedHashMap<String, Copy>();  // starts empty
	}



	@Override
	public String toString() {
		return "Document [documentId=" + this.documentId + ", titleDoc=" + this.titleDoc + ", authorDoc=" + this.authorDoc
				+ ", categoryDoc=" + this.categoryDoc + ", publishYearDoc=" + this.publishYearDoc + ", copies=" + this.copies + "]";
	}
    
	// addCopy
	public void addCopy(Copy copy) throws Exception {
	    if (copies.containsKey(copy.getCopyId())) {
	    	throw new IllegalArgumentException("Duplicate ID");
	    }
	    copies.put(copy.getCopyId(), copy);
	}
	
	public void removeCopy(String copyId) throws Exception {
	    if (!copies.containsKey(copyId)) {
	        throw new Exception("Copy not found!");
	    }
	    copies.remove(copyId);
	}

	public Copy findCopyById(String copyId) {
	    return copies.get(copyId);
	}
    
}
