package cybersoft.javabackend.java11.gira.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

import cybersoft.javabackend.java11.gira.commondata.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Getter 
@Setter
@Entity
@Table(name = "gira_project_workflow_link")
public class WorkflowLink extends AbstractEntity {
	
	private String transition;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "source")
	private WorkflowNode source; // linkBy
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "destination")
	private WorkflowNode destination; // linkTo
	
	@ManyToOne(fetch = FetchType.LAZY)
	@NotNull
	private Workflow workflow;
	
}
