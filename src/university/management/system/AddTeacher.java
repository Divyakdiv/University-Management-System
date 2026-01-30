
package university.management.system;


import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class AddTeacher  extends JFrame implements ActionListener{
    
    JTextField tfname , tffname, tfadress, tfphone, tfemail, tfx, tfxii, tfadhar;
    JLabel labelempid;
    JDateChooser dcdob;
    JComboBox cbcourse, cbbranch;
    JButton submit, cancel;
    
    Random ran = new Random();
    Long first4 = Math.abs((ran.nextLong() %9000L)+ 1000L);
    
    AddTeacher(){
        setSize(800, 600);
        setLocation(350, 50);
        
       setLayout(null);
       
        JLabel heading = new JLabel("New Teacher Information");
        heading.setBounds(230, 30, 500, 50);
        heading.setFont(new Font("serif",Font.BOLD, 30));
        add(heading);
         
         
        JLabel lb1name = new JLabel("Name:");
        lb1name.setBounds(40, 120, 100, 30);
        lb1name.setFont(new Font("serif",Font.BOLD, 20));
        add(lb1name);
        
        tfname = new JTextField();
        tfname.setBounds(120, 120, 100, 30);
        add(tfname);
        
        JLabel lb1fname = new JLabel("Father's Name:");
        lb1fname.setBounds(300, 120, 200, 30);
        lb1fname.setFont(new Font("serif",Font.BOLD, 20));
        add(lb1fname);
        
        tffname = new JTextField();
        tffname.setBounds(500, 120, 100, 30);
        add(tffname);
        
        JLabel lb1roll = new JLabel("EmployeId:");
        lb1roll.setBounds(40, 180, 300, 30);
        lb1roll.setFont(new Font("serif",Font.BOLD, 20));
        add(lb1roll);
        
       labelempid = new JLabel("101"+first4);
       labelempid.setBounds(145, 180, 200, 30);
       labelempid.setFont(new Font("serif",Font.BOLD, 20));
       add(labelempid);
       
       
       JLabel lbdob = new JLabel("Date of Birth:");
       lbdob.setBounds(300, 180, 200, 30);
       lbdob.setFont(new Font("serif",Font.BOLD, 20));
       add(lbdob);
       
       dcdob = new JDateChooser();
       dcdob.setBounds(500, 180, 120, 30);
       add(dcdob);
       
       JLabel lbadress = new JLabel("Adress:");
        lbadress.setBounds(40, 240, 100, 30);
        lbadress.setFont(new Font("serif",Font.BOLD, 20));
        add(lbadress);
        
        tfadress = new JTextField();
        tfadress.setBounds(120, 240, 100, 30);
        add(tfadress);
        
        JLabel lbphone= new JLabel("Phone:");
       lbphone.setBounds(300, 240, 120, 30);
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
        tfemail.setBounds(120, 300, 140, 30);
        add(tfemail);
        
        JLabel lbx= new JLabel("ClassX(Marks):");
       lbx.setBounds(300, 300, 150, 30);
       lbx.setFont(new Font("serif",Font.BOLD, 20));
       add(lbx);
       
       tfx = new JTextField();
       tfx.setBounds(500, 300, 120, 30);
       add(tfx);
        
        JLabel lbadhar = new JLabel("Adhar:");
        lbadhar.setBounds(40, 360, 100, 30);
        lbadhar.setFont(new Font("serif",Font.BOLD, 20));
        add(lbadhar);
        
        tfadhar = new JTextField();
        tfadhar.setBounds(120, 360, 140, 30);
        add(tfadhar);
        
        JLabel lbxii = new JLabel("ClassXII(Marks):");
        lbxii.setBounds(300, 360, 180, 30);
        lbxii.setFont(new Font("serif",Font.BOLD, 20));
        add(lbxii);
        
        tfxii = new JTextField();
        tfxii.setBounds(500, 360, 120, 30);
        add(tfxii);
        
        JLabel lbcourse = new JLabel("Qualification:");
        lbcourse.setBounds(40, 420, 200, 30);
        lbcourse.setFont(new Font("serif",Font.BOLD, 20));
        add(lbcourse);
        
        String course[] = {"B.Tech", "B.E", "Msc", "MCom","BA","Mtech","Pharmacy"};
        cbcourse = new JComboBox(course);
        cbcourse.setBounds(180, 420, 120, 30);
        cbcourse.setBackground(Color.WHITE);
        add(cbcourse);
        
        JLabel lbbranch = new JLabel("Branch:");
        lbbranch.setBounds(370, 420, 100, 30);
        lbbranch.setFont(new Font("serif",Font.BOLD, 20));
        add(lbbranch);
        
        String branch[] = {"Computer science", "Electrical Engineering", "Civil", "AI","Cyber Security","Information Science","Mechanical"};
        cbbranch = new JComboBox(branch);
        cbbranch.setBounds(500, 420, 160, 30);
        cbbranch.setBackground(Color.WHITE);
        add(cbbranch);
        
        submit = new JButton("Submit");
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
                
                String name = tfname.getText();
                String fname = tffname.getText();
                String empId = labelempid.getText();
                String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
                String adress = tfadress.getText();
                String phone = tfphone.getText();
                String email = tfemail.getText();
                String x = tfx.getText();
                String xii = tfxii.getText();
                String adhar = tfadhar.getText();
                String qualification = (String)cbcourse.getSelectedItem();
                String branch = (String)cbbranch.getSelectedItem();
                
                try{
                    
                    String query = "Insert into teacher value('"+name+"','"+fname+"','"+empId+"','"+dob+"','"+adress+"','"+phone+"','"+email+"','"+x+"','"+xii+"','"+adhar+"','"+qualification+"','"+branch+"')";
                    
                    Conn con = new Conn();
                    con.s.executeUpdate(query);
                    
                    JOptionPane.showMessageDialog(null, "Teacher details Inserted successfully!");
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }else{
                setVisible(false);
            }
            
        }

    public static void main(String[] args){
        new AddTeacher();
    }
}
