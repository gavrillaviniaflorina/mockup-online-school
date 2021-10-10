package controller;


import model.Course;
import model.Teacher;
import repository.CourseRepository;
import repository.TeacherRepository;

import java.util.List;

public class CourseController {

    private CourseRepository courseRepository;

    public CourseController() {
        this.courseRepository = new CourseRepository();
    }

    private boolean exist(Course course){

        List<Course> courses=courseRepository.allCourses();

        for (Course course1:courses){
            if(course1.equals(course1)){
                return true;
            }
        }
        return false;
    }

    public void insert(Course course){
        if(exist(course)==false) {
            courseRepository.insert(course);
            System.out.println("The course was inserted.");
        }else{
            System.out.println("This course already exists");
        }

    }

    public Course course(int id){
        List<Course> courses=courseRepository.allCourses();
        for(Course course:courses){
            if(course.getCourseID()==id){
                return course;
            }
        }
        return new Course("",-1,-1);
    }

    public void delete(int id){
        if(exist(course(id))==true){
            courseRepository.delete(id);
            System.out.println("The course was deleted");
        }else{
            System.out.println("The course student does not exist");
        }
    }

    public void updateCourseName(int id,String name){
        if(exist(course(id))==true){
           courseRepository.updateCourseName(id, name);
            System.out.println("The name was updated");
        }else{
            System.out.println("The course does not exist ");
        }
    }

    public void updateTeacherId(int id,int teacherid){
        if(exist(course(id))==true){
            courseRepository.updateTeacherId(id, teacherid);
            System.out.println("The teacher was updated");
        }else{
            System.out.println("The course does not exist");
        }
    }

    public void print(){
        for(Course course:courseRepository.allCourses()){
            System.out.println(course.description());
        }
    }

    public static class TeacherController {
        private TeacherRepository teacherRepository;

        public TeacherController() {
            this.teacherRepository=new TeacherRepository();
        }

        public void insert(Teacher teacher){
            teacherRepository.insert(teacher);
            System.out.println("The teacher was inserted");
        }

        public boolean exist(Teacher teacher){
            for(Teacher teacher1: teacherRepository.allTeachers()){
                if(teacher.equals(teacher1)){
                    return true;
                }
            }
            return false;
        }

        public Teacher teacher(int id){
            for(Teacher teacher: teacherRepository.allTeachers()){
                if(teacher.getTeacher_id()==id){
                    return teacher;
                }
            }
            return new Teacher(-1,"","","","","",false);
        }

        public void delete(int id){
            if(exist(teacher(id))==true){
                teacherRepository.delete(id);
                System.out.println("The teacher was deleted");
            }else{
                System.out.println("The teacher does not exist");
            }
        }

        public void updateEmail(int id ,String email){
            if(exist(teacher(id))==true){
                teacherRepository.updateEmail(id, email);
                System.out.println("The email was updated");
            }else{
                System.out.println("The teacher does not exist");
            }
        }

        public void updatePassword(int id, String password){
            if(exist(teacher(id))==true){
                teacherRepository.updatePassword(id, password);
                System.out.println("The password was updated");
            }else{
                System.out.println("The teacher does not exist");
            }
        }

        public void print(){
            for(Teacher teacher: teacherRepository.allTeachers()){
                System.out.println(teacher.description());
            }
        }
    }
}
