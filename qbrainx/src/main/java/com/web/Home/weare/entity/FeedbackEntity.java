package com.web.Home.weare.entity;


import com.web.utils.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "weAre_details")
@Getter
@Setter
public class FeedbackEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String description;

    private String link;

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name = "image",referencedColumnName = "id")
    private FeedBackImageEntity feedBackImage;
}
