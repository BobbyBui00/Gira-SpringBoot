package cybersoft.javabackend.java11.gira.role.service;

import java.util.List;

import javax.validation.Valid;

import cybersoft.javabackend.java11.gira.commondata.GenericService;
import cybersoft.javabackend.java11.gira.role.dto.CreateRoleDTO;
import cybersoft.javabackend.java11.gira.role.dto.RoleWithAccountsDTO;
import cybersoft.javabackend.java11.gira.role.model.Account;
import cybersoft.javabackend.java11.gira.role.model.Role;

public interface RoleService extends GenericService<Role, Long> {
	
	List<Role> findByRoleName(String roleName);
	List<Role> findByDescription(String description);
	List<Role> findRoleWithNotNullDescription(String roleName);
	List<RoleWithAccountsDTO> findRoleWithAccountInfo();
	Role addAccount(@Valid Account account, Long roleId);
	Role updateRoleInfo(@Valid CreateRoleDTO dto, Long roleId);
}
