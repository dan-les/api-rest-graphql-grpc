package com.lesniewicz.api.dto;

import java.time.OffsetDateTime;

public record LanguageDto(Integer languageId,
                          String name,
                          OffsetDateTime lastUpdate) {
}