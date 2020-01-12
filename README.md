### Salt Generator Library

Batch Job Application to for one-time populating of salt values for related application salt tables.

#### Features

- Slat Reader
- Salt Writer
- Batch Job Listener
- Salt Data Store
- Flexible Config Management
- Data Model
- and more


salt-generator requires data source details such as url, username, password, driverClassName to be provided as input in form of property key alias. The value of data source details should be provided in module specific properties as below.

```
<key-alias>.url=<url>
<key-alias>.username=<username>
<key-alias>.password=<password>
<key-alias>.driverClassName=<driverClassName>
```

salt-generator supports schema name and table name to be provided as input in form of direct value or key of the property which contains the value stored in config server.

** application.properties **

```
asr.salt-generator.chunk-size=<chunkSize>
asr.salt-generator.start-sequence=<startSeq>
asr.salt-generator.end-sequence=<endSeq>
```

** module wise required properties **

```
asr.salt-generator.db.key-alias=<property key alias providing the details for datasource such as url, username, password, driverClassName>
asr.salt-generator.schemaName=<schemaName/property key containing the schemaName>
asr.salt-generator.tableName=<tableName/property key containing the tableName>
```

Default Port and Context Path

```
server.port=4011
```
