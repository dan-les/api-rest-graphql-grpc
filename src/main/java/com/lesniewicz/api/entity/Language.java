package com.lesniewicz.api.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.Set;


@Entity
@Getter
@Setter
public class Language {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long languageId;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false)
    private OffsetDateTime lastUpdate;

    @OneToMany(mappedBy = "language")
    private Set<Film> languageFilms;

    @OneToMany(mappedBy = "originalLanguage")
    private Set<Film> originalLanguageFilms;

}
