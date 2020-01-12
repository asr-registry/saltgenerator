package af.asr.saltgenerator.infrastructure.config;

import static af.asr.saltgenerator.infrastructure.constant.SaltGeneratorConstant.DB_SCHEMA_NAME;
import static af.asr.saltgenerator.infrastructure.constant.SaltGeneratorConstant.DB_TABLE_NAME;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * The Class PhysicalNamingStrategyResolver - class to resolve table name and
 * schema name dynamically.
 */
@Component
public class PhysicalNamingStrategyResolver extends PhysicalNamingStrategyStandardImpl {

	/** The env. */
	@Autowired
	private transient Environment env;

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl#
	 * toPhysicalSchemaName(org.hibernate.boot.model.naming.Identifier,
	 * org.hibernate.engine.jdbc.env.spi.JdbcEnvironment)
	 */
	@Override
	public Identifier toPhysicalSchemaName(Identifier name, JdbcEnvironment context) {
		return Identifier.toIdentifier(env.getProperty(env.getProperty(DB_SCHEMA_NAME.getValue()),
				env.getProperty(DB_SCHEMA_NAME.getValue())));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl#
	 * toPhysicalTableName(org.hibernate.boot.model.naming.Identifier,
	 * org.hibernate.engine.jdbc.env.spi.JdbcEnvironment)
	 */
	@Override
	public Identifier toPhysicalTableName(Identifier name, JdbcEnvironment context) {
		return Identifier.toIdentifier(
				env.getProperty(env.getProperty(DB_TABLE_NAME.getValue()), env.getProperty(DB_TABLE_NAME.getValue())));
	}
}