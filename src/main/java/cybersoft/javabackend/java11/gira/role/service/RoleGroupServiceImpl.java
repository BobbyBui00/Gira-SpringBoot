package cybersoft.javabackend.java11.gira.role.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cybersoft.javabackend.java11.gira.role.model.Role;
import cybersoft.javabackend.java11.gira.role.model.RoleGroup;
import cybersoft.javabackend.java11.gira.role.repository.RoleGroupRepository;
import cybersoft.javabackend.java11.gira.user.model.User;
import cybersoft.javabackend.java11.gira.user.repository.UserRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class RoleGroupServiceImpl implements RoleGroupService {

	private RoleGroupRepository repository;
	private UserRepository userRepository;
	
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
		
		/*
		 *  getOne() => lay tham chieu toi object
		 *  
		 *  findById() => sinh ra cau query lay tu database len 
		 *  
		 *  => lau hon
  		 * 
		 */
		
		group.addRole(role);
		
		return repository.save(group);
	}

	@Override
	public List<RoleGroup> findAllWithUsers() {
		// TODO Auto-generated method stub
		return repository.findAllWithUsers();
	}

	@Override
	public List<RoleGroup> findAllWithRoles() {
		// TODO Auto-generated method stub
		return repository.findAllWithRoles();
	}

	@Override
	public RoleGroup addUser(String username, Long id) {
		// TODO Auto-generated method stub
		RoleGroup group = repository.getOne(id);
		Optional<User> userOpt = userRepository.findByUsername(username);
		
		if(userOpt.isPresent()) {
			group.getUsers().add(userOpt.get());
			userOpt.get().getRoleGroups().add(group);
		}
			
			
		return repository.save(group);
	}

}
