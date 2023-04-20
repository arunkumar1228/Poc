package com.website.Webinar.stories.Case.dto;




import com.website.Webinar.stories.Case.entity.Stories;
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
public class RegisterDto {
    private int id;
    private String name;

    private String emailId;

    private String companyName;

    private StoriesDto stories;
}
