package com.web.resource.webinar.repository;



import com.web.resource.webinar.entity.WebinarsImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebinarImageRepository extends JpaRepository<WebinarsImage,Integer> {


}
