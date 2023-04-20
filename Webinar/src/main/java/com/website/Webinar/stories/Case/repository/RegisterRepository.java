package com.website.Webinar.stories.Case.repository;





import com.website.Webinar.stories.Case.entity.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterRepository extends JpaRepository<Register, Integer> {
}
