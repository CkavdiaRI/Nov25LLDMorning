package Module2.Prototype;

import Module2.Prototype.BoilerPlate.AI;
import Module2.Prototype.BoilerPlate.Mage;
import Module2.Prototype.BoilerPlate.Stats;
import Module2.Prototype.BoilerPlate.Weapon;

public class Sol3 {
    public static void main(String[] args) {
        Mage  mage = new Mage(
                "Jaina",
                new Weapon("Frost Staff", 80),
                new Stats(100, 200),
                new AI("Aggressive")
        );

        Mage magecopy = new Mage();
        magecopy.setName(mage.getName());
        magecopy.setWeapon(mage.getWeapon());
        magecopy.setStats(mage.getStats());
        magecopy.setAi(mage.getAi());

        System.out.println("Original Mage Name: " + mage.getInfo());
    }
}

// Pros :
// - Creates a new Mage object
// - It is a clone of the original Mage`

// Cons :
// - Code duplication
// - Shallow copy
// - Manual copying of each attribute
// - We need to have setters and getters for all attributes, even though we may not want to expose them
// - You will not be able to clone if the original class have private attributes without getters/setters
// - Client needs to know the internal structure of Mage to copy all attributes
// - Client code is tightly coupled with Mage class implementation
// - If Mage class changes, client code needs to be updated accordingly