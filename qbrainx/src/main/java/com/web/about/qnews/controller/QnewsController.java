package com.web.about.qnews.controller;


import com.web.about.qnews.dto.QnewsDto;
import com.web.about.qnews.service.QnewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping(value = "v1/Qnews")
public class QnewsController {
    @Autowired
    QnewsService qnewsService;

    @GetMapping("/getAll")
    public ResponseEntity<List<QnewsDto>> allLeaderShipList() {
        List<QnewsDto> list = qnewsService.getAllList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping(value = "/create", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public QnewsDto createQnews(@RequestParam("file") MultipartFile file, QnewsDto qnewsDto) throws IOException {

        return qnewsService.createQnews(qnewsDto, file);


    }

    @DeleteMapping("/deleteById")
    public String deleteQnewsById(@RequestParam int id) {
        return qnewsService.deleteQnewsById(id);
    }

    @GetMapping("/getById")
    public QnewsDto getQnewsById(@RequestParam int id) {
        return qnewsService.getQnewsById(id);
    }


    @PutMapping(value = "/updateDetailsById", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<QnewsDto> updateQnewsDetails(@RequestParam int id, @RequestParam(value = "file", required = false) MultipartFile file, QnewsDto qnewsDto) throws IOException {
        return new ResponseEntity<>(qnewsService.updateQnewsDetails(id, qnewsDto, file), HttpStatus.OK);
    }


}
