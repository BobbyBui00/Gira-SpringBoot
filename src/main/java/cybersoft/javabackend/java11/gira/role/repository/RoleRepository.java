package cybersoft.javabackend.java11.gira.role.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import cybersoft.javabackend.java11.gira.role.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
	
	List<Role> findByRoleName(String roleName);
	
	/*
	 * Viet ham tim description va sap xep theo role id tang dan
	 * Goi y: dung contain va orderBy
	 */
	
	List<Role> findByDescriptionContainingOrderByIdAsc(String description);
	
	/*
	 * dung @Query de viet cau query theo cu phap cua HQL hoac SQL thuan
	 */
	@Query("SELECT r FROM Role r WHERE r.roleName = :roleName AND r.description IS NOT NULL")
	List<Role> findRoleWithNotNullDescription(@Param("roleName") String roleName);
	
}
