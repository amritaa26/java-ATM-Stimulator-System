package atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Signup2 extends JFrame implements ActionListener {
	JLabel a1, a2, a3, a4, a5, a6, a7;
	JTextField t1, t2, t3;
	JRadioButton r1, r2, r3, r4;
	ButtonGroup s1, e1;
	JButton b1;
	String formno;

	Signup2(String formno) {

		this.formno = formno;
		setTitle("ADDITIONAL DETAILS");
		setSize(800, 800);
		setLocation(400, 15);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);

		a1 = new JLabel("PAGE-2/3");
		a1.setFont(new Font("Osward", Font.BOLD, 10));
		a1.setBounds(50, 10, 400, 40);
		add(a1);

		a2 = new JLabel("ADDITIONAL DETAILS");
		a2.setFont(new Font("Osward", Font.BOLD, 25));
		a2.setBounds(260, 40, 400, 40);
		add(a2);

		a3 = new JLabel("PAN Number");
		a3.setFont(new Font("Raleway", Font.BOLD, 17));
		a3.setBounds(100, 120, 150, 40);
		add(a3);

		t1 = new JTextField();
		t1.setFont(new Font("Aerial", Font.BOLD, 15));
		t1.setBounds(240, 120, 450, 40);
		add(t1);

		a4 = new JLabel("Aadhar Number");
		a4.setFont(new Font("Raleway", Font.BOLD, 17));
		a4.setBounds(100, 190, 150, 40);
		add(a4);

		t2 = new JTextField();
		t2.setFont(new Font("Aerial", Font.BOLD, 15));
		t2.setBounds(240, 190, 450, 40);
		add(t2);

		a5 = new JLabel("Citizenship");
		a5.setFont(new Font("Raleway", Font.BOLD, 17));
		a5.setBounds(100, 260, 150, 40);
		add(a5);

		t3 = new JTextField();
		t3.setFont(new Font("Aerial", Font.BOLD, 15));
		t3.setBounds(240, 260, 450, 40);
		add(t3);

		a6 = new JLabel("Senior Citizen");
		a6.setFont(new Font("Raleway", Font.BOLD, 17));
		a6.setBounds(100, 330, 150, 40);
		add(a6);

		r1 = new JRadioButton("YES");
		r1.setBounds(260, 330, 80, 40);
		r1.setBackground(Color.WHITE);
		add(r1);

		r2 = new JRadioButton("NO");
		r2.setBounds(350, 330, 80, 40);
		r2.setBackground(Color.WHITE);
		add(r2);

		s1 = new ButtonGroup();
		s1.add(r1);
		s1.add(r2);

		a7 = new JLabel("Existing account");
		a7.setFont(new Font("Raleway", Font.BOLD, 17));
		a7.setBounds(100, 400, 150, 40);
		add(a7);

		r3 = new JRadioButton("YES");
		r3.setBounds(260, 400, 80, 40);
		r3.setBackground(Color.WHITE);
		add(r3);

		r4 = new JRadioButton("NO");
		r4.setBounds(350, 400, 80, 40);
		r4.setBackground(Color.WHITE);
		add(r4);

		e1 = new ButtonGroup();
		e1.add(r3);
		e1.add(r4);

		b1 = new JButton("NEXT");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setFont(new Font("Sans Serif", Font.BOLD, 15));
		b1.setBounds(600, 500, 100, 40);
		add(b1);

		b1.addActionListener(this);

		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae) {

		String pan = t1.getText();
		String aadhar = t2.getText();
		String citizen = t3.getText();

		String senior = "";
		if (r1.isSelected()) {
			senior = "YES";
		} else if (r2.isSelected()) {
			senior = "NO";
		}

		String existacc = "";
		if (r3.isSelected()) {
			existacc = "YES";
		} else if (r4.isSelected()) {
			existacc = "NO";
		}

		try {

			if (pan.equals("") || aadhar.equals("") || citizen.equals("") || !r1.isSelected() && !r2.isSelected()
					|| !r3.isSelected() && !r4.isSelected())

			{
				JOptionPane.showMessageDialog(null, "Please fill all the required fields.");
				return;

			}

			else {

				Conn c = new Conn();
				String query = "insert into signup2 values('" + formno + "', '" + pan + "','" + aadhar + "','" + citizen
						+ "', '" + senior + "', '" + existacc + "')";
				c.s.executeUpdate(query); // DML Command

				new Signup3(formno).setVisible(true);
				setVisible(false);
			}

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static void main(String[] args) {
		new Signup2("").setVisible(true);

	}

}
