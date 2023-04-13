package com.web.home.weare.service;

import com.web.exception.BannerNotFoundException;
import com.web.home.weare.dto.FeedBackDto;
import com.web.home.weare.dto.FeedBackImageDto;
import com.web.home.weare.entity.FeedBackImageEntity;
import com.web.home.weare.entity.FeedbackEntity;
import com.web.home.weare.repository.FeedBackImageRepository;
import com.web.home.weare.repository.FeedBackRepository;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class FeedBackServiceImpl implements FeedBackService {

    @Autowired
    FeedBackImageRepository feedBackImageRepository;
    @Autowired
    FeedBackRepository feedBackRepository;
    @Autowired
    DozerBeanMapper dozerBeanMapper;


    @Override
    public List<FeedBackDto> getAllList() {
        List<FeedbackEntity> feedbackEntities = feedBackRepository.findAll();
        return feedbackEntities.stream().map(feedbackEntity -> dozerBeanMapper.map(feedbackEntity, FeedBackDto.class)
        ).collect(Collectors.toList());
    }

    @Override
    public FeedBackDto createFeedback(FeedBackDto feedBackDto, MultipartFile file) throws IOException {
        FeedBackImageDto imageDto = new FeedBackImageDto();
        FeedBackImageEntity image = dozerBeanMapper.map(imageDto, FeedBackImageEntity.class);
        image.setFileName(file.getOriginalFilename());
        image.setData(file.getBytes());
        feedBackImageRepository.save(image);
        FeedbackEntity feedbackEntity = dozerBeanMapper.map(feedBackDto, FeedbackEntity.class);
        feedbackEntity.setDescription(feedBackDto.getDescription());
        feedbackEntity.setLink(feedBackDto.getLink());
        feedbackEntity.setFeedBackImage(image);
        FeedbackEntity feedback = feedBackRepository.save(feedbackEntity);
        FeedBackDto backDto = dozerBeanMapper.map(feedback, FeedBackDto.class);
        return backDto;
    }

    @Override
    public String deleteFeedback(int id) {
        try {
            feedBackRepository.deleteById(id);
        } catch (BannerNotFoundException e) {
            return (e.getMessage());
        }
        return "Deleted Successfully";
    }

    @Override
    public FeedBackDto updateFeedbackDetails(int id, FeedBackDto feedBackDto, MultipartFile file) throws IOException {
        FeedbackEntity feedbackEntity = feedBackRepository.findById(id).get();

        if (!(file == null)) {

            FeedBackImageEntity image = feedbackEntity.getFeedBackImage();
            image.setFileName(file.getOriginalFilename());
            image.setData(file.getBytes());
            feedBackImageRepository.save(image);
        }

        feedbackEntity.setDescription(feedBackDto.getDescription());
        feedbackEntity.setLink(feedBackDto.getLink());
        feedBackRepository.save(feedbackEntity);

        FeedBackDto dto = dozerBeanMapper.map(feedbackEntity, FeedBackDto.class);
        return dto;
    }

    @Override
    public FeedBackDto getFeedbackById(int id) {
        FeedbackEntity feedbackEntity = feedBackRepository.findById(id)
                .orElseThrow(() -> new BannerNotFoundException(id));
        FeedBackDto dto = dozerBeanMapper.map(feedbackEntity, FeedBackDto.class);

        return dto;
    }
}
