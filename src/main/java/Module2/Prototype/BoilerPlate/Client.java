package Module2.Prototype.BoilerPlate;

public class Client {
    public static void main(String[] args) {
        System.out.println("Creating original Mage...");
        Mage mage1 = new Mage(
                "Jaina",
                new Weapon("Frost Staff", 80),
                new Stats(100, 200),
                new AI("Aggressive")
        );

        System.out.println("\nCreating second Mage (Jaina Copy)...");
    }
}