
package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class StudentDetails extends JFrame implements ActionListener{
    
       Choice rollno;
       JTable table;
       JButton search, print, update, cancel, add;
    
        StudentDetails(){
           
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel heading = new JLabel("Search by Roll Number");
        heading.setBounds(20, 20, 150, 20);
        add(heading);
        
        rollno = new Choice();
        rollno.setBounds(180, 20, 150, 20);
        add(rollno);
        
        
        try{
            
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
            
            while(rs.next()){
                rollno.add(rs.getString("usn"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    table = new JTable();
        try{
            
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from student");
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
        
        add= new JButton("Add");
        add.setBounds(220, 50, 80, 20);
        add.addActionListener(this);
        add(add);
        
        update = new JButton("update");
        update.setBounds(320, 50, 80, 20);
        update.addActionListener(this);
        add(update);
        
        cancel = new JButton("cancel");
        cancel.setBounds(420, 50, 80, 20);
        cancel.addActionListener(this);
        add(cancel);
        
        setSize(900, 600);
        setLocation(250, 30);
        setVisible(true);
        
    }
        public void actionPerformed(ActionEvent ae){
            if(ae.getSource()==search){
                
                String query = "select * from student where usn='"+rollno.getSelectedItem()+"'";
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
                
            }else if(ae.getSource()==add){
                setVisible(false);
                new AddStudent();
            }   
            else if(ae.getSource()==update){
                setVisible(false);
                //new UpdateStudent();
            }else{
                setVisible(false);
            }
        }
    
    public static void main(String[] args){
        new StudentDetails();
    }
    
}
