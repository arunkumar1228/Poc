package com.web.about.qnews.repository;






import com.web.about.qnews.entity.Qnews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QnewsRepository extends JpaRepository<Qnews, Integer> {
}
