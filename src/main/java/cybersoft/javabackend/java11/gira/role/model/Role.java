package cybersoft.javabackend.java11.gira.role.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import cybersoft.javabackend.java11.gira.commondata.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "gira_role")
@Getter
@Setter
public class Role extends AbstractEntity {
	
	@NotBlank(message = "Role name cannot be blank.")
	@Length(min = 4, max = 50, message = "Role name length is between 4 and 50.")
	private String roleName;
	
	@NotBlank(message = "Role description cannot be blank.")
	private String description;
	
	@OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
	Set<Account> accounts;
	
	@ManyToMany(mappedBy = "roles")
	@JsonIgnore
	private Set<RoleGroup> groups = new HashSet<>();
	
	/* Helper Method */
	public Role id(Long id) {
		this.id = id;
		return this;
	}
	
	public Role addAccount(Account account) {
		this.accounts.add(account);
		return this;
	}
	
	public Role roleName(String roleName) {
		this.roleName = roleName;
		return this;
	}
	
	public Role description(String description) {
		this.description = description;
		return this;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("ROLE: " + id + " " + roleName + " " + description + " " + accounts);
	}
}
