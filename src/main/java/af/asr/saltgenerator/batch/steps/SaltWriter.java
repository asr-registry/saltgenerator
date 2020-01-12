package af.asr.saltgenerator.batch.steps;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import af.asr.saltgenerator.data.model.SaltEntity;
import af.asr.saltgenerator.data.repository.SaltRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * The Class SaltWriter - Class to write salt entities to DB in batch.
 * Implements {@code ItemWriter}.
 */
@Component
@Log4j2
public class SaltWriter implements ItemWriter<SaltEntity> {

	@Autowired
	private SaltRepository repo;

	/* (non-Javadoc)
	 * @see org.springframework.batch.item.ItemWriter#write(java.util.List)
	 */
	@Override
	@Transactional
	public void write(List<? extends SaltEntity> entities) throws Exception {
		if (repo.countByIdIn(entities.parallelStream().map(SaltEntity::getId).collect(Collectors.toList())) == 0l) {
			repo.saveAll(entities);
			log.debug("SALT_GENERATOR", "SaltWriter", "Entities written", String.valueOf(entities.size()));
		} else {
			log.error("SALT_GENERATOR", "SaltWriter", "write", "Records already exists");
			throw new Exception("Record Already Exist");
		}
	}

}
