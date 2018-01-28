package org.thepoet.springboothibernateapp.dao.spec;

import org.thepoet.springboothibernateapp.model.Student;

import java.util.List;

/**
 * @author the Poet <dogan_oguzhan@hotmail.com>
 * @date 25.01.2018
 */
public interface StudentDao {
    List<Student> getAll();

    Student getById(int id);

    void add(Student student);

    void update(Student student);
}
