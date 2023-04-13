package com.web.home.weOffers.controller;



import com.web.home.weOffers.dto.NewsDto;
import com.web.home.weOffers.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "v1/weOffers")
public class weOffersController {
    @Autowired
    NewsService weOffersService;


    @GetMapping("/getAll")
    public ResponseEntity<List<NewsDto>> allNewsList() {
        List<NewsDto> list = weOffersService.getAllNews();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping(value = "/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
        public ResponseEntity<NewsDto> uploadImage(@RequestParam("file") MultipartFile file, NewsDto weOffersDto) throws IOException {
        return new ResponseEntity<>(weOffersService.createNews(weOffersDto, file), HttpStatus.OK);
    }

    @DeleteMapping("/deleteById")
    public String deleteNewsById(@RequestParam int id) throws IOException {
        return weOffersService.deleteNews(id);
    }

    @GetMapping("/getById")
    public NewsDto getNews(@RequestParam int id) throws IOException {
        return weOffersService.getNewsById(id);
    }

    @PutMapping(value = "/updateById", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<NewsDto> uploadImage(@RequestParam int id, @RequestParam(value = "file",required = false) MultipartFile file, NewsDto weOffersDto) throws IOException {
        return new ResponseEntity<>(weOffersService.updateNewsDetails(id, weOffersDto, file), HttpStatus.OK);
    }
}

