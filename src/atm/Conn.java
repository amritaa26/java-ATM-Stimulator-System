package atm;

import java.sql.*;

public class Conn {
	Connection c;
	Statement s;

	public Conn() {
		try {
			// Class.forName("com.mysql.jdbc.Driver"); // Registering the Driver
			c = DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem", "root", "root"); // create Connection
			s = c.createStatement(); // create Statement

		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
