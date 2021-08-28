package io.github.muhittinpalamutcu.schoolmanagementsystem.service;

import io.github.muhittinpalamutcu.schoolmanagementsystem.entity.Student;

import java.util.List;

public interface BaseService<T> {
    List<T> findAll();
    T findById(int id);
    T save(T object);
    void deleteById(int id);
    T update(T object);
    T findByName(String name);
    void deleteByName(String name);
}
