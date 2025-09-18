/*https://www.ibm.com/docs/en/db2/12.1.0?topic=pdsdjs-common-data-server-driver-jdbc-sqlj-properties-db2-db2-zos-servers
  queryPrefetch
    Specifies whether the IBM Data Server Driver for JDBC and SQLJ uses query prefetch behavior for retrieving rows from a Db2 table. Use of query prefetch can improve performance when an application retrieves large result sets. Query prefetch is not used when an application retrieves LOB or XML data, or when the cursor that is used for data retrieval is not a forward-only cursor.
    The data type of queryPrefetch is boolean. This property applies only to IBM Data Server Driver for JDBC and SQLJ type 4 connectivity.

   Possible values are:
    true
        Specifies that the IBM Data Server Driver for JDBC and SQLJ can use query prefetch when it retrieves rows from a table.
    false
        Specifies that the IBM Data Server Driver for JDBC and SQLJ does not use query prefetch when it retrieves rows from a table. false is the default.
 */
package properties.queryPrefetch;
import java.sql.*;
public class queryPrefetch {

	public static void main(String[] args) throws SQLException {
		Connection con1 = getConnection("jdbc:db2://localhost:51000/testdb:user=db2inst1;password=my_password;queryPrefetch=true;");

		Statement stmt = con1.createStatement();
		//create statement to execute SQL
		ResultSet rs = stmt.executeQuery("select * from sysibm.systables");
		long start = System.currentTimeMillis();
		while(rs.next())
		  System.out.println("Current TimeStamp: "+rs.getString(1));

		long end = System.currentTimeMillis();;
		System.out.println("Time for processing milli: "+(end-start));
		
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
