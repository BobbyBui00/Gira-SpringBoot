package cybersoft.javabackend.java11.gira.project.service.implement;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;


import cybersoft.javabackend.java11.gira.commondata.GenericServiceImpl;
import cybersoft.javabackend.java11.gira.project.dto.CreateProjectDTO;
import cybersoft.javabackend.java11.gira.project.dto.UpdateProjectDTO;
import cybersoft.javabackend.java11.gira.project.model.Project;
import cybersoft.javabackend.java11.gira.project.model.ProjectType;
import cybersoft.javabackend.java11.gira.project.repository.ProjectRepository;
import cybersoft.javabackend.java11.gira.project.repository.ProjectTypeRepository;
import cybersoft.javabackend.java11.gira.project.service.interfaceFile.ProjectService;
import cybersoft.javabackend.java11.gira.user.model.User;
import cybersoft.javabackend.java11.gira.user.repository.UserRepository;
import cybersoft.javabackend.java11.gira.utils.MapDtoToModel;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ProjectServiceImpl extends GenericServiceImpl<Project, Long> implements ProjectService {
	
	private ProjectRepository repository;
	private MapDtoToModel<Object, Project> mapper;
	private ProjectTypeRepository projectTypeRepository;
	private UserRepository userRepository;

	@Override
	public Project save(CreateProjectDTO dto) {
		
		Project model = new Project();
		model = mapper.map(dto, model);
		
		ProjectType type = projectTypeRepository.getOne(dto.getProjectTypeId());
		model.setProjectType(type);
		
		Optional<User> ownerOpt = userRepository.findByUsername(dto.getOwner());
		if(ownerOpt.isPresent()) 
			model.setOwner(ownerOpt.get());
		
		Optional<User> managerOpt = userRepository.findByUsername(dto.getManager());
		if(managerOpt.isPresent()) 
			model.setManager(managerOpt.get());
		
		return repository.save(model);
	}

	@Override
	public Project update(UpdateProjectDTO dto, Long id) {
		// TODO Auto-generated method stub
		Project project = repository.getOne(id);
		project = mapper.map(dto, project);
		
		ProjectType type = projectTypeRepository.getOne(dto.getProjectTypeId());
		project.setProjectType(type);
		
		Optional<User> ownerOpt = userRepository.findByUsername(dto.getOwner());
		if(ownerOpt.isPresent()) 
			project.setOwner(ownerOpt.get());
		
		Optional<User> managerOpt = userRepository.findByUsername(dto.getManager());
		if(managerOpt.isPresent()) 
			project.setManager(managerOpt.get());
		
		return repository.save(project);
	}

	@Override
	public List<Project> findAllByType(Long typeId) {
		// TODO Auto-generated method stub
		ProjectType type = projectTypeRepository.getOne(typeId);
		
		return repository.findAllByType(type);
	}

}

/* 
 * 1.7 -> 1.8:
 * 	- allow to write body method in interface with two keywords default and static
 * */

