package view;

import controller.CourseController;
import controller.ExamResultController;
import controller.TeacherController;
import model.Course;
import model.ExamResult;
import model.Student;
import model.Teacher;
import repository.TeacherRepository;

import java.util.List;
import java.util.Scanner;

public class ViewTeacher {

    private Teacher teacher;
    private CourseController courseController;
    private ExamResultController examResultController;
    private TeacherController teacherController;
    private Scanner scanner;


    public ViewTeacher(Teacher teacher) {

        this.teacher=teacher;
        this.courseController = new CourseController();
        this.examResultController = new ExamResultController();
        this.teacherController = new TeacherController();
        this.scanner = new Scanner(System.in);

    }

    private String meniu() {
        String text = "";
        text += "Apasati tasta 0 pentru a incheia \n";
        text += "Apasati tasta 1 pentru a va schimba mailul\n";
        text += "Apasati tasta 2 pentru a va schimba parola\n";
        text += "Apasati tasta 3 pentru a vedea toate cursurile pe care le predati\n";
        text += "Apasati tasta 4 pentru a schimba nota  unui student la un examen\n";
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
                    courses();
                    break;
                case 4:
                    studentResult();
                    break;

                default:
                    System.out.println(meniu());
                    break;


            }
        }
    }

    private void updateMail() {

        String nume = this.teacher.getLastLogin();

        String prenume = this.teacher.getFirstName();
        System.out.println("Introduceti noul email");
        String email = scanner.nextLine();

        Teacher teacher = teacherController.numePrenumeTeacher(nume, prenume);
        if (teacher.getTeacher_id() == -1) {
            System.out.println("Nume sau prenume incorecte");
        } else {

            teacherController.updateEmail(teacher.getTeacher_id(), email);
        }
    }

    private void updateParola() {
        String nume = this.teacher.getLastLogin();

        String prenume = this.teacher.getFirstName();

        System.out.println("Introduceti noua parola");
        String parola = scanner.nextLine();

        Teacher teacher = teacherController.numePrenumeTeacher(nume, prenume);
        if (teacher.getTeacher_id() == -1) {
            System.out.println("Nume sau prenume incorecte");
        } else {

            teacherController.updatePassword(teacher.getTeacher_id(), parola);
        }
    }

    private void courses(){

        int id=this.teacher.getTeacher_id();

        List<Course> all=courseController.predate(id);
        for(Course course:all){
            System.out.println(course.getCourseName());
        }

        if(all.size()==0){
            System.out.println("Nu predati niciun curs in prezent");
        }
    }

    private void studentResult(){
        System.out.println("Introduceti id-ul studentului");
        int idStudent=Integer.parseInt(scanner.nextLine());
        System.out.println("Introduceti id-ul examenului");
        int idExamen=Integer.parseInt(scanner.nextLine());

        ExamResult examResult=examResultController.result(idStudent,idExamen);

        System.out.println("Introduceti noua nota");
        int mark=Integer.parseInt(scanner.nextLine());

        examResultController.updateMarks(examResult.getExamResultId(),mark);
    }

}
