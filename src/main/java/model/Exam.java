package model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class Exam implements Comparable<Exam>{
    private int examId;
    private int course_id;
    private String date;

    public Exam(int course_id, String date) {
        this.course_id = course_id;
        this.date = date;
    }

    @Override
    public String toString(){
        String text="";
        text+=this.examId+","+this.course_id +","+date;
        return text;
    }

    public String description() {
        String text = "";
        text+="Exam ID:"+this.getExamId();
        text+="Course ID:"+this.getCourse_id();
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
