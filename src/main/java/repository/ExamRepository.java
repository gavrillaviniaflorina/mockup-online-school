package repository;

import model.Exam;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class ExamRepository {

    private String JdbcURl="jdbc:mysql://localhost:3306/hotel_db";
    private String username="root";
    private String password="root";
    private Connection connection=null;
    private Statement statement=null;

    public ExamRepository(){
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

    public void insert(Exam exam){
        String insert="";
        insert+="insert into exam (course_id,start_date ) values (";
        insert+=String.format("%d,'%s'",exam.getCourse_id(),exam.getDate());
        insert+=");";
        executeStatement(insert);
    }

    public void delete(int examID){
        String delete="";
        delete+=String.format("delete from exam where exam_id=%d",examID);
        delete+=";";
        executeStatement(delete);
    }

    public void updateCourseID( int examID,int courseId){

        String update="";
        update+=String.format("update exam set course_id=%d",courseId);
        update+=String.format("where exam_id=%d",examID);
        executeStatement(update);
    }

    public void updateStardDate( int examID,String startDate){

        String update="";
        update+=String.format("update exam set start_date='%s'",startDate);
        update+=String.format("where exam_id=%d",examID);
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

    public List<Exam>allExams(){

        ResultSet set=all();
        List<Exam> attendances=new ArrayList<>();
        try{
            while(set.next()){
                attendances.add(new Exam(set.getInt(1),set.getString(2)));
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return attendances;
    }

}

