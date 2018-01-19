import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo1 {

	public static void main(String[] args) {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// http://www.techpaste.com/2011/07/java-sql-sqlexception-listener-refused-connection-error/
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@172.18.73.194:1521:XE", "system", "oracle");
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
