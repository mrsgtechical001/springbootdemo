package com.example.SpringDemo;

import java.util.List;

public interface StudentDao {

    void save(StudentEntity student);

    StudentEntity findById(Integer id);

    List<StudentEntity> findAll();

    List<StudentEntity> findByLastName(String lastName);
    
    void updateStudentDetails(StudentEntity student);

    void deleteStudent(Integer id);

    int deleteAll();


}
