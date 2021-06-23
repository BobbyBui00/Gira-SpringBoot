package cybersoft.javabackend.java11.gira.project.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkflowNode {
	
	private String name;
	
	private String code;
	
	private int nodeOder;
	
	private Workflow workflow;
}
