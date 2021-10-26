package view;

import controller.*;
import model.ExamResult;
import model.Student;

import java.sql.SQLOutput;
import java.util.Scanner;

public class ViewStudent {

    private ClassroomStudentController classroomStudentController;
    private CourseController courseController;
    private ExamController examController;
    private ExamResultController examResultController;
    private StudentController studentController;
    private Scanner scanner;


    public ViewStudent() {
        this.classroomStudentController=new ClassroomStudentController();
        this.courseController=new CourseController();
        this.examController=new ExamController();
        this.examResultController=new ExamResultController();
        this.studentController=new StudentController();
        this.scanner=new Scanner(System.in);
    }

    private String meniu(){

        String text="";

        text+="Apasati tasta 0 pentru a incheia \n";
        text+="Apasati tasta 1 pentru a va schimba emailul \n";
        text+="Apasati tasta 2 pentru a va schimba parola\n";
        text+="Apasati tasta 3 pentru a va alfa id-ul clasei de care apartineti\n";
        text+="Apasati tasta 4 pentru a afla toate materiile care se predau unei clase \n";
        text+="Apasati tasta 5 pentru a afala data de inceput a unui examen \n";
        text+="Apasati tasta 6 pentru a va afla nota la un examen \n";

        return text;

    }



    public void play(){
        System.out.println(meniu());
        boolean run=true;
        while(run){
            int alegere=Integer.parseInt(scanner.nextLine());
            switch (alegere){
                case 0:
                    run=false;
                    break;
                case 1:
                    updateMail();
                    break;
                case 2:
                    updateParola();
                    break;
                case 3:
                    idClasa();
                    break;
                case 4:
                    subjects();
                    break;
                case 5:
                    startDate();
                    break;
                case 6:
                    notaExamen();
                    break;
                default:
                    System.out.println(meniu());
                    break;


            }
        }
    }


    private void updateMail() {
        System.out.println("Introduceti numele:");
        String nume = scanner.nextLine();
        System.out.println("Introduceti prenumele:");
        String prenume = scanner.nextLine();
        System.out.println("Introduceti noul email");
        String email = scanner.nextLine();

        Student student = studentController.studentNumePrenume(nume, prenume);
        if (student.getStudent_id() == -1) {
            System.out.println("Nume sau prenume incorecte");
        } else {

            studentController.updateEmail(student.getStudent_id(), email);
        }
    }

    private void updateParola() {
        System.out.println("Introduceti numele:");
        String nume = scanner.nextLine();
        System.out.println("Introduceti prenumele:");
        String prenume = scanner.nextLine();
        System.out.println("Introduceti noua parola");
        String parola = scanner.nextLine();

        Student student = studentController.studentNumePrenume(nume, prenume);
        if (student.getStudent_id() == -1) {
            System.out.println("Nume sau prenume incorecte");
        } else {
            studentController.updatePasssword(student.getStudent_id(), parola);
        }
    }

    private void idClasa(){
        System.out.println("Introduceti id-ul dumneavoastra de student");
        int id=Integer.parseInt(scanner.nextLine());

        int idClasa=classroomStudentController.studentsClassroom(id);

      if(idClasa==-1){
          System.out.println("Id incorect");
      }else{
          System.out.println(idClasa);
      }
    }

    private void subjects(){
        System.out.println("Introduceti id-ul clasei ");
        int id=Integer.parseInt(scanner.nextLine());


        courseController.materii(id);
    }

    private void startDate(){

        System.out.println("Introduceti id-ul examenului");
        int id=Integer.parseInt(scanner.nextLine());

        String date= examController.startDate(id);
        if(date==null){
            System.out.println("Id incorect");
        }else{
            System.out.println(date);
        }

    }

    private void notaExamen(){

        System.out.println("Introduceti id-ul de student");
       int idStudent=Integer.parseInt(scanner.nextLine());
        System.out.println("Introduceti id-ul examenului");
        int idExamen=Integer.parseInt(scanner.nextLine());

        ExamResult examResult= examResultController.result(idStudent,idExamen);
        if(examResult.getExamResultId()==-1){
            System.out.println("Id de student sau de examen incorecte");
        }else{
            System.out.println(examResult.getMarks());
        }
    }



}
