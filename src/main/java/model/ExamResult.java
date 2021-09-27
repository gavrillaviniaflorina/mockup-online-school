package model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class ExamResult implements Comparable<ExamResult>{
    private int examId;
    private int studentId;
    private int courseId;
    private String marks;



    @Override
    public String toString(){
        String text="";
        text+=this.examId+","+this.studentId+","+courseId+","+this.marks;
        return text;
    }

    public String description() {
        String text = "";
        text+="Exam ID:"+this.getExamId();
        text+="Student ID:"+this.getStudentId();
        text+="Course ID:"+this.getCourseId();
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
