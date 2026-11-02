package oop.inheritance.hunters;

public class Hunter {
    int gold;
    String name;

    public Hunter(String name) {
        this.gold = 10;
        this.name = name;
    }

    public void hunt(){
        System.out.println(name + " is hunting a beast.");
        gold += 10;
    }

    @Override
    public String toString() {
        return "Hunter{" +
                "gold=" + gold +
                ", name='" + name + '\'' +
                '}';
    }
}
