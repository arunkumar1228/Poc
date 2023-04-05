package com.web.Home.weare.entity;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "weAre_image_details")
public class FeedBackImageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String fileName;
    @Lob
    private byte[] data;





}