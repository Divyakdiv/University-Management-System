package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class TeacherLeaveDetails extends JFrame implements ActionListener{
    
       Choice rollno;
       JTable table;
       JButton search, print,  cancel;
    
        TeacherLeaveDetails(){
           
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel heading = new JLabel("Search by Employee ID");
        heading.setBounds(20, 20, 150, 20);
        add(heading);
        
        rollno = new Choice();
        rollno.setBounds(180, 20, 150, 20);
        add(rollno);
        
        
        try{
            
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacher");
            
            while(rs.next()){
                rollno.add(rs.getString("empId"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    table = new JTable();
        try{
            
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacherleave");
            table.setModel(DbUtils.resultSetToTableModel(rs));
            
          }catch(Exception e){
            e.printStackTrace();
        }
        
        
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0,70,900,500);
        add(jsp);
        
        search = new JButton("Search");
        search.setBounds(20, 50, 80, 20);
        search.addActionListener(this);
        add(search);
        
        print = new JButton("Print");
        print.setBounds(120, 50, 80, 20);
        print.addActionListener(this);
        add(print);
        

        
        cancel = new JButton("cancel");
        cancel.setBounds(220, 50, 80, 20);
        cancel.addActionListener(this);
        add(cancel);
        
        setSize(900, 600);
        setLocation(250, 30);
        setVisible(true);
        
    }
        public void actionPerformed(ActionEvent ae){
            if(ae.getSource()==search){
                
                String query = "select * from teacherleave where empId='"+rollno.getSelectedItem()+"'";
                try{
                    Conn c = new Conn();
                    ResultSet rs = c.s.executeQuery(query);
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                }catch(Exception e){
                    e.printStackTrace();
                }
            }else if(ae.getSource()==print){
                try{
                    table.print();
                }catch(Exception e){
                    e.printStackTrace();
                }
                
               }else{
                setVisible(false);
            }
        }
    
    public static void main(String[] args){
        new TeacherLeaveDetails();
    }
    
}

