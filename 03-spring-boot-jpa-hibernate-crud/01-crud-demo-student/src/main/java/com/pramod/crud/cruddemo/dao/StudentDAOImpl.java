package com.pramod.crud.cruddemo.dao;

import com.pramod.crud.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{

    //Define field for entityManger
    private EntityManager entityManager;

    //Define Constructor


    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student theStudent){
        entityManager.persist(theStudent);

    }

    @Override
    public Student findById(Integer id) {
       return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by lastName",Student.class);
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        //create a query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student WHERE lastName =:theData",Student.class);

        //set the data
        theQuery.setParameter("theData",lastName);

        //return the student
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
        entityManager.merge(theStudent);
    }

    @Override
    @Transactional
    public void deleteStudentById(Integer id){
       Student thestudent = entityManager.find(Student.class,id);
        entityManager.remove(thestudent);
    }

    @Override
    @Transactional
    public void deleteAll() {
        int numRowsAffected = entityManager.createQuery("DELETE FROM Student").executeUpdate();
        System.out.println("Number of rows Affected are " +numRowsAffected);
    }


}
