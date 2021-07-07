package cybersoft.javabackend.java11.gira.role.repository;

import cybersoft.javabackend.java11.gira.role.model.RoleGroup;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleGroupRepository extends JpaRepository<RoleGroup, Long>{
	
	@Override
	@EntityGraph(attributePaths = {"roles"}, type = EntityGraphType.FETCH)
	public List<RoleGroup> findAll();
	
	@EntityGraph(attributePaths = {"users"}, type = EntityGraphType.FETCH)
	@Query(value = "SELECT g FROM RoleGroup g")
	public List<RoleGroup> findAllWithUsers();
	
	@EntityGraph(attributePaths = {"roles", "users"}, type = EntityGraphType.FETCH)
	@Query(value = "SELECT g FROM RoleGroup g")
	public List<RoleGroup> findAllWithRoles();
}
