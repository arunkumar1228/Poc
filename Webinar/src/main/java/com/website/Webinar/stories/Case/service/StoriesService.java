package com.website.Webinar.stories.Case.service;





import com.itextpdf.text.DocumentException;
import com.website.Webinar.stories.Case.dto.RegisterDto;
import com.website.Webinar.stories.Case.dto.StoriesDto;
import com.website.Webinar.stories.Case.entity.Register;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface StoriesService {
    List<StoriesDto> getAllList();

    StoriesDto createStories(StoriesDto storiesDto, MultipartFile file) throws IOException;


    ResponseEntity<byte[]> createRegister(RegisterDto registerDto) throws DocumentException;

}
