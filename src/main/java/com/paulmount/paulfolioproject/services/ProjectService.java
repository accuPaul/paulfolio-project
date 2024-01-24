package com.paulmount.paulfolioproject.services;

import com.paulmount.paulfolioproject.web.model.ProjectDto;

import java.util.UUID;

public interface ProjectService {
    ProjectDto getProjectById(UUID projectId);

    ProjectDto saveNewProject(ProjectDto projectDto);

    void updateProject(UUID projectId, ProjectDto projectDto);

    void deleteProjectById(UUID projectId);
}
