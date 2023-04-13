package com.web.home.weOffers.entity;


import com.web.utils.BaseEntity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "weOffers_details")
@Getter
@Setter
public class NewsEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String Title;
    private String description;

    private String link;



    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name = "image",referencedColumnName = "id")
    private NewsImageEntity newsImage;
}
