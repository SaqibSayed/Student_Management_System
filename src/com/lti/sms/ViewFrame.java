package com.lti.sms;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class ViewFrame extends JFrame {
Container c;
TextArea txtData;
JButton btnBack, btnAsc, btnDesc;
JPanel p1,p2;

ViewFrame(){
c = getContentPane();
c.setLayout(new BoxLayout(c, BoxLayout.Y_AXIS));
System.out.println("inside view frame");

p1 = new JPanel();
txtData = new TextArea(5,40);
txtData.setEditable(false);
p1.add(txtData);
c.add(p1);

p2 = new JPanel();
btnAsc = new JButton("ASC");
btnDesc = new JButton("DESC");
btnBack = new JButton("Back");
p2.add(btnAsc);
p2.add(btnDesc);
p2.add(btnBack);
c.add(p2);

txtData.setText(new DbHandler().viewStudent());

btnAsc.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae){
txtData.setText(new DbHandler().viewAscStudent());
}});

btnDesc.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae){
txtData.setText(new DbHandler().viewDescStudent());
}});

btnBack.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae){
HomeFrame a = new HomeFrame();
dispose();
}});

setSize(320,200);
setTitle("View Student");
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setVisible(true);
}
}