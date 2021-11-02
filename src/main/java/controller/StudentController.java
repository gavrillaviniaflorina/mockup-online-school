package controller;

import model.Student;
import repository.StudentRepository;

import java.sql.Struct;
import java.util.ArrayList;
import java.util.List;

public class StudentController {

    private StudentRepository studentRepository;

    public StudentController() {

        this.studentRepository = new StudentRepository();
    }

    public void insert(Student student) {

        studentRepository.insert(student);
    }

    public boolean exist(Student student) {
        for (Student student1 : studentRepository.allStudents()) {
            if (student.equals(student1)) {
                return true;
            }
        }
        return false;
    }

    public Student student(int id) {
        for (Student student : studentRepository.allStudents()) {
            if (student.getStudent_id() == id) {
                return student;
            }
        }

        return new Student(-1, "", "", "", "", "", false);
    }

    public void delete(int id){
        if(exist(student(id))==true){
            studentRepository.delete(id);
            System.out.println("The student was deleted");
        }else{
            System.out.println("The student does not exist");
        }
    }

    public void updateEmail(int id, String email){
        if(exist(student(id))==true){
            studentRepository.updateEmail(id, email);
            System.out.println("The email was updated");
        }else{
            System.out.println("The student does not exist");
        }
    }

    public void updatePasssword(int id, String password){
        if(exist(student(id))==true){
            studentRepository.updatePassword(id,password);
            System.out.println("The password was updated");
        }else{
            System.out.println("The student does not exist");
        }
    }

    public Student studentNumePrenume(String nume, String prenume){
        for(Student student:studentRepository.allStudents()){
            if(student.getLast_name().equals(nume)&& student.getFirst_name().equals(prenume)){
                return student;
            }
        }
        return new Student(-1,"","","","","",false);
    }

    public void print(){
        for(Student student: studentRepository.allStudents()){
            System.out.println(student.description());
        }
    }

    public List<Student> students(){

        List<Student>list=new ArrayList<>();
        list=studentRepository.allStudents();
        return list;
    }
}
