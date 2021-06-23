package cybersoft.javabackend.java11.gira.project.model;

import java.util.Set;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Workflow {

	private String name;
	
	private String description;
	
	private Project project;
	
	private Set<WorkflowNode> nodes;
	
	private Set<WorkflowLink> links;
}
