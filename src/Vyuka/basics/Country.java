package Vyuka.basics;

public class Country {
    String name;
    String continent;
    Long population;
    double avgAge;

    public Country(String name, String continent, Long population, double avgAge) {
        this.name = name;
        this.continent = continent;
        setPopulation(population);
        setAvgAge(avgAge);
    }

    public Country(String name, long population, double avgAge){
        this.name = name;
        this.continent = "Not Specified";
        setPopulation(population);
        setAvgAge(avgAge);

    }
    public  void setAvgAge (double avgAge){
        if (avgAge >= 20 && avgAge <= 101){
            this.avgAge = avgAge;
            return;
        }
        else {
            this.avgAge = 0.0d;
        }
    }

    public void setPopulation (long population){
        if (population < 10_000 || population > 2_000_000_000){
            System.out.println("Population out of range");
        }
        else{
            this.population = population;
        }
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", continent='" + continent + '\'' +
                ", population=" + population +
                ", avgAge=" + avgAge +
                '}';
    }
}

