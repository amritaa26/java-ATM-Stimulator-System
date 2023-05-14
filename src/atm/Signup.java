package atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;



public class Signup extends JFrame implements ActionListener {

	Random ran = new Random();
	int random = Math.abs((ran.nextInt(9000) + 1000));
	String first = "" + (random);

	JLabel z1, z2, a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, gender, personal;
	JTextField t1, t2, t3, t4, t5, t6, t7, d1;
	JButton b1;
	JRadioButton r1, r2, r3, r4, r5;
	ButtonGroup g1, m1;
	
	JComboBox c1, c2, c3, c4;

	
	Signup() throws Exception {

		setTitle("PERSONAL DETAILS");
		setSize(800, 800);
		setLocation(400, 15);
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);

		z1 = new JLabel("APPLICATION NO.- " + random);
		z1.setFont(new Font("Osward", Font.BOLD, 10));
		z1.setBounds(600, 10, 400, 40);
		add(z1);

		z2 = new JLabel("PAGE-1/3");
		z2.setFont(new Font("Osward", Font.BOLD, 10));
		z2.setBounds(50, 10, 400, 40);
		add(z2);

		personal = new JLabel("PERSONAL DETAILS");
		personal.setFont(new Font("Osward", Font.BOLD, 25));
		personal.setBounds(260, 40, 400, 40);
		add(personal);

		a1 = new JLabel("Name");
		a1.setFont(new Font("Raleway", Font.BOLD, 17));
		a1.setBounds(100, 120, 150, 40);
		add(a1);

		t1 = new JTextField();
		t1.setFont(new Font("Aerial", Font.BOLD, 15));
		t1.setBounds(200, 120, 200, 40);
		add(t1);

		a2 = new JLabel("Father's Name");
		a2.setFont(new Font("Raleway", Font.BOLD, 17));
		a2.setBounds(430, 120, 150, 40);
		add(a2);

		t2 = new JTextField();
		t2.setFont(new Font("Aerial", Font.BOLD, 15));
		t2.setBounds(550, 120, 200, 40);
		add(t2);

		a3 = new JLabel("Address");
		a3.setFont(new Font("Raleway", Font.BOLD, 17));
		a3.setBounds(100, 190, 150, 40);
		add(a3);

		t3 = new JTextField();
		t3.setFont(new Font("Aerial", Font.BOLD, 15));
		t3.setBounds(200, 190, 550, 40);
		add(t3);

		a4 = new JLabel("State");
		a4.setFont(new Font("Raleway", Font.BOLD, 17));
		a4.setBounds(100, 260, 150, 40);
		add(a4);

		t4 = new JTextField();
		t4.setFont(new Font("Aerial", Font.BOLD, 15));
		t4.setBounds(200, 260, 150, 40);
		add(t4);

		a5 = new JLabel("City");
		a5.setFont(new Font("Raleway", Font.BOLD, 17));
		a5.setBounds(360, 260, 150, 40);
		add(a5);

		t5 = new JTextField();
		t5.setFont(new Font("Aerial", Font.BOLD, 15));
		t5.setBounds(400, 260, 150, 40);
		add(t5);

		a6 = new JLabel("Pin");
		a6.setFont(new Font("Raleway", Font.BOLD, 17));
		a6.setBounds(560, 260, 150, 40);
		add(a6);

		t6 = new JTextField();
		t6.setFont(new Font("Aerial", Font.BOLD, 15));
		t6.setBounds(600, 260, 150, 40);
		add(t6);

		a7 = new JLabel("DOB");
		a7.setFont(new Font("Raleway", Font.BOLD, 17));
		a7.setBounds(100, 330, 150, 40);
		add(a7);

		d1 = new JTextField();
		d1.setFont(new Font("Aerial", Font.BOLD, 15));
		d1.setBounds(200, 330, 200, 40);
		add(d1);

		gender = new JLabel("Gender");
		gender.setFont(new Font("Raleway", Font.BOLD, 17));
		gender.setBounds(430, 330, 150, 40);
		add(gender);

		r1 = new JRadioButton("Male");
		r1.setBounds(510, 330, 80, 40);
		r1.setBackground(Color.WHITE);
		add(r1);

		r2 = new JRadioButton("Female");
		r2.setBounds(590, 330, 90, 40);
		r2.setBackground(Color.WHITE);
		add(r2);

		r3 = new JRadioButton("Other");
		r3.setBounds(690, 330, 150, 40);
		r3.setBackground(Color.WHITE);
		add(r3);

		g1 = new ButtonGroup();
		g1.add(r1);
		g1.add(r2);
		g1.add(r3);

		a8 = new JLabel("Contact No.");
		a8.setFont(new Font("Raleway", Font.BOLD, 17));
		a8.setBounds(100, 400, 150, 40);
		add(a8);

		t7 = new JTextField();
		t7.setFont(new Font("Aerial", Font.BOLD, 15));
		t7.setBounds(200, 400, 200, 40);
		add(t7);

		a9 = new JLabel("Education");
		a9.setFont(new Font("Raleway", Font.BOLD, 17));
		a9.setBounds(430, 400, 150, 40);
		add(a9);

		String education[] = { " ", "Non-Graduate", "Graduate", "Post-Graduate", "Doctrate", "Others" };
		c1 = new JComboBox(education);
		c1.setBackground(Color.WHITE);
		c1.setFont(new Font("Raleway", Font.BOLD, 15));
		c1.setBounds(550, 400, 200, 40);
		add(c1);

		a10 = new JLabel("Category");
		a10.setFont(new Font("Raleway", Font.BOLD, 17));
		a10.setBounds(100, 470, 150, 40);
		add(a10);

		String category[] = { " ", "General", "OBC", "SC", "ST", "Other" };
		c2 = new JComboBox(category);
		c2.setBackground(Color.WHITE);
		c2.setFont(new Font("Raleway", Font.BOLD, 15));
		c2.setBounds(200, 470, 200, 40);
		add(c2);

		a11 = new JLabel("Status");
		a11.setFont(new Font("Raleway", Font.BOLD, 17));
		a11.setBounds(430, 470, 150, 40);
		add(a11);

		r4 = new JRadioButton("Married");
		r4.setBounds(510, 470, 80, 40);
		r4.setBackground(Color.WHITE);
		add(r4);

		r5 = new JRadioButton("Unmarried");
		r5.setBounds(590, 470, 100, 40);
		r5.setBackground(Color.WHITE);
		add(r5);

		m1 = new ButtonGroup();
		m1.add(r4);
		m1.add(r5);

		a12 = new JLabel("Occupation");
		a12.setFont(new Font("Raleway", Font.BOLD, 17));
		a12.setBounds(100, 540, 150, 40);
		add(a12);

		String occupation[] = { " ", "Salaried", "Self-Employmed", "Business", "Student", "Retired", "Others" };
		c3 = new JComboBox(occupation);
		c3.setBackground(Color.WHITE);
		c3.setFont(new Font("Raleway", Font.BOLD, 15));
		c3.setBounds(200, 540, 200, 40);
		add(c3);

		a13 = new JLabel("Income");
		a13.setFont(new Font("Raleway", Font.BOLD, 17));
		a13.setBounds(430, 540, 150, 40);
		add(a13);

		String Income[] = { " ", "Null", "<1,50,000", "<2,50,000", "<5,00,000", "Upto 10,00,000", "Above 10,00,000" };
		c4 = new JComboBox(Income);
		c4.setBackground(Color.WHITE);
		c4.setFont(new Font("Raleway", Font.BOLD, 15));
		c4.setBounds(550, 540, 200, 40);
		add(c4);

		b1 = new JButton("NEXT");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setFont(new Font("Sans Serif", Font.BOLD, 15));
		b1.setBounds(650, 650, 100, 40);
		add(b1);

		b1.addActionListener(this);
		setVisible(true);

	}

	public void actionPerformed(ActionEvent ae) {

		String formno = first;
		String name = t1.getText();
		String fname = t2.getText();
		String address = t3.getText();
		String state = t4.getText();
		String city = t5.getText();
		String pin = t6.getText();
		String dob = d1.getText();
		String contact = t7.getText();
		String education = (String) c1.getSelectedItem();
		String category = (String) c2.getSelectedItem();
		String occupation = (String) c3.getSelectedItem();
		String income = (String) c4.getSelectedItem();

		String gender = "";
		if (r1.isSelected()) {
			gender = "Male";
		} else if (r2.isSelected()) {
			gender = "Female";
		} else if (r3.isSelected()) {
			gender = "Other";
		}

		String status = "";
		if (r4.isSelected()) {
			status = "Married";
		} else if (r5.isSelected()) {
			status = "Unmarried";
		}

		try {

			if (name.equals("") || fname.equals("") || address.equals("") || state.equals("") || city.equals("")
					|| pin.equals("") || contact.equals("") || dob.equals("")
					|| !r1.isSelected() && !r2.isSelected() && !r3.isSelected() || !r4.isSelected() && !r5.isSelected()
					|| (String) c1.getSelectedItem() == " " || (String) c2.getSelectedItem() == " "
					|| (String) c3.getSelectedItem() == " " || (String) c4.getSelectedItem() == " ")

			{
				JOptionPane.showMessageDialog(null, "Please fill all the required fields.");
				return;

			}

			else {

				Conn c = new Conn();
				String query = "insert into signup values('" + formno + "','" + name + "','" + fname + "','" + dob
						+ "', '" + gender + "', '" + address + "', '" + city + "','" + pin + "','" + state + "','"
						+ contact + "', '" + status + "','" + education + "', '" + category + "', '" + occupation
						+ "', '" + income + "')";
				c.s.executeUpdate(query); // DML Command

			}
			
/*		if(!contact.matches("[0-9+]")) {
				JOptionPane.showMessageDialog(null, "Contact is Incorrect.");
				return;
			}           */

			setVisible(false);
			new Signup2(first).setVisible(true);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) throws Exception {
		new Signup().setVisible(true);
	}
}