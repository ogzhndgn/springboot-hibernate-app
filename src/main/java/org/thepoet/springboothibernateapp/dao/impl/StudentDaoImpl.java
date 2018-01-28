package org.thepoet.springboothibernateapp.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.thepoet.springboothibernateapp.dao.spec.StudentDao;
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
public class StudentDaoImpl implements StudentDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @SuppressWarnings("unchecked")
    public List<Student> getAll() {
        String hql = "FROM " + Student.class.getName() + " ORDER BY id";
        return (List<Student>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public Student getById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public void add(Student student) {
        entityManager.persist(student);
    }
}