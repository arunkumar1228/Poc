package com.web.Home.WeOffers.service;

import com.web.Exception.BannerNotFoundException;
import com.web.Home.WeOffers.dto.NewsDto;
import com.web.Home.WeOffers.dto.NewsImageDto;
import com.web.Home.WeOffers.entity.NewsEntity;
import com.web.Home.WeOffers.entity.NewsImageEntity;
import com.web.Home.WeOffers.repository.NewsImageRepository;
import com.web.Home.WeOffers.repository.NewsRepository;
import org.dozer.DozerBeanMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    NewsRepository newsRepository;
    @Autowired
    DozerBeanMapper dozerBeanMapper;
    @Autowired
    NewsImageRepository newsImageRepository;

    @Override
    public List<NewsDto> getAllNews() {
        List<NewsEntity> newsEntityList = newsRepository.findAll();
        return newsEntityList.stream().map(allNewsEntity -> dozerBeanMapper.map(allNewsEntity, NewsDto.class)
        ).collect(Collectors.toList());
    }

    @Override
    public NewsDto createNews(NewsDto newsDto, MultipartFile file) throws IOException {
        NewsImageDto imagedto = new NewsImageDto();
        NewsImageEntity image = dozerBeanMapper.map(imagedto, NewsImageEntity.class);
        image.setImageName(file.getOriginalFilename());
        image.setData(file.getBytes());
        newsImageRepository.save(image);
        NewsEntity newsEntity = dozerBeanMapper.map(newsDto, NewsEntity.class);
        newsEntity.setId(newsDto.getId());
        newsEntity.setTitle(newsDto.getTitle());
        newsEntity.setDescription(newsDto.getDescription());
        newsEntity.setLink(newsDto.getLink());
        newsEntity.setNewsImage(image);
        NewsEntity news = newsRepository.save(newsEntity);
        NewsDto dto = dozerBeanMapper.map(news, NewsDto.class);
        return dto;
    }

    @Override
    public String deleteNews(int id) {
        try {
            newsRepository.deleteById(id);
        } catch (Exception e) {
            return (e.getMessage());
        }
        return "Deleted Successfully";
    }

    @Override
    public NewsDto updateNewsDetails(int id, NewsDto newsDto, MultipartFile file) throws IOException {
        Optional<NewsEntity> news = newsRepository.findById(id);
        NewsEntity newsEntity = news.get();
        if (news.isPresent()) {
            if (file == null) {
                newsEntity.setId(newsDto.getId());
                newsEntity.setTitle(newsDto.getTitle());
                newsEntity.setDescription(newsDto.getDescription());
                newsEntity.setLink(newsDto.getLink());
                newsRepository.save(newsEntity);
            } else {
                NewsImageEntity image = news.get().getNewsImage();
                image.setImageName(file.getOriginalFilename());
                image.setData(file.getBytes());
                newsImageRepository.save(image);
            }

        }
        NewsDto dto = dozerBeanMapper.map(newsEntity, NewsDto.class);
        return dto;
    }

    @Override
    public NewsDto getNewsById(int id)  {
        NewsEntity newsEntity = newsRepository.findById(id)
                .orElseThrow(() -> new BannerNotFoundException(id));
        NewsDto dto = dozerBeanMapper.map(newsEntity, NewsDto.class);

        return dto;
    }
}



