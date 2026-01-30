
package university.management.system;

import javax.swing.*;
import java.awt.*;

public class About extends JFrame {
    
    About(){
        
        setSize(800, 600);
        setLocation(300, 50);
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading = new JLabel("<html>University<br/>Management System</html>");
        heading.setBounds(30,30,400,90);
        heading.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(heading);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/about.jpg"));
        Image i2 = i1.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400,10,300, 200);
        add(image);
        
        JLabel name = new JLabel("Directed by: VTU");
        name.setBounds(30,100,400,30);
        name.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(name);
        
        JLabel contact = new JLabel("Contact : vtu123@gmail.com");
        contact.setBounds(30,130,400,30);
        contact.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(contact);
        
        JLabel phone = new JLabel("Phone : 7658954345");
        phone.setBounds(30,160,400,30);
        phone.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(phone);
        
        JLabel course = new JLabel("Courses Offered");
        course.setBounds(30,200,400,90);
        course.setFont(new Font("Tahoma", Font.BOLD, 20));
        add(course);
        
        
        

        setVisible(true);
        
    }
    
    public static void main(String[] args){
        new About();
    }
    
}
