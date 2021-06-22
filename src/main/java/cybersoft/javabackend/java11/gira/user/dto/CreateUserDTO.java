package cybersoft.javabackend.java11.gira.user.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import cybersoft.javabackend.java11.gira.user.util.UserStatus;
import cybersoft.javabackend.java11.gira.user.validation.annotation.ConfirmPassword;
import cybersoft.javabackend.java11.gira.user.validation.annotation.UniqueEmail;
import cybersoft.javabackend.java11.gira.user.validation.annotation.UniqueUsername;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ConfirmPassword(message = "{user.confirm-password}")
public class CreateUserDTO {
	@NotBlank(message = "{user.username.notblank}")
	@Size(min = 3, max = 20, message = "{user.username.size}")
	@UniqueUsername
	private String username;
	
	@NotBlank(message = "{user.password.not-blank}")
	@Size(min = 3, max = 100, message = "{user.password.size}")
	private String password;
	
	@NotBlank
	private String confirmPassword;
	
	@NotBlank
	@Email
	@UniqueEmail
	private String email;
	
	@NotBlank
	private String fullname;
	
	@NotBlank
	private String displayName;
	
	@NotNull
	private UserStatus status;

	
}
