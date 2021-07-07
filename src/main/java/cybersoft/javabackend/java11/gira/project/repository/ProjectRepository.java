package cybersoft.javabackend.java11.gira.project.repository;

import java.util.List;

import javax.persistence.FetchType;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.EntityGraph.EntityGraphType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cybersoft.javabackend.java11.gira.project.model.Project;
import cybersoft.javabackend.java11.gira.project.model.ProjectType;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {

	// ad-hoc entity graph 
	@Override
	@EntityGraph(attributePaths = {"owner.roleGroups.roles", "manager.roleGroups", "projectType", "workflows"}, type = EntityGraphType.FETCH)
	public List<Project> findAll();
	
	// HQL 
	/*
	 * EntityGraph: can use query statement written using HQL
	 * EntityGraph: cannot user with query native
	 */
	@EntityGraph(attributePaths = {"owner.roleGroups.roles", "manager.roleGroups", "projectType", "workflows"}, type = EntityGraphType.FETCH)
	@Query(value = "SELECT p FROM Project p WHERE p.projectType = ?1")
	public List<Project> findAllByType(ProjectType type);
	
	@Query(value = "SELECT p FROM Project p JOIN FETCH p.owner WHERE p.projectType = ?1")
	public List<Project> findAllByTypeJoinFetch(ProjectType type);
	
	/*
	 * only use JOIN FETCH 
	 */
	
	public List<Project> findAllByProjectType(ProjectType type);
	

	
}
