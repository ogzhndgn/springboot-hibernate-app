package org.thepoet.springboothibernateapp.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.thepoet.springboothibernateapp.model.Student;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


/**
 * @author the Poet <dogan_oguzhan@hotmail.com>
 * @date 25.01.2018
 */
@Transactional
@Repository
public class StudentDaoImpl {

    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public List<Student> getAll() {
        String hql = "FROM " + Student.class.getName() + " ORDER BY id";
        return (List<Student>) entityManager.createQuery(hql).getResultList();
    }

    public Student getById(int id) {
        return entityManager.find(Student.class, id);
    }

    public List<Student> queryFirstByGradeGreaterThanAnd(int grade) {
        return null;
    }
    
    public void add(Student student) {
        entityManager.persist(student);
    }

    public void update(Student student) {
        entityManager.persist(student);
    }
}