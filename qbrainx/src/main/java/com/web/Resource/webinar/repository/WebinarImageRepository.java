package com.web.Resource.webinar.repository;



import com.web.Resource.webinar.entity.WebinarsImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebinarImageRepository extends JpaRepository<WebinarsImage,Integer> {


}
