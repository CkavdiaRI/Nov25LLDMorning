package Module1.Generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BoundsDemo {

    public static void main(String[] args) {

        // -------------------------------
        // 1) UPPER BOUND: ? extends Number
        // -------------------------------
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5);
        List<Double> doubleList = Arrays.asList(1.5, 2.5, 3.5);

        System.out.println("=== UPPER BOUND: ? extends Number ===");
        double sumInts = sumOfNumbers(intList);
        double sumDoubles = sumOfNumbers(doubleList);

        System.out.println("Sum of intList     : " + sumInts);
        System.out.println("Sum of doubleList  : " + sumDoubles);

        // Uncomment this to show compile-time error in class:
        // List<? extends Number> numbers = intList;
        // numbers.add(10); // ❌ Compile-time error: cannot add to ? extends


        // -------------------------------
        // 2) LOWER BOUND: ? super Integer
        // -------------------------------
        List<Number> numberList = new ArrayList<>();
        numberList.add(100);     // Integer (autoboxed)
        numberList.add(3.14);    // Double

        System.out.println("\n=== LOWER BOUND: ? super Integer ===");
        addSomeIntegers(numberList);

        System.out.println("After addSomeIntegers(numberList):");
        for (Object obj : numberList) { // we read as Object
            System.out.println("  element: " + obj + " (type: " + obj.getClass().getSimpleName() + ")");
        }

        // You can also pass a List<Object> to ? super Integer
        List<Object> objectList = new ArrayList<>();
        addSomeIntegers(objectList);

        System.out.println("\nAfter addSomeIntegers(objectList):");
        for (Object obj : objectList) {
            System.out.println("  element: " + obj + " (type: " + obj.getClass().getSimpleName() + ")");
        }

        // Uncomment to show type limitation on read:
        // List<? super Integer> superList = numberList;
        // Integer x = superList.get(0); // ❌ Compile-time error: only safe as Object

    }

    // -----------------------------------
    // UPPER BOUND: Producer (read-only)
    // -----------------------------------
    // Accepts List<Number>, List<Integer>, List<Double>, etc.
    // You can safely READ as Number, but cannot ADD new elements.
    public static double sumOfNumbers(List<? extends Number> list) {
        double sum = 0.0;
        for (Number n : list) { // safe: every element is a Number or subclass
            sum += n.doubleValue();
        }
        return sum;
    }

    // -----------------------------------
    // LOWER BOUND: Consumer (write)
    // -----------------------------------
    // Accepts List<Integer>, List<Number>, List<Object>, etc.
    // You can safely ADD Integer values into it.
    public static void addSomeIntegers(List<? super Integer> list) {
        // We know list can hold Integer or its super types,
        // so adding Integer is always safe.
        list.add(1);
        list.add(2);
        list.add(3);

        // Reading is limited: the only safe type is Object
        Object first = list.get(0);
        System.out.println("First element inside addSomeIntegers (as Object): "
                + first + " (type: " + first.getClass().getSimpleName() + ")");
    }

}

