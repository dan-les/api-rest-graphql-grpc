package com.lesniewicz.api.repository;

import com.lesniewicz.api.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<Rental, Long> {
}
