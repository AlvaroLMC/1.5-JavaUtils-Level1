package Exercise1;

import java.io.File;
import java.util.Arrays;

public class AlphabeticalOrderDirectory {
    public static void main(String[] args) {
        File directory = new File("C:\\Users\\rquer\\Documents\\IdeaProjects\\1.5-JavaUtils-Level1\\ContabilidadEmpresa");

        if (directory.exists() && directory.isDirectory()) {
            File[] contents = directory.listFiles();

            if (contents != null) {
                Arrays.sort(contents, (a, b) -> a.getName().compareToIgnoreCase(b.getName()));

                for (File element : contents) {
                    System.out.println(element.getName());
                }
            } else {
                System.out.println("Could not read the directory contents.");
            }
        } else {
            System.out.println("The provided path is not valid.");
        }
    }
}