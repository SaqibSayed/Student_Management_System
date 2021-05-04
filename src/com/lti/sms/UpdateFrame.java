package com.lti.sms;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class UpdateFrame extends JFrame{
Container c;
JLabel lblRollNo, lblName;
JTextField txtRollNo, txtName;
JButton btnUpdate, btnBack;
JPanel p1, p2;

UpdateFrame(){
c = getContentPane();
c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));

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
btnUpdate = new JButton("Update");
btnBack = new JButton("Back");
p2.add(btnUpdate);
p2.add(btnBack);
c.add(p2);

btnBack.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae){
HomeFrame a = new HomeFrame();
dispose();
}});

btnUpdate.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae){
String rollno = txtRollNo.getText();
String name = txtName.getText();
boolean isNumeric = true;
boolean isString = true;
isNumeric = rollno.matches("\\d+(\\d+)?");
isString = name.matches("^[a-zA-Z]*$");

if(rollno.length()==0){
JOptionPane.showMessageDialog(new JDialog(),"Please enter Rollno");
UpdateFrame ab = new UpdateFrame();
dispose();
}
else if(name.length()==0){
JOptionPane.showMessageDialog(new JDialog(),"Please enter Name");
UpdateFrame ab = new UpdateFrame();
dispose();
}
else if(!isNumeric){
JOptionPane.showMessageDialog(new JDialog(),"Please enter Numeric Value only for Roll No !!! ");
UpdateFrame ab = new UpdateFrame();
dispose();
}
else if(!isString){
JOptionPane.showMessageDialog(new JDialog(),"Please enter Alphabetical Value only for Name !!! ");
UpdateFrame ab = new UpdateFrame();
dispose();
}
else if(!ValidateRollno.check_rollno(Integer.parseInt(rollno))){
JOptionPane.showMessageDialog(new JDialog(),"Roll Number does not exist !!! ");
UpdateFrame ab = new UpdateFrame();
dispose();
}
else{
new DbHandler().updateStudent(Integer.parseInt(rollno), name);
txtRollNo.setText("");
txtName.setText("");
txtRollNo.requestFocus();
}
}});

setSize(320, 200);
setTitle("Update Student");
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}

