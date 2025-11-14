package Module1.Inheritance;

public class Dog extends Mammals{
    String dogName;

    Dog(){
        //Animal();
        //Mammals();    // before data member of Dog are initialized, constructor of Animal & Mammals are called automatically
        dogName = "Dog";
    }

    void eat(){
        System.out.println("Dog is eating.");
    }
}
