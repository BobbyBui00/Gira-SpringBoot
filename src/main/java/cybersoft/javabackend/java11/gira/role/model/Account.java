package cybersoft.javabackend.java11.gira.role.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import cybersoft.javabackend.java11.gira.commondata.model.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "gira_account")
@Getter
@Setter
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
	
	
}
