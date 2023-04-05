package com.web.utils;

import lombok.Data;
import lombok.Generated;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;


@MappedSuperclass
@Data
@EntityListeners({AuditingEntityListener.class})
public class BaseEntity implements Serializable {



    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    @PostRemove
    protected  void onDelete(){
        this.deletedAt=LocalDateTime.now();
    }

    @PostUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }
}
