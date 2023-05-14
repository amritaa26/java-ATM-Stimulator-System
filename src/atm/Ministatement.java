package atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Ministatement extends JFrame implements ActionListener {

	JButton b1;
	JLabel bank, mini, card, balance;
	String pin;

	Ministatement(String pin) {
		this.pin = pin;

		bank = new JLabel("Indian Bank");
		bank.setBounds(180, 30, 150, 40);
		bank.setFont(new Font("Osward", Font.BOLD, 20));
		add(bank);

		card = new JLabel("Card Number:");
		card.setBounds(80, 100, 300, 30);
		card.setFont(new Font("Raleway", Font.BOLD, 15));
		add(card);

		mini = new JLabel();
		mini.setBounds(80, 150, 400, 30);
		mini.setFont(new Font("Raleway", Font.BOLD, 10));
		add(mini);

		balance = new JLabel();
		balance.setBounds(80, 250, 200, 30);
		add(balance);

		b1 = new JButton("BACK");
		b1.setBounds(200, 350, 100, 30);
		add(b1);

		b1.addActionListener(this);

		try {
			Conn c = new Conn();
			
			ResultSet rs = c.s.executeQuery("select * from login where pin = '" + pin + "'");

			while (rs.next()) {
				card.setText("Card Number: " + rs.getString("cardno").substring(0, 4) + "XXXXXXXX"
						+ rs.getString("cardno").substring(12));
			}
		} catch (Exception e) {
			System.out.println(e);
		}

		try {
			Conn c = new Conn();
			int bal = 0;
			ResultSet rs = c.s.executeQuery("SELECT * FROM bank where pin = '" + pin + "'");

			if (rs.next()) {
				mini.setText(mini.getText() + "<html>" + rs.getString("date") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
						+ rs.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"
						+ rs.getString("amount") + "<br><br><html>");
			}
			
			if (rs.getString("type").equals("Deposit")) {
				bal += Integer.parseInt(rs.getString("amount"));
			}else {
				bal -= Integer.parseInt(rs.getString("amount"));
			}
		
		     balance.setText("Your total Balance is Rs " + bal);
		     
		} catch (Exception e) {
			e.printStackTrace();
		}

		setSize(500, 500);
		setLocation(500, 200);
		setLayout(null);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {
		
		if (ae.getSource() == b1) {
			setVisible(false);
			new Transactions(pin).setVisible(true);
		}
		
		this.dispose();
	}

	public static void main(String[] args) {
		new Ministatement("").setVisible(true);
	}
}

