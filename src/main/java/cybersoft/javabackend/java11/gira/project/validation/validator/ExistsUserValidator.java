package cybersoft.javabackend.java11.gira.project.validation.validator;

import java.util.Optional;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import cybersoft.javabackend.java11.gira.project.validation.annotation.ExistsUser;
import cybersoft.javabackend.java11.gira.user.model.User;
import cybersoft.javabackend.java11.gira.user.repository.UserRepository;
import lombok.AllArgsConstructor;


public class ExistsUserValidator implements ConstraintValidator<ExistsUser, String> {
	private String message;
	private UserRepository userRepository;
	
	
	
	public ExistsUserValidator(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public void initialize(ExistsUser target) {
		this.message = target.message();
	}
	
	@Override
	public boolean isValid(String username, ConstraintValidatorContext context) {
	
		Optional<User> userOpt = userRepository.findByUsername(username);
		
		if(userOpt.isPresent())
			return true;
		
		context.buildConstraintViolationWithTemplate(message)
				.addConstraintViolation()
				.disableDefaultConstraintViolation();
		
		return false;
		
	}

}
