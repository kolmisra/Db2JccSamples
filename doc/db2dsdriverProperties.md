# Db2 JCC property support for db2dsdriver.cfg file

https://www.ibm.com/docs/en/db2/11.5?topic=file-data-server-driver-configuration-example


##Database parameters

https://www.ibm.com/docs/en/db2/11.5?topic=file-data-server-driver-configuration-keywords

##ACR and client affinity parameters

https://www.ibm.com/docs/en/db2/11.5?topic=keywords-high-availability-support


##Below are the properties supported by JCC driver while using the db2dsdriver.cfg file and its correcponding jcc prperties.

![image](https://github.com/kolmisra/Db2JccSamples/assets/15921209/5677c0c3-4b52-43cc-8cef-5ed173ec26de)

##Database Parameter
---------------------
clientApplcompat----> clientApplcompat

currentPackageSet----> currentPackageSet

enableKeepDynamic----> keepDynamic

currentSQLID----> currentSQLID

connectionTimeout----> connectionTimeout

sslVersion----> sslVersion

sslTrustStoreLocation----> sslTrustStoreLocation

sslKeyStoreLocation----> sslKeyStoreLocation

sslTrustStorePassword----> sslTrustStorePassword

sslKeyStorePassword----> sslKeyStorePassword

progressiveStreaming----> progressiveStreaming

queryCloseImplicit----> queryCloseImplicit

enableSslConnection----> sslConnection

securityMechanism----> securityMechanism

disableClientInputDataConversion----> disableClientInputDataConversion

	
##ACR Parameter	
--------------
enableAcr----> enableClientAffinitiesList

enableSeamlessAcr----> enableSeamlessFailover

affinityFailbackInterval----> affinityFailbackInterval

enableAlternateServerListFirstConnect----> enableAlternateServerListFirstConnect

acrRetryInterval----> retryIntervalForClientReroute

maxAcrRetries----> maxRetriesForClientReroute


