
package bank.management.system;
import javax.swing.*;
import java.awt.*;
//import java.util.*;
import java.awt.event.*;
//import com.toedter.calendar.JDateChooser;
public class SignupTwo extends JFrame implements ActionListener{
    JButton next;
    
    JTextField  aadhar,pan;
    JRadioButton syss,sno,eyss,eno;
    //JDateChooser dateChooser;
    JComboBox religion1,catagory,income,education,occupation;
    String formno;
    SignupTwo(String formno){
        this.formno=formno;
        setLayout(null);
        //Random ran=new Random();
        //random=Math.abs((ran.nextLong() % 9000L)+1000L);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE:2");
        //JLabel formno=new JLabel("APPLICATION FORM NUMBER:"+ random);
        //formno.setFont(new Font("Raleway",Font.BOLD,30));
        //formno.setBounds(140,20,600,40);
        //add(formno);
        
        JLabel personalDetails=new JLabel("Page 2: Additional details");
        personalDetails.setFont(new Font("Raleway",Font.BOLD,30));
        personalDetails.setBounds(210,80,500,30);
        add(personalDetails);
        
        
        JLabel religion=new JLabel("Religion:");
        religion.setFont(new Font("Raleway",Font.BOLD,20));
        religion.setBounds(100,140,100,30);
        add(religion);
        String valReligion[]={"Null", "Hindu","Muslim","Christian","Others"};
        religion1=new JComboBox(valReligion);
        religion1.setBounds(300,140,400,30);
        religion1.setBackground(Color.WHITE);
        add(religion1);
        
        
        
        
        JLabel fname=new JLabel("Catagory:");
        fname.setFont(new Font("Raleway",Font.BOLD,20));
        fname.setBounds(100,190,400,30);
        add(fname);
        String valCatagory[]={"Null","General","OBC-A","OBC-B","SC","ST"};
        catagory=new JComboBox(valCatagory);
        catagory.setBounds(300,190,400,30);
        catagory.setBackground(Color.WHITE);
        catagory.setFont(new Font("Raleway",Font.BOLD,14));
        
        add(catagory);
        
       
        
        
        JLabel dob=new JLabel("Income:");
        dob.setFont(new Font("Raleway",Font.BOLD,20));
        dob.setBounds(100,240,400,30);
        add(dob);
        
        String valIncome[]={"Null","<1,50,00","<2,50,000","<5,00,000","Upto 10,00,000"};
        income=new JComboBox(valIncome);
        income.setBounds(300,240,200,30);
        income.setBackground(Color.WHITE);
        income.setFont(new Font("Raleway",Font.BOLD,14));
        add(income);
         
        
        JLabel gender=new JLabel("Educational");
        gender.setFont(new Font("Raleway",Font.BOLD,20));
        gender.setBounds(100,290,200,30);
        add(gender);
        
        String valEducation[]={"non graduate","graduate","post-graduate","doctorate","Others"};
        education=new JComboBox(valEducation);
        education.setBounds(300,315,200,30);
        education.setBackground(Color.WHITE);
        education.setFont(new Font("Raleway",Font.BOLD,14));
        add(education);
    
        
        
        JLabel email=new JLabel("Qualification:");
        email.setFont(new Font("Raleway",Font.BOLD,20));
        email.setBounds(100,310,200,30);
        add(email);
        //emailTextField=new JTextField();
        //emailTextField.setFont(new Font("Raleway",Font.BOLD ,14));
        //emailTextField.setBounds(300,315,400,30);
        //add(emailTextField);
        
        JLabel marital=new JLabel("Occupation:");
        marital.setFont(new Font("Raleway",Font.BOLD,20));
        marital.setBounds(100,390,400,30);
        add(marital);
        String occupationValues[]={"salaried","self-employed","business","student","retired","Others"};
        occupation=new JComboBox(occupationValues);
        occupation.setBounds(300,390,200,30);
        occupation.setBackground(Color.WHITE);
        occupation.setFont(new Font("Raleway",Font.BOLD,14));
        add(occupation);
        
        
        
        JLabel address=new JLabel("PAN number:");
        address.setFont(new Font("Raleway",Font.BOLD,20));
        address.setBounds(100,440,400,30);
        add(address);
        
        pan=new JTextField();
        pan.setFont(new Font("Raleway",Font.BOLD ,14));
        pan.setBounds(300,440,400,30);
        add(pan);
        
        JLabel city=new JLabel("Aadhar number:");
        city.setFont(new Font("Raleway",Font.BOLD,20));
        city.setBounds(100,490,400,30);
        add(city);
        
        aadhar=new JTextField();
        aadhar.setFont(new Font("Raleway",Font.BOLD ,14));
        aadhar.setBounds(300,490,400,30);
        add(aadhar);
        
        
        JLabel state=new JLabel("Senior citizen:");
        state.setFont(new Font("Raleway",Font.BOLD,20));
        state.setBounds(100,540,400,30);
        add(state);
        syss=new JRadioButton("Yes");
        syss.setBounds(300,540,100,30);
        syss.setBackground(Color.WHITE);
        add(syss);
        sno=new JRadioButton("no");
        sno.setBounds(450,540,100,30);
        sno.setBackground(Color.WHITE);
        add(sno);
        ButtonGroup maritalGroup=new ButtonGroup();
        maritalGroup.add(syss);
        maritalGroup.add(sno);
        
        
        
        //stateTextField=new JTextField();
        //stateTextField.setFont(new Font("Raleway",Font.BOLD ,14));
        //stateTextField.setBounds(300,540,400,30);
        //add(stateTextField);
        
        
        JLabel pincode=new JLabel("Existing account:");
        pincode.setFont(new Font("Raleway",Font.BOLD,20));
        pincode.setBounds(100,590,400,30);
        add(pincode);
        
        eyss=new JRadioButton("Yes");
        eyss.setBounds(300,590,100,30);
        syss.setBackground(Color.WHITE);
        add(eyss);
        eno=new JRadioButton("no");
        eno.setBounds(450,590,100,30);
        eno.setBackground(Color.WHITE);
        add(eno);
        ButtonGroup maritalGroup1=new ButtonGroup();
        maritalGroup1.add(eyss);
        maritalGroup1.add(eno);
        
        next = new JButton("NEXT");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway", Font.BOLD,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);
        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        
        String religion=(String)religion1.getSelectedItem();
        String scatagory= (String)catagory.getSelectedItem();
        String sincome=(String)income.getSelectedItem();
        String seducation=(String)education.getSelectedItem();
        String soccupation=(String)occupation.getSelectedItem();
        String seniorcitizen=null;
        if(syss.isSelected()){
            seniorcitizen="Yes";
        }
        else if(sno.isSelected()){
            seniorcitizen="no";
        }
        
        String existingaccount=null;
        if(eyss.isSelected()){
            existingaccount="yes";
        }else if(eno.isSelected()){
            existingaccount="no";
        }
       
        String span=pan.getText();
        String saadhar=aadhar.getText();
        
        try{
           
                Conn c= new Conn();
                String query = "insert into signup2 values('"+formno +"','"+religion+"','"+scatagory+"','"+seducation+"','"+sincome+"','"+soccupation+"','"+span+"','"+saadhar+"','"+seniorcitizen+"','"+existingaccount+"')";

                c.s.executeUpdate(query);
                setVisible(false);
                new SignupThree(formno).setVisible(true);

        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public static void main(String args[]){
        new SignupTwo("");
    }
}