package com.web.about.qnews.service;


import com.web.about.qnews.dto.QnewsDto;

import com.web.about.qnews.entity.Qnews;
import com.web.about.qnews.repository.QnewsRepository;
import com.web.exception.BannerNotFoundException;
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
public class QnewsServiceImpl implements QnewsService {

    @Autowired
    QnewsRepository qnewsRepository;
    @Autowired
    DozerBeanMapper dozerBeanMapper;


    @Override
    public List<QnewsDto> getAllList() {
        List<Qnews> webinars = qnewsRepository.findAll();
        return webinars.stream().map(allList -> dozerBeanMapper.map(allList, QnewsDto.class)
        ).collect(Collectors.toList());
    }

    @Override
    public QnewsDto createQnews(QnewsDto qnewsDto, MultipartFile file) throws IOException {


        // entity
        Qnews qnews = dozerBeanMapper.map(qnewsDto, Qnews.class);
        qnews.setTitle(qnewsDto.getTitle());
        qnews.setSubTitle(qnewsDto.getSubTitle());
        qnews.setDate(LocalDate.now());
        qnews.setText(qnewsDto.getText());
        qnews.setFileName(file.getOriginalFilename());
        qnews.setData(file.getBytes());

        Qnews entity = qnewsRepository.save(qnews);
        return dozerBeanMapper.map(entity, QnewsDto.class);


    }

    @Override
    public String deleteQnewsById(int id) {
        try {
            qnewsRepository.deleteById(id);
        } catch (BannerNotFoundException e) {
            return (e.getMessage());
        }
        return "Deleted Successfully";
    }

    @Override
    public QnewsDto updateQnewsDetails(int id, QnewsDto qnewsDto, MultipartFile file) throws IOException {
        Qnews qnews = qnewsRepository.findById(id).get();


        if (!(file == null)) {

            qnews.setFileName(file.getOriginalFilename());
            qnews.setData(file.getBytes());
        }
        qnews.setTitle(qnewsDto.getTitle());
        qnews.setSubTitle(qnewsDto.getSubTitle());
        qnews.setDate(LocalDate.now());
        qnews.setText(qnewsDto.getText());

        qnewsRepository.save(qnews);
        return dozerBeanMapper.map(qnews, QnewsDto.class);

    }


    @Override
    public QnewsDto getQnewsById(int id) {

        Qnews Qnews = qnewsRepository.findById(id)
                .orElseThrow(() -> new BannerNotFoundException(id));
        return dozerBeanMapper.map(Qnews, QnewsDto.class);

    }
}

