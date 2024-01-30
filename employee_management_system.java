MINI PROJECT AFTER IMPROVEMENT




CONNECTION CLASS






package Employee_Management;


import java.sql.*;




public class ConnectionClass
{
  Connection con;
  Statement stm;


   ConnectionClass()
   {
     try 
     { 
        Class.forName("com.mysql.cj.jdbc.Driver");
        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_management","root","");//database name
        stm=con.createStatement();
        
     }
     catch(Exception ex)
     { 
          ex.printStackTrace();
     }
   }   
    public static void main(String[] args)
    { 
        new ConnectionClass();
    } 
}


























LOGIN PAGE






package Employee_Management;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Locale;


public class LoginPage extends JFrame implements ActionListener
{
    JFrame f;
    Font f1,f2;
    JLabel l1,l2,l4,l5;
    JTextField t1;
    JPasswordField t2;
    JButton b1,b2;
    
    LoginPage()
    {
        f=new JFrame("Login");
          f1=new Font("TImes New Roman",Font.BOLD,17);
          f2=new Font("TImes New Roman",Font.BOLD,12);
        
        f.setBackground(Color.WHITE);
        f.setLayout(null);
        
        l1=new JLabel("USERNAME");
        l1.setBounds(60,130,100,30);
        f.add(l1);
         l1.setFont(f2);
        
        l2=new JLabel("PASSWORD");
        l2.setBounds(60,200,100,30);
        f.add(l2);
         l2.setFont(f2);
        
          l4=new JLabel("WELCOME !");
        l4.setBounds(270,20,100,30);
        f.add(l4);
        l4.setFont(f1);
        
         l4=new JLabel("PLEASE LOGIN");
        l4.setBounds(60,60,100,30);
        f.add(l4);
        l4.setFont(f2);
        
        t1=new JTextField();
        t1.setBounds(170,130,150,30);
        f.add(t1);
        
        t2=new JPasswordField();
        t2.setBounds(170,200,150,30);
        f.add(t2);
        
       ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("Employee_Management/Icons/lo.png"));
        Image i2=i1.getImage().getScaledInstance(350,300,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel l3=new JLabel(i3);
        l3.setBounds(250,50,550,350);
        f.add(l3);
        
        b1=new JButton("Login");
        b1.setBackground(Color.BLACK);
        b1.setBounds(60,330,120,30);
        b1.addActionListener(this);
        b1.setForeground(Color.WHITE);
        f.add(b1);
        
        b2=new JButton("Close");
        b2.setBackground(Color.BLACK);
        b2.setBounds(200,330,120,30);
        b2.addActionListener(this);
        b2.setForeground(Color.WHITE);
        f.add(b2);
        
        f.getContentPane();
        
        f.setVisible(true);
        f.setSize(720,450);
        f.setLocation(400,300);
    }
    
    public void actionPerformed(ActionEvent ee)
    {
        if(ee.getSource()==b1)
        {
            try
            {
                ConnectionClass obj=new ConnectionClass();
                String name=t1.getText();
                String pass=t2.getText();
                String q="select * from logindata where username='"+name+"'and password='"+pass+"'";
                ResultSet rs=obj.stm.executeQuery(q);
                if(rs.next())
                {
                   new HomePage().setVisible(true);
                    System.out.println("Login.");
                   
                    f.setVisible(false);
                       
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"You have entered Wrong Username and Password");
                    f.setVisible(false);
                    f.setVisible(true);
                    
                }
                
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
                
        }
       if(ee.getSource()==b2)  
       {
           this.f.setVisible(false);
       }
    }
    
    public static void main(String[] args)
    {
        new LoginPage();
        
    
    }
    
}




























HOME PAGE




package Employee_Management;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class HomePage  extends JFrame implements ActionListener
{ 
     JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
     Font f,f1,f2;
     JPanel pi;
     
     HomePage()
     {
        super("Employee Home Page ");
        setLocation(0,0);
        setSize(1550,800);
        
        f=new Font("Times New Roman",Font.BOLD,20);
        f2=new Font ("Times New Roman",Font.BOLD,35);
        f1=new Font("Times New Roman",Font.BOLD,20);
        
        ImageIcon ic=new ImageIcon(ClassLoader.getSystemResource("Employee_Management/Icons/off.jpg"));
        Image img=ic.getImage().getScaledInstance(1550,800,Image.SCALE_DEFAULT);
        ImageIcon ic1=new ImageIcon(img);
        l1=new JLabel(ic1);
        
        JMenuBar m1=new JMenuBar();
        JMenu men1=new JMenu("Profile");
        JMenuItem ment1=new JMenuItem("Complete Profile");
        JMenuItem ment2=new JMenuItem("View Profile");
        
        JMenu men2=new JMenu("Manage");
        JMenuItem ment3=new JMenuItem("Update Details");
        
        JMenu men3=new JMenu("Attendance");
        JMenuItem ment5=new JMenuItem("Take Attendance");
        JMenuItem ment6=new JMenuItem("View Attendance");
        
        JMenu men4=new JMenu("Leave");
        JMenuItem ment7=new JMenuItem("Apply Leave");
        JMenuItem ment8=new JMenuItem("View Leaves");
        
        JMenu men5=new JMenu("Salary");
        JMenuItem ment9=new JMenuItem("Add Salary");
        JMenuItem ment10=new JMenuItem("Generate Salary Slip");
        
        JMenu men6= new JMenu("Exit");
        JMenuItem ment11=new JMenuItem("Logout");
        
        JMenu men7=new JMenu("Delete");
        JMenuItem ment12=new JMenuItem("Delete Employee");
        
        men1.add(ment1);
        men1.add(ment2);
        men2.add(ment3);
        men3.add(ment5);
        men3.add(ment6);
        men4.add(ment7);
        men4.add(ment8);
        men5.add(ment9);
        men5.add(ment10);
        men6.add(ment11);
        men7.add(ment12);
        
        m1.add(men1);
        m1.add(men2);
        m1.add(men3);
        m1.add(men4);
        m1.add(men5);
        m1.add(men7);
        m1.add(men6);
        
        men1.setFont(f);
        men2.setFont(f);
        men3.setFont(f);
        men4.setFont(f);
        men5.setFont(f);
        men6.setFont(f);
        men7.setFont(f);
        
        
        ment1.setFont(f1);
        ment2.setFont(f1);
        ment3.setFont(f1);
       
        ment5.setFont(f1);
        ment6.setFont(f1);
        ment7.setFont(f1);
        ment8.setFont(f1);
        ment9.setFont(f1);
        ment10.setFont(f1);
        ment11.setFont(f1);
        ment12.setFont(f1);
        
        m1.setBackground(Color.DARK_GRAY);
        
        men1.setForeground(Color.WHITE);
        men2.setForeground(Color.WHITE);
        men3.setForeground(Color.WHITE);
        men4.setForeground(Color.WHITE);   
        men5.setForeground(Color.WHITE);
        men7.setForeground(Color.WHITE);
        men6.setForeground(Color.WHITE);
        
        ment1.setBackground(Color.WHITE);
        ment2.setBackground(Color.WHITE);
        ment3.setBackground(Color.WHITE); 
        ment5.setBackground(Color.WHITE); 
        ment6.setBackground(Color.WHITE);
        ment7.setBackground(Color.WHITE);  
        ment8.setBackground(Color.WHITE);
        ment9.setBackground(Color.WHITE);   
        ment10.setBackground(Color.WHITE); 
        ment11.setBackground(Color.WHITE);  
        ment12.setBackground(Color.WHITE);
        
        
        ment1.addActionListener(this);
        ment2.addActionListener(this);
        ment3.addActionListener(this);  
        ment5.addActionListener(this);
        ment6.addActionListener(this);
        ment7.addActionListener(this);  
        ment8.addActionListener(this);
        ment9.addActionListener(this); 
        ment10.addActionListener(this);
        ment11.addActionListener(this);
        ment12.addActionListener(this);
        
         setJMenuBar(m1);
         add(l1);
           
     }         
    
     public void actionPerformed(ActionEvent e)
     {
      String comnd=e.getActionCommand();
      if(comnd.equals("Complete Profile"))
      {
         new Add_Employee();
      }
      else if(comnd.equals("View Profile"))
      {
        new View_Employee();
      }
      else if(comnd.equals("Update Details"))
      {
         new Update_Details_Data().setVisible(true);
      }
      else if(comnd.equals("Take Attendance"))
      {
        new Employee_Attendance().setVisible(true);
      }
      else if(comnd.equals("View Attendance"))
      {
          new View_Attendance().setVisible(true);
       }  
      else if(comnd.equals("Apply Leave"))
      {
        new Apply_Leave().setVisible(true);
       }
      else if(comnd.equals("View Leaves"))
      {
          new View_Leaves().setVisible(true); 
      }
      else if(comnd.equals("Add Salary"))
      {
          new Salary().setVisible(true);
      }
      else if(comnd.equals("Generate Salary Slip"))
      {
          new Generate_PaySlip().setVisible(true);
      }
      else if(comnd.equals("Delete Employee"))
      {
          new Delete_Employee().setVisible(true);
      }
      else if(comnd.equals("Logout"))
      {
         System.exit(0);
      }
         
     }
     
    public static void main(String[] args)
    {
        new HomePage().setVisible(true);
    }
     
}




















VIEW EMPLOYEE


package Employee_Management;


import java.awt.*;
 import javax.swing.*;
 import java.awt.event.*;
 import java.sql.*;


public class View_Employee implements ActionListener
{
    JFrame f;
    JTextField t;
    JLabel l1,l2;
    JButton b,b2;
    
    View_Employee()
    {
        f=new JFrame("View Employee");
        f.setBackground(Color.GREEN);
        f.setLayout(null);
        
        l1=new JLabel();
        l1.setBounds(0,0,500,270);
        l1.setLayout(null);
        
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("Employee_Management/Icons/id.jpg")); //image path may differ i used it directly from the video
        Image img1=img.getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT);
        ImageIcon icl=new ImageIcon(img1);
        l1.setIcon(icl);
        
        l2=new JLabel("EMPLOYEE ID");
        l2.setVisible(true);
        l2.setBounds(40,60,250,30);
    
        l2.setForeground (Color.WHITE) ;
        Font F1 =new Font("Airal",Font.BOLD,25);
        l2.setFont(F1);
        l1.add (l2) ;
        f.add(l1);
        
        t=new JTextField();
        t.setBounds(240,60,220,30);
        l1.add(t);
        
        b=new JButton("Search");
        b.setBounds(140,150,100,30);
        b.addActionListener(this);
        l1.add(b);
        
        b2=new JButton("Cancel");
        b2.setBackground(Color.RED);
        b2.setForeground(Color.WHITE);
        b2.addActionListener(this);
        b2.setBounds(260,150,100,30);
        l1.add(b2);
        
        f.setSize(510,280);
        f.setLocation(450,250);
        f.setVisible(true);
        
        
        
        
        
        
        
    }


 
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b)
        {
           f.setVisible(false);
           new View_Employee_Data(t.getText());
           
        }  
        if(e.getSource()==b2)
        {
           f.setVisible(false);
           new HomePage();
        }
    }
    public static void main(String[] args)
    {
        new View_Employee();
        
    }
}
























ADD EMPLOYEE




package Employee_Management;
 
 import java.awt.*;
 import javax.swing.*;
 import java.awt.event.*;
 import java.sql.*;


 public class Add_Employee implements ActionListener
 {
    JLabel id, id1, id2, id3, id4, id5, id6, id7, id8, id9, id10, id11, id12, id13;
    JFrame f;
    JTextField t, t1, t2, t3, t4, t5, t6, t7, t8, t9, t10, t11, t12, t13;
    JButton b,b1;
    Add_Employee()
    {
        f = new JFrame("Add Employee");
        f.setBackground(Color.WHITE);
        f.setLayout(null);


        


        id=new JLabel ();
        id.setBounds(0, 0, 900, 600);
        id.setLayout(null);
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("Employee_Management/Icons/det.jpg")); //image path may differ i used it directly from the video
        Image i1=img.getImage().getScaledInstance(900, 600, Image.SCALE_DEFAULT);
        ImageIcon img1=new ImageIcon(i1);
        id.setIcon(img1);
        f.add(id);
         
        id1=new JLabel("NEW EMPLOYEE DETAILS");
        id1.setBounds(250,30,500,50);
        id1.setFont (new Font ("TImes New Roman", Font.BOLD,30) ) ;
        id1.setForeground (Color.black) ;
        id.add (id1);
        f.add (id) ;
        
        id2=new JLabel ("Name") ;
        id2.setBounds (50, 150, 150, 30) ;
        id2.setFont (new Font("TImes New Roman", Font.BOLD, 20));
        id.add(id2) ;


        t1=new JTextField();
        t1.setBounds(200,150,150,30);
        id. add (t1) ;


        id3=new JLabel ("Fathers Name") ;
        id3.setBounds (450, 150, 200, 30) ;
        id3.setFont (new Font ("TImes New Roman", Font.BOLD, 20) ) ;
        id.add(id3) ;


        t2=new JTextField();
        t2.setBounds(600,150,150,30);
        id. add (t2) ;


        id4=new JLabel ("Age") ;
        id4.setBounds (50, 200, 100, 30) ;
        id4.setFont (new Font ("TImes New Roman", Font.BOLD, 20) ) ;
        id.add(id4) ;


        t3=new JTextField();
        t3.setBounds(200,200,150,30);
        id. add (t3) ;


        id5=new JLabel ("Date of birth") ;
        id5.setBounds (450, 200, 200, 30) ;
        id5.setFont (new Font ("TImes New Roman", Font.BOLD, 20) ) ;
        id.add(id5) ;


        t4=new JTextField();
        t4.setBounds(600,200,150,30);
        id. add (t4) ;


        id6=new JLabel ("Address") ;
        id6.setBounds (50, 250, 100, 30) ;
        id6.setFont (new Font ("TImes New Roman", Font.BOLD, 20) ) ;
        id.add(id6) ;


        t5=new JTextField();
        t5.setBounds(200,250,150,30);  //may exp some error here change the coordinates if needed
        id. add (t5) ;


        id7=new JLabel("Phone") ;
        id7.setBounds (450, 250, 100, 30) ;
        id7.setFont (new Font ("TImes New Roman", Font.BOLD, 20) ) ;
        id.add(id7) ;


        t6=new JTextField();
        t6.setBounds(600,250,150,30);
        id. add (t6) ;


        id8=new JLabel("Email ID") ;
        id8.setBounds (50, 300, 100, 30) ;
        id8.setFont (new Font ("TImes New Roman", Font.BOLD, 20) ) ;
        id.add(id8) ;


        t7=new JTextField();
        t7.setBounds(200,300,150,30);
        id. add (t7) ;


        id9=new JLabel("Education") ;
        id9.setBounds (450, 300, 100, 30) ;
        id9.setFont (new Font ("TImes New Roman", Font.BOLD, 20) ) ;
        id.add(id9) ;


        t8=new JTextField();
        t8.setBounds(600,300,150,30);
        id. add (t8) ;


        id10=new JLabel ("Job Post") ;
        id10.setBounds (50, 350, 100, 30) ;
        id10.setFont (new Font ("TImes New Roman", Font.BOLD, 20) ) ;
        id.add(id10) ;


        t9=new JTextField();
        t9.setBounds(200,350,150,30);
        id. add (t9) ;


        id11=new JLabel("Adhaar number") ;
        id11.setBounds (450, 350, 100, 30) ;
        id11.setFont (new Font ("TImes New Roman", Font.BOLD, 20) ) ;
        id.add(id11) ;


        t10=new JTextField();
        t10.setBounds(600,350,150,30);
        id. add (t10) ;


        id12=new JLabel ("Employee ID") ;
        id12.setBounds (50, 400, 150, 30) ;
        id12.setFont (new Font ("TImes New Roman", Font.BOLD, 20) ) ;
        id.add(id12) ;


        t11=new JTextField();
        t11.setBounds(200,400,150,30);
        id. add (t11) ;


        b = new JButton ("Submit");
        b.setBackground (Color.BLACK) ;
        b.setForeground (Color.WHITE) ;
        b.setBounds (250, 480, 150, 40) ;


        id.add (b) ;


        b1 = new JButton ("Cancel");
        b1.setBackground (Color.RED) ;
        b1.setForeground (Color.WHITE) ;
        b1.setBounds (450, 480, 150, 40) ;
        
        id.add (b1) ;


        b.addActionListener(this);
        b1.addActionListener(this);


        f.setVisible(true);
        f.setSize(900,600);
        f.setLocation(300,100);




    }
    public void actionPerformed(ActionEvent e )
    {
        String name= t1.getText();
        String fname= t2.getText();
        String age= t3.getText();
        String dob= t4.getText();
        String address= t5.getText();
        String phone= t6.getText();
        String email= t7.getText();
        String education= t8.getText();
        String post= t9.getText();
        String adhaar= t10.getText();
        String eid= t11.getText();


        if(e.getSource()==b)
        {
            try
            {
                ConnectionClass obj = new ConnectionClass();
                String q = "insert into employee values('"+name+"','"+fname+"','"+age+"','"+dob+"','"+address+"','"+phone+"','"+email+"','"+education+"','"+post+"','"+adhaar+"','"+eid+"')";
                obj.stm.executeUpdate(q);
                JOptionPane.showMessageDialog(null, "Details Successfully Inserted") ;
                f.setVisible(false);
                new HomePage();
            }
            catch(Exception ex)
            {
                System.out.println("the error is:"+ex);


            }
        }
        if(e.getSource()==b1)
        {
            f.setVisible(false);
            new HomePage();
        }
        


     }
       






    
    public static void main(String[] args)
    {
        new Add_Employee();


    }
 }




























VIEW EMPLOYEE DATA






package Employee_Management;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Locale;




public class View_Employee_Data implements ActionListener
{
   JFrame f;
   JLabel id8,id,aid,id1,aid1,id2,aid2,id3,aid3,id4,aid4,id5,aid5,id6,aid6,id7,aid7,id9;
   String emp_id,name,father,address,phone,email,education,post,age,dob,aadhar;
   JButton b1,b2;
   ImageIcon icon;
   
    View_Employee_Data(String eid)
    {
       try 
       {
           ConnectionClass obj=new ConnectionClass();
           String s="select * from employee where eid='"+eid+"'";
           ResultSet rs=obj.stm.executeQuery(s);
           
           while(rs.next())
           {
               
             name=rs.getString("name");
             father=rs.getString("fname");
             age=rs.getString("age");
             dob=rs.getString("dob");
             address=rs.getString("address");
             phone=rs.getString("phone");
             email=rs.getString("email");
             education=rs.getString("education");
             post=rs.getString("post");
             aadhar=rs.getString("adhaar");
             emp_id=rs.getString("eid");
             
         
           }    
     
       }
       catch(Exception ex)
       {
           ex.printStackTrace();
       }
        
       f=new JFrame("Display Employee Details");
       f.setVisible(true);
       f.setSize(595, 642);
       f.setLocation(450,200);
       f.setBackground(Color.WHITE);
       f.setLayout(null);
       
       id9=new JLabel();
       id9.setBounds(0, 0, 593, 642);
       id9.setLayout(null);
       ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("Employee_Management/Icons/LOG.png"));
       id9.setIcon(img);
       
       id8 = new JLabel("Employee Details");
       id8.setBounds(170, 10,250, 40);
       f.add(id8);
       id8.setFont(new Font("Airal",Font.BOLD,20));
       id9.add(id8);
       f.add(id9);
       
       id =  new JLabel("Employee Id:");
       id.setBounds(150, 70, 120, 30);
       id.setFont(new Font("serif",Font.BOLD,20));
       id9.add(id);
               
       aid = new JLabel(emp_id);
       aid.setBounds(330,70,200,30);
       aid.setFont(new Font("serif",Font.BOLD,20));
       id9.add(aid);
       
       
       id1 = new JLabel("Name:");
       id1.setBounds(150,120,100,30);
       id1.setFont(new Font("serif",Font.BOLD,20));
       id9.add(id1);
       
       aid1 = new JLabel(name);
       aid1.setBounds(330,120,300,30);
       aid1.setFont(new Font("serif",Font.BOLD,20));
       id9.add(aid1);
       
       id2 = new JLabel("Father's Name:");
       id2.setBounds(150,170,200,30);
       id2.setFont(new Font("serif",Font.BOLD,20));
       id9.add(id2);
       
       aid2 = new JLabel(father);
       aid2.setBounds(330,170,300,30);
       aid2.setFont(new Font("serif",Font.BOLD,20));
       id9.add(aid2);
       
       id3 = new JLabel("Address:");
       id3.setBounds(150,220,300,30);
       id3.setFont(new Font("serif",Font.BOLD,20));
       id9.add(id3);
       
     
       aid3 = new JLabel(address);
       aid3.setBounds(330,220,300,30);
       aid3.setFont(new Font("serif",Font.BOLD,20));
       id9.add(aid3); 
        
       id4 = new JLabel("Mobile No:");
       id4.setBounds(150,270,100,30);//
       id4.setFont(new Font("serif",Font.BOLD,20));
       id9.add(id4); 
       
       
       aid4 = new JLabel(phone);
       aid4.setBounds(330,270,300,30);
       aid4.setFont(new Font("serif",Font.BOLD,20));
       id9.add(aid4); 
       
       
       id5 = new JLabel("Email id:");
       id5.setBounds(150,320,100,30);
       id5.setFont(new Font("serif",Font.BOLD,20));
       id9.add(id5);
        
       aid5 = new JLabel(email);
       aid5.setBounds(330,320,300,30);
       aid5.setFont(new Font("serif",Font.BOLD,20));
       id9.add(aid5); 
        
        
        
       id6 = new JLabel("Education:");
       id6.setBounds(150,370,100,30);
       id6.setFont(new Font("serif",Font.BOLD,20));
       id9.add(id6);
       
       aid6 = new JLabel(education);
       aid6.setBounds(330,370,300,30);
       aid6.setFont(new Font("serif",Font.BOLD,20));
       id9.add(aid6); 
       
       id7 = new JLabel("Job Post:");
       id7.setBounds(150,420,100,30);
       id7.setFont(new Font("serif",Font.BOLD,20));
       id9.add(id7);
       
       
       
       aid7 = new JLabel(post);
       aid7.setBounds(330,420,300,30);
       aid7.setFont(new Font("serif",Font.BOLD,20));
       id9.add(aid7); 
       
       b1=new JButton("Print");
       b1.setBackground(Color.BLACK);
       b1.setForeground(Color.WHITE);
       b1.setBounds(160, 520, 100, 30);
       b1.addActionListener(this);
       id9.add(b1);
       
       
       
       b2=new JButton("cancel");
       b2.setBackground(Color.RED);
       b2.setForeground(Color.WHITE);
       b2.setBounds(350, 520, 100, 30);
       b2.addActionListener(this);
       id9.add(b2); 
       
    }


     public void actionPerformed(ActionEvent e)
     {
      if(e.getSource()==b1)  
      {
          JOptionPane.showMessageDialog(null, "printed successfully");
          f.setVisible(false);
          new HomePage();
      
      } 
      
      if(e.getSource()==b2)
      {
          f.setVisible(false);
          new View_Employee();
          
      }   
      
      
      
      
      
         
     }        
}






















EMPLOYEE ATTENDANCE




package Employee_Management;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;




public class Employee_Attendance extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4,l5,l6;
    Choice c1,c2,c3;
    JButton bt1,bt2;
    JTextField tf1,tf2;
    Font f;
    JPanel p;
    JFrame f1;
    
    Employee_Attendance()
    {
        super("Employee Attendance");
         
        setSize(500,350);
        setLocation(300,200);
        setResizable(false);
        
        
        f=new Font("TImes New Roman",Font.BOLD,15);
        
        l1=new JLabel("Select Employee ID");
        
      
        
        l2=new JLabel("First Half");
        l3=new JLabel("Second Half");
        l4=new JLabel("Name");
        l5=new JLabel("Email");
        
        l1.setFont(f);
        l2.setFont(f);
        l3.setFont(f);
        l4.setFont(f);
        l5.setFont(f);
        
        tf1=new JTextField();
        tf2=new JTextField();
        
        tf1.setFont(f);
        tf2.setFont(f);
        
        tf1.setEditable(false);
        tf2.setEditable(false);
        
        c2=new Choice();
        c2.add("Present");
        c2.add("Absent");
        
        c3=new Choice();
        c3.add("Present");
        c3.add("Absent");
        
        c2.setFont(f);
        c3.setFont(f);
        
        


        bt1=new JButton("Submit");
        bt2=new JButton("Close");
        
        bt1.setBackground(Color.BLACK);
        bt1.setBackground(Color.WHITE);
        
        bt2.setBackground(Color.BLACK);
        bt2.setBackground(Color.WHITE);
        
        bt1.setFont(f);
        bt2.setFont(f);
        
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        
        
        c1=new Choice();
        
        try
        {
            
           ConnectionClass obj=new ConnectionClass();
           String s="select * from employee ";
           ResultSet rest=obj.stm.executeQuery(s);
           
           while(rest.next())
           {
               c1.add(rest.getString("Eid"));
               
           }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        p=new JPanel();
        p.setLayout(new GridLayout(6,2,10,10));
        
        p.add(l1);
        p.add(c1);
        p.add(l4);
        p.add(tf1);
        p.add(l5);
        p.add(tf2);
        p.add(l2);
        p.add(c2);
        p.add(l3);
        p.add(c3);
        p.add(bt1);
        p.add(bt2);
        
        add(p);
        
        c1.addMouseListener(new MouseAdapter()
           {
          @Override
            public void mouseClicked(MouseEvent arg0)
            {
                try 
                {
                          
                    ConnectionClass obj2=new ConnectionClass();
                    String eid=c1.getSelectedItem();
                    String q2="select * from employee where eid='"+eid+"'";
                    ResultSet rest1=obj2.stm.executeQuery(q2);
           
                      while(rest1.next()) 
                      {
                          tf1.setText(rest1.getString("name"));
                          tf2.setText(rest1.getString("email"));
                      }
                  }
                catch(Exception exx)
                {
                    exx.printStackTrace();
                }
             }
          
        });
                
         
     }
   
   public void actionPerformed(ActionEvent ev)
   {
      if(ev.getSource()==bt1)
      {
          String ch_eid=c1.getSelectedItem();
          String ch_first_half=c2.getSelectedItem();
          String ch_second_half=c3.getSelectedItem();
          String name=tf1.getText();
          String email=tf2.getText();
          String dt=new java.util.Date() .toString();
          
          try
          {
             ConnectionClass obj1=new ConnectionClass();
             String q1="insert into attendance values('"+ch_eid+"','"+name+"','"+email+"','"+ch_first_half+"','"+ ch_second_half+"','"+dt+"')";
             obj1.stm.executeUpdate(q1);
             JOptionPane.showMessageDialog(null,"data inserted");
             setVisible(false);
        }  
          catch(Exception ex1)
          {
             ex1.printStackTrace();
          }
      }
      if(ev.getSource()==bt2)
      {
        JOptionPane.showMessageDialog(null,"are you sure to close?");
        setVisible(false);
        
      }
    
   }  
   public static void main(String args[])
   {
       new Employee_Attendance().setVisible(true);
   }
    
}
























VIEW ATTENDANCE




package Employee_Management;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;






public class View_Attendance extends JFrame implements ActionListener
{
   JTable t;
   JButton bt1;
   JTextField tf1;
   JPanel p1,p2,p3;
   String x[]={"Employee ID", "Name","Email","First Half","Second half","date"};
   String y[][]=new String [20][6];
   int i=0,j=0;
   Font f,f1;
   JLabel l1,l2;
   
   View_Attendance()
   {
       super("All Employee attendance records");
       setSize(1480,400);
       setLocation(0,10);
       f=new Font("Times New Roman",Font.BOLD,17);
       
       try
       {
           ConnectionClass obj=new ConnectionClass();
           String q="select * from attendance";
           ResultSet rest=obj.stm.executeQuery(q);
           while(rest.next())
           {
               y[i][j++]=rest.getString("Eid");
               y[i][j++]=rest.getString("name");
               y[i][j++]=rest.getString("Email");
               y[i][j++]=rest.getString("first_half");
               y[i][j++]=rest.getString("second_half");
               y[i][j++]=rest.getString("day_date");
               i++;
               j=0;
           }
t=new JTable(y,x);
       }
catch(Exception ex)
{
ex.printStackTrace();
}


t.setBackground(Color.BLACK);
t.setForeground(Color.WHITE);
t.setFont(f);


       
JScrollPane js=new JScrollPane(t);


f1=new Font("Times New Roman",Font.BOLD,25);


l1=new JLabel("Search any Employee") ;
l1.setHorizontalAlignment (JLabel. CENTER) ;
l1.setFont(f1);
l1. setForeground (Color.YELLOW) ;
l2=new JLabel("EMPLOYEE ID");
l2.setFont(f1);
l2. setForeground (Color. WHITE) ;
tf1=new JTextField();
bt1=new JButton("Search Employee");
tf1.setFont(f);
bt1.setFont(f);
bt1. setBackground (Color. WHITE) ;
bt1. setForeground (Color. BLACK) ;
bt1.addActionListener(this);




p1=new JPanel();
p1.setLayout (new GridLayout (1,1,10,10));
p1.add (l1);


p2=new JPanel();
p2.setLayout (new GridLayout (1,3,10,10));
p2.add (l2);
p2.add(tf1);
p2.add(bt1);


p3=new JPanel();
p3.setLayout(new GridLayout(2,1,10,10));
p3.add(p1);
p3.add(p2);


p1.setBackground(Color.BLACK);
p2.setBackground(Color.BLACK);
p3.setBackground(Color.BLACK);


add(p3,"South");
add(js);






     
}
   
   public void actionPerformed(ActionEvent e)
   {
      String eid=tf1.getText();
      if(e.getSource()==bt1)
      {
          new View_Attendance_Single(eid).setVisible(true);
      }
   }
   
   public static void main(String[] args)
   {
        new View_Attendance().setVisible(true);
   }
}
























VIEW ATTENDANCE SINGLE




package Employee_Management;


import java.sql.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;


public class View_Attendance_Single extends JFrame
{
JTable t;
String x[]={"Employee ID","Name","Email","Firsr Half","Second Half","date"};
String y[][]=new String [20][6];


int i=0,j=0;
Font f,f1;
int count=0;


View_Attendance_Single (String eid)
{
super("Particular Employee attendence records");
setSize (1480,400);
setLocation (0,10);
f=new Font("MS UI Gothic",Font.BOLD,17);


try
{
    ConnectionClass obj =new ConnectionClass();
String q="select * from attendance where Eid='"+eid+"'";
 ResultSet rest=obj.stm.executeQuery(q);
           while(rest.next())
           {
               count++;
               y[i][j++]=rest.getString("Eid");
               y[i][j++]=rest.getString("name");
               y[i][j++]=rest.getString("Email");
               y[i][j++]=rest.getString("first_half");
               y[i][j++]=rest.getString("second_half");
               y[i][j++]=rest.getString("day_date");
               i++;
               j=0;
           }
           if(count==0)
           {
               JOptionPane.showMessageDialog(null,"No Record Found");
           }
           else
           {
               t=new JTable(y,x);
               t.setBackground(Color.BLACK);
               t.setForeground(Color.WHITE);
               t.setFont(f);
               setSize(1480,400);
               setLocation(0,10);
               JScrollPane js=new JScrollPane(t);
               add(js);
           }  
           
}
               catch(Exception ex)
               {
                   ex.printStackTrace();
                   
               }
}
}




















APPLY LEAVE




package Employee_Management;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
 
public class Apply_Leave extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    JButton bt1,bt2;
    JPanel p1,p2,p3;
    JTextField tf1,tf2,tf3,tf4;
    Font f,f1;
    Choice ch1,ch2;
    
  Apply_Leave()
  {
    
        super("Apply Employee leave");
        setSize(950,450);
        setLocation(450,50);
        setResizable(false);
      
        f=new Font("Times New Roman",Font.BOLD,25);
        f1=new Font("Times New Roman",Font.BOLD,16);
        
        l1=new JLabel("APPLY EMPLOYEE LEAVE");
        l2=new JLabel("Select Employee ID");
        l3=new JLabel("Name");
        l4=new JLabel("Email");
        l5=new JLabel("Start Date");
        l6=new JLabel("End Date");
        l7=new JLabel("Leave Reason");
        
        tf1=new JTextField();
        tf2=new JTextField();
        tf3=new JTextField();
        tf4=new JTextField();
        
        bt1=new JButton("Submit");
        bt2=new JButton("Close");
        
        bt1.addActionListener(this);
        bt2.addActionListener(this);
        
        bt1.setForeground(Color.WHITE);
        bt2.setForeground(Color.WHITE);
        
        bt1.setBackground(Color.BLACK);
        bt2.setBackground(Color.RED);
        
        ch1=new Choice();
        
        try
        {
            
              
           ConnectionClass obj=new ConnectionClass();
           String q="select eid from employee ";
           ResultSet rest=obj.stm.executeQuery(q);
           
           while(rest.next())
           {
               ch1.add(rest.getString("Eid"));
               
           }
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        
        ch2=new Choice();
        ch2.add("Employee Health Issue");
        ch2.add("Family Member Health Issue");
        ch2.add("Function/Celebration");
        ch2.add("Party");
        ch2.add("Personal Things");
        ch2.add("Others");
        
        l1.setHorizontalAlignment(JLabel.CENTER);
        
        l1.setFont(f);
        l2.setFont(f1);
        l3.setFont(f1);
        l4.setFont(f1);
        l5.setFont(f1);    
        l6.setFont(f1);
        l7.setFont(f1);
        ch1.setFont(f1);
        ch2.setFont(f1);
        
         tf1.setFont(f1);
         tf2.setFont(f1);
         tf3.setFont(f1);
         tf4.setFont(f1);
         
          bt1.setFont(f1);
          bt2.setFont(f1);
         
         tf1.setEditable(false);
         tf2.setEditable(false);
         
         
         p1=new JPanel();
         p1.setLayout(new GridLayout(1,1,10,10));
         p1.add(l1);
         
         p2=new JPanel();
         p2.setLayout(new GridLayout(7,2,10,10));
         
         p2.add(l2);
         p2.add(ch1);
         p2.add(l3);
         p2.add(tf1);
         p2.add(l4);
         p2.add(tf2);
         p2.add(l5);
         p2.add(tf3);
         p2.add(l6);
         p2.add(tf4);
         p2.add(l7);
         p2.add(ch2);
         p2.add(bt1);
         p2.add(bt2);
         
          
         p3=new JPanel();
         p3.setLayout(new GridLayout(1,1,10,10));
         
        ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("Employee_Management/Icons/LEAVE.png"));
        Image img1=img.getImage().getScaledInstance(400,400,Image.SCALE_DEFAULT);
        ImageIcon ic1=new ImageIcon(img1);
         l8=new JLabel(ic1);
         
         p3.add(l8);
         
         setLayout(new BorderLayout(10,10));
         add(p1,"North");
         add(p3,"Center");
         add(p2,"West");
         
         ch1.addMouseListener(new MouseAdapter()
           {
         @Override
            public void mouseClicked(MouseEvent arg0)
            {
                try 
                {
                          
                    ConnectionClass obj2=new ConnectionClass();
                    String eid=ch1.getSelectedItem();
                    String q2="select * from employee where eid='"+eid+"'";
                    ResultSet rest1=obj2.stm.executeQuery(q2);
                    while(rest1.next())
                    {
                         tf1.setText(rest1.getString("name"));
                          tf2.setText(rest1.getString("email"));
                    }
                  
                } 
                catch(Exception exx)
                {
                    exx.printStackTrace();
                }
    
             }       
    
           });
  }   
  


  public void actionPerformed(ActionEvent ev)
  {
      if(ev.getSource()==bt1)
      {
          String eid=ch1.getSelectedItem();
          String name=tf1.getText();
          String email=tf2.getText();
          String startdt=tf3.getText();
          String enddt=tf4.getText();
          String reason=ch2.getSelectedItem();
          String apply_dt=new java.util.Date().toString(); 
          
         try
         {
              ConnectionClass obj1=new ConnectionClass();
             String q1="insert into apply_leave values('"+eid+"','"+name+"','"+email+"','"+startdt+"','"+enddt+"','"+reason+"','"+apply_dt+"')";
             int aa=obj1.stm.executeUpdate(q1);
             
             if(aa==1)
             {
                 
                 JOptionPane.showMessageDialog(null,"your data successfully updated");
                 this.setVisible(false);
             }    
             else 
             {
                 JOptionPane.showMessageDialog(null,"Please!, Fill all details carefully");
             }
           
         }
         
         catch(Exception ex)
         {
             ex.printStackTrace();
         }
       
      }
      if(ev.getSource()==bt2)
      {
          JOptionPane.showMessageDialog(null,"are you sure to close?");
          this.setVisible(false);
          
      } 
      
  }
public static void main(String[] args)
{
    new Apply_Leave().setVisible(true);
    
}
}


























VIEW LEAVE




package Employee_Management;






import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
 


public class View_Leaves extends JFrame implements ActionListener
{
      JTable t;
      JButton bt1;
      JTextField tf1;
      JPanel p1,p2,p3;
      String x[]={"Employee ID","Name","Email","Start Date","End Date","Reason","Apply Data"};
      String y[][]=new String[20][7];
      int i=0,j=0;
      Font f,f1;
      JLabel l1,l2;
   
      
     View_Leaves()
     {
        super("All Employee leave records");
        setSize(1480,400);
        setLocation(0,10);
        f=new Font("MS UI Gothic",Font.BOLD,17);
        
        try
        {
            
           ConnectionClass obj=new ConnectionClass();
           String q="select * from apply_leave";
           ResultSet rest=obj.stm.executeQuery(q);
           
           while(rest.next())
           {
               y[i][j++]=rest.getString("Eid");
               y[i][j++]=rest.getString("name");
               y[i][j++]=rest.getString("Email");
               y[i][j++]=rest.getString("start_date");
               y[i][j++]=rest.getString("end_date");
               y[i][j++]=rest.getString("reason");
               y[i][j++]=rest.getString("apply_date");
               i++;
               j=0;
               
           }
           t=new JTable(y,x);
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
        JScrollPane js=new JScrollPane(t);
        t.setBackground(Color.BLACK);
        t.setForeground(Color.WHITE);
        t.setFont(f);
        
        f1=new Font("Lucida Fax",Font.BOLD,25);
        
        l1=new JLabel("Search any Employee");
        l1.setHorizontalAlignment(JLabel.CENTER);
        l1.setFont(f1);
        l1.setForeground(Color.YELLOW);
        
        l2=new JLabel("EMPLOYEE ID");
        l2.setFont(f1);
        l2.setForeground(Color.WHITE);
        
        tf1=new JTextField();
        tf1.setFont(f);
        
        bt1=new JButton("Search Employee");
        bt1.setFont(f);
        
        bt1.setBackground( Color.WHITE);
        bt1.setForeground(Color.BLACK);
        bt1.addActionListener(this);
        
        p1=new JPanel();
        p1.setLayout(new GridLayout(1,1,10,10));
        p1.add(l1);
        
        p2=new JPanel();
        p2.setLayout(new GridLayout(1,3,10,10));
        p2.add(l2);
        p2.add(tf1);
        p2.add(bt1);
        
        p3=new JPanel();
        p3.setLayout(new GridLayout(2,1,10,10));
        p3.add(p1);
        p3.add(p2);
        
        p1.setBackground(Color.BLACK);
        p2.setBackground(Color.BLACK);
        p3.setBackground(Color.BLACK);
        
        add(p3,"South");
        add(js);
         
     }      
     
     public void actionPerformed(ActionEvent e)
     {
        String eid=tf1.getText();
        if(e.getSource()==bt1)
        {
         new View_leave_single(eid).setVisible(true);
        }
        
     }  
     public static void main(String[] args)
             
     {
           new View_Leaves().setVisible(true);
     }
    
}


























VIEW LEAVE SINGLE




package Employee_Management;
import java.sql.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;


public class View_leave_single extends JFrame
{
    JTable t;
    String x[]={"Employee ID", "Name", "Email", "Start Date", "End Date", "Reason", "Apply Date"};
    String y[][]=new String[20][7];
    int i=0,j=0;
    Font f, f1;
    int count=0;


    View_leave_single (String eid)
    {
        super ("Particular Employee Leave records");
        f=new Font ("MS UI Gothic", Font. BOLD, 17);
        try
        {
            ConnectionClass obj=new ConnectionClass () ;
            String q="select * from apply_leave where Eid= '"+eid+"'";
            ResultSet rest=obj.stm.executeQuery (q);
            while (rest.next () )
            { 
                count++;
                y[i][j++]=rest.getString ("Eid"); 
                y[i][j++]=rest.getString ("name");
                y[i][j++]=rest.getString ("Email");
                y[i][j++]=rest.getString ("start_date");
                y[i][j++]=rest.getString ("end_date");
                y[i][j++]=rest.getString ("reason");
                y[i][j++]=rest.getString("apply_date");
                i++;
                j=0;
            }


            if (count==0){
                JOptionPane. showMessageDialog (null, "No Record Found.");
            }
        
            else
            {
                t=new JTable (y,x) ;
                JScrollPane js=new JScrollPane (t);
                t. setBackground (Color. BLACK) ;
                t. setForeground (Color. WHITE);
                t. setFont (f);
                setSize (1480, 400);
                setLocation (0, 10); 
                add (js);
            }
        }
        catch (Exception ex){
            ex.printStackTrace () ;
        }
    }
}




















SALARY




package Employee_Management;


import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;


public class Salary extends JFrame implements ActionListener
{
    Font f, f1;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13;
    JTextField t1, t2, t3, t4, t5, t6, t7; 
    Choice ch1, ch2, ch3;
    
    JButton bt1,bt2;
    JPanel p1, p2, p3;
    Salary ()
    {
        super ("Salary");
        setLocation (100, 100);
        setSize (950, 700); 
        setResizable (false);
        f=new Font ("Times New Roman", Font. BOLD, 18);
        f1=new Font ("Times New Roman", Font. BOLD, 25) ;


        l1=new JLabel ("Select Employee ID");
        l2=new JLabel ("Name");
        l3=new JLabel ("Email");
        l4=new JLabel ("HRA");
        l5=new JLabel ("DA");
        l6=new JLabel ("MED");
        l7=new JLabel ("PF");
        l8=new JLabel ("Basic Salary");
        l9=new JLabel ("Select Month");
        l10=new JLabel ("Select Year");
        l12=new JLabel ("EMPLOYEE SALARY");


        l12. setHorizontalAlignment (JLabel. CENTER);
        ch1=new Choice ();
        try
        {
            ConnectionClass obj=new ConnectionClass();
            String q="Select eid from employee";
            ResultSet rest=obj.stm.executeQuery (q) ;
            while (rest.next ())
            {
              ch1.add (rest.getString ("Eid"));
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace () ;
        }
        ch2=new Choice ();
        ch2.add ("January");
        ch2.add ("February");
        ch2.add ("March");
        ch2.add ("April");
        ch2.add ("May");
        ch2.add ("June");
        ch2.add ("July");
        ch2.add ("August");
        ch2.add ("September");
        ch2.add ("October");
        ch2.add ("November");
        ch2.add ("December") ;


        ch3=new Choice ();
        ch3.add ("2015"); 
        ch3.add ("2016"); 
        ch3.add ("2017"); 
        ch3.add ("2018"); 
        ch3. add ("2019"); 
        ch3.add ("2020"); 
        ch3.add ("2021"); 
        ch3.add ("2022");


        l1. setFont (f);
        l2. setFont (f) ;
        l3. setFont (f) ;
        l4. setFont (f);
        l5. setFont (f);
        l6. setFont (f);
        l7. setFont (f) ;
        l8. setFont (f);
        l9. setFont (f);
        l10. setFont (f);
        l12. setFont (f1);


        ch1. setFont (f) ; 
        ch2.setFont (f) ; 
        ch3. setFont (f) ;


        t1=new JTextField (); 
        t2=new JTextField (); 
        t3=new JTextField (); 
        t4=new JTextField(); 
        t5=new JTextField (); 
        t6=new JTextField ();
        t7=new JTextField ();
        
        
        t1. setFont (f);
        t2.setFont (f); 
        t3. setFont (f) ; 
        t4. setFont (f) ; 
        t5. setFont (f) ; 
        t6.setFont (f); 
        t7.setFont (f);
        
        t1.setEditable (false);
        t2. setEditable (false) ; 


        ImageIcon img=new ImageIcon (ClassLoader.getSystemResource("Employee_Management/Icons/emp.png"));
        Image image=img.getImage().getScaledInstance (400, 600, Image. SCALE_DEFAULT);
        ImageIcon img2=new ImageIcon (image);
        l11=new JLabel (img2);
        
        bt1=new JButton ("Submit");
        bt2=new JButton ("close");
        
        bt1.setFont (f) ; 
        bt2. setFont (f) ;
        
        bt1. setBackground (Color. BLACK);
        bt1. setForeground (Color. WHITE); 
        
        bt2.setBackground (Color.BLACK);
        bt2. setForeground (Color. WHITE);
        
        bt1.addActionListener(this);
        bt2.addActionListener (this);




        p1=new JPanel ();
        p1.setLayout (new GridLayout (11, 2, 10,10));
        p1.add (l1);
        p1.add (ch1);
        p1.add (l2);
        p1.add (t1);
        p1.add (l3);
        p1.add (t2);
        p1.add (l4);
        p1.add (t3);
        p1.add (l5);
        p1.add (t4);
        p1.add (l6);
        p1.add (t5) ;
        p1.add (l7);
        p1.add (t6) ;
        p1.add (l8);
        p1.add (t7);
        p1.add (l9);
        p1.add (ch2);
        p1.add (l10);
        p1.add (ch3);
        p1.add (bt1);
        p1.add (bt2) ;


        p2=new JPanel ();
        p2.setLayout (new GridLayout (1, 1, 10, 10) );
        p2.add (l11);
        
        p3=new JPanel ();
        p3. setLayout (new GridLayout (1, 1, 10, 10) );
        p3.add (l12);
        
        setLayout (new BorderLayout (30, 30));
        add (p1, "Center");
        add (p2, "West");
        add (p3, "North");


        ch1.addMouseListener (new MouseAdapter ()
        {
            @Override
            public void mouseClicked (MouseEvent arg0)
            {
                try
                {
                    ConnectionClass obj2=new ConnectionClass () ;
                    String eid2=ch1.getSelectedItem();
                    String q3="select * from employee where eid='"+eid2+"'";
                    ResultSet rest1=obj2.stm.executeQuery(q3) ;
                    while (rest1.next () )
                    {
                     t1.setText (rest1.getString ("name")); 
                     t2.setText (rest1.getString ("email"));
                    }
                }
                catch(Exception exx)
                {
                    exx.printStackTrace();
                }
            }
        });
}


      


    


    public void actionPerformed (ActionEvent e)
    {
        if (e.getSource () ==bt1)
        {
            String Eid=ch1.getSelectedItem();
            String name=t1.getText () ;
            String email=t2.getText ();
            float hra=Float.parseFloat (t3.getText () ) ; 
            float da=Float. parseFloat (t4.getText () ) ; 
            float med=Float. parseFloat (t5.getText () ) ;
            float pf= Float. parseFloat (t6.getText () ) ; 
            float basic=Float.parseFloat (t7.getText () ) ;
            String month=ch2.getSelectedItem ()+" "+ch3.getSelectedItem () ;


            try
            {
                ConnectionClass obj1=new ConnectionClass () ;
                String ql="insert into salary values ('"+0+"','"+Eid+"' ,'"+name+"','"+email+"','"+hra+"','"+da+"','"+med+"','"+pf+"','"+basic+"','"+month+"')";
                int aa=obj1.stm.executeUpdate (ql) ;
                if (aa==1)
                {
                    JOptionPane. showMessageDialog (null, "your data successfully Inserted");
                    this.setVisible (false);
                }
                else
                {
                    JOptionPane. showMessageDialog(null, "Please!, Fill all details carefully");
                    this.setVisible (false);
                    this.setVisible (true);
                }
            }
            catch (Exception exx)
            {
                exx.printStackTrace () ;
            }
        }
    
        if (e.getSource () ==bt2)
                {
                JOptionPane. showMessageDialog (null, "Are you sure?");
                setVisible (false);
                }
    }
                




    
    
        
    public static void main(String[] args)
    {
      new Salary().setVisible (true);   
    }
}




















GENERATE SALARY SLIP






package Employee_Management;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;


public class Generate_PaySlip extends JFrame implements ActionListener
        {
    JButton bt1,bt2;
    JLabel l1, l2, l3, l4, l5, l6;
    JTextArea ta;
    Choice ch1, ch2, ch3;
    JPanel p1;
    Font f;


    Generate_PaySlip ()
    {
        super ("Generate Pay Slip");
        setSize (500,500);
        setLocation (100, 100); 
        setResizable (false);
        f=new Font ("arial", Font. BOLD, 16);
        l1=new JLabel ("Employe Id");
        l2=new JLabel ("Month");
        l3=new JLabel ("Year");
        l1. setFont (f) ;
        l2. setFont (f);
        l3. setFont (f) ;
        ch1=new Choice ();
        ch2=new Choice();
         ch3=new Choice();
        
        


        try
        {
            ConnectionClass obj=new ConnectionClass ();
            String q="select * from employee";
            ResultSet rest=obj.stm.executeQuery (q) ;
            while (rest.next () )
            {
               ch1.add (rest.getString ("Eid"));
            }
        }
            catch (Exception ex)
            {
              ex.printStackTrace () ;
            }


            ch2.add ("January");
            ch2.add ("February");
            ch2.add ("March");
            ch2.add ("April");
            ch2.add ("May");
            ch2.add ("June");
            ch2.add ("July");
            ch2.add ("August");
            ch2.add ("September");
            ch2.add ("October");
            ch2.add ("November");
            ch2.add ("December");
            
            ch3.add ("2015"); 
            ch3.add ("2016");
            
            ch3.add ("2017");
            ch3.add ("2018");
            ch3.add ("2019");
            ch3.add ("2020"); 
            ch3.add ("2021"); 
            ch3.add ("2022");


            
            ch1. setFont (f) ; 
            ch2. setFont (f) ; 
            ch3. setFont (f) ;
            
            bt1=new JButton ("Print");
            bt1.setBackground (Color. BLACK);
            bt1.setForeground (Color. WHITE) ; 
            bt1.addActionListener (this);
            bt1.setFont (f);
            
            bt2=new JButton ("Close");
            bt2.setBackground (Color. BLACK);
            bt2.setForeground (Color. WHITE) ; 
            bt2.addActionListener (this);
            bt2.setFont (f);


            p1=new JPanel ();
            p1. setLayout (new GridLayout (4, 2, 10, 10)) ;
            p1.add (l1);
            p1.add (ch1);
            p1.add (l2);
            p1. add (ch2);
            p1.add (l3);
            p1.add (ch3);
            p1. add (bt1);
            p1.add (bt2);
            
            ta=new JTextArea ();
            JScrollPane sp=new JScrollPane (ta) ;
            ta.setEditable (false);
            ta.setFont (f) ;


            setLayout (new BorderLayout ()) ;
            add (sp, "Center");
            add (p1, "South");
    }
    public void actionPerformed (ActionEvent e)
    {
        if (e.getSource () ==bt1)
        {
            
            ta.setText ("---------pay slip---------");
            try
            {
                ConnectionClass obj1=new ConnectionClass () ;
                String id=ch1.getSelectedItem ();
                String month_year=ch2.getSelectedItem ()+" "+ch3.getSelectedItem ();
                String q1="select * from employee where eid='"+id+"'";
                ResultSet rest1=obj1.stm.executeQuery (q1) ;
                while (rest1.next() )
                {
            
                    ta.append ("\n\nEmployee Id :"+Integer.parseInt (rest1.getString ("Eid")));
                    ta.append ("\nEmployee Name :"+rest1.getString ("name") );
                    ta.append ("\nEmployee Email:"+rest1.getString ("email")) ;
                    ta.append ("\n-------------------------------\n\n");
                }
                String q2="select * from salary where month_year= '"+month_year+"'and Eid='"+id+"'";
                ResultSet rest2=obj1.stm.executeQuery (q2) ;
                
                if(rest2.next () ==false)
                {
                    ta.append ("\n-------------------------\n");
                    ta.append ("Record Not Found of this month and year");
                    ta.append ("\n-------------------------------OR---------------------\n\n");
                    ta.append ("Please add the Salary of this month and year for this record. \n");
                }


                else
                {
                    
                    ta.append ("\n\nHRA : "+Float.parseFloat (rest2.getString ("hra")) ); 
                    ta.append ("\nDA : "+Float.parseFloat (rest2.getString ("da") )); 
                    ta.append ("\nMED : "+Float.parseFloat (rest2.getString ("mid"))); 
                    ta.append ("\nPF : "+Float.parseFloat (rest2.getString ("pf")));
                    ta.append ("\nBASIC SALARY :"+Float.parseFloat (rest2.getString ("basic") ));
                    
                    ta.append ("\n---------------------------\n\n");
                    float gross_salary=Float.parseFloat(rest2.getString("hra"))+Float.parseFloat(rest2.getString("basic"))+Float.parseFloat(rest2.getString("da"));
                     double tax = (gross_salary*2.1)/100;
                    ta.append ("\nGross Salary : "+gross_salary);
                    ta.append ("\nTotal : "+gross_salary);
                    ta.append ("\nTax 2.1% of salary : "+tax);
                }
            }
                catch(Exception exx)
                {
                  exx.printStackTrace ();
                }
            }
            if (e.getSource () ==bt2)
            {
                JOptionPane. showMessageDialog (null, "Are you sure?");
                setVisible(false);
            }
        }
    public static void main(String[] args)
    {
        new Generate_PaySlip().setVisible(true);
    }
            


    }


























DELETE EMPLOYEE






package Employee_Management;
import java.sql. *;
import java.awt.event.  *;
import java.awt.*;
import javax.swing. *; 


public class Delete_Employee extends JFrame implements ActionListener
{
     JTable t;
     JButton bt1;
     JTextField tf1;
     JPanel p1,p2,p3;
     String x[]={"Employee ID","Name","Email","Age","Date of Birth","Post"};
     String y[][]=new String [20] [6];
     int i=0, j=0;
    Font f,f1;
    JLabel l1,l2;


 Delete_Employee () 
     {
           super("All Employee records for delete");
           setSize(1480,400);
           setLocation(0,10);
           f=new Font ("Times New Roman",Font.BOLD,17);
     try 
     {
           ConnectionClass obj=new ConnectionClass () ;
           String q="select * from employee";
           ResultSet rest=obj.stm.executeQuery(q) ;
           while (rest.next())
          {
             y[i][j++]=rest.getString("Eid");
             y[i][j++]=rest.getString("name") ;
             y[i][j++]=rest.getString("email") ;
             y[i][j++]=rest.getString("age") ;
             y[i][j++]=rest.getString("dob") ;
             y[i][j++]=rest.getString("post") ;
            i++;
            j=0;
        }
          t=new JTable(y,x) ;
  }
       catch(Exception ex)
     {
       ex.printStackTrace () ;
     }
        t.setBackground(Color.BLACK) ;
       t.setBackground(Color.WHITE) ;      
       t. setFont (f) ;


     JScrollPane js=new JScrollPane(t) ;
    f1=new Font ("Times New Roman",Font.BOLD,25) ;
 
    l1=new  JLabel ("Delete any employee") ;
    l1.setHorizontalAlignment (JLabel.CENTER) ;
    l1. setFont (f1) ;
    l1. setForeground (Color.YELLOW) ;
  
  l2=new JLabel ("EMPLOYEE ID");
  l2. setFont(f1) ;
  l2. setForeground (Color.WHITE) ;


  tf1=new JTextField( ) ;
  bt1=new JButton("Delete Employee");
tf1 . setFont (f) ;
bt1 . setFont (f) ;


bt1 . setBackground (Color.WHITE) ;
bt1 . setForeground (Color.BLACK) ;
bt1 . addActionListener  (this) ;
 
p1=new JPanel ( );
p1.setLayout (new GridLayout (1,1,10,10 )) ;
p1.add(l1) ;


p2=new JPanel() ;
p2.setLayout (new GridLayout (1,3,10,10) ) ;
p2.add (l2) ;
p2.add (tf1) ;
p2.add (bt1) ;


p3=new JPanel ( ) ;
p3.setLayout (new GridLayout (2,1,10,10) );
p3.add (p1) ;
p3.add (p2) ;


p1.setBackground ( Color.BLACK) ;
p2.setBackground ( Color.BLACK) ;
p3.setBackground ( Color.BLACK) ;


add(p3,"South") ;
add(js) ;
}
public void actionPerformed (ActionEvent e)
{
    if (e. getSource ( ) ==bt1)
{
         String eid=tf1.getText ( ) ;
  
      try 
{
      ConnectionClass obj1=new ConnectionClass ( );
      String q="delete from employee where eid='"+eid+"'" ;
     String q1="delete from apply_leave where Eid='"+eid+"'" ;
     String q2="delete from attendance where Eid='"+eid+"'";
     String q3="delete from salary where Eid='"+eid+"'" ;
    int res=obj1.stm.executeUpdate (q) ;
    
    obj1.stm.executeUpdate (q1) ;
    obj1.stm.executeUpdate (q2) ;
    obj1.stm.executeUpdate (q3) ;
 
  if (res==1)
{ 
  JOptionPane.showMessageDialog(null, "your data successfully Deleted") ;
    obj1.stm.executeUpdate (q1) ;
    obj1.stm.executeUpdate (q2) ;
    obj1.stm.executeUpdate (q3) ;
   this.setVisible(false) ;
   new Delete_Employee( ).setVisible (true) ;
}
else
{
 JOptionPane.showMessageDialog(null,"did not delete sorry!!!!!!");
 this.setVisible (false) ;
 new Delete_Employee ( ).setVisible(true) ;
}


  
  


}
catch (Exception ex)
    {
        ex.printStackTrace ( ) ;
     }
  }
}
public static void main (String[] args  )
 {
   new HomePage ( ). setVisible (true) ;
  }
}






















UPDATE EMPLOYEE




package Employee_Management;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
public class Update_Details_Data extends JFrame implements ActionListener
{
JLabel l1, l2, l3, l4, l5, l6, l7,l8, l9, l10, l11,l12,l13;
JButton bt1,bt2;
JPanel p1,p2,p3;
JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9,tf10;
Font f,f1;
Choice ch;
Update_Details_Data()
{
super("Update Employee");
setLocation (450,50) ;
setSize(950,750);
f=new Font ("Arial", Font. BOLD, 25);
f1=new Font ("Arial",Font. BOLD,18) ;


ch=new Choice();


try
{


ConnectionClass obj=new ConnectionClass();
String q="select  eid from employee";
ResultSet rest=obj.stm.executeQuery(q);
while(rest.next())
{
    ch.add(rest.getString("Eid"));
}
    
}






catch (Exception e)
{
e.printStackTrace () ;
}




l1=new JLabel("Update Employee") ;
l2=new JLabel("Name");
l3=new JLabel("Father's Name");
l4=new JLabel ("Age") ;
l5=new JLabel("Date of birth");
l6=new JLabel ("Address");
l7=new JLabel("Phone");
l8=new JLabel("Email");
l9=new JLabel("Education");
l10=new JLabel("Job Post");
l11=new JLabel("Adhaar");
l12=new JLabel("Employee ID");


tf1=new JTextField();
tf2=new JTextField();
tf3=new JTextField();
tf4=new JTextField();
tf5=new JTextField();
tf6=new JTextField();
tf7=new JTextField();
tf8=new JTextField();
tf9=new JTextField();
tf10=new JTextField();


bt1=new JButton("Update Data");
bt2=new JButton("Back");


l1.setHorizontalAlignment(JLabel.CENTER);


bt1.addActionListener(this);
bt2.addActionListener(this);


l1.setFont(f);
l2.setFont(f1);
l3.setFont(f1);
l4.setFont(f1);
l5.setFont(f1);
l6.setFont(f1);
l7.setFont(f1);
l8.setFont(f1);
l9.setFont(f1);
l10.setFont(f1);
l11.setFont(f1);
l12.setFont(f1);
ch.setFont(f1);






tf1.setFont(f1);
tf2.setFont(f1);
tf3.setFont(f1);
tf4.setFont(f1);
tf5.setFont(f1);
tf6.setFont(f1);
tf7.setFont(f1);
tf8.setFont(f1);
tf9.setFont(f1);
tf10.setFont(f1);


bt1.setFont(f1);
bt2.setFont(f1);


bt1.setBackground (Color. BLACK) ;
bt2.setBackground (Color. RED) ;


bt1.setForeground (Color. WHITE) ;
bt2.setForeground (Color.WHITE) ;


p1=new JPanel();
p1.setLayout(new GridLayout (1,1,10,10)) ;
p1.add(l1);


p2=new JPanel();
p2. setLayout (new GridLayout (12,2,10,10));
p2.add(l12);
p2.add(ch);
p2.add(l2);
p2.add(tf1);
p2.add(l3);
p2.add(tf2);
p2.add(l4);
p2.add(tf3);
p2.add(l5);
p2.add(tf4);
p2.add(l6);
p2.add(tf5);
p2.add(l7);
p2.add(tf6);
p2.add(l8);
p2.add(tf7);
p2.add(l9);
p2.add(tf8);
p2.add(l10);
p2.add(tf9);
p2.add(l11);
p2.add(tf10);
p2.add(bt1);
p2.add(bt2);


p3=new JPanel();
p3.setLayout(new GridLayout(1,1,10,10));


ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("Employee_Management/Icons/emp.png")); //image path may differ i used it directly from the video
        Image img1=img.getImage().getScaledInstance(400, 600, Image.SCALE_DEFAULT);
        ImageIcon ic1=new ImageIcon(img1);
        l13=new JLabel(ic1);


        p3.add(l13);
        
        setLayout(new BorderLayout(10,10));
        add(p1,"North");
        add(p2, "Center");
        add(p3,"West");
        
        ch.addMouseListener (new MouseAdapter()
{
@Override
public void mouseClicked(MouseEvent arg0)
{
try
{
ConnectionClass obj2=new ConnectionClass();
String eid=ch.getSelectedItem();
String q1="select * from employee where eid='"+eid+"'";
ResultSet rest1=obj2.stm.executeQuery(q1);


while(rest1.next())
{
tf1.setText(rest1.getString("name"));
tf2.setText(rest1.getString("fname"));
tf3.setText(rest1.getString("age"));
tf4.setText (rest1.getString("dob"));
tf5. setText (rest1.getString("address"));
tf6.setText(rest1.getString("phone"));
tf7.setText(rest1.getString("email"));
tf8.setText (rest1.getString("education"));
tf9.setText(rest1.getString("post"));
tf10.setText(rest1.getString("adhaar"));
}


}
catch(Exception exx)
{
    exx.printStackTrace();
}
}      
});
}
public void actionPerformed(ActionEvent e)
{
String eid=ch.getSelectedItem();
String name=tf1.getText();
String fname=tf2.getText();
String age=tf3.getText();
String dob=tf4.getText();
String address=tf5.getText();
String phone=tf6.getText();
String email=tf7.getText();
String education=tf8.getText();
String post=tf9.getText();
String adhaar=tf10.getText();


if(e.getSource()==bt1)
{
try
{
ConnectionClass obj3=new ConnectionClass();
String q1="update employee set name='"+name+"' , fname='"+fname+"' , age='"+age+"' , dob='"+dob+"' ,address='"+address+"',phone='"+phone+"',email='"+email+"',education='"+education+"',post='"+post+"',adhaar='"+adhaar+"' where eid='"+eid+"'";
int aa=obj3.stm.executeUpdate(q1);
if(aa==1)
{
JOptionPane.showMessageDialog(null, "your data successfully updated");
this.setVisible(false);
new Update_Details_Data();
}


else
{
   JOptionPane.showMessageDialog(null, "Please, Fill all details carefully"); 
}
}
catch(Exception ee)
{
    ee.printStackTrace();
    
}
}
if(e.getSource()==bt2)
{
    this.setVisible(false);
}
}
public static void main(String[] args)
{
   new  Update_Details_Data().setVisible(true);
}
}