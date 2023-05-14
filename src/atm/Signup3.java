package atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.*;

public class Signup3 extends JFrame implements ActionListener {

	JLabel a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12;
	JRadioButton r1, r2, r3, r4;
	JCheckBox c1, c2, c3, c4, c5, c6, c7;
	ButtonGroup s1, s2;
	JButton b1, b2;
	String formno;

	Signup3(String formno) {

		this.formno = formno;
		setTitle("ACCOUNT DETAILS");
		setSize(800, 800);
		setLocation(400, 15);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);

		a1 = new JLabel("PAGE-3/3");
		a1.setFont(new Font("Osward", Font.BOLD, 10));
		a1.setBounds(50, 10, 400, 40);
		add(a1);

		a2 = new JLabel("ACCOUNT DETAILS");
		a2.setFont(new Font("Osward", Font.BOLD, 25));
		a2.setBounds(260, 40, 400, 40);
		add(a2);

		a3 = new JLabel("Account Type");
		a3.setFont(new Font("Raleway", Font.BOLD, 20));
		a3.setBounds(100, 100, 150, 30);
		add(a3);

		r1 = new JRadioButton("Saving Account");
		r1.setBounds(120, 130, 150, 40);
		r1.setFont(new Font("Arial", Font.PLAIN, 16));
		r1.setBackground(Color.WHITE);
		add(r1);

		r2 = new JRadioButton("Fixed Deposit Account");
		r2.setBounds(320, 130, 200, 40);
		r2.setFont(new Font("Arial", Font.PLAIN, 16));
		r2.setBackground(Color.WHITE);
		add(r2);

		r3 = new JRadioButton("Current Account");
		r3.setBounds(120, 170, 150, 40);
		r3.setFont(new Font("Arial", Font.PLAIN, 16));
		r3.setBackground(Color.WHITE);
		add(r3);

		r4 = new JRadioButton("Recuring Deposit Account");
		r4.setBounds(320, 170, 210, 40);
		r4.setFont(new Font("Arial", Font.PLAIN, 16));
		r4.setBackground(Color.WHITE);
		add(r4);

		s1 = new ButtonGroup();
		s1.add(r1);
		s1.add(r2);
		s1.add(r3);
		s1.add(r4);

		a3 = new JLabel("Card Number");
		a3.setFont(new Font("Raleway", Font.BOLD, 20));
		a3.setBounds(100, 240, 150, 40);
		add(a3);

		a4 = new JLabel("(16-Digit card no.)");
		a4.setFont(new Font("Raleway", Font.BOLD, 12));
		a4.setBounds(100, 260, 150, 40);
		add(a4);

		a5 = new JLabel("XXXX-XXXX-XXXX-4814");
		a5.setFont(new Font("Raleway", Font.PLAIN, 20));
		a5.setBounds(310, 240, 250, 40);
		add(a5);

		a6 = new JLabel("PIN");
		a6.setFont(new Font("Raleway", Font.BOLD, 20));
		a6.setBounds(100, 320, 150, 40);
		add(a6);

		a7 = new JLabel("(4-Digit card no.)");
		a7.setFont(new Font("Raleway", Font.BOLD, 12));
		a7.setBounds(100, 340, 150, 40);
		add(a7);

		a8 = new JLabel("XXXX");
		a8.setFont(new Font("Raleway", Font.PLAIN, 20));
		a8.setBounds(310, 320, 250, 40);
		add(a8);

		a9 = new JLabel("Services Required");
		a9.setFont(new Font("Raleway", Font.BOLD, 20));
		a9.setBounds(100, 400, 200, 40);
		add(a9);

		c1 = new JCheckBox("ATM Required");
		c1.setBounds(120, 440, 200, 30);
		c1.setFont(new Font("Arial", Font.PLAIN, 16));
		c1.setBackground(Color.WHITE);
		add(c1);

		c2 = new JCheckBox("Internet Banking");
		c2.setBounds(320, 440, 200, 30);
		c2.setFont(new Font("Arial", Font.PLAIN, 16));
		c2.setBackground(Color.WHITE);
		add(c2);

		c3 = new JCheckBox("Mobile Banking");
		c3.setBounds(120, 470, 200, 30);
		c3.setFont(new Font("Arial", Font.PLAIN, 16));
		c3.setBackground(Color.WHITE);
		add(c3);

		c4 = new JCheckBox("Email & SMS Alerts");
		c4.setBounds(320, 470, 200, 30);
		c4.setFont(new Font("Arial", Font.PLAIN, 16));
		c4.setBackground(Color.WHITE);
		add(c4);

		c5 = new JCheckBox("Cheque Book");
		c5.setBounds(120, 500, 200, 30);
		c5.setFont(new Font("Arial", Font.PLAIN, 16));
		c5.setBackground(Color.WHITE);
		add(c5);

		c6 = new JCheckBox("E-Statement");
		c6.setBounds(320, 500, 200, 30);
		c6.setFont(new Font("Arial", Font.PLAIN, 16));
		c6.setBackground(Color.WHITE);
		add(c6);

		c7 = new JCheckBox("I hereby declared that the above entered details are correct.");
		c7.setBounds(100, 600, 500, 40);
		c7.setFont(new Font("Arial", Font.PLAIN, 16));
		c7.setBackground(Color.WHITE);
		add(c7);

		b1 = new JButton("SUBMIT");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setFont(new Font("Sans Serif", Font.BOLD, 15));
		b1.setBounds(500, 650, 100, 40);
		add(b1);

		b2 = new JButton("CANCEL");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setFont(new Font("Sans Serif", Font.BOLD, 15));
		b2.setBounds(620, 650, 100, 40);
		add(b2);

		b1.addActionListener(this);
		b2.addActionListener(this);

		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {

		if (ae.getSource() == b1) {
			String atype = null;

			if (r1.isSelected()) {
				atype = "Saving Account";
			} else if (r2.isSelected()) {
				atype = "Fixed Deposit Account";
			} else if (r3.isSelected()) {
				atype = "Current Account";
			} else if (r4.isSelected()) {
				atype = "Recurring Deposit Account";
			}

			Random ran = new Random();
			String cardno = "" + Math.abs((ran.nextLong() % 90000000L) + 5040000000000000L);
			String pin = "" + Math.abs((ran.nextLong() % 9000L) + 1000L);

			String services = "";
			if (c1.isSelected()) {
				services = services + " ATM Card";
			}
			if (c2.isSelected()) {
				services = services + " Internet Banking";
			}
			if (c3.isSelected()) {
				services = services + " Mobile Banking";
			}
			if (c4.isSelected()) {
				services = services + " EMAIL Alerts";
			}
			if (c5.isSelected()) {
				services = services + " Cheque Book";
			}
			if (c6.isSelected()) {
				services = services + " E-Statement";
			}

			try {

				if (!r1.isSelected() && !r2.isSelected() && !r3.isSelected() && !r4.isSelected()
						|| !c1.isSelected() && !c2.isSelected() && !c3.isSelected() && !c4.isSelected()
								&& !c5.isSelected() && !c6.isSelected())

				{
					JOptionPane.showMessageDialog(null, "Please fill all the required fields.");
					return;

				}

				else {

					Conn c = new Conn();
					String query1 = "insert into signup3 values('" + formno + "', '" + atype + "','" + cardno + "','"
							+ pin + "','" + services + "')";
					String query2 = "insert into login values('" + formno + "','" + cardno + "','" + pin + "')";
					c.s.executeUpdate(query1); // DML Command
					c.s.executeUpdate(query2);

					JOptionPane.showMessageDialog(null, "Card Number: " + cardno + "\n Pin:" + pin);
				    
					setVisible(false);
					new Deposit1(pin).setVisible(true);
				}

			} catch (Exception e) {
				System.out.println(e);
			}

		} else if (ae.getSource() == b2) {
			setVisible(false);
			new Login().setVisible(true);
		}
	}

	public static void main(String[] args) {
		new Signup3("").setVisible(true);
		;
	}

}
