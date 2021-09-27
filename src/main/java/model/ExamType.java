package model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamType implements Comparable<ExamType>{

    private int examTypeId;
    private String name;


    public ExamType(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        String text="";
        text+=this.examTypeId+","+this.name;
        return text;
    }

    public String description() {
        String text = "";
        text+="Exam type ID:"+this.getExamTypeId();
        text+="Exam  name:"+this.getName();



        return text;
    }

    @Override
    public boolean equals(Object obj) {
        ExamType exam=(ExamType) obj;
        return this.examTypeId==exam.getExamTypeId();
    }

    @Override
    public int compareTo(ExamType exam){

        if(this.getExamTypeId()>exam.getExamTypeId()){
            return 1;
        }else if(this.getExamTypeId()<exam.getExamTypeId()){
            return -1;
        }
        return 0;
    }
}
