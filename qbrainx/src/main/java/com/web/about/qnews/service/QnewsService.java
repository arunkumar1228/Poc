package com.web.about.qnews.service;






import com.web.about.qnews.dto.QnewsDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface QnewsService {
    List<QnewsDto> getAllList();

    QnewsDto createQnews(QnewsDto qnewsDto, MultipartFile file) throws IOException;

    String deleteQnewsById(int id);


    QnewsDto updateQnewsDetails(int id, QnewsDto qnewsDto, MultipartFile file) throws IOException;

    QnewsDto getQnewsById(int id) ;

}
