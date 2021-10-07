package controller;

import model.ExamResult;
import repository.ExamResultRepository;

public class ExamResultController {

    private ExamResultRepository examResultRepository;

    public ExamResultController() {
        this.examResultRepository=new ExamResultRepository();
    }

    public void insert(ExamResult examResult){
        examResultRepository.insert(examResult);
    }

    public boolean exist(ExamResult examResult){
        for(ExamResult examResult1: examResultRepository.allExamResults()){
            if(examResult.equals(examResult1)){
                return true;
            }
        }
        return false;
    }

    public ExamResult examResult(int id){
        for(ExamResult examResult: examResultRepository.allExamResults()){
            if(examResult.getExamResultId()==id){
                return examResult;
            }
        }
        return new ExamResult(-1,-1,-1);
    }

    public void delete(int id){
        if(exist(examResult(id))==true){
            examResultRepository.delete(id);
            System.out.println("The exam result was deleted.");
        }else{
            System.out.println("The exam reslut does not exist.");
        }
    }

    public void updateStudentId(int id, int studentId){
        if(exist(examResult(id))==true){
            examResultRepository.updateStundentID(id,studentId);
            System.out.println("The student id was updated");
        }else{
            System.out.println("The exam result does not exist.");
        }
    }
}
