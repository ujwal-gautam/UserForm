package com.student.DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

/*import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;*/

import com.student.model.Student;

public class OperationImp implements Operations{

	public static final Logger logger = LogManager.getLogger(OperationImp.class);
	JDBCConfig jdbcConfig = new JDBCConfig();
	Student student = new Student();
	
//	String insertQuery = "insert into student values(?,?,?,?,?)";
//	String selectQuery = "select * from student";
//	String updateQuery = "update student set first_name = ?, last_name = ?, email_id = ?, address = ? where student_id = ?";
//	String deleteQuery = "delete from student where student_id = ?";
	
	@Override
	public Boolean save(String query, List<String> list) {

		Boolean value = false;
		try (PreparedStatement statement = jdbcConfig.databaseConfiguration().prepareStatement(query);){
			for (String list1 : list) {
				int index = 0;
				statement.setString(list1.indexOf(student.getStudentId()), list1);
				statement.setString(list1.indexOf(student.getFirstName()), list1);
				statement.setString(list1.indexOf(student.getLastName()), list1);
				statement.setString(list1.indexOf(student.getEmailId()), list1);
				statement.setString(list1.indexOf(student.getAddress()), list1);

			}
			int result = statement.executeUpdate();
			
			if(!(result == 0)) {
				logger.info("{} Row Inserted");
				value = true;
			}else {
				logger.error("Student details are not inserted");
			}	
		
		}catch(Exception e) {
			logger.error(e.getMessage());
		}finally {
			 try{
                 if (jdbcConfig.databaseConfiguration() != null) {
                	 jdbcConfig.databaseConfiguration().close();
                 }
            } catch (Exception e) {
					// TODO Auto-generated catch block
					logger.error(e.getMessage());
				}
		}
		
		return value;
	}

	@Override
	public List<Student> getData(String query, List<?> student) {
		
		List<Student> list = new ArrayList<Student>();
		
		try(PreparedStatement statement = jdbcConfig.databaseConfiguration().prepareStatement(query);
				ResultSet result = statement.executeQuery()){
			while(result.next()) {
				
				((Student) student).setStudentId(result.getString("student_id"));
				((Student) student).setFirstName(result.getString("first_name"));
				((Student) student).setLastName(result.getString("last_name"));
				((Student) student).setEmailId(result.getString("email_id"));
				((Student) student).setAddress(result.getString("address"));
				
				list.add((Student) student);
			}
		} catch (Exception e) {
			
			logger.error(e.getMessage());
		}finally {
			 try{
                 if (jdbcConfig.databaseConfiguration() != null) {
                	 jdbcConfig.databaseConfiguration().close();
                 }
            } catch (Exception e) {
					// TODO Auto-generated catch block
					logger.error(e.getMessage());
				}
		}
		return list;
	}

	@Override
	public Boolean updateData(String query, List<?> student) {
		
		Boolean value = false;
		try(PreparedStatement statement = jdbcConfig.databaseConfiguration().prepareStatement(query);){
			
			statement.setString(0, ((Student) student).getStudentId());
			statement.setString(1, ((Student) student).getFirstName());
			statement.setString(2, ((Student) student).getLastName());
			statement.setString(3, ((Student) student).getEmailId());
			statement.setString(4, ((Student) student).getAddress());
			
			int result = statement.executeUpdate();
			
			if(!(result == 0)) {
				logger.info("{} Row Updated");
				value = true;
			}else {
				logger.error("Student details are not updated.");
			}	
			
		}catch(Exception e) {
			logger.error(e.getMessage());
		}finally {
			try{
                if (jdbcConfig.databaseConfiguration() != null) {
               	 jdbcConfig.databaseConfiguration().close();
                }
           } catch (Exception e) {
					// TODO Auto-generated catch block
					logger.error(e.getMessage());
				}
		}
		return value;
	}

	@Override
	public Boolean delete(String query,Student student) {
		Boolean value = false;
		try(PreparedStatement statement = jdbcConfig.databaseConfiguration().prepareStatement(query)){
			
			statement.setString(0, student.getStudentId());
			
int result = statement.executeUpdate();
			
			if(!(result == 0)) {
				logger.info("{} Row Updated", null);
				value = true;
			}else {
				logger.error("Student details are not deleted.");
			}	
			
		}catch(Exception e) {
			logger.error(e.getMessage());
		}finally {
			try{
                if (jdbcConfig.databaseConfiguration() != null) {
               	 jdbcConfig.databaseConfiguration().close();
                }
           } catch (Exception e) {
					// TODO Auto-generated catch block
					logger.error(e.getMessage());
				}
		// TODO Auto-generated method stub
	}
		return value;
}
	
}
