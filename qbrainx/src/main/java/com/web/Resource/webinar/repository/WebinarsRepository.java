package com.web.resource.webinar.repository;



import com.web.resource.webinar.entity.Webinars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WebinarsRepository extends JpaRepository<Webinars, Integer> {
}
