package com.example.demo;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.Model.Student;
import com.example.demo.Service.StudentService;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class JenkinsDemoApplication {
	
	private StudentService studentService;

	@Autowired
	public JenkinsDemoApplication(StudentService studentService) {
		super();
		this.studentService = studentService;
	}

	public static void main(String[] args) {
		SpringApplication.run(JenkinsDemoApplication.class, args);
	}
	
	@PostConstruct
	public void init() throws Exception {
		List<Student> result = Stream.of(new Student("Ankur","ankur@gmail.com"),
				new Student("Adarsh","adarsh@gmail.com")).collect(Collectors.toList());
		for (Student a : result) {
			studentService.createStudent(a);
		}

	}

}
