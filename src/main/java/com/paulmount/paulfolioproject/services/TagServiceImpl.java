package com.paulmount.paulfolioproject.services;

import com.paulmount.paulfolioproject.web.model.TagDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 *  Service implementation to update tags
 */
@Slf4j
@Service
public class TagServiceImpl implements TagService {
    @Override
    public TagDto getTagById(UUID tagId) {
        return TagDto.builder()
                .id(tagId)
                .name("JAVA")
                .build();
    }

    @Override
    public TagDto saveNewTag(TagDto tagDto) {
        return TagDto.builder()
                .id(UUID.randomUUID())
                .name(tagDto.getName())
                .build();
    }

    @Override
    public TagDto updateTag(UUID tagId, TagDto tagDto) {
        return TagDto.builder().id(tagId).name(tagDto.getName()).build();
    }

    public void deleteTag(UUID tagId) {
        log.debug("Deleted tag with id "+tagId.toString());
    }


}
