package com.web.resource.webinar.entity;


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
@Table(name = "Webinars_details")
public class Webinars extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String Title;
    private String subTitle;
    @Column(columnDefinition = "VARCHAR(1000000)")
    private String Text;
    private LocalDate Date;


    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name = "image",referencedColumnName = "id")
    private WebinarsImage image;
}
