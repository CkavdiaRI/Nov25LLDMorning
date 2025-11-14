package Module1.Inheritance;

public class Client {
    public static void main(String[] args) {
        //Animal animal = new Animal();
        Mammals mammal = new Mammals();
        Dog dog = new Dog();

        mammal.accessPrivateAttributeOfAnimal();
        dog.accessPrivateAttributeOfAnimal();

        System.out.println("Testing Animal:");
    }
}
