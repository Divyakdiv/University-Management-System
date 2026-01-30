
package university.management.system;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

public class FeeStructure extends JFrame {
    
    FeeStructure(){
        
        setSize(1000, 600);
        setLocation(250,60);
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading = new JLabel("Fee Structure");
        heading.setBounds(20,10,200,20);
        heading.setFont(new Font("Tahoma",Font.BOLD, 20));
        add(heading);
        
        JTable tabel = new JTable();
        
        JScrollPane jsp = new JScrollPane(tabel);
        jsp.setBounds(0,50,1000,550);
        add(jsp);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from fee");
            tabel.setModel(DbUtils.resultSetToTableModel(rs));
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        setVisible(true);
        
    }
    
    public static void main(String[] args){
       new  FeeStructure();
    }
    
}
