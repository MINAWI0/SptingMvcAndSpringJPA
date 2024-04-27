package com.minaoui.controller;


import com.minaoui.entity.Student;
import com.minaoui.studentservice.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/Students")
public class StudentController {

    private StudentService studentService;

    @GetMapping("/all")
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> employees =  studentService.getAllStudents();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }
}