package student.basics;

import java.util.Comparator;

public class Country implements Comparable<Country> {
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

//   public static Comparator<Country> SORT_PER_LENGTH = new Comparator<Country>() {
//       @Override
//       public int compare(Country o1, Country o2) {
//           return Integer.compare(o1.name.length(), o2.name.length());
//       }
//   };


    public static Comparator<Country> SORT_BY_LIVES =   new Comparator<Country>() {
        @Override
        public int compare(Country o1, Country o2) {
            return Integer.compare((int) o1.avarigeAge , (int) o2.avarigeAge);
        }
    };


    @Override
    public int compareTo(Country o) {
        return Integer.compare(this.name.length(), o.name.length());
    }
}

