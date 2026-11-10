package vlastni.basics;

import java.util.Comparator;

public class Country implements Comparable<Country>{
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


    @Override
    public  int compareTo(Country o) {

        return Integer.compare(this.name.length(),o.name.length());
    }
    public static Comparator<Country> BY_AVG_AGE = new Comparator<Country>() {
        @Override
        public int compare(Country o1, Country o2) {
            return Double.compare(o1.avgAge,o2.avgAge);
        }
    };
    public static Comparator<Country> BY_POPULATION = new Comparator<Country>() {
        @Override
        public int compare(Country o1, Country o2) {
            return Long.compare(o1.population,o2.population);
        }
    };
    public static Comparator<Country> BY_CONTINENT = new Comparator<Country>() {
        @Override
        public int compare(Country o1, Country o2) {
            return Double.compare(o1.population,o2.population);
        }
    };

}
