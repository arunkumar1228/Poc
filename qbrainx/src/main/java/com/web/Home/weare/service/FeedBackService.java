package com.web.Home.weare.service;



import com.web.Home.weare.dto.FeedBackDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;



public interface FeedBackService {
    List<FeedBackDto> getAllList();

    FeedBackDto createFeedback(FeedBackDto feedBackDto,MultipartFile file) throws IOException;

    String deleteFeedback(int id) throws IOException;

    FeedBackDto updateFeedbackDetails(int id,FeedBackDto feedBackDto,MultipartFile file) throws IOException;
    FeedBackDto  getFeedbackById(int id);

}
