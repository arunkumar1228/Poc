package com.web.home.life.dto;


import lombok.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TextDto {

    private int id;

    private String textTitle;

    private String textSubTitle;

    private String established;

    private String project;
    private String client;


}
