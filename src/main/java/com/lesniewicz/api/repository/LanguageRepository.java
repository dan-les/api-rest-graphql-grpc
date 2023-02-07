package com.lesniewicz.api.repository;


import com.lesniewicz.api.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;


public interface LanguageRepository extends JpaRepository<Language, Long> {

    @Query("SELECT "
            + "DISTINCT (language) from Language language "
            + "WHERE "
            + "(:name IS NULL OR language.name = :name) AND "
            + "(:lastUpdate IS NULL OR language.lastUpdate = :lastUpdate) ")
    List<Language> findLanguagesWithFilters(String name, LocalDate lastUpdate);

}
