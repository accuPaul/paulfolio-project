package com.paulmount.paulfolioproject.web.controller;

import com.paulmount.paulfolioproject.services.ProjectService;
import com.paulmount.paulfolioproject.web.model.ProjectDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RequestMapping("/api/project")
@RestController
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<ProjectDto> getProject(@PathVariable("projectId") UUID projectId) {
        return new ResponseEntity<>(projectService.getProjectById(projectId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity handlePost(@Valid @RequestBody ProjectDto projectDto) {
        ProjectDto savedProject = projectService.saveNewProject(projectDto);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", "/api/project/" + savedProject.getId().toString());
        return new ResponseEntity(httpHeaders, HttpStatus.CREATED);
    }

    @PutMapping("/{projectId}")
    public ResponseEntity handleUpdate(@PathVariable("projectId") UUID projectId,@Valid @RequestBody ProjectDto projectDto) {
        projectService.updateProject(projectId, projectDto);

        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{projectId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void handleDelete(@PathVariable("projectId") UUID projectId) {
        projectService.deleteProjectById(projectId);
    }

}
