package repository;
import model.Attendance;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AttendanceRepository {

    private String JdbcURl="jdbc:mysql://localhost:3306/hotel_db";
    private String username="root";
    private String password="root";
    private Connection connection=null;
    private Statement statement=null;

    public AttendanceRepository(){
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

    public void insert(Attendance attendance){
        String insert="";
        insert+="insert into attendence (date,student_id,remark,status ) values (";
        insert+=String.format("'%s',%d,'%s','%s'",attendance.getDate(),attendance.getStudentId(),attendance.getRemark());
        insert+=");";
        executeStatement(insert);
    }

    public void delete(String date){
        String delete="";
        delete+=String.format("delete from attendence where date='%s'",date);
        delete+=";";
        executeStatement(delete);
    }

    public void updateDate( String vechi,String nou){

        String update="";
        update+=String.format("update attendence set date='%s'",nou);
        update+=String.format("where date='%s'",vechi);
        executeStatement(update);
    }

    public void updateStudentId( String vechi,String nou){

        String update="";
        update+=String.format("update attendence set student_id=%d",nou);
        update+=String.format("where student_id=%d",vechi);
        executeStatement(update);
    }



    private ResultSet all(){

        executeStatement("select * from attendence");

        try{
            return statement.getResultSet();

        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public List<Attendance>allAttendence(){

        ResultSet set=all();
        List<Attendance> attendances=new ArrayList<>();
        try{
            while(set.next()){
                attendances.add(new Attendance(set.getString(0),set.getInt(1),set.getString(2)));
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return attendances;
    }

}
