
package university.management.system;
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.*;

public class Project extends JFrame implements ActionListener{
    
    Project(){
        
        setSize(1920, 1080);
       
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1600, 800, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image);
        
        JMenuBar mb = new JMenuBar();
        
        //New Information
        JMenu NewInformation = new JMenu("New Information");
        NewInformation.setForeground(Color.blue);
        mb.add(NewInformation);
        
        JMenuItem Information1 = new JMenuItem("New Faculty Information");
        Information1.setBackground(Color.white);
        NewInformation.add(Information1);
        Information1.addActionListener(this);
        
        JMenuItem Information2 = new JMenuItem("New Student Information");
        Information2.setBackground(Color.white);
        NewInformation.add(Information2);
        Information2.addActionListener(this);
        
        //Details
        JMenu Details = new JMenu("Details");
        Details.setForeground(Color.red);
        mb.add(Details);
        
        JMenuItem Information3 = new JMenuItem("View Faculty Information");
        Information3.setBackground(Color.white);
        Information3.addActionListener(this);
        Details.add(Information3);
        
        JMenuItem Information4 = new JMenuItem("View Student Information");
        Information4.setBackground(Color.white);
        Information4.addActionListener(this);
        Details.add(Information4);
        
        //Leave
        JMenu leave = new JMenu("Leave");
        leave.setForeground(Color.blue);
        mb.add(leave);
        
        JMenuItem Information5 = new JMenuItem("Faculty Leave");
        Information5.setBackground(Color.white);
        Information5.addActionListener(this);
        leave.add(Information5);
        
        JMenuItem Information6 = new JMenuItem("Student Leave");
        Information6.setBackground(Color.white);
        Information6.addActionListener(this);
        leave.add(Information6);
        
        //Leave Details
        JMenu leaveDetails = new JMenu("Leave Details");
        leaveDetails.setForeground(Color.red);
        mb.add(leaveDetails);
        
        JMenuItem FacLeaveDetails = new JMenuItem("Faculty Leave Details");
        FacLeaveDetails.setBackground(Color.white);
        FacLeaveDetails.addActionListener(this);
        leaveDetails.add(FacLeaveDetails);
        
        JMenuItem student = new JMenuItem("Student Leave Details");
        student.setBackground(Color.WHITE);
        student.addActionListener(this);
        leaveDetails.add(student);
        

        //ExamDetails
        JMenu exam = new JMenu("Examination");
        exam.setForeground(Color.blue);
        mb.add(exam);
        
        JMenuItem examResult = new JMenuItem("Examination Result");
        examResult.setBackground(Color.white);
        examResult.addActionListener(this);
        exam.add(examResult);
        
        JMenuItem enterMarks = new JMenuItem("Enter Marks");
        enterMarks.setBackground(Color.white);
        enterMarks.addActionListener(this);
        exam.add(enterMarks);
        
        
        //Update Information
        JMenu updateInfo = new JMenu("Update Details");
        updateInfo.setForeground(Color.red);
        mb.add(updateInfo);
        
        JMenuItem updateFacultyInfo = new JMenuItem("Update faculty Details");
        updateFacultyInfo.setBackground(Color.white);
        updateFacultyInfo.addActionListener(this);
        updateInfo.add(updateFacultyInfo);
        
        JMenuItem updateStudentInfo = new JMenuItem("Update Student Details");
        updateStudentInfo.setBackground(Color.white);
        updateStudentInfo.addActionListener(this);
        updateInfo.add(updateStudentInfo);
        
        //Fee Details
        JMenu fees = new JMenu("Fee Details");
        fees.setForeground(Color.blue);
        mb.add(fees);
        
        JMenuItem feeStructure = new JMenuItem("Fee structure");
        feeStructure.setBackground(Color.white);
        feeStructure.addActionListener(this);
        fees.add(feeStructure);
        
        JMenuItem feeForm = new JMenuItem("Student fee Form");
        feeForm.setBackground(Color.white);
        feeForm.addActionListener(this);
        fees.add(feeForm);
        
        
        //about
         JMenu about = new JMenu("About");
        about.setForeground(Color.red);
        mb.add(about);
        
        JMenuItem ab = new JMenuItem("about");
        ab.setBackground(Color.white);
        ab.addActionListener(this);
        about.add(ab);
        
        //Utility
        JMenu utility = new JMenu("Utility");
        utility.setForeground(Color.blue);
        mb.add(utility);
        
        JMenuItem notepad = new JMenuItem("Notepad");
        notepad.setBackground(Color.white);
        notepad.addActionListener(this);
        utility.add(notepad);
        
        JMenuItem calci = new JMenuItem("Calculator");
        calci.setBackground(Color.white);
        calci.addActionListener(this);
        utility.add(calci);
        
        //exit
        JMenu exit = new JMenu("Exit");
        exit.setForeground(Color.red);
        mb.add(exit);
        
        JMenuItem ex = new JMenuItem("Exit");
        ex.setBackground(Color.white);
        ex.addActionListener(this);
        exit.add(ex);
        
        setJMenuBar(mb);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        String msg = ae.getActionCommand();
        
        if(msg.equals("Exit")){
            setVisible(false);
        }else if(msg.equals("calculator")){
            try{
                Runtime.getRuntime().exec("calci.exe");
            }catch(Exception e){
                
            }
        }
            else if(msg.equals("Notepad")){
            try{
                Runtime.getRuntime().exec("notepad.exe");
            }catch(Exception e){
                
            }
            }
            else if(msg.equals("New Faculty Information"))
            {
                   new AddTeacher();
                    }
            else if(msg.equals("New Student Information")){
                new AddStudent();
            }else if(msg.equals("View Faculty Information")){
                new TeacherDetails();
            }else if(msg.equals("View Student Information")){
                new StudentDetails();
            }else if(msg.equals("Faculty Leave")){
                new TeacherLeave();
            }else if(msg.equals("Student Leave")){
                new StudentLeave();
            }else if(msg.equals("Faculty Leave Details")){
                new TeacherLeaveDetails();
            }else if(msg.equals("Student Leave Details")){
                new StudentLeaveDetails();
            }else if(msg.equals("Update faculty Details")){
                new UpdateTeacherDetails();
            }else if(msg.equals("Update Student Details")){
                new UpdateStudentDetails();
            }else if(msg.equals("Enter Marks")){
                new EnterMarks();
            }else if(msg.equals("Examination Result")){
                new ExaminationDetails();
            }else if(msg.equals("Fee structure")){
                new FeeStructure();
            }else if(msg.equals("about")){
                new About();
            }else if(msg.equals("Student fee Form")){
                new StudentFeeForm();
            }
    }
    
    public static void main(String[] args){
        new Project();
    }
    
}
