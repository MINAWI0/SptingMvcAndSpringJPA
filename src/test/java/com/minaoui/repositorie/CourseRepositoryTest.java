package com.minaoui.repositorie;

import com.minaoui.config.PersistenceJPAConfig;
import com.minaoui.entity.Course;
import com.minaoui.entity.Teacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = PersistenceJPAConfig.class)
public class CourseRepositoryTest {
    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourses(){
        List<Course>  listOfCourses = courseRepository.findAll();
        System.out.println("listOfCourses = " + listOfCourses);
    }

    @Test
    public void saveCoursewithTeacher(){
        Teacher teacher = Teacher.builder()
                .firstName("amrani")
                .lastName("mustafa")
                .build();

        Course course = Course.builder()
                .title("history")
                .credit(600)
                .teacher(teacher)
                .build();
        courseRepository.save(course);
    }

    @Test
    public void findAllPagination(){
        Pageable firstPage3Records =
                PageRequest.of(0,3);
        Pageable secondPage4Records =
                PageRequest.of(0,4);
        List<Course> courses = courseRepository.findAll(secondPage4Records).getContent();
        long totalelements = courseRepository.findAll(secondPage4Records).getTotalElements();
        System.out.println("totalelements = " + totalelements);
        int totalPages = courseRepository.findAll(secondPage4Records).getTotalPages();
        System.out.println("totalPages = " + totalPages);
        
        System.out.println("courses = " + courses);
    }

    @Test
    public void findAllSorting(){
        Pageable sortByTitle = PageRequest.of(0,6,Sort.by("title"));
        Pageable sortbyCreditDecended = PageRequest.of(0,6,Sort.by("credit").descending());
        Pageable sortByTitleAndCreditDesc = PageRequest.of(0,6,Sort.by("title").descending().and(Sort.by("credit")));
        List<Course> courses = courseRepository.findAll(sortbyCreditDecended).getContent();
        System.out.println("courses = " + courses);
    }
    @Test
    public void printFindByTitleContaining(){
        Pageable firstPageTenRecords = PageRequest.of(0,10);
        List<Course>  courses = courseRepository.findByTitleContaining("Sp",firstPageTenRecords).getContent();
        System.out.println("courses = " + courses);

    }

}