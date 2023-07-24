package bank.management.system;
import java.awt.Color;
import java.sql.ResultSet;
import javax.swing.*;

public class MiniStatement extends JFrame {

    MiniStatement(String pinnumber) {
        setLayout(null);

        JLabel mini = new JLabel("Your Mini Statement Here"); 
        mini.setBounds(150, 50, 200, 20); 
        add(mini);

        JLabel bank = new JLabel("SBI Bank");
        bank.setBounds(150, 20, 100, 20);
        add(bank);

        JLabel card = new JLabel("Card Information");
        card.setBounds(20, 80, 300, 20);
        add(card);
        
        JLabel balance = new JLabel();
        balance.setBounds(20, 400, 300, 20);
        add(balance);

        try {
            Conn conn = new Conn();
            ResultSet rs = conn.s.executeQuery("select * from bank where pin='" + pinnumber + "'");
            while(rs.next()){
               card.setText("Card number: " + rs.getString("cardnumber").substring(0, 4) + "XXXXXXXX" + rs.getString("cardnumber").substring(12));

            }
        } catch (Exception e) {
            System.out.println(e);
        }
        try {
            Conn conn = new Conn();
            int bal=0;
            ResultSet rs = conn.s.executeQuery("select * from bank where pin='" + pinnumber + "'");
            while(rs.next()){
              mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + rs.getString("amount")+"<br><br><html>");
              if(rs.getString("type").equals("Deposit"))
                    {
                        bal+=Integer.parseInt(rs.getString("amount"));
                    }else{
                        bal-=Integer.parseInt(rs.getString("amount"));
                    }

            }balance.setText("Your current account balance is Rs"+bal);
        } catch (Exception e) {
            System.out.println(e);
        }
        mini.setBounds(20,140,400,200);
        setTitle("Mini Statement");
        setSize(400, 600);
        setLocation(20, 20);
        getContentPane().setBackground(Color.red);
    }

    public static void main(String args[]) {
        new MiniStatement(""); // Replace "your_pin_number_here" with the actual PIN number
    }
}

