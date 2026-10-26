package vyuka.oop.inheritance.hunters;

public class Witcher extends Soldier{
    public Witcher(String name) {
        super(name);
        gold += 50;
    }

    public Witcher(String name, String job) {
        super(name, job);
    }

    public void slayMonster() {
        System.out.println(name + " is hunting a monster.");
        gold += 250;
    }

    @Override
    public void hunt() {
        System.out.println(name + " is hunting a beast.. and he's very good at it!");
        gold += 50;
    }
}
