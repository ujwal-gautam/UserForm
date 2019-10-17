package com.student.services;

import com.student.DAO.OperationImp;
import com.student.model.Student;

import com.student.DAO.Operations;
/*import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;*/
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class StudentService {

	public static final Logger logger = LogManager.getLogger(StudentService.class);
	
	private OperationImp operations = new OperationImp();
	Student student = new Student();



	public Boolean insertStudent(Student student) {
		String insertQuery = "insert into student values(?,?,?,?,?)";
		
		List<String> list = new ArrayList<>();
		list.add(student.getStudentId());
		list.add(student.getFirstName());
		list.add(student.getLastName());
		list.add(student.getEmailId());
		list.add(student.getAddress());

		if(operations.save(insertQuery, list)) {
			
			return true;
			
		}else {
			
			return false;
		}
		
	}
	@SuppressWarnings("unchecked")
	public List<Student> getAllStudent(Student student){
		String query = "select * from student";
		List<Student> students = new ArrayList<>();
		List<Student> list1 = new ArrayList<>();
		 students = operations.getData(query, students);

		 if (students.size() > 0) {

		 	logger.info("Student are present.");
			 for (Student list : students) {
				 list1 = (List<Student>) list;
			 }
		 }
//	students.forEach(list ->logger.info("{}", list));
		return list1;
	}
	
	public Boolean updateStudent(Student student){
		String query = "update student set first_name = ?, last_name = ?, email_id = ?, address = ? where student_id = ?";
		
		List<?> students = new ArrayList<>();
		
		if(operations.updateData(query, students)) {
			return true;
		}
		
		return false;
	}
	
	public Boolean deleteStudent(Student student) {
		String query = "delete from student where student_id = ?";
		
		List<Student> students = new ArrayList<>();

		if(operations.delete(query,student) == true) {
			return true;
		} else {
		return false;
		}
		
	}
}
