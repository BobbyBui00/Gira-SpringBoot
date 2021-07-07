package cybersoft.javabackend.java11.gira.project.service.interfaceFile;

import java.util.List;

import cybersoft.javabackend.java11.gira.commondata.GenericService;
import cybersoft.javabackend.java11.gira.project.dto.CreateProjectDTO;
import cybersoft.javabackend.java11.gira.project.dto.UpdateProjectDTO;
import cybersoft.javabackend.java11.gira.project.model.Project;

public interface ProjectService extends GenericService<Project, Long> {

	Project save(CreateProjectDTO dto);

	Project update(UpdateProjectDTO dto, Long id);

	List<Project> findAllByType(Long typeId);

}
