package vlastni.OOP.inheritance;

public class CardiacSurgeon extends Surgeon{
    final static int CS_BONUS = 35_000;
    CardiacSurgeon(String name) {
        super(name);
        salary += CS_BONUS;
    }
    void cardiacSurgery(){
        System.out.println("Cut my heart in to pieces...");
        salary += 30_000;
    }
}
