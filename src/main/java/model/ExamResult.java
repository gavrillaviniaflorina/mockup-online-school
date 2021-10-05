package model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class ExamResult implements Comparable<ExamResult>{
    private int examResultId;
    private int examId;
    private int studentId;
    private int marks;


    public ExamResult(int examId, int studentId, int marks) {
        this.examId = examId;
        this.studentId = studentId;
        this.marks = marks;
    }

    @Override
    public String toString(){
        String text="";
        text+=this.examResultId+","+this.studentId+this.examId+","+this.marks;
        return text;
    }

    public String description() {
        String text = "";
        text+="Exam result Id:"+this.getExamResultId();
        text+="Student ID:"+this.getStudentId();
        text+="Exam ID:"+this.getExamId();
        text+="Marks :"+this.getMarks();


        return text;
    }

    @Override
    public boolean equals(Object obj) {
        ExamResult exam=(ExamResult) obj;
        return this.examId==exam.examId;
    }

    @Override
    public int compareTo(ExamResult exam){

        if(this.getExamId()>exam.getExamId()){
            return 1;
        }else if(this.getExamId()<exam.getExamId()){
            return -1;
        }
        return 0;
    }
}
