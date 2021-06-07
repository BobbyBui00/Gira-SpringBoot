package cybersoft.javabackend.java11.gira.role.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cybersoft.javabackend.java11.gira.role.model.Role;
import cybersoft.javabackend.java11.gira.role.model.RoleGroup;
import cybersoft.javabackend.java11.gira.role.repository.RoleGroupRepository;

@Service
public class RoleGroupServiceImpl implements RoleGroupService{
	@Autowired
	private RoleGroupRepository repository;
	
	@Override
	public List<RoleGroup> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<RoleGroup> findById(Long id) {
		return repository.findById(id);
	}

	@Override
	public RoleGroup save(RoleGroup group) {
		return repository.save(group);
	}

	@Override
	public RoleGroup update(RoleGroup group) {
		return repository.save(group);
	}

	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	@Override
	public RoleGroup addRole(@Valid Role role, Long groupId) {
		RoleGroup group = repository.getOne(groupId);
		
		group.addRole(role);
		
		return repository.save(group);
	}

}
