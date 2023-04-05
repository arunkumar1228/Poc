package com.web.Home.weare.repository;

import com.web.Home.weare.entity.FeedbackEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedBackRepository extends JpaRepository<FeedbackEntity,Integer> {
}
