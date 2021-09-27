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
   private int gradeID;

    public Course(String courseName, int gradeID) {
        this.courseName = courseName;
        this.gradeID = gradeID;
    }


    @Override
    public String toString(){
        String text="";
        text+=this.courseID+","+this.courseName+","+this.gradeID;
        return text;
    }

    public String description() {
        String text = "";
        text+="Course ID:"+this.getCourseID();
        text+="Course name:"+this.getCourseName();
        text+="Grade ID"+this.getGradeID();


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
