package exams;

public class Doctor {

    final static int BASE_SALARY = 50_000;
    public int numberOfPenalizations;
    public String name;
    public int salary;

    public Doctor(String name) {
        this.name = name;
        salary = BASE_SALARY;
    }

    public void diagnose() {
        System.out.println("Figuring out what's wrong with you...");
        salary += 10_000;
    }

}
