package com.web.about.qnews.dto;




import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Lob;
import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QnewsDto {
    private int id;

    private String Title;
    private String subTitle;
    @Column(columnDefinition = "VARCHAR(1000000)")
    private String Text;
    private String Date;

    private String fileName;

    @Lob
    private byte[] data;
}
