package com.paulmount.paulfolioproject.services;

import com.paulmount.paulfolioproject.web.model.ProjectDto;
import com.paulmount.paulfolioproject.web.model.TagDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

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
                .tags(Arrays.asList(TagDto.builder().id(UUID.randomUUID()).name("Java").build(),
                        TagDto.builder().id(UUID.randomUUID()).name("Spring Boot").build(),
                        TagDto.builder().id(UUID.randomUUID()).name("Microservice").build()))
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
