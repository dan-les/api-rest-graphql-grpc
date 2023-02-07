package com.lesniewicz.api.dto;

import java.time.OffsetDateTime;

public record LanguageDto(Long languageId,
                          String name,
                          OffsetDateTime lastUpdate) {
}