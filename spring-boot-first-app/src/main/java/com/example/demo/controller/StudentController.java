package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.Student;

@RestController
public class StudentController {
	
	@GetMapping("/student")
	public ResponseEntity<Student> getStudent() {
		Student student=new Student(1, "Surbhi", "Kumari");
		return new ResponseEntity<>(student,HttpStatus.OK);
	}
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		List<Student> students =new ArrayList<>();
		students.add(new Student(1, "Surbhi", "Kumari"));
		students.add(new Student(2, "Richa", "Kumari"));
		students.add(new Student(3, "Shikha", "Kumari"));
		students.add(new Student(4, "Shubham", "Kumar"));
		return students;
	}
	
	@GetMapping("/students/{id}")
	//if getmapping varibale and function varible differ then we need to give name like here id and studentid differ
	public Student studentPathVariable(@PathVariable("id") int studentid) {
		return new Student(studentid,"Surbhi","Kumari");
	}
	
	@GetMapping("/students/query")
	public Student studentRequestVariable(@RequestParam int id,@RequestParam String firstname,@RequestParam String lastname) {
		return new Student(id,firstname,lastname);
	}
	
	@PostMapping("students/create")
	@ResponseStatus(HttpStatus.CREATED)
	public Student createStudent(@RequestBody Student student) {
		System.out.println(student.getId());
		System.out.println(student.getFirstname());
		System.out.println(student.getLastname());
		return student;
	}
	
	@PutMapping("/students/{id}/update")
	
	public Student updateStudent(@RequestBody Student student,@PathVariable("id") int studentId) {
		System.out.println(student.getFirstname());
		System.out.println(student.getLastname());
		return student;
	}
	
	@DeleteMapping("students/{id}/delete")
	public String deleteStudent(@PathVariable("id") int studentId) {
		return "Student deleted successfully";
	}
}
