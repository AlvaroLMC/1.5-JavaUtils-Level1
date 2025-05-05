package Exercise5;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializeCountriesFromFile {
    public static void main(String[] args) {
        List<Country> countries = new ArrayList<>();
        File inputFile = new File("C:\\Users\\rquer\\Documents\\IdeaProjects\\1.5-JavaUtils-Level1\\countriesSER.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String name = parts[0].trim();
                    String capital = parts[1].trim();
                    int population = Integer.parseInt(parts[2].trim());

                    countries.add(new Country(name, capital, population));
                }
            }

            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("countries.ser"))) {
                oos.writeObject(countries);
                System.out.println("Countries serialized to countries.ser");
            }

        } catch (IOException e) {
            System.out.println("Error reading or writing: " + e.getMessage());
        }
    }
}