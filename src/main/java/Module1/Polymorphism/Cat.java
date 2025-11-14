package Module1.Polymorphism;

public class Cat extends Animal {

    @Override
    void speak() {
        System.out.println("Cat meows");
    }

    void scratch() {
        System.out.println("Cat scratches");
    }

}
