package cybersoft.javabackend.java11.gira.role.dto;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

public class CreateRoleGroupDTO {
	@NotBlank(message = "Role name can't be blank.")
	@Length(min = 4, max = 50, message = "Role name length is between {0} and {1}.")
	public String groupName;
	
	@NotBlank(message = "Role description can't be blank.")
	public String description;
}
