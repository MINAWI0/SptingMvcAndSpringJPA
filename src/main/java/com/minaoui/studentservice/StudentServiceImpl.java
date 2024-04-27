package com.minaoui.studentservice;

import com.minaoui.dto.StudentDto;
import com.minaoui.entity.Student;
import com.minaoui.repositorie.StudentRepository;
import lombok.AllArgsConstructor;

import org.apache.coyote.Response;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

//    @Override
//    public Student createStudent(Student student) {
//        Student savedStudent = studentRepository.save(student);
//        return savedStudent;
//    }
    @Override
    public List<Student> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        return students;
    }

}