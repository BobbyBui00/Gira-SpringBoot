package cybersoft.javabackend.java11.gira.role.service;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cybersoft.javabackend.java11.gira.role.dto.CreateRoleDTO;
import cybersoft.javabackend.java11.gira.role.dto.RoleWithAccountsDTO;
import cybersoft.javabackend.java11.gira.role.model.Account;
import cybersoft.javabackend.java11.gira.role.model.Role;
import cybersoft.javabackend.java11.gira.role.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleRepository _repository;
	
	@Override
	public List<Role> findAll() {	
		return _repository.findAll();
	}

	@Override
	public List<Role> findByRoleName(String roleName) {
		// TODO bai tap
		
		return _repository.findByRoleName(roleName);
	}

	@Override
	public List<Role> findByDescription(String description) {
		// TODO Auto-generated method stub
		return _repository.findByDescriptionContainingOrderByIdAsc(description);
	}

	@Override
	public List<Role> findRoleWithNotNullDescription(String roleName) {
		// TODO Auto-generated method stub
		return _repository.findRoleWithNotNullDescription(roleName);
	}

	@Override
	public List<RoleWithAccountsDTO> findRoleWithAccountInfo() {
		// TODO Auto-generated method stub
		List<Role> roles = _repository.findAll();
		List<RoleWithAccountsDTO> results = mapRoleToRoleWithAccountsDTO(roles);
		return results;
	}
	
	private List<RoleWithAccountsDTO> mapRoleToRoleWithAccountsDTO(List<Role> roles) {
		List<RoleWithAccountsDTO> results = new LinkedList<RoleWithAccountsDTO>();
		
		for (Role role : roles ) {
			RoleWithAccountsDTO dto = new RoleWithAccountsDTO();
			mapRoleToDto(dto, role);
			results.add(dto);
			
		}
		
		return results;
	}

	private void mapRoleToDto(RoleWithAccountsDTO dto, Role role) {
		// TODO Auto-generated method stub
		dto.setId(role.getId());
		dto.setRoleName(role.getRoleName());
		dto.setDescription(role.getDescription());
		dto.setAccounts(role.getAccounts());
		
	}

	@Override
	public Optional<Role> findById(Long id) {
		// TODO Auto-generated method stub
		return _repository.findById(id);
	}

	@Override
	public Role save(Role entity) {
		return _repository.save(entity);
	}

	@Override
	public Role update(Role entity) {
		// TODO Auto-generated method stub
		return _repository.save(entity);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		_repository.deleteById(id);
	}

	@Override
	public Role addAccount(@Valid Account account, Long roleId) {
		// TODO Auto-generated method stub
		Role accountGroup = _repository.getOne(roleId);
		
		accountGroup.addAccount(account);
		
		return _repository.save(accountGroup);
	}

	@Override
	public Role updateRoleInfo(@Valid CreateRoleDTO dto, Long roleId) {
		// TODO Auto-generated method stub
		Role updatedRole = _repository.getOne(roleId);
		updatedRole.roleName(dto.roleName)
				   .description(dto.description);
		
		return _repository.save(updatedRole);
	}

	@Override
	public Role save(CreateRoleDTO dto) {
		// TODO Auto-generated method stub
		Role role = new Role()
				.roleName(dto.roleName)
				.description(dto.description);
		return role;
	}



}
