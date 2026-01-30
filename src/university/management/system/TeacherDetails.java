
package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;

public class TeacherDetails extends JFrame implements ActionListener{
    
       Choice empid;
       JTable table;
       JButton search, print, update, cancel, add;
    
        TeacherDetails(){
           
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel heading = new JLabel("Search by Employee ID");
        heading.setBounds(20, 20, 150, 20);
        add(heading);
        
        empid = new Choice();
        empid.setBounds(180, 20, 150, 20);
        add(empid);
        
        
        try{
            
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacher");
            
            while(rs.next()){
                empid.add(rs.getString("empId"));
            }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
    table = new JTable();
        try{
            
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from teacher");
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
                
                String query = "select * from teacher where empId='"+empid.getSelectedItem()+"'";
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
                //new UpdateTeacher();
            }else{
                setVisible(false);
            }
        }
    
    public static void main(String[] args){
        new TeacherDetails();
    }
    
}