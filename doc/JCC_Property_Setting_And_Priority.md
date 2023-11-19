# How to set JCC properties and the priority order
There are Four ways A user can pass the jcc properties to the JCC driver.

## JDBC URL:
-------------
"jdbc:db2://localhost:51000/testdb:user=db2inst1;password=my_password;traceFile=/folderpath/jccTraceFile.txt;"

"traceFile" is the property to enable JCC trace for the problem diagnostic.
If user is using the Drivermanager.getConnection() API with JDBC URL to create a connection, in above way the properties can be defined.

## JDBC datasource:
----------------
ds.setTraceFile ("/folderpath/jccTraceFile.txt");
If user is using a datasource to create a connection then above way the properties can be set to the driver.

## Global Property File (DB2JccConfiguration.properties)
------------------------------------------------------
DB2JccConfiguration.properties needs to be placed in the JVM CLASSPATH env for JCC driver to read.

db2.jcc.traceFile=/folderpath/jccTraceFile.txt

OR

db2.jcc.override.traceFile=/folderpath/jccTraceFile.txt

If user is using an external properties file to set the jcc properties, then in above way the values can be set.

## Java System property.
------------------------
Individually a property also can be set through the Java system property.

java -Ddb2.jcc.override.traceFile=/folderpath/jccTraceFile.txt
or
java -Ddb2.jcc.traceFile=/folderpath/jccTraceFile.txt
or through java code
System.setProperty ("db2.jcc.traceFile", "/folderpath/jccTraceFile.txt");

User can set the global property file through the java system property as well.
java -Ddb2.jcc.propertiesFile=myGlobalproperty.properties
or through java code
System.setProperty ("db2.jcc.propertiesFile", "/folderpath/myGlobalproperty.properties");

## Priority Order of the property setting.
--------------------------------------------
1. The override property settings (db2.jcc.override.traceFile) having the higest priority. It overrides the values if same set through the URL/Datasource way. If the same override property passed through the java system property it takes precedence over the global property file setting.
2. The URL/ Datasource are the next in the order. Both URL/ datasource having same priority, because user will use any one only to create the connection.
3. The NON-override property settings (db2.jcc.traceFile) having the least priority. this will be applied if no other way(URL/DS) the same property is set. If the same NON-override property passed through the java system property it takes precedence over the global property file setting.


