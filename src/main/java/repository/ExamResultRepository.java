package repository;

import model.ExamResult;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExamResultRepository {

    private String JdbcURl="jdbc:mysql://localhost:3306/hotel_db";
    private String username="root";
    private String password="root";
    private Connection connection=null;
    private Statement statement=null;

    public ExamResultRepository(){
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

    public void insert(ExamResult examResult){
        String insert="";
        insert+="insert into exam_result (student_id,exam_id,marks ) values (";
        insert+=String.format("%d,%d,%d",examResult.getStudentId(),examResult.getExamId(),examResult.getMarks());
        insert+=");";
        executeStatement(insert);
    }

    public void delete(int examResultId){
        String delete="";
        delete+=String.format("delete from exam_result where exam_result_id=%d",examResultId);
        delete+=";";
        executeStatement(delete);
    }

    public void updateStundentID( int examResultID,int studentID){

        String update="";
        update+=String.format("update exam_result set student_id=%d",studentID);
        update+=String.format("where exam_result_id=%d",examResultID);
        executeStatement(update);
    }

    public void updateExamID( int examResultID,int examId){

        String update="";
        update+=String.format("update exam_result set exam_id=%d",examId);
        update+=String.format("where exam_result_id=%d",examResultID);
        executeStatement(update);
    }

    public void updateMarksID( int examResultID,int marks){

        String update="";
        update+=String.format("update exam_result set marks=%d",marks);
        update+=String.format("where exam_result_id=%d",examResultID);
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

    public List<ExamResult>allClassrooms(){

        ResultSet set=all();
        List<ExamResult> attendances=new ArrayList<>();
        try{
            while(set.next()){
                attendances.add(new ExamResult(set.getInt(1),set.getInt(2),set.getInt(3)));
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return attendances;
    }
}
