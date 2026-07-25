package com.pramod.crud.cruddemo.dao;

import com.pramod.crud.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> findAll();

    List <Student> findByLastName(String lastName);

    void update(Student student);
    void deleteStudentById(Integer id);

    void deleteAll();
}
