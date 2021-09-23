package model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor

public class Teacher implements Comparable<Teacher> {

  private int teacher_id;
  private String lastName;
  private String firstName;
  private String email;
  private String password;
  private String lastLogin;
  private boolean status;

    public Teacher(String lastName, String firstName, String email, String password, String lastLogin, boolean status) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.password = password;
        this.lastLogin = lastLogin;
        this.status = status;
    }

    public String description(){
        String text="";
        text+="ID teacher:"+this.teacher_id;
        text+="Teacher's last name:"+this.lastName;
        text+="Teacher's first name:"+this.firstName;
        text+="Teacher's email:"+this.email;
        text+="Teacher's password:"+this.password;
        text+="Teacher's last login date:"+this.lastLogin;
        text+="Teacher's status:"+this.status;
        return text;
    }

    @Override
    public String toString() {
        String text="";
        text+=this.teacher_id+","+this.lastName+","+this.firstName+","+this.email+","+this.password+","+this.lastLogin+","+this.status;
        return text;
    }

    @Override
    public boolean equals(Object obj) {
        Teacher teacher=(Teacher)obj;
        return this.teacher_id==teacher.getTeacher_id();
    }

    @Override
    public int compareTo(Teacher teacher){

        if(this.getTeacher_id()>teacher.getTeacher_id()){
            return 1;
        }else if(this.getTeacher_id()<teacher.getTeacher_id()){
            return -1;
        }
        return 0;
    }

}
