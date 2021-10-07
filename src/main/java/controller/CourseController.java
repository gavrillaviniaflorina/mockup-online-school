package controller;


import model.Course;
import repository.CourseRepository;

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
}
