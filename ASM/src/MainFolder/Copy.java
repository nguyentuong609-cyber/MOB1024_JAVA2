package MainFolder;

import MainFolder.CopyStatus.Status;

public class Copy {
	private String copyId;
	private String documentId;
	private Status status;
	

	public String getCopyId() {
		return copyId;
	}

	public void setCopyId(String copyId) {
	    if (copyId == null || copyId.isBlank()) {
	        throw new IllegalArgumentException("Copy ID must not be empty");
	    }
	    this.copyId = copyId;
	}

	public String getDocumentId() {
		return documentId;
	}

	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	public Copy () {}

	public Copy(String copyId, String documentId, Status status) {
		this.copyId = copyId;
		this.documentId = documentId;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Copy [copyId=" + this.copyId + ", documentId=" + this.documentId + ", status=" + this.status + "]";
	}
	
	
}
