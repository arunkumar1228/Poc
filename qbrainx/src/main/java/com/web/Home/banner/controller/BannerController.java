package com.web.home.banner.controller;


import com.web.home.banner.dto.BannerDto;
import com.web.home.banner.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "v1/banner")
public class BannerController {
    @Autowired
    BannerService bannerService;

    @GetMapping("/getAllBanners")
    public ResponseEntity<List<BannerDto>> allBannerList() {
        List<BannerDto> list = bannerService.getAllList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping(value = "/createBanner", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file, BannerDto bannerdto) {
        try {
            bannerService.createBanner(bannerdto, file);
            return ResponseEntity.ok().body("Banner saved successfully.");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while saving addresses.");
        }

    }

    @DeleteMapping("/deleteBannerById")
    public  String deleteBannerById(@RequestParam int id)   {
        return bannerService.deleteBanner(id);
    }

    @GetMapping("/getBannerById")
    public BannerDto getBanner(@RequestParam int id)  {
       return bannerService.getBannerById(id);
    }


    @PutMapping(value = "/updateBannerDetailsById", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<BannerDto> updateImage(@RequestParam int id,@RequestParam(value = "file", required = false) MultipartFile file, BannerDto bannerdto) throws IOException {
        return new ResponseEntity<>(bannerService.updateBannerDetails(id,bannerdto, file), HttpStatus.OK);
    }


}
