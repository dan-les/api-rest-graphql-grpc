package com.lesniewicz.api.dto;


import java.time.LocalDate;

public record CustomerDto(Long customerId,
                          String firstName,
                          String lastName,
                          String email,
                          Boolean active,
                          LocalDate createDate,
                          LocalDate lastUpdate

) {
}