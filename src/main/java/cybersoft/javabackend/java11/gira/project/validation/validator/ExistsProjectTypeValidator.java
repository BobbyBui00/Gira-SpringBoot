package cybersoft.javabackend.java11.gira.project.validation.validator;

import javax.persistence.EntityNotFoundException;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import cybersoft.javabackend.java11.gira.project.model.ProjectType;
import cybersoft.javabackend.java11.gira.project.repository.ProjectTypeRepository;
import cybersoft.javabackend.java11.gira.project.validation.annotation.ExistsProjectType;

public class ExistsProjectTypeValidator implements ConstraintValidator<ExistsProjectType, Long> {
	
	private String message;
	private ProjectTypeRepository projectTypeRepository;
	
	public ExistsProjectTypeValidator(ProjectTypeRepository repository) {
		this.projectTypeRepository = repository;
	}
	
	@Override
	public void initialize(ExistsProjectType target) {
		this.message = target.message();
	}
	
	@Override
	public boolean isValid(Long projectTypeId, ConstraintValidatorContext context) {
	
		try {
			ProjectType type = projectTypeRepository.getOne(projectTypeId);
			return true;
			
		} catch (EntityNotFoundException e) {
			context.buildConstraintViolationWithTemplate(message)
					.addConstraintViolation()
					.disableDefaultConstraintViolation();
		}
		
		return false;
	}
	
	
}
