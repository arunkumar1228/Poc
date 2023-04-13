package com.web.resource.stories.controller;


import com.web.resource.stories.dto.StoriesDto;
import com.web.resource.stories.service.StoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "v1/Stories")
public class StoriesController {
    @Autowired
    StoriesService storiesService;

    @GetMapping("/getAll")
    public ResponseEntity<List<StoriesDto>> allStoriesList() {
        List<StoriesDto> list = storiesService.getAllList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping(value = "/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public StoriesDto createStories(@RequestParam("file") MultipartFile file, StoriesDto storiesDto) throws IOException {

        return storiesService.createStories(storiesDto, file);


    }

    @DeleteMapping("/deleteById")
    public String deleteStoriesById(@RequestParam int id) {
        return storiesService.deleteStories(id);
    }

    @GetMapping("/getById")
    public StoriesDto getStoriesById(@RequestParam int id) {
        return storiesService.getStoriesById(id);
    }


    @PutMapping(value = "/updateDetailsById", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<StoriesDto> updateStoriesDetails(@RequestParam int id, @RequestParam(value = "file", required = false) MultipartFile file, StoriesDto storiesDto) throws IOException {
        return new ResponseEntity<>(storiesService.updateStoriesDetails(id, storiesDto, file), HttpStatus.OK);
    }


}
