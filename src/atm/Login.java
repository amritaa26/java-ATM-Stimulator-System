package atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	JLabel l1, l2, l3, image;
	JTextField tf1;
	JPasswordField pf1;
	JButton b1, b2, b3;

	Login() {
		setTitle("AUTOMATED TELLER MACHINE");
		setSize(800, 480);
		setLocation(400, 150);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
		Image i2 = i1.getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
        image = new JLabel(i3);
		image.setBounds(160, 30, 150, 60);
		add(image);
    
		l1 = new JLabel("Welcome To ATM");
		l1.setFont(new Font("Osward", Font.BOLD, 34));
		l1.setBounds(280, 40, 300, 40);
		add(l1);

		l2 = new JLabel("Card Number:");
		l2.setFont(new Font("Raleway", Font.BOLD, 28));
		l2.setBounds(100, 150, 200, 30);
		add(l2);

		tf1 = new JTextField(15);
		tf1.setFont(new Font("Aerial", Font.BOLD, 20));
		tf1.setBounds(300, 150, 250, 30);
		add(tf1);

		l3 = new JLabel("PIN:");
		l3.setFont(new Font("Raleway", Font.BOLD, 28));
		l3.setBounds(100, 220, 200, 30);
		add(l3);

		pf1 = new JPasswordField(15);
		pf1.setFont(new Font("Aerial", Font.BOLD | Font.ITALIC, 20));
		pf1.setBounds(300, 220, 250, 30);
		add(pf1);

		b1 = new JButton("SIGN IN");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setFont(new Font("Sans Serif", Font.BOLD, 15));
		b1.setBounds(300, 300, 100, 40);
		add(b1);

		b2 = new JButton("CLEAR");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setFont(new Font("Sans Serif", Font.BOLD, 15));
		b2.setBounds(450, 300, 100, 40);
		add(b2);

		b3 = new JButton("SIGN UP");
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		b3.setFont(new Font("Sans Serif", Font.BOLD, 15));
		b3.setBounds(300, 350, 250, 40);
		add(b3);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public static void main(String[] args) {
		new Login();
	}

	public void actionPerformed(ActionEvent ae) {

		try {
			Conn c = new Conn();
            if(ae.getSource() == b1) {
            	String cardno = tf1.getText();
        		String pin = pf1.getText();
        		String query = "select * from login where cardno = '"+cardno+"' and pin = '"+pin+"'";
                 
        		ResultSet rs = c.s.executeQuery(query);
        		if(rs.next()){
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Incorrect Card Number or PIN");
                }
            }
		     else if(ae.getSource() == b2) {
				tf1.setText("");
				pf1.setText("");
			} else if (ae.getSource() == b3) {
				setVisible(false);
				new Signup().setVisible(true);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
