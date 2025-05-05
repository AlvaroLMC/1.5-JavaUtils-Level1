package Exercise3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class AlphabeticalAndRecursiveDirectoryOrderTXT {
    public static void main(String[] args) {
        File directory = new File("C:\\Users\\rquer\\Documents\\IdeaProjects\\1.5-JavaUtils-Level1\\ContabilidadEmpresa");
        File output = new File("directory.txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(output))) {
            listDirectoryContents(directory, 0, writer);
            System.out.println("Content written to: " + output.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error writing the file: " + e.getMessage());
        }
    }

    public static void listDirectoryContents(File dir, int depth, BufferedWriter writer) throws IOException {
        if (dir.exists() && dir.isDirectory()) {
            File[] contents = dir.listFiles();

            if (contents != null) {
                Arrays.sort(contents, (a, b) -> a.getName().compareToIgnoreCase(b.getName()));

                for (File file : contents) {
                    String indentation = "  ".repeat(depth); // visual indentation
                    String type = file.isDirectory() ? "D" : "F";
                    String lastModified = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                            .format(new Date(file.lastModified()));

                    writer.write(indentation + type + " - " + file.getName() + " - " + lastModified + "\n");

                    if (file.isDirectory()) {
                        listDirectoryContents(file, depth + 1, writer);
                    }
                }
            } else {
                writer.write("  ".repeat(depth) + "[Could not read the directory contents]\n");
            }
        } else {
            writer.write("[Invalid path or not a directory]\n");
        }
    }
}