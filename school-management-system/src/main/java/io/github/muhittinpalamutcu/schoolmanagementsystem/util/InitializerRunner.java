package io.github.muhittinpalamutcu.schoolmanagementsystem.util;

import io.github.muhittinpalamutcu.schoolmanagementsystem.entity.Student;
import io.github.muhittinpalamutcu.schoolmanagementsystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;

@Component
public class InitializerRunner implements CommandLineRunner {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {
        studentRepository.deleteAll();
        studentRepository.save(Student.builder().name("Ali").address("Izmir").birthDate(LocalDate.of(1998, Month.JANUARY, 13)).gender("MALE").build());
        studentRepository.save(Student.builder().name("Ahmet").address("Istanbul").birthDate(LocalDate.of(1990, Month.JULY, 23)).gender("MALE").build());
        studentRepository.save(Student.builder().name("John").address("London").birthDate(LocalDate.of(2001, Month.MARCH, 10)).gender("MALE").build());
        studentRepository.save(Student.builder().name("Jane").address("Amsterdam").birthDate(LocalDate.of(1992, Month.APRIL, 18)).gender("FEMALE").build());
        studentRepository.save(Student.builder().name("Ayse").address("Antalya").birthDate(LocalDate.of(1974, Month.AUGUST, 19)).gender("FEMALE").build());
    }

}
