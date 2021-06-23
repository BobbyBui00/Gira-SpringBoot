package cybersoft.javabackend.java11.gira.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import cybersoft.javabackend.java11.gira.commondata.GenericServiceImpl;
import cybersoft.javabackend.java11.gira.user.dto.CreateUserDTO;
import cybersoft.javabackend.java11.gira.user.model.User;
import cybersoft.javabackend.java11.gira.user.repository.UserRepository;

@Service
public class UserServiceImpl extends GenericServiceImpl<User, Long> implements UserService {
	@Autowired
	private UserRepository repository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	@Override
	public User save(CreateUserDTO dto) {
		User user = new User();
		user.username(dto.getUsername())
			.password(passwordEncoder.encode(dto.getPassword()))
			.email(dto.getEmail())
			.displayName(dto.getDisplayName())
			.fullname(dto.getFullname())
			.status(dto.getStatus());

		return repository.save(user);
	}
	// done


	@Override
	public boolean isTakenUsername(String username) {
		return repository.countByUsername(username) >= 1;
	}


	@Override
	public boolean isTakenEmail(String email) {
		return repository.countByEmail(email) >= 1;
	}

}