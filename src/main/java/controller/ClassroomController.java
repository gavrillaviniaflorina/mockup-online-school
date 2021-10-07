package controller;

import model.Classroom;
import repository.ClassroomRepository;

import java.util.List;

public class ClassroomController {

    private ClassroomRepository classroomRepository;

    public ClassroomController() {
        this.classroomRepository = new ClassroomRepository();
    }

    private boolean exist(Classroom classroom){

        List<Classroom> classrooms=classroomRepository.allClassrooms();

        for (Classroom clasroom1:classrooms){
            if(classroom.equals(clasroom1)){
                return true;
            }
        }
        return false;
    }

    public void insert(Classroom classroom){
        if(exist(classroom)==false) {
            classroomRepository.insert(classroom);
            System.out.println("The classroom was inserted.");
        }else{
            System.out.println("This classroom already exists");
        }

    }

    public Classroom classroom(int id){
        List<Classroom> classrooms=classroomRepository.allClassrooms();
        for(Classroom classroom1:classrooms){
            if(classroom1.getClassroomId()==id){
                return classroom1;
            }
        }
        return new Classroom(-1,"");
    }

    public void delete(int id){
        if(exist(classroom(id))==true){
            classroomRepository.delete(id);
            System.out.println("The classroom was deleted");
        }else{
            System.out.println("The classroom does not exist");
        }
    }

    public void updateClassroomName(int id,String name){
        if(exist(classroom(id))==true){
            classroomRepository.updateClassroomName(id,name);
            System.out.println("The name was updated");
        }else{
            System.out.println("The classroom does not exist");
        }
    }

    public void print(){
      for(Classroom classroom:classroomRepository.allClassrooms()){
          System.out.println(classroom.description());
      }
    }





}
