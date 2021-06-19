package cybersoft.javabackend.java11.gira.role.service;

import java.util.List;

import javax.validation.Valid;

import cybersoft.javabackend.java11.gira.commondata.GenericService;
import cybersoft.javabackend.java11.gira.role.dto.CreateRoleDTO;
import cybersoft.javabackend.java11.gira.role.dto.RoleWithAccountsDTO;
import cybersoft.javabackend.java11.gira.role.model.Account;
import cybersoft.javabackend.java11.gira.role.model.Role;

public interface RoleService {
	void save(Role role);
	List<Role> findAll();
	List<Role> findByRoleName(String roleName);
	List<Role> findByDescription(String description);
	List<Role> findRoleWithoutBlankDescription(String roleName);
	List<RoleWithAccountsDTO> findRoleWithAccountInfo();
	Role updateRoleInfo(CreateRoleDTO dto, Long roleId);
	void deleteById(Long roleId);
	Role save(CreateRoleDTO dto);

}
