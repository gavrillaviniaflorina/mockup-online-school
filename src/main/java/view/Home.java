package view;

import controller.StudentController;
import controller.TeacherController;
import model.Student;
import model.Teacher;

import java.util.Scanner;

public class Home {

    private ViewLogin login;
    private TeacherController teachers;
    private StudentController students;
    private Scanner scanner;

    public Home() {

        this.login = new ViewLogin();
        this.teachers = new TeacherController();
        this.students = new StudentController();
        this.scanner = new Scanner(System.in);
    }

    private String meniu() {
        String text = "";
        text += "Apasati tasta 0 pentru a incheia \n";
        text += "Apasati tasta 1 pentru a va loga \n";
        text += "Apasati tasta 2 pentru a vedea toti profesorii \n";
        text += "Apasati tasta 3 pentru a vedea toti elevii \n";
        text += "Apasati tasta 4 pentru a cauta un profesor \n";
        text += "Apasati tasta 5 pentru a cauta un elev \n";

        return text;

    }

    private void seeTeachers() {
        teachers.print();
    }

    private void seeStudents() {
        students.print();
    }

    private void searchTeacher() {
        System.out.println("Introduceti numele profesorului pe care il cautati:");
        String nume = scanner.nextLine();
        System.out.println("Intriduceti prenumele profesoruli pe care il cautati:");
        String prenume = scanner.nextLine();

        for (Teacher teacher : teachers.teachers()) {
            if (teacher.getLastName().equals(nume) && teacher.getFirstName().equals(prenume)) {
                System.out.println(teacher.description());
            }
        }


    }

    private void searchStudent() {
        System.out.println("Introduceti numele studentului pe care il cautati:");
        String nume = scanner.nextLine();
        System.out.println("Intriduceti prenumele studentului pe care il cautati:");
        String prenume = scanner.nextLine();

        for (Student student : students.students()) {
            if (student.getLast_name().equals(nume) && student.getFirst_name().equals(prenume)) {
                System.out.println(student.description());
            }
        }
    }


    public void play() {

        boolean run=true;
        while(run){

            System.out.println(meniu());
            int alegere=Integer.parseInt(scanner.nextLine());
            switch (alegere){
                case 0:
                    run=false;
                    break;
                case 1:
                    login.play();
                    break;
                case 2:
                    seeTeachers();
                    break;
                case 3:
                    seeStudents();
                    break;
                case 5:
                    searchTeacher();
                    break;
                case 6:
                    searchStudent();
                    break;
                default:
                    System.out.println(meniu());
                    break;
            }
        }
    }
}
