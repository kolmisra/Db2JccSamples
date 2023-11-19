package connection;
import java.sql.*;
public class Connection_URL {

	public static void main(String[] args) throws SQLException {
		Connection con1 = getConnection("jdbc:db2://localhost:51000/testdb:user=db2inst1;password=my_password;");

		Statement stmt = con1.createStatement();
		ResultSet rs = stmt.executeQuery("select current timestamp from sysibm.sysdummy1");
		rs.next();
		System.out.println("Current TimeStamp: "+rs.getTimestamp(1));
	}
	
	public static Connection getConnection(String URL) throws SQLException {
		Connection con1 = DriverManager
				.getConnection(URL);

		System.out.println("Connection Successful\n______________________________________");
		System.out.println("JCC Driver Version:    " + con1.getMetaData().getDriverVersion());
		System.out.println("Db2 Database Version:  " + con1.getMetaData().getDatabaseProductVersion());
		System.out.println("______________________________________");
		System.out.println();
		return con1;
	}

}
