package com.web.about.leaderShip.repository;






import com.web.about.leaderShip.entity.LeaderShip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaderShipRepository extends JpaRepository<LeaderShip, Integer> {
}
