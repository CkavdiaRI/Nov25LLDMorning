package Module1.Polymorphism;

public class CompileTimePoly {
    // Class demonstrating compile-time polymorphism
    int add(int a, int b) {
        return a + b;
    }

    double add(double a, double b) {
        return a + b;
    }

    int add(int a, int b, int c) {
        return a + b + c;
    }

    double add(double a, int b) {
        return a + b;
    }

    double add(int a, double b) {
        return a + b;
    }

    // Return type alone cannot distinguish two overloaded methods.
//    double add(int a, int b) { // ❌ Compile-time error
//        return a + b;
//    }
}
