package io.github.muhittinpalamutcu.schoolmanagementsystem.controller;

import io.github.muhittinpalamutcu.schoolmanagementsystem.entity.Student;
import io.github.muhittinpalamutcu.schoolmanagementsystem.repository.StudentRepository;
import io.github.muhittinpalamutcu.schoolmanagementsystem.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class StudentController {
    private final StudentService studentService;

    // @desc Get all students
    // @route Get /api/students
    // @access Public
    @GetMapping("/students")
    public ResponseEntity<List<Student>> findAll() {
        return new ResponseEntity<>(studentService.findAll(), HttpStatus.OK);
    }

    // @desc Get student by id
    // @route Get /api/students/{id}
    // @access Public
    @GetMapping("/students/{id}")
    public Student findById(@PathVariable int id) {
        return studentService.findById(id);
    }

    // @desc Save a student
    // @route Post /api/students
    // @access Public
    @PostMapping("/students")
    public Student saveStudent(@RequestBody Student student) {
        return studentService.save(student);
    }

    // @desc Update a student
    // @route Put /api/students
    // @access Public
    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student student) {
        return studentService.update(student);
    }

    // @desc Delete student by id
    // @route Delete /api/students/{id}
    // @access Public
    @DeleteMapping("/students/{id}")
    public String deleteStudentById(@PathVariable int id) {
        studentService.deleteById(id);
        return "Student deleted...";
    }

    // @desc Get student by name
    // @route Get /api/students/getByName/{name}
    // @access Public
    @GetMapping("/students/getByName/{name}")
    public Student findById(@PathVariable String name) {
        return studentService.findByName(name);
    }

    // @desc Get student gender with grouping
    // @route Get /students/getGenderWithGrouping
    // @access Public
    @GetMapping("/students/getGenderWithGrouping")
    public List<?> getGenderWithGrouping() {
        return studentService.getGenderWithGrouping();
    }

    // @desc Delete student by name
    // @route Get /api/students/deleteByName/{name}
    // @access Public
    @DeleteMapping("/students/deleteByName/{name}")
    public String deleteStudentByName(@PathVariable String name) {
        studentService.deleteByName(name);
        return "Student deleted...";
    }
}
