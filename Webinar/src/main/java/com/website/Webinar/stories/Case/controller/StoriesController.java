package com.website.Webinar.stories.Case.controller;


import com.itextpdf.text.DocumentException;
import com.website.Webinar.stories.Case.dto.RegisterDto;
import com.website.Webinar.stories.Case.dto.StoriesDto;
import com.website.Webinar.stories.Case.service.StoriesService;
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

    @PostMapping(value = "/createRegister" ,produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> uploadImage(@RequestBody RegisterDto registerDto) throws DocumentException {
        return  storiesService.createRegister(registerDto);
    }

}
