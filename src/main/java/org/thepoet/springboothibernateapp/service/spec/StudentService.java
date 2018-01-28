package org.thepoet.springboothibernateapp.service.spec;

import org.thepoet.springboothibernateapp.model.Student;

import java.util.List;

/**
 * @author the Poet <dogan_oguzhan@hotmail.com>
 * @date 26.01.2018
 */
public interface StudentService {
    List<Student> getAllStudentList();

    Student getStudentById(int id);

    boolean addStudent(String name, String surname, int grade);
}
