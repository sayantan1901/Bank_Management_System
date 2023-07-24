package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Pinchange extends JFrame implements ActionListener {
    JButton change, back;
    JPasswordField pin, repin;
    String pinnumber;
    Pinchange(String pinnumber) {
        this.pinnumber=pinnumber;
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);
        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setForeground(Color.red);
        text.setFont(new Font("Raleways", Font.CENTER_BASELINE, 16));
        text.setBounds(250, 280, 500, 35);
        image.add(text);

        JLabel pintext = new JLabel("NEW PIN:");
        pintext.setForeground(Color.red);
        pintext.setFont(new Font("Raleways", Font.CENTER_BASELINE, 16));
        pintext.setBounds(165, 320, 180, 25);
        image.add(pintext);

        pin = new JPasswordField();
        pin.setFont(new Font("Raleways", Font.BOLD, 25));
        pin.setBounds(330, 320, 180, 25);
        image.add(pin);

        JLabel repintext = new JLabel("RE-ENTER NEW PIN");
        repintext.setForeground(Color.red);
        repintext.setFont(new Font("Raleways", Font.CENTER_BASELINE, 16));
        repintext.setBounds(165, 360, 180, 25);
        image.add(repintext);

        repin = new JPasswordField();
        repin.setFont(new Font("Raleways", Font.BOLD, 25));
        repin.setBounds(330, 360, 180, 25);
        image.add(repin);

        change = new JButton("CHANGE");
        change.setBounds(305, 410, 150, 30);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("BACK");
        back.setBounds(305, 460, 150, 30);
        back.addActionListener(this);
        image.add(back);

        setSize(900, 900);
        setLocation(300, 0);
    }

    @Override
 public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==change){
            try {
                String npin = pin.getText();
                String rpin = repin.getText();

                // Add your code to handle pin change logic here
                if (npin.equals(rpin)) {
                    // The entered new PINs match, proceed with updating the PIN in the database or data store
                    // Implement your logic here
                    JOptionPane.showMessageDialog(this, "PIN changed successfully!");
                    return;
                }
                if(npin.equals("")) { // Added parentheses
                    JOptionPane.showMessageDialog(this, "PINs do not match. Please try again.");
                    return;
                }
                if(rpin.equals("")) { // Added parentheses
                    JOptionPane.showMessageDialog(this, "PLEASE re-enter new PIN");
                    return;
                }
                Conn conn=new Conn();
                String query1="update bank set pin='"+rpin+"'where pin'"+pinnumber+"'";
                String query2="update login set pin='"+rpin+"'where pin'"+pinnumber+"'";
                String query3="update signupThree set pin='"+rpin+"'where pin'"+pinnumber+"'";
                conn.s.executeUpdate(query1);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);
                JOptionPane.showMessageDialog(this, "PIN changed successfully");
                setVisible(false);
                new Transaction(pinnumber).setVisible(true);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        } else {
            setVisible(false);
            new Transaction(pin.getText()).setVisible(true); // Corrected the variable name
        }
    }

    public static void main(String args[]) {
        new Pinchange("").setVisible(true);
    }
}