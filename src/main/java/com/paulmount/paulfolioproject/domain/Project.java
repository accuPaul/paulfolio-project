package com.paulmount.paulfolioproject.domain;

import com.paulmount.paulfolioproject.web.model.TagDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

/**
 * *  Created by paulm on 1/24/2024
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Project {
    private UUID id;
    private String projectName;
    private String description;
    private String link;
    private String githubLink;
    private List<TagDto> tags;
}
