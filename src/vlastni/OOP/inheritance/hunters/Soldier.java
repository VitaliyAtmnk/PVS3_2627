package vlastni.OOP.inheritance.hunters;

public class Soldier extends Hunter{
    public Soldier(String name) {
        super(name);
        gold+=40;
    }
    public void killBandit(){
        System.out.println(name + " is going against bandits");
        gold+=100;
    }
}
