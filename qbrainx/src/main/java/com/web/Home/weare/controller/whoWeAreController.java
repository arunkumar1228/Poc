package com.web.home.weare.controller;


import com.web.home.weare.dto.FeedBackDto;
import com.web.home.weare.service.FeedBackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping(value = "v1/whoWeAre")
public class whoWeAreController {
    @Autowired
    FeedBackService feedBackService;


    @GetMapping("/getAll")
    public ResponseEntity<List<FeedBackDto>> allFeedbackList() {
        List<FeedBackDto> list = feedBackService.getAllList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping(value = "/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<FeedBackDto> uploadImage(@RequestParam("file") MultipartFile file, FeedBackDto feedBackDto) throws IOException {
        return new ResponseEntity<>(feedBackService.createFeedback(feedBackDto, file), HttpStatus.OK);
    }

    @DeleteMapping("/deleteById")
    public String deleteFeedbackById(@RequestParam int id) throws IOException {
        return feedBackService.deleteFeedback(id);
    }

    @GetMapping("/getById")
    public FeedBackDto getFeedback(@RequestParam int id) {
        return feedBackService.getFeedbackById(id);
    }

    @PutMapping(value = "/updateDetailsById", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<FeedBackDto> uploadImage(@RequestParam int id, @RequestParam(value = "file",required = false) MultipartFile file, FeedBackDto feedBackDto) throws IOException {
        return new ResponseEntity<>(feedBackService.updateFeedbackDetails(id, feedBackDto, file), HttpStatus.OK);
    }
}

