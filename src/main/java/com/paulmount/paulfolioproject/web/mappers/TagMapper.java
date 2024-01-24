package com.paulmount.paulfolioproject.web.mappers;

import com.paulmount.paulfolioproject.domain.Tag;
import com.paulmount.paulfolioproject.web.model.TagDto;
import org.mapstruct.Mapper;

/**
 * *  Created by paulm on 1/24/2024
 */
@Mapper
public interface TagMapper {
    TagDto tagToTagDto(Tag tag);

    Tag tagDtoToTag(TagDto tagDto);
}
