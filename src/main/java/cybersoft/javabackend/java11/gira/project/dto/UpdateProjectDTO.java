package cybersoft.javabackend.java11.gira.project.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.Size;

import cybersoft.javabackend.java11.gira.project.validation.annotation.ExistsProjectType;
import cybersoft.javabackend.java11.gira.project.validation.annotation.ExistsUser;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@FromDateToDate(fromDate="startDate", toDate="endDate")
public class UpdateProjectDTO {
	
	@Size(min = 3, max = 100, message = "{project.name.size}")
	private String name;
	
	@Size(min = 3, max = 7, message = "{project.code.size}")
	private String code;
	
	private String description;
	
	private String icon;
	
	private LocalDateTime startDate;
	
	private LocalDateTime endDate;
	
	@ExistsUser(message = "Owner does not exist.")
	private String owner;

	@ExistsUser(message = "Manager does not exist.")
	private String manager;

	@ExistsProjectType
	private Long projectTypeId;
}
