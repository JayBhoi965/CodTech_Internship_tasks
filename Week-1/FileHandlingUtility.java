import java.io.*;
import java.util.Scanner;

public class FileHandlingUtility {

    // File name
    static String fileName = "sample.txt";

    // Method to write into file
    public static void writeFile() {
        try {
            FileWriter writer = new FileWriter(fileName);

            writer.write("Hello Jay!\n");
            writer.write("Welcome to CODTECH Internship.\n");
            writer.write("This is a File Handling Utility Program.");

            writer.close();

            System.out.println("Data successfully written into file.");

        } catch (IOException e) {
            System.out.println("Error while writing file.");
            e.printStackTrace();
        }
    }

    // Method to read file
    public static void readFile() {
        try {
            File file = new File(fileName);

            Scanner reader = new Scanner(file);

            System.out.println("\nReading File Content:\n");

            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                System.out.println(data);
            }

            reader.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            e.printStackTrace();
        }
    }

    // Method to modify file content
    public static void modifyFile() {
        try {
            File file = new File(fileName);

            BufferedReader reader = new BufferedReader(new FileReader(file));

            StringBuilder oldContent = new StringBuilder();
            String line;

            // Read old content
            while ((line = reader.readLine()) != null) {
                oldContent.append(line).append("\n");
            }

            reader.close();

            // Replace text
            String newContent = oldContent.toString().replace(
                    "CODTECH Internship",
                    "CODTECH Java Internship"
            );

            // Write modified content back
            FileWriter writer = new FileWriter(file);

            writer.write(newContent);

            writer.close();

            System.out.println("\nFile modified successfully.");

        } catch (IOException e) {
            System.out.println("Error while modifying file.");
            e.printStackTrace();
        }
    }

    // Main method
    public static void main(String[] args) {


        // Write data
        writeFile();

        // Read file
        readFile();

        // Modify file
        modifyFile();

        // Read modified file
        System.out.println("\nAfter Modification:\n");

        readFile();
    }
}