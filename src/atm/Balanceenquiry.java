package atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.*;

public class Balanceenquiry extends JFrame implements ActionListener {

	JLabel l1;
	JButton b1;
	String pin;

	Balanceenquiry(String pin) {

		this.pin = pin;
		b1 = new JButton("BACK");
		b1.setBounds(300, 300, 100, 30);
		add(b1);

		Conn c = new Conn();
		int balance = 0;
		try {
			ResultSet rs = c.s.executeQuery("select * from bank where pin = '" + pin + "'");

			while (rs.next()) {
				if (rs.getString("type").equals("Deposit")) {
					balance += Integer.parseInt(rs.getString("amount"));
				} else {
					balance -= Integer.parseInt(rs.getString("amount"));
				}
			}

		} catch (Exception e) {
			System.out.println(e);
		}

		l1 = new JLabel("Your current Account Balance is Rs:" +balance);
		l1.setBounds(50, 50, 350, 30);
		l1.setFont(new Font("Osward", Font.BOLD, 15));
		add(l1);

		setSize(500, 400);
		setLocation(500, 200);
		setLayout(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Balanceenquiry("").setVisible(true);

	}

	public void actionPerformed(ActionEvent ae) {
      
		if(ae.getSource() == b1);{
		setVisible(false);
		new Transactions(pin).setVisible(true);
		}

	}

}
