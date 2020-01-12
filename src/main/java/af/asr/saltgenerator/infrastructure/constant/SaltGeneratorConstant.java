package af.asr.saltgenerator.infrastructure.constant;

/**
 * The Enum SaltGeneratorConstant - contains constants for SaltGenerator.
 */
public enum SaltGeneratorConstant {
	
	/** The package to scan. */
	PACKAGE_TO_SCAN("af.asr.saltgenerator.*"),
	
	/** The db schema name. */
	DB_SCHEMA_NAME("asr.salt-generator.schemaName"),
	
	/** The db table name. */
	DB_TABLE_NAME("asr.salt-generator.tableName"),
	
	/** The chunk size. */
	CHUNK_SIZE("asr.salt-generator.chunk-size"),
	
	/** The start seq. */
	START_SEQ("asr.salt-generator.start-sequence"),
	
	/** The end seq. */
	END_SEQ("asr.salt-generator.end-sequence"),
	
	DATASOURCE_ALIAS("asr.salt-generator.db.key-alias"),
	
	/** The datasource url. */
	DATASOURCE_URL("%s.url"),
	
	/** The datasource username. */
	DATASOURCE_USERNAME("%s.username"),
	
	/** The datasource password. */
	DATASOURCE_PASSWORD("%s.password"),
	
	/** The datasource driverclassname. */
	DATASOURCE_DRIVERCLASSNAME("%s.driverClassName");

	/** The value. */
	private String value;
	
	/**
	 * Instantiates a new salt generator constant.
	 *
	 * @param value the value
	 */
	SaltGeneratorConstant(String value) {
		this.value = value;
	}
	
	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
}
