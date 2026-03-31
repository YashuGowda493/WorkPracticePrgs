package com.test.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.test.dao.StudentDao;
import com.test.entity.Student;
import com.test.repository.StudentRepository;

@Repository
public class StudentDaoImpl implements StudentDao {
	
	@Autowired
	private StudentRepository repo;
	@Override
	public Student saveStd(Student obj) {
		
		return repo.save(obj);
	}

	@Override
	public Student getStdById(int id) {
	
		return repo.findById(id).get();
	}

	@Override
	public Student updateStdById(Student obj) {
		
		return repo.save(obj);
	}

	@Override
	public List<Student> deleteStdById(int id) {
	repo.deleteById(id);
	List<Student> list=repo.findAll();
		return list;
	}

	@Override
	public List<Student> getAllStd() {
	
		return repo.findAll();
	}

}
