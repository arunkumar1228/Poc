package com.web.Home.banner.service;


import com.web.Home.banner.dto.BannerDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface BannerService {
    List<BannerDto> getAllList();

    BannerDto createBanner(BannerDto bannerDto, MultipartFile file) throws IOException;

    String deleteBanner(int id);

    BannerDto updateBannerDetails(int id, BannerDto bannerDto, MultipartFile file);

    BannerDto getBannerById(int id) ;

}
