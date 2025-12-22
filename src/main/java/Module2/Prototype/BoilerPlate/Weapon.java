package Module2.Prototype.BoilerPlate;

public class Weapon {
    String type;
    int damage;

    public Weapon(String type, int damage) {
        simulateHeavyLoad();
        this.type = type;
        this.damage = damage;
    }

    private void simulateHeavyLoad() {
        try {
            System.out.println("Loading heavy weapon data from disk...");
            Thread.sleep(1000); // simulate disk IO
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getDetails() {
        return type + " (" + damage + " dmg)";
    }
}
