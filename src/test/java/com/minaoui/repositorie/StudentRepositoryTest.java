package com.minaoui.repositorie;

import com.minaoui.config.PersistenceJPAConfig;
import com.minaoui.entity.Guardian;
import com.minaoui.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PersistenceJPAConfig.class)
public class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;
    @Test
    public void saveStudent(){
        Student student = Student.builder()
                .emailId("minoauimh@gmail.com")
                .firstName("Mohamed")
                .lastName("Minoaui")
//                .guardianName("hassan")
//                .guradianEmail("hassanMinaoui")
//                .guradianMobile("0791719811")
                .build();
        studentRepository.save(student);
    }
//    saving student with emebede guardian
    @Test
    public void saveSrudentWithGuardien(){
            Guardian guardian =Guardian.builder()
                    .email("fatherOfMohsin@gmail.com")
                    .name("aliFather")
                    .mobile("09990998")
                    .build();
            Student student = Student.builder()
                    .firstName("mohsin")
                    .lastName("clay")
                    .emailId("mohssinemail@gmail.com")
                    .guardian(guardian)
                    .build();
            studentRepository.save(student);
    }

    @Test
    public void printAllStudent(){
        List<Student> studentList = studentRepository.findAll();
        System.out.println("studentList = " + studentList);
    }
    @Test
    public void printStudentByFirstName(){
        List<Student> studentList = studentRepository.findByFirstName("ali");
        System.out.println("studentList = " + studentList);
    }
    @Test
    public void printStudentByFirstNameContaining(){
        List<Student> studentList = studentRepository.findByFirstNameContaining("ame");
        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printStudentByEmailAdress(){
        Student StudentByEmail = studentRepository.findByEmailAdress("minoauimh@gmai.com");
        System.out.println("StudentByEmail = " + StudentByEmail);
    }
    @Test
    public void printStudentfirstNameByEmailAdress(){
        String studentFirstNameByEmail = studentRepository.findStudentFirstNameByEmailAdress("minoauimh@gmail.com");
        System.out.println("StudentFristNameByEmail = " + studentFirstNameByEmail);
    }
    //testng jpql
    @Test
    public void printGuradianByStudentLastName(){
        Guardian GuradianByStudentLastName = studentRepository.findStudentGuardianByLastName("clay");
        System.out.println("GuradianByStudentLastName = " + GuradianByStudentLastName);
    }
//    testing naive query
    @Test
    public void printEmailAddressByGuardianName(){
        String EmailAddressByGuardianName = studentRepository.findEmailAddressByGuardianName("hassan");
        System.out.println("EmailAddressByGuardianName = " + EmailAddressByGuardianName);
    }
    @Test
    public void printGuradianMobileByGuardianNameParam(){
        String GuradianMobileByGuardianNameParam = studentRepository.findGuradianMobileByGuardianNameParam("aliFather");
        System.out.println("GuradianMobileByGuardianNameParam = " + GuradianMobileByGuardianNameParam);
    }
    @Test
    public void updateStudentNameByEmailIdTest(){
        int updateResult = studentRepository.updateStudentNameByEmailId("newAli","aliclay@gmail.com");
        System.out.println("updateResult = " + updateResult);
    }
}