package controller;


import model.ClassroomStudent;
import model.Student;
import repository.ClassroomStudentRepository;

import java.util.List;

public class ClassroomStudentController {

    private ClassroomStudentRepository classroomStudentRepository;

    public ClassroomStudentController() {
        this.classroomStudentRepository = new ClassroomStudentRepository();
    }

    private boolean exist(ClassroomStudent classroomStudent){

        List<ClassroomStudent> classroomStudents=classroomStudentRepository.allClassroomStudents();

        for (ClassroomStudent classroomStudent1:classroomStudents){
            if(classroomStudent.equals(classroomStudent1)){
                return true;
            }
        }
        return false;
    }

    public void insert(ClassroomStudent classroomStudent){
        if(exist(classroomStudent)==false) {
            classroomStudentRepository.insert(classroomStudent);
            System.out.println("The classroom student was inserted.");
        }else{
            System.out.println("This classroom student already exists");
        }

    }

    public ClassroomStudent classroomStudent(int id){
        List<ClassroomStudent> classroomsStudents=classroomStudentRepository.allClassroomStudents();
        for(ClassroomStudent classroomStudent1:classroomsStudents){
            if(classroomStudent1.getClassroomId()==id){
                return classroomStudent1;
            }
        }
        return new ClassroomStudent(-1,-1,-1);
    }

    public void delete(int id){
        if(exist(classroomStudent(id))==true){
            classroomStudentRepository.delete(id);
            System.out.println("The classroom student was deleted");
        }else{
            System.out.println("The classroom student does not exist");
        }
    }

    public void updateClassroomStudentId(int id,int classroomStudentId){
        if(exist(classroomStudent(id))==true){
            classroomStudentRepository.updateClassroomStudentId(id,classroomStudentId);
            System.out.println("The classroom student id was deleted");
        }else{
            System.out.println("The classroom student does not exist");
        }
    }

    public void print(){
        for(ClassroomStudent classroomStudent:classroomStudentRepository.allClassroomStudents()){
            System.out.println(classroomStudent.description());
        }
    }

    public int studentsClassroom(int id){
        for(ClassroomStudent classroomStudent:classroomStudentRepository.allClassroomStudents()){
            if(classroomStudent.getClasroomStundetId()==id){
                return classroomStudent.getClassroomId();
            }
        }
        return -1;
    }
}
