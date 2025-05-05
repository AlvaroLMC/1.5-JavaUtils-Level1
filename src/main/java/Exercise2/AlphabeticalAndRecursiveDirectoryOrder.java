package Exercise2;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class AlphabeticalAndRecursiveDirectoryOrder {
    public static void main(String[] args) {
        File Directory = new File("C:\\Users\\rquer\\Documents\\IdeaProjects\\1.5-JavaUtils-Level1\\ContabilidadEmpresa");

        if (Directory.exists() && Directory.isDirectory()) {
            listDirectoryContents(Directory, 0);
        } else {
            System.out.println("The provided path is not valid.");
        }
    }

    public static void listDirectoryContents(File dir, int depth) {
        File[] items = dir.listFiles();

        if (items != null) {
            Arrays.sort(items, (a, b) -> a.getName().compareToIgnoreCase(b.getName()));

            for (File item : items) {
                String type = item.isDirectory() ? "(D)" : "(F)";
                String lastModified = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                        .format(new Date(item.lastModified()));

                String indent = "  ".repeat(depth);

                System.out.println(indent + type + " " + item.getName() + " - Last modified: " + lastModified);

                if (item.isDirectory()) {
                    listDirectoryContents(item, depth + 1);
                }
            }
        } else {
            System.out.println("Could not access contents of: " + dir.getName());
        }
    }
}
