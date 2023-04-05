package com.web.Home.Life.repository;



import com.web.Home.Life.entity.TextEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TextRepository extends JpaRepository<TextEntity,Integer> {

}
