package com.web.resource.webinar.service;

import com.web.exception.BannerNotFoundException;
import com.web.resource.webinar.dto.WebinarDto;
import com.web.resource.webinar.dto.WebinarsImageDto;
import com.web.resource.webinar.entity.Webinars;
import com.web.resource.webinar.repository.WebinarImageRepository;
import com.web.resource.webinar.repository.WebinarsRepository;
import com.web.resource.webinar.entity.WebinarsImage;
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
public class WebinarServiceImpl implements WebinarService {

    @Autowired
    WebinarsRepository webinarsRepository;
    @Autowired

    WebinarImageRepository webinarImageRepository;
    @Autowired
    DozerBeanMapper dozerBeanMapper;


    @Override
    public List<WebinarDto> getAllList() {
        List<Webinars> webinars = webinarsRepository.findAll();
        return webinars.stream().map(allList -> dozerBeanMapper.map(allList, WebinarDto.class)
        ).collect(Collectors.toList());
    }

    @Override
    public WebinarDto createWebinar(WebinarDto webinarDto, MultipartFile file) throws IOException {


        WebinarsImageDto imageDto = new WebinarsImageDto();
        WebinarsImage image = dozerBeanMapper.map(imageDto, WebinarsImage.class);
        image.setFileName(file.getOriginalFilename());
        image.setData(file.getBytes());
        webinarImageRepository.save(image);

        // entity
        Webinars webinars = dozerBeanMapper.map(webinarDto, Webinars.class);
        webinars.setId(webinars.getId());
        webinars.setTitle(webinarDto.getTitle());
        webinars.setSubTitle(webinarDto.getSubTitle());
        webinars.setText(webinarDto.getText());
        webinars.setDate(LocalDate.now());
        webinars.setImage(image);
        Webinars entity = webinarsRepository.save(webinars);
        return dozerBeanMapper.map(entity, WebinarDto.class);


    }

    @Override
    public String deleteWebinar(int id) {
        try {
            webinarsRepository.deleteById(id);
        } catch (BannerNotFoundException e) {
            return (e.getMessage());
        }
        return "Deleted Successfully";
    }

    @Override
    public WebinarDto updateWebinarDetails(int id, WebinarDto webinarDto, MultipartFile file) throws IOException {
        Webinars webinars = webinarsRepository.findById(id).get();


        if (!(file == null)) {

            WebinarsImage image = webinars.getImage();
            image.setFileName(file.getOriginalFilename());
            image.setData(file.getBytes());
            webinarImageRepository.save(image);
        }
        webinars.setTitle(webinarDto.getTitle());
        webinars.setSubTitle(webinarDto.getSubTitle());
        webinars.setText(webinarDto.getText());
        webinars.setDate(LocalDate.now());

        webinarsRepository.save(webinars);
        return dozerBeanMapper.map(webinars, WebinarDto.class);

    }


    @Override
    public WebinarDto getWebinarById(int id) {

        Webinars webinars = webinarsRepository.findById(id)
                .orElseThrow(() -> new BannerNotFoundException(id));
        WebinarDto dto = dozerBeanMapper.map(webinars, WebinarDto.class);

        return dto;
    }
}

