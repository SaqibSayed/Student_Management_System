package com.lti.sms;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

class HomeFrame extends JFrame{
Container c;
JButton btnAdd, btnView, btnUpdate, btnDelete;



HomeFrame()
{
c = getContentPane();
c.setLayout(new FlowLayout());
btnAdd = new JButton("Add");
btnView = new JButton("View");
btnUpdate = new JButton("Update");
btnDelete = new JButton("Delete");
System.out.println("inside home class");
c.add(btnAdd);
c.add(btnView);
c.add(btnUpdate);
c.add(btnDelete);

btnAdd.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae){
	System.out.println("AddFrame a = new AddFrame();");
AddFrame a = new AddFrame();
dispose();
}});

btnView.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae){
	System.out.println("ViewFrame a = new ViewFrame()");
ViewFrame a = new ViewFrame();
dispose();
}});

btnUpdate.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae){
UpdateFrame a = new UpdateFrame();
System.out.println("UpdateFrame a = new UpdateFrame();");
dispose();
}});

btnDelete.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae){
DeleteFrame a = new DeleteFrame();
System.out.println("DeleteFrame a = new DeleteFrame();");
dispose();
}});


setSize(320,200);
setTitle("Student Management System");
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);

}

public static void main(String args[]){
	System.out.println("in main method");
HomeFrame h = new HomeFrame();


}
}


class DbHandler {

public void addStudent(int rollno, String name){
try{
	System.out.println("Inside add student");
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","abc123");
String sql = "insert into student1(rno, name) values(?,?)";
PreparedStatement pst = c.prepareStatement(sql);
pst.setInt(1, rollno);
pst.setString(2, name);
int r = pst.executeUpdate();
JOptionPane.showMessageDialog(new JDialog(),r + " records inserted");
c.close();
}
catch(SQLException e){
JOptionPane.showMessageDialog(new JDialog(),"issue" + e);
}
}

public String viewStudent(){
StringBuffer sb = new StringBuffer();
try{
	System.out.println("viewStudent()");
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","abc123");
String sql = "select * from student1";
Statement stmt = c.createStatement();
ResultSet rs = stmt.executeQuery(sql);
while(rs.next()){
String rollno = rs.getString(1);
String name = rs.getString(2);
sb.append("Roll no: "+rollno+"  Name: "+name+"\n");
}
rs.close();
c.close();
}
catch(SQLException e){
System.out.println(e);
}
return sb.toString();
}

public void updateStudent(int rollno, String name){
try{
	System.out.println("updateStudent");
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","abc123");
String sql = "update student1 set name = ? where rollno = ?";
PreparedStatement pst = c.prepareStatement(sql);
pst.setString(1, name);
pst.setInt(2, rollno);
int r = pst.executeUpdate();
JOptionPane.showMessageDialog(new JDialog(),r + " records updated");
c.close();
}
catch(SQLException e){
JOptionPane.showMessageDialog(new JDialog(),"issue" + e);
}
}

public void deleteStudent(int rollno){
try{
	System.out.println("deleteStudent");
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","abc123");
String sql = "delete from student1 where rno = ?";
PreparedStatement pst = c.prepareStatement(sql);
pst.setInt(1, rollno);
int r = pst.executeUpdate();
JOptionPane.showMessageDialog(new JDialog(),r + " records deleted");
c.close();
}
catch(SQLException e){
JOptionPane.showMessageDialog(new JDialog(),"issue" + e);
}
}

public String viewAscStudent(){
StringBuffer sb = new StringBuffer();
try{
	System.out.println("viewAscStudent()");
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","abc123");
String sql = "select * from student1 order by rollno ASC";
Statement stmt = c.createStatement();
ResultSet rs = stmt.executeQuery(sql);
while(rs.next()){
String rollno = rs.getString(1);
String name = rs.getString(2);
sb.append("Roll no: "+rollno+"  Name: "+name+"\n");
}
rs.close();
c.close();
}
catch(SQLException e){
System.out.println(e);
}
return sb.toString();
}

public String viewDescStudent(){
StringBuffer sb = new StringBuffer();
try{
	System.out.println("viewDescStudent()");
DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
Connection c = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","abc123");
String sql = "select * from student1 order by rollno DESC";
Statement stmt = c.createStatement();
ResultSet rs = stmt.executeQuery(sql);
while(rs.next()){
String rollno = rs.getString(1);
String name = rs.getString(2);
sb.append("Roll no: "+rollno+"  Name: "+name+"\n");
}
rs.close();
c.close();
}
catch(SQLException e){
System.out.println(e);
}
return sb.toString();
}




}
