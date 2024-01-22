package com.paulmount.paulfolioproject.services;

import com.paulmount.paulfolioproject.model.TagDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TagServiceImpl implements TagService {
    @Override
    public TagDto getTagById(UUID tagId) {
        return TagDto.builder()
                .id(tagId)
                .name("JAVA")
                .build();
    }
}
