package Module1.IntroToOOP;

public class Student {
    // Attributes/Data/Properties
    String name;
    public int age;
    int studentID;
    EntranceExam exam;
    Batch batch;

    // Default constructor. Not visible to you directly but present only if there is mo custom constructor
    Student(){
        name = "Chirag";
        age = 100;
        studentID = 11;
        exam = new EntranceExam(1, "src/main/Test");
    }

//    //Parameterized constructors
//    Student(String name, int age, int studentID){
//        this.name = name;
//        this.age = age;
//        this.studentID = studentID;
//    }

    //Parameterized constructors
    Student(String name, int age){
        this.name = name;
        this.age = age;
        exam = new EntranceExam(1, "src/main/Test");
    }

    //Parameterized constructors
    Student(String name1, int age1,  int  studentID1){
        name = name1;
        age = age1;
        studentID = studentID1;
        exam = new EntranceExam(1, "src/main/Test");
    }

    //Parameterized constructors
    Student(String name){
        this.name = name;
        age = 0;
        studentID = 0;
        exam = new EntranceExam(1, "src/main/Test");
    }

    // copy constructor
    Student(Student other){
        name = other.name;
        age =  other.age;
        studentID = other.studentID;
//        exam = other.exam;      // Shallow copy
//        exam = new EntranceExam(other.exam.examID, other.exam.examName);
        exam = new EntranceExam(other.exam); // Deep copy //will call copy constructor of EntranceExam class
        batch = other.batch;
    }


    //Behaviours/Methods/Functions
    void submitAssignment(int assignmentID){
        System.out.println("Completed assignment " + assignmentID);
    }
    void attendingClass(int classID){
        System.out.println("Student "+name+" is attending class " + classID);
    }

    public int getStudentId(){// getter function
        return studentID;
    }

    void setStudentID(int input){// setter function
        studentID = input;
    }
}
