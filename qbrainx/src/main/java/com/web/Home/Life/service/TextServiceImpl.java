package com.web.Home.Life.service;

import com.web.Exception.BannerNotFoundException;
import com.web.Home.Life.dto.TextDto;
import com.web.Home.Life.entity.TextEntity;
import com.web.Home.Life.repository.TextRepository;

import com.web.Home.banner.dto.BannerDto;
import com.web.Home.banner.entity.BannerEntity;
import org.dozer.DozerBeanMapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.io.IOException;
import java.util.List;
import java.util.Optional;
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

        textEntity.setId(textDto.getId());
        textEntity.setTextTitle(textDto.getTextTitle());
        textEntity.setTextTitle(textDto.getTextTitle());
        textEntity.setEstablished(textDto.getEstablished());
        textEntity.setProject(textDto.getProject());
        textEntity.setClient(textDto.getProject());


        TextEntity text = textRepository.save(textEntity);
        TextDto dto = dozerBeanMapper.map(text, TextDto.class);

        return dto;
    }

    @Override
    public String deleteExistingText(int id) {
        try {
            textRepository.deleteById(id);
        } catch ( BannerNotFoundException e) {
            return (e.getMessage());
        }
        return "Deleted Successfully";
    }



    @Override
    public TextDto updateTextDetails(int id, TextDto textDto) {
        Optional<TextEntity> text = textRepository.findById(id);
        TextEntity textEntity = text.get();

        if (text.isPresent()) {
            textEntity.setId(textDto.getId());
            textEntity.setTextTitle(textDto.getTextTitle());
            textEntity.setTextSubTitle(textDto.getTextSubTitle());
            textEntity.setEstablished(textDto.getEstablished());
            textEntity.setProject(textDto.getProject());
            textEntity.setClient(textDto.getClient());
            textRepository.save(textEntity);


        }
        TextDto dto = dozerBeanMapper.map(textEntity, TextDto.class);

        return dto;
    }

    @Override
    public TextDto getTextById(int id) {
        TextEntity textEntity = textRepository.findById(id)
                .orElseThrow(() -> new BannerNotFoundException(id));
        TextDto textDto = dozerBeanMapper.map(textEntity, TextDto.class);

        return textDto;
    }
}



