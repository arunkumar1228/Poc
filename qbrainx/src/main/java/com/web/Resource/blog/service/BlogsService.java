package com.web.resource.blog.service;



import com.web.resource.blog.dto.BlogsDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface BlogsService {
    List<BlogsDto> getAllList();

    BlogsDto createBlogs(BlogsDto blogsDto, MultipartFile file) throws IOException;

    String deleteBlogs(int id);

    BlogsDto updateBlogsDetails(int id, BlogsDto blogsDto, MultipartFile file) throws IOException;

    BlogsDto getBlogsById(int id) ;

}
