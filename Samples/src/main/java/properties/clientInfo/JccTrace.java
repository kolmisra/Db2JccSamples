package properties.clientInfo;

import java.sql.Connection;
import java.sql.SQLException;

public class JccTrace {
	//Refer doc/JCC_Trace.md for more details.
	
	public static void main(String[] args) throws SQLException {
		String jccURL="jdbc:db2://localhost:51000/testdb:user=db2inst1;password=my_password;"
				+ "traceDirectory=target/resources/jccTrace;"
				+ "traceFile=jccTraceFile;";
		
		//Setting the client info details through connection URL
		Connection con1 = connection.Connection_URL.getConnection(jccURL);
	
	}

}
