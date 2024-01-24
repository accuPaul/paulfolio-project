package com.paulmount.paulfolioproject.controller;

import com.paulmount.paulfolioproject.model.TagDto;
import com.paulmount.paulfolioproject.services.TagService;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping
    public ResponseEntity<TagDto> saveTag(@Valid @RequestBody TagDto tagDto) {
        TagDto savedTag = tagService.saveNewTag(tagDto);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Location","/api/tag/"+savedTag.getId().toString());
        return new ResponseEntity<>(tagService.saveNewTag(tagDto), headers, HttpStatus.CREATED);
    }

    @PutMapping("/{tagId}")
    public ResponseEntity<TagDto> updateTag(@PathVariable("tagId") UUID tagId, @Valid @RequestBody TagDto tagDto) {
        TagDto updatedTag = tagService.updateTag(tagId, tagDto);

        return new ResponseEntity<>(updatedTag, HttpStatus.OK);
    }

    @DeleteMapping("/{tagId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTag(@PathVariable("tagId") UUID tagId) {
        tagService.deleteTag(tagId);
    }

}
