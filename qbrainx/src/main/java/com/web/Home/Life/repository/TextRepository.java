package com.web.home.life.repository;



import com.web.home.life.entity.TextEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TextRepository extends JpaRepository<TextEntity,Integer> {

}
