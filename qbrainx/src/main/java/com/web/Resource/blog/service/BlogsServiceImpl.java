package com.web.resource.blog.service;


import com.web.exception.BannerNotFoundException;
import com.web.resource.blog.dto.BlogsDto;
import com.web.resource.blog.dto.BlogsImageDto;
import com.web.resource.blog.entity.BlogsImage;
import com.web.resource.blog.entity.blogs;
import com.web.resource.blog.repository.BlogsImageRepository;
import com.web.resource.blog.repository.BlogsRepository;
import lombok.extern.slf4j.Slf4j;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class BlogsServiceImpl implements BlogsService {

    @Autowired
    BlogsRepository blogsRepository;
    @Autowired
    BlogsImageRepository blogsImageRepository;
    @Autowired
    DozerBeanMapper dozerBeanMapper;


    @Override
    public List<BlogsDto> getAllList() {
        List<blogs> webinars = blogsRepository.findAll();
        return webinars.stream().map(allList -> dozerBeanMapper.map(allList, BlogsDto.class)
        ).collect(Collectors.toList());
    }

    @Override
    public BlogsDto createBlogs(BlogsDto blogsDto, MultipartFile file) throws IOException {


        BlogsImageDto imageDto = new BlogsImageDto();
        BlogsImage image = dozerBeanMapper.map(imageDto, BlogsImage.class);
        image.setFileName(file.getOriginalFilename());
        image.setData(file.getBytes());
        blogsImageRepository.save(image);

        // entity
        blogs blogs = dozerBeanMapper.map(blogsDto, blogs.class);
        blogs.setTitle(blogsDto.getTitle());
        blogs.setSubTitle(blogsDto.getSubTitle());
        blogs.setText(blogsDto.getText());
        blogs.setDate(LocalDate.now());
        blogs.setImage(image);
        blogs entity = blogsRepository.save(blogs);
        return dozerBeanMapper.map(entity, BlogsDto.class);


    }

    @Override
    public String deleteBlogs(int id) {
        try {
            blogsRepository.deleteById(id);
        } catch (BannerNotFoundException e) {
            return (e.getMessage());
        }
        return "Deleted Successfully";
    }

    @Override
    public BlogsDto updateBlogsDetails(int id, BlogsDto blogsDto, MultipartFile file) throws IOException {
        blogs blogs = blogsRepository.findById(id).get();


        if (!(file == null)) {
            BlogsImage image = blogs.getImage();
            image.setFileName(file.getOriginalFilename());
            image.setData(file.getBytes());
            blogsImageRepository.save(image);


        }

        blogs.setTitle(blogsDto.getTitle());
        blogs.setSubTitle(blogsDto.getSubTitle());
        blogs.setText(blogsDto.getText());
        blogs.setDate(LocalDate.now());

        blogsRepository.save(blogs);
        return dozerBeanMapper.map(blogs, BlogsDto.class);

    }


    @Override
    public BlogsDto getBlogsById(int id) {

        blogs blogs = blogsRepository.findById(id)
                .orElseThrow(() -> new BannerNotFoundException(id));
        return dozerBeanMapper.map(blogs, BlogsDto.class);


    }
}

