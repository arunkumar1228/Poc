package com.web.home.banner.entity;



import com.web.utils.BaseEntity;
import lombok.*;


import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "banner_image_details")
public class BannerImageEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String fileName;
    @Lob
    private byte[] data;

}
