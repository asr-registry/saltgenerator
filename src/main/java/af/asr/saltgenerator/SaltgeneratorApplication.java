package af.asr.saltgenerator;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class SaltgeneratorApplication {

	public static void main(String[] args) {
		SpringApplication.run(SaltgeneratorApplication.class, args);
	}

}
