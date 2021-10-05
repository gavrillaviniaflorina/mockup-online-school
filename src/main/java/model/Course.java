package model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class Course implements Comparable<Course>{
   private int courseID;
   private String courseName;
   private int teacher_id;
   private int classroom_id;


    public Course(String courseName,int teacher_id, int classroom_id) {
        this.courseName = courseName;
        this.teacher_id=teacher_id;
        this.classroom_id=classroom_id;

    }


    @Override
    public String toString(){
        String text="";
        text+=this.courseID+","+this.courseName+","+this.teacher_id+","+this.classroom_id;
    return text;
    }

    public String description() {
        String text = "";
        text+="Course ID:"+this.getCourseID();
        text+="Course name:"+this.getCourseName();
        text+="Teacher's ID:"+this.getTeacher_id();
        text+="Classroom ID:"+this.getClassroom_id();



        return text;
    }

    @Override
    public boolean equals(Object obj) {
       Course course=(Course) obj;
        return this.courseID==course.getCourseID();
    }

    @Override
    public int compareTo(Course course){

        if(this.getCourseID()>course.getCourseID()){
            return 1;
        }else if(this.getCourseID()<course.getCourseID()){
            return -1;
        }
        return 0;
    }
}
