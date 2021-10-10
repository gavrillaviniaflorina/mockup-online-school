package view;

import controller.*;

public class ViewStudent {

    private ClassroomStudentController classroomStudentController;
    private CourseController courseController;
    private ExamController examController;
    private ExamResultController examResultController;
    private StudentController studentController;


    public ViewStudent() {
        this.classroomStudentController=new ClassroomStudentController();
        this.courseController=new CourseController();
        this.examController=new ExamController();
        this.examResultController=new ExamResultController();
        this.studentController=new StudentController();
    }

}
