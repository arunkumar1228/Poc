package com.web.Resource.webinar.dto;


import lombok.Data;

import javax.persistence.Lob;
@Data
public class WebinarsImageDto {
    private int id;
    private String fileName;
    @Lob
    private byte[] data;
}
