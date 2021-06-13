package cybersoft.javabackend.java11.gira.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.stereotype.Component;

@Configuration
@EnableJpaAuditing
public class JpaConfig {
	
	@Component
	public interface GenericRepository<T, ID> extends JpaRepository<T, ID> {
		
	}

}
