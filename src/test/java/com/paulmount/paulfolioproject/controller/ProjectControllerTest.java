package com.paulmount.paulfolioproject.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paulmount.paulfolioproject.model.ProjectDto;
import com.paulmount.paulfolioproject.model.TagDto;
import com.paulmount.paulfolioproject.services.ProjectService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(ProjectController.class)
public class ProjectControllerTest {

    @MockBean
    ProjectService projectService;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    ProjectDto validProject;

    @Before
    public void setUp() {
        validProject = ProjectDto.builder()
                .id(UUID.randomUUID())
                .projectName("Test Name")
                .description("Test description")
                .tags(new ArrayList<>(Arrays.asList(TagDto.builder().id(UUID.randomUUID()).name("JAVA").build(),
                        TagDto.builder().id(UUID.randomUUID()).name("TEST").build())))
                .build();
    }
    @Test
    public void getProject() throws Exception {
        given(projectService.getProjectById(any(UUID.class))).willReturn(validProject);

        mockMvc.perform(get("/api/project/" + validProject.getId().toString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void handlePost() throws Exception {
        ProjectDto projectDto = validProject;
        projectDto.setId(null);
        ProjectDto savedProject = ProjectDto.builder().id(UUID.randomUUID()).build();
        String projectJson = objectMapper.writeValueAsString(projectDto);

        given(projectService.saveNewProject(any())).willReturn(savedProject);

        mockMvc.perform(post("/api/project")
                .contentType(MediaType.APPLICATION_JSON)
                .content(projectJson))
                .andExpect(status().isCreated());
    }

    @Test
    public void handleUpdate() throws Exception {
        ProjectDto projectDto = validProject;
        projectDto.setId(null);
        String projectJson = objectMapper.writeValueAsString(projectDto);

        mockMvc.perform(put("/api/project/"+UUID.randomUUID())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(projectJson))
                .andExpect(status().isNoContent());

        then(projectService).should().updateProject(any(), any());
    }
}