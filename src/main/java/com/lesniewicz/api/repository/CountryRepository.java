package com.lesniewicz.api.repository;

import com.lesniewicz.api.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer> {
}
