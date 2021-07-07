package cybersoft.javabackend.java11.gira.project.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import cybersoft.javabackend.java11.gira.commondata.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "gira_project_workflow_node")
public class WorkflowNode extends AbstractEntity {
	
	@NotBlank(message = "{workflow-node.name.not-blank}")
	@Size(min = 3, max = 100, message = "{workflow-node.name.size}")
	private String name;
	
	private int nodeOder;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnore
	@NotNull
	private Workflow workflow;
	
	@OneToMany(mappedBy = "destination", cascade = CascadeType.ALL)
	private Set<WorkflowLink> linkBy = new HashSet<>();
	
	@OneToMany(mappedBy = "source", cascade = CascadeType.ALL)
	private Set<WorkflowLink> linkTo = new HashSet<>();
}
