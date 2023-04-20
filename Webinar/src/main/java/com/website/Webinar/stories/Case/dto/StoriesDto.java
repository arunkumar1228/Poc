package com.website.Webinar.stories.Case.dto;




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
public class StoriesDto {
    private int id;
    private String title;
    private String category;
    @Column(columnDefinition = "VARCHAR(1000000)")
    private String text;
    private String date;

    private String readTime;
    private String fileName;
    @Lob
    private byte[] data;
}
