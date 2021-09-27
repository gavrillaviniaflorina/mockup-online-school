package model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class Exam implements Comparable<Exam>{
    private int examId;
    private int examTypeID;
    private String date;

    public Exam(int examTypeID, String date) {
        this.examTypeID = examTypeID;
        this.date = date;
    }

    @Override
    public String toString(){
        String text="";
        text+=this.examId+","+this.examTypeID+","+date;
        return text;
    }

    public String description() {
        String text = "";
        text+="Exam ID:"+this.getExamId();
        text+="Exam type name:"+this.getExamTypeID();
        text+="Start date"+this.getDate();


        return text;
    }

    @Override
    public boolean equals(Object obj) {
        Exam exam=(Exam) obj;
        return this.examId==exam.examId;
    }

    @Override
    public int compareTo(Exam exam){

        if(this.getExamId()>exam.getExamId()){
            return 1;
        }else if(this.getExamId()<exam.getExamId()){
            return -1;
        }
        return 0;
    }
}
