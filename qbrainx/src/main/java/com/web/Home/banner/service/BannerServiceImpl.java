package com.web.Home.banner.service;


import com.web.Exception.BannerNotFoundException;
import com.web.Exception.ServiceException;
import com.web.Home.Life.dto.TextDto;
import com.web.Home.Life.entity.TextEntity;
import com.web.Home.banner.dto.BannerDto;
import com.web.Home.banner.dto.ImageDto;
import com.web.Home.banner.entity.BannerEntity;
import com.web.Home.banner.entity.BannerImageEntity;
import com.web.Home.banner.repository.BannerImageRepository;
import com.web.Home.banner.repository.BannerRepository;
import com.web.Home.weare.dto.FeedBackDto;
import com.web.Home.weare.entity.FeedbackEntity;
import lombok.extern.slf4j.Slf4j;
import org.dozer.DozerBeanMapper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


import javax.management.ServiceNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

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
        ).collect(Collectors.toList());    }

    @Override
    public BannerDto createBanner(BannerDto bannerDto, MultipartFile file) throws IOException {
        ImageDto imagedto = new ImageDto();
        BannerImageEntity image = dozerBeanMapper.map(imagedto, BannerImageEntity.class);
        image.setFileName(file.getOriginalFilename());
        image.setData(file.getBytes());
        bannerImageRepository.save(image);
        BannerEntity bannerEntity = dozerBeanMapper.map(bannerDto, BannerEntity.class);
        bannerEntity.setId(bannerDto.getId());
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
    public String deleteBanner(int id)   {
        try {
            bannerRepository.deleteById(id);
        } catch ( BannerNotFoundException e) {
            return (e.getMessage());
        }
        return "Deleted Successfully";
    }

    @Override
    public BannerDto updateBannerDetails(int id, BannerDto bannerDto, MultipartFile file) {
        Optional<BannerEntity> banner = bannerRepository.findById(id);
        BannerEntity bannerEntity = banner.get();

        if (banner.isPresent()) {

            if (file == null) {
                bannerEntity.setBannerTitle(bannerDto.getBannerTitle());
                bannerEntity.setBannerSubTitle(bannerDto.getBannerSubTitle());
                bannerEntity.setBannerCallOfAction(bannerDto.getBannerCallOfAction());
                bannerEntity.setLink(bannerDto.getLink());
                bannerRepository.save(bannerEntity);
            } else {
                BannerImageEntity image = banner.get().getImage();
                image.setFileName(file.getOriginalFilename());
                image.setData(file.toString().getBytes());
                bannerImageRepository.save(image);
            }
        }
        bannerRepository.save(bannerEntity);
        BannerDto dto = dozerBeanMapper.map(bannerEntity, BannerDto.class);
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

