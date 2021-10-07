package repository;


import model.ExamResult;
import model.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class StudentRepository {
    private String JdbcURl="jdbc:mysql://localhost:3306/hotel_db";
    private String username="root";
    private String password="root";
    private Connection connection=null;
    private Statement statement=null;

    public StudentRepository(){
        try {
            connection = DriverManager.getConnection(JdbcURl, username, password);
            statement = connection.createStatement();
            // System.out.println("S-a conectat");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    private void executeStatement(String execute){

        try{
            statement.execute(execute);

        }catch (SQLException e){
            System.out.println("Nu am reusit "+ execute);
        }
    }

    public void insert(Student student){
        String insert="";
        insert+="insert into student (last_name,first_name,email,password,last_login_date ) values (";
        insert+=String.format("'%s','%s','%s','%s','%s'",student.getLast_name(),student.getFirst_name(),student.getEmail(),student.getPassword(),student.getLastLogin());
        insert+=");";
        executeStatement(insert);
    }

    public void delete(int studentID){
        String delete="";
        delete+=String.format("delete from student where student_id=%d",studentID);
        delete+=";";
        executeStatement(delete);
    }

    public void updateLastName( int studentID,String replace){

        String update="";
        update+=String.format("update student set last_name='%s'",replace);
        update+=String.format("where student_id=%d",studentID);
        executeStatement(update);
    }


    public void updateFirstName( int studentID,String replace){

        String update="";
        update+=String.format("update student set first_name='%s'",replace);
        update+=String.format("where student_id=%d",studentID);
        executeStatement(update);
    }

    public void updateEmail( int studentID,String replace){

        String update="";
        update+=String.format("update student set email='%s'",replace);
        update+=String.format("where student_id=%d",studentID);
        executeStatement(update);
    }

    public void updatePassword( int studentID,String replace){

        String update="";
        update+=String.format("update student set password='%s'",replace);
        update+=String.format("where student_id=%d",studentID);
        executeStatement(update);
    }

    public void updateLastLoginDate( int studentID,String replace){

        String update="";
        update+=String.format("update student set last_login_date='%s'",replace);
        update+=String.format("where student_id=%d",studentID);
        executeStatement(update);
    }

    private ResultSet all(){

        executeStatement("select * from classroom");

        try{
            return statement.getResultSet();

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<Student> allStudents(){

        ResultSet set=all();
        List<Student> attendances=new ArrayList<>();
        try{
            while(set.next()){
                attendances.add(new Student(set.getString(1),set.getString(2),set.getString(3),set.getString(4),set.getString(5),set.getBoolean(6)));
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return attendances;
    }
}
