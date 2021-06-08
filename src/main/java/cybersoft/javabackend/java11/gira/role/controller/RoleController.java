package cybersoft.javabackend.java11.gira.role.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cybersoft.javabackend.java11.gira.role.dto.CreateRoleDTO;
import cybersoft.javabackend.java11.gira.role.dto.RoleWithAccountsDTO;
import cybersoft.javabackend.java11.gira.role.model.Role;
import cybersoft.javabackend.java11.gira.role.service.RoleService;

@RestController
@RequestMapping("/api/role")
public class RoleController {
	@Autowired
	private RoleService _service;
	
	@GetMapping("")
	public ResponseEntity<Object> findAll(){
		List<Role> roles = _service.findAll();
		
		if(roles == null)
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<>(roles, HttpStatus.OK);
	}
	
	@GetMapping("/{role-name}")
	public ResponseEntity<Object> findByRoleName(@PathVariable("role-name") String roleName){
		List<Role> roles = _service.findByRoleName(roleName);
		
		if(roles.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<>(roles, HttpStatus.OK);
	}
	
	@GetMapping("/description/{role-name}")
	public ResponseEntity<Object> findRoleWithoutBlankDescription(@PathVariable("role-name") String roleName){
		List<Role> roles = _service.findRoleWithNotNullDescription(roleName);
		
		if(roles.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<>(roles, HttpStatus.OK);
	}
	
	@GetMapping("/with-account")
	public ResponseEntity<List<RoleWithAccountsDTO>> findRoleWithAccountInfo(){
		List<RoleWithAccountsDTO> roles = _service.findRoleWithAccountInfo();
		
		if(roles.isEmpty())
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<>(roles, HttpStatus.OK);
	}
	
	@GetMapping("/description")
	public ResponseEntity<Object> findByDescription(@RequestParam("description") String description){
		List<Role> roles = _service.findByDescription(description);
		
		if(roles.isEmpty())
			return new ResponseEntity<Object>(HttpStatus.NO_CONTENT);
		
		return new ResponseEntity<Object>(roles, HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Object> save(@Valid @RequestBody CreateRoleDTO dto, BindingResult errors){
		if(errors.hasErrors())
			return new ResponseEntity<>(errors.getAllErrors(), HttpStatus.BAD_REQUEST);
		
		Role role = new Role()
				.roleName(dto.roleName)
				.description(dto.description);	
		Role addRole = _service.save(role);
		System.out.println(addRole.toString());
		return new ResponseEntity<>(addRole, HttpStatus.CREATED);
	}
	
	
}