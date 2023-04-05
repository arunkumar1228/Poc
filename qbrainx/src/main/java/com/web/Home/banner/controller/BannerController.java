package com.web.Home.banner.controller;


import com.web.Home.banner.dto.BannerDto;
import com.web.Home.banner.service.BannerService;
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

    @GetMapping("/getAll")
    public ResponseEntity<List<BannerDto>> allBannerList() {
        List<BannerDto> list = bannerService.getAllList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping(value = "/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public BannerDto BannerDtoUploadImage(@RequestParam("file") MultipartFile file, BannerDto bannerdto) throws IOException {

        return bannerService.createBanner(bannerdto, file);


    }

    @DeleteMapping("/deleteById")
    public String deleteBannerById(@RequestParam int id) {
        return bannerService.deleteBanner(id);
    }

    @GetMapping("/getById")
    public BannerDto getBanner(@RequestParam int id) {
        return bannerService.getBannerById(id);
    }


    @PutMapping(value = "/updateDetailsById", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<BannerDto> updateImage(@RequestParam int id, @RequestParam(value = "file", required = false) MultipartFile file, BannerDto bannerdto) {
        return new ResponseEntity<>(bannerService.updateBannerDetails(id, bannerdto, file), HttpStatus.OK);
    }


}
