
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
public class SignupThree extends JFrame implements ActionListener {
    JRadioButton r1,r2,r3,r4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit, cancel;
    String formno;
    SignupThree(String formno){
        this.formno=formno;
        setLayout(null);
        JLabel l1=new JLabel("Page 3: Account details");
        l1.setFont(new Font("Raleway",Font.BOLD,22));
        l1.setBounds(280,40,400,40);
        add(l1);
        
        JLabel type=new JLabel("Account Type");
        type.setFont(new Font("Raleways",Font.BOLD,22));
        type.setBounds(100,140,200,30);
        add(type);
        
        r1=new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleways",Font.BOLD,16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100,180,250,20);
        add(r1);
        
        r2=new JRadioButton("Fixed Account");
        r2.setFont(new Font("Raleways",Font.BOLD,16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350,180,250,20);
        add(r2);
        
        r3=new JRadioButton("Current Account");
        r3.setFont(new Font("Raleways",Font.BOLD,16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100,220,250,20);
        add(r3);
        
        
        r4=new JRadioButton("Recurring Deposit account");
        r4.setFont(new Font("Raleways",Font.BOLD,16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350,220,250,20);
        add(r4); 
        ButtonGroup groupAcc= new ButtonGroup();
        groupAcc.add(r1);
        groupAcc.add(r2);
        groupAcc.add(r3);
        groupAcc.add(r4);
        
        
        JLabel card=new JLabel("Card Number");
        card.setFont(new Font("Raleways",Font.BOLD,22));
        card.setBounds(100,300,200,30);
        add(card);
        
        JLabel Cnumber=new JLabel("xxxx-xxxx-xxxx-4184");
        Cnumber.setFont(new Font("Raleways",Font.BOLD,22));
        Cnumber.setBounds(330,300,300,30);
        add(Cnumber);
        
        
        JLabel carddetails=new JLabel("This is Your 16 digit Card Number");
        carddetails.setFont(new Font("Raleways",Font.BOLD,12));
        carddetails.setBounds(100,330,300,30);
        add(carddetails);
        
        JLabel pin=new JLabel("Pin Number");
        pin.setFont(new Font("Raleways",Font.BOLD,22));
        pin.setBounds(100,370,200,30);
        add(pin);
        
        JLabel Pnumber=new JLabel("xxxx");
        Pnumber.setFont(new Font("Raleways",Font.BOLD,22));
        Pnumber.setBounds(330,370,300,30);
        add(Pnumber);
        
        JLabel pinDetails=new JLabel("Your 4 digt pin");
        pinDetails.setFont(new Font("Raleways",Font.BOLD,12));
        pinDetails.setBounds(100,400,300,30);
        add(pinDetails);
        
        JLabel service=new JLabel("Services required");
        service.setFont(new Font("Raleways",Font.BOLD,22));
        service.setBounds(100,450,200,30);
        add(service);
        c1=new JCheckBox("ATM CARD");
        c1.setBackground(Color.WHITE);
        c1.setFont(new Font("Raleways",Font.BOLD,16));
        c1.setBounds(100,500,200,30);
        add(c1);
        c2=new JCheckBox("Internet Banking");
        c2.setBackground(Color.WHITE);
        c2.setFont(new Font("Raleways",Font.BOLD,16));
        c2.setBounds(350,500,200,30);
        add(c2);
        c3=new JCheckBox("Mobile Banking");
        c3.setBackground(Color.WHITE);
        c3.setFont(new Font("Raleways",Font.BOLD,16));
        c3.setBounds(100,550,200,30);
        add(c3);
        c4=new JCheckBox("Email/SMS alerts");
        c4.setBackground(Color.WHITE);
        c4.setFont(new Font("Raleways",Font.BOLD,16));
        c4.setBounds(350,550,200,30);
        add(c4);
        c5=new JCheckBox("Check Book");
        c5.setBackground(Color.WHITE);
        c5.setFont(new Font("Raleways",Font.BOLD,16));
        c5.setBounds(100,600,200,30);
        add(c5);
        c6=new JCheckBox("E-Statement");
        c6.setBackground(Color.WHITE);
        c6.setFont(new Font("Raleways",Font.BOLD,16));
        c6.setBounds(350,600,200,30);
        add(c6);
        c7=new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge");
        c7.setBackground(Color.WHITE);
        c7.setFont(new Font("Raleways",Font.BOLD,16));
        c7.setBounds(100,640,900,30);
        add(c7);
        submit=new JButton("Submit");
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setFont(new Font("Raleways",Font.BOLD,14));
        submit.setBounds(250,720,100,30);
        submit.addActionListener(this);
        add(submit);
        cancel=new JButton("Cancel");
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font("Raleways",Font.BOLD,14));
        cancel.setBounds(420,720,100,30);
        cancel.addActionListener(this);
        add(cancel);
        getContentPane().setBackground(Color.WHITE);
        setSize(850,820);
        setLocation(350,0);
        setVisible(true);
        
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==submit){
            String accountType=null;
            if(r1.isSelected()){
                accountType="Saving account";
            }
            else if(r2.isSelected()){
                accountType="Fixed deposit account";
            }
            else if(r3.isSelected()){
                accountType="Current account";
            }
            else if(r4.isSelected()){
                accountType="Recurring Deposit account";
            }
            Random random=new Random();
            String cardnumber=" "+ Math.abs((random.nextLong()%90000000L) +5040936000000000L);
            String pinnumber=" "+ Math.abs((random.nextLong()%9000L )+1000L);
            String facility="";
            if(c1.isSelected()){
                facility=facility+ " ATM Card";
            }else if(c2.isSelected()){
                facility=facility+ " Internet Banking";
            }else if(c3.isSelected()){
                facility=facility+ " Mobile Banking";
            }
            else if(c4.isSelected()){
                facility=facility+ " Email/SMS alert";
            }
            else if(c5.isSelected()){
                facility=facility + " Check Book";
            }else if(c6.isSelected()){
                facility=facility + " Statemnet";
            }
            try{
                if(accountType.equals("")){
                    JOptionPane.showMessageDialog(null,"Account Type is required");
                }else{
                    Conn conn=new Conn();
                    String query1 =  "insert into signupthree values('"+formno+"','"+accountType+"','"+cardnumber+"','"+pinnumber+"','"+facility+"')";
                    String query2 =  "insert into login values('"+formno+"','"+cardnumber+"','"+pinnumber+"')";
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);
                    JOptionPane.showMessageDialog(null,"Card Number"+cardnumber+"\n Pin:"+pinnumber);
                }
            }catch(Exception e){
                System.out.println(e);
            }
            
        }else if(ae.getSource()==cancel){
            
        }
    }
    public static void main(String rgs[]){
        new SignupThree("");
    }
    
}
