import model.Classroom;
import model.ClassroomStudent;
import model.Course;
import repository.ClassroomRepository;
import repository.ClassroomStudentRepository;
import repository.CourseRepository;

public class App {


    public static void main(String[] args) {

     CourseRepository rep=new CourseRepository();
     Course course=new Course("mate");
     rep.insert(course);


    }
}
