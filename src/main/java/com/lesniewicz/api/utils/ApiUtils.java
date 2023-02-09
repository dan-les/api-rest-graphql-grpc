package com.lesniewicz.api.utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class ApiUtils {

    public LocalDate retrieveLocalDate(String lastUpdate) {
        return StringUtils.isBlank(lastUpdate) ? null : LocalDate.parse(lastUpdate);
    }

}
