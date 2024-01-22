package com.paulmount.paulfolioproject.controller;

import com.paulmount.paulfolioproject.model.TagDto;
import com.paulmount.paulfolioproject.services.TagService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RequestMapping("/api/tag")
@RestController
public class TagController {

    private final TagService tagService;

    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @GetMapping("/{tagId}")
    public ResponseEntity<TagDto> getTag(@PathVariable("tagId") UUID tagId) {
        return new ResponseEntity<>(tagService.getTagById(tagId), HttpStatus.OK);
    }
}
