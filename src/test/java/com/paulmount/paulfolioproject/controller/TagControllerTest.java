package com.paulmount.paulfolioproject.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.paulmount.paulfolioproject.services.TagService;
import com.paulmount.paulfolioproject.web.controller.TagController;
import com.paulmount.paulfolioproject.web.model.TagDto;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(TagController.class)
public class TagControllerTest {

    @MockBean
    TagService tagService;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    TagDto validTag;

    @Before
    public void setup() {
        validTag = TagDto.builder().id(UUID.randomUUID()).name("TEST").build();
    }

    @Test
    public void getTag() throws Exception {
        given(tagService.getTagById(any(UUID.class))).willReturn(validTag);

        mockMvc.perform(get("/api/tag/" + validTag.getId().toString()).accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void saveTag() throws Exception {
        TagDto tagDto = validTag;
        tagDto.setId(null);
        TagDto savedTag = TagDto.builder().id(UUID.randomUUID()).build();
        String tagJson = objectMapper.writeValueAsString(tagDto);

        given(tagService.saveNewTag(any())).willReturn(savedTag);

        mockMvc.perform(post("/api/tag")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(tagJson))
                .andExpect(status().isCreated());
    }

    @Test
    public void updateTag() throws Exception {
        TagDto tagDto = validTag;
        String tagJson = objectMapper.writeValueAsString(tagDto);

        mockMvc.perform(put("/api/tag/"+validTag.getId())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(tagJson))
                .andExpect(status().isOk());

        then(tagService).should().updateTag(any(), any());
    }

    @Test
    public void deleteTag() throws Exception {
        mockMvc.perform(delete("/api/tag/"+validTag.getId()))
                .andExpect(status().isNoContent());
    }
}