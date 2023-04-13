package com.web.about.leaderShip.service;


import com.web.about.leaderShip.dto.LeaderShipDto;
import com.web.about.leaderShip.repository.LeaderShipRepository;
import com.web.exception.BannerNotFoundException;
import com.web.about.leaderShip.entity.LeaderShip;
import lombok.extern.slf4j.Slf4j;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class LeaderShipServiceImpl implements LeaderShipService {

    @Autowired
    LeaderShipRepository leaderShipRepository;
    @Autowired
    DozerBeanMapper dozerBeanMapper;


    @Override
    public List<LeaderShipDto> getAllList() {
        List<LeaderShip> webinars = leaderShipRepository.findAll();
        return webinars.stream().map(allList -> dozerBeanMapper.map(allList, LeaderShipDto.class)
        ).collect(Collectors.toList());
    }

    @Override
    public LeaderShipDto createLeaderShip(LeaderShipDto leaderShipDto, MultipartFile file) throws IOException {


        // entity
        LeaderShip LeaderShip = dozerBeanMapper.map(leaderShipDto, LeaderShip.class);
        LeaderShip.setName(leaderShipDto.getName());
        LeaderShip.setJobTitle(leaderShipDto.getJobTitle());
        LeaderShip.setLink(leaderShipDto.getLink());
        LeaderShip.setFileName(file.getOriginalFilename());
        LeaderShip.setData(file.getBytes());

        LeaderShip entity = leaderShipRepository.save(LeaderShip);
        return dozerBeanMapper.map(entity, LeaderShipDto.class);


    }

    @Override
    public String deleteLeaderShipById(int id) {
        try {
            leaderShipRepository.deleteById(id);
        }
        catch (BannerNotFoundException e) {
            return (e.getMessage());
        }
        return "Deleted Successfully";
    }

    @Override
    public LeaderShipDto updateLeaderShipDetails(int id, LeaderShipDto leaderShipDto, MultipartFile file) throws IOException {
        LeaderShip leaderShip = leaderShipRepository.findById(id).get();


        if (!(file == null)) {

            leaderShip.setFileName(file.getOriginalFilename());
            leaderShip.setData(file.getBytes());
        }
        leaderShip.setName(leaderShipDto.getName());
        leaderShip.setJobTitle(leaderShipDto.getJobTitle());
        leaderShip.setLink(leaderShipDto.getLink());

        leaderShipRepository.save(leaderShip);
        return dozerBeanMapper.map(leaderShip, LeaderShipDto.class);

    }


    @Override
    public LeaderShipDto getLeaderShipById(int id) {

        LeaderShip LeaderShip = leaderShipRepository.findById(id)
                .orElseThrow(() -> new BannerNotFoundException(id));
        return dozerBeanMapper.map(LeaderShip, LeaderShipDto.class);

    }
}

