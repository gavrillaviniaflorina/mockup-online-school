package repository;

import model.Classroom;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ClassroomRepositoryTest {
    @Test
    public void testInsertDelete(){

        Classroom classroom1=new Classroom("CEN1.1");
        Classroom classroom2=new Classroom("CEN1.2");

        ClassroomRepository classroomRepository=new ClassroomRepository();
        classroomRepository.insert(classroom1);
        classroomRepository.insert(classroom2);

        List<Classroom> classroomList=classroomRepository.allClassrooms();
        assertEquals(true,classroomList.contains(classroom1));
        assertEquals(true, classroomList.contains(classroom2));


        classroomRepository.delete(classroom1.getClassroomId());
        classroomRepository.delete(classroom2.getClassroomId());

        classroomList=classroomRepository.allClassrooms();

        assertEquals(false,classroomList.contains(classroom1));
        assertEquals(false, classroomList.contains(classroom2));


    }

}