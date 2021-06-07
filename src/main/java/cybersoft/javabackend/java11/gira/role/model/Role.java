package cybersoft.javabackend.java11.gira.role.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import cybersoft.javabackend.java11.gira.commondata.AbstractEntity;

@Entity
@Table(name = "role")
public class Role extends AbstractEntity {
	
	@NotBlank(message = "Role name cannot be blank.")
	@Length(min = 4, max = 50, message = "Role name length is between 4 and 50.")
	private String roleName;
	
	@NotBlank(message = "Role description cannot be blank.")
	private String description;
	
	@OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
	@JsonIgnore
	Set<Account> accounts;
	
	@ManyToMany(mappedBy = "roles")
	@JsonIgnore
	private Set<RoleGroup> groups = new HashSet<>();
	
	public Role roleName(String roleName) {
		this.roleName = roleName;
		return this;
	}
	
	public Role description(String description) {
		this.description = description;
		return this;
	}
	
	public Set<RoleGroup> getGroups() {
		return groups;
	}

	public void setGroups(Set<RoleGroup> groups) {
		this.groups = groups;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Account> getAccounts() {
		return accounts;
	}
	
	public void setAccounts(Set<Account> accounts) {
		this.accounts = accounts;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("ROLE: %d %s %s", id, roleName, description);
	}
}
