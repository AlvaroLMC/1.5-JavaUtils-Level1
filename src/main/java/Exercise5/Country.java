package Exercise5;

import java.io.Serializable;

public class Country implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private String capital;
    private int population;

    public Country(String name, String capital, int population) {
        this.name = name;
        this.capital = capital;
        this.population = population;
    }

    @Override
    public String toString() {
        return "Country{name='" + name + "', capital='" + capital + "', population=" + population + '}';
    }
}