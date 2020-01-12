package af.asr.saltgenerator.batch.steps;

import static af.asr.saltgenerator.infrastructure.constant.SaltGeneratorConstant.END_SEQ;
import static af.asr.saltgenerator.infrastructure.constant.SaltGeneratorConstant.START_SEQ;

import javax.annotation.PostConstruct;

import af.asr.saltgenerator.data.model.SaltEntity;
import af.gov.anar.lang.infrastructure.util.CryptoUtil;
import af.gov.anar.lang.infrastructure.util.DateUtils;
import af.gov.anar.lang.infrastructure.util.HMACUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;


/**
 * The Class SaltReader - Creates entities based on chunk size.
 * Start and end sequence for entity Id is provide via configuration.
 * Implements {@code ItemReader}.
 * Salt is provided by {@code HMACUtils.generateSalt()}
 */
@Component
@Log4j2
public class SaltReader implements ItemReader<SaltEntity> {


	/** The start seq. */
	private Long startSeq;

	/** The end seq. */
	private Long endSeq;

	/** The env. */
	@Autowired
	private Environment env;

	@PostConstruct
	public void initialize() {
		startSeq = env.getProperty(START_SEQ.getValue(), Long.class);
		endSeq = env.getProperty(END_SEQ.getValue(), Long.class);
	}

	/* (non-Javadoc)
	 * @see org.springframework.batch.item.ItemReader#read()
	 */
	@Override
	public SaltEntity read() {
		if (startSeq <= endSeq) {
			SaltEntity entity = new SaltEntity();
			entity.setId(startSeq);
			entity.setSalt(CryptoUtil.encodeBase64String(HMACUtils.generateSalt()));
			entity.setCreatedBy("System");
			entity.setCreateDtimes(DateUtils.getUTCCurrentDateTime());
			log.debug("SALT_GENERATOR", "SaltReader", "Entity with id created - ",
					String.valueOf(startSeq));
			startSeq = startSeq + 1;
			return entity;
		} else {
			return null;
		}
	}

}
