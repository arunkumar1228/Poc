package com.web.resource.stories.service;




import com.web.resource.stories.dto.StoriesDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface StoriesService {
    List<StoriesDto> getAllList();

    StoriesDto createStories(StoriesDto storiesDto, MultipartFile file) throws IOException;

    String deleteStories(int id);

    StoriesDto updateStoriesDetails(int id, StoriesDto storiesDto, MultipartFile file) throws IOException;

    StoriesDto getStoriesById(int id) ;

}
