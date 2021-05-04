package com.lti.sms;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class DeleteFrame extends JFrame{
Container c;
JLabel lblRollNo;
JTextField txtRollNo;
JButton btnDelete, btnBack;
JPanel p1, p2;

DeleteFrame(){
	System.out.println("inside delete frame");
c = getContentPane();
c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));

p1 = new JPanel();
lblRollNo = new JLabel("Enter roll no");
txtRollNo = new JTextField(3);
p1.add(lblRollNo);
p1.add(txtRollNo);
c.add(p1);

p2 = new JPanel();
btnDelete = new JButton("Delete");
btnBack = new JButton("Back");
p2.add(btnDelete);
p2.add(btnBack);
c.add(p2);

btnBack.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae){
HomeFrame a = new HomeFrame();
dispose();
}});

btnDelete.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae){
String rollno = txtRollNo.getText();
boolean isNumeric = true;
isNumeric = rollno.matches("\\d+(\\d+)?");

if(rollno.length()==0){
JOptionPane.showMessageDialog(new JDialog(),"Please enter Rollno");
DeleteFrame ab = new DeleteFrame();
dispose();
}
else if(!isNumeric){
JOptionPane.showMessageDialog(new JDialog(),"Please enter Numeric Value only for Roll No !!! ");
DeleteFrame ab = new DeleteFrame();
dispose();
}
else if(!ValidateRollno.check_rollno(Integer.parseInt(rollno))){
JOptionPane.showMessageDialog(new JDialog(),"Roll Number does not exist !!! ");
DeleteFrame ab = new DeleteFrame();
dispose();
}
else{
new DbHandler().deleteStudent(Integer.parseInt(rollno));
txtRollNo.setText("");
txtRollNo.requestFocus();
}
}});

setSize(320, 200);
setTitle("Delete Student");
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}

