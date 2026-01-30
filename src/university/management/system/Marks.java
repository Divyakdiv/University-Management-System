
package university.management.system;

import java.sql.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Marks extends JFrame implements ActionListener{
    
    JButton cancel;
    String rollno;
    Marks(String rollno){
        this.rollno = rollno;
        
        setSize(500, 450);
        setLocation(450, 30);
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading = new JLabel("Visvesvaraya Technological Universirty");
        heading.setBounds(35, 10, 500, 30);
        heading.setFont(new Font("Tahoma",Font.BOLD, 20));
        add(heading);
        
        JLabel subheading = new JLabel("Result of Examination 2025");
        subheading.setBounds(70, 70, 500, 20);
        subheading.setFont(new Font("Tahoma",Font.BOLD, 18));
        add(subheading);
        
        JLabel lblrollno = new JLabel("rollno"+rollno);
        lblrollno.setBounds(70, 100, 500, 20);
        lblrollno.setFont(new Font("Tahoma",Font.BOLD, 18));
        add(lblrollno);
        
        JLabel lblsemester = new JLabel();
        lblsemester.setBounds(70, 130, 500, 20);
        lblsemester.setFont(new Font("Tahoma",Font.BOLD, 18));
        add(lblsemester);
        
        
        JLabel sub1 = new JLabel();
        sub1.setBounds(70, 160, 500, 20);
        sub1.setFont(new Font("Tahoma",Font.PLAIN, 18));
        add(sub1);
        
        JLabel sub2 = new JLabel();
        sub2.setBounds(70, 190, 500, 20);
        sub2.setFont(new Font("Tahoma",Font.PLAIN, 18));
        add(sub2);
        
        JLabel sub3 = new JLabel();
        sub3.setBounds(70, 220, 500, 20);
        sub3.setFont(new Font("Tahoma",Font.PLAIN, 18));
        add(sub3);
        
        JLabel sub4 = new JLabel();
        sub4.setBounds(70, 250, 500, 20);
        sub4.setFont(new Font("Tahoma",Font.PLAIN, 18));
        add(sub4);
        
        JLabel sub5 = new JLabel();
        sub5.setBounds(70, 280, 500, 20);
        sub5.setFont(new Font("Tahoma",Font.PLAIN, 18));
        add(sub5);
        
        cancel = new JButton("Back");
        cancel.setForeground(Color.white);
        cancel.setBackground(Color.black);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        cancel.addActionListener(this);
        cancel.setBounds(100, 350, 70, 20 );
        add(cancel);
        
        try{
            
            Conn c = new Conn();
            ResultSet rs1 = c.s.executeQuery("select * from subject where rollno='"+rollno+"'");
            while(rs1.next()){
                sub1.setText(rs1.getString("subject1"));
                sub2.setText(rs1.getString("subject2"));
                sub3.setText(rs1.getString("subject3"));
                sub4.setText(rs1.getString("subject4"));
                sub5.setText(rs1.getString("subject5"));
            }
            ResultSet rs2 = c.s.executeQuery("select * from marks where rollno='"+rollno+"'");
            while(rs2.next()){
                sub1.setText(sub1.getText()+"---------------->"+rs2.getString("marks1"));
                sub2.setText(sub2.getText()+"---------------->"+rs2.getString("marks2"));
                sub3.setText(sub3.getText()+"---------------->"+rs2.getString("marks3"));
                sub4.setText(sub4.getText()+"---------------->"+rs2.getString("marks4"));
                sub5.setText(sub5.getText()+"---------------->"+rs2.getString("marks5"));
                lblsemester.setText("semester"+ rs2.getString("semester"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }
    
    
    public static void main(String[] args){
        new Marks("");
    }
    
}
