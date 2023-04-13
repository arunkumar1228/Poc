package com.web.home.life.service;





import com.web.home.life.dto.TextDto;


import java.util.List;



public interface TextService {
    List<TextDto> getAllList();

    TextDto createText(TextDto textDto);

    String deleteExistingText(int id);

    TextDto updateTextDetails(int id,TextDto textDto);
    TextDto  getTextById(int id);




}
