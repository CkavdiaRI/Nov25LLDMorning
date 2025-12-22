package Module2.Prototype;
import Module2.Prototype.BoilerPlate.AI;
import Module2.Prototype.BoilerPlate.Mage;
import Module2.Prototype.BoilerPlate.Stats;
import Module2.Prototype.BoilerPlate.Weapon;

public class Sol2 {
    public static void main(String[] args) {
        Mage mage = new Mage(
                "Jaina",
                new Weapon("Frost Staff", 80),
                new Stats(100, 200),
                new AI("Aggressive")
        );

        Mage mage2 = new Mage(
                "Jaina 2",
                new Weapon("Frost Staff", 80),
                new Stats(100, 200),
                new AI("Aggressive")
        );
    }
}

// Cons :
// - New object created, but not a true clone
// - If we create 100 copies, it will be inefficient
// - Code is repetitive and error-prone
// - Time consuming to create each object manually
// - Client is responsible for creating copies
