package com.web.Home.WeOffers.repository;


import com.web.Home.WeOffers.entity.NewsImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsImageRepository extends JpaRepository<NewsImageEntity,Integer> {
}
