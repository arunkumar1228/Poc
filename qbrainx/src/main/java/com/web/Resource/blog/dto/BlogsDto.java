package com.web.resource.blog.dto;




import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BlogsDto {
    private int id;
    private String Title;
    private String SubTitle;
    private String Text;
    private String date;

    private BlogsImageDto image;
}
