
package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;


public class EnterMarks extends JFrame  implements ActionListener{
    
    JButton cancel, submit;
    Choice rollno;
    JComboBox cbsemester;
    JTextField tfentersub1, tfentersub2,tfentersub3,tfentersub4,tfentersub5,tfentermark1,tfentermark2,tfentermark3,tfentermark4,tfentermark5;
    
    EnterMarks(){
        
        setSize(900, 500);
        setLocation(300, 50);
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/exam.jpg"));
        Image i2 = i1.getImage().getScaledInstance(350, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500, 50, 400, 300);
        add(image);
        
        JLabel heading = new JLabel("Enter Marks of Student");
        heading.setBounds(30, 0, 300, 30);
        heading.setFont(new Font("Tahoma",Font.BOLD, 20));
        add(heading);
        
        JLabel heading1 = new JLabel("Search by Roll Number :");
        heading1.setBounds(30, 50, 200, 20);
        heading1.setFont(new Font("serif",Font.PLAIN, 20));
        add(heading1);
        
        rollno = new Choice();
        rollno.setBounds(250, 50, 150, 30);
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
        
        JLabel lblsemester = new JLabel("Select Semester:");
         lblsemester.setBounds(30, 100, 200, 20);
        lblsemester.setFont(new Font("serif",Font.PLAIN, 20));
        add(lblsemester);
        
        String semester[] = {"1st semester","2nd semester","3rd semester","4th semester","5th semester","6th semester","7th semester","8th semester"};
        cbsemester = new JComboBox(semester);
        cbsemester.setBounds(250, 100, 200, 20);
        cbsemester.setBackground(Color.WHITE);
        add(cbsemester);
        
        JLabel lblentersub= new JLabel("Enter Subject");
        lblentersub.setBounds(70, 140, 200, 30);
        lblentersub.setFont(new Font("serif",Font.PLAIN, 20));
        add(lblentersub);
        
        JLabel lblentermark= new JLabel("Enter Marks");
        lblentermark.setBounds(300, 140, 200, 30);
        lblentermark.setFont(new Font("serif",Font.PLAIN, 20));
        add(lblentermark);
        
        tfentersub1 = new JTextField();
        tfentersub1.setBounds(50, 180, 200, 20);
        tfentersub1.setFont(new Font("serif", Font.PLAIN, 20));
        add(tfentersub1);
        
        tfentersub2 = new JTextField();
        tfentersub2.setBounds(50, 210, 200, 20);
        tfentersub2.setFont(new Font("serif", Font.PLAIN, 20));
        add(tfentersub2);
        
        tfentersub3 = new JTextField();
        tfentersub3.setBounds(50, 240, 200, 20);
        tfentersub3.setFont(new Font("serif", Font.PLAIN, 20));
        add(tfentersub3);
        
        tfentersub4 = new JTextField();
        tfentersub4.setBounds(50, 270, 200, 20);
        tfentersub4.setFont(new Font("serif", Font.PLAIN, 20));
        add(tfentersub4);
        
        tfentersub5 = new JTextField();
        tfentersub5.setBounds(50, 300, 200, 20);
        tfentersub5.setFont(new Font("serif", Font.PLAIN, 20));
        add(tfentersub5);
        
        tfentermark1 = new JTextField();
        tfentermark1.setBounds(270, 180, 200, 20);
        tfentermark1.setFont(new Font("serif", Font.PLAIN, 20));
        add(tfentermark1);
        
        tfentermark2 = new JTextField();
        tfentermark2.setBounds(270, 210, 200, 20);
        tfentermark2.setFont(new Font("serif", Font.PLAIN, 20));
        add(tfentermark2);
        
        tfentermark3 = new JTextField();
        tfentermark3.setBounds(270, 240, 200, 20);
        tfentermark3.setFont(new Font("serif", Font.PLAIN, 20));
        add(tfentermark3);
        
        tfentermark4 = new JTextField();
        tfentermark4.setBounds(270, 270, 200, 20);
        tfentermark4.setFont(new Font("serif", Font.PLAIN, 20));
        add(tfentermark4);
        
        tfentermark5 = new JTextField();
        tfentermark5.setBounds(270, 300, 200, 20);
        tfentermark5.setFont(new Font("serif", Font.PLAIN, 20));
        add(tfentermark5);

        
        submit = new JButton("Done");
        submit.setForeground(Color.white);
        submit.setBackground(Color.black);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        submit.setBounds(90, 360, 100, 30 );
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Back");
        cancel.setForeground(Color.white);
        cancel.setBackground(Color.black);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        cancel.addActionListener(this);
        cancel.setBounds(280, 360, 100, 30 );
        add(cancel);
        
         setVisible(true);
        
        }
    public void actionPerformed(ActionEvent ae){
            if(ae.getSource()==submit){
                
                try{
                    
                    Conn c = new Conn();
                    
                    String query1="insert into subject values('"+rollno.getSelectedItem()+"', '"+cbsemester.getSelectedItem()+"', '"+tfentersub1.getText()+"','"+tfentersub2.getText()+"','"+tfentersub3.getText()+"','"+tfentersub4.getText()+"','"+tfentersub5.getText()+"')";
                    String query2="insert into marks values('"+rollno.getSelectedItem()+"', '"+cbsemester.getSelectedItem()+"', '"+tfentermark1.getText()+"','"+tfentermark2.getText()+"','"+tfentermark3.getText()+"','"+tfentermark4.getText()+"','"+tfentermark5.getText()+"')";
                     c.s.executeUpdate(query1);
                     c.s.executeUpdate(query2);
                     
                     JOptionPane.showMessageDialog(null, "Succusfully enterd!");
                     setVisible(false);
                      
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        else{
     setVisible(false);
}
  }  
    public static void main(String[] args){
        new EnterMarks();
    }
    
}
