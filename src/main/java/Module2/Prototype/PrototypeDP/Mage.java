package Module2.Prototype.PrototypeDP;

public class Mage implements Prototype<Mage>{
    String name;
    Weapon weapon;
    Stats stats;
    AI ai;

    public Mage(String name, Weapon weapon, Stats stats, AI ai) {
        this.name = name;
        this.weapon = weapon;
        this.stats = stats;
        this.ai = ai;
    }

    Mage(Mage mage){
        this.name = mage.name;
        this.weapon = mage.weapon.clone();
        this.stats = mage.stats.clone();
        this.ai = mage.ai.clone();
    }

    public String getInfo() {
        return "Mage: " + name + " | Weapon: " + weapon.getDetails()
                + " | Stats: " + stats.getStats()
                + " | AI: " + ai.getBehavior();
    }

    @Override
    public Mage clone(){
        return new Mage(this);
    }
}
