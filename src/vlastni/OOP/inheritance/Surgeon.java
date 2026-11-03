package vlastni.OOP.inheritance;

public class Surgeon extends Doctor {
    final static int SURGEON_BONUS = 2500;

    Surgeon(String name) {
        super(name);
        salary += SURGEON_BONUS;
    }
    void surgery(){
        System.out.println("Cuttin you open");
        salary += 20000;
    }
}
