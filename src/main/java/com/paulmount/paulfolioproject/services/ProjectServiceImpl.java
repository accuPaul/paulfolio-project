package com.paulmount.paulfolioproject.services;

import com.paulmount.paulfolioproject.model.ProjectDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

@Slf4j
@Service
public class ProjectServiceImpl implements ProjectService {
    @Override
    public ProjectDto getProjectById(UUID projectId) {
        return ProjectDto.builder().id(UUID.randomUUID())
                .projectName("Paul Folio")
                .description("The Portfolio you're looking at...")
                .tags(Arrays.asList("Java","Spring Boot","Microservice"))
                .build();
    }

    @Override
    public ProjectDto saveNewProject(ProjectDto projectDto) {
        return ProjectDto.builder()
                .id(UUID.randomUUID())
                .projectName(projectDto.getProjectName())
                .description(projectDto.getDescription())
                .link(projectDto.getLink())
                .githubLink(projectDto.getGithubLink())
                .tags(projectDto.getTags())
                .build();
    }

    @Override
    public void updateProject(UUID projectId, ProjectDto projectDto) {
        //todo implement updater
    }

    @Override
    public void deleteProjectById(UUID projectId) {
        log.debug("Deleting project "+projectId.toString());
    }

}
