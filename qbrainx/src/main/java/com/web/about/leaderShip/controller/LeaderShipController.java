package com.web.about.leaderShip.controller;


import com.web.about.leaderShip.dto.LeaderShipDto;
import com.web.about.leaderShip.service.LeaderShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "v1/LeaderShip")
public class LeaderShipController {
    @Autowired
    LeaderShipService leaderShipService;

    @GetMapping("/getAll")
    public ResponseEntity<List<LeaderShipDto>> allLeaderShipList() {
        List<LeaderShipDto> list = leaderShipService.getAllList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping(value = "/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public LeaderShipDto createLeaderShip(@RequestParam("file") MultipartFile file, LeaderShipDto leaderShipDto) throws IOException {

        return leaderShipService.createLeaderShip(leaderShipDto, file);


    }

    @DeleteMapping("/deleteById")
    public String deleteLeaderShipById(@RequestParam int id) {
        return leaderShipService.deleteLeaderShipById(id);
    }

    @GetMapping("/getById")
    public LeaderShipDto getStoriesById(@RequestParam int id) {
        return leaderShipService.getLeaderShipById(id);
    }


    @PutMapping(value = "/updateDetailsById", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<LeaderShipDto> updateLeaderShipDetails(@RequestParam int id, @RequestParam(value = "file", required = false) MultipartFile file, LeaderShipDto leaderShipDto) throws IOException {
        return new ResponseEntity<>(leaderShipService.updateLeaderShipDetails(id, leaderShipDto, file), HttpStatus.OK);
    }


}
