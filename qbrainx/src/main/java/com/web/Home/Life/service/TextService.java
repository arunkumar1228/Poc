package com.web.Home.Life.service;





import com.web.Home.Life.dto.TextDto;


import java.util.List;



public interface TextService {
    List<TextDto> getAllList();

    TextDto createText(TextDto textDto);

    String deleteExistingText(int id);

    TextDto updateTextDetails(int id,TextDto textDto);
    TextDto  getTextById(int id);




}
