package com.coe.students.dao;

import com.coe.students.models.Student;

public interface StudentDAO {
    void Save(Student student);

    Student findById(int id);
}
