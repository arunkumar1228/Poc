package com.web.Admin.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "admin_details")
public class AdminEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;


}
