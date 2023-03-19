package com.lesniewicz.api.repository;

import com.lesniewicz.api.entity.Film;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FilmRepository extends JpaRepository<Film, Long> {

    @NotNull
    @Override
    @Query(value = "SELECT distinct f" +
            " FROM Film f " +
            " LEFT JOIN FETCH f.actors ")
    List<Film> findAll();
}
