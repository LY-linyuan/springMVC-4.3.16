package com.bjpowernode.service;

import com.bjpowernode.domain.Student;

import java.util.List;

/**
 * @Author 临渊
 * @Date 2022-08-03 11:43
 */
public interface StudentService {

    int addStudent(Student student);

    List<Student> findStudents();

}
