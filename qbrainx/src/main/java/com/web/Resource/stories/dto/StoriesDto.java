package com.web.resource.stories.dto;




import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Lob;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StoriesDto {
    private int id;
    private String Title;
    private String subTitle;
    private String Text;
    private String date;
    private String fileName;
    @Lob
    private byte[] data;
}
