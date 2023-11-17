package properties.clientInfo;
import java.sql.*;
public class Clientinfo {

	public static void main(String[] args) throws SQLException {

		//Setting the client info details through connection URL
		Connection con1 = DriverManager
				.getConnection("jdbc:db2://localhost:51000/testdb:user=db2inst1;password=my_password;"
						+ "clientWorkstation=myWorkStation;"
						+ "clientUser=myUser;"
						+ "clientApplicationInformation=myClientAppInfo;"
						+ "clientAccountingInformation=myClientAccounting;");

		System.out.println("Connection Successful..................");
		System.out.println("Driver Version:    " + con1.getMetaData().getDriverVersion());
		System.out.println("Database Version:  " + con1.getMetaData().getDatabaseProductVersion());
		System.out.println();
		System.out.println("Setting client Info details through connection URL");
	       Statement stmt = con1.createStatement();
	       ResultSet rs = stmt.executeQuery ("SELECT CURRENT CLIENT_WRKSTNNAME, CURRENT CLIENT_USERID, "
	       		+ "CURRENT CLIENT_APPLNAME, CURRENT CLIENT_ACCTNG FROM SYSIBM.SYSDUMMY1");
	       while (rs.next ()) {
	         System.out.println ("CURRENT CLIENT_WRKSTNNAME: " + rs.getString (1));
	         System.out.println ("CURRENT CLIENT_USERID: " + rs.getString (2));
	         System.out.println ("CURRENT CLIENT_APPLNAME: " + rs.getString (3));
	         System.out.println ("CURRENT CLIENT_ACCTNG: " + rs.getString (4));
	       }
	       System.out.println();
	       System.out.println("Setting client Info details through connection API");
	     //Setting the client info details through connection API.
	    con1.setClientInfo("ApplicationName", "ConAppname");
	    con1.setClientInfo("ClientAccountingInformation", "ConAppname");
	    con1.setClientInfo("ClientHostname", "ConAppname");
	    con1.setClientInfo("ClientUser", "ConAppname");
	    rs = stmt.executeQuery ("SELECT CURRENT CLIENT_WRKSTNNAME, CURRENT CLIENT_USERID, "
		       		+ "CURRENT CLIENT_APPLNAME, CURRENT CLIENT_ACCTNG FROM SYSIBM.SYSDUMMY1");
	    
		       while (rs.next ()) {
		         System.out.println ("CURRENT CLIENT_WRKSTNNAME: " + rs.getString (1));
		         System.out.println ("CURRENT CLIENT_USERID: " + rs.getString (2));
		         System.out.println ("CURRENT CLIENT_APPLNAME: " + rs.getString (3));
		         System.out.println ("CURRENT CLIENT_ACCTNG: " + rs.getString (4));
		       }
	}

}
