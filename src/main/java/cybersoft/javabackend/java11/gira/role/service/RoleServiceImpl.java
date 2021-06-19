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
	public void save(Role role) {
		_repository.save(role);
	}

	@Override
	public List<Role> findAll() {
		return _repository.findAll();
	}

	@Override
	public List<Role> findByRoleName(String roleName) {
		// TODO: bài tập
		return _repository.findByRoleName(roleName);
	}

	@Override
	public List<Role> findByDescription(String description) {
		return _repository.findByDescriptionContainingOrderByIdAsc(description);
	}

	@Override
	public List<Role> findRoleWithoutBlankDescription(String roleName) {
		return _repository.findRoleWithNotNullDescription(roleName);
	}

	@Override
	public List<RoleWithAccountsDTO> findRoleWithAccountInfo() {
		List<Role> roles = _repository.findAll();
		List<RoleWithAccountsDTO> results = mapRoleToRoleWithAccountsDTO(roles);
		System.out.println("Hold this line to debug.");
		return results;
	}
	
	private List<RoleWithAccountsDTO> mapRoleToRoleWithAccountsDTO(List<Role> roles){
		List<RoleWithAccountsDTO> results = new LinkedList<RoleWithAccountsDTO>();
		
		for (Role role : roles) {
			RoleWithAccountsDTO dto = new RoleWithAccountsDTO();
			mapRoleToDto(dto, role);
			results.add(dto);
		}
		
		return results;
	}
	
	private void mapRoleToDto(RoleWithAccountsDTO dto, Role role) {
		dto.setId(role.getId());
		dto.setRoleName(role.getRoleName());
		dto.setDescription(role.getDescription());
		dto.setAccounts(role.getAccounts());
	}

	@Override
	public Role updateRoleInfo(CreateRoleDTO dto, Long roleId) {
		Role role = _repository.getOne(roleId);
		role.roleName(dto.getRoleName())
			.description(dto.getDescription());
		
		return _repository.save(role);
	}

	@Override
	public void deleteById(Long roleId) {
		_repository.deleteById(roleId);
		
	}

	@Override
	public Role save(CreateRoleDTO dto) {
		Role role = new Role();
		role.roleName(dto.getRoleName())
			.description(dto.getDescription());
		return _repository.save(role);
	}



}
