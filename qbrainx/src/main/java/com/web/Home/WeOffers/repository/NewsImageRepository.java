package com.web.home.weOffers.repository;


import com.web.home.weOffers.entity.NewsImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsImageRepository extends JpaRepository<NewsImageEntity,Integer> {
}
