package cybersoft.javabackend.java11.gira.project.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import cybersoft.javabackend.java11.gira.commondata.model.ResponseHandler;
import cybersoft.javabackend.java11.gira.project.dto.CreateProjectDTO;
import cybersoft.javabackend.java11.gira.project.dto.UpdateProjectDTO;
import cybersoft.javabackend.java11.gira.project.model.Project;
import cybersoft.javabackend.java11.gira.project.service.interfaceFile.ProjectService;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/project")
public class ProjectController {

	@Autowired
	private ProjectService service;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@GetMapping("")
	public ResponseEntity<Object> findAllProjects() {
		logger.debug("=========START FIND ALL PROJECTS==========");
		List<Project> projects = service.findAll();
		logger.debug("=========FETCHED PROJECTS==========");
		logger.debug("Results: {}", projects);
		if (projects.isEmpty())
			return ResponseHandler.getResponse("There is no data", HttpStatus.OK);

		return ResponseHandler.getResponse(projects, HttpStatus.OK);
	}
	
	@GetMapping("/{type-id}")
	public ResponseEntity<Object> findAllProjectType(@PathVariable("type-id") Long typeId) {
		
		List<Project> projects = service.findAllByType(typeId);
		
		if(projects.isEmpty()) 
			return ResponseHandler.getResponse("There is no data", HttpStatus.OK);
		
		return ResponseHandler.getResponse(projects, HttpStatus.OK);
	}
 	

	@PostMapping("")
	public ResponseEntity<Object> createNewProject(@Valid @RequestBody CreateProjectDTO dto, BindingResult bindingResult) {
		
		if(bindingResult.hasErrors()) 
			return ResponseHandler.getResponse(bindingResult, HttpStatus.BAD_REQUEST);
		
		
		Project project = service.save(dto);
		return ResponseHandler.getResponse(project, HttpStatus.OK);
	}

	@PutMapping("/{project-id}")
	public ResponseEntity<Object> updateProject(@PathVariable("project-id") Long id, @RequestBody UpdateProjectDTO dto, BindingResult bindingResult) {
		
		if(id == null)
			return ResponseHandler.getResponse(HttpStatus.BAD_REQUEST);
		
		if(bindingResult.hasErrors())
			return ResponseHandler.getResponse(bindingResult, HttpStatus.BAD_REQUEST);
			
		Project updateResult = service.update(dto, id);
		
		return ResponseHandler.getResponse(HttpStatus.BAD_REQUEST);
	}
 
}
