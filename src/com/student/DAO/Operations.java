package com.student.DAO;

import java.util.List;

import com.student.model.Student;

public interface Operations {

	public Boolean save(String query, List<String> students);
	public List<Student> getData(String query, List<?> students);
	public Boolean updateData(String query, List<?> students);
	public Boolean delete(String query, Student student);
	
	
}