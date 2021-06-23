package cybersoft.javabackend.java11.gira.project.model;

import java.time.LocalDateTime;

import cybersoft.javabackend.java11.gira.user.model.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Project {

	private String name;
	
	private String code;
	
	private User user;
	
	private User manager;
	
	private String description;
	
	private String icon;
	
	private LocalDateTime startDate;
	
	private LocalDateTime endDate;
	
	private ProjectType projectType;
	
	private Workflow workflow;
}
