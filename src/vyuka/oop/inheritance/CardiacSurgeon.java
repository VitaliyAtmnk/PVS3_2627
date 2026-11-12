package vyuka.oop.inheritance;

public class CardiacSurgeon extends Surgeon{

    final static int CS_BONUS = 35000;

    public CardiacSurgeon(String name) {
        super(name);
        salary += CS_BONUS;
    }

    void cardiacSurgery(){
        System.out.println("Cut my hearth into pieces");
        salary += 30000;
    }
}
