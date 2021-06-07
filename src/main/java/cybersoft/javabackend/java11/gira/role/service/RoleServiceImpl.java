package cybersoft.javabackend.java11.gira.role.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cybersoft.javabackend.java11.gira.role.dto.RoleWithAccountsDTO;
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


}
