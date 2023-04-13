package com.web.home.weare.repository;


import com.web.home.weare.entity.FeedBackImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedBackImageRepository extends JpaRepository<FeedBackImageEntity,Integer> {
}
