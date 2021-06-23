package cybersoft.javabackend.java11.gira.user.service;

import javax.validation.Valid;

import cybersoft.javabackend.java11.gira.commondata.GenericService;
import cybersoft.javabackend.java11.gira.user.dto.CreateUserDTO;
import cybersoft.javabackend.java11.gira.user.model.User;


public interface UserService extends GenericService<User, Long>{

	User save(@Valid CreateUserDTO dto);

	boolean isTakenUsername(String username);
	
	boolean isTakenEmail(String email);
		
}
