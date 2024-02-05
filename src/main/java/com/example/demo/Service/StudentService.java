package com.example.demo.Service;

import java.util.List;

import com.example.demo.Model.Student;

public interface StudentService {
	Student createStudent(Student student);
	List<Student> getAllStudents();
}
