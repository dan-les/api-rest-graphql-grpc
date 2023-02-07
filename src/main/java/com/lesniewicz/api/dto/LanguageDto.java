package com.lesniewicz.api.dto;

import java.time.LocalDate;

public record LanguageDto(Long languageId,
                          String name,
                          LocalDate lastUpdate) {
}