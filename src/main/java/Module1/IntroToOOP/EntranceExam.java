package Module1.IntroToOOP;

public class EntranceExam {
    public int examID;
    public String examName;


    EntranceExam(int examID,String examName){
        this.examID = examID;
        this.examName = examName;
    }

    EntranceExam(EntranceExam other){
        examID = other.examID;;
        examName = other.examName;

    }
}
