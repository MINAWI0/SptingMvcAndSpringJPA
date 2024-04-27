package com.minaoui.repositorie;

import com.minaoui.config.PersistenceJPAConfig;
import com.minaoui.entity.Course;
import com.minaoui.entity.Teacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PersistenceJPAConfig.class)
public class TeacherRepositoryTest {
    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    public void saveTeacher() {
        Course courseDroit = Course.builder()
                .title("Droit")
                .credit(330)
                .build();
        Course courseOracle = Course.builder()
                .title("orcla")
                .credit(3330)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Batal")
                .lastName("ahmed")
//                .courses(List.of(courseDroit,courseOracle))
                .build();
        teacherRepository.save(teacher);
    }

}