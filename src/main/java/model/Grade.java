package model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Grade implements Comparable<Grade> {
    private int gradeId;
    private int mark;


    public Grade(int mark) {
        this.mark = mark;
    }


    @Override
    public String toString(){
        String text="";
        text+=this.mark;
        return text;
    }

    public String description() {
        String text = "";
        text+="Grade Id:"+this.getGradeId();
        text+="Mark:"+this.getMark();



        return text;
    }

    @Override
    public boolean equals(Object obj) {
      Grade grade=(Grade) obj;
      return this.getGradeId()==grade.getGradeId();
    }

    @Override
    public int compareTo(Grade grade){

        if(this.getGradeId()>grade.getGradeId()){
            return 1;
        }else if(this.getGradeId()<grade.getGradeId()){
            return -1;
        }
        return 0;
    }
}
