package com.minaoui.repositorie;


import com.minaoui.entity.Guardian;
import com.minaoui.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    public List<Student> findByFirstName(String firstName);
    public List<Student> findByFirstNameContaining(String name);



    //JPQL
    @Query("select s from Student s where s.emailId = ?1")
    public Student findByEmailAdress(String emailId);
    @Query("select s.firstName from Student s where s.emailId = ?1")
    public String findStudentFirstNameByEmailAdress(String emailId);
    @Query("select s.guardian from Student s where s.lastName = ?1")
    public Guardian findStudentGuardianByLastName(String lastName);


    //SQL Query
    @Query(value ="select email_address from tbl_student where guardianName = ?1",nativeQuery = true)
    public String findEmailAddressByGuardianName(String guardianName);

    //Query With named Param
    @Query(value ="select guradianMobile from tbl_student where guardianName = :guardianName",nativeQuery = true)
    public String findGuradianMobileByGuardianNameParam(@Param("guardianName") String guardianName);
    //Update Example

    @Modifying
    @Transactional
    @Query(
            value = "update tbl_student set firstName=?1 where email_address = ?2",
            nativeQuery = true
    )
    int updateStudentNameByEmailId(String firstName , String emailId);
}
