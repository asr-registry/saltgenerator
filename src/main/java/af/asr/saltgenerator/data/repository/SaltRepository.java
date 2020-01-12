package af.asr.saltgenerator.data.repository;

import java.util.List;

import af.asr.saltgenerator.data.model.SaltEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The Interface SaltRepository.
 */
public interface SaltRepository extends JpaRepository<SaltEntity, Long> {

	/**
	 * Count by id in list of ids.
	 *
	 * @param ids the ids
	 * @return the long
	 */
	Long countByIdIn(List<Long> ids);
}
