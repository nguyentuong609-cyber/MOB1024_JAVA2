package MainFolder;

public class Copy {
	private String copyId;
	private String documentId;
	private CopyStatus status;
	

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

	public CopyStatus getStatus() {
		return status;
	}

	public void setStatus(CopyStatus status) {
		this.status = status;
	}

	public Copy(String copyId, String documentId, CopyStatus status) {
		this.copyId = copyId;
		this.documentId = documentId;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Copy [copyId=" + copyId + ", documentId=" + documentId + ", status=" + status + "]";
	}
	
	
}
