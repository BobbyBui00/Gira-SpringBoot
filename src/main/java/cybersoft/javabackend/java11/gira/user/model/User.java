package cybersoft.javabackend.java11.gira.user.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import cybersoft.javabackend.java11.gira.commondata.model.AbstractEntity;
import cybersoft.javabackend.java11.gira.role.model.RoleGroup;
import cybersoft.javabackend.java11.gira.user.util.UserStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "gira_user")
public class User extends AbstractEntity{
	@NotBlank(message = "{user.username.not-blank}")
	@Size(min = 3, max = 50, message = "{user.username.size}")
	@Column(unique = true)
	private String username;
	
	@NotBlank
	private String password;
	
	@NotBlank
	@Email
	@Column(unique = true)
	private String email;
	
	@NotBlank
	private String fullname;
	
	@NotBlank
	private String displayName;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	private UserStatus status;
	
	private String avatar;
	
	private String facebookUrl;
	private String job;
	private String department;
	private String hobbies;
	
	@ManyToMany(mappedBy = "users", fetch = FetchType.EAGER)
	@JsonIgnore
	private Set<RoleGroup> roleGroups = new HashSet<>();
	
	public User username(String username) {
		this.username = username;
		return this;
	}
	
	public User password(String password) {
		this.password = password;
		return this;
	}
	
	public User email(String email) {
		this.email = email;
		return this;
	}
	
	public User fullname(String fullname) {
		this.fullname = fullname;
		return this;
	}
	
	public User displayName(String displayName) {
		this.displayName = displayName;
		return this;
	}
	
	public User status(UserStatus status) {
		this.status = status;
		return this;
	}
}