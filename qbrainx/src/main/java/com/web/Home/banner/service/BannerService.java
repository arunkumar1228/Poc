package com.web.home.banner.service;


import com.web.home.banner.dto.BannerDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface BannerService {
    List<BannerDto> getAllList();

    BannerDto createBanner(BannerDto bannerDto, MultipartFile file) throws IOException;

    String deleteBanner(int id);

    BannerDto updateBannerDetails(int id, BannerDto bannerDto, MultipartFile file) throws IOException;

    BannerDto getBannerById(int id) ;

}
