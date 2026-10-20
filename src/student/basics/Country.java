package student.basics;

public class Country {
    String name;
    String continent;
    long population;
    double avarigeAge;

    public Country(String name, String continent, long population, double avarigeAge) {
        this.name = name;
        this.continent = continent;
        this.population = population;
        this.avarigeAge = avarigeAge;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", continent='" + continent + '\'' +
                ", population=" + population +
                ", avarigeAge=" + avarigeAge +
                '}';
    }
}
