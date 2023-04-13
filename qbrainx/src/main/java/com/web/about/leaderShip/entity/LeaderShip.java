package com.web.about.leaderShip.entity;




import com.web.utils.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class LeaderShip extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String jobTitle;

    private String link;

    private String fileName;

    @Lob
    private byte[] data;

}
