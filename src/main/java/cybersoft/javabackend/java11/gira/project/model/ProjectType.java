package cybersoft.javabackend.java11.gira.project.model;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProjectType {
	
	private String name;
	
	private String code;
	
	private String description;
	
	private Set<Project> projects;
}
