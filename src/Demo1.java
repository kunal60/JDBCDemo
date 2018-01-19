import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo1 {

	public static void main(String[] args) {
		// http://www.studytonight.com/java/steps-to-connect-to-database-in-java.php
		// https://www.javatpoint.com/example-to-connect-to-the-oracle-database
		try {

			Class.forName("oracle.jdbc.driver.OracleDriver");
			// http://www.techpaste.com/2011/07/java-sql-sqlexception-listener-refused-connection-error/
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@172.18.73.194:1521:XE", "system", "oracle");
			//http://www.studytonight.com/java/connecting-to-oracle.php
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from emp");

			while (rs.next())
				System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
