package Module2.Prototype.PrototypeDP;

public class Client {
    public static void main(String[] args) {
        Mage mage1 = new Mage(
                "Jaina",
                new Weapon("Frost Staff", 80),
                new Stats(100, 200),
                new AI("Aggressive")
        );

        Mage magecopy = mage1.clone(); // create a new object using the clone method

        System.out.println("Original Mage: " + mage1);
    }
}
