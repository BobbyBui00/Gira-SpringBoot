package cybersoft.javabackend.java11.gira.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cybersoft.javabackend.java11.gira.user.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	int countByUsername(String username);
	
}
