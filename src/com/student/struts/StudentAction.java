package com.student.struts;


import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.student.model.Student;
import com.student.services.StudentService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class StudentAction extends ActionSupport implements ModelDriven<Student> {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = LogManager.getLogger(StudentAction.class);
	public Student student = new Student();
	private StudentService service = new StudentService();


	public String saveStudent(){
		/*int i = 0;
		while (i< student.size()){
			student.get(i).getStudentId();
			student.get(i).getFirstName();
			student.get(i).getLastName();
			student.get(i).getEmailId();
			student.get(i).getAddress();

			break;
		}*/
		if (service.insertStudent(student)) {

				logger.info("Successfully save the Student data");
				return "INSERT";
			}
		else
		{
			return "error";
		}
	}
	
	public String selectStudent() {
		List<?> list = new ArrayList<>();
		list = service.getAllStudent(student);

		return "SELECT";
	}
	public String updateStudent() {

		if(service.updateStudent(student)) {

			return "UPDATE";
		} else {
			return "error";
		}
	}

	public String deleteStudent() {
		service.deleteStudent(student);
		return "DELETE";
		
	}


	@Override
	public Student getModel() {

		return student;
	}


}
