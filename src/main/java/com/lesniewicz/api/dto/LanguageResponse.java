package com.lesniewicz.api.dto;

import java.time.LocalDate;

public record LanguageResponse(Long languageId,
                               String name,
                               LocalDate lastUpdate) {
}