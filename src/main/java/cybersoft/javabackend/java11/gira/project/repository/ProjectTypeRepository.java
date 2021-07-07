package cybersoft.javabackend.java11.gira.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cybersoft.javabackend.java11.gira.project.model.ProjectType;

@Repository
public interface ProjectTypeRepository extends JpaRepository<ProjectType, Long>{

}
