package com.app.raghu.service;

import java.util.List;

import com.app.raghu.entity.Student;

public interface IStudentService {
	
	//save
	Integer saveStudent(Student student);
		
	//getAll
	List<Student> getAllStudents();
	
	//getOne
	Student getOneStudent(Integer id);
	
	//delete
	void deleteStudent(Integer Id);
	
	//update
	void updateStudent(Student student);
}
