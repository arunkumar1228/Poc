package com.web.Resource.webinar.controller;


import com.web.Resource.webinar.dto.WebinarDto;
import com.web.Resource.webinar.service.WebinarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "v1/webinar")
public class WebinarController {
    @Autowired
    WebinarService webinarService;

    @GetMapping("/getAll")
    public ResponseEntity<List<WebinarDto>> allBannerList() {
        List<WebinarDto> list = webinarService.getAllList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping(value = "/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public WebinarDto createWebinar(@RequestParam("file") MultipartFile file, WebinarDto webinarDto) throws IOException {

        return webinarService.createWebinar(webinarDto, file);


    }

    @DeleteMapping("/deleteById")
    public String deleteBannerById(@RequestParam int id) {
        return webinarService.deleteWebinar(id);
    }

    @GetMapping("/getById")
    public WebinarDto getWebinarById(@RequestParam int id) {
        return webinarService.getWebinarById(id);
    }


    @PutMapping(value = "/updateDetailsById", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<WebinarDto> updateWebinarDetails(@RequestParam int id, @RequestParam(value = "file", required = false) MultipartFile file, WebinarDto webinarDto) {
        return new ResponseEntity<>(webinarService.updateWebinarDetails(id, webinarDto, file), HttpStatus.OK);
    }


}
