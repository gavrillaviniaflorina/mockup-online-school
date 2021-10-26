package controller;

import model.Course;
import model.Teacher;
import repository.TeacherRepository;

public  class TeacherController {
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
