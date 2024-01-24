package com.paulmount.paulfolioproject.services;

import com.paulmount.paulfolioproject.web.model.TagDto;

import java.util.UUID;

public interface TagService {
    TagDto getTagById(UUID tagId);

    TagDto saveNewTag(TagDto tagDto);

    TagDto updateTag(UUID tagId, TagDto tagDto);

    void deleteTag(UUID tagId);
}
