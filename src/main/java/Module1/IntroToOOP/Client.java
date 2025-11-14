package Module1.IntroToOOP;

public class Client {
    public static void main(String[] args) {
        System.out.println("Hello World !!");

        Student s1 = new Student();
//        s1.name = "Chirag";
//        s1.age = 100;
//        s1.studentID = 1;

        Student s2 = new Student();

        Student s3 = new Student("Jairaj", 120, 101);

        Student s5 = new Student(s1);
//        s1.name = "Deepak";
//
//        Student  s6 = s1;
//        s6.name = "Deepak";

        System.out.println("Hello World !!");

    }
}
