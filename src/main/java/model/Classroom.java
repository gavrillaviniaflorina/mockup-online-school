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

    private String classroomName;

    public Classroom( String classroomName) {
       this.classroomName=classroomName;
    }

    @Override
    public String toString(){
        String text="";
        text+=this.classroomId+","+this.classroomName;
        return text;
    }

    public String description() {
        String text = "";
        text+="Classroom ID:"+this.getClassroomId();
        text+="Classroom name:"+this.classroomName;


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
