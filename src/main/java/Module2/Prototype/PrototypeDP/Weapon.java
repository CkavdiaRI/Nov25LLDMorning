package Module2.Prototype.PrototypeDP;

public class Weapon implements Prototype<Weapon>
{
    String name;
    int damage;

    public Weapon(String name, int damage) {
        simulateLoad();
        this.name = name;
        this.damage = damage;
    }

    Weapon(Weapon weapon){
        this.name = weapon.name;
        this.damage = weapon.damage;
    }

    private void simulateLoad() {
        try {
            System.out.println("Forging weapon...");
            Thread.sleep(1000); // simulate setup
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getDetails() {
        return name + " (Damage: " + damage + ")";
    }

    @Override
    public Weapon clone(){
        return new Weapon(this);
    }
}
