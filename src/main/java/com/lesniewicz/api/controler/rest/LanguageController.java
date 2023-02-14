package com.lesniewicz.api.controler.rest;


import com.lesniewicz.api.dto.LanguageDto;
import com.lesniewicz.api.dto.LanguageRequest;
import com.lesniewicz.api.service.LanguageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/rest", produces = "application/json")
public class LanguageController {
    private final LanguageService languageService;

    @GetMapping("/language")
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public List<LanguageDto> getAllLanguages(@RequestBody LanguageRequest languageRequest) {
        log.info("REST::getAllLanguages()");
        return languageService.getAllLanguagesWithFilters(languageRequest.name(), languageRequest.lastUpdate());
    }

}
