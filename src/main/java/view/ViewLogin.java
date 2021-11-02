package view;

import controller.StudentController;
import controller.TeacherController;
import model.Student;
import model.Teacher;

import java.util.Scanner;

public class ViewLogin {
    private Scanner scanner;
    private StudentController studentController;
    private TeacherController teacherController;

    public ViewLogin() {
        this.scanner=new Scanner(System.in);
        this.studentController=new StudentController();
        this.teacherController=new TeacherController();
    }

    private String meniu(){
        String text="";
        text+="Apasati tasta 0 pentru a incheia\n";
        text+="Apasati tasta 1 pentru a va loga\n";
        return text;

    }



    public void play(){

        System.out.println("Introduceti statusul dvs(ex:teacher, student)");
        String status=scanner.nextLine();
        if(status.equals("teacher")==false && status.equals("student")==false){
            System.out.println("Nu ati introdus un status valid.");
        }else {
            System.out.println("Introduceti numele dvs:");
            String nume = scanner.nextLine();
            System.out.println("Introduceti prenumele dvs:");
            String prenume = scanner.nextLine();
            System.out.println("Introduceti parola dvs:");
            String parola = scanner.nextLine();

            if (status.equals("teacher")) {
                if (!teacherController.numePrenumeTeacher(nume, prenume).getPassword().equals(parola) || teacherController.numePrenumeTeacher(nume, prenume).getPassword()==null ) {
                    System.out.println("nume sau parola incorecta!");
                } else {
                    Teacher teacher =teacherController.numePrenumeTeacher(nume,prenume);
                    ViewTeacher viewTeacher = new ViewTeacher(teacher);
                   viewTeacher.play();

                }
            } else if (status.equals("student")) {
                if (!studentController.studentNumePrenume(nume, prenume).getPassword().equals(parola) || studentController.studentNumePrenume(nume, prenume).getPassword()==null  ) {
                    System.out.println("nume sau parola incorecte!");
                } else {
                    Student student= studentController.studentNumePrenume(nume, prenume);
                   ViewStudent viewStudent=new ViewStudent(student);
                    viewStudent.play();
                    ;
                }
            }
        }

    }

}
