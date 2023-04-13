package com.web.home.life.controller;

import com.web.home.life.dto.TextDto;
import com.web.home.life.service.TextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(value = "v1/lifeAtQb")
public class lifeAtQbController {


    @Autowired
    TextService textService;

    @GetMapping("/getAll")
    public ResponseEntity<List<TextDto>> allTextList() {
        List<TextDto> list = textService.getAllList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @PostMapping("/create" )
    public ResponseEntity<TextDto> uploadImage(@RequestBody TextDto textDto) {
        return new ResponseEntity<>(textService.createText(textDto), HttpStatus.OK);
    }

    @DeleteMapping("/deleteById")
    public String deleteTextById(@RequestParam int id)  {
        return textService.deleteExistingText(id);
    }

    @GetMapping("/getById")
    public TextDto getText(@RequestParam int id)  {
        return textService.getTextById(id);
    }

    @PutMapping(value = "/updateDetailsById")
    public ResponseEntity<TextDto> uploadImage(@RequestParam int id,TextDto textDto)  {
        return new ResponseEntity<>(textService.updateTextDetails(id, textDto ), HttpStatus.OK);
    }
}