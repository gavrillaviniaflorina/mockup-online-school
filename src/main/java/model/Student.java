package model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student  implements Comparable<Student> {

    private int student_id;
    private String last_name;
    private String first_name;
    private String email;
    private String password;
    private String lastLogin;
    private boolean status;




    public Student(String last_name, String first_name, String email, String password, String lastLogin, boolean status) {
        this.last_name = last_name;
        this.first_name = first_name;
        this.email = email;
        this.password = password;
        this.lastLogin = lastLogin;

    }

    public String description(){
        String text="";
        text+="ID student:"+this.student_id;
        text+="Student's last name:"+this.last_name;
        text+="Student's first name:"+this.first_name;
        text+="Student's email:"+this.email;
        text+="Student's password:"+this.password;
        text+="Student's last login date:"+this.lastLogin;
        text+="Student's status:"+this.status;
        return text;
    }

    @Override
    public String toString() {
        String text="";
        text+=this.student_id+","+this.last_name+","+this.first_name+","+this.email+","+this.password+","+this.lastLogin+","+this.status;
        return text;
    }

    @Override
    public boolean equals(Object obj) {
        Student student=(Student)obj;
        return this.student_id==student.getStudent_id();
    }

    @Override
    public int compareTo(Student student){

        if(this.getStudent_id()>getStudent_id()){
            return 1;
        }else if(this.getStudent_id()<getStudent_id()){
            return -1;
        }
        return 0;
    }
}
