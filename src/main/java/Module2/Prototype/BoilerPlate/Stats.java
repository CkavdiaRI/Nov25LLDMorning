package Module2.Prototype.BoilerPlate;

public class Stats {
    int health;
    int mana;

    public Stats(int health, int mana) {
        this.health = health;
        this.mana = mana;
    }

    public String getStats() {
        return "HP: " + health + ", Mana: " + mana;
    }
}