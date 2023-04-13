package com.web.about.qnews.entity;



import com.web.utils.BaseEntity;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "qnews_details")
public class Qnews extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String Title;
    private String subTitle;
    @Column(columnDefinition = "VARCHAR(1000000)")
    private String Text;
    private LocalDate Date;

    private String fileName;

    @Lob
    private byte[] data;

}
