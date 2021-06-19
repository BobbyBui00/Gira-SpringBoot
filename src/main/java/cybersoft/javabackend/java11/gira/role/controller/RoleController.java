package cybersoft.javabackend.java11.gira.role.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cybersoft.javabackend.java11.gira.commondata.model.ResponseHandler;
import cybersoft.javabackend.java11.gira.commondata.model.ResponseObject;
import cybersoft.javabackend.java11.gira.role.dto.CreateRoleDTO;
import cybersoft.javabackend.java11.gira.role.dto.RoleWithAccountsDTO;
import cybersoft.javabackend.java11.gira.role.model.Role;
import cybersoft.javabackend.java11.gira.role.service.RoleService;
import cybersoft.javabackend.java11.gira.utils.ErrorsUtils;
import cybersoft.javabackend.java11.gira.utils.ListUtils;

@RestController
@RequestMapping("/api/role")
public class RoleController {
	@Autowired
	private RoleService _service;
	
	@GetMapping("")
	public ResponseEntity<Object> findAll() {
		List<Role> roles = _service.findAll();
		
		if(roles == null)
			return ResponseHandler.getResponse("There is no data.", HttpStatus.OK);

		return ResponseHandler.getResponse(roles, HttpStatus.OK);
	}
	
	@GetMapping("/{role-name}")
	public ResponseEntity<Object> findByRoleName(@PathVariable("role-name") String roleName) {
		List<Role> roles = _service.findByRoleName(roleName);
		
		if(roles.isEmpty())
			return ResponseHandler.getResponse("There is no data.", HttpStatus.OK);
		
		return ResponseHandler.getResponse(roles, HttpStatus.OK);
	}
	
	@GetMapping("/description/{role-name}")
	public ResponseEntity<Object> findRoleWithoutBlankDescription(@PathVariable("role-name") String roleName) {
		List<Role> roles = _service.findRoleWithoutBlankDescription(roleName);
		if(roles.isEmpty())
			return ResponseHandler.getResponse("There is no data.", HttpStatus.OK);
		
		return ResponseHandler.getResponse(roles, HttpStatus.OK);
	}
	
	@GetMapping("/with-account")
	public ResponseEntity<Object> findRoleWithAccountInfo() {
		List<RoleWithAccountsDTO> roles = _service.findRoleWithAccountInfo();
		
		if(roles.isEmpty())
			return ResponseHandler.getResponse("There is no data.", HttpStatus.OK);
		
		return ResponseHandler.getResponse(roles, HttpStatus.OK);
	}
	
	@GetMapping("/description")
	public ResponseEntity<Object> findByDescription(@RequestParam("description") String description) {
		List<Role> roles = _service.findByDescription(description);
		
		if(roles.isEmpty())
			return ResponseHandler.getResponse("There is no data.", HttpStatus.OK);
		
		return ResponseHandler.getResponse(roles, HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<Object> save(@Valid @RequestBody CreateRoleDTO dto, BindingResult errors) {
		if(errors.hasErrors())
			return ResponseHandler.getResponse(errors, HttpStatus.BAD_REQUEST);
		
		Role addRole = _service.save(dto);
		
		return ResponseHandler.getResponse(addRole, HttpStatus.OK);
	}
	
	@PutMapping("/{role-id}")
	public ResponseEntity<Object> updateRoleInfo(@Valid @RequestBody CreateRoleDTO dto, @PathVariable("role-id") Long roleId, BindingResult errors) {
		
		if(errors.hasErrors())
			return ResponseHandler.getResponse(errors, HttpStatus.BAD_REQUEST);
		
		Role updatedRole = _service.updateRoleInfo(dto, roleId);
		
		return ResponseHandler.getResponse(updatedRole, HttpStatus.OK);
	}
	
	@DeleteMapping("/{role-id}")
	public ResponseEntity<Object> deleteRole(@PathVariable("role-id") Long roleId) {
		
		if(roleId == null) 
			return ResponseHandler.getResponse("Role id must be provided.", HttpStatus.BAD_REQUEST);
		
		_service.deleteById(roleId);
		
		return ResponseHandler.getResponse(HttpStatus.OK);
	}
	
}