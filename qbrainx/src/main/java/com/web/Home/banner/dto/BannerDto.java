package com.web.Home.banner.dto;




import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BannerDto {
    private int id;
    private String bannerTitle;
    private String bannerSubTitle;
    private String bannerCallOfAction;
    private String link;

    private ImageDto image;
}
