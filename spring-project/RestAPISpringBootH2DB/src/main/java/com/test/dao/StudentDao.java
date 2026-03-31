package com.test.dao;

import java.util.List;

import com.test.entity.Student;

public interface StudentDao  {
	public Student saveStd(Student obj);
	public Student getStdById(int id);
	public Student updateStdById(Student obj);
	public List<Student> deleteStdById(int id);
	public List<Student> getAllStd();
}
