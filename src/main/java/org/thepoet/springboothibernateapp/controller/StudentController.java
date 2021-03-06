package org.thepoet.springboothibernateapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.util.UriComponentsBuilder;
import org.thepoet.springboothibernateapp.model.Student;
import org.thepoet.springboothibernateapp.service.spec.StudentService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author the Poet <dogan_oguzhan@hotmail.com>
 * @date 26.01.2018
 */
@Controller
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping("students")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> studentList = studentService.getAllStudentList();
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }

    @GetMapping("student/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") int id) {
        Student student = studentService.getStudentById(id);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PostMapping("student/add")
    public ResponseEntity<Void> addStudent(HttpServletRequest request, UriComponentsBuilder builder) {
        boolean result = studentService.addStudent(request.getParameter("name"), request.getParameter("surname"), Integer.parseInt(request.getParameter("grade")));
        if (!result) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("students").build().toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    @PostMapping("student/update")
    public ResponseEntity<Void> updateStudent(HttpServletRequest request, UriComponentsBuilder builder) {
        int studentId = Integer.parseInt(request.getParameter("id"));
        int newGrade = Integer.parseInt(request.getParameter("newGrade"));
        boolean result = studentService.updateStudent(studentId, newGrade);
        if (!result) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("students").build().toUri());
        return new ResponseEntity<>(headers, HttpStatus.OK);
    }

    @PostMapping("student/getallbyname")
    public ResponseEntity<List<Student>> getAllByName(HttpServletRequest request) {
        String name = request.getParameter("name");
        List<Student> studentList = studentService.getStudentListByName(name);
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }

    @PostMapping("student/getallbygrade")
    public ResponseEntity<List<Student>> getAllStudentGreaterGrade(HttpServletRequest request) {
        String grade = request.getParameter("grade");
        List<Student> studentList = studentService.getAllStudentsByGrade(Integer.parseInt(grade));
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }
}