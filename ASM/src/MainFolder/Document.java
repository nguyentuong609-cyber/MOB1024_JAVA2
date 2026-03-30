package MainFolder;

import java.util.ArrayList;
import java.util.List;

public class Document {
	private String documentId;    
    private String titleDoc;         
    private String authorDoc;  
    private String categoryDoc;
    private int publishYearDoc;
    
	private List<Copy> copies;
    
    
    public String getDocumentId() {
		return documentId;
	}



	public void setDocumentId(String documentId) {
		if(documentId == null || documentId.isBlank()) {
			throw new IllegalArgumentException("ID must not be emptied");
		}
		this.documentId = documentId;
	}



	public String getTitleDoc() {
		return titleDoc;
	}



	public void setTitleDoc(String titleDoc) {
		if(titleDoc == null || titleDoc.isBlank()) {
			throw new IllegalArgumentException("Document must have a title");
		}
		this.titleDoc = titleDoc;
	}



	public String getAuthorDoc() {
		return authorDoc;
	}



	public void setAuthorDoc(String authorDoc) {
		if(authorDoc == null || authorDoc.isBlank()) {
			throw new IllegalArgumentException("Document must have author name");
		}
		this.authorDoc = authorDoc;
	}



	public String getCategoryDoc() {
		return categoryDoc;
	}



	public void setCategoryDoc(String categoryDoc) {
		this.categoryDoc = categoryDoc;
	}



	public int getPublishYearDoc() {
		return publishYearDoc;
	}



	public void setPublishYearDoc(int publishYearDoc) {
		this.publishYearDoc = publishYearDoc;
	}



	public List<Copy> getCopies() {
		return copies;
	}



	public void setCopies(List<Copy> copies) {
		this.copies = copies;
	}

	public Document() {}
	
	public Document(String documentId, String title, String author, String category,int publishYear) {
	    this.documentId = documentId;
	    this.titleDoc = title;
	    this.authorDoc = author;
	    this.categoryDoc = category;
	    this.publishYearDoc = publishYear;
	    this.copies = new ArrayList<>();  // starts empty
	}



	@Override
	public String toString() {
		return "Document [documentId=" + this.documentId + ", titleDoc=" + this.titleDoc + ", authorDoc=" + this.authorDoc
				+ ", categoryDoc=" + this.categoryDoc + ", publishYearDoc=" + this.publishYearDoc + ", copies=" + this.copies + "]";
	}
    
	public void addCopy(Copy copy) {
	    this.copies.add(copy);
	}
	
	public void removeCopy(String copyId) {
	    this.copies.removeIf(c -> c.getCopyId().equals(copyId));
	}

	public Copy findCopyById(String copyId) {
	    for (Copy c : this.copies) {
	        if (c.getCopyId().equals(copyId)) {
	            return c;
	        }
	    }
	    return null; // not found
	}
    
}
