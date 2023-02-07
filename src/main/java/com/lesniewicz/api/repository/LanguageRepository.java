package com.lesniewicz.api.repository;


import com.lesniewicz.api.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LanguageRepository extends JpaRepository<Language, Long> {
}
