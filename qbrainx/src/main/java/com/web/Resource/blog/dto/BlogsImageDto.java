package com.web.resource.blog.dto;


import lombok.Data;

import javax.persistence.Lob;
@Data
public class BlogsImageDto {
    private int id;
    private String fileName;
    @Lob
    private byte[] data;
}
