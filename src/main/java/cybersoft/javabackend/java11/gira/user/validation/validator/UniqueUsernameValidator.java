package cybersoft.javabackend.java11.gira.user.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import cybersoft.javabackend.java11.gira.user.service.UserService;
import cybersoft.javabackend.java11.gira.user.validation.annotation.UniqueUsername;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

	@Autowired
	private UserService service;
	
	private String message;
	
	@Override
	public void initialize(UniqueUsername constraintAnnotation) {
		this.message = constraintAnnotation.message();
		
	}
	
	@Override
	public boolean isValid(String username, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		boolean isTakenUsername = service.isTakenUsername(username);
		
		if (!isTakenUsername)
			return true;
		
		context.buildConstraintViolationWithTemplate(message)
				.addConstraintViolation()
				.disableDefaultConstraintViolation();
		return false;
	}

}
