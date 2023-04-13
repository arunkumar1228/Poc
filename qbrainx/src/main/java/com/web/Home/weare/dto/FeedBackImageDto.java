package com.web.home.weare.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.Lob;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FeedBackImageDto {

    private int id;
    private String fileName;
    @Lob
    private byte[] data;

}
