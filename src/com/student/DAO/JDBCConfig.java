package com.student.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.student.constant.GeneralConstant;

public class JDBCConfig {
	
	private static final Logger logger = LogManager.getLogger(JDBCConfig.class);
	

	public Connection databaseConfiguration() throws ClassNotFoundException {
		Connection connection = null;
		try{
			Class.forName(GeneralConstant.DATABASEDRIVER);
			connection = DriverManager.getConnection(GeneralConstant.DATABASEURL,GeneralConstant.DATABASEUSERNAME, GeneralConstant.DATABASEPASSWORD);
			
			
		}catch(Exception e) {
			logger.error(e.getMessage());
		}

		return connection;
	}
}
