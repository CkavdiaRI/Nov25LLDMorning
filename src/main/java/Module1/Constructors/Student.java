package Module1.Constructors;

public class Student {
    // Attributes
    String name;
    int studentID;
    int age;

//    Student() {
//        name = "Default Name";
//        studentID = -1;
//        age = 18;
//    }

    // Methods // Behaviors
    void submitAssignment() {
        System.out.println(name + " is submitting assignment.");
    }

    void attendClass() {
        System.out.println(name + " is attending class.");
    }
}
