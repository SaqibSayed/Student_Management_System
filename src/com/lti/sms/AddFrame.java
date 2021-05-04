package com.lti.sms;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

class AddFrame extends JFrame{
Container c;
JLabel lblRollNo, lblName;
JTextField txtRollNo, txtName;
JButton btnAdd, btnBack;
JPanel p1, p2;

AddFrame(){
c = getContentPane();
c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));
System.out.println("inside aDD CLASS");
p1 = new JPanel();
lblRollNo = new JLabel("Enter roll no");
txtRollNo = new JTextField(3);
lblName = new JLabel("Enter name");
txtName = new JTextField(10);
p1.add(lblRollNo);
p1.add(txtRollNo);
p1.add(lblName);
p1.add(txtName);
c.add(p1);

p2 = new JPanel();
btnAdd = new JButton("Add");
btnBack = new JButton("Back");
p2.add(btnAdd);
p2.add(btnBack);
c.add(p2);

btnBack.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae){
HomeFrame a = new HomeFrame();
System.out.println("inside home frame");
dispose();
}});

btnAdd.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae){
	System.out.println("actionPerformed");
String rollno = txtRollNo.getText();
String name = txtName.getText();
boolean isNumeric = true;
boolean isString = true;
isNumeric = rollno.matches("\\d+(\\d+)?");
isString = name.matches("^[a-zA-Z]*$");

if(rollno.length()==0){
JOptionPane.showMessageDialog(new JDialog(),"Please enter Rollno !!! ");
AddFrame ab = new AddFrame();
System.out.println("inside add frame class in roll.lenght");
dispose();
}
else if(name.length()==0){
JOptionPane.showMessageDialog(new JDialog(),"Please enter Name !!! ");
AddFrame ab = new AddFrame();
System.out.println("inside add frame class in name.lenght");
dispose();
}
else if(!isNumeric){
JOptionPane.showMessageDialog(new JDialog(),"Please enter Numeric Value only for Roll No !!! ");
AddFrame ab = new AddFrame();
System.out.println("inside add frame class in numeric");
dispose();
}
else if(!isString){
JOptionPane.showMessageDialog(new JDialog(),"Please enter Alphabetical Value only for Name !!! ");
AddFrame ab = new AddFrame();
System.out.println("inside add frame class in isString");
dispose();
}
else if(ValidateRollno.check_rollno((Integer.parseInt(rollno)))){
JOptionPane.showMessageDialog(new JDialog(),"Roll Number already exists !!! ");
AddFrame ab = new AddFrame();
System.out.println("inside add frame class in ValidateRollno.check_rollno");
dispose();
}
else {
new DbHandler().addStudent(Integer.parseInt(rollno), name);
txtRollNo.setText("");
txtName.setText("");
txtRollNo.requestFocus();
System.out.println("inside add frame class in else");
}
}});

setSize(320, 200);
System.out.println("Adding student");
setTitle("Add Student");
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}

