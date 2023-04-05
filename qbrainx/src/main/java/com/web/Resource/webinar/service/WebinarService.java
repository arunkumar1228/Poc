package com.web.Resource.webinar.service;




import com.web.Resource.webinar.dto.WebinarDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface WebinarService {
    List<WebinarDto> getAllList();

    WebinarDto createWebinar(WebinarDto webinarDto, MultipartFile file) throws IOException;

    String deleteWebinar(int id);

    WebinarDto updateWebinarDetails(int id, WebinarDto webinarDto, MultipartFile file);

    WebinarDto getWebinarById(int id) ;

}
