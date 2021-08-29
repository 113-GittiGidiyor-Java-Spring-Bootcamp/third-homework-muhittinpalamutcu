package io.github.muhittinpalamutcu.schoolmanagementsystem.controller;

import io.github.muhittinpalamutcu.schoolmanagementsystem.entity.Instructor;
import io.github.muhittinpalamutcu.schoolmanagementsystem.service.InstructorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class InstructorController {
    private final InstructorService instructorService;

    // @desc Get all instructors
    // @route Get /api/instructors
    // @access Public
    @GetMapping("/instructors")
    public ResponseEntity<List<Instructor>> findAll() {
        return new ResponseEntity<>(instructorService.findAll(), HttpStatus.OK);
    }

    // @desc Get instructor by id
    // @route Get /api/instructors/{id}
    // @access Public
    @GetMapping("/instructors/{id}")
    public Instructor findById(@PathVariable int id) {
        return instructorService.findById(id);
    }

    // @desc Save a instructor
    // @route Post /api/instructors
    // @access Public
    @PostMapping("/instructors")
    public Instructor saveInstructor(@RequestBody Instructor instructor) {
        return instructorService.save(instructor);
    }

    // @desc Update a instructor
    // @route Put /api/instructors
    // @access Public
    @PutMapping("/instructors")
    public Instructor updateInstructor(@RequestBody Instructor instructor) {
        return instructorService.update(instructor);
    }

    // @desc Delete instructor by id
    // @route Delete /api/instructors/{id}
    // @access Public
    @DeleteMapping("/instructors/{id}")
    public String deleteInstructorById(@PathVariable int id) {
        instructorService.deleteById(id);
        return "Instructor deleted...";
    }

    // @desc Get instructor by name
    // @route Get /api/instructors/getByName/{name}
    // @access Public
    @GetMapping("/instructors/getByName/{name}")
    public Instructor findByName(@PathVariable String name) {
        return instructorService.findByName(name);
    }

    // @desc Delete instructor by name
    // @route Get /api/instructors/deleteByName/{name}
    // @access Public
    @DeleteMapping("/instructors/deleteByName/{name}")
    public String deleteInstructorByName(@PathVariable String name) {
        instructorService.deleteByName(name);
        return "Instructor deleted...";
    }

    // @desc Find 3 highest paid permanent instructor
    // @route Get /api/instructors/find3HighestPaidPermanentInstructor
    // @access Public
    @GetMapping("/instructors/find3HighestPaidPermanentInstructor")
    public ResponseEntity<List<Instructor>> find3HighestPaidPermanentInstructor() {
        return new ResponseEntity<>(instructorService.find3HighestPaidPermanentInstructor(), HttpStatus.OK);
    }

    // @desc Find 3 least paid permanent instructor
    // @route Get /api/instructors/find3LeastPaidPermanentInstructor
    // @access Public
    @GetMapping("/instructors/find3LeastPaidPermanentInstructor")
    public ResponseEntity<List<Instructor>> find3LeastPaidPermanentInstructor() {
        return new ResponseEntity<>(instructorService.find3LeastPaidPermanentInstructor(), HttpStatus.OK);
    }


}
