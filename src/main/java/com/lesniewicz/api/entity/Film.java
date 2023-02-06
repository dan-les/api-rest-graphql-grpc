package com.lesniewicz.api.entity;

import javax.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;


@Entity
@Getter
@Setter
@Data
public class Film {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer filmId;

    @Column(nullable = false, length = 128)
    private String title;

    @Column(name = "\"description\"", columnDefinition = "longtext")
    private String description;

    private Integer releaseYear;

    @Column(nullable = false)
    private Integer rentalDuration;

    @Column(nullable = false, precision = 6, scale = 2)
    private BigDecimal rentalRate;

    @Column
    private Integer length;

    @Column(nullable = false, precision = 7, scale = 2)
    private BigDecimal replacementCost;

    @Column
    private String rating;

    @Column
    private String specialFeatures;

    @Column(nullable = false)
    private OffsetDateTime lastUpdate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "language_id", nullable = false)
    private Language language;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "original_language_id")
    private Language originalLanguage;

    //    @OneToMany(mappedBy = "film")
//    private Set<FilmActor> filmFilmActors;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "film_actor",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id"))
    private Set<Actor> actors = new HashSet<>();

    //    @OneToMany(mappedBy = "film")
//    private Set<FilmCategory> filmFilmCategorys;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "film_category",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();


    @OneToMany(mappedBy = "film")
    private Set<Inventory> filmInventorys;

}
