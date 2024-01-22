package com.paulmount.paulfolioproject.services;

import com.paulmount.paulfolioproject.model.TagDto;
import org.springframework.stereotype.Service;

import java.util.UUID;

public interface TagService {
    TagDto getTagById(UUID tagId);
}
