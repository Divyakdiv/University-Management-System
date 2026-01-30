 
package university.management.system;

import javax.swing.*;
import java.awt.*;

public class Splash extends JFrame implements Runnable{
    
    Thread t ;
    Splash(){
        
        ImageIcon i1 = new  ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1000, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        
        
     setSize(1000, 700);
     setLocationRelativeTo(null);
     
     setVisible(true);
     
     t = new Thread(this);
        t.start();
     
   }
    
    public void run(){
        try{
            Thread.sleep(4000);
            setVisible(false);
            
            //Next frame
            new Login();
        }
        catch(Exception e){
            
        }
    }
    
    public static void main(String[] args){
      new  Splash();
    }
}
