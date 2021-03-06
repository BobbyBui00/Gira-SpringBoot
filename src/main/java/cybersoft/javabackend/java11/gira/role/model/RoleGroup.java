package cybersoft.javabackend.java11.gira.role.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import cybersoft.javabackend.java11.gira.commondata.model.AbstractEntity;
import cybersoft.javabackend.java11.gira.user.model.User;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "gira_role_group")
@Getter
@Setter
public class RoleGroup extends AbstractEntity {

	@NotBlank(message = "Role name cannot be blank.")
	@Length(min = 4, max = 50, message = "Role name length is between {0} to {1}.")
	private String groupName;
	
	@NotBlank(message = "Role description cannot be blank.")
	private String description;
	
	/*
	 * Quan he many to many 
	 * 	- su dung Set, khong su dung List
	 *  - khong su dung cascade REMOVE va ALL
	 *  - tao bang join table o doi tuong chinh
	 */
	@ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinTable(name = "gira_group_role_link",
				joinColumns = @JoinColumn(name = "group_id"),
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();
	
	
	@ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@JoinTable(name = "gira_user_role_group",
				joinColumns = @JoinColumn(name = "role_group_id"),
				inverseJoinColumns = @JoinColumn(name = "user_id"))
	@JsonIgnore
	private Set<User> users = new HashSet<>();
	
	/*
	 * Helper methods 
	 *  - de dam bao du lieu luon duoc thong nhat giua cac doi tuong
	 * 
	 */
	public RoleGroup addRole(Role role) {
		this.roles.add(role);
		role.getGroups().add(this);
		return this;
	}
	
	public RoleGroup name(String name) {
		this.groupName = name;
		return this;
	}
	
	public RoleGroup description(String description) {
		this.description = description;
		return this;
	}
	
	
}
