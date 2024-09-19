package com.example.SpringDemo;


import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
//import org.springframework.transaction.annotation.Transactional;

@Repository
public class StudentImpl implements StudentDao{


    private EntityManager manager ;

    @Autowired
    public StudentImpl(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    @Transactional
    public void save(StudentEntity student) {
        manager.persist(student);

    }

    @Override
    public StudentEntity findById(Integer id) {
        return manager.find(StudentEntity.class,id);
    }

    @Override
    public List<StudentEntity> findAll() {

        TypedQuery<StudentEntity> theQuery = manager.createQuery("FROM StudentEntity", StudentEntity.class);

        return theQuery.getResultList();
    }

    @Override
    public List<StudentEntity> findByLastName(String lastName) {
        TypedQuery<StudentEntity> query = manager.createQuery("FROM StudentEntity WHERE lastName=:theData", StudentEntity.class);

        // set query parameters
        query.setParameter("theData", lastName);

        return query.getResultList();
    }

    @Override
    @Transactional
    public void updateStudentDetails(StudentEntity student) {
        manager.merge(student);

    }

    @Override
    public void deleteStudent(Integer id) {
        //This comment is added

//        new comment by sagar

        StudentEntity student = manager.find(StudentEntity.class,id);
        manager.remove(student);
    }
}
