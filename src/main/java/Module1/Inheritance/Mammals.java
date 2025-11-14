package Module1.Inheritance;

public class Mammals extends Animal{
    String mammalName;

    Mammals(){
        // Animal();    // Implicit call to parent class constructor
        mammalName = "Mammal";
    }

    void eat(){
        System.out.println("Mammal is eating.");
        System.out.println("Accessing default member animalName: " + animalName); // This is allowed because animalName has default access in Animal class
        System.out.println("Accessing protected member animalAge: " + animalAge); // This is allowed because animalAge is protected in Animal class
        // System.out.println("Accessing private member animalID: " + animalID); // This will cause a compile-time error because animalID is private in Animal class
    }

//    public void accessPrivateAttributeFromParent(){
//        accessPrivateAttribute(); // This is allowed because accessPrivateAttribute() is protected in Animal class
//    }
}

// Public, Protected can be accessed in child class
// Default can be accessed within same package. It has package-level access and not accessible outside the package