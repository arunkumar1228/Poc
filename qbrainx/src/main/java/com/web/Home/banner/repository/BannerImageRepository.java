package com.web.home.banner.repository;



import com.web.home.banner.entity.BannerImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BannerImageRepository extends JpaRepository<BannerImageEntity,Integer> {


}
