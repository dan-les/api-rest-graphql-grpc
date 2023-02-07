package com.lesniewicz.api.repository;

import com.lesniewicz.api.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CityRepository extends JpaRepository<City, Long> {
}
