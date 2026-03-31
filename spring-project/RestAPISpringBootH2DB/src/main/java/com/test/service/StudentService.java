package com.test.service;

import java.util.List;

import com.test.entity.Student;

public interface StudentService {
	public Student saveStd(Student obj);
	public Student getStdById(int id);
	public Student updateStdById(Student obj);
	public List<Student> deleteStdById(int id);
	public List<Student> getAllStd();

}
