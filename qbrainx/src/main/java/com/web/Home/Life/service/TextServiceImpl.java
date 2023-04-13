package com.web.home.life.service;

import com.web.exception.BannerNotFoundException;
import com.web.home.life.dto.TextDto;
import com.web.home.life.entity.TextEntity;
import com.web.home.life.repository.TextRepository;
import org.dozer.DozerBeanMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

import java.util.stream.Collectors;

@Service

public class TextServiceImpl implements TextService {


    @Autowired
    TextRepository textRepository;
    @Autowired
    DozerBeanMapper dozerBeanMapper;

    @Override
    public List<TextDto> getAllList() {
        List<TextEntity> textEntities = textRepository.findAll();
        return textEntities.stream().map(allList -> dozerBeanMapper.map(allList, TextDto.class)
        ).collect(Collectors.toList());
    }

    @Override
    public TextDto createText(TextDto textDto) {

        TextEntity textEntity = dozerBeanMapper.map(textDto, TextEntity.class);
        textEntity.setTextTitle(textDto.getTextTitle());
        textEntity.setTextTitle(textDto.getTextTitle());
        textEntity.setEstablished(textDto.getEstablished());
        textEntity.setProject(textDto.getProject());
        textEntity.setClient(textDto.getProject());


        TextEntity text = textRepository.save(textEntity);
        return dozerBeanMapper.map(text, TextDto.class);


    }

    @Override
    public String deleteExistingText(int id) {
        try {
            textRepository.deleteById(id);
        } catch (BannerNotFoundException e) {
            return (e.getMessage());
        }
        return "Deleted Successfully";
    }


    @Override
    public TextDto updateTextDetails(int id, TextDto textDto) {
        TextEntity text = textRepository.findById(id).get();
        text.setTextTitle(textDto.getTextTitle());
        text.setTextSubTitle(textDto.getTextSubTitle());
        text.setEstablished(textDto.getEstablished());
        text.setProject(textDto.getProject());
        text.setClient(textDto.getClient());
        textRepository.save(text);


        return dozerBeanMapper.map(text, TextDto.class);


    }

    @Override
    public TextDto getTextById(int id) {
        TextEntity textEntity = textRepository.findById(id)
                .orElseThrow(() -> new BannerNotFoundException(id));
        return dozerBeanMapper.map(textEntity, TextDto.class);

    }
}



