package model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class Attendance implements Comparable<Attendance>{
    private String date;
    private int studentId;
    private String remark;


    @Override
    public String toString(){
        String text="";
        text+=this.date+","+this.studentId+","+this.remark;
        return text;
    }

    public String description() {
        String text = "";
        text+="Date:"+this.getDate();
        text+="Student ID:"+this.getStudentId();
        text+="Remarks:"+this.getRemark();


        return text;
    }

    @Override
    public boolean equals(Object obj) {
        Attendance attendance=(Attendance) obj;
        return this.getDate().equals(attendance);
    }

    @Override
    public int compareTo(Attendance attendance){

        if(this.getDate().compareTo(attendance.getDate())>0){
            return 1;
        }else if(this.getDate().compareTo(attendance.getDate())<0){
            return -1;
        }
        return 0;
    }


}
