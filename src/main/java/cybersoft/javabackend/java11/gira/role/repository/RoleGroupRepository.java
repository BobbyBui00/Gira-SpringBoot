package cybersoft.javabackend.java11.gira.role.repository;

import cybersoft.javabackend.java11.gira.role.model.RoleGroup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleGroupRepository extends JpaRepository<RoleGroup, Long>{

}
