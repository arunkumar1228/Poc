package com.web.Home.Life.entity;



import com.web.utils.BaseEntity;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "lifeAtQb_details")
public class TextEntity extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(length = 500)
	private String textTitle;

	private String textSubTitle;

	private String established;

	private String project;
	private String client;


}

