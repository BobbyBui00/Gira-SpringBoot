package cybersoft.javabackend.java11.gira.user.service;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cybersoft.javabackend.java11.gira.commondata.GenericServiceImpl;
import cybersoft.javabackend.java11.gira.user.dto.CreateUserDTO;
import cybersoft.javabackend.java11.gira.user.model.User;
import cybersoft.javabackend.java11.gira.user.repository.UserRepository;

@Service
public class UserServiceImpl extends GenericServiceImpl<User, Long> implements UserService {

	@Autowired
	private UserRepository repository;
	
	@Override
	public User save(@Valid CreateUserDTO dto) {
		// TODO Auto-generated method stub
		User newUser = new User();
		newUser	.username(dto.getUsername())
				.password(dto.getPassword())
				.email(dto.getEmail())
				.displayName(dto.getDisplayName())
				.fullname(dto.getFullname())
				.status(dto.getStatus());
		
		return repository.save(newUser);
	}

	@Override
	public boolean isTakenUsername(String username) {
		// TODO Auto-generated method stub
		
		return repository.countByUsername(username) >= 1;
	}

	@Override
	public boolean isTakenEmail(String email) {
		// TODO Auto-generated method stub
		return repository.countByEmail(email) >= 1;
	}

}
