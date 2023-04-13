package com.web.home.weare.dto;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;




@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FeedBackDto {


    private int id;
    private String description;

    private String link;
   private FeedBackImageDto feedBackImage;
}
