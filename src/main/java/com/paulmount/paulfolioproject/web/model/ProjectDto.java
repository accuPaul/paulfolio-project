package com.paulmount.paulfolioproject.web.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created 2024-01-22 Paul M
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProjectDto {

    @Null
    private UUID id;
    @NotBlank
    private String projectName;
    @NotBlank
    private String description;
    private String link;
    private String githubLink;
    private List<TagDto> tags;

    void addTag(String tag) {
        if (this.tags == null) this.tags = new ArrayList<>();
        this.tags.add(TagDto.builder().name(tag).build());
    }
    void addTag(TagDto tag) {
        if (this.tags == null) this.tags = new ArrayList<>();
        this.tags.add(tag);
    }
}
