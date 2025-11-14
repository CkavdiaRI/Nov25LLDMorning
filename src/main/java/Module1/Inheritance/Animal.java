package Module1.Inheritance;

public class Animal {
    String animalName;
    protected int animalAge;
    private int animalID;

    Animal(){
        animalName = "Animal";
        animalID = 1;
        animalAge = 11;
    }

    void eat(){
        System.out.println("Animal is eating.");
    }
    protected void accessPrivateAttributeOfAnimal(){
        System.out.println("Accessing private member animalID: " + animalID);
    }
}
