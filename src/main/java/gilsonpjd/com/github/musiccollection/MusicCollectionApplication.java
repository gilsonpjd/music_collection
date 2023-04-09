package gilsonpjd.com.github.musiccollection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaRepositories("repository")
@EntityScan("model")
@ComponentScan("controller")
@ComponentScan(basePackages = {"service"})

public class MusicCollectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusicCollectionApplication.class, args);
	}

}
