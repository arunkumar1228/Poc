package com.web.Home.banner.repository;



import com.web.Home.banner.entity.BannerImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BannerImageRepository extends JpaRepository<BannerImageEntity,Integer> {


}
