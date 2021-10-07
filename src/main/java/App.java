import model.Classroom;
import model.ClassroomStudent;
import model.Course;
import repository.ClassroomRepository;
import repository.ClassroomStudentRepository;
import repository.CourseRepository;

public class App {


    public static void main(String[] args) {

  ClassroomRepository repository=new ClassroomRepository();
  Classroom classroom=new Classroom("CEN");
  repository.insert(classroom);


    }
}
