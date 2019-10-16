package com.student.struts;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.opensymphony.xwork2.ActionSupport;
import com.student.model.Student;
import com.student.services.StudentService;

public class StudentAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final Logger logger = LogManager.getLogger(StudentAction.class);
	Student student = new Student();
	StudentService service = new StudentService(null);
	String msg = null;
	
	
	private HttpServletResponse response;
	public void setServletResponse(HttpServletResponse response){
	    this.response = response;
	  }

	  public HttpServletResponse getServletResponse(){
	    return response;
	  }
	  
	public String saveStudent() {
		
		if(service.insertStudent(student) == true) {
		response.setContentType("Application/json");
		
		logger.info("Successfully save the Student data");
		return "INSERT";
		}
		else
		{
		
			return "error";
		}
	}
	
	public String selectStudent() {
		List<Student> list = new ArrayList<>();
		list = service.getAllStudent(student);
		
		response.setContentType("Application/json");
		return "SELECT";	
	}
	public String updateStudent() {
		
		if(service.updateStudent(student) == true) {
		
			msg = "Update Successful";
			response.setContentType("Application/json");
			return "UPDATE";
		} else {
			return "error";
		}
	}
	
	public String deleteStudent() {
		service.deleteStudent(student);
		msg ="Delete Successful";
		return "DELETE";
		
	}
}
