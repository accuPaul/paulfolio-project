package com.paulmount.paulfolioproject.web.mappers;/* Created by paulm on 1/24/2024*/

import com.paulmount.paulfolioproject.domain.Project;
import com.paulmount.paulfolioproject.web.model.ProjectDto;
import org.mapstruct.Mapper;

@Mapper
public interface ProjectMapper {

    ProjectDto projectToProjectDto(Project project);

    Project projectDtoToProject(ProjectDto projectDto);
}
