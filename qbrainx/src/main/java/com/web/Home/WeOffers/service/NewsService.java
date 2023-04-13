package com.web.home.weOffers.service;
import com.web.home.weOffers.dto.NewsDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


public interface NewsService {
    List<NewsDto> getAllNews();

    NewsDto createNews(NewsDto newsDto,MultipartFile file) throws IOException;

    String deleteNews(int id) throws IOException;

    NewsDto updateNewsDetails(int id,NewsDto newsDto,MultipartFile file) throws IOException;
    NewsDto getNewsById(int id) throws IOException;
}
