package com.web.about.leaderShip.service;






import com.web.about.leaderShip.dto.LeaderShipDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface LeaderShipService {
    List<LeaderShipDto> getAllList();

    LeaderShipDto createLeaderShip(LeaderShipDto leaderShipDto, MultipartFile file) throws IOException;

    String deleteLeaderShipById(int id);


    LeaderShipDto updateLeaderShipDetails(int id, LeaderShipDto leaderShipDto, MultipartFile file) throws IOException;

    LeaderShipDto getLeaderShipById(int id) ;

}
