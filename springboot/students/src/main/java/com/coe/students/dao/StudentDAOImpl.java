package com.coe.students.dao;

import org.springframework.stereotype.Repository;

import com.coe.students.models.Student;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class StudentDAOImpl implements StudentDAO {
    private EntityManager entityManager;

    public StudentDAOImpl(EntityManager injectedEntityManager) {
        this.entityManager = injectedEntityManager;
    }

    @Override
    @Transactional
    public void Save(Student student) {
        try {
            this.entityManager.persist(student);
        } catch (Exception e) {
            // roll back savepassId
        }
        
    }

    @Override
    public Student findById(int id) {
        return this.entityManager.find(Student.class, id);
    }

    
}
