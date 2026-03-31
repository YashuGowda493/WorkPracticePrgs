package com.test.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.StudentDao;
import com.test.entity.Student;
import com.test.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentDao dao;
	@Override
	public Student saveStd(Student obj) {
		
		return dao.saveStd(obj);
	}

	@Override
	public Student getStdById(int id) {
		
		return dao.getStdById(id);
	}

	@Override
	public Student updateStdById(Student obj) {
		
		return dao.updateStdById(obj);
	}

	@Override
	public List<Student> deleteStdById(int id) {
		
		return dao.deleteStdById(id);
	}

	@Override
	public List<Student> getAllStd() {
	
		return dao.getAllStd();
	}

}
