package com.web.Home.WeOffers.repository;


import com.web.Home.WeOffers.entity.NewsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NewsRepository extends JpaRepository<NewsEntity,Integer> {
}
