package repository;


import model.ClassroomStudent;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClassroomStudentRepository {

    private String JdbcURl="jdbc:mysql://localhost:3306/online-school.db";
    private String username="root";
    private String password="root";
    private Connection connection=null;
    private Statement statement=null;

    public ClassroomStudentRepository(){
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

    public void insert(ClassroomStudent classroomStudent){
        String insert="";
        insert+="insert into classroom_student (student_id,classroom_id) values (";
        insert+=String.format("%d,%d",classroomStudent.getStudentId(),classroomStudent.getClassroomId());
        insert+=");";
        executeStatement(insert);
    }

    public void delete(int classroomStudentID){
        String delete="";
        delete+=String.format("delete from classroom_student where classroom_student_id=%d",classroomStudentID);
        delete+=";";
        executeStatement(delete);
    }

    public void updateClassroomStudentId( int classroomStudentId,int classroomId){

        String update="";
        update+=String.format("update classroom_student set classroom_id=%d",classroomId);
        update+=String.format("where classroom_student_id=%d",classroomStudentId);
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

    public List<ClassroomStudent> allClassroomStudents(){

        ResultSet set=all();
        List<ClassroomStudent> attendances=new ArrayList<>();
        try{
            while(set.next()){
                attendances.add(new ClassroomStudent(set.getInt(1),set.getInt(2)));
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return attendances;
    }

}
