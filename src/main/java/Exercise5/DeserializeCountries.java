package Exercise5;

import java.io.*;
import java.util.List;

public class DeserializeCountries {
    public static void main(String[] args) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("countries.ser"))) {
            List<Country> countries = (List<Country>) ois.readObject();

            System.out.println("Deserialized countries:");
            for (Country country : countries) {
                System.out.println(country);
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Deserialization error: " + e.getMessage());
        }
    }
}