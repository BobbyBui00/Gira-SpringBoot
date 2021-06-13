package cybersoft.javabackend.java11.gira.user.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cybersoft.javabackend.java11.gira.commondata.model.ResponseHandler;
import cybersoft.javabackend.java11.gira.user.dto.CreateUserDTO;
import cybersoft.javabackend.java11.gira.user.model.User;
import cybersoft.javabackend.java11.gira.user.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping("")
	public ResponseEntity<Object> findAllUser() {
		List<User> users = service.findAll();
		
		if(users.isEmpty())
			return ResponseHandler.getResponse("There is no data.", HttpStatus.OK);
		
		return ResponseHandler.getResponse(users, HttpStatus.OK);
	}
	
	@PostMapping("")
	public ResponseEntity<Object> addNewUser(@Valid @RequestBody CreateUserDTO dto, BindingResult errors) {
		
		if(errors.hasErrors())
			return ResponseHandler.getResponse(errors, HttpStatus.BAD_REQUEST);
		
		User newUser = service.save(dto);
		
		return ResponseHandler.getResponse(newUser, HttpStatus.OK);
	}
}
