package com.web.home.banner.entity;



import com.web.utils.BaseEntity;
import lombok.*;


import javax.persistence.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "banner_details")
public class BannerEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String bannerTitle;
    private String bannerSubTitle;
    private String bannerCallOfAction;
    private String link;


    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name = "image",referencedColumnName = "id")
    private BannerImageEntity image;
}
