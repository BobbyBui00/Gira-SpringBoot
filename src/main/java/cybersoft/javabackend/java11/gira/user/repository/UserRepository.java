package cybersoft.javabackend.java11.gira.user.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.stereotype.Repository;

import cybersoft.javabackend.java11.gira.user.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	int countByUsername(String username);

	@EntityGraph(attributePaths = {"roleGroups"}, type = EntityGraphType.FETCH)
			
	Optional<User> findByUsername(String username);

	int countByEmail(String email);
	
}
