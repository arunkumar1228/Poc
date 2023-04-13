package com.web.resource.stories.repository;




import com.web.resource.stories.entity.Stories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoriesRepository extends JpaRepository<Stories, Integer> {
}
