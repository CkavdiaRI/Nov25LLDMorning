package Module2.Prototype;

import Module2.Prototype.BoilerPlate.Mage;

public class Sol4 {
    public static void main(String[] args) {
        Mage mage = new Mage(
                "Jaina",
                new Module2.Prototype.BoilerPlate.Weapon("Frost Staff", 80),
                new Module2.Prototype.BoilerPlate.Stats(100, 200),
                new Module2.Prototype.BoilerPlate.AI("Aggressive")
        );

        Mage magecopy = new Mage(mage);
    }
}

// Pros :
// - New object created using copy constructor
// - Client code is cleaner
// - Client doesn't need to know the details of Mage class
// - Client code is not tightly coupled with Mage class implementation
// - Any changes in Mage class won't affect client code`

// Cons :
// - Shallow copy
// - Changes to Weapon, Stats, or AI in magecopy will affect mage (and vice versa)
