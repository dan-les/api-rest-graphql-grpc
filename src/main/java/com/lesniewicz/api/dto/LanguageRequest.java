package com.lesniewicz.api.dto;

import java.time.LocalDate;

public record LanguageRequest(String name,
                              LocalDate lastUpdate) {
}