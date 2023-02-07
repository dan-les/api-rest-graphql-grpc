package com.lesniewicz.api.repository;

import com.lesniewicz.api.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Long> {
}
