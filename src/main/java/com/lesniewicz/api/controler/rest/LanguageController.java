package com.lesniewicz.api.controler.rest;


import com.lesniewicz.api.dto.LanguageDto;
import com.lesniewicz.api.service.LanguageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/rest", produces = "application/json")
public class LanguageController {
    private final LanguageService languageService;

    @GetMapping("/language")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<LanguageDto> getAllLanguages() {
        // TODO: 07.02.2023 Add params
        return languageService.getAllLanguagesWithFilters(null, null);
    }

}
