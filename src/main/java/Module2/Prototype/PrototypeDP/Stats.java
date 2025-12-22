package Module2.Prototype.PrototypeDP;

public class Stats implements Prototype<Stats>{
    int health;
    int mana;

    public Stats(int health, int mana) {
        this.health = health;
        this.mana = mana;
    }

    Stats(Stats stats){
        this.health = stats.health;
        this.mana = stats.mana;
    }

    public String getStats() {
        return "HP: " + health + ", Mana: " + mana;
    }

    @Override
    public Stats clone(){
        return new Stats(this);
    }
}
