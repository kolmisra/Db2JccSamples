# JCC Trace property and its options

https://www.ibm.com/support/pages/collecting-data-tracing-ibm-data-server-driver-jdbc-and-sqlj
https://www.ibm.com/docs/en/db2/11.5?topic=sqlj-examples-using-configuration-properties-start-jdbc-trace
https://www.ibm.com/support/pages/db2-how-collect-jdbc-trace-jcc-driver
https://www.ibm.com/docs/en/db2/11.5?topic=SSEPGG_11.5.0/com.ibm.db2.luw.apdv.java.doc/src/tpc/imjcc_cjvjcdig.htm

This page contains the various property details for JCC tracing.
###Property traceFile
###Property traceDirectory
###property traceLevel 
###Property traceFileAppend 
###Property traceOption
###Property traceFileCount
###Property traceFileSize
###property db2.jcc.tracePolling
###property db2.jcc.tracePollingInterval

Refer [JCC_Property_Setting_And_Priority.md](docs/JCC_Property_Setting_And_Priority.md) for properties priority order.

NOTE: While using multiple trace properties either follow all through override or all through NON-override .
Mixing override and the NON-OVERRIDE may cause some unexpected trace property behaviour.

##Property traceFile
traceFile=/folderpath/jccTraceFile.txt

This will write the JCC trace content into the /folderpath/jccTraceFile.txt file. For windows use "traceFile=C:\\tracesfolderpath\\jccTraceFile.txt" to pass the value.
providing the file name only will create the file in JVM root directory.

##Property traceDirectory

If the "traceDirectory" propery is set, then the trace file will be created inside the directory.
If "traceDirectory" is set, provide a file name only without and folderpath for "traceFile".
traceDirectory=/folderpath
traceFile=jccTraceFile.txt
With the above setting the JCC trace will be present as /folderpath/jccTraceFile.txt_sds_1
If the "traceFile" is not set, JCC trace will be present as /folderpath/_sds_1

if the properties defined in a global property file 
db2.jcc.traceDirectory=/folderpath
db2.jcc.traceFile=jccTraceFile.txt
then the trace file will be /folderpath/jccTraceFile.txt_global_1
If the traceFile is not set, JCC trace will be present as /folderpath/_global_1

With "traceDirectory" defined one JCC trace file will be created for each connection object.
In a multithread application it is recommended to use the "traceDirectory" property.

The trace file will be create with an incremental number for each connection object.
e.g
_global_1, _global_2, _global_3, ....... 
or
_sds_1, _sds_2, _sds_3, .....

##property traceLevel 

By default the traceLevel value is -1. which means all trace data will be available.
Below are the various trace levels, its HEX, INTEGER and BINARY representations. Trace Levels are the place holder of the bits in the integer variable.
TRACE_NONE = 0x0  (0)
TRACE_CONNECTION_CALLS = 0x1  (1)   	(0000 0000 0000 0000 0000 0000 0000 0001)
TRACE_STATEMENT_CALLS = 0x2  (2)   	(0000 0000 0000 0000 0000 0000 0000 0010)     
TRACE_RESULT_SET_CALLS = 0x4  (4)   	(0000 0000 0000 0000 0000 0000 0000 0100)
TRACE_DRIVER_CONFIGURATION = 0x10  (16)   	(0000 0000 0000 0000 0000 0000 0001 0000)
TRACE_CONNECTS = 0x20  (32)   	(0000 0000 0000 0000 0000 0000 0010 0000)
TRACE_DRDA_FLOWS = 0x40  (64)  	(0000 0000 0000 0000 0000 0000 0100 0000)
TRACE_RESULT_SET_META_DATA = 0x80  (128)   	(0000 0000 0000 0000 0000 0000 1000 0000)
TRACE_PARAMETER_META_DATA = 0x100  (256)   	(0000 0000 0000 0000 0000 0001 0000 0000)
TRACE_DIAGNOSTICS = 0x200  (512)   	(0000 0000 0000 0000 0000 0010 0000 0000)
TRACE_SQLJ = 0x400  (1024)   	(0000 0000 0000 0000 0000 0100 0000 0000)
TRACE_XA_CALLS = 0x800  (2048)   	(0000 0000 0000 0000 0000 1000 0000 0000)
TRACE_META_CALLS = 0x2000  (8192)   	(0000 0000 0000 0000 0010 0000 0000 0000)
TRACE_DATASOURCE_CALLS = 0x4000  (16384)   	(0000 0000 0000 0000 0100 0000 0000 0000)
TRACE_LARGE_OBJECT_CALLS = 0x8000  (32768)   	(0000 0000 0000 0000 1000 0000 0000 0000)
TRACE_T2ZOS = 0x10000  (65536)   	(0000 0000 0000 0001 0000 0000 0000 0000)
TRACE_SYSTEM_MONITOR = 0x20000  (131072)   	(0000 0000 0000 0010 0000 0000 0000 0000)
TRACE_TRACEPOINTS = 0x40000  (262144)   	(0000 0000 0000 0100 0000 0000 0000 0000)
TRACE_SYSPLEX = 0x80000  (524288)   	(0000 0000 0000 1000 0000 0000 0000 0000)
	
TRACE_ALL = 0xFFFFFFFF(-1)    	(1111 1111 1111 1111 1111 1111 1111 1111)

If two or more trace level need to combine, use the (value1 | value2 ) to get the traceLevel value.
e.g  if user wants to collect traces of connection, statement, diagnostic and the system monitor calls
So the trace level will be 
1 | 2 | 512 | 131072 = 20203
use traceLevel=20203

If all the data except a specific level needed then, use the (-1 & ~value ) to get the value.
e.g  if user wants to collect all the data except DRDA FLOWS.
So the trace level will be 
-1 & ~64 = -65
use traceLevel=-65

e.g  if user wants to collect all the data except DRDA and CONENCTION FLOWS.
So the trace level will be 
-1 & ~(64 | 1) = -66
use traceLevel=-66

##Property traceFileAppend 

If the "traceFileAppend" property is set to true, JCC trace append to the file if the same exists in the given "traceFile" property.
By default the value is false.
traceFileAppend is always false if the "traceDirectory" property is set.

##Property traceOption

This is also known as circular tracing. If the "traceOption" property set to 1, the file gets over written after the count and size limit is met.
By default this behavior is disabled and the value is 0. This property is depends on "traceFileCount" and "traceFileSize" property values for the count and the size limit.

##Property traceFileCount

If the "traceOption" property is enabled, number of files created are based on the "traceFileCount" value.
If not set by default the value is 2. And the property cant be set smaller than 2.
The trace files generated sequentially.
e.g if the "traceFileCount" is 3, and traceFile=/folderpath/jccTraceFile.txt
jccTraceFile.txt, jccTraceFile.txt.2, jccTraceFile.txt.3 will becreated.

##Property traceFileSize
 
If the "traceOption" property is enabled, size of files created are based on the "traceFileSize" value in bytes.
If not set by default the value is 1048576 (1 MB). And the property cant be set smaller than 1048576 (1 MB).

##property db2.jcc.tracePolling

This property allowed to set through the global property file (DB2JccConfiguration.properties) only.
If this property is set to true, It reads the global property file based on "db2.jcc.tracePollingInterval" value and updates the following trace properties values.

traceLevel, traceFile, traceDirectory, traceFileAppend, traceOption, traceFileSize, traceFileCount

##property db2.jcc.tracePollingInterval

This property allowed to set through the global property file (DB2JccConfiguration.properties) only.
If "db2.jcc.tracePolling" property is set then "db2.jcc.tracePollingInterval" tells the interval in seconds to read the global property file.
By default the property value is 60 seconds.