package com.website.Webinar.stories.Case.service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.website.Webinar.exception.BannerNotFoundException;
import com.website.Webinar.stories.Case.dto.RegisterDto;
import com.website.Webinar.stories.Case.dto.StoriesDto;
import com.website.Webinar.stories.Case.entity.Register;
import com.website.Webinar.stories.Case.entity.Stories;
import com.website.Webinar.stories.Case.repository.RegisterRepository;
import com.website.Webinar.stories.Case.repository.StoriesRepository;
import lombok.extern.slf4j.Slf4j;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class StoriesServiceImpl implements StoriesService {

    @Autowired
    StoriesRepository storiesRepository;
    @Autowired
    DozerBeanMapper dozerBeanMapper;

    @Autowired
    RegisterRepository registerRepository;


    @Override
    public List<StoriesDto> getAllList() {
        List<Stories> webinars = storiesRepository.findAll();
        return webinars.stream().map(allList -> dozerBeanMapper.map(allList, StoriesDto.class)
        ).collect(Collectors.toList());
    }

    @Override
    public StoriesDto createStories(StoriesDto storiesDto, MultipartFile file) throws IOException {


        // entity
        Stories stories = dozerBeanMapper.map(storiesDto, Stories.class);

        stories.setTitle(storiesDto.getTitle());
        stories.setCategory(storiesDto.getCategory());
        stories.setReadTime(storiesDto.getReadTime());
        stories.setText(storiesDto.getText());
        stories.setDate(LocalDate.now());
        stories.setFileName(file.getOriginalFilename());
        stories.setData(file.getBytes());

        Stories entity = storiesRepository.save(stories);
        System.out.println(stories.getId());
        System.out.println(storiesDto.getId());
        return dozerBeanMapper.map(entity, StoriesDto.class);




    }

    @Override
    public ResponseEntity<byte[]> createRegister(RegisterDto registerDto) throws DocumentException {

        Register register = dozerBeanMapper.map(registerDto, Register.class);
        register.setId(registerDto.getId());
        register.setName(registerDto.getName());
        register.setEmailId(registerDto.getEmailId());
        register.setCompanyName(registerDto.getCompanyName());

        registerRepository.save(register);

        System.out.println(registerDto.getStories().getId());
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            Document document = new Document();
            PdfWriter.getInstance(document, baos);

            document.open();

            document.close();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_PDF);
            headers.setContentDispositionFormData("attachment", "blog.pdf");
            headers.setContentLength(baos.size());
            return new ResponseEntity<>(baos.toByteArray(), headers, HttpStatus.OK);
        }

}

