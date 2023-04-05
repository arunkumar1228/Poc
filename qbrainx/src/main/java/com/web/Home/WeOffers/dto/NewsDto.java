package com.web.Home.WeOffers.dto;



import com.web.Home.WeOffers.entity.NewsImageEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.OneToOne;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class NewsDto {
    private int id;
    private String title;
    private String description;

    private String link;


    private NewsImageDto newsImage;
}
