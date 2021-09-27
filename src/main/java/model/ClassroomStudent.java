package model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class ClassroomStudent implements Comparable<ClassroomStudent> {
   private int clasroomStundetId;
   private int classroomId;
   private int studentId;

    public ClassroomStudent(int classroomId, int studentId) {
        this.classroomId = classroomId;
        this.studentId = studentId;
    }

    public String description(){
        String text="";
        text+="ID classroomStudent:"+this.getClasroomStundetId();
        text+="ID student:"+this.getStudentId();
        text+="ID classroom:"+this.getClassroomId();


        return text;
    }

    @Override
    public String toString() {
        String text="";
        text+=this.getClasroomStundetId()+","+this.getStudentId()+","+this.getClassroomId();
        return text;
    }

    @Override
    public boolean equals(Object obj) {
        ClassroomStudent classroomStudent=(ClassroomStudent) obj;
        return this.clasroomStundetId==classroomStudent.getClasroomStundetId();
    }

    @Override
    public int compareTo(ClassroomStudent student){

        if(this.getClasroomStundetId()>student.getClasroomStundetId()){
            return 1;
        }else if(this.getClasroomStundetId()<student.getClasroomStundetId()){
            return -1;
        }
        return 0;
    }
}
