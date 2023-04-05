package com.web.Home.WeOffers.entity;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "weOffers_image_details")
public class NewsImageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String imageName;


    @Lob
    private byte[] data;

}