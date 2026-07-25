import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Java File Handling - Practical Guide
 * Demonstrates: creating a folder, creating a file, writing to a file,
 * reading a file, and deleting a file, using proper exception handling.
 */
public class FileHandlingDemo {

    public static void main(String[] args) {

        // File paths used throughout the program
        String folderPath = "MyFolder";
        String filePath = "MyFolder/data.txt";

        createFolder(folderPath);
        createFile(filePath);
        writeToFile(filePath);
        readFile(filePath);
        deleteFile(filePath);
    }

    /**
     * Creates a new folder using the File class.
     */
    public static void createFolder(String folderPath) {
        File folder = new File(folderPath);
        try {
            if (folder.mkdir()) {
                System.out.println("Folder created successfully: " + folderPath);
            } else {
                System.out.println("Folder already exists: " + folderPath);
            }
        } catch (SecurityException e) {
            System.out.println("Error: Unable to create folder due to security restrictions.");
            e.printStackTrace();
        }
    }

    /**
     * Creates a new file using the File class.
     */
    public static void createFile(String filePath) {
        File file = new File(filePath);
        try {
            if (file.createNewFile()) {
                System.out.println("File created successfully: " + filePath);
            } else {
                System.out.println("File already exists: " + filePath);
            }
        } catch (IOException e) {
            System.out.println("Error: An IOException occurred while creating the file.");
            e.printStackTrace();
        }
    }

    /**
     * Writes text content into the file using the FileWriter class.
     */
    public static void writeToFile(String filePath) {
        // try-with-resources automatically closes the FileWriter
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write("Java File Handling Practical Guide\n");
            writer.write("This file was created and written using FileWriter.\n");
            writer.write("Line 3: File handling operations completed.\n");
            System.out.println("Data written successfully to: " + filePath);
        } catch (IOException e) {
            System.out.println("Error: An IOException occurred while writing to the file.");
            e.printStackTrace();
        }
    }

    /**
     * Reads and displays the content of the file using the Scanner class.
     */
    public static void readFile(String filePath) {
        File file = new File(filePath);
        // try-with-resources automatically closes the Scanner
        try (Scanner reader = new Scanner(file)) {
            System.out.println("\n--- Reading file content ---");
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                System.out.println(line);
            }
            System.out.println("--- End of file content ---\n");
        } catch (IOException e) {
            System.out.println("Error: An IOException occurred while reading the file.");
            e.printStackTrace();
        }
    }

    /**
     * Deletes the file using the File class.
     */
    public static void deleteFile(String filePath) {
        File file = new File(filePath);
        try {
            if (file.delete()) {
                System.out.println("File deleted successfully: " + filePath);
            } else {
                System.out.println("Error: Failed to delete the file. It may not exist.");
            }
        } catch (SecurityException e) {
            System.out.println("Error: Unable to delete file due to security restrictions.");
            e.printStackTrace();
        }
    }
}
