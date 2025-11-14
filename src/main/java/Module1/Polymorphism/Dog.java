package Module1.Polymorphism;

public class Dog extends Animal {

    @Override
    void speak() {
        System.out.println("Dog barks");
    }

    void wagTail() {
        System.out.println("Dog wags tail");
    }

    // Overriding a private method (doesn't work)
//    @Override
//    private void sayHi() {
//        System.out.println("Dog says hi");
//    }

}
