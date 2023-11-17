package connection;
import java.sql.*;
public class Connection_URL {

	public static void main(String[] args) throws SQLException {
		Connection con1 = DriverManager
				.getConnection("jdbc:db2://localhost:51000/testdb:user=db2inst1;password=my_password;");

		System.out.println("Connection Successful..................");
		System.out.println("Driver Version:    " + con1.getMetaData().getDriverVersion());
		System.out.println("Database Version:  " + con1.getMetaData().getDatabaseProductVersion());

		Statement stmt = con1.createStatement();
		ResultSet rs = stmt.executeQuery("select current timestamp from sysibm.sysdummy1");
		rs.next();
		System.out.println("Current TimeStamp: "+rs.getTimestamp(1));
	}

}
