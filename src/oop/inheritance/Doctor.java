package oop.inheritance;

public class Doctor {
    final static int BASE_SALARY = 50000;

   public String name;
    public int salary;

    public Doctor(String name){
        this.name = name;
        salary = BASE_SALARY;
    }

    public void diagnose(){
        System.out.println("Figuring out what's wrong with you...");
        salary += 10000;
    }

    @Override
    public String toString() {
        return name + ", Salary: " + salary;
    }
}
