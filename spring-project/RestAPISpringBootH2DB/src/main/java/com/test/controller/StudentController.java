package com.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.Student;
import com.test.service.StudentService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/std/v1/api")
@Tag(name="Student crud operations")
public class StudentController {
	@Autowired
	private StudentService service;
	
	@PostMapping("/create")
	public ResponseEntity<Student> createStd(@RequestBody Student obj){
		Student std=service.saveStd(obj);
		if(std==null) {
			return new ResponseEntity<>(std,HttpStatus.BAD_REQUEST);
		}else {
			return new ResponseEntity<Student>(std,HttpStatus.CREATED);
		}
	}
	@GetMapping("/list")
	public ResponseEntity<List<Student>> listAll(){
		List<Student> list=service.getAllStd();
		if(list.size()<=0) {
			return new ResponseEntity<>(list,HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(list,HttpStatus.OK);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Student> updateStd(@PathVariable int id,@RequestBody Student obj){
		obj.setId(id);
		Student std=service.updateStdById(obj);
		if(std==null) {
			return new ResponseEntity<>(std,HttpStatus.BAD_REQUEST);
		}else {
			return new ResponseEntity<Student>(std,HttpStatus.OK);
		}
	}
	@GetMapping("/{id}")
	public ResponseEntity<Student> getStdById(@PathVariable int id){

		Student std=service.getStdById(id);
		if(std==null) {
			return new ResponseEntity<>(std,HttpStatus.BAD_REQUEST);
		}else {
			return new ResponseEntity<Student>(std,HttpStatus.OK);
		}
	
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<List<Student>> deleteStdById(@PathVariable int id){
		List<Student> list=service.deleteStdById(id);
		if(list.isEmpty()) {
			return new ResponseEntity<>(list,HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<>(list,HttpStatus.OK);
		}
	}
	

}
