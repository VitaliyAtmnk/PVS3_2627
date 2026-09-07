package vyuka.basics;

public class Country {
    protected String name;
    protected String continent;
    protected Double population;
    protected Double avgAge;

    Country(String name, String continent, double population, double avgAge){
        this.name = name;
        this.continent = continent;
        this.population = population;
        this.avgAge = avgAge;
    }

    void printCountry(){
        System.out.println(name+" je na kontinentu "+ continent +", má "+ population +" obyvatel a průměrná délka života je "+avgAge+" roku.");
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
