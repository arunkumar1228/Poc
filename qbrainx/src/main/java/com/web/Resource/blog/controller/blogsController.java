package com.web.resource.blog.controller;


import com.web.resource.blog.dto.BlogsDto;
import com.web.resource.blog.service.BlogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping(value = "v1/Blogs")
public class blogsController {
    @Autowired
    BlogsService blogsService;

    @GetMapping("/getAll")
    public ResponseEntity<List<BlogsDto>> allBlogsList() {
        List<BlogsDto> list = blogsService.getAllList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping(value = "/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public BlogsDto createBlogs(@RequestParam("file") MultipartFile file, BlogsDto blogsDto) throws IOException {

        return blogsService.createBlogs(blogsDto, file);


    }

    @DeleteMapping("/deleteById")
    public String deleteBlogsById(@RequestParam int id) {
        return blogsService.deleteBlogs(id);
    }

    @GetMapping("/getById")
    public BlogsDto getBlogsById(@RequestParam int id) {
        return blogsService.getBlogsById(id);
    }


    @PutMapping(value = "/updateDetailsById", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<BlogsDto> updateBlogsDetails(@RequestParam int id, @RequestParam(value = "file", required = false) MultipartFile file, BlogsDto blogsDto) throws IOException {
        return new ResponseEntity<>(blogsService.updateBlogsDetails(id, blogsDto, file), HttpStatus.OK);
    }


}
