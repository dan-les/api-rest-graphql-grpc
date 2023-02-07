package com.lesniewicz.api.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.OffsetDateTime;
import java.util.Set;


@Entity
@Getter
@Setter
public class Country {

    @Id
    @Column(nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long countryId;

    @Column(nullable = false, length = 50)
    private String country;

    @Column(nullable = false)
    private OffsetDateTime lastUpdate;

    @OneToMany(mappedBy = "country")
    private Set<City> countryCitys;

}
