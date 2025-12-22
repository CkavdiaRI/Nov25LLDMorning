package Module2.Prototype;

class Weapon {
    String name;
    int damage;

    public Weapon(String name, int damage) {
        simulateHeavyLoad();
        this.name = name;
        this.damage = damage;
    }

    public Weapon(Weapon original) {
        this.name = original.name;
        this.damage = original.damage;
    }

    public void simulateHeavyLoad() {
        try {
            System.out.println("Loading heavy weapon data from disk...");
            Thread.sleep(1000); // simulate disk IO
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getDetails() {
        return name + " (Damage: " + damage + ")";
    }
}

class Stats {
    int health;
    int mana;

    public Stats(int health, int mana) {
        this.health = health;
        this.mana = mana;
    }

    public Stats(Stats original) {
        this.health = original.health;
        this.mana = original.mana;
    }

    public String getStats() {
        return "Health: " + health + ", Mana: " + mana;
    }
}

class AI {
    String behavior;

    public AI(String behavior) {
        simulateLoad();
        this.behavior = behavior;
    }

    public AI(AI original) {
        this.behavior = original.behavior;
    }

    public void simulateLoad() {
        try {
            System.out.println("Configuring AI engine...");
            Thread.sleep(1000); // simulate setup
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getBehavior() {
        return behavior;
    }
}

class Mage {
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

    // Deep copy constructor
    public Mage(Mage original) {
        this.name = original.name;
        this.weapon = new Weapon(original.weapon);
        this.stats = new Stats(original.stats);
        this.ai = new AI(original.ai);
    }

    public void displayInfo() {
        System.out.println("Mage Info:");
        System.out.println("Weapon: " + weapon.getDetails());
        System.out.println("Stats: " + stats.getStats());
        System.out.println("AI Behavior: " + ai.getBehavior());
    }
}

public class Sol5 {
    public static void main(String[] args) {
        Mage originalMage = new Mage(
                "Gandalf",
                new Weapon("Staff of Power", 150),
                new Stats(1000, 500),
                new AI("Aggressive")
        );

        System.out.println("Original Mage:");
        originalMage.displayInfo();

        System.out.println("\nCloning Mage...");
        Mage clonedMage = new Mage(originalMage);

        System.out.println("\nCloned Mage:");
        clonedMage.displayInfo();
    }
}

// Pros :
// - True deep copy of all mutable objects
// - Changes to weapon, stats, ai do not affect the other object
// - Client is not responsible for deep copying logic