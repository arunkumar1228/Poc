package com.website.Webinar.stories.Case.entity;



import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Register  {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "register_id")
    private int id;

    private String name;

    private String emailId;

    private String companyName;

    @OneToOne(mappedBy = "register")
    private Stories stories;


}
