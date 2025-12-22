package Module2.Prototype.BoilerPlate;

public class Mage {
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

    public Mage() {
    }

    // Shallow Copy Constructor
    public Mage(Mage original) {
        this.name = original.name;
        this.weapon = original.weapon;
        this.stats = original.stats;
        this.ai = original.ai;
    }

    public String getInfo() {
        return "Mage: " + name + " | Weapon: " + weapon.getDetails()
                + " | Stats: " + stats.getStats()
                + " | AI: " + ai.getBehavior();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public AI getAi() {
        return ai;
    }

    public void setAi(AI ai) {
        this.ai = ai;
    }
}