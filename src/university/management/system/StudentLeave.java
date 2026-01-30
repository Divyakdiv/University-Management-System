package university.management.system;

import com.toedter.calendar.JDateChooser;
import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;
import java.awt.event.*;

public class StudentLeave extends JFrame implements ActionListener{
    
    JDateChooser dcdob;
    Choice rollno, time1 ;
    JButton submit, cancel;
    
    StudentLeave(){
        setSize(400, 450);
        setLocation(500, 50);
        setLayout(null);
        
        getContentPane().setBackground(Color.white);
        
        JLabel heading = new JLabel("Apply Leave (Student)");
        heading.setBounds(20, 20, 300, 20);
        heading.setFont(new Font("Tahoma", Font.BOLD, 14));
        add(heading);
        
        JLabel lbrollno = new JLabel("Search by Roll Number");
        lbrollno.setBounds(20, 60, 150, 20);
        lbrollno.setFont(new Font("Tahoma", Font.PLAIN , 15));
        add(lbrollno);
        
        rollno = new Choice();
        rollno.setBounds(20, 80, 150, 20);
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
        
        JLabel lbdob = new JLabel("Date");
       lbdob.setBounds(20, 120, 100, 25);
       lbdob.setFont(new Font("serif",Font.PLAIN,20));
       add(lbdob);
       
       dcdob = new JDateChooser();
       dcdob.setBounds(20, 150, 130, 18);
       lbdob.setFont(new Font("serif",Font.PLAIN,20));
       add(dcdob);
       
       JLabel time = new JLabel("Time");
       time.setBounds(20, 180, 150, 25);
       time.setFont(new Font("Tahoma", Font.PLAIN , 20));
        add(time);
        
        time1 = new Choice();
        time1.setBounds(20, 210, 150, 18);
        time1.add("Full Time");
        time1.add("Part Time");
        add(time1);
        
        submit = new JButton("Submit");
        submit.setForeground(Color.white);
        submit.setBackground(Color.black);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        submit.setBounds(40, 280, 100, 30 );
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Cancel!");
        cancel.setForeground(Color.white);
        cancel.setBackground(Color.black);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        cancel.addActionListener(this);
        cancel.setBounds(160, 280, 100, 30 );
        add(cancel);
        
       

        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String rollno1 = rollno.getSelectedItem();
            String date1 = ((JTextField)dcdob.getDateEditor().getUiComponent()).getText();
            String duration = time1.getSelectedItem();
            
            String query = "insert into studenleave values('"+rollno1+"','"+date1+"','"+duration+"')";
            
            try{
                Conn c = new Conn();
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Leave Confirmed");
                setVisible(false);
                
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else{
            setVisible(false);
        }
    }

    public static void main(String[] args){
        new StudentLeave();
    }
}  


