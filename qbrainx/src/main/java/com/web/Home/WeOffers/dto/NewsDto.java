package com.web.home.weOffers.dto;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NewsDto {
    private int id;
    private String Title;
    private String description;

    private String link;


    private NewsImageDto newsImage;
}
