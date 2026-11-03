package vyuka.oop.inheritance;

public class Surgeon extends Doctor{
    final static int SURGEON_BONUS = 25000;
    public Surgeon(String name) {
        super(name);
        salary += SURGEON_BONUS;
    }

    void surgery() {
        System.out.println("Cutting you open...");
        salary += 20000;
    }
}
