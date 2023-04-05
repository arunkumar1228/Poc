package com.web.Home.weare.service;

import com.web.Exception.BannerNotFoundException;
import com.web.Home.weare.dto.FeedBackDto;
import com.web.Home.weare.dto.FeedBackImageDto;
import com.web.Home.weare.entity.FeedBackImageEntity;
import com.web.Home.weare.entity.FeedbackEntity;
import com.web.Home.weare.repository.FeedBackImageRepository;
import com.web.Home.weare.repository.FeedBackRepository;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
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
        feedbackEntity.setId(feedBackDto.getId());
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
        } catch ( BannerNotFoundException e) {
            return (e.getMessage());
        }
        return "Deleted Successfully";
    }

    @Override
    public FeedBackDto updateFeedbackDetails(int id, FeedBackDto feedBackDto, MultipartFile file) throws IOException {
        Optional<FeedbackEntity> feedback = feedBackRepository.findById(id);
        FeedbackEntity feedbackEntity = feedback.get();

        if (feedback.isPresent()) {

            if (file == null) {
                feedbackEntity.setId(feedBackDto.getId());
                feedbackEntity.setDescription(feedBackDto.getDescription());
                feedbackEntity.setLink(feedBackDto.getLink());
                feedBackRepository.save(feedbackEntity);
            } else {
                FeedBackImageEntity image = feedback.get().getFeedBackImage();
                image.setFileName(file.getOriginalFilename());
                image.setData(file.getBytes());
                feedBackImageRepository.save(image);
            }
        }
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
