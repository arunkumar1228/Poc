package com.web.home.banner.service;


import com.web.exception.BannerNotFoundException;
import com.web.home.banner.dto.BannerDto;
import com.web.home.banner.dto.ImageDto;
import com.web.home.banner.entity.BannerEntity;
import com.web.home.banner.entity.BannerImageEntity;
import com.web.home.banner.repository.BannerImageRepository;
import com.web.home.banner.repository.BannerRepository;
import lombok.extern.slf4j.Slf4j;
import org.dozer.DozerBeanMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.List;

import java.util.stream.Collectors;

@Service
@Slf4j
public class BannerServiceImpl implements BannerService {

    @Autowired
    BannerRepository bannerRepository;
    @Autowired
    BannerImageRepository bannerImageRepository;
    @Autowired
    DozerBeanMapper dozerBeanMapper;

    Logger logger = LoggerFactory.getLogger(BannerServiceImpl.class);

    @Override
    public List<BannerDto> getAllList() {
        List<BannerEntity> bannerEntities = bannerRepository.findAll();
        return bannerEntities.stream().map(allList -> dozerBeanMapper.map(allList, BannerDto.class)
        ).collect(Collectors.toList());
    }

    @Override
    public BannerDto createBanner(BannerDto bannerDto, MultipartFile file) throws IOException {
        ImageDto imagedto = new ImageDto();
        BannerImageEntity image = dozerBeanMapper.map(imagedto, BannerImageEntity.class);
        image.setFileName(file.getOriginalFilename());
        image.setData(file.getBytes());
        bannerImageRepository.save(image);
        BannerEntity bannerEntity = dozerBeanMapper.map(bannerDto, BannerEntity.class);
        bannerEntity.setBannerTitle(bannerDto.getBannerTitle());
        bannerEntity.setBannerSubTitle(bannerDto.getBannerSubTitle());
        bannerEntity.setBannerCallOfAction(bannerDto.getBannerCallOfAction());
        bannerEntity.setLink(bannerDto.getLink());
        bannerEntity.setImage(image);
        BannerEntity entity = bannerRepository.save(bannerEntity);
        BannerDto dto = dozerBeanMapper.map(entity, BannerDto.class);
        return dto;

    }

    @Override
    public String deleteBanner(int id) {
        try {
            bannerRepository.deleteById(id);
        } catch (BannerNotFoundException e) {
            return (e.getMessage());
        }
        return "Deleted Successfully";
    }

    @Override
    public BannerDto updateBannerDetails(int id, BannerDto bannerDto, MultipartFile file) throws IOException {
        BannerEntity banner = bannerRepository.findById(id).get();

        if (!(file == null)) {
            BannerImageEntity image = banner.getImage();
            image.setFileName(file.getOriginalFilename());
            image.setData(file.getBytes());
            bannerImageRepository.save(image);
        }
        banner.setBannerTitle(bannerDto.getBannerTitle());
        banner.setBannerSubTitle(bannerDto.getBannerSubTitle());
        banner.setBannerCallOfAction(bannerDto.getBannerCallOfAction());
        banner.setLink(bannerDto.getLink());
        banner.setImage(banner.getImage());


        bannerRepository.save(banner);
        BannerDto dto = dozerBeanMapper.map(banner, BannerDto.class);
        return dto;
    }


    @Override
    public BannerDto getBannerById(int id) {

        BannerEntity bannerEntity = bannerRepository.findById(id)
                .orElseThrow(() -> new BannerNotFoundException(id));
        BannerDto dto = dozerBeanMapper.map(bannerEntity, BannerDto.class);

        return dto;
    }
}

