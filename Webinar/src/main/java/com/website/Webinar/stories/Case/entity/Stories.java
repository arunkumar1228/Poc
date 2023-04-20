package com.website.Webinar.stories.Case.entity;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "Stories_details")
public class Stories  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "stories_id")
    private int id;
    private String title;
    private String category;
    @Column(columnDefinition = "VARCHAR(1000000)")
    private String Text;
    private LocalDate Date;

    private String readTime;


    private String fileName;
    @Lob
    private byte[] data;

    @JsonIgnoreProperties
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_register_id")
    private Register register;

}
