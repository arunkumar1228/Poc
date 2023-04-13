package com.web.resource.stories.service;


import com.web.exception.BannerNotFoundException;
import com.web.resource.stories.dto.StoriesDto;
import com.web.resource.stories.entity.Stories;
import com.web.resource.stories.repository.StoriesRepository;
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
public class StoriesServiceImpl implements StoriesService {

    @Autowired
    StoriesRepository storiesRepository;
    @Autowired
    DozerBeanMapper dozerBeanMapper;


    @Override
    public List<StoriesDto> getAllList() {
        List<Stories> webinars = storiesRepository.findAll();
        return webinars.stream().map(allList -> dozerBeanMapper.map(allList, StoriesDto.class)
        ).collect(Collectors.toList());
    }

    @Override
    public StoriesDto createStories(StoriesDto storiesDto, MultipartFile file) throws IOException {


        // entity
        Stories Stories = dozerBeanMapper.map(storiesDto, Stories.class);
        Stories.setId(Stories.getId());
        Stories.setTitle(storiesDto.getTitle());
        Stories.setSubTitle(storiesDto.getSubTitle());
        Stories.setText(storiesDto.getText());
        Stories.setDate(LocalDate.now());
        Stories.setFileName(file.getOriginalFilename());
        Stories.setData(file.getBytes());

        Stories entity = storiesRepository.save(Stories);
        return dozerBeanMapper.map(entity, StoriesDto.class);


    }

    @Override
    public String deleteStories(int id) {
        try {
            storiesRepository.deleteById(id);
        } catch (BannerNotFoundException e) {
            return (e.getMessage());
        }
        return "Deleted Successfully";
    }

    @Override
    public StoriesDto updateStoriesDetails(int id, StoriesDto storiesDto, MultipartFile file) throws IOException {
        Stories stories = storiesRepository.findById(id).get();


        if (!(file == null)) {

            stories.setFileName(file.getOriginalFilename());
            stories.setData(file.getBytes());
        }
        stories.setTitle(storiesDto.getTitle());
        stories.setSubTitle(storiesDto.getSubTitle());
        stories.setText(storiesDto.getText());
        stories.setDate(LocalDate.now());


        storiesRepository.save(stories);
        return dozerBeanMapper.map(stories, StoriesDto.class);

    }


    @Override
    public StoriesDto getStoriesById(int id) {

        Stories Stories = storiesRepository.findById(id)
                .orElseThrow(() -> new BannerNotFoundException(id));
        return dozerBeanMapper.map(Stories, StoriesDto.class);

    }
}

