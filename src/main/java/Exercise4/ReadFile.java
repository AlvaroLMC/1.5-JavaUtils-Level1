package Exercise4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\rquer\\Documents\\IdeaProjects\\1.5-JavaUtils-Level1\\countries.txt");

        if (!file.exists()) {
            System.out.println("The file does not exist: " + file.getAbsolutePath());
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
