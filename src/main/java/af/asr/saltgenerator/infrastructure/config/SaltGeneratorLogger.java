package af.asr.saltgenerator.infrastructure.config;


///**
// * The Class SaltGeneratorLogger.
// *
// */
//public class SaltGeneratorLogger {
//
//	/** The mosip rolling file appender. */
//	private static RollingFileAppender rollingFileAppender;
//
//	static {
//		rollingFileAppender = new RollingFileAppender();
//		rollingFileAppender.setAppend(true);
//		rollingFileAppender.setAppenderName("fileappender");
//		rollingFileAppender.setFileName("logs/salt-generator.log");
//		rollingFileAppender.setFileNamePattern("logs/salt-generator-%d{yyyy-MM-dd}-%i.log");
//		rollingFileAppender.setImmediateFlush(true);
//		rollingFileAppender.setMaxFileSize("1mb");
//		rollingFileAppender.setMaxHistory(3);
//		rollingFileAppender.setPrudent(false);
//		rollingFileAppender.setTotalCap("10mb");
//	}
//
//	/**
//	 * Method to get the rolling file logger for the class provided.
//	 *
//	 * @param clazz the clazz
//	 * @return the logger
//	 */
//	public static Logger getLogger(Class<?> clazz) {
//		return Logfactory.getDefaultRollingFileLogger(mosipRollingFileAppender, clazz);
//	}
//}
