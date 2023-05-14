package atm;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Transactions extends JFrame implements ActionListener {

	JLabel l1;
	JButton b1, b2, b3, b4, b5, b6, b7;
	String pin;

	Transactions(String pin) {

		this.pin = pin;
		l1 = new JLabel("Please Select Your Transaction");
		l1.setFont(new Font("System", Font.BOLD, 16));
		l1.setBounds(120, 50, 700, 25);
		add(l1);

		b1 = new JButton("DEPOSIT");
		b1.setBounds(70, 100, 150, 35);
		add(b1);

		b2 = new JButton("CASH WITHDRAWL");
		b2.setBounds(270, 100, 150, 35);
		add(b2);

		b3 = new JButton("FAST CASH");
		b3.setBounds(70, 150, 150, 35);
		add(b3);

		b4 = new JButton("MINI STATEMENT");
		b4.setBounds(270, 150, 150, 35);
		add(b4);

		b5 = new JButton("PIN CHANGE");
		b5.setBounds(70, 200, 150, 35);
		add(b5);

		b6 = new JButton("BALANCE ENQUIRY");
		b6.setBounds(270, 200, 150, 35);
		add(b6);

		b7 = new JButton("EXIT");
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

		if (ae.getSource() == b1) {
			setVisible(false);
			new Deposit1(pin).setVisible(true);
		} 
		else if (ae.getSource() == b2) {
			setVisible(false);
			new Withdrawal(pin).setVisible(true);
		}
		else if (ae.getSource() == b3) {
			 setVisible(false); 
			 new Fastcash(pin).setVisible(true);
		}
		else if (ae.getSource() == b4) {			 
			 setVisible(false); 
			 new Ministatement(pin).setVisible(true);    
		}
	    else if (ae.getSource() == b5) {
			 setVisible(false); 
			 new Pinchange(pin).setVisible(true);
		}
	    else if (ae.getSource() == b6) {
			 setVisible(false); 
			 new Balanceenquiry(pin).setVisible(true);    
		} 
	    else if (ae.getSource() == b7) {
	    	System.exit(0);
	    }
		
	}
	public static void main(String[] args) {
		new Transactions("").setVisible(true);
	}
}
