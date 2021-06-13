package cybersoft.javabackend.java11.gira.user.validation.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import cybersoft.javabackend.java11.gira.user.validation.validator.UniqueUsernameValidator;

@Constraint(validatedBy = UniqueUsernameValidator.class)
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)	
public @interface UniqueUsername {
	
	public String message() default "Username is already exist.";
	
	public Class<?>[] groups() default {};
	
	public Class<? extends Payload>[] payload() default {}; 
}
