package com.web.resource.webinar.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WebinarDto  {
    private int id;
    private String Title;
    private String SubTitle;
    @Column(length = 10000)
    private String Text;
    private String date;

    private WebinarsImageDto image;
}
