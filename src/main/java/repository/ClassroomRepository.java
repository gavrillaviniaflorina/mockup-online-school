package repository;


import model.Classroom;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class ClassroomRepository {

    private String JdbcURl="jdbc:mysql://localhost:3306/hotel_db";
    private String username="root";
    private String password="root";
    private Connection connection=null;
    private Statement statement=null;

    public ClassroomRepository(){
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

    public void insert(Classroom classroom){
        String insert="";
        insert+="insert into classroom (classroom_id,year,teacher_id,subject_name ) values (";
        insert+=String.format("%d,'%s',%d,'%s'",classroom.getClassroomId(),classroom.getYear(),classroom.getTeacherId(),classroom.getSubjectName());
        insert+=");";
        executeStatement(insert);
    }

    public void delete(int classroomId){
        String delete="";
        delete+=String.format("delete from classroom where classroom_id=%d",classroomId);
        delete+=";";
        executeStatement(delete);
    }

    public void updateYear( int classroomId,int year){

        String update="";
        update+=String.format("update classroom set year=%d",year);
        update+=String.format("where classroom_id=%d",classroomId);
        executeStatement(update);
    }

    public void updateTeacherId( int classroomId,int teacherId){

        String update="";
        update+=String.format("update classroom set teacher_id=%d",teacherId);
        update+=String.format("where classroom_id=%d",classroomId);
        executeStatement(update);
    }

    public void updateSubjectName( int classroomId,String subjectName){

        String update="";
        update+=String.format("update classroom set subject_name='%s'",subjectName);
        update+=String.format("where classroom_id=%d",classroomId);
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

    public List<Classroom>allClassrooms(){

        ResultSet set=all();
        List<Classroom> attendances=new ArrayList<>();
        try{
            while(set.next()){
                attendances.add(new Classroom(set.getInt(1),set.getInt(2),set.getString(3)));
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return attendances;
    }

}
