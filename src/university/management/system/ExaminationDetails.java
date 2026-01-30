package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import net.proteanit.sql.DbUtils;


public class ExaminationDetails extends JFrame implements ActionListener{
    
    JTextField search;
    JButton submit, cancel;
    JTable table;
    
    ExaminationDetails(){
        
        setSize(1000, 500);
        setLocation(250, 50);
        setLayout(null);
        
        getContentPane().setBackground(Color.WHITE);
        
        JLabel heading = new JLabel("Check Results");
        heading.setBounds(30, 5, 300, 30);
        heading.setFont(new Font("Tahoma",Font.BOLD, 20));
        add(heading);
        
        search = new JTextField();
        search.setBounds(30, 70, 200, 30 );
        search.setFont(new Font("Tahoma", Font.PLAIN, 18));
        add(search);
        
        submit = new JButton("Result");
        submit.setForeground(Color.white);
        submit.setBackground(Color.black);
        submit.setFont(new Font("Tahoma", Font.BOLD, 15));
        submit.setBounds(250, 70, 200, 30 );
        submit.addActionListener(this);
        add(submit);
        
        cancel = new JButton("Back");
        cancel.setForeground(Color.white);
        cancel.setBackground(Color.black);
        cancel.setFont(new Font("Tahoma", Font.BOLD, 15));
        cancel.addActionListener(this);
        cancel.setBounds(470, 70, 200, 30 );
        add(cancel);
        
        table = new JTable();
        table.setFont(new Font("Tahoma", Font.PLAIN, 16));
         
        JScrollPane jsp = new JScrollPane(table);
        jsp.setBounds(0, 130, 1000, 320 );
        add(jsp);
         
        try{
             Conn c = new Conn();
             ResultSet rs = c.s.executeQuery("select * from student");
             table.setModel(DbUtils.resultSetToTableModel(rs));
             
         }
        catch(Exception e){
             e.printStackTrace();
         }
        
         table.addMouseListener(new MouseAdapter(){
       
            public void mouseClicked(MouseEvent me){
                int row = table.getSelectedRow();
                search.setText(table.getModel().getValueAt(row, 2).toString()); 
            }
         
        });
         
         setVisible(true);
    }
         
        public void actionPerformed(ActionEvent ae){
            if(ae.getSource()==submit){
              new Marks(search.getText());
              setVisible(false);
            }
            else{
                setVisible(false);
            }
        }
        
        
    
    
    public static void main(String[] args){
         
        new ExaminationDetails();
        
    }
}
