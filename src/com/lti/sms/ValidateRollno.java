package com.lti.sms;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class ValidateRollno{
public static boolean check_rollno(int rollno1){
	boolean AlreadyExists = false;
	try{
		System.out.println("inside vaidate frame");
		DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","abc123");
		String sql = "Select rno from student1";
		PreparedStatement stmt = c.prepareStatement(sql); 
		ResultSet rs = stmt.executeQuery(); 
		 
		while (rs.next()){
			String num1 = rs.getString("rno");
			int num = Integer.parseInt(num1);
			if (num == rollno1){ 
				AlreadyExists = true;
			} 
			else{ 
				continue; 
			}
		}
		c.close();
	}
	catch(SQLException e){
		JOptionPane.showMessageDialog(new JDialog(),"issue" + e);
	}
	return AlreadyExists;
	}
}

