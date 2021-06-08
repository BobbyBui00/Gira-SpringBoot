package cybersoft.javabackend.java11.gira.role.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import cybersoft.javabackend.java11.gira.commondata.AbstractEntity;

@Entity
@Table(name = "account")
public class Account extends AbstractEntity {

	@NotBlank(message = "username can't be blank.")
	@Length(min = 4, max = 50, message = "username length must between 4 to 50")
	private String username;
	
	@NotBlank(message = "password can't be blank.")
	@Length(min = 4, max = 50, message = "username length must between 4 to 50")
	private String password;
	
	@NotBlank(message = "email can't be blank.")
	private String email;
	
	@Column(name = "role_id", insertable = false, updatable = false)
	private Long roleId;
	
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "role_id")
	private Role role;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	
}
