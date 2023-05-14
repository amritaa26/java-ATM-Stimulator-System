package atm;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;
import javax.swing.*;


public class Fastcash extends JFrame implements ActionListener{
	JLabel l1;
	JButton b1, b2, b3, b4, b5, b6, b7;
	String pin;

	Fastcash(String pin) {

		this.pin = pin;
		l1 = new JLabel("Select Withdrawal Amount");
		l1.setFont(new Font("System", Font.BOLD, 16));
		l1.setBounds(120, 50, 700, 25);
		add(l1);

		b1 = new JButton("Rs. 100");
		b1.setBounds(70, 100, 150, 35);
		add(b1);

		b2 = new JButton("Rs. 500");
		b2.setBounds(270, 100, 150, 35);
		add(b2);

		b3 = new JButton("Rs. 1000");
		b3.setBounds(70, 150, 150, 35);
		add(b3);

		b4 = new JButton("Rs. 2000");
		b4.setBounds(270, 150, 150, 35);
		add(b4);

		b5 = new JButton("Rs. 5000");
		b5.setBounds(70, 200, 150, 35);
		add(b5);

		b6 = new JButton("Rs. 10000");
		b6.setBounds(270, 200, 150, 35);
		add(b6);

		b7 = new JButton("BACK");
		b7.setBounds(170, 250, 150, 35);
		add(b7);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);

		setSize(500, 400);
		setLocation(500, 150);
		setLayout(null);
		setVisible(true);

	}

	public void actionPerformed(ActionEvent ae) {
		try {
            String amount = ((JButton)ae.getSource()).getText().substring(4); //k
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from bank where pin = '"+pin+"'");
            int balance = 0;
            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            } if (ae.getSource() != b7 && balance < Integer.parseInt(amount)) {
                JOptionPane.showMessageDialog(null, "Insuffient Balance");
                return;
            }

            if (ae.getSource() == b7) {
                this.setVisible(false);
                new Transactions(pin).setVisible(true);
            }else{
                Date date = new Date();
                c.s.executeUpdate("insert into bank values('"+pin+"', '"+date+"', 'Withdrawl', '"+amount+"')");
                JOptionPane.showMessageDialog(null, "Rs. "+amount+" Debited Successfully");
                    
                setVisible(false);
                new Transactions(pin).setVisible(true);
            }
        } catch (Exception e) {
        	System.out.println(e);
        }
	}
	public static void main(String[] args) {
		new Fastcash("").setVisible(true);
	}
}

