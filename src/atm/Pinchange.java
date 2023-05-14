package atm;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Pinchange extends JFrame implements ActionListener {
	JLabel l1, l2, l3;
	JPasswordField t1, t2;
	JButton b1, b2;
	String pin;
	
	Pinchange(String pin){
		
		this.pin = pin;
		l1 = new JLabel("Change your PIN");
		l1.setBounds(140, 20, 200, 40);
		l1.setFont(new Font("Osward", Font.BOLD, 25));
		add(l1);
		
		l2 = new JLabel("New PIN");
		l2.setBounds(100, 80, 100, 30);
		l2.setFont(new Font("Osward", Font.BOLD, 15));
		add(l2);
		
		t1 = new JPasswordField();
		t1.setBounds(250, 80, 120, 30);
		add(t1);
		
		l3 = new JLabel("Re-Enter PIN");
		l3.setBounds(100, 120, 100, 30);
		l3.setFont(new Font("Osward", Font.BOLD, 15));
		add(l3);
		
		t2 = new JPasswordField();
		t2.setBounds(250, 120, 120, 30);
		add(t2);
		
		b1 = new JButton("CHANGE");
		b1.setBounds(130, 200, 100, 25);
		add(b1);

		b2 = new JButton("BACK");
		b2.setBounds(250, 200, 100, 25);
		add(b2);

		b1.addActionListener(this);
		b2.addActionListener(this);
		
		setSize(500, 300);
		setLocation(500, 200);
		setLayout(null);
		setVisible(true);
	}
	
	public void actionPerformed(ActionEvent ae) {
		 try{        
	            String npin = t1.getText();
	            String rpin = t2.getText();
	            
	            if(!npin.equals(rpin)){
	                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
	                return;
	            }
	            
	            if(ae.getSource()==b1){
	                if (t1.getText().equals("")){
	                    JOptionPane.showMessageDialog(null, "Enter New PIN");
	                }
	                if (t2.getText().equals("")){
	                    JOptionPane.showMessageDialog(null, "Re-Enter new PIN");
	                }
	                
	                Conn c = new Conn();
	                String q1 = "update bank set pin = '"+rpin+"' where pin = '"+pin+"' ";
	                String q2 = "update login set pin = '"+rpin+"' where pin = '"+pin+"' ";
	                String q3 = "update signup3 set pin = '"+rpin+"' where pin = '"+pin+"' ";

	                c.s.executeUpdate(q1);
	                c.s.executeUpdate(q2);
	                c.s.executeUpdate(q3);

	                JOptionPane.showMessageDialog(null, "PIN changed successfully");
	                setVisible(false);
	                new Transactions(rpin).setVisible(true);
	            
	            }else if(ae.getSource()==b2){
	                new Transactions(pin).setVisible(true);
	                setVisible(false);
	            }
	        }catch(Exception e){
	            System.out.println(e);;
	        }
		
	}

	public static void main(String[] args) {
		new Pinchange("").setVisible(true);

	}


}
