package io.github.muhittinpalamutcu.schoolmanagementsystem.controller;

import io.github.muhittinpalamutcu.schoolmanagementsystem.entity.Course;
import io.github.muhittinpalamutcu.schoolmanagementsystem.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class CourseController {

    private final CourseService courseService;

    // @desc Get all courses
    // @route Get /api/courses
    // @access Public
    @GetMapping("/courses")
    public ResponseEntity<List<Course>> findAll() {
        return new ResponseEntity<>(courseService.findAll(), HttpStatus.OK);
    }

    // @desc Get course by id
    // @route Get /api/courses/{id}
    // @access Public
    @GetMapping("/courses/{id}")
    public Course findById(@PathVariable int id) {
        return courseService.findById(id);
    }

    // @desc Save a course
    // @route Post /api/courses
    // @access Public
    @PostMapping("/courses")
    public Course saveCourse(@RequestBody Course course) {
        return courseService.save(course);
    }

    // @desc Update a course
    // @route Put /api/courses
    // @access Public
    @PutMapping("/courses")
    public Course updateCourse(@RequestBody Course course) {
        return courseService.update(course);
    }

    // @desc Delete course by id
    // @route Delete /api/courses/{id}
    // @access Public
    @DeleteMapping("/courses/{id}")
    public String deleteCourseById(@PathVariable int id) {
        courseService.deleteById(id);
        return "Course deleted...";
    }

    // @desc Get course by name
    // @route Get /api/courses/getByName/{name}
    // @access Public
    @GetMapping("/courses/getByName/{name}")
    public Course findByName(@PathVariable String name) {
        return courseService.findByName(name);
    }

    // @desc Delete course by name
    // @route Get /api/courses/deleteByName/{name}
    // @access Public
    @DeleteMapping("/courses/deleteByName/{name}")
    public String deleteCourseByName(@PathVariable String name) {
        courseService.deleteByName(name);
        return "Course deleted...";
    }

}
