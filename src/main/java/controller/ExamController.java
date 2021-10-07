package controller;

import model.Exam;
import repository.ExamRepository;

public class ExamController {

    private ExamRepository examRepository;


    public ExamController() {
        this.examRepository=new ExamRepository();
    }

    public boolean exist(Exam exam){
        for(Exam exam1:examRepository.allExams()){
            if(exam1.equals(exam)){
                return true;
            }
        }
        return false;
    }

    public void insert(Exam exam){

        examRepository.insert(exam);
        System.out.println("The exam was inserted");
    }

    public void delete(int id){

        if(exist(exam(id))==true) {
            examRepository.delete(id);
            System.out.println("The exam was deleted");
        }else{
            System.out.println("The exam does not exist");
        }
    }


    private Exam exam(int id){
        for(Exam exam: examRepository.allExams()){
            if(exam.getExamId()==id){
                return exam;
            }
        }
        return new Exam(-1,-1,"");
    }

    public void updateStartDate(int id, String startDate){
        if(exist(exam(id))==true){
            examRepository.updateStardDate(id,startDate);
            System.out.println("The start date was updated.");
        }
        else {
            System.out.println("The exam does not exist.");
        }

    }

    public void updateCourseId(int id, int courseId){
        if(exist(exam(id))==true){
            examRepository.updateCourseID(id,courseId);
            System.out.println("The course id was updated.");
        }else{
            System.out.println("The exam does ot exist.");
        }
    }

    public void print(){
        for(Exam exam: examRepository.allExams()){
            System.out.println(exam.description());
        }
    }
}
