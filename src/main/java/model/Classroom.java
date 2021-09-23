package model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Classroom implements Comparable<Classroom>{

    private int classroomId;
    private int year;
    private int teacherId;
    private String SubjectName;

    public Classroom(int year, int teacherId, String subjectName) {
        this.year = year;
        this.teacherId = teacherId;
        SubjectName = subjectName;
    }

    @Override
    public String toString(){
        String text="";
        text+=this.classroomId+","+this.year+","+this.teacherId+","+this.SubjectName;
        return text;
    }

    public String description() {
        String text = "";
        text+="Classroom ID:"+this.getClassroomId();
        text+="Classroom year:"+this.getYear();
        text+="Teacher of the classroom:"+this.getTeacherId();
        text+="Name of the subject:"+this.getSubjectName();

        return text;
    }

    @Override
    public boolean equals(Object obj) {
        Classroom classroom=(Classroom) obj;
        return this.classroomId==classroom.getClassroomId();
    }

    @Override
    public int compareTo(Classroom classroom){

        if(this.getClassroomId()>classroom.getClassroomId()){
            return 1;
        }else if(this.getClassroomId()<classroom.getClassroomId()){
            return -1;
        }
        return 0;
    }
}
