package connection;
import java.sql.*;
public class Connection_DS {

	public static void main(String[] args) throws SQLException {
		com.ibm.db2.jcc.DB2SimpleDataSource ds = new com.ibm.db2.jcc.DB2SimpleDataSource();
		ds.setServerName("localhost");
		ds.setPortNumber(51000);
		ds.setDatabaseName("testdb");
		ds.setDriverType(4);

		Connection con1 = ds.getConnection("db2inst1", "my_password");

		System.out.println("Connection Successful..................");
		System.out.println("Driver Version:    " + con1.getMetaData().getDriverVersion());
		System.out.println("Database Version:  " + con1.getMetaData().getDatabaseProductVersion());

		Statement stmt = con1.createStatement();
		ResultSet rs = stmt.executeQuery("select current timestamp from sysibm.sysdummy1");
		rs.next();
		System.out.println("Current TimeStamp: "+rs.getTimestamp(1));
	}

}
