package com.website.Webinar.stories.Case.repository;





import com.website.Webinar.stories.Case.entity.Stories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoriesRepository extends JpaRepository<Stories, Integer> {
}
