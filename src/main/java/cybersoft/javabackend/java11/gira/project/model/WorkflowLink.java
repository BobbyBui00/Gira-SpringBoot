package cybersoft.javabackend.java11.gira.project.model;

import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
public class WorkflowLink {
	
	private WorkflowNode linkBy; // source
	
	private WorkflowNode linkTo; // destination
	
	private String transition;
	
	private Workflow workflow;
	
}
