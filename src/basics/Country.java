package basics;

public class Country {
    String name, continent;
    long population;
    double avgAge;

    // private static final int MAX_AVG_AGE = 101;
    // alt + insert

    public Country(String name, String continent, long population, double avgAge) {
        this.name = name;
        this.continent = continent;
        setPopulation(population); // 10_000 ... 2_000_000_000
        setAvgAge(avgAge);
    }

    public Country(String name, long population, double avgAge) {
        this.name = name;
        this.continent = "Not Specified";
        setPopulation(population);
        setAvgAge(avgAge);
    }

    public void setPopulation(long population) {
        if (population < 10_000 || population > 2_000_000_000) {
            System.out.println("Population out of range");
        } else {
            this.population = population;
        }
    }

    public void setAvgAge(double avgAge) {
        if (avgAge >= 20 && avgAge <= 101) {
            this.avgAge = avgAge;
        } else {
            this.avgAge = 0.0d;
        }
    }

    @Override
    public String toString() {
        return name + " (" + continent + ") [" + population + " people, average life expectancy: " + avgAge + "]";
    }
}
