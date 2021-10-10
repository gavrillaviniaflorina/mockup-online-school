package repository;


import model.Teacher;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class TeacherRepository {

    private String JdbcURl="jdbc:mysql://localhost:3306/online-school.db";
    private String username="root";
    private String password="root";
    private Connection connection=null;
    private Statement statement=null;

    public TeacherRepository(){
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

    public void insert(Teacher teacher){
        String insert="";
        insert+="insert into teacher (last_name,first_name,email,password,last_login_date ) values (";
        insert+=String.format("'%s','%s','%s','%s','%s'",teacher.getLastName(),teacher.getFirstName(),teacher.getEmail(),teacher.getPassword(),teacher.getLastLogin());
        insert+=");";
        executeStatement(insert);
    }

    public void delete(int teacherId){
        String delete="";
        delete+=String.format("delete from teacher where teacher_id=%d",teacherId);
        delete+=";";
        executeStatement(delete);
    }

    public void updateLastName( int teacherID,String replace){

        String update="";
        update+=String.format("update teacher set last_name='%s'",replace);
        update+=String.format("where teacher_id=%d",teacherID);
        executeStatement(update);
    }


    public void updateFirstName( int teacherID,String replace){

        String update="";
        update+=String.format("update teacher set first_name='%s'",replace);
        update+=String.format("where teacher_id=%d",teacherID);
        executeStatement(update);
    }

    public void updateEmail( int teacherID,String replace){

        String update="";
        update+=String.format("update teacher set email='%s'",replace);
        update+=String.format("where teacher_id=%d",teacherID);
        executeStatement(update);
    }

    public void updatePassword( int teacherId,String replace){

        String update="";
        update+=String.format("update teacher set password='%s'",replace);
        update+=String.format("where teacher_id=%d",teacherId);
        executeStatement(update);
    }

    public void updateLastLoginDate( int teacherID,String replace){

        String update="";
        update+=String.format("update teacher set last_login_date='%s'",replace);
        update+=String.format("where teacher_id=%d",teacherID);
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

    public List<Teacher> allTeachers(){

        ResultSet set=all();
        List<Teacher> attendances=new ArrayList<>();
        try{
            while(set.next()){
                attendances.add(new Teacher(set.getString(1),set.getString(2),set.getString(3),set.getString(4),set.getString(5),set.getBoolean(6)));
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return attendances;
    }
}
