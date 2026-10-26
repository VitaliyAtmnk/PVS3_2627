package student.oop.inheritance.hunters;

public class Hunter {
    String name;
    public int gold = 10;


    public void hunt() {
        System.out.println(name+": killing deer");
        gold =+ 5;
    }

    public Hunter(String name) {
        this.name = name;
    }
}

class Soldier extends Hunter {



    public void killBandits(){
        System.out.println(name+": raiding enemies");
        gold =+ 16;
    }


    public Soldier(String name) {
        super(name);
        gold =+ 20;
    }
}

class Witcher extends Soldier {



    public void slayMonster() {
        System.out.println(name + " is hunting for a monster.");
        gold += 150;
    }

    @Override
    public void hunt() {
        System.out.println(name + " is hunting a beast... and he's very good at it.");
        gold += 25;
    }


    public Witcher(String name){
        super(name);
        gold =+ 50;
    }
}
