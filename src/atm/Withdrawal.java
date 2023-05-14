package atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

@SuppressWarnings("serial")
public class Withdrawal extends JFrame implements ActionListener {

	JLabel l1;
	JTextField t1;
	JButton b1, b2;
	String pin;

	Withdrawal(String pin) {

		this.pin = pin;

		l1 = new JLabel("Enter Amount");
		l1.setBounds(150, 20, 200, 40);
		l1.setFont(new Font("Osward", Font.BOLD, 25));
		add(l1);

		t1 = new JTextField();
		t1.setBounds(120, 80, 230, 40);
		t1.setFont(new Font("Osward", Font.BOLD, 20));
		add(t1);

		b1 = new JButton("WITHDRAW");
		b1.setBounds(70, 150, 150, 35);
		add(b1);

		b2 = new JButton("BACK");
		b2.setBounds(270, 150, 150, 35);
		add(b2);

		b1.addActionListener(this);
		b2.addActionListener(this);

		setSize(500, 300);
		setLocation(500, 200);
		setLayout(null);
		setVisible(true);

	}

	public void actionPerformed(ActionEvent ae) {

		try {
			if (ae.getSource() == b1) {
				String amount = t1.getText();
				Date date = new Date();

				if (t1.getText().equals("")) {

					JOptionPane.showMessageDialog(null, "Please enter the Amount");

				} else {
					Conn c = new Conn();
					String query = ("insert into bank values('" + pin + "', '" + date + "', 'Withdraw', '" + amount
							+ "')");
					c.s.executeUpdate(query);

					JOptionPane.showMessageDialog(null, "Rs. " + amount + " Withdraw Successfully");
					setVisible(false);
					new Transactions(pin).setVisible(true);
				}
			}

			else if (ae.getSource() == b2) {
				setVisible(false);
				new Transactions(pin).setVisible(true);
			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static void main(String[] args) {
		new Withdrawal("");
	}

}
