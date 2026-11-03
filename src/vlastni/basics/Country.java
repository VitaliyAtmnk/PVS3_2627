package vlastni.basics;

public class Country {
    String name, continent;
    long population;
    double avgAge;

    //alt + insert - generovat constructor
    public Country(String name, String continent, long population, double avgAge) {
        this.name = name;
        this.continent = continent;
        setPopulation(population); //10_000 2_000_000_000
        setAvgAge(avgAge);

    }
    public Country(String name, long population, double avgAge) {
        this.name = name;
        this.continent = "Not specified";
        setPopulation(population);
        setAvgAge(avgAge);

    }

    public void setAvgAge(double avgAge) {
        if (avgAge > 100 || avgAge <20){
            this.avgAge = 0.0d;
        }
        else{
            this.avgAge = avgAge;}
    }

    public void setPopulation(long population) {
        if (population < 10000||population>2_000_000_000){
            System.out.println("population out of range");
        }
        else this.population = population;
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
