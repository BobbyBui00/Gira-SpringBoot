package cybersoft.javabackend.java11.gira.project.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;

import cybersoft.javabackend.java11.gira.utils.DateUtils;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProjectDTO {
	
	@NotBlank(message = "{project.name.not-blank}")
	@Size(min = 3, max = 100, message = "{project.name.size}")
	@Column(unique = true)
	private String name;
	
	@NotBlank(message = "{project.code.not-blank}")
	@Size(min = 3, max = 7, message = "{projecy.code.size}")
	@Column(unique = true)
	private String code;
	
	@NotBlank(message = "{project.description.not-blank}")
	private String description;
	
	private String icon;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateUtils.DATE_FORMAT)
	@DateTimeFormat(pattern = DateUtils.DATE_FORMAT)
	private LocalDateTime startDate;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = DateUtils.DATE_FORMAT)
	@DateTimeFormat(pattern = DateUtils.DATE_FORMAT)
	private LocalDateTime endDate;
	
	@NotNull
	private Long projectTypeId;
	
	private String owner;
	
	private String manager;
}
