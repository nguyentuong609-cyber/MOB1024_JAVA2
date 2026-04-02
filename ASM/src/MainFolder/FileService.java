package MainFolder;


import java.io.*;
import java.util.*;

public class FileService {
	private static final String FILE_PATH = "documents.txt";
	
	
	// SAVE FILE
	public static void saveToFile(Map<String, Document> documents) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {

            for (Document d : documents.values()) {
                // write document line
                writer.write(
                    d.getDocumentId() + "," +
                    d.getTitleDoc() + "," +
                    d.getAuthorDoc() + "," +
                    d.getCategoryDoc() + "," +
                    d.getPublishYearDoc()
                );
                writer.newLine();

                // write each copy line
                for (Copy c : d.getCopies().values()) {
                    writer.write(
                        c.getCopyId() + "," +
                        c.getDocumentId() + "," +
                        c.getStatus()
                    );
                    writer.newLine();
                }
            }

            System.out.println("Data saved!");

        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }
	
	
	// LOAD FILE
	 public static void loadFromFile(DocumentService service) {
	        File file = new File(FILE_PATH);

	        // if no file exists yet, skip loading
	        if (!file.exists()) {
	            System.out.println("No saved data found, starting fresh.");
	            return;
	        }

	        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
	            String line;
	            Document currentDoc = null;

	            while ((line = reader.readLine()) != null) {
	                String[] parts = line.split(",");

	                if (parts.length == 5) {
	                    // its a document line
	                    // DOC001,Java Book,John Smith,Technology,2023
	                    currentDoc = new Document(
	                        parts[0], // documentId
	                        parts[1], // title
	                        parts[2], // author
	                        parts[3], // category
	                        Integer.parseInt(parts[4]) // year
	                    );
	                    service.addDocument(currentDoc);

	                } else if (parts.length == 3) {
	                    // its a copy line
	                    // COPY001,DOC001,GOOD
	                    if (currentDoc != null) {
	                        Copy copy = new Copy(
	                            parts[0], // copyId
	                            parts[1], // documentId
	                            CopyStatus.valueOf(parts[2]) // status
	                        );
	                        service.addCopyToDocument(parts[1], copy);
	                    }
	                }
	            }

	            System.out.println("Data loaded!");

	        } catch (IOException e) {
	            System.out.println("Error loading file: " + e.getMessage());
	        } catch (Exception e) {
	            System.out.println("Error: " + e.getMessage());
	        }
	    }
}
