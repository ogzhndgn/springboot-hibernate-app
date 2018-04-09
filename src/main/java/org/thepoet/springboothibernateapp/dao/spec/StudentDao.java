package org.thepoet.springboothibernateapp.dao.spec;

import org.springframework.data.repository.CrudRepository;
import org.thepoet.springboothibernateapp.model.Student;

import java.util.List;

/**
 * @author the Poet <dogan_oguzhan@hotmail.com>
 * @date 25.01.2018
 */
public interface StudentDao extends CrudRepository<Student, Long> {
    List<Student> getAllByGradeGreaterThan(int grade);

    Student getById(int id);

    List<Student> getAll();

    List<Student> getAllByName(String name);

    List<Student> getAllBySurname(String surname);

}
