
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener {
    JButton login,signup,clear;
    JPasswordField pinTextField;
    JTextField cardTextField;
    Login(){
        setTitle("AUTOMATED  TELLER MACHINE");
        setLayout(null);
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/LOGO.jpg"));
        Image i2=i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel label= new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);
        
        
        JLabel text =new JLabel("welcome to ATM");
        text.setFont(new Font("osward",Font.BOLD,28));
        text.setBounds(200, 40, 400, 40);
        add(text);
        

        //CARD NUMBER*****************************************************
        JLabel cardno =new JLabel("Card No.");
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
        cardno.setBounds(120,150,150,30 );
        add(cardno);
        cardTextField=new JTextField();
        cardTextField.setBounds(300,150,230,30);
        cardno.setFont(new Font("Ariel",Font.BOLD,14));
        add(cardTextField);
        

        //PIN NUMBER*******************************************************
        JLabel pin =new JLabel("PIN");
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        pin.setBounds(120, 220, 250, 30);
        pin.setFont(new Font("Ariel",Font.BOLD,14));
        add(pin);
        pinTextField=new JPasswordField();
        pinTextField.setBounds(300,220,230,30);
        add(pinTextField);
        
        //BUTTONS**********************************************************
        login=new JButton("LOGIN");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
        
        clear=new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        
        signup=new JButton("SIGNUP");
        signup.setBounds(300,350,230,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
        getContentPane().setBackground(Color.WHITE);
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==clear){
            cardTextField.setText("");
            pinTextField.setText("");
        }else if(ae.getSource()==login){
          Conn conn=new Conn();
          String cardnumber=cardTextField.getText();
          String pinnumber=pinTextField.getText();
          String query = "SELECT * FROM login WHERE cardnumber='" + cardnumber + "' AND pin='" + pinnumber + "'";
          try{
              ResultSet rn=conn.s.executeQuery(query);
              if(rn.next()){
                 setVisible(false);
                 new Transaction(pinnumber).setVisible(true);
              }
              else{
                 JOptionPane. showMessageDialog(null,"Incorrect card number");
              }
          }catch(Exception e){
              System.out.println(e);
          }
        }else if(ae.getSource()==signup){
            setVisible(false);
            new SignupOne().setVisible(true);
        }
    }
    public static void main(String args[]){
        new Login();
    }
}
