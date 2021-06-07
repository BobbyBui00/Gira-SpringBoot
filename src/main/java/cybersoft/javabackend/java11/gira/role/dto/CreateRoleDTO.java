package cybersoft.javabackend.java11.gira.role.dto;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

public class CreateRoleDTO {
	@NotBlank(message = "Role name cannot be blank")
	@Length(min = 4, max = 50, message = "Role name length is between 4 and 50")
	public String roleName;
	
	@NotBlank(message = "Role description cannot be blank")
	public String description;
}


