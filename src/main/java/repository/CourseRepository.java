package repository;

import model.Course;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseRepository {

    private String JdbcURl="jdbc:mysql://localhost:3306/online-school.db";
    private String username="root";
    private String password="root";
    private Connection connection=null;
    private Statement statement=null;

    public CourseRepository(){
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

    public void insert(Course course){
        String insert="";
        insert+="insert into course (course_name,teacher_id,classroom_id) values (";
        insert+=String.format("'%s',%d ,%d",course.getCourseName(),course.getTeacher_id(),course.getClassroom_id());
        insert+=");";
        executeStatement(insert);
    }

    public void delete(int courseId){
        String delete="";
        delete+=String.format("delete from course where course_id=%d",courseId);
        delete+=";";
        executeStatement(delete);
    }

    public void updateCourseName( int courseID,String courseName){

        String update="";
        update+=String.format("update classroom set course_name='%s'",courseName);
        update+=String.format("where course_id=%d",courseID);
        executeStatement(update);
    }


    public void updateTeacherId( int courseID,int teacherId){

        String update="";
        update+=String.format("update course set teacher_id='%s'",teacherId);
        update+=String.format("where course_id=%d",courseID);
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

    public List<Course>allCourses(){

        ResultSet set=all();
        List<Course> attendances=new ArrayList<>();
        try{
            while(set.next()){
                attendances.add(new Course(set.getString(1),set.getInt(2),set.getInt(3)));
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return attendances;
    }

}
