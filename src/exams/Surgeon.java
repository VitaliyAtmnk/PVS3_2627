package exams;

public class Surgeon extends Doctor {
    final static int SURGEON_BONUS = 25_000;

    public Surgeon(String name) {
        super(name);
        salary += SURGEON_BONUS;
    }

    public void surgery() {
        System.out.println("Cutting you open...");
        salary += 20_000;
    }
}
