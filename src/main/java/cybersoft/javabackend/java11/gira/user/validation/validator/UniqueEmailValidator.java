package cybersoft.javabackend.java11.gira.user.validation.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import cybersoft.javabackend.java11.gira.user.service.UserService;
import cybersoft.javabackend.java11.gira.user.validation.annotation.UniqueEmail;

public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, String> {
	@Autowired
	private UserService service;
	
	private String message;
	
	@Override
	public void initialize(UniqueEmail constraintAnnotation) {
		this.message = constraintAnnotation.message();
	}
	
	@Override
	public boolean isValid(String email, ConstraintValidatorContext context) {
		boolean isTakenEmail = service.isTakenEmail(email);
		
		if(!isTakenEmail)
			return true;
		
		context.buildConstraintViolationWithTemplate(message)
			.addConstraintViolation()
			.disableDefaultConstraintViolation();
		
		return false;
	}

}
