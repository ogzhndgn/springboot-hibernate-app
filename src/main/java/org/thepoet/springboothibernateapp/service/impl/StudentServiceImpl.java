package org.thepoet.springboothibernateapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thepoet.springboothibernateapp.dao.spec.StudentDao;
import org.thepoet.springboothibernateapp.model.Student;
import org.thepoet.springboothibernateapp.service.spec.StudentService;

import java.util.List;

/**
 * @author the Poet <dogan_oguzhan@hotmail.com>
 * @date 26.01.2018
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public List<Student> getAllStudentList() {
        return studentDao.getAll();
    }

    @Override
    public Student getStudentById(int id) {
        return studentDao.getById(id);
    }

    @Override
    public boolean addStudent(String name, String surname, int grade) {
        try {
            Student student = new Student();
            student.setName(name);
            student.setSurname(surname);
            student.setGrade(grade);
            studentDao.add(student);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateStudent(int id, int newGrade) {
        try {
            Student student = this.getStudentById(id);
            student.setGrade(newGrade);
            studentDao.update(student);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}