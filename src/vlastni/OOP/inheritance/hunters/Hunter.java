package vlastni.OOP.inheritance.hunters;

public class Hunter {
    String name;
    int gold;

    public Hunter(String name) {
        this.name = name;
        this.gold = 10;
    }

    public void hunt(){
        System.out.println(name + " is hunting a beast...");
        gold+=10;
    }
}
