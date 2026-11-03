package vyuka.oop.inheritance.hunters;

public class Hunter {
    int gold;
    String name;
    String job;

    public Hunter(String name) {
        this.gold = 10;
        this.name = name;
    }

    public Hunter(String name, String job) {
        this(name);
        this.job = job;
    }

    public void hunt() {
        System.out.println(name + " is hunting a beast.");
        gold += 10;
    }
}
