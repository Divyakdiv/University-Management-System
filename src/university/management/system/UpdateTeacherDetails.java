 
package university.management.system;


import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;

import java.awt.event.*;
import java.sql.ResultSet;

public class UpdateTeacherDetails  extends JFrame implements ActionListener{
    
    JTextField  tfadress, tfphone, tfemail, tfcourse,tfbranch;
    JLabel empId;
    
    Choice rollno;
    JButton submit, cancel;
    

    
    UpdateTeacherDetails(){
        setSize(800, 600);
        setLocation(350, 50);
        
       setLayout(null);
       
        JLabel heading = new JLabel("Update Factulty Information");
        heading.setBounds(30, 10, 600, 30);
        heading.setFont(new Font("Tahoma",Font.ITALIC, 30));
        add(heading);
        
        JLabel heading1 = new JLabel("Search by Employee Id :");
        heading1.setBounds(30, 80, 350, 20);
        heading1.setFont(new Font("serif",Font.PLAIN, 20));
        add(heading1);
        
        rollno = new Choice();
        rollno.setBounds(380, 80, 150, 30);
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
         
         
        JLabel lb1name = new JLabel("Name:");
        lb1name.setBounds(40, 120, 100, 30);
        lb1name.setFont(new Font("serif",Font.BOLD, 20));
        add(lb1name);
        
        JLabel labelname = new JLabel();
        labelname.setBounds(120, 120, 100, 30);
        labelname.setFont(new Font("Tahoma",Font.PLAIN, 16));
        add(labelname);
       
        
        JLabel lb1fname = new JLabel("Father's Name:");
        lb1fname.setBounds(300, 120, 200, 30);
        lb1fname.setFont(new Font("serif",Font.BOLD, 20));
        add(lb1fname);
        
        JLabel labelfname = new JLabel();
        labelfname.setBounds(500, 120, 100, 30);
        labelfname.setFont(new Font("Tahoma",Font.PLAIN, 16));
        add(labelfname);
        
        
        JLabel lb1roll = new JLabel("EmpId:");
        lb1roll.setBounds(40, 180, 200, 30);
        lb1roll.setFont(new Font("serif",Font.BOLD, 20));
        add(lb1roll);
        
        empId = new JLabel();
       empId.setBounds(120, 180, 200, 30);
       
       add(empId);
       
        
       
       
       JLabel lbdob = new JLabel("Date of Birth:");
       lbdob.setBounds(300, 180, 200, 30);
       lbdob.setFont(new Font("serif",Font.BOLD, 20));
       add(lbdob);
       
       JLabel  labeldoc= new JLabel();
       labeldoc.setBounds(500, 180, 120, 30);
       labeldoc.setFont(new Font("Tahoma",Font.PLAIN, 16));
       add(labeldoc);
       
       
       JLabel lbadress = new JLabel("Adress:");
        lbadress.setBounds(40, 240, 100, 30);
        lbadress.setFont(new Font("serif",Font.BOLD, 20));
        add(lbadress);
        
        tfadress = new JTextField();
        tfadress.setBounds(120, 240, 150, 30);
        
        add(tfadress);
        
        JLabel lbphone= new JLabel("Phone:");
       lbphone.setBounds(300, 240, 150, 30);
       lbphone.setFont(new Font("serif",Font.BOLD, 20));
       add(lbphone);
       
        tfphone = new JTextField();
        tfphone.setBounds(500, 240, 120, 30);
        
        add(tfphone);
       
        JLabel lbemail = new JLabel("EMail:");
        lbemail.setBounds(40, 300, 100, 30);
        lbemail.setFont(new Font("serif",Font.BOLD, 20));
        add(lbemail);
        
        tfemail = new JTextField();
        tfemail.setBounds(120, 300, 150, 30);
       
        add(tfemail);
        
        JLabel lbx= new JLabel("ClassX(Marks):");
       lbx.setBounds(300, 300, 150, 30);
       lbx.setFont(new Font("serif",Font.BOLD, 20));
       add(lbx);
       
       JLabel labelx = new JLabel();
       labelx.setBounds(500, 300, 120, 30);
       labelx.setFont(new Font("Tahoma",Font.PLAIN, 16));
       add(labelx);
       
       
        
        JLabel lbadhar = new JLabel("Adhar:");
        lbadhar.setBounds(40, 360, 100, 30);
        lbadhar.setFont(new Font("serif",Font.BOLD, 20));
        add(lbadhar);
        
        JLabel labeladhar = new JLabel();
        labeladhar.setBounds(120, 360, 140, 30);
        labeladhar.setFont(new Font("Tahoma",Font.PLAIN, 16));
        add(labeladhar);
        
        
        JLabel lbxii = new JLabel("ClassXII(Marks):");
        lbxii.setBounds(300, 360, 180, 30);
        lbxii.setFont(new Font("serif",Font.BOLD, 20));
        add(lbxii);
        
        JLabel labelxii = new JLabel();
        labelxii.setBounds(500, 360, 120, 30);
        labelxii.setFont(new Font("Tahoma",Font.PLAIN, 16));
        add(labelxii);
        
        
        JLabel lbcourse = new JLabel("Education:");
        lbcourse.setBounds(40, 420, 100, 30);
        lbcourse.setFont(new Font("serif",Font.BOLD, 20));
        add(lbcourse);
        
        
        tfcourse = new JTextField();
        tfcourse.setBounds(140, 420, 150, 30);
        tfcourse.setBackground(Color.WHITE);
        add(tfcourse);
        
        JLabel lbbranch = new JLabel("Department:");
        lbbranch.setBounds(300, 420, 100, 30);
        lbbranch.setFont(new Font("serif",Font.BOLD, 20));
        add(lbbranch);
        
       
        tfbranch = new JTextField();
        tfbranch.setBounds(500, 420, 150, 30);
        add(tfbranch);
        
        try{
            Conn c = new Conn();
            String query = "select * from teacher where empId='"+rollno.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                labelname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("fname"));
                labeldoc.setText(rs.getString("dob"));
                labelx.setText(rs.getString("x"));
                labeladhar.setText(rs.getString("adhar"));
                labelxii.setText(rs.getString("xii"));
                tfadress.setText(rs.getString("adress"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                tfcourse.setText(rs.getString("qualification")); 
                tfbranch.setText(rs.getString("branch"));
                empId.setText(rs.getString("empId")); 

              }
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        rollno.addItemListener(new ItemListener(){
        public void itemStateChanged(ItemEvent ie){
            
            try{
            Conn c = new Conn();
            String query = "select * from teacher where empId='"+rollno.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                labelname.setText(rs.getString("name"));
                labelfname.setText(rs.getString("fname"));
                labeldoc.setText(rs.getString("dob"));
                labelx.setText(rs.getString("x"));
                labeladhar.setText(rs.getString("adhar"));
                labelxii.setText(rs.getString("xii"));
                tfadress.setText(rs.getString("adress"));
                tfphone.setText(rs.getString("phone"));
                tfemail.setText(rs.getString("email"));
                tfcourse.setText(rs.getString("qualification")); 
                tfbranch.setText(rs.getString("branch"));
                empId.setText(rs.getString("empId")); 

              }
            
        }catch(Exception e){
            e.printStackTrace();
        }

            
        }
    });
        
        submit = new JButton("Update");
        submit.setForeground(Color.white);
        submit.setBackground(Color.black);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        submit.setBounds(200, 500, 100, 30 );
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel!");
        cancel.setForeground(Color.white);
        cancel.setBackground(Color.black);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        cancel.addActionListener(this);
        cancel.setBounds(400, 500, 100, 30 );
        add(cancel);
       
        
        
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
            if(ae.getSource()==submit){
                              
               String rollno1 = empId.getText();
               String adress = tfadress.getText();
               String phone = tfphone.getText();
               String course = tfcourse.getText();
               String branch= tfbranch.getText();
               String email = tfemail.getText();
               
                try{
                    
                   String query = "update teacher set adress='"+adress+"',phone='"+phone+"',email='"+email+"', qualification='"+course+"', branch='"+branch+"' where empId='"+rollno1+"'";                 
                    Conn con = new Conn();
                   con.s.executeUpdate(query);
                    
                    JOptionPane.showMessageDialog(null, "Teacher details Updateded successfully!");
                    setVisible(false);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }else{
                setVisible(false);
            }
            
        }

    public static void main(String[] args){
        new UpdateTeacherDetails();
    }
}