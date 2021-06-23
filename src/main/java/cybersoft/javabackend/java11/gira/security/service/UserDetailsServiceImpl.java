package cybersoft.javabackend.java11.gira.security.service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import cybersoft.javabackend.java11.gira.role.model.RoleGroup;
import cybersoft.javabackend.java11.gira.security.dto.UserDetailsDTO;
import cybersoft.javabackend.java11.gira.user.model.User;
import cybersoft.javabackend.java11.gira.user.repository.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO: đọc thông tin user và role group từ database
		// load user từ database
		Optional<User> user = repository.findByUsername(username);
		
		if(!user.isPresent())
			throw new UsernameNotFoundException("Username is invalid.");
		
		Set<GrantedAuthority> authorities = getAuthorities(user.get().getRoleGroups());
		
		return new UserDetailsDTO(user.get().getUsername(), user.get().getPassword(), authorities);
	}

	private Set<GrantedAuthority> getAuthorities(Set<RoleGroup> roleGroups) {
		Set<GrantedAuthority> authorities = new HashSet<>();
		
		Iterator<RoleGroup> iterator = roleGroups.iterator();
		
		while(iterator.hasNext()) 
			authorities.add(new SimpleGrantedAuthority(iterator.next().getGroupName()));
			
		return authorities;
	}

}